package patternsHomework.logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Date;

public class TimeFileLogger implements ILogger {
    private Date date = new Date();

    @Override
    public void write(String message) {
        try (OutputStream out = new FileOutputStream("datedLog.txt", true)){
            message = message + "\n" + date + "\n";
            byte[] buffer = message.getBytes(Charset.defaultCharset());
            out.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
