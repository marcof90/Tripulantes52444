package services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public void insertCurso(String nombre, int codigo, char jornada) {
        String sql = "INSERT INTO `cursos`(`nombre`, `codigo`, `jornada`)"+
            " VALUES ('"+nombre+"','"+codigo+"','"+jornada+"')";
        executeInsertStatement(sql);        
    }

    public void updateCurso(String nombre, int codigo, char jornada){
        String sql = "UPDATE `cursos` SET `nombre`='"+nombre+"',`jornada`='"+jornada+"' "+
            "WHERE `codigo`="+codigo;
        executeInsertStatement(sql);
    }

    public ResultSet getCursosDB() {
        String sql = "SELECT * FROM cursos";
        return executeQueryStatement(sql);
    }

    public void executeInsertStatement(String sql) {        
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQueryStatement(String sql) {
        try {
            Statement stmt = connection.createStatement();
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
