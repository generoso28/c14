package org.reader;
import java.io.File;

public class FileSelectorService {

    // The service now depends on the interface, making it easy to test.
    public static void selectAndReadFile(IFileSelector fileSelector) {
        File selectedFile = fileSelector.selectFile();

        if (selectedFile != null) {
            FileReaderService.readFile(selectedFile);
        } else {
            System.out.println("Nenhum arquivo selecionado.");
        }
    }
}