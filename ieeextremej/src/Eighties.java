
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kommusoft
 */
public class Eighties {

    public static void main(String[] args) {
        new Eighties().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        short ax = 0x00;
        short bx = 0x00;
        short cx = 0x00;
        short dx = 0x00;
        short di = 0x0400;
        short si = 0x00c0;
        short sp = 0x00c0;
        short bp = 0x00c0;
        ax |= sc.nextInt(16) & 0xff;
    }

}
