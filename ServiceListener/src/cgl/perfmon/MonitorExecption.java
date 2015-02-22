package cgl.perfmon;

public class MonitorExecption extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MonitorExecption(Throwable cause) {
		super(cause);
	}

	public MonitorExecption(String message) {
		super(message);
	}

	public MonitorExecption(String message, Throwable cause) {
		super(message, cause);
	}

}
