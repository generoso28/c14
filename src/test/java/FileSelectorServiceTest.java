import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.reader.IFileSelector;
import org.reader.FileReaderService;
import org.reader.FileSelectorService;

import java.io.File;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FileSelectorServiceTest {

    @Mock
    private IFileSelector fileSelectorMock; // Mock the interface

    @Test
    public void testSelectAndReadFile_WhenFileIsSelected() {
        // Arrange: Define the behavior of the mock
        File expectedFile = new File("src/test/resources/small.pdf");
        when(fileSelectorMock.selectFile()).thenReturn(expectedFile);

        // Mock the static fileReaderService.readFile call
        try (MockedStatic<FileReaderService> readerServiceMock = Mockito.mockStatic(FileReaderService.class)) {
            // Act: Call the service with the mock
            FileSelectorService.selectAndReadFile(fileSelectorMock);

            // Assert: Verify that readFile was called with the correct file
            readerServiceMock.verify(() -> FileReaderService.readFile(expectedFile), times(1));
        }
    }

    @Test
    public void testSelectAndReadFile_WhenSelectionIsCanceled() {
        // Arrange: Define the behavior of the mock to return null (user canceled)
        when(fileSelectorMock.selectFile()).thenReturn(null);

        // Mock the static fileReaderService.readFile call
        try (MockedStatic<FileReaderService> readerServiceMock = Mockito.mockStatic(FileReaderService.class)) {
            // Act: Call the service
            FileSelectorService.selectAndReadFile(fileSelectorMock);

            // Assert: Verify that readFile was never called
            readerServiceMock.verify(() -> FileReaderService.readFile(any()), never());
        }
    }
}