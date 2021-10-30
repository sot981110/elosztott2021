# Redis példa

1. redis szerver dockerben

```
docker run -p 16379:6379 -d redis:6.0 redis-server --requirepass "mypass"
```

2. mvn clean package

3. RedisExampleApplication.java Spring Boot appként futtatva

4. Működés:

`POST` kéréssel új személy felvétele.

`GET` kérésssel személyek lekérdezése.
