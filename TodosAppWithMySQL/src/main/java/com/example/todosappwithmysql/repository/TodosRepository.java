package com.example.todosappwithmysql.repository;

import com.example.todosappwithmysql.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TodosRepository extends JpaRepository<Todo, Long> {

    List<Todo> getAllByDoneFalse();

    List<Todo> findAllByTitleContainingIgnoreCaseOrContentContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrAssigneeNameOrCreationDateLikeOrDueDateLike(String title, String content, String description, String assignee_name, Date creationDate, Date dueDate);

    List<Todo> findByAssignee_Id(Long assignee_id);
}
