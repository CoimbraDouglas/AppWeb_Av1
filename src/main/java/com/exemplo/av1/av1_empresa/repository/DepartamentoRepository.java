package com.exemplo.av1.av1_empresa.repository;

import com.exemplo.av1.av1_empresa.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}