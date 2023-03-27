package Object;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Base.BaseMethod;

public class TrelloMethods extends BaseMethod {
	
	public void login(String email, String password) {
		driver.findElement(By.xpath("//input[@id='user']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='login']")).click();
		driver.findElement(By.xpath("//div[@class='field-group password-field expanded  css-4pzks9']//input")).sendKeys(password);
		driver.findElement(By.xpath("//button[@id='login-submit']")).click();
	}
	
	public void createWorkBook(String workspace) {
		driver.findElement(By.xpath("//button[@aria-label='Create board or Workspace']")).click();
		driver.findElement(By.xpath("//button[@data-testid='header-create-board-button']")).click();
		driver.findElement(By.xpath("//input[@data-testid='create-board-title-input']")).sendKeys(workspace);
		driver.findElement(By.xpath("//button[@data-testid='create-board-submit-button']")).click();
	}
	
	public void addList(String flist, String slist) {
		driver.findElement(By.xpath("//input[@class='list-name-input']")).sendKeys(flist);
		driver.findElement(By.xpath("//input[@value='Add list']")).click();
		driver.findElement(By.xpath("//div[@id='board']//a[@class='open-add-list js-open-add-list']/following-sibling::input")).sendKeys(slist);
		driver.findElement(By.xpath("//input[@value='Add list']")).click();
	}
	
	public void addCard(String fcard, String scard) {
		driver.findElement(By.xpath("(//a[@class='open-card-composer js-open-card-composer'])[1]")).click();
		driver.findElement(By.xpath("//textarea[@class='list-card-composer-textarea js-card-title']")).sendKeys(fcard);
		driver.findElement(By.xpath("//input[@value='Add card']")).click();
		driver.findElement(By.xpath("(//a[@class='open-card-composer js-open-card-composer'])[1]")).click();
		driver.findElement(By.xpath("//div[@class='list-card-details u-clearfix']//textarea")).sendKeys(scard);
		driver.findElement(By.xpath("//input[@value='Add card']")).click();
	}
	
	public void dragAndDrop() {
		WebElement dragTask = driver.findElement(By.xpath("(//div[@class='list-card-details js-card-details'])[1]//following-sibling::span[@class='list-card-title js-card-name']"));
		WebElement dropPlace = driver.findElement(By.xpath("(//div[@class='list-card-details js-card-details'])[2]"));
		Actions action = new Actions(driver);
		action.dragAndDrop(dragTask, dropPlace).build().perform();
	}
	
	public void getCoordinates() {
		Point Coordinates = driver.findElement(By.xpath("(//span[@class='list-card-title js-card-name'])[2]")).getLocation();
		System.out.println("The Coordinates are: "+ Coordinates);
	}
	
	public void logout() {
		driver.findElement(By.xpath("//button[@data-testid='header-member-menu-button']")).click();
		driver.findElement(By.xpath("//button[@data-testid='account-menu-logout']")).click();
		driver.findElement(By.xpath("//button[@id='logout-submit']")).click();
	}
}
