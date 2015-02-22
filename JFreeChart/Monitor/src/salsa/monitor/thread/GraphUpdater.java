package salsa.monitor.thread;

import salsa.monitor.ui.GenericGraph;
import salsa.monitor.client.StatClient;
import cgl.perfmon.Measurements;

import java.awt.*;

/**
 * @author Saliya Ekanayake
 * (esaliya@gmail.com)
 */
public class GraphUpdater implements Runnable{
    private GenericGraph [] graphs;
    private StatClient client;
    private boolean pause = false;
    private boolean exit = false;
    private int refresh;

    public GraphUpdater(GenericGraph[] graphs, StatClient client, int refresh) {
        this.graphs = graphs;
        this.client = client;
        this.refresh = refresh;
    }

    @Override
    public void run() {
        while(!exit) {
            if (!pause) {
                Measurements[] updates = client.getUpdates();
                String[] titleUpdates = client.getTitleUpdates();
                int i;
                for (i = 0; i < graphs.length; i++) {
                    if (graphs[i] != null) {
                        graphs[i].update(updates[i].getCpuCombinedPercentage() * 100, updates[i].getMemPercentage());
                        graphs[i].setTitle(titleUpdates[i]);
//                        graphs[i].update(updates[i].getCpuCombinedPercentage() * 100+Math.random()*90, updates[i].getMemPercentage()+Math.random() * 90);
                    }
                }
            }
            try {
                Thread.sleep(refresh);
            } catch (InterruptedException e) {
                e.printStackTrace();  //later log this
            }
        }
    }

    public void pause() {
        pause = true;
    }

    public void resume() {
        pause = false;
    }

    public void exit() {
        exit = true;
    }
}
