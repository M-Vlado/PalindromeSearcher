package com.example.todosappwithmysql.repository;

import com.example.todosappwithmysql.models.Assignee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssigneesRepository extends JpaRepository<Assignee, Long> {

}
