# HTTP_SERVER

# Simple Java HTTP Server
![http_server](https://github.com/user-attachments/assets/2283698f-47de-48f8-a96f-d2363d3156ed)


A lightweight HTTP server built using pure Java, designed to handle basic HTTP requests and responses. This project is intended for learning the basics of networking, TCP connections, and HTTP protocol implementation in Java.

## Main 
![802f359f-b245-43c5-a68f-520be42a4268](https://github.com/user-attachments/assets/01bdcd39-e42a-479c-8e8a-75d7ed8f5ffc)


## Features
- Handles basic HTTP GET requests
- Implements a simple TCP 3-way handshake simulation
- Multi-threaded request handling (optional for expansion)
- Simple HTTP response with `Content-Type` and basic HTML content

## Requirements
- Java 17 or higher

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/shchae04/HTTP_SERVER.git
    ```

2. Navigate to the project directory:
    ```bash
    cd http-server
    ```

3. Compile the project:
    ```bash
    javac -d out src/com/example/CustomServerSocket.java
    ```

4. Run the server:
    ```bash
    java -cp out 
    ```

## Usage

1. After starting the server, you can test the server by sending a simple HTTP GET request using your browser or a tool like `curl`:
   ```bash
   curl http://localhost:8080
