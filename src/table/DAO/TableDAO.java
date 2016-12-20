
package table.DAO;

import java.util.List;

/**
 *
 * @author evdokimoveu
 * @param <T> 
 */
public interface TableDAO<T> {
    List<T> read();
    void create();
    void update(List<T> table);
    void delete();
}
