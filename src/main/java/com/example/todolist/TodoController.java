package com.example.todolist;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;;
 

 
@Controller
@RequestMapping(path="/")
public class TodoController {
  @Autowired
  ToDoService service;

  public TodoController(ToDoService service) {
    this.service = service;
    
  }
  @GetMapping(path="/")
  public String index(Model model) 
  {
    List<ToDo> list = service.getAllToDos();
 
    model.addAttribute("ToDos", list);
    model.addAttribute("task", new ToDo());
    return "index";
  }
 
  @RequestMapping (value="/addTask",method= RequestMethod.POST)
  public String addTask (Model model ,@ModelAttribute ToDo task){
      service.saveToDo(task);
      return "redirect:/";


  }

  @RequestMapping("/deleteTask")
public String deleteTask( Model model ,@ModelAttribute ToDo task) {
   service.deleteTaskbyID(task.getId());
      
    return "redirect:/";
}


 
  @GetMapping(path="/AllToDos")
  public String getAllToDos(Model model) 
  {
    List<ToDo> list = service.getAllToDos();
 
    model.addAttribute("ToDos", list);
    return "AllToDos";
  }

  @RequestMapping(path = "/updateForm")

  public String updateForm (Model model, @RequestParam("id") Integer id)  {
    
    ToDo data=service.findTaskbyID(id);
    model.addAttribute("dt", data);
      
      return "updateForm";
  }

  @RequestMapping ("/saveUpdate")
    public String saveUpdate (Model model ,@RequestParam Integer id, @RequestParam String taskDescription, @RequestParam String priority, @RequestParam LocalDate deadLine, @RequestParam String status) {
     
      ToDo data=service.findTaskbyID(id);
      data.setTaskDescription(taskDescription);
      data.setPriority(priority);
      data.setDeadLine(deadLine);
      data.setStatus(status);
      service.saveToDo(data);

      return "redirect:/";
      
    }

  }
  
 
  
   
  

 
  
