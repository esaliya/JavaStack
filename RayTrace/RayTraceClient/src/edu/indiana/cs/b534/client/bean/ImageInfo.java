package edu.indiana.cs.b534.client.bean;

/**
 * @author Saliya Ekanayake (sekanaya@cs.indiana.edu)
 */

/**
 * Class <code>ImageInfo</code> holds image information
 * in the case of sub view ray tracing with blocks. In
 * essence this is a bean.
 */
public class ImageInfo {
    private String imageUrl;
    // indicates the column major block id (zero base)
    private int id;
    // Top-Left-X, Top-Left-Y, Bottom-Right-X, Bottom-Right-Y
    private int tlx, tly, brx, bry;

    public ImageInfo(int id, int tlx, int tly, int brx, int bry) {
        this.id = id;
        this.tlx = tlx;
        this.tly = tly;
        this.brx = brx;
        this.bry = bry;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getId() {
        return id;
    }

    public int getTlx() {
        return tlx;
    }

    public int getTly() {
        return tly;
    }

    public int getBrx() {
        return brx;
    }

    public int getBry() {
        return bry;
    }
}
