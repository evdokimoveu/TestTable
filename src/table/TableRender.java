
package table;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import table.model.Cell;

/**
 *
 * @author evdokimoveu
 */
public class TableRender  extends JLabel implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Cell cell = (Cell) value;
        setOpaque(true);
        if(isSelected){
            setBackground(new Color(184,207,229));
        }
        else{
            setBackground(new Color(255, 255, 220));
        }
        setIcon(new ImageIcon(getClass().getResource("/res/smile.png")));
        setText(cell.getText());
        
        return this;
    }
    
    
}
