package nl.rug.ds.bpm.editor.core.configloader;

import com.mxgraph.model.mxGeometry;
import com.mxgraph.util.mxPoint;
import nl.rug.ds.bpm.editor.core.AppCore;
import nl.rug.ds.bpm.editor.diagramViews.bpmn.BPMNService;
import nl.rug.ds.bpm.editor.models.EdgeCellVariable;
import nl.rug.ds.bpm.editor.models.IConstraintHolder;
import nl.rug.ds.bpm.editor.models.graphModels.ConstrainEdgeCell;
import nl.rug.ds.bpm.editor.models.graphModels.EdgeCell;
import nl.rug.ds.bpm.editor.models.graphModels.InputCell;
import nl.rug.ds.bpm.editor.models.graphModels.SuperCell;
import nl.rug.ds.bpm.jaxb.xpdlEx.ActivityConstraint;
import nl.rug.ds.bpm.jaxb.xpdlEx.Transition;
import nl.rug.ds.bpm.jaxb.xpdlEx.XPDLConstraint;
import nl.rug.ds.bpm.jaxb.xpdlEx.XpdlEx;
import nl.rug.ds.bpm.verification.models.cpn.Variable;
import org.wfmc._2008.xpdl2.ConnectorGraphicsInfo;
import org.wfmc._2008.xpdl2.ConnectorGraphicsInfos;
import org.wfmc._2008.xpdl2.Coordinates;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

/**
 * Created by Mark Kloosterhuis.
 */
public class XPDLExMarshaller {
    XpdlEx xpdlEx;
    private BPMNService bpmnService;

    public XPDLExMarshaller() {
        bpmnService = AppCore.app.getBpmnService();
        xpdlEx = new XpdlEx();

        createVariables();
        createTransitions();
        createAcitivityConstraints();
    }

    private void createVariables() {
        for (Variable element : AppCore.app.getVariables()) {
            if (!element.isDefault())
                xpdlEx.AddVariable(element.getId(), element.getName());
        }
    }

    private void createTransitions() {
        for (EdgeCell edge : bpmnService.getEdges()) {
            Transition transition = xpdlEx.AddTransition(edge.getVisibleId());
            for (EdgeCellVariable value : edge.getVariablesValues()) {
                transition.addVariableValue(value.getVariableId(), value.getCondition(), value.getValue());
            }
        }

        for (ConstrainEdgeCell edge : bpmnService.getRelations()) {
            XPDLConstraint XPDLConstraint = new XPDLConstraint(
                    edge.getVisibleId(),
                    edge.getSource() != null ? ((SuperCell)edge.getSource()).getVisibleId() : null,
                    edge.getTarget() != null ? ((SuperCell)edge.getTarget()).getVisibleId() : null,
                    edge.getConstraint().getId()
            );
            xpdlEx.AddConstraint(XPDLConstraint);
            XPDLConstraint.setConnectorGraphicsInfos(new ConnectorGraphicsInfos());

            ConnectorGraphicsInfo gfxInfo = new ConnectorGraphicsInfo();
            mxGeometry geo = edge.getGeometry();
            if (geo.getPoints() != null) {
                for (mxPoint point : geo.getPoints()) {
                    Coordinates coords = new Coordinates();
                    coords.setXCoordinate(point.getX());
                    coords.setYCoordinate(point.getY());
                    gfxInfo.getCoordinates().add(coords);
                }
            }
            XPDLConstraint.getConnectorGraphicsInfos().getConnectorGraphicsInfo().add(gfxInfo);

            for (EdgeCellVariable value : edge.getVariablesValues()) {
                XPDLConstraint.addVariableValue(value.getVariableId(), value.getCondition(), value.getValue());
            }
        }
    }

    private void createAcitivityConstraints() {
        for (InputCell activity : bpmnService.getCells()) {
            for (IConstraintHolder constraint : activity.getConstraints()) {
                ActivityConstraint activityConstraint = new ActivityConstraint(activity.getVisibleId(), constraint.getConstraint().getId());
                for (EdgeCellVariable value : constraint.getVariablesValues()) {
                    activityConstraint.addVariableValue(value.getVariableId(), value.getCondition(), value.getValue());
                }
                xpdlEx.AddActivityConstraint(activityConstraint);
            }
        }

    }

    public void Marshall(File file) {
        try {

            JAXBContext context = JAXBContext.newInstance(XpdlEx.class);
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(xpdlEx, file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
