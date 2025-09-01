package org.example;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File caminho_arquivo = new File("src/main/java/assets/acampamento.pdf"); // Caminho para o arquivo PDF
        try (PDDocument document = Loader.loadPDF(caminho_arquivo)) {

            if (document.isEncrypted()) {
                System.err.println("Erro: O documento está criptografado e não pode ser lido.");
                return;
            }

            PDFTextStripper stripper = new PDFTextStripper();

            String text = stripper.getText(document);
            System.out.println("--- INÍCIO DO TEXTO DO PDF ---");
            System.out.println(text);
            System.out.println("--- FIM DO TEXTO DO PDF ---");

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }
}