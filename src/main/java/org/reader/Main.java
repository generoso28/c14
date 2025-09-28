package org.reader;

public class Main {
    public static void main(String[] args) {
        IFileSelector fileSelector = new SwingFileSelector();
        FileSelectorService.selectAndReadFile(fileSelector);
    }
}