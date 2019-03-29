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

import WebJdbc.demos.entity.FileLog;
import WebJdbc.demos.repositorys.FileHandles;

@RestController
@RequestMapping(value = "/folder")
@CrossOrigin(value = "*")
public class FileLogController {
	@Autowired
	private FileHandles fileHandles;

	// generate for select option user list -call ajax for option:
	@GetMapping(value = "/search/user/list/{begin}/{end}")
	public ResponseEntity<List<String>> searchListUserInFolder(@PathVariable("begin") String begin,
			@PathVariable("end") String end) {
		List<String> list = this.fileHandles.getListUserInDuration(begin, end);
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	// generate for select option table list with begin and end date:
	@GetMapping(value = "/search/table/list/{begin}/{end}")
	public ResponseEntity<List<String>> searchListTableInFolder(@PathVariable("begin") String begin,
			@PathVariable("end") String end) {
		List<String> list = this.fileHandles.getListTableInDuration(begin, end);
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	// Display list when pres search button : input : begin and end date
	@GetMapping(value = "/search/list/{begin}/{end}")
	public ResponseEntity<List<FileLog>> searchListData(@PathVariable("begin") String begin,
			@PathVariable("end") String end) {
		List<FileLog> list = this.fileHandles.getListFileLogInDuration(begin, end);
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	// Display list when press search button :
	// input : begin and end date and table name
	@GetMapping(value = "/search/list/table/{begin}/{end}/{tableName}")
	public ResponseEntity<List<FileLog>> searchListDataByTable(@PathVariable("begin") String begin,
			@PathVariable("end") String end, @PathVariable("tableName") String tableName) {

		List<FileLog> list = this.fileHandles.searchListDataByTable(begin, end, tableName);
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	// Display list when pres search button :
	// input : begin and end date, user name and table name:
	@GetMapping(value = "/search/list/user/{begin}/{end}/{userName}")
	public ResponseEntity<List<FileLog>> searchListDataByUser(@PathVariable("begin") String begin,
			@PathVariable("end") String end, @PathVariable("userName") String userName) {
		List<FileLog> list = this.fileHandles.searchListDataByUser(begin, end, userName);
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	// Display list when pres search button :
	// input : begin and end date, user name and table name:
	@GetMapping(value = "/search/list/full/{begin}/{end}/{userName}/{tableName}")
	public ResponseEntity<List<FileLog>> searchListDataWittUserAndTable(@PathVariable("begin") String begin,
			@PathVariable("end") String end, @PathVariable("userName") String userName,
			@PathVariable("tableName") String tableName) {
		List<FileLog> list = this.fileHandles.getListWithUserIdAndTable(begin, end, userName, tableName);
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

}
