package org.pommm;

import org.bsee.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotel extends BaseClass{
	
	public BookHotel() {
		PageFactory.initElements(d, this);
	}

	@FindBy(id="first_name")
	private WebElement firstName;
	
	@FindBy(id="last_name")
	private WebElement lastName;
	
	@FindBy(id="address")
	private WebElement address;
	
	@FindBy(id="cc_num")
	private WebElement ccNum;
	
	@FindBy(id="cc_type")
	private WebElement ccType;
	
	@FindBy(id="cc_exp_month")
	private WebElement ccMon;
	
	@FindBy(id="cc_exp_year")
	private WebElement ccYear;
	
	@FindBy(id="cc_cvv")
	private WebElement ccvNum;
	
	@FindBy(id="book_now")
	private WebElement bookBtn;

	
	
	
	public WebElement getFirstName() {
		return firstName;
	}
	public WebElement getLastName() {
		return lastName;
	}
	public WebElement getAddress() {
		return address;
	}
	public WebElement getCcNum() {
		return ccNum;
	}
	public WebElement getCcType() {
		return ccType;
	}
	public WebElement getCcMon() {
		return ccMon;
	}
	public WebElement getCcYear() {
		return ccYear;
	}
	public WebElement getCcvNum() {
		return ccvNum;
	}
	public WebElement getBookBtn() {
		return bookBtn;
	}
}
