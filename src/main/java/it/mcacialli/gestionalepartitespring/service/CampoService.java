package it.mcacialli.gestionalepartitespring.service;

import it.mcacialli.gestionalepartitespring.repository.CampoRepository;
import it.mcacialli.gestionalepartitespring.controller.dto.request.CampoRequest;
import it.mcacialli.gestionalepartitespring.controller.dto.response.CampoResponse;
import it.mcacialli.gestionalepartitespring.model.Campo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampoService {
    @Autowired
    CampoRepository campoRepository;
    public List<Campo> getAll(){
        return campoRepository.findAll();
    }

    //CREA CAMPO
    public CampoResponse createCampo(CampoRequest request) {
        Campo campo= new Campo();
        campo.setIndirizzoCampo(request.getIndirizzoCampo());
        campo.setNomeCampo(request.getNomeCampo());
        return new CampoResponse(campoRepository.save(campo));
    }
}
