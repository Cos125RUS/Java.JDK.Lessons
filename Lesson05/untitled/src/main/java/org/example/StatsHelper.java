package org.example;

import java.util.Scanner;

public class StatsHelper {
    private static int cnt = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread readThread = new Thread(()->{
            Scanner in = new Scanner(System.in);
            while (in.hasNextLine() && Thread.interrupted()){
                in.nextLine();
                cnt++;
            }
        });
        readThread.setDaemon(true);
        readThread.start();
        readThread.interrupt();
        while (true){
            System.out.println(cnt+" messages input by user");
            Thread.sleep(2000);
        }
    }
}
