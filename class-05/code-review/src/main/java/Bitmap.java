import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Bitmap {

    public Path path;
    public BufferedImage imageData;

    public Bitmap(Path imagePath) { // tImageIOakes in a Path
        this.path = imagePath;
        // actually read in file and save that data in an instance variable
        BufferedImage img = null;
        try {
            img = ImageIO.read(imagePath.toFile());
            this.imageData = img;
        } catch (IOException e) {
        }
    }

    // constructor for testing purposes
    public Bitmap(BufferedImage imageData) {
        this.imageData = imageData;
    }

    public void flipVertically() {
        // logic on instance variable to flip it
        // take each row
        // reverse it (aka flip it)
        for (int i = 0; i < this.imageData.getWidth(); i++) {
            for (int j = 0; j < this.imageData.getHeight() / 2; j++) {
                int temp = this.imageData.getRGB(i,j);
                this.imageData.setRGB(i,j, this.imageData.getRGB(i, this.imageData.getWidth() - j - 1));
                this.imageData.setRGB(i, this.imageData.getWidth() - j - 1, temp);
            }
        }

    }

    public void flipHorizontally(){
        // flip horizontally, which means i want to visit half of the pixels width wise
        // i want to visit all of the pixels heighth wise

        for(int x = 0; x < this.imageData.getWidth() / 2; x++){
            for(int y = 0; y < this.imageData.getHeight(); y++){
                int temp = this.imageData.getRGB(x,y);
                System.out.println((temp));
                // get the rgb from the width - 1 - the x value
                // a certain amount of x's from the end
                int endPixelColor = this.imageData.getRGB(this.imageData.getWidth() - x - 1, y);
                this.imageData.setRGB(x, y, -255192203);
                // set the end pixel to have the first pixel's original color
                this.imageData.setRGB(this.imageData.getWidth() - x - 1, y, temp);

            }
        }

    }
    public boolean save(Path savePath) {
        // output instance variable data into a file at the save path
        try {
            return ImageIO.write(imageData, "bmp", savePath.toFile());
        } catch (IOException e) {

        }
        return false;
    }
}
