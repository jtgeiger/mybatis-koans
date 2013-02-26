package net.thornydev.mybatis.koan.koan08;

import org.apache.ibatis.annotations.Delete;

import net.thornydev.mybatis.koan.domain.Country;

public interface Koan08Mapper {
  // TODO: Specify the DELETE sql in an annotation, not xml, for this method
  //       that takes an id, rather than a Country object
  @Delete( "DELETE FROM country WHERE country_id = #{burritos}" )
  int deleteCountryById(int id);


  // TODO: Specify the DELETE sql in an annotation, not xml, for this method
  //       that takes a Country object, rather than an id
  @Delete( "DELETE FROM country WHERE country_id = #{id}" )
  int deleteCountry(Country c);
}
