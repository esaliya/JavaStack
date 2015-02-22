package mypack;

import java.io.IOException;
import java.util.Properties;

public class PropReader {
    public static void main(String[] args) {
        System.out.println("running.");
        Properties props = new Properties();
        try {
            props.load(PropReader.class.getResourceAsStream("/mongo.properties"));
            System.out.println(props.getProperty("name"));
            System.out.println(Integer.parseInt(props.getProperty("age")));
        } catch (IOException e) {
            System.out.println("Couldn't find mongo.properties files in classpath");
        }
    }
}
