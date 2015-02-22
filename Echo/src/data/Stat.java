package data;

public class Stat {

    private double clus1memtime;
    private double clus1cputime;
    private double clus2memtime;
    private double clus2cputime;
    private double clus3memtime;
    private double clus3cputime;
    private double clus4memtime;
    private double clus4cputime;

    public Stat (double clus1memtime, double clus1cputime,
                 double clus2memtime,
                 double clus2cputime,
                 double clus3memtime,
                 double clus3cputime,
                 double clus4memtime,
                 double clus4cputime) {

        this.clus1memtime = clus1memtime;
        this.clus1cputime = clus1cputime;
        this.clus2memtime = clus2memtime;
        this.clus2cputime = clus2cputime;
        this.clus3memtime = clus3memtime;
        this.clus3cputime = clus3cputime;
        this.clus4memtime = clus4memtime;
        this.clus4cputime = clus4cputime;
    }

    public double getClus1memtime() {
        return this.clus1memtime;
    }

    public double getClus1cputime() {
        return this.clus1cputime;
    }

    public double getClus2memtime() {
        return this.clus2memtime;
    }

    public double getClus2cputime() {
        return this.clus2cputime;
    }

    public double getClus3memtime() {
        return this.clus3memtime;
    }

    public double getClus3cputime() {
        return this.clus3cputime;
    }

    public double getClus4memtime() {
        return this.clus4memtime;
    }

    public double getClus4cputime() {
        return this.clus4cputime;
    }

}
