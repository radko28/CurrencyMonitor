package sk.cyklosoft.currencymonitor.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * Read image from file system.
 * 
 * 
 */
@Controller
@RequestMapping("/images")
public class ImageController {

    /**
     * 
     * Reading image from filesystem and return as byte array.
     * 
     * @param fileName
     *            name of the picture
     * @return image as byte array
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/logo", method = RequestMethod.GET)
    public byte[] getLogo(@RequestParam(value = "filename", required = true)
    String fileName) throws IOException {
    	
        BufferedImage image = null;
        ByteArrayOutputStream baos = null;
        try {
        	URL path = Thread.currentThread().getContextClassLoader().getResource(fileName);
        	image = ImageIO.read(path);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        baos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", baos);
        byte[] res = baos.toByteArray();
        return res;
    }



}
