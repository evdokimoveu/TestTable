
package table;

import table.model.Cell;
import table.model.Row;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import table.utils.Constants;

/**
 *
 * @author evdokimoveu
 */
public class TableModel extends AbstractTableModel {
    
    private List<Row> rows;    

    public TableModel() {
    }

    public TableModel(List<Row> rows) {
        this.rows = rows;        
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return Constants.COLUMN_COUNT;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Row row = rows.get(rowIndex);
        List<Cell> cells = row.getCells();
        Cell cell = cells.get(columnIndex);
        return cell;
    }

    @Override
    public String getColumnName(int column) {
        return super.getColumnName(column);
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }
}
