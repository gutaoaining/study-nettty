package org.example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

public class ByteBufferScatterAndGatherTest {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(8888);
        serverSocketChannel.socket().bind(address);
        int messageLength = 2 + 3 + 4;
        ByteBuffer[] buffers = new ByteBuffer[3];

        buffers[0] = ByteBuffer.allocate(2);
        buffers[1] = ByteBuffer.allocate(3);
        buffers[2] = ByteBuffer.allocate(4);

        SocketChannel socketChannel = serverSocketChannel.accept();

        while (true) {
            int byteReadLength = 0;
            while (byteReadLength < messageLength) {
                long r = socketChannel.read(buffers);
                byteReadLength += r;
                System.out.println("byteReadLength: " + byteReadLength);
                Arrays.asList(buffers).stream().map(buffer -> "position: " + buffer.position() + ", limit: " + buffer.limit()).forEach(System.out::println);
            }
            Arrays.asList(buffers).forEach(buffer -> {
                buffer.flip();
            });

            long byteWrittenLength = 0;
            while (byteWrittenLength < messageLength) {
                long w = socketChannel.write(buffers);
                byteWrittenLength += w;

            }
            Arrays.asList(buffers).forEach(byteBuffer -> {
                byteBuffer.clear();
            });
            System.out.println("byteReadLength: " + byteReadLength + ", byteWrittenLength: " + byteWrittenLength + ", messageLength: " + messageLength);
        }

    }
}
