package com.example.estacionamento.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.estacionamento.entity.Veiculo;
import com.example.estacionamento.service.ModeloVeiculoService;
import com.example.estacionamento.service.VeiculoService;

@Controller
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private ModeloVeiculoService modeloVeiculoService;

    @GetMapping
    public ModelAndView findAll() {
        var listaVeiculos = veiculoService.findAll();
        return new ModelAndView("listaVeiculos", "listaVeiculos", listaVeiculos);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var veiculo = new Veiculo();
        var listaModelos = modeloVeiculoService.findAll();
        HashMap<String, Object> map = new HashMap<>();
        map.put("veiculo", veiculo);
        map.put("listaModelos", listaModelos);
        return new ModelAndView("veiculo", map);
    }

    @PostMapping("/salvar")
    public ModelAndView save(@ModelAttribute("veiculo") Veiculo veiculo) {  // Para verificar se os dados estão sendo recebidos corretamente
    veiculoService.salvar(veiculo);
    return new ModelAndView("redirect:/veiculos");
}


    @GetMapping("/deletar/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        veiculoService.deletar(id);
        return new ModelAndView("redirect:/veiculos");
    }


    
}
