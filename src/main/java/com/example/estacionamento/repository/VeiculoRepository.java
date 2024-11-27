package com.example.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.estacionamento.entity.Veiculo;
@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    
}
