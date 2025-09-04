# Redis-Demo

It is a simple spring boot project, Here I have connect my spring boot application to local Redis server and have done some basic CRUD operations.
> Writing data into redis db.
> Fetching data from redis db.

It is basic and raw, where I have used native Java classes like
RedisStandaloneConfiguration  -> for setting the redis server and port details
RedisConnectionFactory  ->  for building connection by using redisStandaloneConfiguration
RedisTemplate -> which consumes the connection factory object and has methods like 
                opsForHash().getall -> for retrieving a hask key data
                opsForHash().put    -> for persisting Hkey & Hvalue into redis db

I just created 2 rest endpoints (POST & GET), to add a student and to retrieve a student data
