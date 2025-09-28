package org.reader;

import javax.swing.*;
import java.io.File;
public class SwingFileSelector implements IFileSelector {

    @Override
    public File selectFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null; // Return null if the user cancels
    }
}