package net.transino.lms.modules.ext.ws.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @author lee
 * @since 5.0
 */
public class JAXBTools {
    /**
     * Java类向XML进行转换
     * @param cls
     * @param obj
     * @throws JAXBException
     */
    public static <T> String java2Xml(Class<T> cls,Object obj) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(cls);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter writer = new StringWriter();
        marshaller.marshal(obj, writer);
        return writer.toString();
    }

    /**
     * XML向JAVA类转换
     * @param cls
     * @param content
     * @return
     * @throws JAXBException
     */
    public static <T> Object xml2Java(Class<T> cls,String content) throws JAXBException{
        JAXBContext jaxbContext = JAXBContext.newInstance(cls);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return unmarshaller.unmarshal(new StringReader(content));
    }
}
