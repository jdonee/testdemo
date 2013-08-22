package org.jdonee.demo.junit.JUnitParams;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.converters.ConvertParam;
import junitparams.converters.ParamConverter;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class ParamsConverterTest {
	@Test
    @Parameters({ "01.12.2012" })
    public void convertSingleParam(
        @ConvertParam(value = StringToDateConverter.class, options = "dd.MM.yyyy") Date date) {
        Calendar calendar = createCalendarWithDate(date);
        assertCalendarDate(calendar);
    }

    @Test
    @Parameters({ "01.12.2012,A" })
    public void convertMultipleParams(
        @ConvertParam(value = StringToDateConverter.class, options = "dd.MM.yyyy") Date date,
        @ConvertParam(LetterToNumberConverter.class) int num) {
        Calendar calendar = createCalendarWithDate(date);
        assertCalendarDate(calendar);
        assertEquals(1, num);
    }

    @Test
    @Parameters(method = "params")
    public void convertParamsFromMethod(
            @ConvertParam(value = StringToDateConverter.class, options = "dd.MM.yyyy") Date date) {
        Calendar calendar = createCalendarWithDate(date);
        assertCalendarDate(calendar);
    }

    private List<String> params() {
        return Arrays.asList("01.12.2012");
    }

    private void assertCalendarDate(Calendar calendar) {
        assertEquals(2012, calendar.get(Calendar.YEAR));
        assertEquals(11, calendar.get(Calendar.MONTH));
        assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
    }

    private Calendar createCalendarWithDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static class LetterToNumberConverter implements ParamConverter<Integer> {
        @Override
		public Integer convert(Object param, String options) {
            return param.toString().charAt(0) - 64;
        }
    }

    public static class StringToDateConverter implements ParamConverter<Date> {
        @Override
		public Date convert(Object param, String options) {
            try {
                return new SimpleDateFormat(options).parse(param.toString());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
