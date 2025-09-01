package org.reader;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import javax.swing.JFileChooser;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        file_selector_service.openFileSelector();
    }
}