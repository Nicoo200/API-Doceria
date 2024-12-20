package com.doceria.api.controller;

import com.doceria.api.dto.DoceriaDto;
import com.doceria.api.model.DoceriaModel;
import com.doceria.api.repository.RepositoryDoceria;
import com.doceria.api.service.DoceriaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/doceria")
public class DoceriaController {

    private final DoceriaService doceriaService;
    private final RepositoryDoceria repositoryDoceria;

    public DoceriaController(DoceriaService doceriaService, RepositoryDoceria repositoryDoceria) {
        this.doceriaService = doceriaService;
        this.repositoryDoceria = repositoryDoceria;
    }

    @PostMapping("/new")
    public ResponseEntity<DoceriaModel> createDoce(@Valid @RequestBody DoceriaDto doceriaDto) {
        DoceriaModel newDoce = doceriaService.createDoce(doceriaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDoce);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoceriaModel> getDoceById(@PathVariable UUID id) {
        DoceriaModel doceriaModel = doceriaService.getDoceById(id);
        return ResponseEntity.ok(doceriaModel);
    }

    @GetMapping
    public ResponseEntity<List<DoceriaModel>> getAllDoces() {
        List<DoceriaModel> allDoces = doceriaService.getAllDoces();
        return ResponseEntity.ok(allDoces);
    }

    @PutMapping("/edit{id}")
    public ResponseEntity<Void> updateDoce(@PathVariable UUID id, @RequestBody DoceriaDto doceriaDto) {
        doceriaService.updateDoce(id, doceriaDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/dell{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id){
        doceriaService.deleteById(String.valueOf(id));
        return ResponseEntity.noContent().build();
    }


}


