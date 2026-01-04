package com.jspiders.taskapi.data.tasks;

import lombok.Data;


//Domain Model or Entity
// these fields will be present in the DB of Task Table
@Data
public class Task {
    private Long taskId;
    private String title;
    private String description;
    private String status;
    private String createdAt;
    private String updatedAt;
}
