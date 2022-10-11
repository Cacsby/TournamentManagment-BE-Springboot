package it.mcacialli.gestionalepartitespring.controller;

import it.mcacialli.gestionalepartitespring.controller.dto.request.CampoRequest;
import it.mcacialli.gestionalepartitespring.controller.dto.response.CampoResponse;
import it.mcacialli.gestionalepartitespring.service.CampoService;
import it.mcacialli.gestionalepartitespring.model.Campo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("/campo"))
public class CampoController {

    @Autowired
    CampoService campoService;

    @GetMapping
    public Iterable<Campo> getAll(){
        return campoService.getAll();
    }

    //CREAZIONE NUOVO CAMPO
    @PostMapping
    public ResponseEntity<CampoResponse> create(@RequestBody CampoRequest campo) {
        try{
        CampoResponse campoResponse= campoService.createCampo(campo);
        return new ResponseEntity<>(campoResponse, HttpStatus.OK);}
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
