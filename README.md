# NATS Example using JNats

## Start Nats Server using Docker
- Start Nats Server using Docker
  ```
  docker run --name nats --rm -p 4222:4222 nats`
  ```
- Connecting to NATS Server
  ```
  telnet localhost 4222
  ```
- Publishing a message to subject `com.techprimers`:
  ```
  PUB com.techprimers 5
  hello
  ```