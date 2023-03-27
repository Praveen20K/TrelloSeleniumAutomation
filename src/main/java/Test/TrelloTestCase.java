package Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseMethod;
import Object.TrelloMethods;

public class TrelloTestCase extends BaseMethod {
	
	@BeforeTest
	public void setData() {
		excelFileName = "testData";
	}
	
	@Test(dataProvider = "fetchData")
	public void testCase(String Email, String Password, String workBook, String FirstList, String secondList, String firstCard, String secondCard) {
		TrelloMethods methods = new TrelloMethods();
		methods.login(Email, Password);
		methods.createWorkBook(workBook);
		methods.addList(FirstList, secondList);
		methods.addCard(firstCard, secondCard);
		methods.dragAndDrop();
		methods.getCoordinates();
		methods.logout();
	}
}

