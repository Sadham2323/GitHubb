package org.pommm;

import org.bsee.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotel extends BaseClass{
	
	public SelectHotel() {
		PageFactory.initElements(d, this);
	} 
	
	@FindBy(id="radiobutton_0")
	private WebElement checkBox;
	
	@FindBy(id="continue")
	private WebElement continueBtn;

	
	
	public WebElement getCheckBox() {
		return checkBox;
	}
	public WebElement getContinueBtn() {
		return continueBtn;
	}
}
