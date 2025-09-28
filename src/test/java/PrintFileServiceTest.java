import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.Test;
import org.reader.PrintFileService;
public class PrintFileServiceTest {
    @Test
    public void test_print_null() {
        PrintFileService.printFile(null); // Tenta imprimir um arquivo nulo
    }
    @Test
    public void test_print_empty() {
        PrintFileService.printFile(new PDDocument()); // Tenta imprimir um arquivo vazio
    }
    @Test
    public void test_print_large_document() throws Exception {
        PDDocument doc = org.apache.pdfbox.Loader.loadPDF(new java.io.File("src/test/resources/large_file.pdf"));
        PrintFileService.printFile(doc); // Tenta imprimir um arquivo válido e grande
        doc.close();
    }
}