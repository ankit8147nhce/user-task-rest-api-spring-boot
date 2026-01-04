package com.jspiders.taskapi.services.impl;

import com.jspiders.taskapi.data.tasks.CreateTaskRequest;
import com.jspiders.taskapi.data.tasks.Task;
import com.jspiders.taskapi.data.tasks.UpdateTaskRequest;
import com.jspiders.taskapi.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class TaskServiceimpl implements TaskService {
    @Override
    public ResponseEntity<String> createTask(CreateTaskRequest createTaskRequest) {

        System.out.println("this is TaskServiceImpl --> createTask()");

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Task created successfully");

    }

    @Override
    public ResponseEntity<List<Task>> getAllTasks() {
        System.out.println("this is TaskServiceImpl --> getAllTasks()");
        return ResponseEntity.status(HttpStatus.OK)
                .body(null);
    }

    @Override
    public ResponseEntity<Task> getTaskByID(Long taskid) {
        System.out.println("this is TaskServiceImpl -> getTaskByID()");
        return ResponseEntity.status(HttpStatus.OK)
                .body(null);
    }

    @Override
    public ResponseEntity<String> updateTask(UpdateTaskRequest updateTaskRequest) {
        System.out.println("this is TaskServiceImpl --> updateTask()");
        return ResponseEntity.status(HttpStatus.OK)
                .body("Task Updated successfully");
    }

    @Override
    public ResponseEntity<String> deleteTaskByID(Long taskId) {
        System.out.println("this is TaskServiceImpl --> deleteTaskByID()");
        return ResponseEntity.status(HttpStatus.OK)
                .body("Task deleted successfully");
    }
}
