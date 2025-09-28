package org.reader;

import org.apache.pdfbox.pdmodel.PDDocument;

public class PrintFileService {
    public static void printFile(PDDocument document) {
        if(document == null) {
            System.err.println("Documento nulo fornecido para impressão.");
            return;
        }
        else if(document.getNumberOfPages() == 0) {
                System.out.println("O documento está vazio. Nada a imprimir.");
                return;
        }
        else{
            System.out.println(
                    "--- INÍCIO DO TEXTO DO PDF ---\n"
                            + FileStripperService.stripTextFromPDF(document) +
                            "\n--- FIM DO TEXTO DO PDF ---");
        }

    }
}
