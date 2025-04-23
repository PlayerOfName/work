package org.shvetsov;
import java.util.ArrayList;
import java.util.List;
public class OutOfMemoryError {
    public static void noMemory() {
        List<byte[]> list = new ArrayList<>();
        while (true) {
            list.add(new byte[1024 * 1024]); // 1 МБ в каждой итерации
        }
    }

    public static void noMemory2() {
        int i = 0;
        while (true) {
            String.valueOf(i++).intern(); // Заполнение пула строк
        }
    }

    public static void noMemory3() {
        List<byte[]> leak = new ArrayList<>();
        while (true) {
            leak.add(new byte[1024 * 1024]); // Утечка через статику
        }
    }

    public static void main(String[] args) {
        noMemory2();
    }
}
