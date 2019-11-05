package com.lsolino.crud.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Tarefa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Descrição não pode estar em branco")
  private String descricao;
  private String prioridade;
  private String data_entrega;
  private boolean completado = false;
  
  @ManyToOne
  @NotNull(message = "É necessário informar o funcionário responsável por essa tarefa")
  private Funcionario funcionario;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getPrioridade() {
    return prioridade;
  }

  public void setPrioridade(String prioridade) {
    this.prioridade = prioridade;
  }

  public String getData_entrega() {
    return data_entrega;
  }

  public void setData_entrega(String data_entrega) {
    this.data_entrega = data_entrega;
  }

  public boolean isCompletado() {
    return completado;
  }

  public void setCompletado(boolean completado) {
    this.completado = completado;
  }

  public Funcionario getFuncionario() {
    return funcionario;
  }

  public void setFuncionario(Funcionario funcionario) {
    this.funcionario = funcionario;
  }

}
