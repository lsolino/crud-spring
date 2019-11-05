package com.lsolino.crud.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

@Entity
public class Funcionario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Nome não pode estar em branco")
  private String nome;
  @NotBlank(message = "CPF não pode estar em branco")
  private String cpf;
  @NotBlank(message = "Telefone não pode estar em branco")
  private String telefone;
  @DecimalMin(value = "0.0", message = "Salário não pode ser negativo")
  private double salario;

  @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
  private Set<Tarefa> tarefas;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }

  public Set<Tarefa> getTarefas() {
    return tarefas;
  }

  public void setTarefas(Set<Tarefa> tarefas) {
    this.tarefas = tarefas;
  }

  

}