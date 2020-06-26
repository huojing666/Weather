package com.until;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * @author Sweeney
 * @date 2020/6/26 10:10 PM
 */


public class XmlBuilder {
    /**
     * XML转换成POJO
     * */

    public static Object xmlstrToObject(Class<?> clazz ,String xmlStr) throws JAXBException, IOException {
        Object xmlObject = null;
        Reader reader = null;
        JAXBContext context = JAXBContext.newInstance(clazz);
        /**
         * xml转化对象的接口
         * */
        Unmarshaller unmarshaller = context.createUnmarshaller();
        reader = new StringReader(xmlStr);
        xmlObject = unmarshaller.unmarshal(reader);
        /**
         *资源关闭
         * */
        if (null != reader){
            reader.close();
        }
        return xmlObject;

    }
}
