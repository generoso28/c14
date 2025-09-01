package org.reader;

import org.apache.pdfbox.pdmodel.PDDocument;

public class print_file_service {
    public static void printFile(PDDocument document) {
        System.out.println(
                "--- INÍCIO DO TEXTO DO PDF ---\n"
                        + file_stripper_service.stripTextFromPDF(document) +
                        "\n--- FIM DO TEXTO DO PDF ---");
    }
}
