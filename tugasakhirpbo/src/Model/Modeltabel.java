/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author ASUS
 */
public class Modeltabel extends AbstractTableModel{
    List<Dtbuku> db;

    public Modeltabel(List<Dtbuku> db) {
        this.db = db;
    }
    
    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "ID";
            case 1:
                return "Judul";
            case 2:
                return "Penulis";
            case 3:
                return "Penerbit";
            case 4:
                return "Jumlah Halaman";
            case 5:
                return "Tahun";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
       switch(column){
            case 0:
                return db.get(row).getId();
            case 1:
                return db.get(row).getJudul();
            case 2:
                return db.get(row).getPenulis();
            case 3:
                return db.get(row).getPenerbit();
            case 4:
                return db.get(row).getJml_halaman();
            case 5:
                return db.get(row).getTahun();
            default:
                return null;
        }
    }
}
