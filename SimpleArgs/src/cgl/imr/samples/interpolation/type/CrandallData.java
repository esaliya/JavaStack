package cgl.imr.samples.interpolation.type;

public class CrandallData {
	String id;
	int dimensionNum;
	short[] data;
	public CrandallData(String id, int dimensionNum, short[] data) {
		super();
		this.id = id;
		this.dimensionNum = dimensionNum;
		this.data = data;
	}
	public String getId() {
		return id;
	}
	public int getDimensionNum() {
		return dimensionNum;
	}
	public short[] getData() {
		return data;
	}
	
}
