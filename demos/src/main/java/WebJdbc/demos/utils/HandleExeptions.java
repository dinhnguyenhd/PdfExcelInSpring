package WebJdbc.demos.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class HandleExeptions {

	public static List<ErrorMessage> getMessErrors(BindingResult result) {
		List<ErrorMessage> list = new ArrayList<>();
		for (FieldError s : result.getFieldErrors()) {
			list.add(new ErrorMessage(s.getField(), s.getDefaultMessage()));
		}
		return list;
	}

}
