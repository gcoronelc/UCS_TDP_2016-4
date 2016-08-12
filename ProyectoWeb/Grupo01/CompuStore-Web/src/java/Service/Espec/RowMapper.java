package Service.Espec;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog www.desarrollasoftware.com
 */
public interface RowMapper<T> {
  
  T mapRow(ResultSet rs) throws SQLException;
  
}
