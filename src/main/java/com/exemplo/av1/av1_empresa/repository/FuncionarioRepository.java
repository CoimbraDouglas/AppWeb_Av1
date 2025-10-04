package com.exemplo.av1.av1_empresa.repository;

import com.exemplo.av1.av1_empresa.model.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}