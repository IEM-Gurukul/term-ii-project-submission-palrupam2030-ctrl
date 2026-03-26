package com.passwordgen.util;

import java.io.FileWriter;
import java.io.IOException;

public class PasswordFileManager {

    public static void savePasswordToFile(String password, String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName, true);
        writer.write("Generated Password: " + password + System.lineSeparator());
        writer.close();
    }
}