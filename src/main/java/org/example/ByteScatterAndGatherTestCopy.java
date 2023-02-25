package org.example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

public class ByteScatterAndGatherTestCopy {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(9999);
        serverSocketChannel.socket().bind(address);
        int messageLength = 2 + 3 + 4;
        ByteBuffer[] buffers = new ByteBuffer[3];
        buffers[0] = ByteBuffer.allocate(2);
        buffers[1] = ByteBuffer.allocate(3);
        buffers[2] = ByteBuffer.allocate(4);
        SocketChannel socketChannel = serverSocketChannel.accept();
        while (true) {
            int readMessageLength = 0;
            while (readMessageLength < messageLength) {
                long readLength = socketChannel.read(buffers);
                readMessageLength += readLength;
                System.out.println("read length: " + readMessageLength);
                Arrays.asList(buffers).stream().map(buffer -> "position: " + buffer.position() + ", limit: " + buffer.limit()).forEach(System.out::println);
            }
            Arrays.asList(buffers).forEach(buffer ->
                    buffer.flip()
            );
            int writeLength = 0;
            while (writeLength < messageLength) {
                long writtenLength = socketChannel.write(buffers);
                writeLength += writtenLength;
            }
            Arrays.asList(buffers).forEach(buffer -> buffer.clear());
            System.out.println("byteReadLength: " + readMessageLength + ", writeLength: " + writeLength + ", messageLength: " + messageLength);
        }


    }
}
