package com.coherentsolutions.spring.school.section22.ex02filehandling;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    private BufferedWriter writer;

    @PostConstruct
    public void openFile() {
        try {
            writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("File opened.\n");
            System.out.println("File opened for writing.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void closeFile() {
        try {
            if (writer != null) {
                writer.write("File closed.\n");
                writer.close();
                System.out.println("File closed.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeData(String data) {
        try {
            if (writer != null) {
                writer.write(data + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
