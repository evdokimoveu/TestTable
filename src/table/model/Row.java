package table.model;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author evdokimoveu
 */
public class Row {
    
    private List<Cell> cells;

    public Row() {
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.cells);
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
        final Row other = (Row) obj;
        if (!Objects.equals(this.cells, other.cells)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Row{" + "cells=" + cells + '}';
    }
    
    
}
