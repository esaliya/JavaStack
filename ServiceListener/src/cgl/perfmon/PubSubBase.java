package cgl.perfmon;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import cgl.narada.event.NBEvent;
import cgl.narada.event.NBEventException;
import cgl.narada.event.TemplateProfileAndSynopsisTypes;
import cgl.narada.matching.Profile;
import cgl.narada.service.ServiceException;
import cgl.narada.service.client.ClientService;
import cgl.narada.service.client.EventConsumer;
import cgl.narada.service.client.EventProducer;
import cgl.narada.service.client.NBEventListener;
import cgl.narada.service.client.SessionService;

public class PubSubBase implements NBEventListener {

	private String brokerHost;

	private String brokerPort;

	private Subscribable subscriber;

	// NB event consumers and producers
	private EventProducer producer;

	private EventConsumer consumer;

	private int entityId;

	private ClientService clientService;

	// Map to hold the profiles that this client may subscirbe to.
	// Need this to disconnect from the profiles gracefully at the event of
	// closing communications.
	private Map<String, Profile> profiles;

	/**
	 * Constructor initializes the broker communications and hence may throw a
	 * MRException.
	 * 
	 * @param host
	 *            Broker host IP address
	 * @param port
	 *            Broker port (typically 3045 for non blocking tcp)
	 * @param subscriber
	 *            Subscribable implementation
	 * @throws MRException
	 */

	public PubSubBase(String host, String port) throws MonitorExecption {
		this.brokerHost = host;
		this.brokerPort = port;
		this.entityId = new Random().nextInt();

		try {
			clientService = SessionService.getClientService(this.entityId);
			Properties props = new Properties();
			props.put("hostname", brokerHost);
			props.put("portnum", brokerPort);

			clientService.initializeBrokerCommunications(props, Constants.TCP_COMM_TYPE);

			// Initialize the EventProducer
			producer = clientService.createEventProducer();
			producer.generateEventIdentifier(true);
			producer.setTemplateId(new Random().nextInt());
			producer.setDisableTimestamp(false);
			// producer.setSuppressRedistributionToSource(true);

		} catch (ServiceException e) {
			throw new MonitorExecption(e);
		}
	}

	public PubSubBase(String host, String port, Subscribable subscriber)
			throws MonitorExecption {

		this(host, port);
		this.subscriber=subscriber;
		profiles = new HashMap<String, Profile>();

		try {
			// Initialize the EventConsumer
			consumer = clientService.createEventConsumer(this);

		} catch (ServiceException e) {
			throw new MonitorExecption(e);
		}
	}

	/**
	 * Closes the connection to the broker.
	 * 
	 * @throws ServiceException
	 */
	public synchronized void closeBrokerConnection() throws MonitorExecption {
		try {
			for (String key : profiles.keySet()) {
				unsubscribe(key);
			}
			clientService.closeBrokerConnection();
			clientService.terminateServices();
		} catch (ServiceException se) {
			throw new MonitorExecption(se);
		}

	}

	/**
	 * Subscribe to a given topic.
	 * 
	 * @param topic
	 * @throws ServiceException
	 */
	public synchronized void subscribeToProfile(String topic)
			throws MonitorExecption {

		try {
			Profile profile = clientService.createProfile(
					TemplateProfileAndSynopsisTypes.STRING, topic);
			consumer.subscribeTo(profile);
			profiles.put(topic, profile);
		} catch (ServiceException se) {
			throw new MonitorExecption(se);
		}
	}

	/**
	 * Unsubscribe from a given topic.
	 * 
	 * @param topic
	 * @throws ServiceException
	 */
	private synchronized void unsubscribe(String topic) throws MonitorExecption {
		try {
			consumer.unSubscribe(profiles.get(topic));
		} catch (ServiceException se) {
			throw new MonitorExecption(se);
		}
	}

	/**
	 * Handles the publishing of events to a particular topic.
	 * 
	 * @param stringMsg
	 * @param topic
	 * @throws ServiceException
	 * @throws NBEventException
	 */
	public synchronized void publishEvent(String stringMsg, String topic)
			throws MonitorExecption {
		try {
			NBEvent nbEvent = producer.generateEvent(
					TemplateProfileAndSynopsisTypes.STRING, topic, stringMsg
							.getBytes());
			producer.publishEvent(nbEvent);
		} catch (ServiceException se) {
			throw new MonitorExecption(se);
		}
	}

	/**
	 * Handles the publishing of events using a bytes as the inputs.
	 * 
	 * @param byteMsg
	 * @param topic
	 * @throws ServiceException
	 * @throws NBEventException
	 */

	public synchronized void publishEvent(byte[] byteMsg, String topic)
			throws MonitorExecption {
		try {
			NBEvent nbEvent = producer.generateEvent(
					TemplateProfileAndSynopsisTypes.STRING, topic, byteMsg);
			producer.publishEvent(nbEvent);
			// System.out.println("Publishing to :"+topic);
		} catch (ServiceException se) {
			throw new MonitorExecption(se);
		}
	}

	/**
	 * Call the subscriber passing the payload bytes of the receiving message.
	 * Here we ignore the header processing of the NBEvent. This is a simple
	 * provision for a future C++ implementation. (NB's C++ client does not
	 * support event headers yet)
	 */
	public synchronized void onEvent(NBEvent nbEvent) {
		this.subscriber.onEvent(nbEvent.getContentPayload());

	}

}
