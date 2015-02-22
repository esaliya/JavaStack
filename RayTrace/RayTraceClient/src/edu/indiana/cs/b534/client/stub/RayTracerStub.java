/**
 * RayTracerStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
package edu.indiana.cs.b534.client.stub;


/*
*  RayTracerStub java implementation
*/


public class RayTracerStub extends org.apache.axis2.client.Stub {
    protected org.apache.axis2.description.AxisOperation[] _operations;

    //hashmaps to keep the fault mapping
    private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
    private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
    private java.util.HashMap faultMessageMap = new java.util.HashMap();

    private static int counter = 0;

    private static synchronized java.lang.String getUniqueSuffix() {
        // reset the counter if it is greater than 99999
        if (counter > 99999) {
            counter = 0;
        }
        counter = counter + 1;
        return java.lang.Long.toString(System.currentTimeMillis()) + "_" + counter;
    }


    private void populateAxisService() throws org.apache.axis2.AxisFault {

        //creating the Service with a unique name
        _service = new org.apache.axis2.description.AxisService("RayTracer" + getUniqueSuffix());
        addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[4];

        __operation = new org.apache.axis2.description.OutInAxisOperation();


        __operation.setName(new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "rayTrace"));
        _service.addOperation(__operation);


        _operations[0] = __operation;


        __operation = new org.apache.axis2.description.OutInAxisOperation();


        __operation.setName(new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "rayTraceMovie"));
        _service.addOperation(__operation);


        _operations[1] = __operation;


        __operation = new org.apache.axis2.description.OutInAxisOperation();


        __operation.setName(new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "rayTraceSubView"));
        _service.addOperation(__operation);


        _operations[2] = __operation;


        __operation = new org.apache.axis2.description.OutInAxisOperation();


        __operation.setName(new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "rayTraceURL"));
        _service.addOperation(__operation);


        _operations[3] = __operation;


    }

    //populates the faults

    private void populateFaults() {


    }

    /**
     * Constructor that takes in a configContext
     */

    public RayTracerStub(org.apache.axis2.context.ConfigurationContext configurationContext,
                         java.lang.String targetEndpoint)
            throws org.apache.axis2.AxisFault {
        this(configurationContext, targetEndpoint, false);
    }


    /**
     * Constructor that takes in a configContext  and useseperate listner
     */
    public RayTracerStub(org.apache.axis2.context.ConfigurationContext configurationContext,
                         java.lang.String targetEndpoint, boolean useSeparateListener)
            throws org.apache.axis2.AxisFault {
        //To populate AxisService
        populateAxisService();
        populateFaults();

        _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext, _service);


        _serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(
                targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);


    }

    /**
     * Default Constructor
     */
    public RayTracerStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {

        this(configurationContext, "http://129.79.49.196:8080/axis2/services/RayTracer/");

    }

    /**
     * Default Constructor
     */
    public RayTracerStub() throws org.apache.axis2.AxisFault {

        this("http://129.79.49.196:8080/axis2/services/RayTracer/");

    }

    /**
     * Constructor taking the target endpoint
     */
    public RayTracerStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null, targetEndpoint);
    }


    /**
     * Auto generated method signature
     *
     * @param rayTrace0
     * @see edu.indiana.cs.b534.RayTracer#rayTrace
     */


    public RayTracerStub.RayTraceResponse rayTrace(

            RayTracerStub.RayTrace rayTrace0)


            throws java.rmi.RemoteException

    {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
            _operationClient.getOptions().setAction("urn:rayTrace");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


            addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");


            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();


            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;


            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                    rayTrace0,
                    optimizeContent(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                            "rayTrace")));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);


            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                    org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


            java.lang.Object object = fromOM(
                    _returnEnv.getBody().getFirstElement(),
                    RayTracerStub.RayTraceResponse.class,
                    getEnvelopeNamespaces(_returnEnv));


            return (RayTracerStub.RayTraceResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex =
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new java.lang.Class[]{messageClass});
                        m.invoke(ex, new java.lang.Object[]{messageObject});


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param rayTrace0
     * @see edu.indiana.cs.b534.client.stub.RayTracerStub.RayTracer#startrayTrace
     */
    public void startrayTrace(

            RayTracerStub.RayTrace rayTrace0,

            final RayTracerCallbackHandler callback)

            throws java.rmi.RemoteException {

        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
        _operationClient.getOptions().setAction("urn:rayTrace");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


        addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");


        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


        //Style is Doc.


        env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                rayTrace0,
                optimizeContent(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                        "rayTrace")));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                            RayTracerStub.RayTraceResponse.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultrayTrace(
                            (RayTracerStub.RayTraceResponse) object);

                } catch (org.apache.axis2.AxisFault e) {
                    callback.receiveErrorrayTrace(e);
                }
            }

            public void onError(java.lang.Exception error) {
                if (error instanceof org.apache.axis2.AxisFault) {
                    org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();
                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                            //make the fault by reflection
                            try {
                                java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
                                java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                                java.lang.Exception ex =
                                        (java.lang.Exception) exceptionClass.newInstance();
                                //message class
                                java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
                                java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                                java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new java.lang.Class[]{messageClass});
                                m.invoke(ex, new java.lang.Object[]{messageObject});


                                callback.receiveErrorrayTrace(new java.rmi.RemoteException(ex.getMessage(), ex));
                            } catch (java.lang.ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrayTrace(f);
                            } catch (java.lang.ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrayTrace(f);
                            } catch (java.lang.NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrayTrace(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrayTrace(f);
                            } catch (java.lang.IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrayTrace(f);
                            } catch (java.lang.InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrayTrace(f);
                            } catch (org.apache.axis2.AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrayTrace(f);
                            }
                        } else {
                            callback.receiveErrorrayTrace(f);
                        }
                    } else {
                        callback.receiveErrorrayTrace(f);
                    }
                } else {
                    callback.receiveErrorrayTrace(error);
                }
            }

            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                } catch (org.apache.axis2.AxisFault axisFault) {
                    callback.receiveErrorrayTrace(axisFault);
                }
            }
        });


        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if (_operations[0].getMessageReceiver() == null && _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[0].setMessageReceiver(
                    _callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);

    }

    /**
     * Auto generated method signature
     *
     * @param rayTraceMovie2
     * @see edu.indiana.cs.b534.RayTracer#rayTraceMovie
     */


    public RayTracerStub.RayTraceMovieResponse rayTraceMovie(

            RayTracerStub.RayTraceMovie rayTraceMovie2)


            throws java.rmi.RemoteException

    {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
            _operationClient.getOptions().setAction("urn:rayTraceMovie");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


            addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");


            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();


            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;


            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                    rayTraceMovie2,
                    optimizeContent(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                            "rayTraceMovie")));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);


            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                    org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


            java.lang.Object object = fromOM(
                    _returnEnv.getBody().getFirstElement(),
                    RayTracerStub.RayTraceMovieResponse.class,
                    getEnvelopeNamespaces(_returnEnv));


            return (RayTracerStub.RayTraceMovieResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex =
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new java.lang.Class[]{messageClass});
                        m.invoke(ex, new java.lang.Object[]{messageObject});


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param rayTraceMovie2
     * @see edu.indiana.cs.b534.RayTracer#startrayTraceMovie
     */
    public void startrayTraceMovie(

            RayTracerStub.RayTraceMovie rayTraceMovie2,

            final RayTracerCallbackHandler callback)

            throws java.rmi.RemoteException {

        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
        _operationClient.getOptions().setAction("urn:rayTraceMovie");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


        addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");


        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


        //Style is Doc.


        env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                rayTraceMovie2,
                optimizeContent(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                        "rayTraceMovie")));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                            RayTracerStub.RayTraceMovieResponse.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultrayTraceMovie(
                            (RayTracerStub.RayTraceMovieResponse) object);

                } catch (org.apache.axis2.AxisFault e) {
                    callback.receiveErrorrayTraceMovie(e);
                }
            }

            public void onError(java.lang.Exception error) {
                if (error instanceof org.apache.axis2.AxisFault) {
                    org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();
                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                            //make the fault by reflection
                            try {
                                java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
                                java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                                java.lang.Exception ex =
                                        (java.lang.Exception) exceptionClass.newInstance();
                                //message class
                                java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
                                java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                                java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new java.lang.Class[]{messageClass});
                                m.invoke(ex, new java.lang.Object[]{messageObject});


                                callback.receiveErrorrayTraceMovie(new java.rmi.RemoteException(ex.getMessage(), ex));
                            } catch (java.lang.ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrayTraceMovie(f);
                            } catch (java.lang.ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrayTraceMovie(f);
                            } catch (java.lang.NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrayTraceMovie(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrayTraceMovie(f);
                            } catch (java.lang.IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrayTraceMovie(f);
                            } catch (java.lang.InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrayTraceMovie(f);
                            } catch (org.apache.axis2.AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrayTraceMovie(f);
                            }
                        } else {
                            callback.receiveErrorrayTraceMovie(f);
                        }
                    } else {
                        callback.receiveErrorrayTraceMovie(f);
                    }
                } else {
                    callback.receiveErrorrayTraceMovie(error);
                }
            }

            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                } catch (org.apache.axis2.AxisFault axisFault) {
                    callback.receiveErrorrayTraceMovie(axisFault);
                }
            }
        });


        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if (_operations[1].getMessageReceiver() == null && _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[1].setMessageReceiver(
                    _callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);

    }

    /**
     * Auto generated method signature
     *
     * @param rayTraceSubView4
     * @see edu.indiana.cs.b534.RayTracer#rayTraceSubView
     */


    public RayTracerStub.RayTraceSubViewResponse rayTraceSubView(

            RayTracerStub.RayTraceSubView rayTraceSubView4)


            throws java.rmi.RemoteException

    {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
            _operationClient.getOptions().setAction("urn:rayTraceSubView");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


            addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");


            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();


            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;


            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                    rayTraceSubView4,
                    optimizeContent(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                            "rayTraceSubView")));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);


            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                    org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


            java.lang.Object object = fromOM(
                    _returnEnv.getBody().getFirstElement(),
                    RayTracerStub.RayTraceSubViewResponse.class,
                    getEnvelopeNamespaces(_returnEnv));


            return (RayTracerStub.RayTraceSubViewResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex =
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new java.lang.Class[]{messageClass});
                        m.invoke(ex, new java.lang.Object[]{messageObject});


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param rayTraceSubView4
     * @see edu.indiana.cs.b534.RayTracer#startrayTraceSubView
     */
    public void startrayTraceSubView(

            RayTracerStub.RayTraceSubView rayTraceSubView4,

            final RayTracerCallbackHandler callback)

            throws java.rmi.RemoteException {

        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
        _operationClient.getOptions().setAction("urn:rayTraceSubView");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


        addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");


        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


        //Style is Doc.


        env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                rayTraceSubView4,
                optimizeContent(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                        "rayTraceSubView")));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                            RayTracerStub.RayTraceSubViewResponse.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultrayTraceSubView(
                            (RayTracerStub.RayTraceSubViewResponse) object);

                } catch (org.apache.axis2.AxisFault e) {
                    callback.receiveErrorrayTraceSubView(e);
                }
            }

            public void onError(java.lang.Exception error) {
                if (error instanceof org.apache.axis2.AxisFault) {
                    org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();
                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                            //make the fault by reflection
                            try {
                                java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
                                java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                                java.lang.Exception ex =
                                        (java.lang.Exception) exceptionClass.newInstance();
                                //message class
                                java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
                                java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                                java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new java.lang.Class[]{messageClass});
                                m.invoke(ex, new java.lang.Object[]{messageObject});


                                callback.receiveErrorrayTraceSubView(new java.rmi.RemoteException(ex.getMessage(), ex));
                            } catch (java.lang.ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrayTraceSubView(f);
                            } catch (java.lang.ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrayTraceSubView(f);
                            } catch (java.lang.NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrayTraceSubView(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrayTraceSubView(f);
                            } catch (java.lang.IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrayTraceSubView(f);
                            } catch (java.lang.InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrayTraceSubView(f);
                            } catch (org.apache.axis2.AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrayTraceSubView(f);
                            }
                        } else {
                            callback.receiveErrorrayTraceSubView(f);
                        }
                    } else {
                        callback.receiveErrorrayTraceSubView(f);
                    }
                } else {
                    callback.receiveErrorrayTraceSubView(error);
                }
            }

            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                } catch (org.apache.axis2.AxisFault axisFault) {
                    callback.receiveErrorrayTraceSubView(axisFault);
                }
            }
        });


        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if (_operations[2].getMessageReceiver() == null && _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[2].setMessageReceiver(
                    _callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);

    }

    /**
     * Auto generated method signature
     *
     * @param rayTraceURL6
     * @see edu.indiana.cs.b534.RayTracer#rayTraceURL
     */


    public RayTracerStub.RayTraceURLResponse rayTraceURL(

            RayTracerStub.RayTraceURL rayTraceURL6)


            throws java.rmi.RemoteException

    {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[3].getName());
            _operationClient.getOptions().setAction("urn:rayTraceURL");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


            addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");


            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();


            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;


            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                    rayTraceURL6,
                    optimizeContent(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                            "rayTraceURL")));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);


            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                    org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


            java.lang.Object object = fromOM(
                    _returnEnv.getBody().getFirstElement(),
                    RayTracerStub.RayTraceURLResponse.class,
                    getEnvelopeNamespaces(_returnEnv));


            return (RayTracerStub.RayTraceURLResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex =
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new java.lang.Class[]{messageClass});
                        m.invoke(ex, new java.lang.Object[]{messageObject});


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param rayTraceURL6
     * @see edu.indiana.cs.b534.RayTracer#startrayTraceURL
     */
    public void startrayTraceURL(

            RayTracerStub.RayTraceURL rayTraceURL6,

            final RayTracerCallbackHandler callback)

            throws java.rmi.RemoteException {

        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[3].getName());
        _operationClient.getOptions().setAction("urn:rayTraceURL");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


        addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");


        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


        //Style is Doc.


        env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                rayTraceURL6,
                optimizeContent(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                        "rayTraceURL")));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                            RayTracerStub.RayTraceURLResponse.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultrayTraceURL(
                            (RayTracerStub.RayTraceURLResponse) object);

                } catch (org.apache.axis2.AxisFault e) {
                    callback.receiveErrorrayTraceURL(e);
                }
            }

            public void onError(java.lang.Exception error) {
                if (error instanceof org.apache.axis2.AxisFault) {
                    org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();
                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                            //make the fault by reflection
                            try {
                                java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
                                java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                                java.lang.Exception ex =
                                        (java.lang.Exception) exceptionClass.newInstance();
                                //message class
                                java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
                                java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                                java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new java.lang.Class[]{messageClass});
                                m.invoke(ex, new java.lang.Object[]{messageObject});


                                callback.receiveErrorrayTraceURL(new java.rmi.RemoteException(ex.getMessage(), ex));
                            } catch (java.lang.ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrayTraceURL(f);
                            } catch (java.lang.ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrayTraceURL(f);
                            } catch (java.lang.NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrayTraceURL(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrayTraceURL(f);
                            } catch (java.lang.IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrayTraceURL(f);
                            } catch (java.lang.InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrayTraceURL(f);
                            } catch (org.apache.axis2.AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrayTraceURL(f);
                            }
                        } else {
                            callback.receiveErrorrayTraceURL(f);
                        }
                    } else {
                        callback.receiveErrorrayTraceURL(f);
                    }
                } else {
                    callback.receiveErrorrayTraceURL(error);
                }
            }

            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                } catch (org.apache.axis2.AxisFault axisFault) {
                    callback.receiveErrorrayTraceURL(axisFault);
                }
            }
        });


        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if (_operations[3].getMessageReceiver() == null && _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[3].setMessageReceiver(
                    _callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);

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


    private javax.xml.namespace.QName[] opNameArray = null;

    private boolean optimizeContent(javax.xml.namespace.QName opName) {


        if (opNameArray == null) {
            return false;
        }
        for (int i = 0; i < opNameArray.length; i++) {
            if (opName.equals(opNameArray[i])) {
                return true;
            }
        }
        return false;
    }
    //http://129.79.49.196:8080/axis2/services/RayTracer/

    public static class RayTraceURLResponse
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://b534.cs.indiana.edu",
                "rayTraceURLResponse",
                "ns1");


        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://b534.cs.indiana.edu")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }


        /**
         * field for ImageURL
         */


        protected java.lang.String localImageURL;

        /*  This tracker boolean wil be used to detect whether the user called the set method
       *   for this attribute. It will be used to determine whether to include this field
        *   in the serialized XML
        */
        protected boolean localImageURLTracker = false;


        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public java.lang.String getImageURL() {
            return localImageURL;
        }


        /**
         * Auto generated setter method
         *
         * @param param ImageURL
         */
        public void setImageURL(java.lang.String param) {

            if (param != null) {
                //update the setting tracker
                localImageURLTracker = true;
            } else {
                localImageURLTracker = true;

            }

            this.localImageURL = param;


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
                            RayTraceURLResponse.this.serialize(MY_QNAME, factory, xmlWriter);
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
                            namespacePrefix + ":rayTraceURLResponse",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "rayTraceURLResponse",
                            xmlWriter);
                }


            }
            if (localImageURLTracker) {
                namespace = "http://b534.cs.indiana.edu";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "imageURL", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "imageURL");
                    }

                } else {
                    xmlWriter.writeStartElement("imageURL");
                }


                if (localImageURL == null) {
                    // write the nil attribute

                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

                } else {


                    xmlWriter.writeCharacters(localImageURL);

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

            if (localImageURLTracker) {
                elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                        "imageURL"));

                elementList.add(localImageURL == null ? null :
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localImageURL));
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
            public static RayTraceURLResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                RayTraceURLResponse object =
                        new RayTraceURLResponse();

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

                            if (!"rayTraceURLResponse".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (RayTraceURLResponse) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "imageURL").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setImageURL(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

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


    public static class Point3D
            implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
                name = Point3D
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
         * field for X
         */


        protected double localX;

        /*  This tracker boolean wil be used to detect whether the user called the set method
       *   for this attribute. It will be used to determine whether to include this field
        *   in the serialized XML
        */
        protected boolean localXTracker = false;


        /**
         * Auto generated getter method
         *
         * @return double
         */
        public double getX() {
            return localX;
        }


        /**
         * Auto generated setter method
         *
         * @param param X
         */
        public void setX(double param) {

            // setting primitive attribute tracker to true

            if (java.lang.Double.isNaN(param)) {
                localXTracker = false;

            } else {
                localXTracker = true;
            }

            this.localX = param;


        }


        /**
         * field for Y
         */


        protected double localY;

        /*  This tracker boolean wil be used to detect whether the user called the set method
       *   for this attribute. It will be used to determine whether to include this field
        *   in the serialized XML
        */
        protected boolean localYTracker = false;


        /**
         * Auto generated getter method
         *
         * @return double
         */
        public double getY() {
            return localY;
        }


        /**
         * Auto generated setter method
         *
         * @param param Y
         */
        public void setY(double param) {

            // setting primitive attribute tracker to true

            if (java.lang.Double.isNaN(param)) {
                localYTracker = false;

            } else {
                localYTracker = true;
            }

            this.localY = param;


        }


        /**
         * field for Z
         */


        protected double localZ;

        /*  This tracker boolean wil be used to detect whether the user called the set method
       *   for this attribute. It will be used to determine whether to include this field
        *   in the serialized XML
        */
        protected boolean localZTracker = false;


        /**
         * Auto generated getter method
         *
         * @return double
         */
        public double getZ() {
            return localZ;
        }


        /**
         * Auto generated setter method
         *
         * @param param Z
         */
        public void setZ(double param) {

            // setting primitive attribute tracker to true

            if (java.lang.Double.isNaN(param)) {
                localZTracker = false;

            } else {
                localZTracker = true;
            }

            this.localZ = param;


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
                            Point3D.this.serialize(parentQName, factory, xmlWriter);
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
                            namespacePrefix + ":Point3D",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "Point3D",
                            xmlWriter);
                }


            }
            if (localXTracker) {
                namespace = "http://b534.cs.indiana.edu";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "x", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "x");
                    }

                } else {
                    xmlWriter.writeStartElement("x");
                }

                if (java.lang.Double.isNaN(localX)) {

                    throw new org.apache.axis2.databinding.ADBException("x cannot be null!!");

                } else {
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localX));
                }

                xmlWriter.writeEndElement();
            }
            if (localYTracker) {
                namespace = "http://b534.cs.indiana.edu";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "y", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "y");
                    }

                } else {
                    xmlWriter.writeStartElement("y");
                }

                if (java.lang.Double.isNaN(localY)) {

                    throw new org.apache.axis2.databinding.ADBException("y cannot be null!!");

                } else {
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localY));
                }

                xmlWriter.writeEndElement();
            }
            if (localZTracker) {
                namespace = "http://b534.cs.indiana.edu";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "z", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "z");
                    }

                } else {
                    xmlWriter.writeStartElement("z");
                }

                if (java.lang.Double.isNaN(localZ)) {

                    throw new org.apache.axis2.databinding.ADBException("z cannot be null!!");

                } else {
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localZ));
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

            if (localXTracker) {
                elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                        "x"));

                elementList.add(
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localX));
            }
            if (localYTracker) {
                elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                        "y"));

                elementList.add(
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localY));
            }
            if (localZTracker) {
                elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                        "z"));

                elementList.add(
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localZ));
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
            public static Point3D parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                Point3D object =
                        new Point3D();

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

                            if (!"Point3D".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (Point3D) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "x").equals(reader.getName())) {

                        java.lang.String content = reader.getElementText();

                        object.setX(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                        object.setX(java.lang.Double.NaN);

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "y").equals(reader.getName())) {

                        java.lang.String content = reader.getElementText();

                        object.setY(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                        object.setY(java.lang.Double.NaN);

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "z").equals(reader.getName())) {

                        java.lang.String content = reader.getElementText();

                        object.setZ(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                        object.setZ(java.lang.Double.NaN);

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


    public static class RayTraceMovieResponse
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://b534.cs.indiana.edu",
                "rayTraceMovieResponse",
                "ns1");


        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://b534.cs.indiana.edu")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }


        /**
         * field for ImageURL
         * This was an Array!
         */


        protected java.lang.String[] localImageURL;

        /*  This tracker boolean wil be used to detect whether the user called the set method
       *   for this attribute. It will be used to determine whether to include this field
        *   in the serialized XML
        */
        protected boolean localImageURLTracker = false;


        /**
         * Auto generated getter method
         *
         * @return java.lang.String[]
         */
        public java.lang.String[] getImageURL() {
            return localImageURL;
        }


        /**
         * validate the array for ImageURL
         */
        protected void validateImageURL(java.lang.String[] param) {

        }


        /**
         * Auto generated setter method
         *
         * @param param ImageURL
         */
        public void setImageURL(java.lang.String[] param) {

            validateImageURL(param);


            if (param != null) {
                //update the setting tracker
                localImageURLTracker = true;
            } else {
                localImageURLTracker = true;

            }

            this.localImageURL = param;
        }


        /**
         * Auto generated add method for the array for convenience
         *
         * @param param java.lang.String
         */
        public void addImageURL(java.lang.String param) {
            if (localImageURL == null) {
                localImageURL = new java.lang.String[]{};
            }


            //update the setting tracker
            localImageURLTracker = true;


            java.util.List list =
                    org.apache.axis2.databinding.utils.ConverterUtil.toList(localImageURL);
            list.add(param);
            this.localImageURL =
                    (java.lang.String[]) list.toArray(
                            new java.lang.String[list.size()]);

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
                            RayTraceMovieResponse.this.serialize(MY_QNAME, factory, xmlWriter);
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
                            namespacePrefix + ":rayTraceMovieResponse",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "rayTraceMovieResponse",
                            xmlWriter);
                }


            }
            if (localImageURLTracker) {
                if (localImageURL != null) {
                    namespace = "http://b534.cs.indiana.edu";
                    boolean emptyNamespace = namespace == null || namespace.length() == 0;
                    prefix = emptyNamespace ? null : xmlWriter.getPrefix(namespace);
                    for (int i = 0; i < localImageURL.length; i++) {

                        if (localImageURL[i] != null) {

                            if (!emptyNamespace) {
                                if (prefix == null) {
                                    java.lang.String prefix2 = generatePrefix(namespace);

                                    xmlWriter.writeStartElement(prefix2, "ImageURL", namespace);
                                    xmlWriter.writeNamespace(prefix2, namespace);
                                    xmlWriter.setPrefix(prefix2, namespace);

                                } else {
                                    xmlWriter.writeStartElement(namespace, "ImageURL");
                                }

                            } else {
                                xmlWriter.writeStartElement("ImageURL");
                            }


                            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localImageURL[i]));

                            xmlWriter.writeEndElement();

                        } else {

                            // write null attribute
                            namespace = "http://b534.cs.indiana.edu";
                            if (!namespace.equals("")) {
                                prefix = xmlWriter.getPrefix(namespace);

                                if (prefix == null) {
                                    prefix = generatePrefix(namespace);

                                    xmlWriter.writeStartElement(prefix, "ImageURL", namespace);
                                    xmlWriter.writeNamespace(prefix, namespace);
                                    xmlWriter.setPrefix(prefix, namespace);

                                } else {
                                    xmlWriter.writeStartElement(namespace, "ImageURL");
                                }

                            } else {
                                xmlWriter.writeStartElement("ImageURL");
                            }
                            writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                            xmlWriter.writeEndElement();

                        }

                    }
                } else {

                    // write the null attribute
                    // write null attribute
                    java.lang.String namespace2 = "http://b534.cs.indiana.edu";
                    if (!namespace2.equals("")) {
                        java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                        if (prefix2 == null) {
                            prefix2 = generatePrefix(namespace2);

                            xmlWriter.writeStartElement(prefix2, "ImageURL", namespace2);
                            xmlWriter.writeNamespace(prefix2, namespace2);
                            xmlWriter.setPrefix(prefix2, namespace2);

                        } else {
                            xmlWriter.writeStartElement(namespace2, "ImageURL");
                        }

                    } else {
                        xmlWriter.writeStartElement("ImageURL");
                    }

                    // write the nil attribute
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                    xmlWriter.writeEndElement();

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

            if (localImageURLTracker) {
                if (localImageURL != null) {
                    for (int i = 0; i < localImageURL.length; i++) {

                        if (localImageURL[i] != null) {
                            elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                                    "ImageURL"));
                            elementList.add(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localImageURL[i]));
                        } else {

                            elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                                    "ImageURL"));
                            elementList.add(null);

                        }


                    }
                } else {

                    elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                            "ImageURL"));
                    elementList.add(null);

                }

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
            public static RayTraceMovieResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                RayTraceMovieResponse object =
                        new RayTraceMovieResponse();

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

                            if (!"rayTraceMovieResponse".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (RayTraceMovieResponse) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();

                    java.util.ArrayList list1 = new java.util.ArrayList();


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "ImageURL").equals(reader.getName())) {


                        // Process the array and step past its final element's end.

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            list1.add(null);

                            reader.next();
                        } else {
                            list1.add(reader.getElementText());
                        }
                        //loop until we find a start element that is not part of this array
                        boolean loopDone1 = false;
                        while (!loopDone1) {
                            // Ensure we are at the EndElement
                            while (!reader.isEndElement()) {
                                reader.next();
                            }
                            // Step out of this element
                            reader.next();
                            // Step to next element event.
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            if (reader.isEndElement()) {
                                //two continuous end elements means we are exiting the xml structure
                                loopDone1 = true;
                            } else {
                                if (new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "ImageURL").equals(reader.getName())) {

                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                        list1.add(null);

                                        reader.next();
                                    } else {
                                        list1.add(reader.getElementText());
                                    }
                                } else {
                                    loopDone1 = true;
                                }
                            }
                        }
                        // call the converter utility  to convert and set the array

                        object.setImageURL((java.lang.String[])
                                list1.toArray(new java.lang.String[list1.size()]));

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


    public static class RayTrace
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://b534.cs.indiana.edu",
                "rayTrace",
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


        protected CameraSetup localCamera;

        /*  This tracker boolean wil be used to detect whether the user called the set method
       *   for this attribute. It will be used to determine whether to include this field
        *   in the serialized XML
        */
        protected boolean localCameraTracker = false;


        /**
         * Auto generated getter method
         *
         * @return CameraSetup
         */
        public CameraSetup getCamera() {
            return localCamera;
        }


        /**
         * Auto generated setter method
         *
         * @param param Camera
         */
        public void setCamera(CameraSetup param) {

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
                            RayTrace.this.serialize(MY_QNAME, factory, xmlWriter);
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
                            namespacePrefix + ":rayTrace",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "rayTrace",
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
            public static RayTrace parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                RayTrace object =
                        new RayTrace();

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

                            if (!"rayTrace".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (RayTrace) ExtensionMapper.getTypeObject(
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

                            object.setCamera(CameraSetup.Factory.parse(reader));

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


    public static class Rectangle
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
                                return (Rectangle) ExtensionMapper.getTypeObject(
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


    public static class RayTraceURL
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://b534.cs.indiana.edu",
                "rayTraceURL",
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


        protected CameraSetup localCamera;

        /*  This tracker boolean wil be used to detect whether the user called the set method
       *   for this attribute. It will be used to determine whether to include this field
        *   in the serialized XML
        */
        protected boolean localCameraTracker = false;


        /**
         * Auto generated getter method
         *
         * @return CameraSetup
         */
        public CameraSetup getCamera() {
            return localCamera;
        }


        /**
         * Auto generated setter method
         *
         * @param param Camera
         */
        public void setCamera(CameraSetup param) {

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
                            RayTraceURL.this.serialize(MY_QNAME, factory, xmlWriter);
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
                            namespacePrefix + ":rayTraceURL",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "rayTraceURL",
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
            public static RayTraceURL parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                RayTraceURL object =
                        new RayTraceURL();

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

                            if (!"rayTraceURL".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (RayTraceURL) ExtensionMapper.getTypeObject(
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

                            object.setCamera(CameraSetup.Factory.parse(reader));

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


    public static class RayTraceSubViewResponse
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://b534.cs.indiana.edu",
                "rayTraceSubViewResponse",
                "ns1");


        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://b534.cs.indiana.edu")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }


        /**
         * field for ImageURL
         */


        protected java.lang.String localImageURL;

        /*  This tracker boolean wil be used to detect whether the user called the set method
       *   for this attribute. It will be used to determine whether to include this field
        *   in the serialized XML
        */
        protected boolean localImageURLTracker = false;


        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public java.lang.String getImageURL() {
            return localImageURL;
        }


        /**
         * Auto generated setter method
         *
         * @param param ImageURL
         */
        public void setImageURL(java.lang.String param) {

            if (param != null) {
                //update the setting tracker
                localImageURLTracker = true;
            } else {
                localImageURLTracker = true;

            }

            this.localImageURL = param;


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
                            RayTraceSubViewResponse.this.serialize(MY_QNAME, factory, xmlWriter);
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
                            namespacePrefix + ":rayTraceSubViewResponse",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "rayTraceSubViewResponse",
                            xmlWriter);
                }


            }
            if (localImageURLTracker) {
                namespace = "http://b534.cs.indiana.edu";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "imageURL", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "imageURL");
                    }

                } else {
                    xmlWriter.writeStartElement("imageURL");
                }


                if (localImageURL == null) {
                    // write the nil attribute

                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

                } else {


                    xmlWriter.writeCharacters(localImageURL);

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

            if (localImageURLTracker) {
                elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                        "imageURL"));

                elementList.add(localImageURL == null ? null :
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localImageURL));
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
            public static RayTraceSubViewResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                RayTraceSubViewResponse object =
                        new RayTraceSubViewResponse();

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

                            if (!"rayTraceSubViewResponse".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (RayTraceSubViewResponse) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "imageURL").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setImageURL(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

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


    public static class ArrayOfRGBColor
            implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
                name = ArrayOfRGBColor
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
         * field for Array
         * This was an Array!
         */


        protected RGBColor[] localArray;

        /*  This tracker boolean wil be used to detect whether the user called the set method
       *   for this attribute. It will be used to determine whether to include this field
        *   in the serialized XML
        */
        protected boolean localArrayTracker = false;


        /**
         * Auto generated getter method
         *
         * @return RGBColor[]
         */
        public RGBColor[] getArray() {
            return localArray;
        }


        /**
         * validate the array for Array
         */
        protected void validateArray(RGBColor[] param) {

        }


        /**
         * Auto generated setter method
         *
         * @param param Array
         */
        public void setArray(RGBColor[] param) {

            validateArray(param);


            if (param != null) {
                //update the setting tracker
                localArrayTracker = true;
            } else {
                localArrayTracker = true;

            }

            this.localArray = param;
        }


        /**
         * Auto generated add method for the array for convenience
         *
         * @param param RGBColor
         */
        public void addArray(RGBColor param) {
            if (localArray == null) {
                localArray = new RGBColor[]{};
            }


            //update the setting tracker
            localArrayTracker = true;


            java.util.List list =
                    org.apache.axis2.databinding.utils.ConverterUtil.toList(localArray);
            list.add(param);
            this.localArray =
                    (RGBColor[]) list.toArray(
                            new RGBColor[list.size()]);

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
                            ArrayOfRGBColor.this.serialize(parentQName, factory, xmlWriter);
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
                            namespacePrefix + ":ArrayOfRGBColor",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "ArrayOfRGBColor",
                            xmlWriter);
                }


            }
            if (localArrayTracker) {
                if (localArray != null) {
                    for (int i = 0; i < localArray.length; i++) {
                        if (localArray[i] != null) {
                            localArray[i].serialize(new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "array"),
                                    factory, xmlWriter);
                        } else {

                            // write null attribute
                            java.lang.String namespace2 = "http://b534.cs.indiana.edu";
                            if (!namespace2.equals("")) {
                                java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                if (prefix2 == null) {
                                    prefix2 = generatePrefix(namespace2);

                                    xmlWriter.writeStartElement(prefix2, "array", namespace2);
                                    xmlWriter.writeNamespace(prefix2, namespace2);
                                    xmlWriter.setPrefix(prefix2, namespace2);

                                } else {
                                    xmlWriter.writeStartElement(namespace2, "array");
                                }

                            } else {
                                xmlWriter.writeStartElement("array");
                            }

                            // write the nil attribute
                            writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                            xmlWriter.writeEndElement();

                        }

                    }
                } else {

                    // write null attribute
                    java.lang.String namespace2 = "http://b534.cs.indiana.edu";
                    if (!namespace2.equals("")) {
                        java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                        if (prefix2 == null) {
                            prefix2 = generatePrefix(namespace2);

                            xmlWriter.writeStartElement(prefix2, "array", namespace2);
                            xmlWriter.writeNamespace(prefix2, namespace2);
                            xmlWriter.setPrefix(prefix2, namespace2);

                        } else {
                            xmlWriter.writeStartElement(namespace2, "array");
                        }

                    } else {
                        xmlWriter.writeStartElement("array");
                    }

                    // write the nil attribute
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                    xmlWriter.writeEndElement();

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

            if (localArrayTracker) {
                if (localArray != null) {
                    for (int i = 0; i < localArray.length; i++) {

                        if (localArray[i] != null) {
                            elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                                    "array"));
                            elementList.add(localArray[i]);
                        } else {

                            elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                                    "array"));
                            elementList.add(null);

                        }

                    }
                } else {

                    elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                            "array"));
                    elementList.add(localArray);

                }

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
            public static ArrayOfRGBColor parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                ArrayOfRGBColor object =
                        new ArrayOfRGBColor();

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

                            if (!"ArrayOfRGBColor".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ArrayOfRGBColor) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();

                    java.util.ArrayList list1 = new java.util.ArrayList();


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "array").equals(reader.getName())) {


                        // Process the array and step past its final element's end.

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            list1.add(null);
                            reader.next();
                        } else {
                            list1.add(RGBColor.Factory.parse(reader));
                        }
                        //loop until we find a start element that is not part of this array
                        boolean loopDone1 = false;
                        while (!loopDone1) {
                            // We should be at the end element, but make sure
                            while (!reader.isEndElement())
                                reader.next();
                            // Step out of this element
                            reader.next();
                            // Step to next element event.
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            if (reader.isEndElement()) {
                                //two continuous end elements means we are exiting the xml structure
                                loopDone1 = true;
                            } else {
                                if (new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "array").equals(reader.getName())) {

                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                        list1.add(null);
                                        reader.next();
                                    } else {
                                        list1.add(RGBColor.Factory.parse(reader));
                                    }
                                } else {
                                    loopDone1 = true;
                                }
                            }
                        }
                        // call the converter utility  to convert and set the array

                        object.setArray((RGBColor[])
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                        RGBColor.class,
                                        list1));

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


    public static class RGBColor
            implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
                name = RGBColor
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
         * field for Blue
         */


        protected double localBlue;

        /*  This tracker boolean wil be used to detect whether the user called the set method
       *   for this attribute. It will be used to determine whether to include this field
        *   in the serialized XML
        */
        protected boolean localBlueTracker = false;


        /**
         * Auto generated getter method
         *
         * @return double
         */
        public double getBlue() {
            return localBlue;
        }


        /**
         * Auto generated setter method
         *
         * @param param Blue
         */
        public void setBlue(double param) {

            // setting primitive attribute tracker to true

            if (java.lang.Double.isNaN(param)) {
                localBlueTracker = true;

            } else {
                localBlueTracker = true;
            }

            this.localBlue = param;


        }


        /**
         * field for Green
         */


        protected double localGreen;

        /*  This tracker boolean wil be used to detect whether the user called the set method
       *   for this attribute. It will be used to determine whether to include this field
        *   in the serialized XML
        */
        protected boolean localGreenTracker = false;


        /**
         * Auto generated getter method
         *
         * @return double
         */
        public double getGreen() {
            return localGreen;
        }


        /**
         * Auto generated setter method
         *
         * @param param Green
         */
        public void setGreen(double param) {

            // setting primitive attribute tracker to true

            if (java.lang.Double.isNaN(param)) {
                localGreenTracker = true;

            } else {
                localGreenTracker = true;
            }

            this.localGreen = param;


        }


        /**
         * field for Red
         */


        protected double localRed;

        /*  This tracker boolean wil be used to detect whether the user called the set method
       *   for this attribute. It will be used to determine whether to include this field
        *   in the serialized XML
        */
        protected boolean localRedTracker = false;


        /**
         * Auto generated getter method
         *
         * @return double
         */
        public double getRed() {
            return localRed;
        }


        /**
         * Auto generated setter method
         *
         * @param param Red
         */
        public void setRed(double param) {

            // setting primitive attribute tracker to true

            if (java.lang.Double.isNaN(param)) {
                localRedTracker = true;

            } else {
                localRedTracker = true;
            }

            this.localRed = param;


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
                            RGBColor.this.serialize(parentQName, factory, xmlWriter);
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
                            namespacePrefix + ":RGBColor",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "RGBColor",
                            xmlWriter);
                }


            }
            if (localBlueTracker) {
                namespace = "http://b534.cs.indiana.edu";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "blue", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "blue");
                    }

                } else {
                    xmlWriter.writeStartElement("blue");
                }

                if (java.lang.Double.isNaN(localBlue)) {

                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

                } else {
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBlue));
                }

                xmlWriter.writeEndElement();
            }
            if (localGreenTracker) {
                namespace = "http://b534.cs.indiana.edu";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "green", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "green");
                    }

                } else {
                    xmlWriter.writeStartElement("green");
                }

                if (java.lang.Double.isNaN(localGreen)) {

                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

                } else {
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGreen));
                }

                xmlWriter.writeEndElement();
            }
            if (localRedTracker) {
                namespace = "http://b534.cs.indiana.edu";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "red", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "red");
                    }

                } else {
                    xmlWriter.writeStartElement("red");
                }

                if (java.lang.Double.isNaN(localRed)) {

                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

                } else {
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRed));
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

            if (localBlueTracker) {
                elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                        "blue"));

                elementList.add(
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBlue));
            }
            if (localGreenTracker) {
                elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                        "green"));

                elementList.add(
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGreen));
            }
            if (localRedTracker) {
                elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                        "red"));

                elementList.add(
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRed));
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
            public static RGBColor parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                RGBColor object =
                        new RGBColor();

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

                            if (!"RGBColor".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (RGBColor) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "blue").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setBlue(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

                        } else {


                            object.setBlue(java.lang.Double.NaN);

                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                        object.setBlue(java.lang.Double.NaN);

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "green").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setGreen(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

                        } else {


                            object.setGreen(java.lang.Double.NaN);

                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                        object.setGreen(java.lang.Double.NaN);

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "red").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setRed(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

                        } else {


                            object.setRed(java.lang.Double.NaN);

                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                        object.setRed(java.lang.Double.NaN);

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


    public static class ExtensionMapper {

        public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                     java.lang.String typeName,
                                                     javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {


            if (
                    "http://b534.cs.indiana.edu".equals(namespaceURI) &&
                            "Point3D".equals(typeName)) {

                return Point3D.Factory.parse(reader);


            }


            if (
                    "http://b534.cs.indiana.edu".equals(namespaceURI) &&
                            "ArrayOfRGBColor".equals(typeName)) {

                return ArrayOfRGBColor.Factory.parse(reader);


            }


            if (
                    "http://b534.cs.indiana.edu".equals(namespaceURI) &&
                            "RGBColor".equals(typeName)) {

                return RGBColor.Factory.parse(reader);


            }


            if (
                    "http://b534.cs.indiana.edu".equals(namespaceURI) &&
                            "Rectangle".equals(typeName)) {

                return Rectangle.Factory.parse(reader);


            }


            if (
                    "http://b534.cs.indiana.edu".equals(namespaceURI) &&
                            "CameraSetup".equals(typeName)) {

                return CameraSetup.Factory.parse(reader);


            }


            throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
        }

    }

    public static class RayTraceSubView
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


        protected CameraSetup localCamera;

        /*  This tracker boolean wil be used to detect whether the user called the set method
       *   for this attribute. It will be used to determine whether to include this field
        *   in the serialized XML
        */
        protected boolean localCameraTracker = false;


        /**
         * Auto generated getter method
         *
         * @return CameraSetup
         */
        public CameraSetup getCamera() {
            return localCamera;
        }


        /**
         * Auto generated setter method
         *
         * @param param Camera
         */
        public void setCamera(CameraSetup param) {

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


        protected Rectangle localSubView;

        /*  This tracker boolean wil be used to detect whether the user called the set method
       *   for this attribute. It will be used to determine whether to include this field
        *   in the serialized XML
        */
        protected boolean localSubViewTracker = false;


        /**
         * Auto generated getter method
         *
         * @return Rectangle
         */
        public Rectangle getSubView() {
            return localSubView;
        }


        /**
         * Auto generated setter method
         *
         * @param param SubView
         */
        public void setSubView(Rectangle param) {

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
                                return (RayTraceSubView) ExtensionMapper.getTypeObject(
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

                            object.setCamera(CameraSetup.Factory.parse(reader));

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

                            object.setSubView(Rectangle.Factory.parse(reader));

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


    public static class RayTraceResponse
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://b534.cs.indiana.edu",
                "rayTraceResponse",
                "ns1");


        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://b534.cs.indiana.edu")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }


        /**
         * field for _return
         * This was an Array!
         */


        protected ArrayOfRGBColor[] local_return;

        /*  This tracker boolean wil be used to detect whether the user called the set method
       *   for this attribute. It will be used to determine whether to include this field
        *   in the serialized XML
        */
        protected boolean local_returnTracker = false;


        /**
         * Auto generated getter method
         *
         * @return ArrayOfRGBColor[]
         */
        public ArrayOfRGBColor[] get_return() {
            return local_return;
        }


        /**
         * validate the array for _return
         */
        protected void validate_return(ArrayOfRGBColor[] param) {

        }


        /**
         * Auto generated setter method
         *
         * @param param _return
         */
        public void set_return(ArrayOfRGBColor[] param) {

            validate_return(param);


            if (param != null) {
                //update the setting tracker
                local_returnTracker = true;
            } else {
                local_returnTracker = true;

            }

            this.local_return = param;
        }


        /**
         * Auto generated add method for the array for convenience
         *
         * @param param ArrayOfRGBColor
         */
        public void add_return(ArrayOfRGBColor param) {
            if (local_return == null) {
                local_return = new ArrayOfRGBColor[]{};
            }


            //update the setting tracker
            local_returnTracker = true;


            java.util.List list =
                    org.apache.axis2.databinding.utils.ConverterUtil.toList(local_return);
            list.add(param);
            this.local_return =
                    (ArrayOfRGBColor[]) list.toArray(
                            new ArrayOfRGBColor[list.size()]);

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
                            RayTraceResponse.this.serialize(MY_QNAME, factory, xmlWriter);
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
                            namespacePrefix + ":rayTraceResponse",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "rayTraceResponse",
                            xmlWriter);
                }


            }
            if (local_returnTracker) {
                if (local_return != null) {
                    for (int i = 0; i < local_return.length; i++) {
                        if (local_return[i] != null) {
                            local_return[i].serialize(new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "return"),
                                    factory, xmlWriter);
                        } else {

                            // write null attribute
                            java.lang.String namespace2 = "http://b534.cs.indiana.edu";
                            if (!namespace2.equals("")) {
                                java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                if (prefix2 == null) {
                                    prefix2 = generatePrefix(namespace2);

                                    xmlWriter.writeStartElement(prefix2, "return", namespace2);
                                    xmlWriter.writeNamespace(prefix2, namespace2);
                                    xmlWriter.setPrefix(prefix2, namespace2);

                                } else {
                                    xmlWriter.writeStartElement(namespace2, "return");
                                }

                            } else {
                                xmlWriter.writeStartElement("return");
                            }

                            // write the nil attribute
                            writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                            xmlWriter.writeEndElement();

                        }

                    }
                } else {

                    // write null attribute
                    java.lang.String namespace2 = "http://b534.cs.indiana.edu";
                    if (!namespace2.equals("")) {
                        java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                        if (prefix2 == null) {
                            prefix2 = generatePrefix(namespace2);

                            xmlWriter.writeStartElement(prefix2, "return", namespace2);
                            xmlWriter.writeNamespace(prefix2, namespace2);
                            xmlWriter.setPrefix(prefix2, namespace2);

                        } else {
                            xmlWriter.writeStartElement(namespace2, "return");
                        }

                    } else {
                        xmlWriter.writeStartElement("return");
                    }

                    // write the nil attribute
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                    xmlWriter.writeEndElement();

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

            if (local_returnTracker) {
                if (local_return != null) {
                    for (int i = 0; i < local_return.length; i++) {

                        if (local_return[i] != null) {
                            elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                                    "return"));
                            elementList.add(local_return[i]);
                        } else {

                            elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                                    "return"));
                            elementList.add(null);

                        }

                    }
                } else {

                    elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                            "return"));
                    elementList.add(local_return);

                }

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
            public static RayTraceResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                RayTraceResponse object =
                        new RayTraceResponse();

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

                            if (!"rayTraceResponse".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (RayTraceResponse) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();

                    java.util.ArrayList list1 = new java.util.ArrayList();


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "return").equals(reader.getName())) {


                        // Process the array and step past its final element's end.

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            list1.add(null);
                            reader.next();
                        } else {
                            list1.add(ArrayOfRGBColor.Factory.parse(reader));
                        }
                        //loop until we find a start element that is not part of this array
                        boolean loopDone1 = false;
                        while (!loopDone1) {
                            // We should be at the end element, but make sure
                            while (!reader.isEndElement())
                                reader.next();
                            // Step out of this element
                            reader.next();
                            // Step to next element event.
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            if (reader.isEndElement()) {
                                //two continuous end elements means we are exiting the xml structure
                                loopDone1 = true;
                            } else {
                                if (new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "return").equals(reader.getName())) {

                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                        list1.add(null);
                                        reader.next();
                                    } else {
                                        list1.add(ArrayOfRGBColor.Factory.parse(reader));
                                    }
                                } else {
                                    loopDone1 = true;
                                }
                            }
                        }
                        // call the converter utility  to convert and set the array

                        object.set_return((ArrayOfRGBColor[])
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                        ArrayOfRGBColor.class,
                                        list1));

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


    public static class RayTraceMovie
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://b534.cs.indiana.edu",
                "rayTraceMovie",
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
         * This was an Array!
         */


        protected CameraSetup[] localCamera;

        /*  This tracker boolean wil be used to detect whether the user called the set method
       *   for this attribute. It will be used to determine whether to include this field
        *   in the serialized XML
        */
        protected boolean localCameraTracker = false;


        /**
         * Auto generated getter method
         *
         * @return CameraSetup[]
         */
        public CameraSetup[] getCamera() {
            return localCamera;
        }


        /**
         * validate the array for Camera
         */
        protected void validateCamera(CameraSetup[] param) {

        }


        /**
         * Auto generated setter method
         *
         * @param param Camera
         */
        public void setCamera(CameraSetup[] param) {

            validateCamera(param);


            if (param != null) {
                //update the setting tracker
                localCameraTracker = true;
            } else {
                localCameraTracker = true;

            }

            this.localCamera = param;
        }


        /**
         * Auto generated add method for the array for convenience
         *
         * @param param CameraSetup
         */
        public void addCamera(CameraSetup param) {
            if (localCamera == null) {
                localCamera = new CameraSetup[]{};
            }


            //update the setting tracker
            localCameraTracker = true;


            java.util.List list =
                    org.apache.axis2.databinding.utils.ConverterUtil.toList(localCamera);
            list.add(param);
            this.localCamera =
                    (CameraSetup[]) list.toArray(
                            new CameraSetup[list.size()]);

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
                            RayTraceMovie.this.serialize(MY_QNAME, factory, xmlWriter);
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
                            namespacePrefix + ":rayTraceMovie",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "rayTraceMovie",
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
                if (localCamera != null) {
                    for (int i = 0; i < localCamera.length; i++) {
                        if (localCamera[i] != null) {
                            localCamera[i].serialize(new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "camera"),
                                    factory, xmlWriter);
                        } else {

                            // write null attribute
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

                        }

                    }
                } else {

                    // write null attribute
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
                if (localCamera != null) {
                    for (int i = 0; i < localCamera.length; i++) {

                        if (localCamera[i] != null) {
                            elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                                    "camera"));
                            elementList.add(localCamera[i]);
                        } else {

                            elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                                    "camera"));
                            elementList.add(null);

                        }

                    }
                } else {

                    elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                            "camera"));
                    elementList.add(localCamera);

                }

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
            public static RayTraceMovie parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                RayTraceMovie object =
                        new RayTraceMovie();

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

                            if (!"rayTraceMovie".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (RayTraceMovie) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();

                    java.util.ArrayList list2 = new java.util.ArrayList();


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


                        // Process the array and step past its final element's end.

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            list2.add(null);
                            reader.next();
                        } else {
                            list2.add(CameraSetup.Factory.parse(reader));
                        }
                        //loop until we find a start element that is not part of this array
                        boolean loopDone2 = false;
                        while (!loopDone2) {
                            // We should be at the end element, but make sure
                            while (!reader.isEndElement())
                                reader.next();
                            // Step out of this element
                            reader.next();
                            // Step to next element event.
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            if (reader.isEndElement()) {
                                //two continuous end elements means we are exiting the xml structure
                                loopDone2 = true;
                            } else {
                                if (new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "camera").equals(reader.getName())) {

                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                        list2.add(null);
                                        reader.next();
                                    } else {
                                        list2.add(CameraSetup.Factory.parse(reader));
                                    }
                                } else {
                                    loopDone2 = true;
                                }
                            }
                        }
                        // call the converter utility  to convert and set the array

                        object.setCamera((CameraSetup[])
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                        CameraSetup.class,
                                        list2));

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


    public static class CameraSetup
            implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
                name = CameraSetup
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
         * field for Direction
         */


        protected Point3D localDirection;

        /*  This tracker boolean wil be used to detect whether the user called the set method
       *   for this attribute. It will be used to determine whether to include this field
        *   in the serialized XML
        */
        protected boolean localDirectionTracker = false;


        /**
         * Auto generated getter method
         *
         * @return Point3D
         */
        public Point3D getDirection() {
            return localDirection;
        }


        /**
         * Auto generated setter method
         *
         * @param param Direction
         */
        public void setDirection(Point3D param) {

            if (param != null) {
                //update the setting tracker
                localDirectionTracker = true;
            } else {
                localDirectionTracker = true;

            }

            this.localDirection = param;


        }


        /**
         * field for Location
         */


        protected Point3D localLocation;

        /*  This tracker boolean wil be used to detect whether the user called the set method
       *   for this attribute. It will be used to determine whether to include this field
        *   in the serialized XML
        */
        protected boolean localLocationTracker = false;


        /**
         * Auto generated getter method
         *
         * @return Point3D
         */
        public Point3D getLocation() {
            return localLocation;
        }


        /**
         * Auto generated setter method
         *
         * @param param Location
         */
        public void setLocation(Point3D param) {

            if (param != null) {
                //update the setting tracker
                localLocationTracker = true;
            } else {
                localLocationTracker = true;

            }

            this.localLocation = param;


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
                            CameraSetup.this.serialize(parentQName, factory, xmlWriter);
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
                            namespacePrefix + ":CameraSetup",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "CameraSetup",
                            xmlWriter);
                }


            }
            if (localDirectionTracker) {
                if (localDirection == null) {

                    java.lang.String namespace2 = "http://b534.cs.indiana.edu";

                    if (!namespace2.equals("")) {
                        java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                        if (prefix2 == null) {
                            prefix2 = generatePrefix(namespace2);

                            xmlWriter.writeStartElement(prefix2, "direction", namespace2);
                            xmlWriter.writeNamespace(prefix2, namespace2);
                            xmlWriter.setPrefix(prefix2, namespace2);

                        } else {
                            xmlWriter.writeStartElement(namespace2, "direction");
                        }

                    } else {
                        xmlWriter.writeStartElement("direction");
                    }


                    // write the nil attribute
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                    xmlWriter.writeEndElement();
                } else {
                    localDirection.serialize(new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "direction"),
                            factory, xmlWriter);
                }
            }
            if (localLocationTracker) {
                if (localLocation == null) {

                    java.lang.String namespace2 = "http://b534.cs.indiana.edu";

                    if (!namespace2.equals("")) {
                        java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                        if (prefix2 == null) {
                            prefix2 = generatePrefix(namespace2);

                            xmlWriter.writeStartElement(prefix2, "location", namespace2);
                            xmlWriter.writeNamespace(prefix2, namespace2);
                            xmlWriter.setPrefix(prefix2, namespace2);

                        } else {
                            xmlWriter.writeStartElement(namespace2, "location");
                        }

                    } else {
                        xmlWriter.writeStartElement("location");
                    }


                    // write the nil attribute
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                    xmlWriter.writeEndElement();
                } else {
                    localLocation.serialize(new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "location"),
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

            if (localDirectionTracker) {
                elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                        "direction"));


                elementList.add(localDirection == null ? null :
                        localDirection);
            }
            if (localLocationTracker) {
                elementList.add(new javax.xml.namespace.QName("http://b534.cs.indiana.edu",
                        "location"));


                elementList.add(localLocation == null ? null :
                        localLocation);
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
            public static CameraSetup parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                CameraSetup object =
                        new CameraSetup();

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

                            if (!"CameraSetup".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (CameraSetup) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "direction").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            object.setDirection(null);
                            reader.next();

                            reader.next();

                        } else {

                            object.setDirection(Point3D.Factory.parse(reader));

                            reader.next();
                        }
                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://b534.cs.indiana.edu", "location").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            object.setLocation(null);
                            reader.next();

                            reader.next();

                        } else {

                            object.setLocation(Point3D.Factory.parse(reader));

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


    private org.apache.axiom.om.OMElement toOM(RayTracerStub.RayTrace param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(RayTracerStub.RayTrace.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(RayTracerStub.RayTraceResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(RayTracerStub.RayTraceResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(RayTracerStub.RayTraceMovie param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(RayTracerStub.RayTraceMovie.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(RayTracerStub.RayTraceMovieResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(RayTracerStub.RayTraceMovieResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(RayTracerStub.RayTraceSubView param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(RayTracerStub.RayTraceSubView.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(RayTracerStub.RayTraceSubViewResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(RayTracerStub.RayTraceSubViewResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(RayTracerStub.RayTraceURL param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(RayTracerStub.RayTraceURL.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(RayTracerStub.RayTraceURLResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(RayTracerStub.RayTraceURLResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }


    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, RayTracerStub.RayTrace param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(RayTracerStub.RayTrace.MY_QNAME, factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }


    /* methods to provide back word compatibility */


    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, RayTracerStub.RayTraceMovie param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(RayTracerStub.RayTraceMovie.MY_QNAME, factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }


    /* methods to provide back word compatibility */


    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, RayTracerStub.RayTraceSubView param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(RayTracerStub.RayTraceSubView.MY_QNAME, factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }


    /* methods to provide back word compatibility */


    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, RayTracerStub.RayTraceURL param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(RayTracerStub.RayTraceURL.MY_QNAME, factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }


    /* methods to provide back word compatibility */


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

            if (RayTracerStub.RayTrace.class.equals(type)) {

                return RayTracerStub.RayTrace.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (RayTracerStub.RayTraceResponse.class.equals(type)) {

                return RayTracerStub.RayTraceResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (RayTracerStub.RayTraceMovie.class.equals(type)) {

                return RayTracerStub.RayTraceMovie.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (RayTracerStub.RayTraceMovieResponse.class.equals(type)) {

                return RayTracerStub.RayTraceMovieResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (RayTracerStub.RayTraceSubView.class.equals(type)) {

                return RayTracerStub.RayTraceSubView.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (RayTracerStub.RayTraceSubViewResponse.class.equals(type)) {

                return RayTracerStub.RayTraceSubViewResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (RayTracerStub.RayTraceURL.class.equals(type)) {

                return RayTracerStub.RayTraceURL.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (RayTracerStub.RayTraceURLResponse.class.equals(type)) {

                return RayTracerStub.RayTraceURLResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
        return null;
    }


}
   