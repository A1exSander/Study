package lesson26;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.*;

public class Logged {
    // создание логгера
    private static final Logger LOGGER = Logger.getLogger(Logged.class.getName());

    static {
        // Установка уровня логирования
        LOGGER.setLevel(Level.INFO);
    }

    public static void main(String[] args) {
        LOGGER.info("Started with args: " + Arrays.toString(args));

        try {
            int result = 3/0;
        } catch (Exception e){
            LOGGER.severe("Fatal error: " + e.getMessage());
        }
    }
}

class LoggedFile {
    private static final Logger LOGGER = Logger.getLogger(Logged.class.getName());

    static {
        try {
            LOGGER.addHandler(new FileHandler("logged.log.xml"));

            FileHandler fileHandler = new FileHandler("logged.log");
            fileHandler.setFormatter(new MyFormatter());

            LOGGER.addHandler(fileHandler);

        } catch (IOException e) {
            LOGGER.warning("Не удалось создать файл");
        }
    }

    public static void main(String[] args) {
        LOGGER.info("Started with args: " + Arrays.toString(args));

        try {
            int result = 3/0;
        } catch (Exception e){
            LOGGER.severe("Fatal error: " + e.getMessage());
        }
    }
}

class MyFormatter extends Formatter {

    private final static ThreadLocal<DateFormat> dateformat = new ThreadLocal<DateFormat>(){

        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    @Override
    public String format(LogRecord record) {
        // свой формат записи в файл
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[")
                .append(formatTime(record.getMillis()))
                .append("]");
        stringBuilder.append("[")
                .append(record.getLevel())
                .append("]");
        stringBuilder.append("\n");
        stringBuilder.append(record.getMessage());
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }

    private String formatTime(long mls) {
        return dateformat.get().format(new Date(mls));
    }
}