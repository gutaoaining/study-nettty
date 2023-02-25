package org.example;

import java.nio.ByteBuffer;

public class SliceBufferTest {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        for (int i = 0; i < byteBuffer.capacity(); ++i) {
            byteBuffer.put((byte) i);
        }
        byteBuffer.position(2);
        byteBuffer.limit(6);
        ByteBuffer aliceBuffer = byteBuffer.slice();
        for (int i = 0; i < aliceBuffer.capacity(); ++i) {
            byte byteTemp = aliceBuffer.get(i);
            byteTemp *= 2;
            aliceBuffer.put(i, byteTemp);
        }
        byteBuffer.position(0);
        byteBuffer.limit(byteBuffer.capacity());
        while (byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.get());
        }
    }
}
