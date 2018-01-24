CREATE KEYSPACE IF NOT EXISTS PrimaveraKeySpace WITH replication = {'class':'SimpleStrategy','replication_factor':1};

use PrimaveraKeySpace;

create table NumberOfPeople (room text, numberOfPeople bigint, timeStamp timestamp, PRIMARY KEY (room, timeStamp));

insert into NumberOfPeople (room, numberOfPeople, timestamp) values ('1', 40, '2017-12-21 08:20:29');

select * from NumberOfPeople;
