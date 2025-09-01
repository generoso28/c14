package org.reader;

import javax.swing.*;
import java.io.File;

public class fileSelectorService
{
    public static void openFileSelector()
    {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            fileReaderService.readFile(selectedFile);
        } else {
            System.out.println("Nenhum arquivo selecionado.");
        }
    }
}
