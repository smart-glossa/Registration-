package log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class login {
	public JSONObject addlogin(String firstname,String lastname,String dob,String username,String password,String cpassword)throws JSONException {
        JSONObject result = new JSONObject();
try{
	 Class.forName("com.mysql.jdbc.Driver");
     Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginpage", "root", "root");
     Statement statement = connection.createStatement();
     String query = "Insert into registration(firstname,lastname,dob,username,password,cpassword) values('" + firstname +"',"
     		+ " '" + lastname + "','" + dob + "','" + username + "', '" + password + "','" + cpassword +"')";
      
     statement.execute(query);
     result.put("Status", "Success");
 } catch (Exception e1) {
     JSONObject error = new JSONObject();
     error .put("Error", e1.getMessage());
     return error;

 }
 return result;
}

}
