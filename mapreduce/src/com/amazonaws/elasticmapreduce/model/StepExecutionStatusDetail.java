
package com.amazonaws.elasticmapreduce.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StepExecutionStatusDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StepExecutionStatusDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CreationDateTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="StartDateTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EndDateTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastStateChangeReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * Generated by AWS Code Generator
 * <p/>
 * Tue Apr 21 15:28:27 PDT 2009
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StepExecutionStatusDetail", propOrder = {
    "state",
    "creationDateTime",
    "startDateTime",
    "endDateTime",
    "lastStateChangeReason"
})
public class StepExecutionStatusDetail {

    @XmlElement(name = "State", required = true)
    protected String state;
    @XmlElement(name = "CreationDateTime", required = true)
    protected String creationDateTime;
    @XmlElement(name = "StartDateTime")
    protected String startDateTime;
    @XmlElement(name = "EndDateTime")
    protected String endDateTime;
    @XmlElement(name = "LastStateChangeReason")
    protected String lastStateChangeReason;

    /**
     * Default constructor
     * 
     */
    public StepExecutionStatusDetail() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public StepExecutionStatusDetail(final String state, final String creationDateTime, final String startDateTime, final String endDateTime, final String lastStateChangeReason) {
        this.state = state;
        this.creationDateTime = creationDateTime;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.lastStateChangeReason = lastStateChangeReason;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

    public boolean isSetState() {
        return (this.state!= null);
    }

    /**
     * Gets the value of the creationDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreationDateTime() {
        return creationDateTime;
    }

    /**
     * Sets the value of the creationDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreationDateTime(String value) {
        this.creationDateTime = value;
    }

    public boolean isSetCreationDateTime() {
        return (this.creationDateTime!= null);
    }

    /**
     * Gets the value of the startDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDateTime() {
        return startDateTime;
    }

    /**
     * Sets the value of the startDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDateTime(String value) {
        this.startDateTime = value;
    }

    public boolean isSetStartDateTime() {
        return (this.startDateTime!= null);
    }

    /**
     * Gets the value of the endDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDateTime() {
        return endDateTime;
    }

    /**
     * Sets the value of the endDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDateTime(String value) {
        this.endDateTime = value;
    }

    public boolean isSetEndDateTime() {
        return (this.endDateTime!= null);
    }

    /**
     * Gets the value of the lastStateChangeReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastStateChangeReason() {
        return lastStateChangeReason;
    }

    /**
     * Sets the value of the lastStateChangeReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastStateChangeReason(String value) {
        this.lastStateChangeReason = value;
    }

    public boolean isSetLastStateChangeReason() {
        return (this.lastStateChangeReason!= null);
    }

    /**
     * Sets the value of the State property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public StepExecutionStatusDetail withState(String value) {
        setState(value);
        return this;
    }

    /**
     * Sets the value of the CreationDateTime property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public StepExecutionStatusDetail withCreationDateTime(String value) {
        setCreationDateTime(value);
        return this;
    }

    /**
     * Sets the value of the StartDateTime property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public StepExecutionStatusDetail withStartDateTime(String value) {
        setStartDateTime(value);
        return this;
    }

    /**
     * Sets the value of the EndDateTime property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public StepExecutionStatusDetail withEndDateTime(String value) {
        setEndDateTime(value);
        return this;
    }

    /**
     * Sets the value of the LastStateChangeReason property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public StepExecutionStatusDetail withLastStateChangeReason(String value) {
        setLastStateChangeReason(value);
        return this;
    }
    

    /**
     * 
     * XML fragment representation of this object
     * 
     * @return XML fragment for this object. Name for outer
     * tag expected to be set by calling method. This fragment
     * returns inner properties representation only
     */
    protected String toXMLFragment() {
        StringBuffer xml = new StringBuffer();
        if (isSetState()) {
            xml.append("<State>");
            xml.append(escapeXML(getState()));
            xml.append("</State>");
        }
        if (isSetCreationDateTime()) {
            xml.append("<CreationDateTime>");
            xml.append(escapeXML(getCreationDateTime()));
            xml.append("</CreationDateTime>");
        }
        if (isSetStartDateTime()) {
            xml.append("<StartDateTime>");
            xml.append(escapeXML(getStartDateTime()));
            xml.append("</StartDateTime>");
        }
        if (isSetEndDateTime()) {
            xml.append("<EndDateTime>");
            xml.append(escapeXML(getEndDateTime()));
            xml.append("</EndDateTime>");
        }
        if (isSetLastStateChangeReason()) {
            xml.append("<LastStateChangeReason>");
            xml.append(escapeXML(getLastStateChangeReason()));
            xml.append("</LastStateChangeReason>");
        }
        return xml.toString();
    }

    /**
     * 
     * Escape XML special characters
     */
    private String escapeXML(String string) {
        StringBuffer sb = new StringBuffer();
        int length = string.length();
        for (int i = 0; i < length; ++i) {
            char c = string.charAt(i);
            switch (c) {
            case '&':
                sb.append("&amp;");
                break;
            case '<':
                sb.append("&lt;");
                break;
            case '>':
                sb.append("&gt;");
                break;
            case '\'':
                sb.append("&#039;");
                break;
            case '"':
                sb.append("&quot;");
                break;
            default:
                sb.append(c);
            }
        }
        return sb.toString();
    }



    /**
     *
     * JSON fragment representation of this object
     *
     * @return JSON fragment for this object. Name for outer
     * object expected to be set by calling method. This fragment
     * returns inner properties representation only
     *
     */
    protected String toJSONFragment() {
        StringBuffer json = new StringBuffer();
        boolean first = true;
        if (isSetState()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("State"));
            json.append(" : ");
            json.append(quoteJSON(getState()));
            first = false;
        }
        if (isSetCreationDateTime()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("CreationDateTime"));
            json.append(" : ");
            json.append(quoteJSON(getCreationDateTime()));
            first = false;
        }
        if (isSetStartDateTime()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("StartDateTime"));
            json.append(" : ");
            json.append(quoteJSON(getStartDateTime()));
            first = false;
        }
        if (isSetEndDateTime()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("EndDateTime"));
            json.append(" : ");
            json.append(quoteJSON(getEndDateTime()));
            first = false;
        }
        if (isSetLastStateChangeReason()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("LastStateChangeReason"));
            json.append(" : ");
            json.append(quoteJSON(getLastStateChangeReason()));
            first = false;
        }
        return json.toString();
    }

    /**
     *
     * Quote JSON string
     */
    private String quoteJSON(String string) {
        StringBuffer sb = new StringBuffer();
        sb.append("\"");
        int length = string.length();
        for (int i = 0; i < length; ++i) {
            char c = string.charAt(i);
            switch (c) {
            case '"':
                sb.append("\\\"");
                break;
            case '\\':
                sb.append("\\\\");
                break;
            case '/':
                sb.append("\\/");
                break;
            case '\b':
                sb.append("\\b");
                break;
            case '\f':
                sb.append("\\f");
                break;
            case '\n':
                sb.append("\\n");
                break;
            case '\r':
                sb.append("\\r");
                break;
            case '\t':
                sb.append("\\t");
                break;
            default:
                if (c <  ' ') {
                    sb.append("\\u" + String.format("%03x", Integer.valueOf(c)));
                } else {
                sb.append(c);
            }
        }
        }
        sb.append("\"");
        return sb.toString();
    }


}
