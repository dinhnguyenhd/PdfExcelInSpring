package WebJdbc.demos.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import WebJdbc.demos.entity.Units;

public class UnitMapper implements RowMapper<Units> {
	@Override
	public Units mapRow(ResultSet rs, int rowNum) throws SQLException {
		Units object = new Units();
		object.setCode(rs.getString("code"));
		object.setName(rs.getString("name"));
		object.setName(rs.getString("address"));
		object.setName(rs.getString("taxCode"));
		object.setName(rs.getString("email"));
		object.setName(rs.getString("mobile"));
		return object;
	}
}