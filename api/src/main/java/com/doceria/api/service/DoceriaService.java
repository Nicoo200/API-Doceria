package com.doceria.api.service;

import com.doceria.api.dto.DoceriaDto;
import com.doceria.api.model.DoceriaModel;
import com.doceria.api.repository.RepositoryDoceria;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DoceriaService {

    //ADICIONADO O POST
    private final RepositoryDoceria repositoryDoceria;

    public DoceriaService(RepositoryDoceria repositoryDoceria) {
        this.repositoryDoceria = repositoryDoceria;
    }

    public DoceriaModel createDoce(DoceriaDto doceriaDto) {
        DoceriaModel newDoce = new DoceriaModel(doceriaDto);
        return repositoryDoceria.save(newDoce);
    }

    // ADICIONANDO O GET

    public DoceriaModel getDoceById(UUID id) {
        return repositoryDoceria.findById(id).orElseThrow();
    }

    public List<DoceriaModel> getAllDoces() {
        return repositoryDoceria.findAll();
    }

    // ADICIONANDO O PUT
    public void updateDoce(UUID id, DoceriaDto doceriaDto){
        DoceriaModel existingModel =  repositoryDoceria.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Doce com ID " + id + " não encontrado"));

        existingModel.setNome(doceriaDto.nome());
        existingModel.setValor(doceriaDto.valor());
        existingModel.setDescricao(doceriaDto.descricao());
        existingModel.setImgUrl(doceriaDto.imgUrl());

        repositoryDoceria.save(existingModel);
    }

    public void deleteById(String id) {
        var doceid =UUID.fromString(id);

        var doceExists = repositoryDoceria.existsById(doceid);

        if (doceExists){
            repositoryDoceria.deleteById(doceid);
        }

    }

}
