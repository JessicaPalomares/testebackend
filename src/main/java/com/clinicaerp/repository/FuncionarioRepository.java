package com.clinicaerp.repository;

import com.clinicaerp.modelo.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {

    Optional<Funcionario> findByCpf(String cpf);
    Optional<Funcionario> findById(long id);
}
