package br.com.fiap.epictask.task;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    TaskRepository repository;

    public List<Task> findAll(){
        return repository.findAll();
    }

    public boolean delete(Long id) {
        var task = repository.findById(id);

        if(task.isEmpty()) return false;

        repository.deleteById(id);
        return true;
    }

    public void save(Task task) {
        repository.save(task);
    }

    public void decrement(Long id) {
        //buscar a tarefa no bd
        var optional = repository.findById(id);

        if (optional.isEmpty()) throw new RuntimeException("tarefa não encontrada");

        var task = optional.get();

        if (task.getStatus() == null || task.getStatus() <= 0) 
            throw new RuntimeException("tarefa não pode ter status negativo");

        task.setStatus(task.getStatus() - 10);


        //salvar
        repository.save(task);
    }

    public void increment(Long id) {
        //buscar a tarefa no bd
        var optional = repository.findById(id);

        if (optional.isEmpty()) throw new RuntimeException("tarefa não encontrada");

        var task = optional.get();

        if (task.getStatus() == null) task.setStatus(0); 

        if (task.getStatus() == 100){
            throw new RuntimeException("tarefa não pode ter status maior que 100");
        }
            
        task.setStatus(task.getStatus() + 10);

        //salvar
        repository.save(task);
    }
    
}
