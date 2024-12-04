package com.safetrust.testcases;
import com.safetrust.helpers.ExcelHelper;
import com.safetrust.helpers.PropertiesHelper;
import  com.safetrust.utils.LogUtils;
import org.testng.annotations.Test;

import static java.lang.System.*;

public class TestHandle {
    @Test
    public void testReadPropertiesFile(){
        PropertiesHelper.loadAllFiles();
        System.out.println(PropertiesHelper.getValue("author") );
    }

    @Test
    public void testReadExcelData(){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/datatest/Safetrust.xlsx","Login");

        System.out.println("email: "+excelHelper.getCellData("EMAIL",1));
        System.out.println("email: "+excelHelper.getCellData("PASSWORD",1));

    }

    @Test
    public void testLog4j2(){
        LogUtils.info("Cucumber TestNG");
    }
}

