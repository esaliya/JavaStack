/**
 * RayTracerMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
package edu.indiana.cs.b534;

import org.apache.axis2.receivers.AbstractInOutAsyncMessageReceiver;

/**
 * RayTracerMessageReceiverInOut message receiver
 */

public class RayTracerMessageReceiverInOut extends AbstractInOutAsyncMessageReceiver {


    public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
            throws org.apache.axis2.AxisFault {

        try {

            // get the implementation class for the Web Service
            Object obj = getTheImplementationObject(msgContext);

            RayTracerSkeleton skel = (RayTracerSkeleton) obj;
            //Out Envelop
            org.apache.axiom.soap.SOAPEnvelope envelope = null;
            //Find the axisOperation that has been set by the Dispatch phase.
            org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
            if (op == null) {
                throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
            }

            java.lang.String methodName;
            if ((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)) {


                if ("rayTrace".equals(methodName)) {

                    edu.indiana.cs.b534.RayTraceResponse rayTraceResponse1 = null;
                    edu.indiana.cs.b534.RayTrace wrappedParam =
                            (edu.indiana.cs.b534.RayTrace) fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.indiana.cs.b534.RayTrace.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));

                    rayTraceResponse1 =


                            skel.rayTrace(wrappedParam)
                            ;

                    envelope = toEnvelope(getSOAPFactory(msgContext), rayTraceResponse1, false);
                } else if ("rayTraceMovie".equals(methodName)) {

                    edu.indiana.cs.b534.RayTraceMovieResponse rayTraceMovieResponse3 = null;
                    edu.indiana.cs.b534.RayTraceMovie wrappedParam =
                            (edu.indiana.cs.b534.RayTraceMovie) fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.indiana.cs.b534.RayTraceMovie.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));

                    rayTraceMovieResponse3 =


                            skel.rayTraceMovie(wrappedParam)
                            ;

                    envelope = toEnvelope(getSOAPFactory(msgContext), rayTraceMovieResponse3, false);
                } else if ("rayTraceSubView".equals(methodName)) {

                    edu.indiana.cs.b534.RayTraceSubViewResponse rayTraceSubViewResponse5 = null;
                    edu.indiana.cs.b534.RayTraceSubView wrappedParam =
                            (edu.indiana.cs.b534.RayTraceSubView) fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.indiana.cs.b534.RayTraceSubView.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));

                    rayTraceSubViewResponse5 =


                            skel.rayTraceSubView(wrappedParam)
                            ;

                    envelope = toEnvelope(getSOAPFactory(msgContext), rayTraceSubViewResponse5, false);
                } else if ("rayTraceURL".equals(methodName)) {

                    edu.indiana.cs.b534.RayTraceURLResponse rayTraceURLResponse7 = null;
                    edu.indiana.cs.b534.RayTraceURL wrappedParam =
                            (edu.indiana.cs.b534.RayTraceURL) fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    edu.indiana.cs.b534.RayTraceURL.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));

                    rayTraceURLResponse7 =


                            skel.rayTraceURL(wrappedParam)
                            ;

                    envelope = toEnvelope(getSOAPFactory(msgContext), rayTraceURLResponse7, false);

                } else {
                    throw new java.lang.RuntimeException("method not found");
                }


                newMsgContext.setEnvelope(envelope);
            }
        }
        catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    //

    private org.apache.axiom.om.OMElement toOM(edu.indiana.cs.b534.RayTrace param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(edu.indiana.cs.b534.RayTrace.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(edu.indiana.cs.b534.RayTraceResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(edu.indiana.cs.b534.RayTraceResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(edu.indiana.cs.b534.RayTraceMovie param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(edu.indiana.cs.b534.RayTraceMovie.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(edu.indiana.cs.b534.RayTraceMovieResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(edu.indiana.cs.b534.RayTraceMovieResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(edu.indiana.cs.b534.RayTraceSubView param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(edu.indiana.cs.b534.RayTraceSubView.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(edu.indiana.cs.b534.RayTraceSubViewResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(edu.indiana.cs.b534.RayTraceSubViewResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(edu.indiana.cs.b534.RayTraceURL param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(edu.indiana.cs.b534.RayTraceURL.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(edu.indiana.cs.b534.RayTraceURLResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(edu.indiana.cs.b534.RayTraceURLResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.indiana.cs.b534.RayTraceResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody().addChild(param.getOMElement(edu.indiana.cs.b534.RayTraceResponse.MY_QNAME, factory));


            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private edu.indiana.cs.b534.RayTraceResponse wraprayTrace() {
        edu.indiana.cs.b534.RayTraceResponse wrappedElement = new edu.indiana.cs.b534.RayTraceResponse();
        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.indiana.cs.b534.RayTraceMovieResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody().addChild(param.getOMElement(edu.indiana.cs.b534.RayTraceMovieResponse.MY_QNAME, factory));


            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private edu.indiana.cs.b534.RayTraceMovieResponse wraprayTraceMovie() {
        edu.indiana.cs.b534.RayTraceMovieResponse wrappedElement = new edu.indiana.cs.b534.RayTraceMovieResponse();
        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.indiana.cs.b534.RayTraceSubViewResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody().addChild(param.getOMElement(edu.indiana.cs.b534.RayTraceSubViewResponse.MY_QNAME, factory));


            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private edu.indiana.cs.b534.RayTraceSubViewResponse wraprayTraceSubView() {
        edu.indiana.cs.b534.RayTraceSubViewResponse wrappedElement = new edu.indiana.cs.b534.RayTraceSubViewResponse();
        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, edu.indiana.cs.b534.RayTraceURLResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody().addChild(param.getOMElement(edu.indiana.cs.b534.RayTraceURLResponse.MY_QNAME, factory));


            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private edu.indiana.cs.b534.RayTraceURLResponse wraprayTraceURL() {
        edu.indiana.cs.b534.RayTraceURLResponse wrappedElement = new edu.indiana.cs.b534.RayTraceURLResponse();
        return wrappedElement;
    }


    /**
     * get the default envelope
     */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }


    private java.lang.Object fromOM(
            org.apache.axiom.om.OMElement param,
            java.lang.Class type,
            java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault {

        try {

            if (edu.indiana.cs.b534.RayTrace.class.equals(type)) {

                return edu.indiana.cs.b534.RayTrace.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (edu.indiana.cs.b534.RayTraceResponse.class.equals(type)) {

                return edu.indiana.cs.b534.RayTraceResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (edu.indiana.cs.b534.RayTraceMovie.class.equals(type)) {

                return edu.indiana.cs.b534.RayTraceMovie.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (edu.indiana.cs.b534.RayTraceMovieResponse.class.equals(type)) {

                return edu.indiana.cs.b534.RayTraceMovieResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (edu.indiana.cs.b534.RayTraceSubView.class.equals(type)) {

                return edu.indiana.cs.b534.RayTraceSubView.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (edu.indiana.cs.b534.RayTraceSubViewResponse.class.equals(type)) {

                return edu.indiana.cs.b534.RayTraceSubViewResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (edu.indiana.cs.b534.RayTraceURL.class.equals(type)) {

                return edu.indiana.cs.b534.RayTraceURL.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (edu.indiana.cs.b534.RayTraceURLResponse.class.equals(type)) {

                return edu.indiana.cs.b534.RayTraceURLResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
        return null;
    }


    /**
     * A utility method that copies the namepaces from the SOAPEnvelope
     */
    private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env) {
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
            org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
            returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
        }
        return returnMap;
    }

    private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

}//end of class
    