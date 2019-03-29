package WebJdbc.demos.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import WebJdbc.demos.entity.SearchHivRow;

@Component
public class WritePdf {

	final String FONT = "C:/Users/eHealth-PC/Downloads/font-times-new-roman.ttf";
	final String parentPath = "C:/Users/eHealth-PC/Desktop/pdf";

	public void createFile(List<SearchHivRow> list)
			throws DocumentException, IllegalArgumentException, IllegalAccessException, IOException {
		Document document = new Document(PageSize.A3.rotate());
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(parentPath + "/" + "thongtinbn.pdf"));
		document.open();
		PdfPTable table = new PdfPTable(12);
		table.setWidthPercentage(100);
		table.setSpacingBefore(10f);
		table.setSpacingAfter(10f);
		float[] columnWidths = { 0.5f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f };
		table.setWidths(columnWidths);
		try {
			document.add(new WritePdf().addHeader());
			for (SearchHivRow row : list) {
				document.add(new WritePdf().addRow(row));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		document.close();
		writer.close();
	}

	public PdfPTable addHeader()
			throws IllegalArgumentException, IllegalAccessException, DocumentException, IOException {
		PdfPTable rowHeader = new PdfPTable(12);
		rowHeader.setWidthPercentage(100);
		rowHeader.setSpacingBefore(10f);
		rowHeader.setSpacingAfter(10f);
		float[] columnWidths = { 0.5f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f };
		rowHeader.setWidths(columnWidths);

		SearchHivRow abc = new SearchHivRow();
		for (Field field : abc.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			String name = field.getName();
			BaseFont bf = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font f = new Font(bf, 10);
			PdfPCell cell = new PdfPCell(new Paragraph(name.toUpperCase(), f));
			if (name.toString().toLowerCase().contains("serialversionuid"))
				continue;
			else {
				rowHeader.addCell(cell);
			}
		}
		return rowHeader;
	}

	public PdfPTable addRow(SearchHivRow row)
			throws IllegalArgumentException, IllegalAccessException, DocumentException, IOException {
		PdfPTable rowTable = new PdfPTable(12);
		rowTable.setWidthPercentage(100);
		float[] columnWidths = { 0.5f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f };
		rowTable.setWidths(columnWidths);
		for (Field field : row.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			Object value = field.get(row);
			String name = field.getName();
			BaseFont bf = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font f = new Font(bf, 10);
			PdfPCell cell = new PdfPCell(new Paragraph(value.toString().toUpperCase(), f));
			cell.setLeft(5);
			if (name.toString().toLowerCase().contains("serialversionuid"))
				continue;
			else {
				rowTable.addCell(cell);
			}

		}
		return rowTable;

	}

}
