import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import com.mysql.jdbc.Statement;

public class Jdbcconnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		String host="localhost";
		String port="3306";
		// change by ram in GITStuffX
		
		Connection con=DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/qadbtesting", "root", "root");
		
		Statement s = con.createStatement();
		
		ResultSet rs=s.executeQuery("select * from credentials where scenario='saving'");
		rs.next();
		//rs.next is used to change the row index so that can fetch the data.
		System.out.println(rs.getString("username"));
		System.out.println(rs.getString("password"));
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shyamag\\Desktop\\chromedriver.exe");
		
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 
		 driver.get("https://login.salesforce.com");
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(rs.getString("username"));
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(rs.getString("password"));
		
	}

}
