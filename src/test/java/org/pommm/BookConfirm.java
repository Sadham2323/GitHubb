package org.pommm;

import org.bsee.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookConfirm extends BaseClass{

	public BookConfirm() {
		PageFactory.initElements(d, this);
	}
	
	@FindBy(id="order_no")
	private WebElement orderNo;
	
	@FindBy(id="my_itinerary")
	private WebElement itinerary;

	
	
	public WebElement getOrderNo() {
		return orderNo;
	}
	public WebElement getItinerary() {
		return itinerary;
	}
}
