import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.Test;
import org.reader.print_file_service;
public class print_file_service_test {
    @Test
    public void test_print_null() {
        print_file_service.printFile(null); // Tenta imprimir um arquivo nulo
    }
    @Test
    public void test_print_empty() {
        print_file_service.printFile(new PDDocument()); // Tenta imprimir um arquivo vazio
    }
    @Test
    public void test_print_large_document() throws Exception {
        PDDocument doc = org.apache.pdfbox.Loader.loadPDF(new java.io.File("src/test/resources/large_file.pdf"));
        print_file_service.printFile(doc); // Tenta imprimir um arquivo válido e grande
        doc.close();
    }
}
