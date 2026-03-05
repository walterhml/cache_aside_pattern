# Cache Aside with Redis

Simple backend example showing how cache works.

## Stack

- Java
- Spring Boot
- Redis
- Docker

## How it works

1. API receives request
2. Check Redis cache
3. If cache miss → fetch from database
4. Save in Redis with TTL
5. Next request → cache hit

## Running Redis with Docker

docker compose up -d

## Run the project

./mvnw spring-boot:run
