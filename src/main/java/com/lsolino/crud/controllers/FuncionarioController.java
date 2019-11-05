package com.lsolino.crud.controllers;

import javax.validation.Valid;

import com.lsolino.crud.models.Funcionario;
import com.lsolino.crud.repositories.Funcionarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

  @Autowired
  Funcionarios funcionarios;

  @RequestMapping("")
  public ModelAndView inicio(){
    ModelAndView mv = new ModelAndView("funcionario.html");
		mv.addObject(new Funcionario());
		mv.addObject("funcionarios",funcionarios.findAll());
		return mv;
  }

  @RequestMapping(value = "", method = RequestMethod.POST)
  public String salvar(@Valid Funcionario funcionario, BindingResult bindingResult, Model model){
    if (bindingResult.hasErrors()) {
      model.addAttribute("funcionarios", funcionarios.findAll());
      return "funcionario.html";
    }
    funcionarios.save(funcionario);
		return "redirect:/funcionarios";
  }

  @RequestMapping(value = "alterar/{id}")
  public ModelAndView alterar(@PathVariable Long id){
    ModelAndView mv = new ModelAndView("funcionario.html");
		Funcionario funcionario = funcionarios.getOne(id);
		mv.addObject(funcionario);
		mv.addObject("funcionarios",funcionarios.findAll());
		return mv;
  }

  @RequestMapping(value = "excluir/{id}")
  public String excluir(@PathVariable Long id){
    funcionarios.deleteById(id);
		return "redirect:/funcionarios";
  }

}