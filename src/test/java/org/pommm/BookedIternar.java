package org.pommm;

import org.bsee.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookedIternar extends BaseClass{
	
	public BookedIternar() {
		PageFactory.initElements(d, this);
	}
	
	@FindBy(id="order_id_text")
	private WebElement srhBox;
	
	@FindBy(id="search_hotel_id")
	private WebElement goBtn;

	
	
	public WebElement getSrhBox() {
		return srhBox;
	}
	public WebElement getGoBtn() {
		return goBtn;
	}
}
