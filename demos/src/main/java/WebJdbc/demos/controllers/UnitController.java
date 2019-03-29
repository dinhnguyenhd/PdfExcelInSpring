package WebJdbc.demos.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import WebJdbc.demos.entity.Dvtt;
import WebJdbc.demos.entity.UnitDto;
import WebJdbc.demos.entity.Units;
import WebJdbc.demos.forms.UnitForm;
import WebJdbc.demos.forms.UploadForm;
import WebJdbc.demos.service.UnitService;
import WebJdbc.demos.utils.ErrorMessage;
import WebJdbc.demos.utils.HandleExeptions;

@RestController
@RequestMapping(value = "/unit")
@CrossOrigin(value = "*")
public class UnitController {
	@Autowired
	private UnitService unitService;
	

	@GetMapping(value = "/list")
	public ResponseEntity<List<Units>> searchByCondition() {
		List<Units> list = this.unitService.list();
		
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	@PostMapping(value = "/search")
	public ResponseEntity<List<UnitDto>> list(@RequestBody UnitForm form) {
		List<UnitDto> list = this.unitService.searchByCondition(form);
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	// Luc add nho check trung code :
	@PostMapping(value = "/add")
	public ResponseEntity<?> addUnit(@Valid @RequestBody UnitForm form, BindingResult result) {
		if (result.hasErrors()) {
			List<ErrorMessage> list = HandleExeptions.getMessErrors(result);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} else {
			String code = form.getCode();
			Units check = this.unitService.getByCode(code);
			if (check != null) {
				return new ResponseEntity<>("-1", HttpStatus.OK);
			} else {
				Integer newbill = this.unitService.add(form);
				return new ResponseEntity<>(newbill, HttpStatus.OK);
			}
		}

	}

	@GetMapping(value = "/getbyId/{code}")
	public ResponseEntity<Units> getUnitById(@PathVariable("code") String code) {
		Units newBill = this.unitService.getByCode(code);
		return new ResponseEntity<Units>(newBill, HttpStatus.OK);

	}

	@PutMapping(value = "/update")
	public ResponseEntity<?> update(@RequestBody Units unit) {
		int result = this.unitService.update(unit);
		return new ResponseEntity<>(result, HttpStatus.OK);

	}

	@DeleteMapping(value = "/delete/{code}")
	public ResponseEntity<Integer> delete(@PathVariable("code") String code) {
		int result = this.unitService.delete(code);
		return new ResponseEntity<>(result, HttpStatus.OK);

	}

	@GetMapping(value = "/list/dvtt")
	public ResponseEntity<List<Dvtt>> getList() {
		List<Dvtt> list = this.unitService.listDvtt();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	// Luc add nho check trung code :
	@PostMapping(value = "/upload")
	public ResponseEntity<?> uploadFile(@RequestBody UploadForm form) {
		if (form.getData() != null) {
			form.getData().forEach(row -> {
				System.out.println(" name " + row.getName() + " dvtt" + row.getDvtt());
			});
		}
		this.unitService.insertBatch(form.getData());
		return new ResponseEntity<>(null, HttpStatus.OK);

	}

	

}
