package com.senai.eli.Controller;

import com.senai.eli.Model.Grupo;
import com.senai.eli.Repository.EventoRepository;
import com.senai.eli.Repository.GrupoRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RestController
@RequestMapping("/grupo")
public class GrupoController {
    @Autowired
    private GrupoRepository grupoRepository;

    @PostMapping("/criar")
    public Grupo criarGrupo (@RequestBody Grupo grupo){
        return grupoRepository.save(grupo);
    }

    @GetMapping("/listarTodosGrupos")
    public List<Grupo> listarTodosOsGrupos(){
        return grupoRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Grupo pesquisarGrupoId(@PathVariable Long id){
        return grupoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/dell/{id}")
    public void deletarGrupo(@PathVariable Long id){
        grupoRepository.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Grupo atualizarGrupo(@PathVariable Long id, @RequestBody Grupo grupo){
        grupo.setNome(grupo.getNome());
        grupo.setResponsavel(grupo.getResponsavel());
        grupo.setEmail(grupo.getEmail());
        grupo.setDescricao(grupo.getDescricao());
        grupo.setId(id);
        grupoRepository.save(grupo);
        return grupo;
    }
}
