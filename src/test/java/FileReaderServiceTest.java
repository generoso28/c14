import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.reader.FileReaderService;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class FileReaderServiceTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    // Captura a saída do console antes de cada teste
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    // Restaura a saída do console depois de cada teste
    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    // Testes Positivos

    @Test
    public void test_read_small_valid_file() {
        FileReaderService.readFile(new File("src/test/resources/small.pdf"));
        assertTrue(outContent.toString().contains("A Luta (Agon) de Paulo em Favor da Igreja"));
    }

    @Test
    public void test_read_large_valid_file() {
        FileReaderService.readFile(new File("src/test/resources/large_file.pdf"));
        assertTrue(outContent.toString().contains("WILLIAM BARCLAY"));
    }

    @Test
    public void test_read_empty_pdf_file() {
        FileReaderService.readFile(new File("src/test/resources/empty.pdf"));
        // Verifica se imprime o cabeçalho e rodapé, mesmo com o conteúdo vazio
        assertTrue(outContent.toString().contains("--- INÍCIO DO TEXTO DO PDF ---"));
        assertTrue(outContent.toString().contains("--- FIM DO TEXTO DO PDF ---"));
    }

    @Test
    public void test_read_file_with_special_chars() {
        FileReaderService.readFile(new File("src/test/resources/special.pdf"));
        assertTrue(outContent.toString().contains("O Ministério de Paulo em"));
    }

    // Testes Negativos

    @Test
    public void test_read_non_existent_file() {
        FileReaderService.readFile(new File("src/test/resources/non_existent_file.pdf"));
        assertTrue(outContent.toString().contains("Erro ao ler o arquivo PDF:"));
    }

    @Test
    public void test_read_non_pdf_file() {
        FileReaderService.readFile(new File("src/test/resources/not_a_pdf.txt"));
        assertTrue(outContent.toString().contains("Erro ao ler o arquivo PDF:"));
    }

    @Test
    public void test_read_null_file() {
        // A biblioteca PDFBox lança uma NullPointerException se o arquivo for nulo,
        // que não é uma IOException. O teste verifica se essa exceção não tratada ocorre.
        assertThrows(NullPointerException.class, () -> {
            FileReaderService.readFile(null);
        });
    }

    @Test
    public void test_read_encrypted_file() {
        FileReaderService.readFile(new File("src/test/resources/encrypted.pdf"));
        assertTrue(outContent.toString().contains("Erro ao ler o arquivo PDF: Cannot decrypt PDF, the password is incorrect"));
    }

    @Test
    public void test_read_corrupted_file() {
        FileReaderService.readFile(new File("src/test/resources/corrupted.pdf"));
        assertTrue(outContent.toString().contains("Erro ao ler o arquivo PDF:"));
    }
}