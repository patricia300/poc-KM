package com.poc.gestion.connaissance.repository;

import com.poc.gestion.connaissance.entity.DocumentIndex;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface DocumentRepository extends ElasticsearchRepository<DocumentIndex, String> {
    List<DocumentIndex> findByContenuContaining(String keyword);
}
