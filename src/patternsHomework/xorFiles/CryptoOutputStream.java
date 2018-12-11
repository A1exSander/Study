package patternsHomework.xorFiles;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CryptoOutputStream extends FilterOutputStream {

    private byte[] password;
    private int currentPos;

    public CryptoOutputStream(OutputStream out, byte[] password) {
        super(out);
        this.password = password;
    }

    @Override
    public void write(int b) throws IOException {
        b = b^password[currentPos%password.length];
        currentPos++;
        super.write(b);
    }
}

