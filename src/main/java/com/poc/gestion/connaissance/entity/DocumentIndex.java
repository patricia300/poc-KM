package com.poc.gestion.connaissance.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "documents")
@Data
public class DocumentIndex {
    @Id
    private String id;
    private String nom;
    private String type;
    private String contenu;
}
