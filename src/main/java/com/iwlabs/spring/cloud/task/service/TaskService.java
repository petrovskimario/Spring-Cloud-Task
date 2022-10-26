package com.iwlabs.spring.cloud.task.service;

import com.iwlabs.spring.cloud.task.model.Book;
import com.iwlabs.spring.cloud.task.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.task.listener.annotation.AfterTask;
import org.springframework.cloud.task.listener.annotation.BeforeTask;
import org.springframework.cloud.task.listener.annotation.FailedTask;
import org.springframework.cloud.task.repository.TaskExecution;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service
public class TaskService {

    @Autowired
    BookRepository bookRepository;

    @Value("${bookFileLocation}")
    private String fileLocation;

    public void run() {
        System.out.println("running");
        try {
            System.out.println("Saving books..");
            BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
            String line = reader.readLine();
            while(line != null) {
                Book book = new Book(null,line);
                bookRepository.save(book);
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            // Exception
        }
    }

    @BeforeTask
    public void start(TaskExecution taskExecution) {
        System.out.println("TaskName : " + taskExecution.getTaskName() + " Execution Id : "
                + taskExecution.getExecutionId() + " started...");

    }

    @AfterTask
    public void end(TaskExecution taskExecution) {
        System.out.println("TaskName : " + taskExecution.getTaskName() + " Execution Id : "
                + taskExecution.getExecutionId() + " completed...");

    }

    @FailedTask
    public void fail(TaskExecution taskExecution, Throwable throwable) {
        System.out.println("TaskName : " + taskExecution.getTaskName() + " Execution Id : "
                + taskExecution.getExecutionId() + " failed...");
    }
}
