import org.junit.Test;
import org.reader.file_selector_service;
public class file_selector_service_test {
    @Test
    public void test_openFileSelector() {
        // Este teste é limitado, pois não podemos interagir com a GUI em um teste automatizado.
        // No entanto, podemos chamar o metodo para garantir que ele não lance exceções.
        file_selector_service.openFileSelector();
    }
}
