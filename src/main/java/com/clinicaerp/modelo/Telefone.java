package com.clinicaerp.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name="telefone")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(length = 2, nullable = false)
    private String ddd;

    @Column(length = 9, nullable = false)
    private String numero;

    /**
    @ManyToOne
    @JoinColumn(name = "codigo_funcionario")
    @JsonIgnore
    private Funcionario funcionario;
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefone telefone = (Telefone) o;
        return codigo.equals(telefone.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
