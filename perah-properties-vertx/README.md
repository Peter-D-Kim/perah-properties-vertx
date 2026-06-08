# Perah Properties Vert.x Application

A simple Java Vert.x application created inside the Perah Properties workspace.

## Run

1. Install Maven if not already installed.
2. From the project root:
   ```bash
   mvn package
   java -jar target/perah-properties-vertx-0.1.0.jar
   ```
3. Open http://localhost:8888

## Container

Build and run with Docker:

```bash
docker build -t perah-properties-vertx:latest .
docker run --rm -p 8888:8888 perah-properties-vertx:latest
```

Or use Docker Compose:

```bash
docker compose up --build
```

Then open http://localhost:8888
