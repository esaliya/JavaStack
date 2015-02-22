package salsa.services;

import org.apache.axis2.context.ServiceContext;
import org.apache.axis2.service.Lifecycle;
import cgl.perfmon.*;

/**
 * @Author: Saliya Ekanayake
 * (esaliya@gmail.com)
 */
public class StatService implements Lifecycle, Subscribable {
    private static final String BROKER_HOST = "156.56.104.94";
    private static final String BROKER_PORT = "3045";
    private static final String [] CLUSTER_NAMES = {"linux_vm", "linux_bm", "windows_bm"};


    private PubSubBase pubSubBase;
    private ClusStat [] stats;


    public void init(ServiceContext serviceContext) {
        try {
            pubSubBase = new PubSubBase(BROKER_HOST, BROKER_PORT, this);
            pubSubBase.subscribeToProfile(Constants.SUMMERIZER_OUT_COMM_TOPIC);
            stats = new ClusStat[4];
            for (int i = 0; i < 3; i++) {
                stats[i] = new ClusStat(CLUSTER_NAMES[i]); // the fixed clusters
            }
            stats[3] = new ClusStat(); // for the switching cluster
        } catch (MonitorExecption monitorExecption) {
            monitorExecption.printStackTrace(); // later log this
        }
    }

    public void destroy(ServiceContext serviceContext) {
        if (pubSubBase != null) {
            try {
                pubSubBase.closeBrokerConnection();
            } catch (MonitorExecption monitorExecption) {
                monitorExecption.printStackTrace();  // later log this
            }
        }
    }

    public void onEvent(byte[] bytes) {
        if (bytes[0] == Constants.PERF_MESSAGE) {
            try {
                Measurements m = new Measurements();
                m.fromBytes(bytes);
                String clusName = m.getClusterName();
                if (clusName.equals(CLUSTER_NAMES[0])) {
                    stats[0].setCpuUsage(m.getCpuCombinedPercentage());
                    stats[0].setMemUsage(m.getMemPercentage());
                } else if (clusName.equals(CLUSTER_NAMES[1])) {
                    stats[1].setCpuUsage(m.getCpuCombinedPercentage());
                    stats[1].setMemUsage(m.getMemPercentage());
                } else if (clusName.equals(CLUSTER_NAMES[2])) {
                    stats[2].setCpuUsage(m.getCpuCombinedPercentage());
                    stats[2].setMemUsage(m.getMemPercentage());
                } else {
                    stats[3].setName(clusName);
                    stats[3].setCpuUsage(m.getCpuCombinedPercentage());
                    stats[3].setMemUsage(m.getMemPercentage());
                }
            } catch (MonitorExecption e) {
                e.printStackTrace();
            }
        }
    }

    public ClusStat [] getStat() {
          return stats;
    }
}
