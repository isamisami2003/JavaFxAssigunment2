/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class Accounts {
    private int id;
    private int userId;
    private int AccountNumber;
    private String username;
    private String currency;
    private double balance;
    private String creationDate;

    public Accounts(int userId, int AccountNumber, String username, String currency, double balance, String creationDate) {
        this.userId = userId;
        this.AccountNumber = AccountNumber;
        this.username = username;
        this.currency = currency;
        this.balance = balance;
        this.creationDate = creationDate;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(int AccountNumber) {
        this.AccountNumber = AccountNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public String getCreationDate() {
        return creationDate;
    }

    public void getCreationDate(String creationdata) {
        this.creationDate = creationDate;
    }


 public int save() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter = 0;
        String sql = "INSERT INTO accounts (ID,USERID,ACCOUNTNUMBER,USERNAME,CURRENCY,BALANCE,CREATIONDATE)VALUES(?,?,?,?,?,?,?)";
        ps = c.prepareStatement(sql);
        ps.setInt(1, this.getId());
        ps.setInt(2, this.getUserId());
        ps.setInt(3, this.getAccountNumber());
        ps.setString(4, this.getUsername());
        ps.setString(5, this.getCurrency());
        ps.setDouble(6, this.getBalance());
        ps.setString(7, this.getCreationDate());

       recordCounter = ps.executeUpdate();
       if(recordCounter > 0 ){
           System.out.println(this.getUsername()+"User was added successfully!");
       }
       if(ps != null){
           ps.close();
       }
            c.close();
        return recordCounter;
    }

    
    
    public int update() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter = 0;
        String sql = "update accounts SET USERID=?,ACCOUNTNUMBER=?,USERNAME=?,CURRENCY=?,BALANCE=?,CREATIONDATE=?";
        ps = c.prepareStatement(sql);
        ps.setInt(1, this.getId());
        ps.setInt(2, this.getUserId());
        ps.setInt(3, this.getAccountNumber());
        ps.setString(4, this.getUsername());
        ps.setString(5, this.getCurrency());
        ps.setDouble(6, this.getBalance());
        ps.setString(7, this.getCreationDate());
        
       recordCounter = ps.executeUpdate();
       if(recordCounter > 0 ){
           System.out.println(this.getUsername()+"User was added successfully!");
       }
       if(ps != null){
           ps.close();
       }
            c.close();
        return recordCounter;
    }
    
    public static ArrayList<Accounts> getAllUsers() throws ClassNotFoundException, SQLException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;   
        ResultSet rs= null; 
        ArrayList<Accounts> accounts=new ArrayList<>();
        String sql ="SELECT * FROM accounts";
        ps=c.prepareStatement(sql);
        rs=ps.executeQuery();
        while(rs.next()){
            Accounts account=new Accounts(rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getString(7));
            account.setId(rs.getInt(1));
            accounts.add(account);    
        }
        if(ps !=null ){
            ps.close();
        }
        c.close();
        return accounts;
    }
    
    public int delete() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;  
        int recordCounter=0;
        String sql="DELETE FROM accounts WHERE ID=? ";
        ps.setInt(1,this.getId());
        recordCounter=ps.executeUpdate();
        if(recordCounter > 0){
            System.out.println("The user with id : "+this.getId()+"Was deleted successfuly");
        }
        if(ps != null){
            ps.close();
        }
        c.close();
        return recordCounter;
    }
    
}
