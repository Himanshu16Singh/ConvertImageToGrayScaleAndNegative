import edu.duke.*;
import java.io.*;
/**
 * Write a description of GrayScaleConverter here.
 * 
 * @author Himanshu Singh
 * @version 08-08-2020
 */
public class GrayScaleAndNegativeConverter {
    public ImageResource makeGray(ImageResource inImage){
        // a blank image of same size
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        // iterate over pixel
        for (Pixel pixel : outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen())/3;
            pixel.setRed(average);
            pixel.setGreen(average);
            pixel.setBlue(average);
        }
        return outImage;
    }
    
    public ImageResource makeNegative(ImageResource inImage){
        // a blank image of same size
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        // iterate over pixel
        for (Pixel pixel : outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            pixel.setRed(255-inPixel.getRed());
            pixel.setGreen(255-inPixel.getGreen());
            pixel.setBlue(255-inPixel.getBlue());
        }
        return outImage;
    
    }
    
    public void selectAndConvertInGray(){
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            ImageResource inImage = new ImageResource(f);
            ImageResource gray = makeGray(inImage);
            String newName = f.getParent() +"\\grayVersion-" + inImage.getFileName();
            gray.setFileName(newName);
            gray.save();
        }
    }
    
    public void selectAndConvertInNegative(){
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            ImageResource inImage = new ImageResource(f);
            ImageResource negative = makeNegative(inImage);
            String newName = f.getParent() +"\\negativeVersion-" + inImage.getFileName();
            negative.setFileName(newName);
            negative.save();
        }
    }
}
