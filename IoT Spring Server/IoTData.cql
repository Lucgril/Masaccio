CREATE KEYSPACE IF NOT EXISTS PrimaveraKeySpace WITH replication = {'class':'SimpleStrategy','replication_factor':1};

use PrimaveraKeySpace;

create table NumberOfPeople (room text, numberOfPeople bigint, timeStamp timestamp, PRIMARY KEY (room, timeStamp));

insert into NumberOfPeople (room, numberOfPeople, timestamp) values ('1', 40, '2017-12-21 08:20:29');

select * from NumberOfPeople;

create table messages (id bigint, timestamp timestamp, text text, sender bigint, primary key(id, timestamp));

insert into messages(id,timestamp,text,sender) values (1,'2018-01-04 08:20:29','Hy, how are you?',1);

select * from messages;

create table accessrequest (item text, timestamp timestamp, carduid text, primary key(item, timestamp)) with clustering order by (timestamp asc);

insert into accessrequest(item,timestam,carduid) values ('room1','2018-01-04 08:20:29','1234abcd');

select * from accessrequest;
