package nl.rug.ds.bpm.editor.core;

import com.mxgraph.model.mxGraphModel;
import nl.rug.ds.bpm.editor.GUIApplication;
import nl.rug.ds.bpm.editor.core.configloader.*;
import nl.rug.ds.bpm.editor.core.enums.ConstraintType;
import nl.rug.ds.bpm.editor.core.enums.EventType;
import nl.rug.ds.bpm.editor.core.listeners.EventSource;
import nl.rug.ds.bpm.editor.diagramViews.bpmn.BPMNService;
import nl.rug.ds.bpm.editor.models.Constraint;
import nl.rug.ds.bpm.editor.models.KripkeStructure;
import nl.rug.ds.bpm.editor.models.ModelChecker;
import nl.rug.ds.bpm.editor.models.SpecificationLanguage;
import nl.rug.ds.bpm.verification.models.cpn.Variable;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by Mark Kloosterhuis.
 */
public class AppCore {
    public static AppCore app;
    public Configloader config;
    public static GUIApplication gui;
    public Converter converter;
    private HashMap<Integer, KripkeStructure> kripkeStructures = new HashMap<>();
    private HashMap<String, Constraint> constraints = new HashMap<>();
    public List<Variable> variables = new ArrayList<>();
    public boolean modelReductionEnabled = true;
    private File xpdlsaveFile;

    public AppCore() {
        app = this;
        config = new Configloader();
        gui = new GUIApplication();
        converter = new Converter();


        EventSource.fireEvent(EventType.VARIABLES_CHANGED, null);
        EventSource.fireEvent(EventType.FILE_OPENED, null);
        EventSource.fireEvent(EventType.LOADED, null);
    }


    public List<Variable> getVariables() {
        return variables;
    }


    public ModelChecker selectedModelChecker() {
        return gui.toolbar.selectedModelChecker();
    }

    public List<SpecificationLanguage> getSpecificationLanguages() {
        return config.getSpecificationLanguages();
    }

    public HashMap<Integer, KripkeStructure> getKripkeStructures() {
        //if (kripkeStructures.isEmpty())
        //    kripkeStructures.put(0, new KripkeStructure(0, "Full model"));
        return kripkeStructures;
    }

    public KripkeStructure getSelectedKripkeStructure() {
        int index = gui.kripkeTab.getSelectedTabIndex();
        if (index >= 0) {
            return kripkeStructures.get(index);
        }
        return null;
    }

    public HashMap<String, Constraint> getConstraints() {
        return constraints;
    }

    public List<Constraint> getConstraints(ConstraintType constraintType) {
        return constraints.values()
                .parallelStream()
                .filter(c -> c.getConstraintType() == constraintType)
                .collect(Collectors.toList());

    }

    public Constraint getDefaultConstraint() {
        return selectedModelChecker().getSpecificationLanguages().stream()
                .filter(s -> s.getConstrains().size() > 0)
                .findFirst().orElse(null).getConstrains().get(0);


    }

    public BPMNService getBpmnService() {
        return gui.getGraph().bpmnService;
    }

    public void openXPDL() {
        clear();

        JFileChooser fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed(false);

        FileNameExtensionFilter vf = new FileNameExtensionFilter("Process/Variant files", "xpdl");
        fc.addChoosableFileFilter(vf);
        fc.setFileFilter(vf);


        if (fc.showOpenDialog(gui.getFrame()) == JFileChooser.APPROVE_OPTION) {
            xpdlsaveFile = fc.getSelectedFile();
            File xpdlExFile = new File(xpdlsaveFile.getAbsolutePath().replace(".xpdl", "") + ".xpdlex");
            XPDLUnmarshaller unmarshall = new XPDLUnmarshaller(xpdlsaveFile);
            if (xpdlExFile.exists()) {
                XPDLExUnmarshaller unmarshallEx = new XPDLExUnmarshaller(xpdlExFile);
            }

        }
        EventSource.fireEvent(EventType.FILE_OPENED, null);
        EventSource.fireEvent(EventType.BPMN_REDRAW, null);

    }

    public void saveXPDL() {
        if(xpdlsaveFile != null)
            saveXPDL(xpdlsaveFile);
        else
            saveXPDLAs();
    }

    public void saveXPDLAs() {
        JFileChooser fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter vf = new FileNameExtensionFilter("xpdl", "xpdl");
        fc.addChoosableFileFilter(vf);

        if (fc.showSaveDialog(gui.getFrame()) == JFileChooser.APPROVE_OPTION) {
            xpdlsaveFile = fc.getSelectedFile();
            saveXPDL(xpdlsaveFile);
        }
    }

    private void saveXPDL(File xpdlFile) {
        XPDLMarshaller marshaller = new XPDLMarshaller();
        XPDLExMarshaller marshallerEx = new XPDLExMarshaller();

        File xpdlExFile = new File(xpdlFile.getAbsolutePath().replace(".xpdl", "") + ".xpdlex");

        //XPDL
        if (xpdlFile.exists())
            marshaller.Marshall(xpdlFile);
        else {
            File f = new File(xpdlFile.getAbsoluteFile() + ".xpdl");
            marshaller.Marshall(f);
        }
        //XPDLEX
        marshallerEx.Marshall(xpdlExFile);
    }

    public  void clear()
    {
        xpdlsaveFile = null;

        gui.getGraph().clearSelection();
        ((mxGraphModel) gui.getGraph().getModel()).clear();
        //gui.getGraph().removeCells(gui.getGraph().getChildCells(gui.getGraph().getDefaultParent(), true, true));
        gui.getGraph().reset();
        gui.getBPMNView().getUndoManager().clear();


        //variables.clear();
        kripkeStructures.clear();
        //constraints.clear();
        gui.importService.clear();

        EventSource.fireEvent(EventType.VARIABLES_CHANGED, null);
        EventSource.fireEvent(EventType.BPMN_REDRAW, null);
    }

    public void importSpecificationSet() {
        JFileChooser fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed(false);

        FileNameExtensionFilter vf = new FileNameExtensionFilter("Specification XML files", "xml");
        fc.addChoosableFileFilter(vf);
        fc.setFileFilter(vf);

        if (fc.showOpenDialog(gui.getFrame()) == JFileChooser.APPROVE_OPTION) {
            File spec = fc.getSelectedFile();
            XMLSpecUnmarshaller xmlum = new XMLSpecUnmarshaller(spec);

            EventSource.fireEvent(EventType.CHECKMODEL_BUTTON_CLICK, null);
        }
        EventSource.fireEvent(EventType.FILE_OPENED, null);
        EventSource.fireEvent(EventType.CONSOLE_CONSTRAINT, null);
    }
}
