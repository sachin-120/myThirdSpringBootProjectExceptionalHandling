package in.sachin.springExpectionalOne.respository;


import in.sachin.springExpectionalOne.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
