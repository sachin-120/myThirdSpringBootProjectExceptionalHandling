package in.sachin.springExpectionalOne.controller;

import in.sachin.springExpectionalOne.dtos.TaskRequestDtos;
import in.sachin.springExpectionalOne.dtos.TaskResponseDtos;
import in.sachin.springExpectionalOne.entity.Task;
import in.sachin.springExpectionalOne.service.TaskService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/taskManagement")
public class TaskController{

    private TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }

    //----------------------------------------------

    @PostMapping
    private ResponseEntity<TaskResponseDtos> createTask(@Valid @RequestBody TaskRequestDtos task1){

        TaskResponseDtos task= taskService.createTasks(task1);

        return ResponseEntity.ok(task);
    }

    //----------------------------------------------

    @GetMapping
    private ResponseEntity<List<TaskResponseDtos>> getAll(){
        List<TaskResponseDtos> getAll=taskService.getALLTask();

        return ResponseEntity.ok(getAll);
    }

    //----------------------------------------------

    @DeleteMapping("/{id}")
    private void DeleteTask(@PathVariable Long id){

        taskService.deleteTask(id);
    }

    //----------------------------------------------

    @GetMapping("/{id}")
    private ResponseEntity<TaskResponseDtos> getElemenetId(@PathVariable Long id){
        TaskResponseDtos task=taskService.getTaskById(id);

        if(task==null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(task);
    }

    //------------------------------------------------

    @PatchMapping("/{id}")
    private ResponseEntity<TaskResponseDtos> updateTask(@Valid @RequestBody TaskRequestDtos task, @PathVariable Long id){

        TaskResponseDtos tasks=taskService.updateTask(task,id);

        return ResponseEntity.ok(tasks);
    }


}
