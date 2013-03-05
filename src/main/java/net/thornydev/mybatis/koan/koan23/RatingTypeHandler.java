package net.thornydev.mybatis.koan.koan23;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class RatingTypeHandler extends BaseTypeHandler<Rating>
{

    @Override
    public void setNonNullParameter( PreparedStatement ps, int i, Rating parameter,
            JdbcType jdbcType ) throws SQLException
    {
        ps.setString( i, parameter.toString() );
    }

    @Override
    public Rating getNullableResult( ResultSet rs, String columnName ) throws SQLException
    {
        return getRating( rs.getString( columnName ) );
    }

    private Rating getRating( String string )
    {
        Rating r = Rating.fromString( string );
        return r;
    }

    @Override
    public Rating getNullableResult( ResultSet rs, int columnIndex ) throws SQLException
    {
        return getRating( rs.getString( columnIndex ) );
    }

    @Override
    public Rating getNullableResult( CallableStatement cs, int columnIndex ) throws SQLException
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException( "Acrinta TODO!" );
    }

}
