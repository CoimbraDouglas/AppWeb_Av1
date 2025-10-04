package com.exemplo.av1.av1_empresa.controller.mvc;

import com.exemplo.av1.av1_empresa.model.Funcionario;
import com.exemplo.av1.av1_empresa.service.DepartamentoService;
import com.exemplo.av1.av1_empresa.service.FuncionarioService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioMvcController {

    private final FuncionarioService funcionarioService;
    private final DepartamentoService departamentoService;

    public FuncionarioMvcController(FuncionarioService funcionarioService, DepartamentoService departamentoService) {
        this.funcionarioService = funcionarioService;
        this.departamentoService = departamentoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("funcionarios", funcionarioService.listar());
        return "funcionarios/list";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        model.addAttribute("departamentos", departamentoService.listar());
        return "funcionarios/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Funcionario funcionario) {
        funcionarioService.salvar(funcionario);
        return "redirect:/funcionarios";
    }

    @GetMapping("/{id}/editar")
    public String editarForm(@PathVariable Long id, Model model) {
        model.addAttribute("funcionario", funcionarioService.buscarPorId(id));
        model.addAttribute("departamentos", departamentoService.listar());
        return "funcionarios/form";
    }

    @PostMapping("/{id}/deletar")
    public String deletar(@PathVariable Long id) {
        funcionarioService.deletar(id);
        return "redirect:/funcionarios";
    }
}