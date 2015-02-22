package cgl.perfmon;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Message to transfer performance information.
 *
 * @author Jaliya Ekanayake (jaliyae@gmail.com) 11/03/2009
 */
public class Measurements {
	private int nodeNumber;
	private int numCpus;
	private double cpuCombinedPercentage;
	private long totalMemory; // in MBs
	private double memPercentage;
	private boolean hasClusterName = false;
	private String clusterName;

	public Measurements() {
	}

	public String getClusterName() {
		return clusterName;
	}

	public void setClusterName(String clusterName) {
		this.hasClusterName = true;
		this.clusterName = clusterName;
	}

	public int getNumCpus() {
		return numCpus;
	}

	public void setNumCpus(int numCpus) {
		this.numCpus = numCpus;
	}

	public double getCpuCombinedPercentage() {
		return cpuCombinedPercentage;
	}

	public void setCpuCombinedPercentage(double cpuCombinedPercentage) {
		this.cpuCombinedPercentage = cpuCombinedPercentage;
	}

	public long getTotalMemory() {
		return totalMemory;
	}

	public void setTotalMemory(long totalMemory) {
		this.totalMemory = totalMemory;
	}

	public double getMemPercentage() {
		return memPercentage;
	}

	public void setMemPercentage(double memPercentage) {
		this.memPercentage = memPercentage;
	}

	/**
	 * Serialize the object and returns the bytes.
	 *
	 * @return
	 * @throws MonitorExecption
	 */
	public byte[] getBytes() throws MonitorExecption {
		byte[] serializedBytes = null;
		int len = 0;
		byte[] data;

		try {
			ByteArrayOutputStream baOutputStream = new ByteArrayOutputStream();
			DataOutputStream dout = new DataOutputStream(baOutputStream);

			//First byte is the message type.
			dout.writeByte(Constants.PERF_MESSAGE);

			dout.writeInt(this.nodeNumber);

			dout.writeInt(this.numCpus);

			dout.writeDouble(this.cpuCombinedPercentage);

			dout.writeLong(this.totalMemory);

			dout.writeDouble(this.memPercentage);

			dout.writeBoolean(hasClusterName);
			if (hasClusterName) {
				data = clusterName.getBytes();
				len = data.length;
				dout.writeInt(len);
				dout.write(data);
			}

			dout.flush();
			dout.close();

			serializedBytes = baOutputStream.toByteArray();

		} catch (IOException ioe) {
			throw new MonitorExecption("Could not serialize the message", ioe);
		}

		return serializedBytes;

	}

	/**
	 * Construct the object back from a previously serialized bytes.
	 *
	 * @param bytes
	 * @throws MonitorExecption
	 */
	public void fromBytes(byte[] bytes) throws MonitorExecption {

		ByteArrayInputStream baInputStream = new ByteArrayInputStream(bytes);
		DataInputStream din = new DataInputStream(baInputStream);

		byte[] data = null;
		int len = 0;

		try {
			//First byte is the message type
			byte msgType=din.readByte();
			assert(msgType==Constants.PERF_MESSAGE);

			this.nodeNumber = din.readInt();

			this.numCpus = din.readInt();

			this.cpuCombinedPercentage = din.readDouble();

			this.totalMemory = din.readLong();

			this.memPercentage = din.readDouble();

			this.hasClusterName = din.readBoolean();
			if (hasClusterName) {
				len = din.readInt();
				data = new byte[len];
				din.readFully(data);
				this.clusterName = new String(data);
			}

			baInputStream.close();
			din.close();
		} catch (IOException ioe) {
			throw new MonitorExecption("Could not de-serialize the message",
					ioe);
		}
	}

	public int getNodeNumber() {
		return nodeNumber;
	}

	public void setNodeNumber(int nodeNumber) {
		this.nodeNumber = nodeNumber;
	}
}
