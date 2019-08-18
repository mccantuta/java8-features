package com.mccl.poc;

public class Util {
    public static String heavyResource() {
        try {
            System.out.println("Finding heavy resource");
            Thread.sleep(3000);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return "";
    }
}
