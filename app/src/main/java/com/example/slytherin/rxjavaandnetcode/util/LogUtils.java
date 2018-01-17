package com.example.slytherin.rxjavaandnetcode.util;

import com.example.slytherin.rxjavaandnetcode.BuildConfig;
import com.orhanobut.logger.Logger;

/**
 * used for output log
 *
 * Created by Slytherin on 2018/1/2.
 */

public class LogUtils {
    public static final boolean VERBUSE = BuildConfig.LOG_CALLS;
    public static final boolean DEBUG = BuildConfig.LOG_CALLS;
    public static final boolean INFO = BuildConfig.LOG_CALLS;
    public static final boolean WARN = BuildConfig.LOG_CALLS;
    public static final boolean ERROR = BuildConfig.LOG_CALLS;
    public static final boolean ASSERT = BuildConfig.LOG_CALLS;
    public static void VERBUSE(String msg){
        if (VERBUSE){
            Logger.v(msg);
        }
    }
    public static void DEBUG(String msg){
        if (DEBUG){
            Logger.d(msg);
        }
    }
    public static void INFO(String msg){
        if (INFO){
            Logger.i(msg);
        }
    }
    public static void WARN(String msg){
        if (WARN){
            Logger.w(msg);
        }
    }
    public static void ERROR(String msg){
        if (ERROR){
            Logger.e(msg);
        }
    }
    public static void ASSERT(String msg){
        if (ASSERT){
            Logger.wtf(msg);
        }
    }
}
