package testNG.testcases;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class QRCodeDemo {

	public static void main(String[] args) throws IOException, NotFoundException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\arjun\\Desktop\\chromedriver.exe");
		  WebDriver driver=new ChromeDriver();
		  driver.get("http://testautomationpractice.blogspot.com/");
		  driver.manage().window().maximize();
		  String qrCodeUrl=driver.findElement(By.xpath("//*[@id=\"HTML4\"]/div[1]/img")).getAttribute("src");
		  URL url=new URL(qrCodeUrl);
		  BufferedImage buffImg=ImageIO.read(url);
          LuminanceSource luminancesource=new BufferedImageLuminanceSource(buffImg);
          BinaryBitmap bitmap=new BinaryBitmap(new HybridBinarizer(luminancesource));
          Result result=new MultiFormatReader().decode(bitmap);
          System.out.println(result);
          driver.close();
	}

}
