package com.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;

//@Controller
@SessionAttributes("name")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        String username=getUsernameDetails();
        model.put("todos",todoService.findByUser(username));
        return "list-todos";
    }

    @RequestMapping(value="add-todo",method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model){
        String username=getUsernameDetails();
        Todo todo=new Todo(0,username,"",LocalDate.now().plusYears(1),false);
        model.put("todo",todo);
        return "add-todo";
    }

    @RequestMapping(value="add-todo",method = RequestMethod.POST)
    public String addNewTodoPage(ModelMap model, @Valid Todo todo, BindingResult result){
        if (result.hasErrors())return "add-todo";

        String username = getUsernameDetails();
        todoService.addTodo(username,todo.getDescription(), todo.getTargetDate(),false);
        return "redirect:list-todos";
    }

    @RequestMapping(value="delete-todo")
    public String deleteTodo(@RequestParam int id){
        todoService.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value="update-todo",method = RequestMethod.GET)
    public String updateTodo(@RequestParam int id,ModelMap model){
        String username=getUsernameDetails();
        Todo todo=todoService.findById(id);
        model.addAttribute("todo",todo);
        return "add-todo";
    }
    @RequestMapping(value="update-todo",method = RequestMethod.POST)
    public String updatenewTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if (result.hasErrors())return "add-todo";

        String username = getUsernameDetails();
        todo.setUsername(username);
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }
    public String getUsernameDetails(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}
