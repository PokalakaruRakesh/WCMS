package base.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScreenshotUtil {
	@Attachment(value="Screenshot", type="image/png")
	public static byte[] takeScreenshotForAllure(WebDriver driver) throws IOException {
		try {
			return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		}
		catch (Exception e)
		{

		}
		return new byte[0];
	}
	
	@Attachment(value = "Screenshot", type = "image/png")
	public static  byte[] takeFullPageScreenshot() throws AWTException, IOException {
		Robot robot = new Robot();
		Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
		return toByteArray(bufferedImage, "png");
	}

	public static byte[] toByteArray(BufferedImage bufferedImage, String string) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(bufferedImage, string, baos);
		byte[] bytes = baos.toByteArray();
		return bytes;
	}
	
	
}
