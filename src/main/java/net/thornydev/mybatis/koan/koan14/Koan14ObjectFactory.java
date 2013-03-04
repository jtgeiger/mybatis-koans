package net.thornydev.mybatis.koan.koan14;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.thornydev.mybatis.koan.domain.Actor;
import net.thornydev.mybatis.koan.domain.Address;
import net.thornydev.mybatis.koan.domain.Address.Builder;
import net.thornydev.mybatis.koan.domain.City;
import net.thornydev.mybatis.koan.util.KoanSchoolMarm;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

public class Koan14ObjectFactory extends DefaultObjectFactory {

  private static final long serialVersionUID = -8362701815721739033L;

  @Override
  public <T> T create(Class<T> type, List<Class<?>> ctorArgTypes, List<Object> ctorArgs) {
    // TODO: override this create method and call the appropriate createXXX
    //       method below based on the Class type passed in
    // NOTE: make sure to handle the case where the Class passed in is not
    //       one of the specific types we are overriding below - those need
    //       to invoke the MyBatis default object factory creation code
    //return null;
      if ( type == City.class )
          return createCity( ctorArgs );
      else if ( type == Actor.class )
          return createActor( ctorArgs );
      else if ( type == Address.class )
          return createAddress( ctorArgs );
      else
          return super.create( type, ctorArgTypes, ctorArgs );
  }

  /**
   * Create a City object using the constructor that uses its
   * three-param constructor.
   *
   * This usage of ObjectFactory adds no new net value and you
   * wouldn't use the ObjectFactory in production code this way,
   * but it serves to illustrate how to mimic what MyBatis does
   * behind the scenes with an ObjectFactory.
   *
   * This method expects three constructorArgs as specified in the
   * city-mapper.xml file.
   */
  private <T> T createCity(List<Object> ctorArgs) {
    // leave this intact
    KoanSchoolMarm.getInstance().setObjectFactoryUsed(true);

    // TODO: fill in, using the three param constructor of City
    //return null;
    if ( ctorArgs.size() != 3 )
        throw new IllegalArgumentException( "Expected 3 args; got=" + ctorArgs.size() );
    
    City city = new City( (Integer)ctorArgs.get( 0 ), (String)ctorArgs.get( 1 ), (Date)ctorArgs.get( 2 ) );
    @SuppressWarnings( "unchecked" )
    T tObj = (T) city;
    return tObj;
  }

  /**
   * Create an Actor object using the constructor that takes a Map
   * of field names to field values.
   *
   * This method expects four constructorArgs as specified in the
   * actor-mapper.xml file.
   */
  private <T> T createActor(List<Object> ctorArgs) {
    // leave this intact
    KoanSchoolMarm.getInstance().setObjectFactoryUsed(true);

    // TODO: fill in using the constructor of Actor that takes a Map
    //return null;
    if ( ctorArgs.size() != 4 )
        throw new IllegalArgumentException( "Expected 4 args; got=" + ctorArgs.size() );
    
    Map<String, Object> map = new HashMap<String, Object>();
    map.put( "id", ctorArgs.get( 0 ) );
    map.put( "firstName", ctorArgs.get( 1 ) );
    map.put( "lastName", ctorArgs.get( 2 ) );
    map.put( "lastUpdate", ctorArgs.get( 3 ) );
    
    Actor actor = new Actor( map );
    
    @SuppressWarnings( "unchecked" )
    T tObj = (T)actor;
    
    return tObj;
  }

  /**
   * Create an Address object using the Builder idiom.
   *
   * This method expects seven constructorArgs as specified in the
   * address-mapper.xml file.
   */
  private <T> T createAddress(List<Object> ctorArgs) {
    // leave this intact
    KoanSchoolMarm.getInstance().setObjectFactoryUsed(true);

    // TODO: fill in using the Address.Builder inner class of Address
    //return null;
    
    if ( ctorArgs.size() != 7 )
        throw new IllegalArgumentException( "Expected 7 args; got=" + ctorArgs.size() );
    
    Builder b = new Address.Builder()
        .id( (Integer)ctorArgs.get( 0 ) )
        .address( (String)ctorArgs.get( 1 ) )
        .address2( (String)ctorArgs.get( 2 ) )
        .district( (String)ctorArgs.get( 3 ) )
        .postalCode( (String)ctorArgs.get( 4 ) )
        .phone( (String)ctorArgs.get( 5 ) )
        .lastUpdate( (Date)ctorArgs.get( 6 ) );
        //.city( (City)ctorArgs.get( 7 ) );
    Address a = b.build();
    
    @SuppressWarnings( "unchecked" )
    T tObj = (T)a;
    
    return tObj;
  }

}
