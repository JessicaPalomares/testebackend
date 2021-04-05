package com.clinicaerp.servico.impl;

import com.clinicaerp.modelo.Funcionario;
import com.clinicaerp.modelo.Telefone;
import com.clinicaerp.repository.FuncionarioRepository;
import com.clinicaerp.repository.TelefoneRepository;
import com.clinicaerp.servico.FuncionarioService;
import com.clinicaerp.servico.exception.UnicidadeCpfException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;


    public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;



    }

    @Override
    public Funcionario salvar(Funcionario funcionario) throws UnicidadeCpfException
    {

        Optional<Funcionario> optional = funcionarioRepository.findByCpf(funcionario.getCpf());

        if(optional.isPresent()){
            throw new UnicidadeCpfException("Já existe funcionario cadastrado com o CPF '"+funcionario.getCpf()+"'");
        }

        return funcionarioRepository.save(funcionario);
    }
}
