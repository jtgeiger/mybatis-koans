package net.thornydev.mybatis.koan.util;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.thornydev.mybatis.koan.domain.Country;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class CountryIdTypeHandler extends BaseTypeHandler<Country>
{

    @Override
    public void setNonNullParameter( PreparedStatement ps, int i, Country parameter,
            JdbcType jdbcType ) throws SQLException
    {
        ps.setInt( i, parameter.getId() );
    }

    @Override
    public Country getNullableResult( ResultSet rs, String columnName ) throws SQLException
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException( "Acrinta TODO!" );
    }

    @Override
    public Country getNullableResult( ResultSet rs, int columnIndex ) throws SQLException
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException( "Acrinta TODO!" );
    }

    @Override
    public Country getNullableResult( CallableStatement cs, int columnIndex ) throws SQLException
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException( "Acrinta TODO!" );
    }

}
