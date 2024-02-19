package com.springboot.myfirstwebapp.todo;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static final List<Todo> todos;

    private static int todosCount=0;

    static {
        todos=new ArrayList<>();
//        todos.add(new Todo(++todosCount, "chirag", "learn Spring", LocalDate.now().plusYears(1),false));
//        todos.add(new Todo(++todosCount, "chirag", "learn Spring boot", LocalDate.now().plusYears(1),false));
//        todos.add(new Todo(++todosCount, "chirag", "learn java", LocalDate.now().plusYears(1),false));
    }

    public List<Todo> findByUser(String username){
        Predicate<? super Todo> predicate=todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description, LocalDate tragteDate,boolean isDone){
        Todo todo=new Todo(++todosCount,username,description,tragteDate,isDone);
        todos.add(todo);
    }

    public void deleteById(int id){

        Predicate<? super Todo> predicate=todo -> todo.getId()==id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate=todo -> todo.getId()==id;
        return todos.stream().filter(predicate).findFirst().get();
    }

    public void updateTodo(Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
