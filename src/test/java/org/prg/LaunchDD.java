package org.prg;

import org.bsee.BaseClass;
import org.openqa.selenium.By;
import org.pommm.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LaunchDD extends BaseClass{
	
	@BeforeClass
	private void beforeClass() {
		browserLaunch("edge");
	}
	@AfterClass
	private void afterClass() {
		quit();
	}
	int row=1;
	@Test(invocationCount=1)
	private void test1() throws Exception {
		
		urlLaunch("https://adactinhotelapp.com/");
		impWait(10);
		int cell=0;
		LoginPage l=new LoginPage();
		sendkeys(l.getUserName(),excel(row, cell));
		cell++;
		sendkeys(l.getPassWord(),excel(row, cell));
		cell++;
		click(l.getLoginBtn());
		
		SearchHotel sh=new SearchHotel();
		sltIndex(sh.getLocation(),5);
		sltValue(sh.getHotel(),"Hotel Sunshine");
		sltVisibleText(sh.getRomType(),"Super Deluxe");
		sltVisibleText(sh.getRomCount(),"1 - One");
		sltValue(sh.getAdultCount(),"2");
		sltIndex(sh.getChildrenCount(),1);
		click(sh.getSubmitBtn());
		
		SelectHotel s=new SelectHotel();
		click(s.getCheckBox());
		click(s.getContinueBtn());
		
		BookHotel bh=new BookHotel();
		sendkeys(bh.getFirstName(),excel(row, cell));
		cell++;
		sendkeys(bh.getLastName(),excel(row, cell));
		cell++;
		sendkeys(bh.getAddress(),excel(row, cell));
		cell++;
		sendkeys(bh.getCcNum(),excel(row, cell));
		cell++;
		sltVisibleText(bh.getCcType(),"Master Card");
		sltValue(bh.getCcMon(),"6");
		sltValue(bh.getCcYear(),"2024");
		sendkeys(bh.getCcvNum(),excel(row, cell));
		cell++;
		click(bh.getBookBtn());
		
		BookConfirm bc=new BookConfirm();
		String bid = getAttribute(bc.getOrderNo());
		wexcel(row, cell, bid);
		staticWait(2500);
		click(bc.getItinerary());
		
		BookedIternar bi=new BookedIternar();
		sendkeys(bi.getSrhBox(),bid);
		click(bi.getGoBtn());
		
		d.findElement(By.id("check_all")).click();
		d.findElement(By.xpath("//input[@style='width:150px;']")).click();
		staticWait(1500);
		accept();
		staticWait(1500);
		row++;
	}
	
}
