package com.br.senac.Projeto.controller;

import com.br.senac.Projeto.data.ClienteEntity;
import com.br.senac.Projeto.data.EnderecoEntity;
import com.br.senac.Projeto.data.OrdemEntity;
import com.br.senac.Projeto.service.ClienteService;
import com.br.senac.Projeto.service.OrdemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class mainController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    OrdemService ordemService;

    @GetMapping("/criarCliente")
    public String criarCliente(Model model) {
        ClienteEntity cliente = new ClienteEntity();
        cliente.setEndereco(new EnderecoEntity());
        model.addAttribute("cliente", cliente);
        return "cadastrarCliente";
    }

    @PostMapping("/salvarCliente")
    public String salvarCliente(@ModelAttribute("cliente") ClienteEntity cliente,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "cadastrarCliente";
        }
        clienteService.criarCliente(cliente);
        return "redirect:/criarCliente";
    }

    @GetMapping("/pesquisarClientePorNome")
    public String pesquisarClientePorNome(@RequestParam String clienteNome, Model model) {
        List<ClienteEntity> clientesEncontrados = clienteService.encontrarClientesPorNome(clienteNome);
        model.addAttribute("clientes", clientesEncontrados);
        return "/clienteResultados";
    }

    @GetMapping("/")
    public String index(Model model) {
        List<OrdemEntity> ordemEntity = ordemService.listarTodasOrdens();
        model.addAttribute("ordem", ordemEntity);
        return "index";
    }
}
