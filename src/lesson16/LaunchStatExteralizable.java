package lesson16;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

public class LaunchStatExteralizable implements Externalizable {
    private static final long serialVersionUID = 0L;
    private static final int VERSION = 1;
    private int launchCount;
    private Date lastLaunch;
    private String lastUser;

    public void update() {
        launchCount++;
        lastLaunch = new Date();
        lastUser = System.getProperty("user.name");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

        out.writeInt(VERSION);
        out.writeInt(launchCount);
        out.writeObject(lastLaunch);
        out.writeUTF(lastUser);

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int version = in.readInt();
        if (version > VERSION) {
            throw new IOException("unsupported version");
        }
        launchCount = in.readInt();
        lastLaunch = (Date) in.readObject();

        if (version > 0) {
            lastUser = in.readUTF();
        }
    }

    public boolean isFirstLaunch() {
        return launchCount == 0 && lastLaunch == null;
    }


    @Override
    public String toString() {
        return "LaunchStatExteralizable{" +
                "launchCount=" + launchCount +
                ", lastLaunch=" + lastLaunch +
                ", lastUser='" + lastUser + '\'' +
                '}';
    }
}
