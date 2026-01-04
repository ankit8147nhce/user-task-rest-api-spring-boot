package com.jspiders.taskapi.controllers;

import com.jspiders.taskapi.data.tasks.CreateTaskRequest;
import com.jspiders.taskapi.data.tasks.Task;
import com.jspiders.taskapi.data.tasks.UpdateTaskRequest;
import com.jspiders.taskapi.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

//**********************************************************************************
//@RequiredArgsConstructor is one of the most useful Lombok annotations
//It automatically generates a constructor with required fields only.
//**********************************************************************************
@RequiredArgsConstructor

@RestController
@RequestMapping("/api/task")
public class TaskController {

    /*
    WITHOUT : @RequiredArgsConstructor: Lombok (normal Java)

    private final TaskService taskService;
    @Autowired
    public TaskService(TaskService taskService) {
        this.taskService = taskService;
    }
 */
    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTask(){
        System.out.println("this is TaskController --> getAllTask()");
        ResponseEntity<List<Task>> response = taskService.getAllTasks();
        return response;
    }

    @GetMapping("/{taskid}")
    public ResponseEntity<Task> getTaskByID(@PathVariable Long taskid){
        System.out.println("this is TaskController --> getTaskByID()");
        ResponseEntity<Task> response = taskService.getTaskByID(taskid);
        return response;
    }

    @PostMapping
    public ResponseEntity<String> createTask(@RequestBody CreateTaskRequest createTaskRequest) {
        System.out.println("this is TaskController --> createTask()");
        ResponseEntity<String> response = taskService.createTask(createTaskRequest);
        return response;
    }
    @PutMapping
    public ResponseEntity<String> updateTask(UpdateTaskRequest updateTaskRequest){
        System.out.println("This is TaskController --> updateTask()");
        ResponseEntity<String> response = taskService.updateTask(updateTaskRequest);
        return response;
    }
    @DeleteMapping
    public ResponseEntity<String> deleteTaskById(Long taskId){
        System.out.println("This is TaskController --> deleteTask()");
        ResponseEntity<String> response = taskService.deleteTaskByID(taskId);
        return response;
    }
}
