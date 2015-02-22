package mypack;

public class DP implements Comparable<DP> {

    private double x;
    public DP(double x){
        this.x = x;
    }

    public double getX() {
        return x;
    }

    @Override
    public int compareTo(DP o) {
        /*if (this.x >= o.getX()) {
            return 1;
        }else{
            return -1;
        }*/

        return (this.getX() <o.getX() ? -1 : (this.getX() == o.getX() ? 0 : 1));
    }
}

