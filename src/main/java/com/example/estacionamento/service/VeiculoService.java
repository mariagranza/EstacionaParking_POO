package com.example.estacionamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.estacionamento.entity.Veiculo;
import com.example.estacionamento.repository.VeiculoRepository;

@Service
public class VeiculoService {
    
    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }
    public Veiculo salvar(Veiculo veiculo) {
        try {
            return veiculoRepository.save(veiculo);
        } catch (Exception e) {
            // Aqui você pode registrar o erro, ou lançar uma exceção customizada
            throw new RuntimeException("Erro ao salvar o veículo", e);
        }
    }
    

    public void deletar(Long id) {
        veiculoRepository.deleteById(id);
    }
}


