package WebJdbc.demos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import WebJdbc.demos.entity.LogEntity;
import WebJdbc.demos.service.DatabaseLogService;

@RestController
@RequestMapping(value = "/db")
@CrossOrigin(value = "*")
public class DatabaseLogController {

	@Autowired
	private DatabaseLogService databaseLogService;

	// generate for select option user list -call ajax for option:
	@GetMapping(value = "/search/list/user/{begin}/{end}")
	public ResponseEntity<List<String>> searchListUserInFolder(@PathVariable("begin") String begin,
			@PathVariable("end") String end) {
		System.out.print(" hic "  + begin);
		List<String> list = this.databaseLogService.searchListUserInDb(begin, end);
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	// generate for select option table list with begin and end date:
	@GetMapping(value = "/search/list/table/{begin}/{end}")
	public ResponseEntity<List<String>> searchListTableInFolder(@PathVariable("begin") String begin,
			@PathVariable("end") String end) {
		List<String> list = this.databaseLogService.searchListTableInDb(begin, end);
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	// Display list when pres search button : input : begin and end date
	@GetMapping(value = "/search/list/{begin}/{end}")
	public ResponseEntity<List<LogEntity>> searchListData(@PathVariable("begin") String begin,
			@PathVariable("end") String end) {
		List<LogEntity> list = this.databaseLogService.searchListData(begin, end);
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	// Display list when press search button :
	// input : begin and end date and table name
	@GetMapping(value = "/search/list/table/{begin}/{end}/{tableName}")
	public ResponseEntity<List<LogEntity>> searchListDataByTable(@PathVariable("begin") String begin,
			@PathVariable("end") String end, @PathVariable("tableName") String tableName) {

		List<LogEntity> list = this.databaseLogService.searchListDataByTable(begin, end, tableName);
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	// Display list when pres search button :
	// input : begin and end date, user name and table name:
	@GetMapping(value = "/search/list/user/{begin}/{end}/{userName}")
	public ResponseEntity<List<LogEntity>> searchListDataByUser(@PathVariable("begin") String begin,
			@PathVariable("end") String end, @PathVariable("userName") String userName) {
		List<LogEntity> list = this.databaseLogService.searchListDataByUser(begin, end, userName);
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	// Display list when pres search button :
	// input : begin and end date, user name and table name:
	@GetMapping(value = "/search/list/full/{begin}/{end}/{userName}/{tableName}")
	public ResponseEntity<List<LogEntity>> getListWithUserIdAndTable(@PathVariable("begin") String begin,
			@PathVariable("end") String end, @PathVariable("userName") String userName,
			@PathVariable("tableName") String tableName) {
		List<LogEntity> list = this.databaseLogService.searchListDataWithUserAndTable(begin, end, userName, tableName);
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

}
