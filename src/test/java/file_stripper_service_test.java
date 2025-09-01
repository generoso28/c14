import org.junit.Test;
import org.reader.file_stripper_service;

import java.io.IOException;

public class file_stripper_service_test {
    @Test
    public void test_strip_null() throws IOException {
        file_stripper_service.stripTextFromPDF(null); // Tenta ler um arquivo que não é PDF
    }
    @Test
    public void test_strip_empty_document() throws IOException {
        file_stripper_service.stripTextFromPDF(new org.apache.pdfbox.pdmodel.PDDocument()); // Tenta ler um arquivo vazio
    }
    @Test
    public void test_strip_large_document() throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.Loader.loadPDF(new java.io.File("src/test/resources/large_file.pdf"));
        file_stripper_service.stripTextFromPDF(doc); // Tenta ler um arquivo válido e grande
        doc.close();
    }
    @Test
    public void test_strip_small_document() throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.Loader.loadPDF(new java.io.File("src/test/resources/small.pdf"));
        file_stripper_service.stripTextFromPDF(doc); // Tenta ler um arquivo válido
        doc.close();
    }
    @Test
    public void test_strip_special_char_document() throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.Loader.loadPDF(new java.io.File("src/test/resources/special.pdf"));
        file_stripper_service.stripTextFromPDF(doc); // Tenta ler um arquivo com imagens e caracteres especiais
        doc.close();
    }
    @Test
    public void test_strip_corrupted_document() throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.Loader.loadPDF(new java.io.File("src/test/resources/corrupted.pdf"));
        file_stripper_service.stripTextFromPDF(doc); // Tenta ler um arquivo PDF corrompido
        doc.close();
    }
    @Test
    public void test_strip_encrypted_document() throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.Loader.loadPDF(new java.io.File("src/test/resources/encrypted.pdf"));
        file_stripper_service.stripTextFromPDF(doc); // Tenta ler um arquivo criptografado
        doc.close();
    }
    @Test
    public void test_strip_non_pdf_document() throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.Loader.loadPDF(new java.io.File("src/test/resources/not_a_pdf.txt"));
        file_stripper_service.stripTextFromPDF(doc); // Tenta ler um arquivo que não é PDF
        doc.close();
    }
}
