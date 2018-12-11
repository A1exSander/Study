package patternsHomework.xorFiles;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CryptoInputStream extends FilterInputStream {

    private byte[] password;
    private int currentPos=0;

    public CryptoInputStream(InputStream in, byte[] password) {
        super(in);
        this.password = password;
    }

    @Override
    public int read() throws IOException {
        int buffer =  super.read();
        buffer = buffer^password[currentPos%password.length];
        currentPos++;
        return buffer;
    }
}
