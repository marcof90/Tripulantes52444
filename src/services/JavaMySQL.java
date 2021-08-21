package services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JavaMySQL {
    
    public final static String URL_PROPERTIES = "./data/db.properties";

    private String url;
    private String user;
    private String password;
    private Connection connection;

    public JavaMySQL() {
        super();
        loadProperties();
        connectDB();
    }

    public void connectDB() {        
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection.isValid(360) ? "Connected":"Failed");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void loadProperties() {
        try {
            InputStream ins = new FileInputStream(URL_PROPERTIES);
            Properties prop = new Properties();
            prop.load(ins);
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            ins.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
