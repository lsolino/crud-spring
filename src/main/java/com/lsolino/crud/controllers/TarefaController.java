package com.lsolino.crud.controllers;

import com.lsolino.crud.models.Funcionario;
import com.lsolino.crud.models.Tarefa;
import com.lsolino.crud.repositories.Funcionarios;
import com.lsolino.crud.repositories.Tarefas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {

  @Autowired
  Tarefas tarefas;

  @Autowired
  Funcionarios funcionarios;

  @RequestMapping("{id}")
  public ModelAndView inicio(@PathVariable Long id){
    ModelAndView mv = new ModelAndView("tarefa.html");
    Funcionario funcionario = funcionarios.getOne(id);
		mv.addObject(new Tarefa());
    mv.addObject("tarefas",tarefas.findAll());
    mv.addObject("funcionario_obj",funcionario);
    mv.addObject("tarefas_func",tarefas.getTarefas(id));
		return mv;
  }

  @RequestMapping(value = "{id}", method = RequestMethod.POST)
  public String salvar(Tarefa tarefa, @PathVariable Long id){
    ModelAndView mv = new ModelAndView();
    Funcionario funcionario = funcionarios.getOne(id);
    tarefa.setFuncionario(funcionario);
    tarefas.save(tarefa);
    mv.addObject("funcionario_obj",funcionario);
		return "redirect:/tarefas/{id}";
  }

  @RequestMapping(value = "alterar/{id}")
  public ModelAndView alterar(@PathVariable Long id){
    ModelAndView mv = new ModelAndView("tarefa.html");
    Tarefa tarefa = tarefas.getOne(id);
    Funcionario funcionario = tarefa.getFuncionario();
		mv.addObject(tarefa);
    mv.addObject("tarefas_func",tarefas.getTarefas(funcionario.getId()));
    mv.addObject("funcionario_obj",funcionario);
		return mv;
  }

  @RequestMapping(value = "excluir/{id}")
  public String excluir(@PathVariable Long id){
    tarefas.deleteById(id);
    return "redirect:/funcionarios";
  }

}