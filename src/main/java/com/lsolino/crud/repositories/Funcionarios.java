package com.lsolino.crud.repositories;

import com.lsolino.crud.models.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Funcionarios extends JpaRepository<Funcionario, Long> {
  
}