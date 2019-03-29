package WebJdbc.demos.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import WebJdbc.demos.entity.Dvtt;
import WebJdbc.demos.entity.UnitDto;
import WebJdbc.demos.entity.Units;
import WebJdbc.demos.forms.UnitForm;
import WebJdbc.demos.repositorys.UnitRepository;

@Service
@Transactional
public class UnitServiceImpl implements UnitService {

	@Autowired
	private UnitRepository unitRepository;

	@Override
	public List<Units> list() {
		return this.unitRepository.list();
	}

	@Override
	public int add(UnitForm form) {
		Units unit = new Units();
		unit.setCode(form.getCode());
		unit.setName(form.getName());
		unit.setAddress(form.getAddress());
		unit.setTaxCode(form.getTaxCode());
		unit.setEmail(form.getEmail());
		unit.setMobile(form.getMobile());
		unit.setDvtt(form.getDvtt());
		LocalDateTime localDateTime = LocalDateTime.now();
		unit.setCreateDateTime(localDateTime);
		unit.setCreatePerson(" User create tempate ");

		return this.unitRepository.add(unit);
	}

	@Override
	public Units getByCode(String code) {
		return this.unitRepository.getByCode(code);
	}

	@Override
	public int update(Units unit) {
		LocalDateTime localDateTime = LocalDateTime.now();
		unit.setUpdateDateTime(localDateTime);
		unit.setUpdatePerson(" User update tempate ");
		return this.unitRepository.update(unit);
	}

	@Override
	public int delete(String code) {

		return this.unitRepository.delete(code);
	}

	@Override
	public List<UnitDto> searchByCondition(UnitForm form) {
		return this.unitRepository.searchByCondition(form);
	}

	@Override
	public List<Dvtt> listDvtt() {

		return this.unitRepository.listDvtt();
	}

	@Override
	public void insertBatch(List<UnitDto> data) {
		for (UnitDto unitDto : data) {
			LocalDateTime localDateTime = LocalDateTime.now();
			unitDto.setCreateDateTime(localDateTime);
			unitDto.setCreatePerson(" User create tempate upload");
		}
		this.unitRepository.insertBatch(data);

	}

	

}
