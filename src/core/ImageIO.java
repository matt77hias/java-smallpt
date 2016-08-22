package core;

import java.io.IOException;

public class ImageIO {
    public static final double GAMMA = 2.2;
	
	public static void writePPM(int w, int h, Vector3[] Ls, String fname) {
    	try {
    		java.io.FileWriter sw = new java.io.FileWriter(new java.io.File(fname));
    	
	    	String sbegin = String.format("P3\n%1$d %2$d\n%3$d\n", w, h, 255);
	        sw.write(sbegin);
	
	        for (int i = 0; i < w * h; ++i) {
	        	String s = String.format("%1$d %2$d %3$d ", MathUtils.toByte(Ls[i].x, GAMMA), MathUtils.toByte(Ls[i].y, GAMMA), MathUtils.toByte(Ls[i].z, GAMMA));
	            sw.write(s);
	        }
	        
	        sw.close();
    	}
    	catch (IOException e) {
    		System.out.println(e.getMessage());;
    	}
    }
}
