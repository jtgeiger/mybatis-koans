package net.thornydev.mybatis.koan.util;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.thornydev.mybatis.koan.domain.City;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class CityIdTypeHandler extends BaseTypeHandler<City>
{

    @Override
    public void setNonNullParameter( PreparedStatement ps, int i, City parameter, JdbcType jdbcType )
            throws SQLException
    {
        ps.setInt( i, parameter.getId() );
    }

    @Override
    public City getNullableResult( ResultSet rs, String columnName ) throws SQLException
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException( "Acrinta TODO!" );
    }

    @Override
    public City getNullableResult( ResultSet rs, int columnIndex ) throws SQLException
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException( "Acrinta TODO!" );
    }

    @Override
    public City getNullableResult( CallableStatement cs, int columnIndex ) throws SQLException
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException( "Acrinta TODO!" );
    }

}
