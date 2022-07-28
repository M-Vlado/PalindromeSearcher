package com.example.todosappwithmysql;

import com.example.todosappwithmysql.models.Assignee;
import com.example.todosappwithmysql.models.Todo;
import com.example.todosappwithmysql.repository.AssigneesRepository;
import com.example.todosappwithmysql.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class TodosAppWithMySqlApplication implements CommandLineRunner {

    TodosRepository todosRepository;
    AssigneesRepository assigneesRepository;

    @Autowired
    public TodosAppWithMySqlApplication(TodosRepository todosRepository, AssigneesRepository assigneesRepository) {
        this.todosRepository = todosRepository;
        this.assigneesRepository = assigneesRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TodosAppWithMySqlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        List<Assignee> assignees = new ArrayList<>();
//        Assignee vlado = new Assignee("Vlado", "vlado@vlado.com");
//        Assignee lukas = new Assignee("Lukas", "lukas@gmail.com");
//        Assignee martin = new Assignee("Martin", "mato@gmail.com");
//        Assignee maca = new Assignee("Maca", "macka@gmail.com");
//        assignees.add(vlado);
//        assignees.add(lukas);
//        assignees.add(martin);
//        assignees.add(maca);
//
//        assigneesRepository.saveAll(assignees);
//
//        List<Todo> todos = new ArrayList<>();
//        todos.add(new Todo("I have to learn Object Relational Mapping", "for SQL using JAVA", "use this technologies: JAVA , MySql", false, false, lukas, "2022-08-08"));
//        todos.add(new Todo("I have to learn OOP", "Choose language as you like, but the best is JAVA :)", "start with a basic of OOP like classes", false, false, vlado, "2022-08-08"));
//        todos.add(new Todo("I have to learn JS", "optional you can use TypeScript which is using for Angular framework", "start with basic JS or TS", false, false, maca, "2022-09-18"));
//        todos.add(new Todo("I have to learn HTML", "without HTML you are lost forever :D :D ", "just kidding it's very easy", false, false, martin, "2022-10-28"));
//        todos.add(new Todo("connection to MySQL","create connection with SQL database", "you can use hibernate", true, true, vlado, "2022-08-18"));
//        todos.add(new Todo("MySQL populated with data", "first of all you have to change the constructor for this task","change constructor and fill up the data",false, true, vlado, "2022-11-08"));
//        todos.add(new Todo("Add some CSS to App", "make the page looks nice ;)","create CSS file or use Bootstrap",true, false, lukas, "2022-12-24"));
//
//        todosRepository.saveAll(todos);

    }

}
