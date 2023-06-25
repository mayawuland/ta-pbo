/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;
import Koneksi.Connector;
import Model.*;
import Implement.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ASUS
 */
public class Dtdao implements Dtimplement{
    Connection connection;
    
    final String select = "select * from dtbuku;";
    final String insert = "insert into dtbuku (judul,penulis,penerbit,jml_halaman,tahun) values (?,?,?,?,?);";
    final String update = "update dtbuku set judul=?, penulis=?, penerbit=?, jml_halaman=?, tahun=? where id=?;";
    final String delete = "delete from dtbuku where id=?;";

    public Dtdao() {
        connection = Connector.connection();
    }
    
    @Override
    public void insert(Dtbuku a) {
        PreparedStatement statement = null;
        try{
        statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, a.getJudul());
        statement.setString(2, a.getPenulis());
        statement.setString(3, a.getPenerbit());
        statement.setInt(4, a.getJml_halaman());
        statement.setInt(5, a.getTahun());
        statement.executeUpdate();
        ResultSet rs = statement.getGeneratedKeys();
        while(rs.next()){
            a.setId(rs.getInt(1));
        }
        }catch(SQLException ex){
        ex.printStackTrace();
        }
    }

    @Override
    public void update(Dtbuku b) {
       PreparedStatement statement = null;
        try{
        statement = connection.prepareStatement(update);
        statement.setString(1, b.getJudul());
        statement.setString(2, b.getPenulis());
        statement.setString(3, b.getPenerbit());
        statement.setInt(4, b.getJml_halaman());
        statement.setInt(5, b.getTahun());
        statement.setInt(6, b.getId());
        statement.executeUpdate();
        }catch(SQLException ex){
        ex.printStackTrace();
        }
    }

    @Override
    public void delete(Dtbuku c) {
        PreparedStatement statement = null;
        try{
        statement = connection.prepareStatement(delete);
        statement.setInt(1, c.getId());
        statement.executeUpdate();
        }catch(SQLException ex){
        ex.printStackTrace();
        }
    }
    @Override
    public List<Dtbuku> getAll() {
        List<Dtbuku> db = null;
        try{
        db = new ArrayList<Dtbuku>();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(select);
        while(rs.next()){
            Dtbuku dt = new Dtbuku();
            dt.setId(rs.getInt("id"));
            dt.setJudul(rs.getString("judul"));
            dt.setPenulis(rs.getString("penulis"));
            dt.setPenerbit(rs.getString("penerbit"));
            dt.setJml_halaman(rs.getInt("jml_halaman"));
            dt.setTahun(rs.getInt("tahun"));
            db.add(dt);
        }
        }catch(SQLException ex){
        Logger.getLogger(Dtdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return db;
    }
}
