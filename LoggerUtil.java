package com.daihui;

import org.slf4j.LoggerFactory;

/**
 * package-name: com.daihui
 * project-name: spring-ioc
 * function : 日志工具类
 * @author daihui
 * @since 2018-3-20 9:33  
 */
public class LoggerUtil {

    private static boolean isDebug = LoggerFactory.getLogger(LoggerUtil.class).isDebugEnabled();

    public static void info( String msg , Object... params ){
        LoggerFactory.getLogger(getClassName()).info( msg , params );
    }

    public static void info( String msg ){
        info(msg,null);
    }

    public static void debug( String msg , Object... params ){
        if(!isDebug)
            return ;

        LoggerFactory.getLogger(getClassName()).debug(msg,params);
    }

    public static void debug( String msg ){
        debug(msg,null);
    }



    public static void error( String msg , Object... params ){
        LoggerFactory.getLogger(getClassName()).error(msg,params);
    }


    public static void error( String msg ){
        error(msg,null);
    }

    // 获取调用 error,info,debug静态类的类名
    private static String getClassName() {
        return new SecurityManager() {
            public String getClassName() {
                return getClassContext()[3].getName();
            }
        }.getClassName();
    }

}
