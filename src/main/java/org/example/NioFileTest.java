package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioFileTest {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("inputFile.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("outputFile.txt");

        FileChannel fileChannelInput = fileInputStream.getChannel();
        FileChannel fileChannelOutput = fileOutputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(20);
        while (true) {
            buffer.clear();
            int read = fileChannelInput.read(buffer);
            System.out.println("-----read-----" + buffer);
            System.out.println("buffer position : " + buffer.position());
            System.out.println("buffer limit : " + buffer.limit());

            if (read == -1) {
                break;
            }
            buffer.flip();
            fileChannelOutput.write(buffer);
        }
        fileChannelInput.close();
        fileChannelOutput.close();

    }
}
