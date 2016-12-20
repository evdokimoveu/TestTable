
package table.DAO.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import table.DAO.TableDAO;
import table.model.Cell;
import table.model.Row;
import table.utils.Constants;


/**
 *
 * @author evdokimoveu
 */
public class TableDAOJSONImpl implements TableDAO<Row> {
   
    private List<Row> rows;
    private final File resFile;

    public TableDAOJSONImpl() {
        this.rows = new ArrayList<>();
        this.resFile = new File("struc.json");
        if(!resFile.exists()){            
            this.create();
        }
    }
    
    @Override
    public List<Row> read() {
        Gson gson = new Gson();
        StringBuilder builder = new StringBuilder();
        String jsonStr = "";
        try {            
            BufferedReader reader = new BufferedReader(new FileReader(resFile));
            while ((jsonStr = reader.readLine()) != null) {                
                builder.append(jsonStr);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TableDAOJSONImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TableDAOJSONImpl.class.getName()).log(Level.SEVERE, null, ex);
        }        
        rows = gson.fromJson(builder.toString(), new TypeToken<List<Row>>(){}.getType());       
        return rows;
    }
    
    @Override
    public void create() {        
        this.createDefaultData();
        if(rows.size() > 0){
            PrintWriter writer = null;
            try {
                Gson gson = new Gson();
                writer = new PrintWriter(resFile, "UTF-8");
                writer.println(gson.toJson(rows));                
            } catch (FileNotFoundException | UnsupportedEncodingException ex) {
                Logger.getLogger(TableDAOJSONImpl.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                writer.close();
            }
        }
    }

    @Override
    public void delete() {
    }

    @Override
    public void update(List<Row> rows) {        
        if(rows.size() > 0){
            this.rows = rows;
            PrintWriter writer = null;
            try {
                Gson gson = new Gson();
                writer = new PrintWriter(resFile, "UTF-8");
                writer.println(gson.toJson(rows));                
            } catch (FileNotFoundException | UnsupportedEncodingException ex) {
                Logger.getLogger(TableDAOJSONImpl.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                writer.close();
            }
        }
    }
    
    private void createDefaultData(){        
        for(int i = 0; i < Constants.ROW_COUNT; i++){
            List<Cell> cells = new ArrayList<>();
            for(int j = 0; j < Constants.COLUMN_COUNT; j++){
                Cell cell = new Cell();
                cell.setText(String.valueOf((int) (Math.random() * 100000)));
                cell.setImgSrc("/res/smile.png");
                cells.add(cell);
            }
            Row row = new Row();
            row.setCells(cells);
            rows.add(row);
        }
    }

}
