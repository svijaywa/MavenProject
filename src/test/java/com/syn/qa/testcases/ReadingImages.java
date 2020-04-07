package com.syn.qa.testcases;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ReadingImages {

	public static void main(String[] args) {

        ITesseract image = new Tesseract();
        
        try {
			String str = image.doOCR(new File("C:\\Users\\u955590\\Pictures\\Saved Pictures\\download.png"));
			System.out.println("Data from the image is "+str );
			
			
		} catch (TesseractException e) {
			System.out.println("Exception "+e.getMessage());
		}
        
		

	}

}
