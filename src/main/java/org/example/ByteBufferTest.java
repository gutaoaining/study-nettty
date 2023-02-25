package org.example;

import java.nio.ByteBuffer;

public class ByteBufferTest {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(32);
        buffer.putInt(32);
        buffer.putLong(1000L);
        buffer.putFloat(23.23f);
        buffer.putChar('你');
        buffer.putShort((short) 2);
        buffer.putChar('我');
        buffer.flip();
        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getFloat());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getShort());
        System.out.println(buffer.getChar());

    }
}
