package org.prg;

import org.bsee.BaseClass;
import org.openqa.selenium.By;
import org.pommm.BookConfirm;
import org.pommm.BookHotel;
import org.pommm.BookedIternar;
import org.pommm.LoginPage;
import org.pommm.SearchHotel;
import org.pommm.SelectHotel;
import org.testng.annotations.*;

public class Launch extends BaseClass{

	@BeforeClass
	private void beforeClass() {
		browserLaunch("chrome");
	}
	@AfterClass
	private void afterClass() {
		quit();
	}
	@Test
	private void test1() throws Exception {
		
		urlLaunch("https://adactinhotelapp.com/");
		impWait(10);
		
		LoginPage l=new LoginPage();
		sendkeys(l.getUserName(),"jagan3355");
		sendkeys(l.getPassWord(),"123456");
		click(l.getLoginBtn());
		
		SearchHotel sh=new SearchHotel();
		sltIndex(sh.getLocation(),6);
		sltValue(sh.getHotel(),"Hotel Sunshine");
		sltVisibleText(sh.getRomType(),"Super Deluxe");
		sltVisibleText(sh.getRomCount(),"1 - One");
		sltValue(sh.getAdultCount(),"2");
		sltIndex(sh.getChildrenCount(),2);
		click(sh.getSubmitBtn());
		
		SelectHotel s=new SelectHotel();
		click(s.getCheckBox());
		click(s.getContinueBtn());
		
		BookHotel bh=new BookHotel();
		sendkeys(bh.getFirstName(),"Jagan");
		sendkeys(bh.getLastName(),"nath");
		sendkeys(bh.getAddress(),"Bangalore");
		sendkeys(bh.getCcNum(),"1234567890987654");
		sltVisibleText(bh.getCcType(),"Master Card");
		sltValue(bh.getCcMon(),"6");
		sltValue(bh.getCcYear(),"2024");
		sendkeys(bh.getCcvNum(),"456");
		click(bh.getBookBtn());
		
		BookConfirm bc=new BookConfirm();
		String bid = getAttribute(bc.getOrderNo());
		staticWait(2500);
		click(bc.getItinerary());
		
		BookedIternar bi=new BookedIternar();
		sendkeys(bi.getSrhBox(),bid);
		click(bi.getGoBtn());
		
		d.findElement(By.id("check_all")).click();
		d.findElement(By.xpath("//input[@style='width:150px;']")).click();
		staticWait(1500);
		d.switchTo().alert().accept();
		staticWait(3500);	
	}
}
