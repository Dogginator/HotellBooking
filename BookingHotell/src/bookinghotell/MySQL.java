
package bookinghotell;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.text.Text;
import java.sql.ResultSet;
import java.util.List;

public class MySQL implements Connecter{
      
    
    private static Statement sqlStatement = null;
    private static int i, columnCount, id, intValue;
    private static int longValue;
    private static BigInteger bigValue;
    private static String outputData;
    private static String url, user, pass;
    private static Text outPut;
    
    
        public static Connection Connected() throws SQLException {
        for (PassWord logIn : passWord) {
            url = logIn.getAdress();
            user = logIn.getPassName();
            pass = logIn.getPassKey();
        }

        Connection connection = Connecter.Help.con(url, user, pass);
            sqlStatement = connection.createStatement();
        return connection;
    }
    
        protected static void table_Insert(String table,  String colum, String columTwo,
            String columThree, String columFour,BigInteger ISBN, String title, int year, double rate )throws SQLException{
        Connection connection = Connected();
        sqlStatement = connection.createStatement();
        PreparedStatement stmt = sqlStatement.getConnection().prepareStatement("INSERT INTO " + table + "("+ colum + ", " + columTwo
                + ")" + " VALUES ("+ ISBN + "," + title + ", ?, ?);");
        stmt.setInt(1, year);
        stmt.setDouble(2,rate);
        stmt.executeUpdate();
       
    }
    protected static void intUpdate(int set, int where, String table, String colum, String line)throws SQLException{
        Connection connection = Connected();
        sqlStatement = connection.createStatement();
        PreparedStatement stmt = sqlStatement.getConnection().prepareStatement("UPDATE " + table + " SET " + colum + " = ? WHERE "+ line +" = ?;");
        stmt.setInt(1, set);
        stmt.setInt(2, where);
        stmt.executeUpdate();
    }
    protected static void returnUpdate(int inventory_Id)throws SQLException{
        Connection connection = Connected();
        sqlStatement = connection.createStatement();
        PreparedStatement stmt = sqlStatement.getConnection().prepareStatement("UPDATE Register SET rented = false WHERE bookId = ?;");
        stmt.setInt(1, inventory_Id);
        stmt.executeUpdate();    
    }
    protected static void bigIntUpdate(BigInteger ISBN, int where, String table, String colum, String line)throws SQLException{
        Connection connection = Connected();
        sqlStatement = connection.createStatement();
        PreparedStatement stmt = sqlStatement.getConnection().prepareStatement("UPDATE " + table + " SET " + colum + " = " + 
                ISBN + " WHERE "+ line +" = ?;");
        //stmt.setInt(1, set);
        stmt.setInt(1, where);
        stmt.executeUpdate();
    }
    protected static void stringUpdate(String set, int where, String table, String colum, String line)throws SQLException{
        Connection connection = Connected();
        sqlStatement = connection.createStatement();
        PreparedStatement stmt = sqlStatement.getConnection().prepareStatement("UPDATE " + table + " SET " + colum + " = " + 
                set + " WHERE "+ line +" = ?;");
        //stmt.setInt(1, set);
        stmt.setInt(1, where);
        stmt.executeUpdate();
    }
    protected static void dUpdate(double set, int where, String table, String colum, String line)throws SQLException{
        Connection connection = Connected();
        sqlStatement = connection.createStatement();
        PreparedStatement stmt = sqlStatement.getConnection().prepareStatement("UPDATE " + table + " SET " + colum + " = ? WHERE "+ line +" = ?;");
        stmt.setDouble(1, set);
        stmt.setInt(2, where);
        stmt.executeUpdate();
    }
        protected static void intDelete(String table, String colum, int where)throws SQLException{
        Connection connection = Connected();
        sqlStatement = connection.createStatement();
        PreparedStatement stmt = sqlStatement.getConnection().prepareStatement("DELETE FROM " + table + " WHERE " + colum + " = ?;");
        stmt.setInt(1, where);
        stmt.executeUpdate();
    }
        // NOT IMPLUMENTED below
            // <editor-fold defaultstate="collapsed" desc=" Get Value to Table's ">
    /*public static List<CostumerList> getBookList() throws SQLException {
        try (
        Connection connection = Connected();
        Statement sqlStmt = connection.createStatement();
        PreparedStatement stmt = sqlStmt.getConnection().prepareStatement("SELECT * FROM Book_List;");
        ResultSet rs = stmt.executeQuery();
        ){
            //List<Book_List> bookList = new ArrayList<>();
            while (rs.next()) {
                Integer bookId = rs.getInt("Book_Id");
                String ISBN = rs.getString("iSBN");
                String title = rs.getString("title");
                Integer year = rs.getInt("realese_Year");
                Double rate = rs.getDouble("rate");
                Book_List book = new Book_List(bookId, ISBN, title, year, rate);
                bookList.add(book);
            }
            return bookList ;
        } 
    }
    public static List<Logistic> getLogiList() throws SQLException {
        try (
        Connection connection = Connected();
        Statement sqlStmt = connection.createStatement();
        PreparedStatement stmt = sqlStmt.getConnection().prepareStatement("SELECT * FROM Logistic;");
        ResultSet rs = stmt.executeQuery();
        ){
            //List<Logistic> logiList = new ArrayList<>();
            while (rs.next()) {
                Integer logId = rs.getInt("inventory_Id");
                Integer quantity = rs.getInt("quanty");
                Integer bookId = rs.getInt("BookId");
                Logistic logi = new Logistic(logId, quantity, bookId);
                logiList.add(logi);
            }
            return logiList ;
        }
         }
    public static List<Register> getRegiList() throws SQLException {
        try (
        Connection connection = Connected();
        Statement sqlStmt = connection.createStatement();
        PreparedStatement stmt = sqlStmt.getConnection().prepareStatement("SELECT * FROM Register;");
        ResultSet rs = stmt.executeQuery();
        ){
            //List<Register> regiList = new ArrayList<>();
            while (rs.next()) {
                
                Integer regId = rs.getInt("regId");
                String lendDate = rs.getString("lending_DATE");
                Integer bookId = rs.getInt("BookId");
                String reDate = rs.getString("return_DATE");
                String lended = rs.getString("rented");
                Register regi = new Register(regId, lendDate, bookId, reDate, lended);
                regiList.add(regi);
            }
            return regiList ;
        }
        }
    public static List<Costumer> getCostumerList() throws SQLException {
        try (
        Connection connection = Connected();
        Statement sqlStmt = connection.createStatement();
        PreparedStatement stmt = sqlStmt.getConnection().prepareStatement("SELECT * FROM Costumer;");
        ResultSet rs = stmt.executeQuery();
        ){
            //List<Costumer> costumerList = new ArrayList<>();
            while (rs.next()) {
                Integer cardId = rs.getInt("card_Id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                Costumer person = new Costumer(cardId, firstName, lastName);
                costumerList.add(person);
            }
            return costumerList ;
        }
        }
    public static List<Book_By_Author> getBookAuthorList() throws SQLException {
        try (
        Connection connection = Connected();
        Statement sqlStmt = connection.createStatement();
        PreparedStatement stmt = sqlStmt.getConnection().prepareStatement("SELECT * FROM Book_By_Author;");
        ResultSet rs = stmt.executeQuery();
        ){
            //List<Book_By_Author> bookAuthorList = new ArrayList<>();
            while (rs.next()) {
                Integer bookId = rs.getInt("BookId");
                Integer authorId = rs.getInt("author_Id");
                Book_By_Author bBa = new Book_By_Author(bookId, authorId);
                bookAuthorList.add(bBa);
            }
            return bookAuthorList;
        }
        }
    public static List<Author> getAuthorList() throws SQLException {
        try (
        Connection connection = Connected();
        Statement sqlStmt = connection.createStatement();
        PreparedStatement stmt = sqlStmt.getConnection().prepareStatement("SELECT * FROM Author;");
        ResultSet rs = stmt.executeQuery();
        ){
            //List<Author> authorList = new ArrayList<>();
            while (rs.next()) {
                Integer authorId = rs.getInt("author_Id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                Author person = new Author(authorId, firstName, lastName);
                authorList.add(person);
            }
            return authorList;
        }
        }
    public static List<Book_By_Costumer> getBookCostumerList() throws SQLException {
        try (
        Connection connection = Connected();
        Statement sqlStmt = connection.createStatement();
        PreparedStatement stmt = sqlStmt.getConnection().prepareStatement("SELECT * FROM Book_By_Costumer;");
        ResultSet rs = stmt.executeQuery();
        ){
            //List<Book_By_Costumer> bookCostumerList = new ArrayList<>();
            while (rs.next()) {
                Integer regId = rs.getInt("regId");
                Integer cardId= rs.getInt("cardId");
                Book_By_Costumer bBc = new Book_By_Costumer(regId, cardId);
                bookCostumerList.add(bBc);
            }
            return bookCostumerList;
        }
        } */
    // </editor-fold> 
}
/*
CREATE DATABASE HottellBooking;


CREATE TABLE Costumer(
CostumerID INT PRIMARY KEY AUTO_INCREMENT,
FistName char(255) NOT NULL,
LastName char(255) NOT NULL
) AUTO_INCREMENT = 1;

CREATE TABLE CostumerInfo(
ID INT,
FOREIGN KEY (ID) REFERENCES Costumer(CostumerID) ON DELETE CASCADE,
PhoneNumber BIGINT NOT NULL
);

CREATE TABLE Rooms(
RoomID INT PRIMARY KEY AUTO_INCREMENT,
RoomType char(255) NOT NULL,
Price BIGINT UNIQUE,
Rented BIT NOT NULL DEFAULT false
) AUTO_INCREMENT = 1010;
-- Drop TABLE rooms;



CREATE TABLE BOOKING(
ID INT,
StartDate DATETIME DEFAULT CURRENT_TIMESTAMP,
EndDate DATETIME DEFAULT NULL,
RoomID INT,
FOREIGN KEY (ID) REFERENCES Costumer(CostumerID) ON DELETE SET NULL,
Rented BIT NOT NULL DEFAULT TRUE
);

CREATE TABLE Food(
ItemID INT PRIMARY KEY AUTO_INCREMENT,
Item CHAR(255) NOT NULL,
Price DOUBLE NOT NULL
) AUTO_INCREMENT = 1;

CREATE TABLE Orders(
ID INT,
FOREIGN KEY (ID) REFERENCES Rooms(RoomID) ON DELETE CASCADE,
ItemID INT,
FOREIGN KEY (ItemID) REFERENCES Food(ItemID) ON DELETE CASCADE,
PRIMARY KEY(ID, ItemID),
OrderDate DATETIME DEFAULT CURRENT_TIMESTAMP
);
*/
