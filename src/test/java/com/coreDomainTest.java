package com;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import com.example.todolist.ToDo;

public class coreDomainTest {
    @Test
    void newToDoIDNullandGettersSettersWorking() {
      ToDo task = new ToDo();
      task.setTaskDescription("SubmitCWK");
      task.setPriority("High");
      task.setDeadLine(LocalDate.of(2023,04,22));
      task.setStatus("NotDone");
      assertThat(task.getId()).isNull();
      assertThat(task.getTaskDescription()).isEqualTo("SubmitCWK");
      assertThat(task.getPriority()).isEqualTo("High");
      assertThat(task.getDeadLine())
        .isEqualTo("2023-04-22");
     assertThat(task.getStatus()).isEqualTo("NotDone");
    }
    
}
