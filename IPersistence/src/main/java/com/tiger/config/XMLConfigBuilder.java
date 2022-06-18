package com.tiger.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.tiger.bean.Configuration;
import com.tiger.io.Resources;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * @author:zhanglihu
 * @Date:2022/6/18-06-18-20:40
 * @Description:com.tiger.config
 * @Version:1.0
 **/
public class XMLConfigBuilder {
    //该方法就是将配置文件进行解析，封装Configuration的方法
    private Configuration configuration;

    public XMLConfigBuilder() {
        this.configuration = new Configuration();
    }


    public Configuration parseConfig(InputStream inputStream){
        //使用dom4j 对配置文件进行解析
        try {
            Document read = new SAXReader().read(inputStream);
            //<configuration>
            Element rootElement = read.getRootElement();
            List<Element> list = rootElement.selectNodes("//property");
            Properties properties = new Properties();
            for (Element element : list) {
                String name = element.attributeValue("name");
                String value = element.attributeValue("value");
                properties.setProperty(name,value);
            }
            ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
            try {
                comboPooledDataSource.setDriverClass(properties.getProperty("driverClass"));
                comboPooledDataSource.setJdbcUrl(properties.getProperty("jdbcUrl"));
                comboPooledDataSource.setUser(properties.getProperty("username"));
                comboPooledDataSource.setPassword(properties.getProperty("password"));
                configuration.setDataSource(comboPooledDataSource);
                //mapper.xml 解析 拿到路径 根据路径把mapper.xml 加载成字节输入流---通过dom4j 进行解析
                List<Element> mapperList = rootElement.selectNodes("//mapper");
                for (Element element : mapperList) {
                    String mapperPath = element.attributeValue("resource");
                    InputStream resourceAsStream = Resources.getResourceAsStream(mapperPath);
                    //使用dom4j 进行解析
                    XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(configuration);
                    xmlMapperBuilder.parse(resourceAsStream);
                }

            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return configuration;
    }
}
