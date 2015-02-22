/**
 * Rectangle.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */

package edu.indiana.cs.b534;


/**
 * Rectangle bean class
 */

public class Rectangle
        implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
    name = Rectangle
    Namespace URI = http://b534.cs.indiana.edu
    Namespace Prefix = ns1
    */


    private static java.lang.String generatePrefix(java.lang.String namespace) {
        if (namespace.equals("http://b534.cs.indiana.edu")) {
            return "ns1";
        }
        return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }


    /**
     * field for MaxX
     */


    protected double localMaxX;

    /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
    protected boolean localMaxXTracker = false;


    /**
     * Auto generated getter method
     *
     * @return double
     */
    public double getMaxX() {
        return localMaxX;
    }


    /**
     * Auto generated setter method
     *
     * @param param MaxX
     */
    public void setMaxX(double param) {

        // setting primitive attribute tracker to true

        if (java.lang.Double.isNaN(param)) {
            localMaxXTracker = false;

        } else {
            localMaxXTracker = true;
        }

        this.localMaxX = param;


    }


    /**
     * field for MaxY
     */


    protected double localMaxY;

    /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
    protected boolean localMaxYTracker = false;


    /**
     * Auto generated getter method
     *
     * @return double
     */
    public double getMaxY() {
        return localMaxY;
    }


    /**
     * Auto generated setter method
     *
     * @param param MaxY
     */
    public void setMaxY(double param) {

        // setting primitive attribute tracker to true

        if (java.lang.Double.isNaN(param)) {
            localMaxYTracker = false;

        } else {
            localMaxYTracker = true;
        }

        this.localMaxY = param;


    }


    /**
     * field for MinX
     */


    protected double localMinX;

    /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
    protected boolean localMinXTracker = false;


    /**
     * Auto generated getter method
     *
     * @return double
     */
    public double getMinX() {
        return localMinX;
    }


    /**
     * Auto generated setter method
     *
     * @param param MinX
     */
    public void setMinX(double param) {

        // setting primitive attribute tracker to true

        if (java.lang.Double.isNaN(param)) {
            localMinXTracker = false;

        } else {
            localMinXTracker = true;
        }

        this.localMinX = param;


    }


    /**
     * field for MinY
     */


    protected double localMinY;

    /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
    protected boolean localMinYTracker = false;


    /**
     * Auto generated getter method
     *
     * @return double
     */
    public double getMinY() {
        return localMinY;
    }


    /**
     * Auto generated setter method
     *
     * @param param MinY
     */
    public void setMinY(double param) {

        // setting primitive attribute tracker to true

        if (java.lang.Double.isNaN(param)) {
            localMinYTracker = false;

        } else {
            localMinYTracker = true;
        }

        this.localMinY = param;


    }


    /**
     * isReaderMTOMAware
     *
     * @return true if the reader supports MTOM
     */
    public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;

        try {
            isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        } catch (java.lang.IllegalArgumentException e) {
            isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
    }


    /**
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    public org.apache.axiom.om.OMElement getOMElement(
            final javax.xml.namespace.QName parentQName,
            final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


        org.apache.axiom.om.OMDataSource dataSource =
                new org.apache.axis2.databinding.ADBDataSource(this, parentQName) {

                    public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                        Rectangle.this.serialize(parentQName, factory, xmlWriter);
                    }
                };
        return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                parentQName, factory, dataSource);

    }

    public void serialize(final javax.xml.namespace.QName parentQName,
                          final org.apache.axiom.om.OMFactory factory,
                          org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
        serialize(parentQName, factory, xmlWriter, false);
    }

    public void serialize(final javax.xml.namespace.QName parentQName,
                          final org.apache.axiom.om.OMFactory factory,
                          org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                          boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {


        java.lang.String prefix = null;
        java.lang.String namespace = null;


        prefix = parentQName.getPrefix();
        namespace = parentQName.getNamespaceURI();

        if ((namespace != null) && (namespace.trim().length() > 0)) {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
            } else {
                if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        } else {
            xmlWriter.writeStartElement(parentQName.getLocalPart());
        }

        if (serializeType) {


            java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://b534.cs.indiana.edu");
            if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                        namespacePrefix + ":Rectangle",
                        xmlWriter);
            } else {
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                        "Rectangle",
                        xmlWriter);
            }


        }
        if (localMaxXTracker) {
            namespace = "http://b534.cs.indiana.edu";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "maxX", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "maxX");
                }

            } else {
                xmlWriter.writeStartElement("maxX");
            }

            if (java.lang.Double.isNaN(localMaxX)) {

                throw new org.apache.axis2.databinding.ADBException("maxX cannot be null!!");

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMaxX));
            }

            xmlWriter.writeEndElement();
        }
        if (localMaxYTracker) {
            namespace = "http://b534.cs.indiana.edu";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "maxY", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "maxY");
                }

            } else {
                xmlWriter.writeStartElement("maxY");
            }

            if (java.lang.Double.isNaN(localMaxY)) {

                throw new org.apache.axis2.databinding.ADBException("maxY cannot be null!!");

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMaxY));
            }

            xmlWriter.writeEndElement();
        }
        if (localMinXTracker) {
            namespace = "http://b534.cs.indiana.edu";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "minX", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "minX");
                }

            } else {
                xmlWriter.writeStartElement("minX");
            }

            if (java.lang.Double.isNaN(localMinX)) {

                throw new org.apache.axis2.databinding.ADBException("minX cannot be null!!");

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMinX));
            }

            xmlWriter.writeEndElement();
        }
        if (localMinYTracker) {
            namespace = "http://b534.cs.indiana.edu";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "minY", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "minY");
                }

            } else {
                xmlWriter.writeStartElement("minY");
            }

            if (java.lang.Double.isNaN(localMinY)) {

                throw new org.apache.axis2.databinding.ADBException("minY cannot be null!!");

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMinY));
            }

            xmlWriter.writeEndElement();
        }
        xmlWriter.writeEndElement();


    }

    /**
     * Util method to write an attribute with the ns prefix
     */
    private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
        if (xmlWriter.getPrefix(namespace) == null) {
            xmlWriter.writeNamespace(prefix, namespace);
            xmlWriter.setPrefix(prefix, namespace);

        }

        xmlWriter.writeAttribute(namespace, attName, attValue);

    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
        if (namespace.equals("")) {
            xmlWriter.writeAttribute(attName, attValue);
        } else {
            registerPrefix(xmlWriter, namespace);
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }
    }


    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                     javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

        java.lang.String attributeNamespace = qname.getNamespaceURI();
        java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
        if (attributePrefix == null) {
            attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
        }
        java.lang.String attributeValue;
        if (attributePrefix.trim().length() > 0) {
            attributeValue = attributePrefix + ":" + qname.getLocalPart();
        } else {
            attributeValue = qname.getLocalPart();
        }

        if (namespace.equals("")) {
            xmlWriter.writeAttribute(attName, attributeValue);
        } else {
            registerPrefix(xmlWriter, namespace);
            xmlWriter.writeAttribute(namespace, attName, attributeValue);
        }
    }

    /**
     * method to handle Qnames
     */

    private void writeQName(javax.xml.namespace.QName qname,
                            javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
        java.lang.String namespaceURI = qname.getNamespaceURI();
        if (namespaceURI != null) {
            java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
            if (prefix == null) {
                prefix = generatePrefix(namespaceURI);
                xmlWriter.writeNamespace(prefix, namespaceURI);
                xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
                xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            } else {
                // i.e this is the default namespace
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }

        } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }
    }

    private void writeQNames(javax.xml.namespace.QName[] qnames,
                             javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

        if (qnames != null) {
            // we have to store this data until last moment since it is not possible to write any
            // namespace data after writing the charactor data
            java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
            java.lang.String namespaceURI = null;
            java.lang.String prefix = null;

            for (int i = 0; i < qnames.length; i++) {
                if (i > 0) {
                    stringToWrite.append(" ");
                }
                namespaceURI = qnames[i].getNamespaceURI();
                if (namespaceURI != null) {
                    prefix = xmlWriter.getPrefix(namespaceURI);
                    if ((prefix == null) || (prefix.length() == 0)) {
                        prefix = generatePrefix(namespaceURI);
                        xmlWriter.writeNamespace(prefix, namespaceURI);
                        xmlWriter.setPrefix(prefix, namespaceURI);
                    }

                    if (prefix.trim().length() > 0) {
                        stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                } else {
                    stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                }
            }
            xmlWriter.writeCharacters(stringToWrite.toString());
        }

    }


    /**
     * Register a namespace prefix
     */
    private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
        java.lang.String prefix = xmlWriter.getPrefix(namespace);

        if (prefix == null) {
            prefix = generatePrefix(namespace);

            while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
            }

            xmlWriter.writeNamespace(prefix, namespace);
            xmlWriter.setPrefix(prefix, namespace);
        }

        return prefix;
    }


    /**
     * databinding method to get an XML representation of this object
     */
    public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
            throws org.apache.axis2.databinding.ADBException {


        java.util.ArrayList elementList = new java.util.ArrayList();
        java.util.ArrayList attribList = new java.util.ArrayList();

        if (localMaxXTracker) {
            elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                    "maxX"));

            elementList.add(
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMaxX));
        }
        if (localMaxYTracker) {
            elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                    "maxY"));

            elementList.add(
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMaxY));
        }
        if (localMinXTracker) {
            elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                    "minX"));

            elementList.add(
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMinX));
        }
        if (localMinYTracker) {
            elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                    "minY"));

            elementList.add(
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMinY));
        }

        return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());


    }


    /**
     * Factory class that keeps the parse method
     */
    public static class Factory {


        /**
         * static method to create the object
         * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
         * If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
         * Postcondition: If this object is an element, the reader is positioned at its end element
         * If this object is a complex type, the reader is positioned at the end element of its outer element
         */
        public static Rectangle parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
            Rectangle object =
                    new Rectangle();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix = "";
            java.lang.String namespaceuri = "";
            try {

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();


                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                    java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "type");
                    if (fullTypeName != null) {
                        java.lang.String nsPrefix = null;
                        if (fullTypeName.indexOf(":") > -1) {
                            nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                        }
                        nsPrefix = nsPrefix == null ? "" : nsPrefix;

                        java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                        if (!"Rectangle".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                            return (Rectangle) edu.indiana.cs.b534.ExtensionMapper.getTypeObject(
                                    nsUri, type, reader);
                        }


                    }


                }


                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();


                reader.next();


                while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "maxX").equals(reader.getName())) {

                    java.lang.String content = reader.getElementText();

                    object.setMaxX(
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

                    reader.next();

                }  // End of if for expected property start element

                else {

                    object.setMaxX(java.lang.Double.NaN);

                }


                while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "maxY").equals(reader.getName())) {

                    java.lang.String content = reader.getElementText();

                    object.setMaxY(
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

                    reader.next();

                }  // End of if for expected property start element

                else {

                    object.setMaxY(java.lang.Double.NaN);

                }


                while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "minX").equals(reader.getName())) {

                    java.lang.String content = reader.getElementText();

                    object.setMinX(
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

                    reader.next();

                }  // End of if for expected property start element

                else {

                    object.setMinX(java.lang.Double.NaN);

                }


                while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "minY").equals(reader.getName())) {

                    java.lang.String content = reader.getElementText();

                    object.setMinY(
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

                    reader.next();

                }  // End of if for expected property start element

                else {

                    object.setMinY(java.lang.Double.NaN);

                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement())
                    // A start element we are not expecting indicates a trailing invalid property
                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());


            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

    }//end of factory class


}
           
          