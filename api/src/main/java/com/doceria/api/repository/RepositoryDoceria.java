package com.doceria.api.repository;

import com.doceria.api.model.DoceriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositoryDoceria extends JpaRepository <DoceriaModel, UUID>{
}
