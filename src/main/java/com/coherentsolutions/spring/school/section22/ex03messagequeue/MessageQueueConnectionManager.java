package com.coherentsolutions.spring.school.section22.ex03messagequeue;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MessageQueueConnectionManager {

    private Connection connection;

    @PostConstruct
    public void init() {
        // Simulate establishing a connection to a message queue
        connection = new Connection("MessageQueueConnection");
        connection.connect();
        System.out.println("Message queue connection established.");
    }

    @PreDestroy
    public void close() {
        // Simulate closing the connection to the message queue
        if (connection != null) {
            connection.disconnect();
            System.out.println("Message queue connection closed.");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public class Connection {
        private String name;

        public Connection(String name) {
            this.name = name;
        }

        public void connect() {
            System.out.println("Connecting to " + name);
        }

        public void disconnect() {
            System.out.println("Disconnecting from " + name);
        }
    }
}
