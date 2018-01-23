package it.univaq.disim.se.masaccio.producer;

public class IoTDataProducer {

	public static void main(String[] args) throws Exception {
		RoomDataProducer roomDataProducer = new RoomDataProducer();
		roomDataProducer.start();
		
		AccessRequestProducer accessRequestProducer = new AccessRequestProducer();
		accessRequestProducer.start();
	}
}
