B534 - Project 1 - README.txt
------------------------------

Authors
-------
  Saliya Ekanayake (sekanaya at cs dot indiana dot edu)
  Hui Li(lihui at indiana dot edu)


Contents
---------
1. README.txt (this file)
2. bin - contains drive scripts (run.bat and run.sh)
3. lib - contains required jar files (except axis2 jars)
4. RayTraceClient - contains client code with ant build
5. RayTraceService - contains service code with ant build


Pre-requisites
---------------
1. Java runtime installed and java executable set in path variable of the system
2. Apache Ant
3. Apache Tomcat
4. Apache Axis2 installed in Apache Tomcat
5. AXIS2_HOME environment variable. The scripts assume the existance of AXIS2_HOME
   variable. It should point to the WEB-INF folder of deployed axis2 inside Tomcat
6. Ray-Tracer-API-B534-V1.jar and rings.jar should be present inside
   AXIS2_HOME/lib folder along with the rest of axis2-*.jar files


Building the Service
--------------------
1. Open a terminal window and change directory to RayTraceService folder
2. Type ant. This will build and copy the the RayTracer.aar into AXIS2_HOME/services

Note: Please make sure to remove any previous service archives with the same name (if any)
      from the AXIS2_HOME/services folder prior to running ant here.


Building the Client
--------------------
1. Open a terminal window and change directory to RayTraceClient folder
2. Type ant. This will compile and build the RayTracer-client.jar inside
   RayTracerClient/build/lib folder.


Deploying RayTracer Service
---------------------------
1. Start Apache Tomcat


Running RayTrace Client
-----------------------
1. Open a terminal and change directory to bin folder.
2. Type run.bat (or run.sh if in an Linux environment). This will launch the RayTrace GUI.
3. Follow the intutive operations on the user interface.

Note: You can provide a different server location by passing it as an argument to the run.bat
      (or run.sh)


IMPORTANT:
----------
The system needs to save image files, but since it there is no public file server or shared
directory to save these, it will save them to the current directory where Apache Tomcat is 
running. If you run Apache Tomcat from its bin folder then images will be saved there.

All the images are named with UUIDs to avoid conflicts. To cleanup the set of images do 
a remove operation on *.jpg.

