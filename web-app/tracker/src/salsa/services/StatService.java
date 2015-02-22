

/**
 * StatService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */

    package salsa.services;

    /*
     *  StatService java interface
     */

    public interface StatService {
          

        /**
          * Auto generated method signature
          * 
         */

         
                     public salsa.services.xsd.ClusStat[] getStat(

                        )
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
          */
        public void startgetStat(

            

            final salsa.services.StatServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
         */
        public void  onEvent(
         javax.activation.DataHandler bytes5

        ) throws java.rmi.RemoteException
        
        ;

        

        
       //
       }
    