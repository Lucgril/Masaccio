package it.univaq.disim.se.masaccio.utility;

import it.univaq.disim.se.masaccio.data.Room;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;


@Repository
public interface RoomDataRepository extends CassandraRepository<Room> {

    @Query("select * from numberofpeople group by room limit 10")
    List<Room> findRoomsLimit();
}
