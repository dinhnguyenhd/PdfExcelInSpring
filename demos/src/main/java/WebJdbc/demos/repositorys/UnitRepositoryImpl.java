package WebJdbc.demos.repositorys;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import WebJdbc.demos.entity.Dvtt;
import WebJdbc.demos.entity.UnitDto;
import WebJdbc.demos.entity.Units;
import WebJdbc.demos.forms.UnitForm;

@Repository
public class UnitRepositoryImpl implements UnitRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<Units> list() {

		String sql = " Select code, " + "name," + "address," + "taxCode," + "email," + "mobile," + "dvtt ,"
				+ "createPerson," + "createDateTime," + "updatePerson," + "updateDateTime  from dm_donvi";
		return jdbcTemplate.query(sql,
				(result, row) -> new Units(result.getString("code"), result.getString("name"),
						result.getString("address"), result.getString("taxCode"), result.getString("email"),
						result.getString("mobile"), result.getString("dvtt")));
	}

	@Override
	public int add(Units unit) {
		String query = " Insert Into dm_donvi(code, name, address, taxCode, email, mobile, dvtt, createDateTime, createPerson) "
				+ " VALUES(?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(query, unit.getCode(), unit.getName(), unit.getAddress(), unit.getTaxCode(),
				unit.getEmail(), unit.getMobile(), unit.getDvtt(), unit.getCreateDateTime(), unit.getCreatePerson());

	}

	@Override
	public Units getByCode(String code) {

		String sql = "select * from dm_donvi where code = ?";

		try {
			Units user = getJdbcTemplate().queryForObject(sql, new Object[] { code }, new RowMapper<Units>() {
				public Units mapRow(ResultSet rs, int rowNum) throws SQLException {

					Units unit = new Units();
					unit.setCode(rs.getString("code"));
					unit.setName(rs.getString("name"));
					unit.setAddress(rs.getString("address"));
					unit.setMobile(rs.getString("mobile"));
					unit.setEmail(rs.getString("email"));

					return unit;
				}
			});
			return user;

		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public int update(Units unit) {
		String sql = "UPDATE dm_donvi " + " SET " + " name = ? ," + " address = ? ," + " taxCode=? ," + " email = ? ,"
				+ " mobile=? , " + " dvtt = ? , " + " updateDateTime=? , " + " updatePerson=?  "+  " WHERE code = ?";
		return jdbcTemplate.update(sql, unit.getName(), unit.getAddress(), unit.getTaxCode(), unit.getEmail(),
				unit.getMobile(), unit.getDvtt(), unit.getUpdateDateTime(), unit.getUpdatePerson(),unit.getCode());
	}

	@Override
	public int delete(String code) {
		String query = "Delete from dm_donvi where code =  ?";
		return jdbcTemplate.update(query, code);

	}

	/**
	 * @return the jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * @param jdbcTemplate the jdbcTemplate to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * @return the namedParameterJdbcTemplate
	 */
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	/**
	 * @param namedParameterJdbcTemplate the namedParameterJdbcTemplate to set
	 */
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public List<UnitDto> searchByCondition(UnitForm form) {

		StringBuilder condition = new StringBuilder();
		if (form.getCode() != null && form.getCode().length() > 0) {
			condition.append("code like '%" + form.getCode() + "%'");
		}
		if (form.getName() != null && form.getName().length() > 0) {
			if (form.getCode().trim().length() != 0l) {
				condition.append(" and name like '%" + form.getName() + "%'");
			} else {
				condition.append(" name like '%" + form.getName() + "%'");
			}
		}
		if (form.getAddress() != null && form.getAddress().length() > 0) {
			if (form.getCode().trim().length() != 0 || form.getName().trim().length() != 0) {
				condition.append(" and address like '%" + form.getAddress() + "%'");
			}
			if (form.getCode().trim().length() == 0 && (form.getName().trim().length() == 0)) {
				condition.append(" address like '%" + form.getAddress() + "%'");
			}

		}
		if (form.getMobile() != null && form.getMobile().length() > 0) {
			if (form.getCode().trim().length() == 0 && form.getName().trim().length() == 0 && form.getAddress().trim().length() == 0) {
				condition.append(" mobile  like '%" + form.getMobile() + "%'");
			} else {
				condition.append(" and mobile  like '%" + form.getMobile() + "%'");
			}

		}
		String sql = " Select code, " + "name," + "address," + "taxCode," + "email," + "mobile " + " from dm_donvi";
		if (condition.length() > 0) {
			sql = sql + " where  " + condition;
		}

		return jdbcTemplate.query(sql,
				(result, row) -> new UnitDto(result.getString("code"), result.getString("name"),
						result.getString("address"), result.getString("taxCode"), result.getString("email"),
						result.getString("mobile")));
	}

	@Override
	public List<Dvtt> listDvtt() {

		String sql = "Select id,  name  from dvtt";
		return jdbcTemplate.query(sql, (result, row) -> new Dvtt(result.getInt("id"), result.getString("name")));
	}

	@Override
	public void insertBatch(List<UnitDto> data) {

		String sql = " Insert Into dm_donvi(code, name, address, taxCode, email, mobile, dvtt, createDateTime, createPerson) "
				+ " VALUES(?,?,?,?,?,?,?,?,?)";

		this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				UnitDto unit = data.get(i);
				ps.setString(1, unit.getCode());
				ps.setString(2, unit.getName());
				ps.setString(3, unit.getAddress());
				ps.setString(4, unit.getTaxCode());
				ps.setString(5, unit.getEmail());
				ps.setString(6, unit.getMobile());
				ps.setString(7, unit.getDvtt());
				ps.setString(8, unit.getCreateDateTime().toString());
				ps.setString(9, unit.getCreatePerson());

			}

			@Override
			public int getBatchSize() {
				return data.size();
			}
		});

	}

}
