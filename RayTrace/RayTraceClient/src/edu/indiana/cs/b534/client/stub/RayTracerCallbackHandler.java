
/**
 * RayTracerCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

package edu.indiana.cs.b534.client.stub;

    /**
     *  RayTracerCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class RayTracerCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public RayTracerCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public RayTracerCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for rayTrace method
            * override this method for handling normal response from rayTrace operation
            */
           public void receiveResultrayTrace(
                    RayTracerStub.RayTraceResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from rayTrace operation
           */
            public void receiveErrorrayTrace(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for rayTraceMovie method
            * override this method for handling normal response from rayTraceMovie operation
            */
           public void receiveResultrayTraceMovie(
                    RayTracerStub.RayTraceMovieResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from rayTraceMovie operation
           */
            public void receiveErrorrayTraceMovie(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for rayTraceSubView method
            * override this method for handling normal response from rayTraceSubView operation
            */
           public void receiveResultrayTraceSubView(
                    RayTracerStub.RayTraceSubViewResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from rayTraceSubView operation
           */
            public void receiveErrorrayTraceSubView(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for rayTraceURL method
            * override this method for handling normal response from rayTraceURL operation
            */
           public void receiveResultrayTraceURL(
                    RayTracerStub.RayTraceURLResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from rayTraceURL operation
           */
            public void receiveErrorrayTraceURL(java.lang.Exception e) {
            }
                


    }
    