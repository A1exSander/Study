package lesson27;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.*;

public class NioApi {
    // Channel:
//    FileChannel
//    DatagramChannel UDP протокол
//    SocketChannel TCP клиент
//    ServerSocketChannel TCP сервер

    // Buffer
    // Selector

    public static void write(File file) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            FileChannel channel = raf.getChannel();
            String text = "Text\n" + "Text\n" + "Text\n";
            byte[] bytes = text.getBytes(Charset.forName("utf-8"));
            // Создаем буфер для записи данных
            ByteBuffer buffer = ByteBuffer.allocate(512);
            // Заполняем буфер данными
            buffer.put(bytes);
            // ставим limit на позицию курсора автоматически курсор перемещается в начало
            buffer.flip();
            // записываем данные з буфера в канал
            // курсор переместится на позицию, равную количеству записанных байт
            int written = channel.write(buffer);
            System.out.println("written: " + written + "bytes to file " + file.getAbsolutePath());
        }
    }

    public static void read(File file) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")){
            FileChannel channel = raf.getChannel();

            // буфер для чтения данных
            ByteBuffer buffer = ByteBuffer.allocate(512);
            StringBuilder builder = new StringBuilder();

            // Считывание данных
            while (channel.read(buffer) !=-1){
                builder.append(new String(buffer.array(), 0, buffer.remaining()));
                // очистка буфера для следующего чтения
                buffer.clear();
            }
            System.out.println("Read from file " + file + ": ");
            System.out.println(builder);
        }
    }


    public static void main(String[] args) throws IOException {
        try {
            write(new File("nioTest.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Buffer
//        capacity - емкость (не меняется)
//        position - текущее положение курсора
//        limit - предел для позиции
        ByteBuffer buffer = ByteBuffer.allocate(512);
//        Методы для того, чтобы положить в буфе и добавить к нему данные
//        buffer.get();
//        buffer.put();
//        buffer.flip() - перемещает курсор в начало и задает лимит, если буфер больше инфы
//        buffer.rewind() - сброс позиции на ноль

//        buffer.clear() - очистка буфера
//        buffer.remaining() - показывает разницу между лимитом и позицией
//        buffer.position() - возвращает позиципию в буфер (Позицию курсора)
        buffer.limit(buffer.remaining());

//        Path path = Paths.get();
//        path.getFileName();

        Path dir = Paths.get("src");

        WatchService watcher = FileSystems.getDefault().newWatchService();

        while(true) {
            WatchKey key = null;
            try {
                key = watcher.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (WatchEvent event: key.pollEvents()) {
                switch (event.kind().name()){

                }
            }
        }
    }
}
