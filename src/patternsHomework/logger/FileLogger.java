package patternsHomework.logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class FileLogger implements ILogger{

    @Override
    public void write(String message) {
        try (OutputStream out = new FileOutputStream("log.txt", true)){
            message = message + "\n";
            byte[] buffer = message.getBytes(Charset.defaultCharset());
            out.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
