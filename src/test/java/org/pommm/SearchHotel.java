package org.pommm;

import org.bsee.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotel extends BaseClass{

	public SearchHotel() {
		PageFactory.initElements(d, this);
	}
	
	
	@FindBy(id="location")
	private WebElement location;
	
	@FindBy(id="hotels")
	private WebElement hotel;
	
	@FindBy(id="room_type")
	private WebElement romType;
	
	@FindBy(id="room_nos")
	private WebElement romCount;
	
	@FindBy(id="adult_room")
	private WebElement adultCount;
	
	@FindBy(id="child_room")
	private WebElement childrenCount;
	
	@FindBy(id="Submit")
	private WebElement submitBtn;

	
	
	public WebElement getLocation() {
		return location;
	}
	public WebElement getHotel() {
		return hotel;
	}
	public WebElement getRomType() {
		return romType;
	}
	public WebElement getRomCount() {
		return romCount;
	}
	public WebElement getAdultCount() {
		return adultCount;
	}
	public WebElement getChildrenCount() {
		return childrenCount;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}	
}
