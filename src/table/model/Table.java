
package table.model;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author evdokimoveu
 */
public class Table {
    private List<Row> rows;

    public Table(List<Row> rows) {
        this.rows = rows;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.rows);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Table other = (Table) obj;
        if (!Objects.equals(this.rows, other.rows)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Table{" + "rows=" + rows + '}';
    }
    
    
}
