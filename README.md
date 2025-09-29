# docker-for-developers

Create Network

```
docker network create postnet
```

Create Volume

```
docker volume create postdata
```

Run Postgres Database as a container

```
docker run --name postdb \
    --env-file .env/postgres \
    --network postnet \
    -p 5432:5432 \
    -v postdata:/var/lib/postgresql/data \
    -d postgres:17.6-alpine
```

Building post-api spring application

```
cd post-api

docker build -t post-api .
```

Running post-api application.

```
docker run --name postapi \
    --env-file .env/postgres \
    --network postnet \
    -p 8080:8080 \
    -d post-api
```