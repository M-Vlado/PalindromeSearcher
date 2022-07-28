package com.example.todosappwithmysql.controllers;

import com.example.todosappwithmysql.models.Assignee;
import com.example.todosappwithmysql.models.Todo;
import com.example.todosappwithmysql.repository.AssigneesRepository;
import com.example.todosappwithmysql.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/todo")
public class TodoController {

    TodosRepository todosRepository;
    AssigneesRepository assigneesRepository;

    @Autowired
    public TodoController(TodosRepository todosRepository, AssigneesRepository assigneesRepository) {
        this.todosRepository = todosRepository;
        this.assigneesRepository = assigneesRepository;
    }

    @GetMapping(value = {"", "/list"})
    public String list(@RequestParam(required = false) String isActive, @RequestParam(value = "search", required = false) String search, Model model) {
        if (isActive != null && isActive.equals("true")) {
            model.addAttribute("todos", todosRepository.getAllByDoneFalse());
            model.addAttribute("assignees", assigneesRepository.findAll());
        } else if (search != null && isActive == null) {
            Date searchingDate = null;
            try {
                searchingDate = new SimpleDateFormat("yyyy-MM-dd").parse(search);

            } catch (ParseException e) {
                e.printStackTrace();
            }
            model.addAttribute("todos", todosRepository.findAllByTitleContainingIgnoreCaseOrContentContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrAssigneeNameOrCreationDateLikeOrDueDateLike(search, search, search, search, searchingDate, searchingDate));
            model.addAttribute("assignees", assigneesRepository.findAll());
        } else {
            model.addAttribute("todos", todosRepository.findAll());
            model.addAttribute("assignees", assigneesRepository.findAll());
        }

        return "index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Todo todo = new Todo();
        model.addAttribute("todoObj", todo);
        model.addAttribute("assigneesList", assigneesRepository.findAll());
        return "addTodo";
    }

    @PostMapping("/add")
    public String addTodo(@ModelAttribute Todo todo) {
        todosRepository.save(todo);
        return "redirect:/todo";
    }

    @GetMapping("/{id}/delete")
    public String deleteTodo(@PathVariable(value = "id") int id) {
        todosRepository.deleteById((long) id);
        return "redirect:/todo";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable(value = "id") int id, Model model) {

        model.addAttribute("todoEdit", todosRepository.findById((long) id).get());
        model.addAttribute("assignees", assigneesRepository.findAll());
        return "editTodo";
    }

    @PostMapping("/{id}/edit")
    public String editTodo(@ModelAttribute Todo todo) {

        todosRepository.save(todo);

        return "redirect:/todo";
    }

    @GetMapping("/{id}")
    public String showTodo(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("todoToShow", todosRepository.findById((long) id).get());
        return "showTodo";
    }

    @GetMapping("/assignees")
    public String showAllAssignees(Model model) {
        model.addAttribute("assigneesList", assigneesRepository.findAll());

        return "showAssignees";
    }

    @GetMapping("/assignees/{id}/edit")
    public String assigneeEdit(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("assigneeToChange", assigneesRepository.findById((long) id).get());
        return "editAssignee";
    }

    @PostMapping("/assignees/{id}/edit")
    public String assigneeEditPost(@ModelAttribute Assignee assignee) {
        assigneesRepository.save(assignee);
        return "redirect:/todo/assignees";
    }

    @GetMapping("/assignees/{id}/delete")
    public String deleteAssignee(@PathVariable(value = "id") int id) {
        assigneesRepository.deleteById((long) id);
        return "redirect:/todo/assignees";
    }

    @GetMapping("/assignee/add")
    public String addAssignee(Model model) {
        Assignee assignee = new Assignee();
        model.addAttribute("assigneeObj", assignee);
        return "addAssignee";
    }

    @PostMapping("/assignee/add")
    public String addAssigneePost(@ModelAttribute Assignee assignee) {
        assigneesRepository.save(assignee);
        return "redirect:/todo/assignees";
    }

    @GetMapping("/assignees/{id}/show-Todos")
    public String showAssigneeTodos(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("assignedTodos", todosRepository.findByAssignee_Id((long) id));
        return "assignedTodos";
    }


}
