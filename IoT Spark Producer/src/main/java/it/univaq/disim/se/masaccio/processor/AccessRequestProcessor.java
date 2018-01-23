package it.univaq.disim.se.masaccio.processor;

import it.univaq.disim.se.masaccio.entity.AccessRequest;
import org.apache.spark.streaming.api.java.JavaDStream;

import com.datastax.spark.connector.japi.CassandraJavaUtil;

import static com.datastax.spark.connector.japi.CassandraStreamingJavaUtil.javaFunctions;

import java.util.*;



public class AccessRequestProcessor {
	/**
	 * Method to get access request to the database.
	 * 
	 * @param nonfilteredIotDataStream IoT data stream
	 */
	public void processAccessRequests(JavaDStream<AccessRequest> nonFilteredAccessDataStream) {
		// Map Cassandra table column
		Map<String, String> columnNameMappings = new HashMap<String, String>();
		columnNameMappings.put("item", "item");
		columnNameMappings.put("cardUid", "carduid");
		columnNameMappings.put("timeStamp", "timestamp");

		// call CassandraStreamingJavaUtil function to save in DB
		javaFunctions(nonFilteredAccessDataStream).writerBuilder("primaverakeyspace", "accessrequest",
				CassandraJavaUtil.mapToRow(AccessRequest.class, columnNameMappings)).saveToCassandra();

	}
}
