package it.univaq.disim.se.masaccio.util;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.univaq.disim.se.masaccio.entity.AccessRequest;
import kafka.serializer.Encoder;
import kafka.utils.VerifiableProperties;

public class AccessRequestEncoder implements Encoder<AccessRequest> {
	
	private static final Logger logger = Logger.getLogger(AccessRequestEncoder.class);	
	private static ObjectMapper objectMapper = new ObjectMapper();		
	public AccessRequestEncoder(VerifiableProperties verifiableProperties) {

    }
	public byte[] toBytes(AccessRequest accessRequest) {
		try {
			String msg = objectMapper.writeValueAsString(accessRequest);
			logger.info(msg);
			return msg.getBytes();
		} catch (JsonProcessingException e) {
			logger.error("Error in Serialization", e);
		}
		return null;
	}
}