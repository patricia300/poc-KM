package com.poc.gestion.connaissance.controller;

import com.poc.gestion.connaissance.entity.DocumentIndex;
import com.poc.gestion.connaissance.service.IndexationService;
import org.apache.tika.exception.TikaException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentController {
    private final IndexationService indexationService;

    public DocumentController(IndexationService indexationService) {
        this.indexationService = indexationService;
    }

    @PostMapping("/telecharger")
    public ResponseEntity<Void> telecharger(@RequestParam("fichier") MultipartFile fichier) throws TikaException, IOException {
        indexationService.indexerFichier(fichier);
        return ResponseEntity.ok().build();
    }

    @GetMapping("recherche")
    public ResponseEntity<List<DocumentIndex>> recherche(@RequestParam String motCle) {
        return  ResponseEntity.ok(indexationService.rechercheParMotCle(motCle));
    }

    @GetMapping
    public ResponseEntity<Iterable<DocumentIndex>> getAllDocuments() {
        return ResponseEntity.ok(indexationService.getAllDocuments());
    }
}
