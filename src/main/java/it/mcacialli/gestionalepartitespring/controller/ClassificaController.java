package it.mcacialli.gestionalepartitespring.controller;

import it.mcacialli.gestionalepartitespring.controller.dto.response.TeamResponse;
import it.mcacialli.gestionalepartitespring.service.ClassificaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(("/classifica"))
public class ClassificaController {

    @Autowired
    ClassificaService classificaService;

    @GetMapping
    public List<TeamResponse> classifica() {
        return classificaService.classificaTotalScore();
    }


}
