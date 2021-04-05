package com.clinicaerp.servico;


import com.clinicaerp.modelo.Funcionario;
import com.clinicaerp.repository.FuncionarioRepository;
import com.clinicaerp.servico.exception.UnicidadeCpfException;
import com.clinicaerp.servico.impl.FuncionarioServiceImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FuncionarioServiceTest {

    private  static final String NOME = "Jessica Palomares";
    private  static final String CPF = "06126244715";


    private FuncionarioService sut;

    @MockBean
    private FuncionarioRepository funcionarioRepository;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Funcionario funcionario;

    @Before
    public void setup() throws Exception{
        sut = new FuncionarioServiceImpl(funcionarioRepository);

        funcionario = new Funcionario();
        funcionario.setNome(NOME);
        funcionario.setCpf(CPF);

        when(funcionarioRepository.findByCpf(CPF)).thenReturn(Optional.empty());
    }


    @Test
    public void deve_salvar_funcionario_no_repositorio() throws Exception{

        sut.salvar(funcionario);

        verify(funcionarioRepository).save(funcionario);
    }
    @Test
    public void nao_deve_salvar_dois_funcionarios_com_o_mesmo_cpf() throws  Exception{

        when(funcionarioRepository.findByCpf(CPF)).thenReturn(Optional.of(funcionario));

        expectedException.expect(UnicidadeCpfException.class);
        expectedException.expectMessage("Já existe funcionario cadastrado com o CPF '"+ CPF +"'");

        sut.salvar(funcionario);



    }


}
