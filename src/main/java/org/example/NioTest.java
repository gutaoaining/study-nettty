package org.example;

import java.nio.IntBuffer;
import java.security.SecureRandom;

public class NioTest {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(10);
        System.out.println("buffer capacity: " + intBuffer.capacity());
        for (int i = 0; i < 5; i++) {
            int randomInt = new SecureRandom().nextInt(20);
            intBuffer.put(randomInt);
        }
        System.out.println("buffer limit: " + intBuffer.limit());
        intBuffer.flip();
        System.out.println("after flip, buffer limit: " + intBuffer.limit());
        System.out.println("---------------begin get------------------");
        while (intBuffer.hasRemaining()) {
            System.out.println("buffer position: " + intBuffer.position());
            System.out.println("buffer limit: " + intBuffer.limit());
            System.out.println("buffer capacity: " + intBuffer.capacity());
            System.out.println(intBuffer.get());
        }
        intBuffer.flip();
        System.out.println("---------------begin put------------------");
        System.out.println("buffer position: " + intBuffer.position());
        System.out.println("buffer limit: " + intBuffer.limit());
        System.out.println("buffer capacity: " + intBuffer.capacity());
        System.out.println("---------------begin put new value------------------");

    }
}
