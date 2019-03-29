package WebJdbc.demos.repositorys;

import java.util.List;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import WebJdbc.demos.entity.DoiTuong;
import WebJdbc.demos.entity.Place;
import WebJdbc.demos.entity.SearchHivRow;
import WebJdbc.demos.forms.SearchHivFrom;
import WebJdbc.demos.forms.SelectItem;

@Repository
public class HivRepositoryImpl implements HivRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public List<Place> listPlace() {
		String sql = " Select id, noichidinh  from noichidinh";
		return jdbcTemplate.query(sql,
				(result, row) -> new Place(result.getLong("id"), result.getString("noichidinh")));
	}

	public List<DoiTuong> listDoiTuong() {
		String sql = " Select id, name  from doituong";
		return jdbcTemplate.query(sql, (result, row) -> new DoiTuong(result.getLong("id"), result.getString("name")));
	}

	public List<SearchHivRow> searchHiv(SearchHivFrom form, StringBuilder inConditions ){
		
		StringJoiner set = new StringJoiner(",");
		for(SelectItem item : form.getList()) {
			set.add("'" + item.getLabel() + "'");
		}
		System.out.println("set " + set);
		String sql = "Select  " + 
				"  bn.id as id, "  +
				"  bn.hoten as hoten, "  + 
				"  bn.gioitinh as gioitinh, " + 
				"  bn.tuoi as tuoi, " + 
				"  bn.diachi as diachi, " + 
				"  bn.doituong as doituong, " + 
				"  kq.ngaylm as ngaylm, " + 
				"  kq.ngayxn as ngayxn, " + 
				"  kq.sp as sp, " + 
				"  dmxn.maxn as maxn, " + 
				"  kq.ketluan as ketluan, " + 
				"  kq.ketluankd as ketluankd, " + 
				"  kq.ghichu as ghichu " + 
				"  from ketquaxn kq " + 
				"  inner join benhnhan bn on kq.idbn = bn.id " + 
				"  inner join danhmucxn dmxn on kq.iddm = dmxn.id ";
		
		StringBuilder condition= new StringBuilder();
		condition.append(" WHERE kq.ngayxn >= '" + form.getBegin().trim() + "' AND  kq.ngayxn <= '" + form.getEnd().trim()+"' ");
		condition.append(" AND dmxn.maxn IN ( " + inConditions + " ) ");
		if (set.length() > 0) {
			condition.append(" AND bn.doituong IN ( " + set + ")");
		}
		if (form.getPlace() != null && form.getPlace().trim().length()>0) {
			condition.append(" AND  kq.noichidinh  = '"+ form.getPlace().trim() + "'");
		}
		
		
		System.out.print(" SQL " +sql.concat(condition.toString()));
	
		return jdbcTemplate.query(sql.concat(condition.toString()),
				(result, row) -> new SearchHivRow(
						result.getString("id"), 
						result.getString("hoten"), 
						result.getString("gioitinh"),
						result.getString("tuoi"),
						result.getString("diachi"),
						result.getString("doituong"),
						result.getString("ngaylm"),
						result.getString("ngayxn"),
						result.getString("sp"),
						result.getString("maxn"),
						result.getString("ketluan"),
						result.getString("ketluankd"),
						result.getString("ghichu")
						));
		
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

}
