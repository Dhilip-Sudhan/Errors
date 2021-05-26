package Assignment.Week6.day2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Assignment.Week6.day2.Hooks.Hooks;

public class UpdateIncidents extends Hooks {
	
	WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
	
	public UpdateIncidents changeUrgencyIncident() throws InterruptedException {
		driver.switchTo().frame(iframe);
		WebElement urgencyDropDown = driver.findElement(By.xpath("//select[@id='incident.urgency']"));
		Select urgDropdown = new Select(urgencyDropDown); 
		urgDropdown.selectByVisibleText("1 - High");
		Thread.sleep(2000);
		return this;
	}
	
	public UpdateIncidents changeStateIncident() throws InterruptedException {
		driver.switchTo().frame(iframe);
		WebElement stateDropDown = driver.findElement(By.xpath("//select[@id='incident.state']"));
		Select steDropdown = new Select(stateDropDown); 
		steDropdown.selectByVisibleText("In Progress");
		Thread.sleep(2000);
		return this;
	}
	
	public UpdateIncidents enterWorkNotesIncident(String WorkNotes) {
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("//textarea[@id='activity-stream-work_notes-textarea']")).sendKeys(WorkNotes);
		return this;
	}
	
	public Incidents clickUpdateIncident() throws InterruptedException {
		driver.switchTo().frame(iframe);
		driver.findElement(By.id("sysverb_update")).click();
		Thread.sleep(3000);
		return new Incidents();
	}
	
}
