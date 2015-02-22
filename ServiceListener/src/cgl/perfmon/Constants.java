package cgl.perfmon;

public interface Constants {

	/**
	 * Constants for the monitoring infrastructure.
	 *
	 * @author Jaliya Ekanayake (jaliyae@gmail.com) 11/03/2009
	 */

	public static byte PERF_MESSAGE=0;
	public static byte STATUS_MESSAGE=1;

	public static String TCP_COMM_TYPE = "niotcp";
	public static String MONITOR_OUT_COMM_TOPIC = "/monitor-to-server/communication/topic";
	public static String SUMMERIZER_OUT_COMM_TOPIC = "/summerizer-to-webservice/communication/topic";

	public static final long MONITOR_WORKER_SLEEP_TIME = 2000; // In milliseconds.
	public static int SUMMERIZE_WORKER_SLEEP_TIME = 2000;
	public static final long SLEEP_BEFORE_TERMINATE = 5000; // In milliseconds.

}
