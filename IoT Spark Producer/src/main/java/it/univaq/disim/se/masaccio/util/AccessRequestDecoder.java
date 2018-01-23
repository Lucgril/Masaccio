package it.univaq.disim.se.masaccio.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.univaq.disim.se.masaccio.entity.AccessRequest;
import kafka.serializer.Decoder;
import kafka.utils.VerifiableProperties;

/**
 * Class to deserialize JSON string to IoTData java object
 * 
 * @author abaghel
 *
 */
public class AccessRequestDecoder implements Decoder<AccessRequest> {
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	public AccessRequestDecoder(VerifiableProperties verifiableProperties) {

    }
	public AccessRequest fromBytes(byte[] bytes) {
		try {
			return objectMapper.readValue(bytes, AccessRequest.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
