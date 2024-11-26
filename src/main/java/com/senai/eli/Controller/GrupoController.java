package com.senai.eli.Controller;

import com.senai.eli.Model.Grupo;
import com.senai.eli.Repository.EventoRepository;
import com.senai.eli.Repository.GrupoRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
public class GrupoController {
    @Autowired
    private GrupoRepository gr;

    @PostMapping("/grupo/criar")
    public String criar (){
        return "evento/criar";
    }

    @PostMapping("grupo/criar")
    public String criar(Grupo gp){
        gr.save(gp);
        return "redirect:/grupo";
    }

    @GetMapping("/evento")
    public String listar(Model view){
        List<Grupo> listaGrupos = gr.findAll();

        view.addAttribute("listaGruposNoFront", listaGrupos);

        return "evento/listar";
    }

    @GetMapping("/grupo/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model){
        Grupo grupo;
        grupo = gr.findById(id).orElseThrow();

        model.addAttribute("grupo", grupo);
        return "grupo/alterar";
    }

    @PostMapping("/evento/alterar/{id}")
    public String alterar(@PathVariable Long id, Grupo gp){
        gp.setId(id);
        gr.save(gp);
        return "redirect:/evento";
    }
}