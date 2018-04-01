package udpclient.cl.udpclient.net;

import java.io.IOException;

/**
 * Created by martin on 01-04-18.
 */

public interface Transmissible {
    public void send(byte[] data) throws IOException;
    public void send(String data) throws IOException;
    public void send(byte b) throws IOException;
}
