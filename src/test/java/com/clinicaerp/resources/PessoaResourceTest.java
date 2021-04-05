package com.clinicaerp.resources;


import com.clinicaerp.ClinicaerpApplicationTests;
import com.clinicaerp.modelo.Funcionario;
import com.clinicaerp.modelo.Telefone;
import com.clinicaerp.repository.FuncionarioRepository;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PessoaResourceTest extends ClinicaerpApplicationTests {

    @Test
    public void deve_salvar_um_novo_funcionario() throws Exception {
        final Funcionario funcionario = new Funcionario();
        funcionario.setNome("Lorenzo");
        funcionario.setCpf("62461410720");
        funcionario.setSalario(150.00f);

        final Telefone telefone = new Telefone();
        telefone.setDdd("79");
        telefone.setNumero("36977168");

        funcionario.setTelefones(Arrays.asList(telefone));

        given()
                .request()
                .header("Accept", ContentType.ANY)
                .header("Content-type", ContentType.JSON)
                .body(funcionario)
                .when()
                .post("/funcionarios")
                .then()
                .log().headers()
                .and()
                .log().body()
                .and()
                .statusCode(HttpStatus.CREATED.value())
                .header("Location", equalTo("http://localhost:"+porta+"/funcionarios/79/36977168"))
                .body("codigo", equalTo(6),
                        "nome", equalTo("Lorenzo"),
                        "cpf", equalTo("62461410720"));
    }

    @Test
    public void nao_deve_salvar_dois_funcionarios_com_o_mesmo_cpf() throws Exception {

        final Funcionario funcionario = new Funcionario();
        funcionario.setNome("Lorenzo");
        funcionario.setCpf("78673781620");
        funcionario.setSalario(150.00f);

        final Telefone telefone = new Telefone();
        telefone.setDdd("79");
        telefone.setNumero("36977168");

        funcionario.setTelefones(Arrays.asList(telefone));

        given()
                .request()
                .header("Accept", ContentType.ANY)
                .header("Content-type", ContentType.JSON)
                .body(funcionario)
                .when()
                .post("/funcionarios")
                .then()
                .log().body()
                .and()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body("erro", equalTo("Já existe funcionario cadastrado com o CPF '78673781620'"));
    }
}
