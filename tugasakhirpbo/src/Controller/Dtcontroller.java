/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Implement.*;
import Model.*;
import view.*;
import DAO.Dtdao;
import java.util.List;
/**
 *
 * @author ASUS
 */
public class Dtcontroller {
    Dtimplement impldt;
    Tampilan frame;
    List<Dtbuku> db;

    public Dtcontroller(Tampilan frame) {
        impldt = new Dtdao();
        this.frame = frame;
        db = impldt.getAll();
    }
    
    public void isitabel(){
        db = impldt.getAll();
        Modeltabel mt = new Modeltabel(db);
        frame.getjTable1().setModel(mt);
    }
    
    public void insert(){
        Dtbuku db = new Dtbuku();
        db.setJudul(frame.getjTextJudul().getText());
        db.setPenulis(frame.getjTextPenulis().getText());
        db.setPenerbit(frame.getjTextPenerbit().getText());
        db.setJml_halaman(Integer.parseInt(frame.getjTextJml().getText()));
        db.setTahun(Integer.parseInt(frame.getjTextTahun().getText()));
        impldt.insert(db);
    }
    
    public void update(){
        Dtbuku db = new Dtbuku();
        db.setJudul(frame.getjTextJudul().getText());
        db.setPenulis(frame.getjTextPenulis().getText());
        db.setPenerbit(frame.getjTextPenerbit().getText());
        db.setJml_halaman(Integer.parseInt(frame.getjTextJml().getText()));
        db.setTahun(Integer.parseInt(frame.getjTextTahun().getText()));
        db.setId(Integer.parseInt(frame.getjTextId().getText()));
        impldt.update(db);
    }
    
    public void delete(){
        Dtbuku db = new Dtbuku();
        db.setId(Integer.parseInt(frame.getjTextId().getText()));
        impldt.delete(db);
    }

}
