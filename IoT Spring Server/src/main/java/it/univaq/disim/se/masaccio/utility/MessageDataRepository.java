package it.univaq.disim.se.masaccio.utility;

import it.univaq.disim.se.masaccio.data.MessageList;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDataRepository extends CassandraRepository<MessageList> {

    @Query("select * from messages")
    List<MessageList> findMessagesOrder();
}
