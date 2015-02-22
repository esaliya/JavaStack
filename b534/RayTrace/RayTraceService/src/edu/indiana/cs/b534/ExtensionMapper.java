/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */

package edu.indiana.cs.b534;

/**
 * ExtensionMapper class
 */

public class ExtensionMapper {

    public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                 java.lang.String typeName,
                                                 javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {


        if (
                "http://b534.cs.indiana.edu".equals(namespaceURI) &&
                        "Point3D".equals(typeName)) {

            return edu.indiana.cs.b534.Point3D.Factory.parse(reader);


        }


        if (
                "http://b534.cs.indiana.edu".equals(namespaceURI) &&
                        "ArrayOfRGBColor".equals(typeName)) {

            return edu.indiana.cs.b534.ArrayOfRGBColor.Factory.parse(reader);


        }


        if (
                "http://b534.cs.indiana.edu".equals(namespaceURI) &&
                        "RGBColor".equals(typeName)) {

            return edu.indiana.cs.b534.RGBColor.Factory.parse(reader);


        }


        if (
                "http://b534.cs.indiana.edu".equals(namespaceURI) &&
                        "Rectangle".equals(typeName)) {

            return edu.indiana.cs.b534.Rectangle.Factory.parse(reader);


        }


        if (
                "http://b534.cs.indiana.edu".equals(namespaceURI) &&
                        "CameraSetup".equals(typeName)) {

            return edu.indiana.cs.b534.CameraSetup.Factory.parse(reader);


        }


        throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
    }

}
    