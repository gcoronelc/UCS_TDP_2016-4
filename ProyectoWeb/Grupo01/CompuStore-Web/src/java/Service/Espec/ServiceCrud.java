package Service.Espec;

import java.util.List;

public interface ServiceCrud<T> {
  
  void insert(T bean);
  
  void update(T bean);
  
  void delete(String id);
  
  T getForId(String id);
  
  List<T> getRecords(T bean);
  
}
