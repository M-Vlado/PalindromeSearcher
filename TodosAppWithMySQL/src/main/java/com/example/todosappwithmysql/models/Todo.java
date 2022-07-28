package com.example.todosappwithmysql.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Getter
@Setter
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    private String description;
    private boolean urgent;
    private boolean done;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "assignee_id")
    private Assignee assignee;

    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;

    public Todo(String title, String content, String description) {
        this.title = title;
        this.content = content;
        this.description = description;
        this.urgent = false;
        this.done = false;
        this.creationDate = new Date();
    }

    public Todo(String title, String content, String description, boolean urgent, boolean done, Assignee assignee, String dueDate) {
        this.title = title;
        this.content = content;
        this.description = description;
        this.urgent = urgent;
        this.done = done;
        this.creationDate = new Date();
        this.assignee = assignee;
        try {
            this.dueDate = new SimpleDateFormat("yyyy-MM-dd").parse(dueDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Todo() {
        this.creationDate = new Date();
    }


}
