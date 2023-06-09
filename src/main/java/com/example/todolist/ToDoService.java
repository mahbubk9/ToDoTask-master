package com.example.todolist;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

@Service
public class ToDoService {
   
  @Autowired
  ToDoRepo todoRepo;

  public ToDo saveToDo(ToDo task)
    {
        return todoRepo.save(task);
    }
 
  public void deleteTaskbyID(Integer id) {
     ToDo t=todoRepo.findById(id).get();
    todoRepo.delete(t);

  }

  public ToDo findTaskbyID(Integer id) {
    return todoRepo.findById(id).get();
   

 }
  public List<ToDo> getAllToDos() {
    List<ToDo> result = (List<ToDo>) todoRepo.findAll();
     
    if(result.size() > 0) {
      return result;
    } else {
      return new ArrayList<ToDo>();
    }
  }
   
 

  
  
   
  public void deleteToDoById(Integer id) throws RecordNotFoundException 
  {
    Optional<ToDo> todo = todoRepo.findById(id);
     
    if(todo.isPresent()) 
    {
      todoRepo.deleteById(id);
    } else {
      throw new RecordNotFoundException("No ToDo record exist for given id");
    }
  } 
}