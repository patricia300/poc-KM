package com.poc.gestion.connaissance.service;

import com.poc.gestion.connaissance.entity.DocumentIndex;
import com.poc.gestion.connaissance.repository.DocumentRepository;
import org.apache.tika.exception.TikaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class IndexationService {
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private ExtractionService extractionService;

    public void indexerFichier(MultipartFile fichier) throws TikaException, IOException {
        String contenu = extractionService.extraireTexte(fichier);

        DocumentIndex documentIndex = new DocumentIndex();
        documentIndex.setNom(fichier.getOriginalFilename());
        documentIndex.setType(fichier.getContentType());
        documentIndex.setContenu(contenu);

        documentRepository.save(documentIndex);
    }

    public List<DocumentIndex> rechercheParMotCle(String motCle) {
        return documentRepository.findByContenuContaining(motCle);
    }

    public Iterable<DocumentIndex> getAllDocuments() {
        return documentRepository.findAll();
    }
}
