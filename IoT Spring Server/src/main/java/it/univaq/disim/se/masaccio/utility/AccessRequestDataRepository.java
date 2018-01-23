package it.univaq.disim.se.masaccio.utility;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import it.univaq.disim.se.masaccio.data.AccessRequest;

@Repository
public interface AccessRequestDataRepository extends CassandraRepository<AccessRequest> {

    @Query("select * from accessrequest group by item limit 4")
    List<AccessRequest> findAccessRequestsLimit();
}