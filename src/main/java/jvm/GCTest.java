package jvm;

public class GCTest {
    // +XX:+PrintGCDetails
    public static void main(String[] args) throws InterruptedException {
//        while (true) {
            byte[] allocations;
            allocations = new byte[29500 * 1024];
//            Thread.sleep(100);
//        }
    }
}
