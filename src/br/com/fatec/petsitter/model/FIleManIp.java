package br.com.fatec.petsitter.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FIleManIp {
    private File dir, file;

    public static FIleManIp open(String dir, String file) {
        FIleManIp fl = new FIleManIp();
        fl.dir = new File(dir);
        fl.file = new File(file);
        return fl;
    }

    public void checkIfExists() {
        if (!dir.exists()) {
            createFolder();
            createFile();
        }
    }

    private void createFile() {
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Não foi possível criar novo arquivo");
            e.printStackTrace();
        }
    }

    private void createFolder() {
        if (!dir.mkdirs()) {
            System.out.println("Não foi possível criar a pasta");
            return;
        }
    }

    public void WriteInFile(String toWrite) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(toWrite);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}