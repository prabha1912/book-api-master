package com.praba.bookshop.controller.utility;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class FormatWithLocal {

	public static final DateTimeFormatter UK_DATE_FORMATTER = new DateTimeFormatterBuilder()
			.appendPattern("dd/MM/yyyy")
			.toFormatter(Locale.UK);
}
