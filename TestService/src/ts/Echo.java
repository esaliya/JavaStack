package ts;

/**
 * Created by IntelliJ IDEA.
 * User: Saliya
 * Date: Nov 2, 2009
 * Time: 12:26:05 AM
 * To change this template use File | Settings | File Templates.
 */

import org.apache.axis2.engine.ServiceLifeCycle;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.description.AxisService;

public class Echo implements ServiceLifeCycle{

    public Echo() {
        System.out.println("instance created..........");
    }
    public void startUp(ConfigurationContext configurationContext, AxisService axisService) {
        System.out.println("Started............");
    }

    public void shutDown(ConfigurationContext configurationContext, AxisService axisService) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
