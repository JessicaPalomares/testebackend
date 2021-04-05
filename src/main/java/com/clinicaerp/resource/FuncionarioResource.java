package com.clinicaerp.resource;

import com.clinicaerp.modelo.Funcionario;
import com.clinicaerp.repository.FuncionarioRepository;
import com.clinicaerp.servico.FuncionarioService;
import com.clinicaerp.servico.exception.TelefoneNaoEncontradoException;
import com.clinicaerp.servico.exception.UnicidadeCpfException;
import com.clinicaerp.servico.exception.UnicidadeTelefoneException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioResource {


    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @PostMapping
    public ResponseEntity<Funcionario> salvarNova(@RequestBody Funcionario funcionario, HttpServletResponse response) throws UnicidadeCpfException, UnicidadeTelefoneException {
        final Funcionario funcionarioSalvo = funcionarioService.salvar(funcionario);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{ddd}/{numero}")
                .buildAndExpand(funcionario.getTelefones().get(0).getDdd(), funcionario.getTelefones().get(0).getNumero()).toUri();
        response.setHeader("Location", uri.toASCIIString());

        return new ResponseEntity<>(funcionarioSalvo, HttpStatus.CREATED);
    }
    @GetMapping
    public List<Funcionario>  listaFuncionarios(){
        return funcionarioRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Funcionario> unicoFuncionario(@PathVariable(value="id") long id){
        return funcionarioRepository.findById(id);
    }

    @ExceptionHandler({UnicidadeCpfException.class})
    public ResponseEntity<Erro> handleUnicidadeCpfException(UnicidadeCpfException e) {
        return new ResponseEntity<>(new Erro(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({TelefoneNaoEncontradoException.class})
    public ResponseEntity<Erro> handleTelefoneNaoEncontradoException(TelefoneNaoEncontradoException e) {
        return new ResponseEntity<>(new Erro(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    class Erro {
        private final String erro;

        public Erro(String erro) {
            this.erro = erro;
        }

        public String getErro() {
            return erro;
        }
    }

}
