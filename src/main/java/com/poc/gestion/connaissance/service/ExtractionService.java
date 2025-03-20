package com.poc.gestion.connaissance.service;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ExtractionService {
    private final Tika tika = new Tika();

    public String extraireTexte(MultipartFile fichier) throws IOException, TikaException {
        return tika.parseToString(fichier.getInputStream());
    }
}
