package it.univaq.disim.se.masaccio.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.univaq.disim.se.masaccio.entity.IoTRoomData;
import kafka.serializer.Decoder;
import kafka.utils.VerifiableProperties;

/**
 * Class to deserialize JSON string to IoTData java object
 * 
 * @author abaghel
 *
 */
public class IoTDataDecoder implements Decoder<IoTRoomData> {
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	public IoTDataDecoder(VerifiableProperties verifiableProperties) {

    }
	public IoTRoomData fromBytes(byte[] bytes) {
		try {
			return objectMapper.readValue(bytes, IoTRoomData.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
