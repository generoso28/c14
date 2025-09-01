package org.reader;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class file_reader_service {
    public static void readFile(File filePath) {
        try (PDDocument document = Loader.loadPDF(filePath)) {
            if (document.isEncrypted()) {
                System.out.println("Erro: O documento está criptografado e não pode ser lido.");
            }
            print_file_service.printFile(document);

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo PDF: " + e.getMessage());
        }
    }
}
