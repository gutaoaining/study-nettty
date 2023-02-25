package org.example;

import java.nio.ByteBuffer;

public class ReadOnlyByteBuffer {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        System.out.println(byteBuffer);
        for (int i = 0; i < byteBuffer.capacity(); i++) {
            byteBuffer.put((byte) i);
        }
        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        System.out.println(readOnlyBuffer);
        readOnlyBuffer.position(0);
//        readOnlyBuffer.put((byte) 1);

    }
}
