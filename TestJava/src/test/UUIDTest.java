package test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.UUID;

public class UUIDTest {
    public static void main(String[] args) {
        double x = Math.sqrt(16);
        System.out.println(x%1 ==0);
//        UUID id = UUID.randomUUID();
//        System.out.println(id.toString());
//        File f = new File("test.txt");
//        System.out.println(f.getAbsolutePath());
//        try {
//            System.out.println(f.toURI().toURL());
//            URL url = f.toURI().toURL();
//            System.out.println(System.getProperty("someprop"));
//
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }
//
//
//        java.util.Properties props = System.getProperties();
//        java.util.Enumeration propertiesNames = props.keys();
//
//        System.out.println("BEGIN OF SYSTEM PROPERTIES LIST!");
//        String propName = null;
//        while (propertiesNames.hasMoreElements()) {
//            propName = propertiesNames.nextElement().toString();
//            System.out.print("PROPERTY NAME: " + propName);
//            System.out.println(" PROPERTY VALUE: " + props.getProperty(propName));
//        }
//        System.out.println("END OF SYSTEM PROPERTIES LIST!");

        System.out.println(System.getenv("CATALINA_HOME"));
//       Map<String, String> env = System.getenv();
//        for (String envName : env.keySet()) {
//            System.out.format("%s=%s%n", envName, env.get(envName));
//        }


    }
}
