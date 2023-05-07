package java_basics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Files {

    public static void main(String[] args) {

        PrintWriter kitty = null;
        try {
            kitty = new PrintWriter(new File("typing.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        kitty.write(80);// 80 is  ASCII value, it corresponds to the symbol P
        kitty.write(117);
        kitty.write(114);
        kitty.write(114);
        kitty.write(102);
        kitty.write(101);
        kitty.write(99);
        kitty.write(116);
        kitty.write(" Hello");
        kitty.close();
    }
}
