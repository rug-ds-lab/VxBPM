//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.10.05 at 01:56:55 PM CEST 
//


package org.wfmc._2008.xpdl2;

import org.w3c.dom.Element;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>Java class for PackageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PackageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.wfmc.org/2008/XPDL2.1}PackageHeader"/>
 *         &lt;element ref="{http://www.wfmc.org/2008/XPDL2.1}RedefinableHeader" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2008/XPDL2.1}ConformanceClass" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2008/XPDL2.1}Script" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2008/XPDL2.1}ExternalPackages" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2008/XPDL2.1}TypeDeclarations" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2008/XPDL2.1}Participants" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2008/XPDL2.1}Applications" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2008/XPDL2.1}DataFields" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2008/XPDL2.1}PartnerLinkTypes" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2008/XPDL2.1}Pages" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2008/XPDL2.1}Pools" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2008/XPDL2.1}MessageFlows" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2008/XPDL2.1}Associations" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2008/XPDL2.1}Artifacts" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2008/XPDL2.1}WorkflowProcesses" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2008/XPDL2.1}ExtendedAttributes" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" use="required" type="{http://www.wfmc.org/2008/XPDL2.1}Id" />
 *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Language" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="QueryLanguage" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PackageType", propOrder = {
    "packageHeader",
    "redefinableHeader",
    "conformanceClass",
    "script",
    "externalPackages",
    "typeDeclarations",
    "participants",
    "applications",
    "dataFields",
    "partnerLinkTypes",
    "pages",
    "pools",
    "messageFlows",
    "associations",
    "artifacts",
    "workflowProcesses",
    "extendedAttributes",
    "any"
})
public class PackageType {

    @XmlElement(name = "PackageHeader", required = true)
    protected PackageHeader packageHeader;
    @XmlElement(name = "RedefinableHeader")
    protected RedefinableHeader redefinableHeader;
    @XmlElement(name = "ConformanceClass")
    protected ConformanceClass conformanceClass;
    @XmlElement(name = "Script")
    protected Script script;
    @XmlElement(name = "ExternalPackages")
    protected ExternalPackages externalPackages;
    @XmlElement(name = "TypeDeclarations")
    protected TypeDeclarations typeDeclarations;
    @XmlElement(name = "Participants")
    protected Participants participants;
    @XmlElement(name = "Applications")
    protected Applications applications;
    @XmlElement(name = "DataFields")
    protected DataFields dataFields;
    @XmlElement(name = "PartnerLinkTypes")
    protected PartnerLinkTypes partnerLinkTypes;
    @XmlElement(name = "Pages")
    protected Pages pages;
    @XmlElement(name = "Pools")
    protected Pools pools;
    @XmlElement(name = "MessageFlows")
    protected MessageFlows messageFlows;
    @XmlElement(name = "Associations")
    protected Associations associations;
    @XmlElement(name = "Artifacts")
    protected Artifacts artifacts;
    @XmlElement(name = "WorkflowProcesses")
    protected WorkflowProcesses workflowProcesses;
    @XmlElement(name = "ExtendedAttributes")
    protected ExtendedAttributes extendedAttributes;
    @XmlAnyElement(lax = true)
    protected List<java.lang.Object> any;
    @XmlAttribute(name = "Id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;
    @XmlAttribute(name = "Name")
    protected String name;
    @XmlAttribute(name = "Language")
    protected String language;
    @XmlAttribute(name = "QueryLanguage")
    protected String queryLanguage;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the packageHeader property.
     * 
     * @return
     *     possible object is
     *     {@link PackageHeader }
     *     
     */
    public PackageHeader getPackageHeader() {
        return packageHeader;
    }

    /**
     * Sets the value of the packageHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link PackageHeader }
     *     
     */
    public void setPackageHeader(PackageHeader value) {
        this.packageHeader = value;
    }

    /**
     * Gets the value of the redefinableHeader property.
     * 
     * @return
     *     possible object is
     *     {@link RedefinableHeader }
     *     
     */
    public RedefinableHeader getRedefinableHeader() {
        return redefinableHeader;
    }

    /**
     * Sets the value of the redefinableHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link RedefinableHeader }
     *     
     */
    public void setRedefinableHeader(RedefinableHeader value) {
        this.redefinableHeader = value;
    }

    /**
     * Gets the value of the conformanceClass property.
     * 
     * @return
     *     possible object is
     *     {@link ConformanceClass }
     *     
     */
    public ConformanceClass getConformanceClass() {
        return conformanceClass;
    }

    /**
     * Sets the value of the conformanceClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConformanceClass }
     *     
     */
    public void setConformanceClass(ConformanceClass value) {
        this.conformanceClass = value;
    }

    /**
     * Gets the value of the script property.
     * 
     * @return
     *     possible object is
     *     {@link Script }
     *     
     */
    public Script getScript() {
        return script;
    }

    /**
     * Sets the value of the script property.
     * 
     * @param value
     *     allowed object is
     *     {@link Script }
     *     
     */
    public void setScript(Script value) {
        this.script = value;
    }

    /**
     * Gets the value of the externalPackages property.
     * 
     * @return
     *     possible object is
     *     {@link ExternalPackages }
     *     
     */
    public ExternalPackages getExternalPackages() {
        return externalPackages;
    }

    /**
     * Sets the value of the externalPackages property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalPackages }
     *     
     */
    public void setExternalPackages(ExternalPackages value) {
        this.externalPackages = value;
    }

    /**
     * Gets the value of the typeDeclarations property.
     * 
     * @return
     *     possible object is
     *     {@link TypeDeclarations }
     *     
     */
    public TypeDeclarations getTypeDeclarations() {
        return typeDeclarations;
    }

    /**
     * Sets the value of the typeDeclarations property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeDeclarations }
     *     
     */
    public void setTypeDeclarations(TypeDeclarations value) {
        this.typeDeclarations = value;
    }

    /**
     * Gets the value of the participants property.
     * 
     * @return
     *     possible object is
     *     {@link Participants }
     *     
     */
    public Participants getParticipants() {
        return participants;
    }

    /**
     * Sets the value of the participants property.
     * 
     * @param value
     *     allowed object is
     *     {@link Participants }
     *     
     */
    public void setParticipants(Participants value) {
        this.participants = value;
    }

    /**
     * Gets the value of the applications property.
     * 
     * @return
     *     possible object is
     *     {@link Applications }
     *     
     */
    public Applications getApplications() {
        return applications;
    }

    /**
     * Sets the value of the applications property.
     * 
     * @param value
     *     allowed object is
     *     {@link Applications }
     *     
     */
    public void setApplications(Applications value) {
        this.applications = value;
    }

    /**
     * Gets the value of the dataFields property.
     * 
     * @return
     *     possible object is
     *     {@link DataFields }
     *     
     */
    public DataFields getDataFields() {
        return dataFields;
    }

    /**
     * Sets the value of the dataFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataFields }
     *     
     */
    public void setDataFields(DataFields value) {
        this.dataFields = value;
    }

    /**
     * Gets the value of the partnerLinkTypes property.
     * 
     * @return
     *     possible object is
     *     {@link PartnerLinkTypes }
     *     
     */
    public PartnerLinkTypes getPartnerLinkTypes() {
        return partnerLinkTypes;
    }

    /**
     * Sets the value of the partnerLinkTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartnerLinkTypes }
     *     
     */
    public void setPartnerLinkTypes(PartnerLinkTypes value) {
        this.partnerLinkTypes = value;
    }

    /**
     * Gets the value of the pages property.
     * 
     * @return
     *     possible object is
     *     {@link Pages }
     *     
     */
    public Pages getPages() {
        return pages;
    }

    /**
     * Sets the value of the pages property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pages }
     *     
     */
    public void setPages(Pages value) {
        this.pages = value;
    }

    /**
     * Gets the value of the pools property.
     * 
     * @return
     *     possible object is
     *     {@link Pools }
     *     
     */
    public Pools getPools() {
        return pools;
    }

    /**
     * Sets the value of the pools property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pools }
     *     
     */
    public void setPools(Pools value) {
        this.pools = value;
    }

    /**
     * Gets the value of the messageFlows property.
     * 
     * @return
     *     possible object is
     *     {@link MessageFlows }
     *     
     */
    public MessageFlows getMessageFlows() {
        return messageFlows;
    }

    /**
     * Sets the value of the messageFlows property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageFlows }
     *     
     */
    public void setMessageFlows(MessageFlows value) {
        this.messageFlows = value;
    }

    /**
     * Gets the value of the associations property.
     * 
     * @return
     *     possible object is
     *     {@link Associations }
     *     
     */
    public Associations getAssociations() {
        return associations;
    }

    /**
     * Sets the value of the associations property.
     * 
     * @param value
     *     allowed object is
     *     {@link Associations }
     *     
     */
    public void setAssociations(Associations value) {
        this.associations = value;
    }

    /**
     * Gets the value of the artifacts property.
     * 
     * @return
     *     possible object is
     *     {@link Artifacts }
     *     
     */
    public Artifacts getArtifacts() {
        return artifacts;
    }

    /**
     * Sets the value of the artifacts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Artifacts }
     *     
     */
    public void setArtifacts(Artifacts value) {
        this.artifacts = value;
    }

    /**
     * Gets the value of the workflowProcesses property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowProcesses }
     *     
     */
    public WorkflowProcesses getWorkflowProcesses() {
        return workflowProcesses;
    }

    /**
     * Sets the value of the workflowProcesses property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowProcesses }
     *     
     */
    public void setWorkflowProcesses(WorkflowProcesses value) {
        this.workflowProcesses = value;
    }

    /**
     * Gets the value of the extendedAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedAttributes }
     *     
     */
    public ExtendedAttributes getExtendedAttributes() {
        return extendedAttributes;
    }

    /**
     * Sets the value of the extendedAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedAttributes }
     *     
     */
    public void setExtendedAttributes(ExtendedAttributes value) {
        this.extendedAttributes = value;
    }

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     * {@link java.lang.Object }
     * 
     * 
     */
    public List<java.lang.Object> getAny() {
        if (any == null) {
            any = new ArrayList<java.lang.Object>();
        }
        return this.any;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the queryLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueryLanguage() {
        return queryLanguage;
    }

    /**
     * Sets the value of the queryLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueryLanguage(String value) {
        this.queryLanguage = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
