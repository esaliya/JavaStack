package salsa.monitor.client;

import cgl.perfmon.*;
import cgl.switcher.StatusMessage;
import cgl.switcher.SwitcherExecption;

import java.util.ArrayList;

public class StatClient implements Subscribable {
    private static final String BROKER_HOST = "156.56.104.95";
    private static final String BROKER_PORT = "3045";
    private static final String[] FIXED_CLUSTER_NAMES = {"linux_vm", "linux_bm", "windows_bm"};

    private Measurements[] updates;
    private String [] titleUpdates;
    private PubSubBase pubSubBase;

    public StatClient() {
        updates = new Measurements[FIXED_CLUSTER_NAMES.length + 1];
        titleUpdates = new String[FIXED_CLUSTER_NAMES.length + 1];
        for (int i = 0; i < FIXED_CLUSTER_NAMES.length + 1; i++) {
            updates[i] = new Measurements();
            titleUpdates[i] = "Waiting for Name...";
        }
    }

    public void start() throws MonitorExecption {
        pubSubBase = new PubSubBase(BROKER_HOST, BROKER_PORT, this);
        pubSubBase.subscribeToProfile(Constants.SUMMERIZER_OUT_COMM_TOPIC);
    }

    public void stop() throws MonitorExecption {
        if (pubSubBase != null) {
            pubSubBase.closeBrokerConnection();
        }
    }

    @Override
    public void onEvent(byte[] bytes) {
        try {
            if (bytes[0] == Constants.PERF_MESSAGE) {
                Measurements m = new Measurements();
                m.fromBytes(bytes);
                String clusName = m.getClusterName();
//                System.out.println(m.getClusterName() + " CPU" + m.getCpuCombinedPercentage());
//                System.out.println(m.getClusterName() + " MEM" + m.getMemPercentage());
                if (clusName.equals(FIXED_CLUSTER_NAMES[0])) {
                    updates[0] = m;
                } else if (clusName.equals(FIXED_CLUSTER_NAMES[1])) {
                    updates[1] = m;
                } else if (clusName.equals(FIXED_CLUSTER_NAMES[2])) {
                    updates[2] = m;
                } else {
                    updates[3] = m;
                }
            }

            if (bytes[0] == Constants.STATUS_MESSAGE) {
                StatusMessage sm = new StatusMessage();
                sm.fromBytes(bytes);
                String [] texts = sm.getMessage().split("#");
                // Um, we may not need to check status message, but let's keep it for the moment
                if ("start_app".equals(sm.getStatus())) {
                    updateTitles(texts[0], texts[1]);
                } else if ("end_app".equals(sm.getStatus())) {
                    updateTitles(texts[0], texts[1]);
                }
            }
        } catch (MonitorExecption monitorExecption) {
            monitorExecption.printStackTrace();  //Tlater log this
        } catch (SwitcherExecption switcherExecption) {
            switcherExecption.printStackTrace();  //later log this
        }
    }

    private void updateTitles(String clusName, String title) {
        if (FIXED_CLUSTER_NAMES[0].equals(clusName)) {
            titleUpdates[0] = title;
        } else if (FIXED_CLUSTER_NAMES[1].equals(clusName)) {
            titleUpdates[1] = title;
        } else if (FIXED_CLUSTER_NAMES[2].equals(clusName)) {
            titleUpdates[2] = title;
        } else {
            titleUpdates[3] = title;
        }
    }

    public Measurements[] getUpdates() {
        return updates;
    }

    public String[] getTitleUpdates() {
        return titleUpdates;
    }
}
