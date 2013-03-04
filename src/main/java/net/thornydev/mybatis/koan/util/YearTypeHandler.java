package net.thornydev.mybatis.koan.util;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class YearTypeHandler extends BaseTypeHandler<Year>
{

    @Override
    public Year getNullableResult( CallableStatement cs, int columnIndex ) throws SQLException
    {
        Date date = cs.getDate( columnIndex );
        return new Year( date );
    }

    @Override
    public Year getNullableResult( ResultSet rs, int columnIndex ) throws SQLException
    {
        Date date = rs.getDate( columnIndex );
        return new Year( date );
    }

    @Override
    public Year getNullableResult( ResultSet rs, String columnName ) throws SQLException
    {
        Date date = rs.getDate( columnName );
        return new Year( date );
    }

    @Override
    public void setNonNullParameter( PreparedStatement ps, int i, Year parameter, JdbcType jdbcType )
            throws SQLException
    {
        java.sql.Date date = new java.sql.Date( parameter.getYearAsDate().getTime() );
        ps.setDate( i, date );
    }

}
