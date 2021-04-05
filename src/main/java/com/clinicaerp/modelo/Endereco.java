package com.clinicaerp.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;

    /**@ManyToOne
    @JoinColumn(name = "codigo_funcionario")
    @JsonIgnore
    private Funcionario funcionario;
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return codigo.equals(endereco.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
