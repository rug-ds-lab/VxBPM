//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.10.05 at 01:56:55 PM CEST 
//


package org.wfmc._2008.xpdl2;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResourceCostName">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="100"/>
 *               &lt;minLength value="0"/>
 *               &lt;whiteSpace value="preserve"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ResourceCost">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CostUnitOfTime">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *               &lt;enumeration value="second"/>
 *               &lt;enumeration value="minute"/>
 *               &lt;enumeration value="hour"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "resourceCostName",
    "resourceCost",
    "costUnitOfTime"
})
@XmlRootElement(name = "ResourceCosts")
public class ResourceCosts {

    @XmlElement(name = "ResourceCostName", required = true)
    protected String resourceCostName;
    @XmlElement(name = "ResourceCost", required = true)
    protected BigDecimal resourceCost;
    @XmlElement(name = "CostUnitOfTime", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String costUnitOfTime;

    /**
     * Gets the value of the resourceCostName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResourceCostName() {
        return resourceCostName;
    }

    /**
     * Sets the value of the resourceCostName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResourceCostName(String value) {
        this.resourceCostName = value;
    }

    /**
     * Gets the value of the resourceCost property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getResourceCost() {
        return resourceCost;
    }

    /**
     * Sets the value of the resourceCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setResourceCost(BigDecimal value) {
        this.resourceCost = value;
    }

    /**
     * Gets the value of the costUnitOfTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCostUnitOfTime() {
        return costUnitOfTime;
    }

    /**
     * Sets the value of the costUnitOfTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCostUnitOfTime(String value) {
        this.costUnitOfTime = value;
    }

}
