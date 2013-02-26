package net.thornydev.mybatis.koan.koan07;

import java.util.List;
import java.util.Map;

import net.thornydev.mybatis.koan.domain.Country;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

public interface Koan07Mapper {

  // TODO: add annotation to specify the SQL mapping for this method
  @Select( "SELECT count(*) FROM country" )
  int getCountryCount();

  // TODO: add annotation to specify the SQL mapping for this method
  @Select( {"SELECT country_id id, country, last_update lastUpdate ",
           "FROM country",
           "WHERE country_id = #{tacobell}"} )
  Country getCountryById(int id);

  // TODO: add annotation to specify the SQL mapping for this method
  // TODO: add any other annotations required to make this return a Map
  @Select( {"SELECT country_id id, country, last_update lastUpdate ",
           "FROM country",} )
  @MapKey( "id" )
  Map<Integer,Country> getAllCountriesMappedById();

  // TODO: add annotation to specify the SQL mapping for this method
  // TODO: depending how you specify the parameters in the SQL, you may
  //       also need additional annotations
  @Select( {"SELECT country_id id, country, last_update lastUpdate ",
          "FROM country",
          "WHERE country_id BETWEEN #{param1} AND #{param2}"} )
  List<Country> getCountryRange(int lowerBound, int upperBound);

  // TODO: add annotation to specify the SQL mapping for this method
  // TODO: even though you can have overloaded method names in Java, will it work here?
  @Select( {"SELECT country_id id, country, last_update lastUpdate ",
      "FROM country",} )
  List<Country> getCountryRange2(RowBounds rb);
}
