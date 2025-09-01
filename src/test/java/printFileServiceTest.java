import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.Test;
import org.reader.printFileService;
public class printFileServiceTest {
    @Test
    public void test_print_null() {
        printFileService.printFile(null); // Tenta imprimir um arquivo nulo
    }
    @Test
    public void test_print_empty() {
        printFileService.printFile(new PDDocument()); // Tenta imprimir um arquivo vazio
    }
    @Test
    public void test_print_large_document() throws Exception {
        PDDocument doc = org.apache.pdfbox.Loader.loadPDF(new java.io.File("src/test/resources/large_file.pdf"));
        printFileService.printFile(doc); // Tenta imprimir um arquivo válido e grande
        doc.close();
    }
}
