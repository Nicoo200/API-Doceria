package com.doceria.api.dto;

import com.doceria.api.model.DoceriaModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.UUID;

public record DoceriaDto(
        @NotBlank
        String nome,
        @NotNull
        @Positive
        double valor,
        String descricao,
        @NotBlank
        String imgUrl
) {

    public DoceriaDto(DoceriaModel doceriaModel) {
        this(
                doceriaModel.getNome(),
                doceriaModel.getValor(),
                doceriaModel.getDescricao(),
                doceriaModel.getImgUrl()
        );
    }
}