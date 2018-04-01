package udpclient.cl.udpclient.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Arrays;

/**
 * Created by martin on 01-04-18.
 */

public class UDPClient implements Communicable {
    private DatagramSocket dataSock;
    private DatagramPacket sendPacket;
    private DatagramPacket recvPacket;

    public UDPClient() throws SocketException {
        this.dataSock = new DatagramSocket();
    }

    public UDPClient(String host, int port) throws SocketException {
        this();
        connectTo(host, port);
    }

    public void connectTo(String host, int port) throws SocketException {
        dataSock.connect(new InetSocketAddress(host, port));
        sendPacket = new DatagramPacket(new byte[1024], 1024, dataSock.getRemoteSocketAddress());
        recvPacket = new DatagramPacket(new byte[1024], 1024);
    }

    public void send(byte[] data) throws IOException {
        sendPacket.setData(data);
        dataSock.send(sendPacket);
    }
    public void send(String data) throws IOException {
        send(data.getBytes());
    }
    public void send(byte b) throws IOException {
        byte[] data = {b};
        send(data);
    }

    public byte[] receivData() throws IOException {
        dataSock.receive(recvPacket);
        byte[] rawData = recvPacket.getData();
        int transfLen = recvPacket.getLength();
        if (rawData.length > transfLen)
            rawData = Arrays.copyOf(rawData, transfLen);
        return rawData;
    }

    public String receivMsg() throws IOException {
        return new String(receivData());
    }
    public byte receivByte() throws IOException {
        return receivData()[0];
    }

}
