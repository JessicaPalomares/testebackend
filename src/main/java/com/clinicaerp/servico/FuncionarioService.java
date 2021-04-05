package com.clinicaerp.servico;

import com.clinicaerp.modelo.Funcionario;
import com.clinicaerp.servico.exception.UnicidadeCpfException;

public interface FuncionarioService {

    Funcionario salvar(Funcionario funcionario) throws UnicidadeCpfException;

}
