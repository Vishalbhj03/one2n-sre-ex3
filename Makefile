APP_NAME = SpringBootRestAPIProject
PORT ?= 8087

IMAGE_NAME = student-rest-api
VERSION ?= 1.0.0

.PHONY: build run test migrate clean db-start db-migrate docker-build api-run

# Maven Commands
build:
	mvn -q -DskipTests package

run:
	mvn spring-boot:run

test:
	mvn -q test

migrate:
	mvn -q flyway:migrate

clean:
	mvn -q clean

# Docker Compose Commands
db-start:
	docker compose up -d db

db-migrate:
	mvn -q flyway:migrate

docker-build:
	docker build -t $(IMAGE_NAME):$(VERSION) .

api-run: db-start db-migrate
	docker compose up -d api
