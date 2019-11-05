package com.lsolino.crud.repositories;

import java.util.List;

import com.lsolino.crud.models.Tarefa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Tarefas extends JpaRepository<Tarefa, Long> {

  @Query("select t from Tarefa t where t.funcionario.id = ?1")
  public List<Tarefa> getTarefas(Long funcionarioid); 
}