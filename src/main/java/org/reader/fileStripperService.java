package org.reader;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;

public class fileStripperService {
    public static String stripTextFromPDF(PDDocument document) {
        try {
            if(document == null) {
                System.err.println("Documento nulo fornecido para extração de texto.");
                return "";
            }else if(document .getNumberOfPages() == 0) {
                System.out.println("O documento está vazio. Nada a extrair.");
                return "";
            }
            else{
                PDFTextStripper pdfStripper = new PDFTextStripper();
                return pdfStripper.getText(document);
            }
        } catch (IOException e) {
            System.err.println("Erro ao extrair texto do PDF: " + e.getMessage());
            e.printStackTrace();
            return "";
        }
    }
}
