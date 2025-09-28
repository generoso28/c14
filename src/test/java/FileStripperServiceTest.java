import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.Test;
import org.reader.FileStripperService;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class FileStripperServiceTest {

    // Testes Positivos

    @Test
    public void test_strip_small_document() throws IOException {
        try (PDDocument doc = Loader.loadPDF(new File("src/test/resources/small.pdf"))) {
            String text = FileStripperService.stripTextFromPDF(doc);
            assertNotNull(text);
            assertTrue(text.contains("A Luta (Agon) de Paulo em Favor da Igreja"));
        }
    }

    @Test
    public void test_strip_large_document() throws IOException {
        try (PDDocument doc = Loader.loadPDF(new File("src/test/resources/large_file.pdf"))) {
            String text = FileStripperService.stripTextFromPDF(doc);
            assertNotNull(text);
            assertTrue(text.contains("O NOVO TESTAMENTO Comentado por William Barclay"));
        }
    }

    @Test
    public void test_strip_empty_document() {
        try (PDDocument doc = new PDDocument()) {
            String text = FileStripperService.stripTextFromPDF(doc);
            assertNotNull(text);
            assertEquals("", text.trim());
        } catch (IOException e) {
            // Ignorar exceção, pois o documento está vazio
        }
    }

    @Test
    public void test_strip_special_char_document() throws IOException {
        try (PDDocument doc = Loader.loadPDF(new File("src/test/resources/special.pdf"))) {
            String text = FileStripperService.stripTextFromPDF(doc);
            assertNotNull(text);
            assertTrue(text.contains("O Ministério de Paulo em"));
        }
    }

    // Testes Negativos

    @Test
    public void test_strip_null_document() {
        // O método deve tratar o nulo graciosamente e retornar uma string vazia
        String text = FileStripperService.stripTextFromPDF(null);
        assertNotNull(text);
        assertEquals("", text);
    }

    @Test
    public void test_strip_closed_document() throws IOException {
        PDDocument doc = new PDDocument();
        doc.addPage(new org.apache.pdfbox.pdmodel.PDPage());
        doc.close(); // Fecha o documento antes de tentar extrair o texto

        // Tentar extrair de um documento fechado deve retornar uma string vazia
        String text = FileStripperService.stripTextFromPDF(doc);
        assertNotNull(text);
        assertEquals("", text);
    }
}