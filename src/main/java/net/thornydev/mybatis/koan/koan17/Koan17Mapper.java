package net.thornydev.mybatis.koan.koan17;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import net.thornydev.mybatis.koan.util.FilmInStockId;
import net.thornydev.mybatis.koan.util.FilmInStockParam;

public interface Koan17Mapper {
  /* ---[ film_in_stock stored proc mapper methods ]--- */

  // TODO: add annotations to make this work
//jtg: not working
  @Select( "{ CALL film_in_stock( " +
  		"#{filmId, mode=IN, jdbcType=INTEGER}, " +
  		"#{storeId, mode=IN, jdbcType=INTEGER}, " +
  		"#{count, mode=OUT, jdbcType=INTEGER} ) }")
  List<Map<String,Integer>> callFilmInStockWithHashMaps(Map<String,Integer> params);

  // TODO: add annotations to make this work
  @Select( "{ CALL film_in_stock( " +
          "#{filmId, mode=IN, jdbcType=INTEGER}, " +
          "#{storeId, mode=IN, jdbcType=INTEGER}, " +
          "#{count, mode=OUT, jdbcType=INTEGER} ) }")
  @ResultMap(value = "filmInStockIdMap")
  @Options(statementType = StatementType.CALLABLE)
  List<FilmInStockId> callFilmInStock(FilmInStockParam params);

  // TODO: add annotations to make this work
  @Select( "{ CALL film_in_stock( " +
          "#{filmId, mode=IN, jdbcType=INTEGER}, " +
          "#{storeId, mode=IN, jdbcType=INTEGER}, " +
          "#{count, mode=OUT, jdbcType=INTEGER} ) }")
  @Options(statementType = StatementType.CALLABLE)
  List<Integer> callFilmInStock2(FilmInStockParam params);

  /* ---[ inventory_in_stock stored function mapper methods ]--- */

  // TODO: add annotations to make this work
  @Select( "SELECT inventory_in_stock( #{theParam} )" )
  @Options(statementType = StatementType.CALLABLE)
  Boolean inventoryInStore(int storeId);
}
