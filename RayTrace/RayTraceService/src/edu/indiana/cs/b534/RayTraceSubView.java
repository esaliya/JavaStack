/**
 * RayTraceSubView.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:41 LKT)
 */

package edu.indiana.cs.b534;


/**
 * RayTraceSubView bean class
 */

public class RayTraceSubView
        implements org.apache.axis2.databinding.ADBBean {

    public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
            "http://b534.cs.indiana.edu",
            "rayTraceSubView",
            "ns1");


    private static java.lang.String generatePrefix(java.lang.String namespace) {
        if (namespace.equals("http://b534.cs.indiana.edu")) {
            return "ns1";
        }
        return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }


    /**
     * field for SceneURL
     */


    protected java.lang.String localSceneURL;

    /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
    protected boolean localSceneURLTracker = false;


    /**
     * Auto generated getter method
     *
     * @return java.lang.String
     */
    public java.lang.String getSceneURL() {
        return localSceneURL;
    }


    /**
     * Auto generated setter method
     *
     * @param param SceneURL
     */
    public void setSceneURL(java.lang.String param) {

        if (param != null) {
            //update the setting tracker
            localSceneURLTracker = true;
        } else {
            localSceneURLTracker = true;

        }

        this.localSceneURL = param;


    }


    /**
     * field for Camera
     */


    protected edu.indiana.cs.b534.CameraSetup localCamera;

    /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
    protected boolean localCameraTracker = false;


    /**
     * Auto generated getter method
     *
     * @return edu.indiana.cs.b534.CameraSetup
     */
    public edu.indiana.cs.b534.CameraSetup getCamera() {
        return localCamera;
    }


    /**
     * Auto generated setter method
     *
     * @param param Camera
     */
    public void setCamera(edu.indiana.cs.b534.CameraSetup param) {

        if (param != null) {
            //update the setting tracker
            localCameraTracker = true;
        } else {
            localCameraTracker = true;

        }

        this.localCamera = param;


    }


    /**
     * field for ImageWidth
     */


    protected int localImageWidth;

    /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
    protected boolean localImageWidthTracker = false;


    /**
     * Auto generated getter method
     *
     * @return int
     */
    public int getImageWidth() {
        return localImageWidth;
    }


    /**
     * Auto generated setter method
     *
     * @param param ImageWidth
     */
    public void setImageWidth(int param) {

        // setting primitive attribute tracker to true

        if (param == java.lang.Integer.MIN_VALUE) {
            localImageWidthTracker = false;

        } else {
            localImageWidthTracker = true;
        }

        this.localImageWidth = param;


    }


    /**
     * field for ImageHeight
     */


    protected int localImageHeight;

    /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
    protected boolean localImageHeightTracker = false;


    /**
     * Auto generated getter method
     *
     * @return int
     */
    public int getImageHeight() {
        return localImageHeight;
    }


    /**
     * Auto generated setter method
     *
     * @param param ImageHeight
     */
    public void setImageHeight(int param) {

        // setting primitive attribute tracker to true

        if (param == java.lang.Integer.MIN_VALUE) {
            localImageHeightTracker = false;

        } else {
            localImageHeightTracker = true;
        }

        this.localImageHeight = param;


    }


    /**
     * field for SubView
     */


    protected edu.indiana.cs.b534.Rectangle localSubView;

    /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
    protected boolean localSubViewTracker = false;


    /**
     * Auto generated getter method
     *
     * @return edu.indiana.cs.b534.Rectangle
     */
    public edu.indiana.cs.b534.Rectangle getSubView() {
        return localSubView;
    }


    /**
     * Auto generated setter method
     *
     * @param param SubView
     */
    public void setSubView(edu.indiana.cs.b534.Rectangle param) {

        if (param != null) {
            //update the setting tracker
            localSubViewTracker = true;
        } else {
            localSubViewTracker = true;

        }

        this.localSubView = param;


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
                new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

                    public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                        RayTraceSubView.this.serialize(MY_QNAME, factory, xmlWriter);
                    }
                };
        return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                MY_QNAME, factory, dataSource);

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
                        namespacePrefix + ":rayTraceSubView",
                        xmlWriter);
            } else {
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                        "rayTraceSubView",
                        xmlWriter);
            }


        }
        if (localSceneURLTracker) {
            namespace = "http://b534.cs.indiana.edu";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "sceneURL", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "sceneURL");
                }

            } else {
                xmlWriter.writeStartElement("sceneURL");
            }


            if (localSceneURL == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localSceneURL);

            }

            xmlWriter.writeEndElement();
        }
        if (localCameraTracker) {
            if (localCamera == null) {

                java.lang.String namespace2 = "http://b534.cs.indiana.edu";

                if (!namespace2.equals("")) {
                    java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                    if (prefix2 == null) {
                        prefix2 = generatePrefix(namespace2);

                        xmlWriter.writeStartElement(prefix2, "camera", namespace2);
                        xmlWriter.writeNamespace(prefix2, namespace2);
                        xmlWriter.setPrefix(prefix2, namespace2);

                    } else {
                        xmlWriter.writeStartElement(namespace2, "camera");
                    }

                } else {
                    xmlWriter.writeStartElement("camera");
                }


                // write the nil attribute
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                xmlWriter.writeEndElement();
            } else {
                localCamera.serialize(new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "camera"),
                        factory, xmlWriter);
            }
        }
        if (localImageWidthTracker) {
            namespace = "http://b534.cs.indiana.edu";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "imageWidth", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "imageWidth");
                }

            } else {
                xmlWriter.writeStartElement("imageWidth");
            }

            if (localImageWidth == java.lang.Integer.MIN_VALUE) {

                throw new org.apache.axis2.databinding.ADBException("imageWidth cannot be null!!");

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localImageWidth));
            }

            xmlWriter.writeEndElement();
        }
        if (localImageHeightTracker) {
            namespace = "http://b534.cs.indiana.edu";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "imageHeight", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "imageHeight");
                }

            } else {
                xmlWriter.writeStartElement("imageHeight");
            }

            if (localImageHeight == java.lang.Integer.MIN_VALUE) {

                throw new org.apache.axis2.databinding.ADBException("imageHeight cannot be null!!");

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localImageHeight));
            }

            xmlWriter.writeEndElement();
        }
        if (localSubViewTracker) {
            if (localSubView == null) {

                java.lang.String namespace2 = "http://b534.cs.indiana.edu";

                if (!namespace2.equals("")) {
                    java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                    if (prefix2 == null) {
                        prefix2 = generatePrefix(namespace2);

                        xmlWriter.writeStartElement(prefix2, "subView", namespace2);
                        xmlWriter.writeNamespace(prefix2, namespace2);
                        xmlWriter.setPrefix(prefix2, namespace2);

                    } else {
                        xmlWriter.writeStartElement(namespace2, "subView");
                    }

                } else {
                    xmlWriter.writeStartElement("subView");
                }


                // write the nil attribute
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                xmlWriter.writeEndElement();
            } else {
                localSubView.serialize(new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "subView"),
                        factory, xmlWriter);
            }
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

        if (localSceneURLTracker) {
            elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                    "sceneURL"));

            elementList.add(localSceneURL == null ? null :
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSceneURL));
        }
        if (localCameraTracker) {
            elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                    "camera"));


            elementList.add(localCamera == null ? null :
                    localCamera);
        }
        if (localImageWidthTracker) {
            elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                    "imageWidth"));

            elementList.add(
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localImageWidth));
        }
        if (localImageHeightTracker) {
            elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                    "imageHeight"));

            elementList.add(
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localImageHeight));
        }
        if (localSubViewTracker) {
            elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                    "subView"));


            elementList.add(localSubView == null ? null :
                    localSubView);
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
        public static RayTraceSubView parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
            RayTraceSubView object =
                    new RayTraceSubView();

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

                        if (!"rayTraceSubView".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                            return (RayTraceSubView) edu.indiana.cs.b534.ExtensionMapper.getTypeObject(
                                    nsUri, type, reader);
                        }


                    }


                }


                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();


                reader.next();


                while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "sceneURL").equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                        java.lang.String content = reader.getElementText();

                        object.setSceneURL(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                    } else {


                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();

                }  // End of if for expected property start element

                else {

                }


                while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "camera").equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        object.setCamera(null);
                        reader.next();

                        reader.next();

                    } else {

                        object.setCamera(edu.indiana.cs.b534.CameraSetup.Factory.parse(reader));

                        reader.next();
                    }
                }  // End of if for expected property start element

                else {

                }


                while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "imageWidth").equals(reader.getName())) {

                    java.lang.String content = reader.getElementText();

                    object.setImageWidth(
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                    reader.next();

                }  // End of if for expected property start element

                else {

                    object.setImageWidth(java.lang.Integer.MIN_VALUE);

                }


                while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "imageHeight").equals(reader.getName())) {

                    java.lang.String content = reader.getElementText();

                    object.setImageHeight(
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                    reader.next();

                }  // End of if for expected property start element

                else {

                    object.setImageHeight(java.lang.Integer.MIN_VALUE);

                }


                while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "subView").equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        object.setSubView(null);
                        reader.next();

                        reader.next();

                    } else {

                        object.setSubView(edu.indiana.cs.b534.Rectangle.Factory.parse(reader));

                        reader.next();
                    }
                }  // End of if for expected property start element

                else {

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
           
          