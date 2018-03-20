package com.daihui.util;

import java.io.*;

/**
 * package-name: com.daihui.util
 * project-name: spring-ioc
 * function : 主要用于类的复制
 * @author daihui
 * @since 2018-3-20 18:37  
 */
public class CloneUtil {

    /**
     * function: 实现同类型对象的拷贝
     * @param source
     * @return T
     * @author daihui
     * @since 2018-3-20 18:42
     */
    public static <T extends Serializable> T clone(T source){
        if(source == null)
            return null;

        T result = null;
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(source);
            oos.close();

            ByteArrayInputStream bis = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            result = (T) ois.readObject();
            ois.close();

        } catch (Exception e) {
            LoggerUtil.error("序列化异常：param:{},exception:{}",source,e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

}
