package it.univaq.disim.se.masaccio.utility;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.cassandra.repository.Query;
import it.univaq.disim.se.masaccio.data.impl.RoomImpl;

import java.util.List;


@Repository
public interface RoomDataRepository extends CassandraRepository<RoomImpl> {

    @Query("select * from numberofpeople group by room limit 9")
    List<RoomImpl> findRoomsLimit();
}
