package locators;

import org.openqa.selenium.By;

public class MailLoactors {
	
	public static final By COMPOSE_MAIL=By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']");
	public static final By TO_MAIL=By.xpath("//textarea[@name='to']");
	public static final By MESSAGE_BODY=By.xpath("//div[@aria-label='Message Body']");
	public static final By CLICK_ATTCH=By.xpath("//div[@class='a1 aaA aMZ']");
	
	public static final By SEND=By.xpath("//div[text()='Send']");

}
