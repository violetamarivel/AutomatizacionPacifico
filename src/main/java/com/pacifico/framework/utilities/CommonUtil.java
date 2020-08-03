package com.pacifico.framework.utilities;

import com.pacifico.framework.base.DriverContext;
import com.pacifico.framework.config.Settings;
import cucumber.api.Scenario;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Locale;
import java.util.Random;

/**
 * Created by jsegura on 02/06/17.
 */
public class CommonUtil {

    public static void waitSleep(int i) {

        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAllCookies() {
        DriverContext.Driver.manage().deleteAllCookies();
    }

    public static String randomNumber(int low, int high) {

        Random r = new Random();
        int result = r.nextInt(high - low) + low;
        return result + "";
    }

    public static void embedScreenshot(WebDriver driver, Scenario scenario) {
        try {
            final byte[] byteFile = ((TakesScreenshot) DriverContext.Driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(byteFile, "image/png");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public static void takeScreenshot(WebDriver driver, Scenario scenario) {

        try {
            File dir = new File(Settings.ScreenPath);
            if (!dir.exists())
                dir.mkdir();
        } catch (Exception e) {
        }

        File scrFile = ((TakesScreenshot) DriverContext.Driver).getScreenshotAs(OutputType.FILE);
        String NewFileNamePath = null;
        File directory = new File(".");

        ZoneId zid = ZoneId.of("America/Lima");
        ZonedDateTime date = ZonedDateTime.now(zid);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String fileNameFormat = date.format(formatter);
        String classAndMethodName = fileNameFormat + "_" + scenario.getId();

        try {
            NewFileNamePath = directory.getCanonicalPath() + File.separator + Settings.ScreenPath + File.separator + classAndMethodName + ".png";
            FileUtils.copyFile(scrFile, new File(NewFileNamePath));
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    public static String getFeatureName(String id) {
        String[] strName = id.split(";");
        String output = strName[0].substring(0, 1).toUpperCase() + strName[0].substring(1);
        return output.replace('-', ' ');
    }

    public static String getTagsName(Collection<String> sourceTagNames) {

        String strTags = "";
        for (String tag : sourceTagNames) {
            strTags += tag + " ";
//            System.out.println("Scenario Tag "+tag);
        }

        return strTags;
    }

    public static String getExecutiveTime(long endMillis, long startMillis) {

        long millis = endMillis - startMillis;
        long second = (millis / 1000) % 60;
        long minute = (millis / (1000 * 60)) % 60;
        long hour = (millis / (1000 * 60 * 60)) % 24;

        return String.format("%02d:%02d:%02d:%d", hour, minute, second, millis);
    }

    public static String getConfigDate(String pFormatDate, String time, String... format) {

        ZoneId zid = ZoneId.of("America/Lima");

        if (pFormatDate.length() > 0) {

            ZonedDateTime localDate = null;

            if (time.equals("Initial Time")) {
                if (pFormatDate.equals("NOW")) {
                    localDate = ZonedDateTime.now(zid);
                } else {
                    localDate = ZonedDateTime.now(zid).withHour(0).withMinute(0).withSecond(0);
                }
            } else {
                localDate = ZonedDateTime.now(zid).withHour(23).withMinute(59).withSecond(59);
            }

            //Initial Time
            if (pFormatDate.equals("NOW")) {
                localDate = localDate;
            } else {
                String signal = pFormatDate.substring(3, 4);
                int days = Integer.parseInt(pFormatDate.substring(4));
                if (signal.equals("+")) {
                    localDate = localDate.plusDays(days);
                } else {
                    localDate = localDate.minusDays(days);
                }
            }

            if (format.length > 0) {
                return localDate.format(DateTimeFormatter.ofPattern(format[0]).withLocale(Locale.getDefault()).withZone(ZoneId.systemDefault())); //.toLowerCase()
//                String strFormated = format[0];
//                strFormated = StringUtils.replace(strFormated,"dd",strDay);
//                strFormated = StringUtils.replace(strFormated,"MM",strMonth);
//                strFormated = StringUtils.replace(strFormated,"MMM",strMonth);
//                strFormated = StringUtils.replace(strFormated,"yyyy",year+"");
//                return strFormated;
            }

            int year = localDate.getYear();
            int month = localDate.getMonth().getValue();
            String strMonth = month < 10 ? "0" + month : month + "";
            int day = localDate.getDayOfMonth();
            String strDay = day < 10 ? "0" + day : day + "";

            return strMonth + strDay + year + "";
        }
        return "";
    }

    public static void removeBackspaceInput(WebElement element, int nroRetry) {

        for (int i = 0; i < nroRetry; i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }

        if (element.getAttribute("value").length() > 0) {
            for (int i = 0; i < nroRetry; i++) {
                element.sendKeys(Keys.BACK_SPACE);
            }
        }

    }

    public static String responseMessage(Response response, int statusExpected) {

        String strMessageError = "Error don't expected";

        if (response.getStatusCode() != statusExpected) {

            if (response.getStatusCode() != 200) {
                String respMsg = response.path("message") != null ? response.path("message").toString() : response.asString();
                strMessageError = response.getStatusCode() != statusExpected ? respMsg : null;
                if (response.contentType().equals("text/html")) {
                    strMessageError = response.htmlPath().get().toString();
                }
            }
        }


        return strMessageError;
    }

}

//    yyyy-MM-dd                 1969-12-31
//    yyyy-MM-dd                 1970-01-01
//    yyyy-MM-dd HH:mm           1969-12-31 16:00
//    yyyy-MM-dd HH:mm           1970-01-01 00:00
//    yyyy-MM-dd HH:mmZ          1969-12-31 16:00-0800
//    yyyy-MM-dd HH:mmZ          1970-01-01 00:00+0000
//    yyyy-MM-dd HH:mm:ss.SSSZ   1969-12-31 16:00:00.000-0800
//    yyyy-MM-dd HH:mm:ss.SSSZ   1970-01-01 00:00:00.000+0000
//    yyyy-MM-dd'T'HH:mm:ss.SSSZ 1969-12-31T16:00:00.000-0800
//    yyyy-MM-dd'T'HH:mm:ss.SSSZ 1970-01-01T00:00:00.000+0000
