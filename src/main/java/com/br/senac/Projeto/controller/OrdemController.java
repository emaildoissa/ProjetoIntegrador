package com.br.senac.Projeto.controller;

import com.br.senac.Projeto.data.ClienteEntity;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrdemController {

    @Autowired
    private OrdemService ordemService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/localizarOS")
    public String listarOS() {

        return "/localizarOS";
    }

    @GetMapping("/listarOrdensPorCliente")
    public String listarOrdensPorCliente(@RequestParam("clienteNome") String clienteNome, Model model) {
        List<OrdemEntity> ordensDoCliente = ordemService.listarOrdensPorCliente(clienteNome);
        model.addAttribute("ordensDoCliente", ordensDoCliente);
        return "/osResultados";
    }

    @GetMapping("/abrirOS")
    public String criarOrdem(Model model) {
        OrdemEntity ordem = new OrdemEntity();
        model.addAttribute("ordem", ordem);
        return "abrirOS";
    }

    @PostMapping("/salvarOS")
    public String salvarOrdem(@ModelAttribute("ordem") OrdemEntity ordem,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "abrirOS";
        }
        if (ordem.getId() == null) {
            ordemService.criarOrdem(ordem);
        } else {
            ordemService.atualizarOrdem(ordem.getId(), ordem);
        }
        return "redirect:/listarOS";
    }

    @GetMapping("/adicionarOS/{id}")
    public String criarOS(@PathVariable(value = "id") Integer id, Model model) {
        ClienteEntity clienteEntity = clienteService.getClienteId(id);
        if (clienteEntity != null) {
            OrdemEntity ordemEntity = ordemService.getOrdemByClienteId(id);
            if (ordemEntity != null) {
                model.addAttribute("cliente", clienteEntity);
                model.addAttribute("ordem", ordemEntity);
            } else {
                OrdemEntity novaOrdem = new OrdemEntity();
                novaOrdem.setCliente(clienteEntity);
                model.addAttribute("ordem", novaOrdem);

            }
            return "cadastrarOS";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/atualizarOS/{id}")
    public String atualizarOS(@PathVariable(value = "id") Integer id, Model model) {
        OrdemEntity ordemEntity = ordemService.getOrdemId(id);
        model.addAttribute("ordem", ordemEntity);
        return "atualizarOrdem";
    }

    @GetMapping("/listarOS")
    public String listarOS(Model model) {
        List<OrdemEntity> ordemEntity = ordemService.listarTodasOrdens();
        model.addAttribute("ordem", ordemEntity);
        return "listarOS";
    }

    @GetMapping("/excluirOS/{id}")
    public String apagarOS(@PathVariable(value = "id") Integer id) {
        ordemService.deletarOrdem(id);
        return "redirect: /listarOS";
    }
}
