package com.clinicaerp.modelo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Data
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(length = 80, nullable = false)
    private String nome;

    @Column(length = 11, nullable = false)
    private String cpf;

    @Column(nullable = false)
    private double salario;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn( name = "codigo_funcionario", referencedColumnName = "codigo")
    private List<Endereco> enderecos;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn( name = "codigo_funcionario", referencedColumnName = "codigo")
    private List<Telefone> telefones;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return codigo.equals(that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
