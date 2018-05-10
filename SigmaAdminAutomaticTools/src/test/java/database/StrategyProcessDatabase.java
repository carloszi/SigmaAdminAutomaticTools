package database; /**
 * Created by zieli_k on 2018-03-22.*/


import java.sql.*;
import java.util.ArrayList;


public class StrategyProcessDatabase {

    private Connection conn() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:sqlserver://sqlsigma-int\\INT2;integratedSecurity=true;";
        Connection connection = null;
        Class.forName("com.microsoft.sqlserver.jdbc.DriverJDBCVersion");
        connection = DriverManager.getConnection(connectionString);
        return  connection;
    }

    public ArrayList<String> getDBData(String dataBase, String table, String columnName) throws ClassNotFoundException, SQLException{
        Statement statement = null;
        ResultSet rs = null;
        Connection connection  = conn();
        statement = connection.createStatement();
        rs = statement.executeQuery("SELECT * FROM "+dataBase+".dbo."+table);
        ArrayList<String> ls = new ArrayList<String>();
        while (rs.next()) {
            ls.add(rs.getString(columnName));
        }
        return ls;
    }
}