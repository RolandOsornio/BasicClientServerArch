package Database;

import java.sql.*;

public class Database 
{
    
    public Database() {

    }
    
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jeffery","root","passwordTeam6");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select password from usercredentials where username<=\"tom\"");//"insert into usercredentials (db_username,db_password,db_email,db_lockoutCount) values (fred,wow4,fred@callutheran.edu,0)"
            while(rs.next()) {
                System.out.println(rs.getString(1));
            }
            con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        
    }

}
