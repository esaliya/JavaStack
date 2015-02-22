
package com.amazonaws.elasticmapreduce.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="JobFlowId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "", propOrder = {
    "jobFlowId"
})
@XmlRootElement(name = "RunJobFlowResult")
public class RunJobFlowResult {

    @XmlElement(name = "JobFlowId")
    protected String jobFlowId;

    /**
     * Default constructor
     * 
     */
    public RunJobFlowResult() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public RunJobFlowResult(final String jobFlowId) {
        this.jobFlowId = jobFlowId;
    }

    /**
     * Gets the value of the jobFlowId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobFlowId() {
        return jobFlowId;
    }

    /**
     * Sets the value of the jobFlowId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobFlowId(String value) {
        this.jobFlowId = value;
    }

    public boolean isSetJobFlowId() {
        return (this.jobFlowId!= null);
    }

    /**
     * Sets the value of the JobFlowId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public RunJobFlowResult withJobFlowId(String value) {
        setJobFlowId(value);
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
        if (isSetJobFlowId()) {
            xml.append("<JobFlowId>");
            xml.append(escapeXML(getJobFlowId()));
            xml.append("</JobFlowId>");
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
        if (isSetJobFlowId()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("JobFlowId"));
            json.append(" : ");
            json.append(quoteJSON(getJobFlowId()));
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
