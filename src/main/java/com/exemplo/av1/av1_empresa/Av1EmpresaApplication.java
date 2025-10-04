package com.exemplo.av1.av1_empresa;

import com.exemplo.av1.av1_empresa.model.Departamento;
import com.exemplo.av1.av1_empresa.model.Funcionario;
import com.exemplo.av1.av1_empresa.repository.DepartamentoRepository;
import com.exemplo.av1.av1_empresa.repository.FuncionarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class Av1EmpresaApplication {
    public static void main(String[] args) {
        SpringApplication.run(Av1EmpresaApplication.class, args);
    }

    @Bean
    CommandLineRunner init(DepartamentoRepository dRepo, FuncionarioRepository fRepo) {
        return args -> {
            if (dRepo.count() == 0) {
                Departamento d1 = dRepo.save(new Departamento(null, "TI", "Prédio A"));
                Departamento d2 = dRepo.save(new Departamento(null, "RH", "Prédio B"));

                fRepo.save(new Funcionario(null, "Ana Silva","ana@example.com", LocalDate.of(2020,5,10), d1));
                fRepo.save(new Funcionario(null, "João Pereira","joao@example.com", LocalDate.of(2019,3,21), d2));
            }
        };
    }
}
