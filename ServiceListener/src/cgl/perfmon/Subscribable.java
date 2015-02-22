package cgl.perfmon;

/**
 * Interface for subscribable classes. A subscribable class can be used as a
 * listener for receiving events from pub/sub network.
 * 
 * @author Jaliya Ekanayake (jaliyae@gamil.com)
 * 
 */
public interface Subscribable {
	/**
	 * This method is called when a message is available.
	 * 
	 * @param message
	 */
	public void onEvent(byte[] message);
}
