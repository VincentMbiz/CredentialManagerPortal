package com.safetrust.constant;

import com.safetrust.helpers.PropertiesHelper;

public class ConstantGlobal {

    static {
        PropertiesHelper.loadAllFiles();
    }

    public static final String URL = PropertiesHelper.getValue("URL");
    public static final String EMAIL = PropertiesHelper.getValue("EMAIL");
    public static final String PASSWORD = PropertiesHelper.getValue("PASSWORD");
    public static final Boolean HEADLESS = Boolean.parseBoolean(PropertiesHelper.getValue("HEADLESS"));
    public final static String BROWSER = PropertiesHelper.getValue("BROWSER");
    public final static String USERNAME = PropertiesHelper.getValue("USERNAME");
    public final static long STEP_TIME = Long.parseLong(PropertiesHelper.getValue("STEP_TIME"));
    public final static long EXPLICIT_TIMEOUT = Long.parseLong(PropertiesHelper.getValue("EXPLICIT_TIMEOUT"));
    public final static long PAGE_LOAD_TIMEOUT = Long.parseLong(PropertiesHelper.getValue("PAGE_LOAD_TIMEOUT"));
    public final static String ENV = PropertiesHelper.getValue("ENV");
    public final static String SCREENSHOT_FAIL = PropertiesHelper.getValue("SCREENSHOT_FAIL");
    public final static String SCREENSHOT_PASS = PropertiesHelper.getValue("SCREENSHOT_PASS");
    public final static String SCREENSHOT_STEP = PropertiesHelper.getValue("SCREENSHOT_STEP");
    public final static String RECORD_VIDEO = PropertiesHelper.getValue("RECORD_VIDEO");
    public final static String RECORD_VIDEO_PATH = PropertiesHelper.getValue("RECORD_VIDEO_PATH");
    public final static String EXTENT_REPORT_PATH = PropertiesHelper.getValue("EXTENT_REPORT_PATH");
    public final static String AUTHOR = PropertiesHelper.getValue("AUTHOR");
}
