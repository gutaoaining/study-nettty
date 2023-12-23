package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class ReplaceFileContext {

    public static void main(String[] args) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile("directInputFile.txt", "rw");
        FileChannel fileChannel = accessFile.getChannel();
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        mappedByteBuffer.put(1, (byte) 'g');
        mappedByteBuffer.put(4, (byte) 'z');
        System.out.println("测试代码提交");
        accessFile.close();
    }
}
