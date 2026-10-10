package in.sachin.springExpectionalOne.dtos;

import java.time.LocalDate;

public class TaskResponseDtos {

    private Long id;
    private String name;
    private String description;
    private String priority;
    private String status;
    private LocalDate dueDate;
    private LocalDate createAdt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getCreateAdt() {
        return createAdt;
    }

    public void setCreateAdt(LocalDate createAdt) {
        this.createAdt = createAdt;
    }
}
