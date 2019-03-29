package WebJdbc.demos.repositorys;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import WebJdbc.demos.entity.CauHinh;

@Repository
public class CauHinhRepositoryImpl implements CauHinhRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<CauHinh> listConfig() {
		String sql = "Select id, tenso, listcode FROM CauHinh";

		return jdbcTemplate.query(sql, (result, row) -> new CauHinh(result.getString("id"), result.getString("tenso"),
				result.getString("listcode")));

	}

	@Override
	public CauHinh getNameConfig(String findCode) {
		boolean flag = false;
		CauHinh newObject = new CauHinh();
		String sql = "Select id, tenso, listCode FROM CauHinh";
		List<CauHinh> list = jdbcTemplate.query(sql, (result, row) -> new CauHinh(result.getString("id"),
				result.getString("tenso"), result.getString("listcode")));

		for (CauHinh config : list) {
			StringTokenizer stok = new StringTokenizer(config.getListCode().trim(), ";");
			while (stok.hasMoreElements()) {
				String code = stok.nextToken().trim();
				if (code.equals(findCode.trim())) {
					newObject.setTenso(config.getTenso());
					flag = true;
					break;
				}
				if (flag == true)
					break;

			}
		}
		return newObject;

	}

	@Override
	public void insert(List<CauHinh> list) {
		for (CauHinh cauHinh : list) {
			System.out.println(cauHinh.toString());
		}
		String sql = "Insert Into CauHinh(id, tenso, listCode) " + " VALUES(?,?,?)";

		this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				CauHinh config = list.get(i);
				ps.setString(1, config.getId());
				ps.setString(2, config.getTenso());
				ps.setString(3, config.getListCode());
			}

			@Override
			public int getBatchSize() {
				return list.size();
			}
		});
	}

	@Override
	public void delete() {
		String sql = " Delete FROM cauhinh";
		jdbcTemplate.execute(sql);

	}

}
