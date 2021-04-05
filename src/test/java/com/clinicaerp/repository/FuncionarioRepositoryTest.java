package com.clinicaerp.repository;

import com.clinicaerp.modelo.Funcionario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Sql(value = "/load-database.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/clean-database.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@TestPropertySource("classpath:application-test.properties")
public class FuncionarioRepositoryTest {

    @Autowired
    private FuncionarioRepository sut;

    @Test
    public void deve_procurar_funcionario_pelo_cpf() throws Exception {

        Optional<Funcionario> optional = sut.findByCpf("38767897100");

        assertThat(optional.isPresent()).isTrue();

        Funcionario funcionario = optional.get();
        assertThat(funcionario.getCodigo()).isEqualTo(3L);
        assertThat(funcionario.getNome()).isEqualTo("Cauê");
        assertThat(funcionario.getCpf()).isEqualTo("38767897100");

    }

}
