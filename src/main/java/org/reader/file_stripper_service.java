package org.reader;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;

public class file_stripper_service {
    public static String stripTextFromPDF(PDDocument document) {
        try {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document);
        } catch (IOException e) {
            System.err.println("Erro ao extrair texto do PDF: " + e.getMessage());
            e.printStackTrace();
            return "";
        }
    }
}
