package org.seasar.doma.internal.apt.processor.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

@SuppressWarnings("deprecation")
@Dao(config = MyConfig.class)
public interface SqlValidationSkipWithConfigFileDao {

  @Select
  String selectById(String name);
}
