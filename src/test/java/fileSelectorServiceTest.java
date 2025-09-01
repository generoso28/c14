import org.junit.Test;
import org.reader.fileSelectorService;
public class fileSelectorServiceTest {
    @Test
    public void test_openFileSelector() {
        // Este teste é limitado, pois não podemos interagir com a GUI em um teste automatizado.
        // No entanto, podemos chamar o metodo para garantir que ele não lance exceções.
        fileSelectorService.openFileSelector();
    }
}
