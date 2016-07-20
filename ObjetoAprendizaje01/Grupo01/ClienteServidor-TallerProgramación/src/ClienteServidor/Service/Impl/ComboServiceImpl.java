package ClienteServidor.Service.Impl;

import ClienteServidor.DB.AccesoDB;
import ClienteServidor.Domain.Combo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ClienteServidor.Service.Espec.ComboServiceEspec;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog www.desarrollasoftware.com
 */
public class ComboServiceImpl implements ComboServiceEspec {

  private final String SQL_CATEGORIA_SELECT
          = "select cast(idcat as varchar) as code, "
          + "cast(idcat as varchar) + ' - ' "
          + "+ nombre as name "
          + "from Tbl_Categoria ";

  @Override
  public List<Combo> getCategorias() {
    List<Combo> lista = new ArrayList<>();
    Connection cn = null;
    try {
      // Abriendo la conexión con la BD
      cn = AccesoDB.getConnection();
      // Proceso
      String sql = SQL_CATEGORIA_SELECT;
      PreparedStatement pstm = cn.prepareStatement(sql);
      ResultSet rs = pstm.executeQuery();
      while (rs.next()) {
        Combo bean = mapRow(rs);
        lista.add(bean);
      }
      rs.close();
      pstm.close();
    } catch (Exception e) {
      String texto = "Error en el proceso.";
      if (e.getMessage() != null && !e.getMessage().isEmpty()) {
        texto += "\n" + e.getMessage();
      }
      throw new RuntimeException(texto);
    } finally {
      try {
        // Cerrando la conexión
        cn.close();
      } catch (Exception e) {
      }
    }
    return lista;
  }

  @Override
  public Combo mapRow(ResultSet rs) throws SQLException {
    Combo bean = new Combo();
    bean.setCode(rs.getString("code"));
    bean.setName(rs.getString("name"));
    bean.setSelect(0);
    return bean;
  }

}
