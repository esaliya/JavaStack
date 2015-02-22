package salsa.services;

/**
 * @Author: Saliya Ekanayake
 * (esaliya@gmail.com)
 */

/**
 * Class <class>ClusStat</class> captures statistics of a single cluster
 */
public class ClusStat {
    private String name;
    private double memUsage;
    private double cpuUsage;

    public ClusStat() {
    }

    public ClusStat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMemUsage() {
        return memUsage;
    }

    public void setMemUsage(double memUsage) {
        this.memUsage = memUsage;
    }

    public double getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(double cpuUsage) {
        this.cpuUsage = cpuUsage;
    }
}
