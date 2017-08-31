
/*
@Author Juliana Carvalho
@Date 8/12/2017

Code will take user input and write data to a mySQL database
User must provide the database username and password. Variables
may be replaced with the actual username and password 
*/ 

package SQLPractice;
import java.sql.*;
import java.util.Scanner; 

public class SQLPractice {


	public static void main(String[] args) throws SQLException{
		
		SQLPractice s = new SQLPractice();
		Scanner input = new Scanner(System.in); 


		System.out.println("Enter Database Username"); 
		String username = input.nextLine(); 

		System.out.println("Enter Database Password"); 
		String password = input.nextLine(); 

		try {
			
			//Create Connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Client", username ,  password);

			// Create Statement
			Statement myStat = myConn.createStatement(); 
			
			//Execute Query
			String query = (
			"INSERT INTO client.Customers(FirstName,LastName,Address1,Address2,City,ZipCode,Email,Phone,OptOut)" +
			"VALUES (?,?,?,?,?,?,?,?,?)");
			
			/*
			String FirstName = "James";
			String LastName = "Williams";
			String Address1 = "300 Princenton Street";
			String Address2 = "Left 2";
			String City = "Boston";
			Integer ZipCode = 02120;
			String Email = "jwilliams20@gmail.com";
			String Phone = "3215436758";
			Integer Opt = 0;
			*/
			
			System.out.println("First Name: ");
			String FirstName = input.nextLine();
			
			System.out.println("Last Name: ");
			String LastName = input.nextLine();
			
			System.out.println("Address: ");
			String Address1 = input.nextLine();
			
			System.out.println("City: ");
			String City = input.nextLine();
			
			System.out.println("Zip Code: ");
			Integer ZipCode = input.nextInt();
			System.out.println();
			
			System.out.println("Email: ");
			String Email = input.nextLine();
			
			System.out.println("Phone: ");
			String Phone = input.nextLine(); 
			
			System.out.println("Would You Like to Opt Out?: ");
			Integer Opt = input.nextInt();
			
		
			//Update after Insert statement 
			PreparedStatement preStatement = myConn.prepareStatement(query);
			preStatement.setString(1, FirstName);
			preStatement.setString(2, LastName);
			preStatement.setString(3, Address1);
			preStatement.setString(5, City);
			preStatement.setInt(6, ZipCode);
			preStatement.setString(7, Email);
			preStatement.setString(8, Phone);
			preStatement.setInt(9, Opt);
			
			preStatement.execute();
			
			myConn.close();
			
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
