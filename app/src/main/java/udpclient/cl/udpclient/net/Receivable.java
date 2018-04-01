package udpclient.cl.udpclient.net;

import java.io.IOException;

/**
 * Created by martin on 01-04-18.
 */

public interface Receivable {
    public byte[] receivData() throws IOException;
    public String receivMsg() throws IOException;
    public byte receivByte() throws IOException;
}
