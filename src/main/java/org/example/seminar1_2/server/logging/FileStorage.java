package org.example.seminar1_2.server.logging;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileStorage implements Repository<String> {
    public static final String PATHFORLOG = "src/main/java/org/example/chat.txt";
    @Override
    public void logging(String text) {
        try (FileWriter writer = new FileWriter(PATHFORLOG, true)) {
            writer.write(text);
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String readLog() {
        StringBuilder sb = new StringBuilder();
        try (FileReader reader = new FileReader(PATHFORLOG)) {
            int ch;
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            sb.delete(sb.length() - 1, sb.length());
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
