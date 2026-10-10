package in.sachin.springExpectionalOne.service;

import in.sachin.springExpectionalOne.dtos.TaskRequestDtos;
import in.sachin.springExpectionalOne.dtos.TaskResponseDtos;
import in.sachin.springExpectionalOne.entity.Task;
import in.sachin.springExpectionalOne.exception.TaskNotFoundException;
import in.sachin.springExpectionalOne.respository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService{

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository=taskRepository;
    }

    public TaskResponseDtos createTasks(TaskRequestDtos tasks){

        Task task=mapToEntity(tasks);

        Task savedTask=taskRepository.save(task);

        return mapToResponse(savedTask);
    }

    public List<TaskResponseDtos> getALLTask(){



        List<Task> tasks=taskRepository.findAll();

        List<TaskResponseDtos> response=new ArrayList<>();

        for(Task task:tasks){
            response.add(mapToResponse(task));
        }

        return response;
    }

    public TaskResponseDtos getTaskById(Long id){

        Optional<Task> getElement=taskRepository.findById(id);

        if(getElement.isEmpty()){
            throw new TaskNotFoundException("Task with id " + id + " not found");
        }

        TaskResponseDtos response=mapToResponse(getElement.get());

        return response;
    }


    //------------------------------------

    public TaskResponseDtos updateTask(TaskRequestDtos task,Long id){

        Optional<Task> updateTask=taskRepository.findById(id);

        if(updateTask.isEmpty()){
            throw new TaskNotFoundException("Task with id " + id + " not found");
        }

        Task existingTask=updateTask.get();

        existingTask.setName(task.getName());
        existingTask.setDescription(task.getDescription());
        existingTask.setPriority(task.getPriority());
        existingTask.setStatus(task.getStatus());
        existingTask.setDueDate(task.getDueDate());

        Task updateReponse=taskRepository.save(existingTask);

        return mapToResponse(updateReponse);

    }


    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    private Task mapToEntity(TaskRequestDtos dto){

        Task tasks=new Task();

        tasks.setName(dto.getName());
        tasks.setDescription(dto.getDescription());
        tasks.setPriority(dto.getPriority());
        tasks.setStatus(dto.getStatus());
        tasks.setDueDate(dto.getDueDate());

        return tasks;

    }

    private TaskResponseDtos mapToResponse(Task tasks){

        TaskResponseDtos reponseDto=new TaskResponseDtos();

        reponseDto.setId(tasks.getId());
        reponseDto.setName(tasks.getName());
        reponseDto.setDescription(tasks.getDescription());
        reponseDto.setPriority(tasks.getPriority());
        reponseDto.setStatus(tasks.getStatus());
        reponseDto.setDueDate(tasks.getDueDate());

        return reponseDto;

    }


}
