package per.itachi.java.xml.dom4j.infra.xml.dom4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Slf4j
@Component
public class Dom4jXmlProcessor {

    // just example
    private static List<String> xpathToRemove = Arrays.asList(
            "/transaction/trades/trade/attributes/attribute[code='PERSISTENCE']",
            "/transaction/"
    );

    @Autowired
    private OutputFormat outputFormat;

    public void removeNodes(String xmlFile, List<String> xpaths) {
        Document document = null;
        try {
            SAXReader saxReader = new SAXReader();
            document = saxReader.read(new File(xmlFile));
            for (String xpath : xpaths) {
                List<?> listElements = document.selectNodes(xpath);
                if (!CollectionUtils.isEmpty(listElements)) {
                    for (Object object : listElements) {
                        Element element = (Element) object;
//                        element.getParent().remove(element);
                        element.detach(); // with return value
                    }
                }
            }
        }
        catch (DocumentException e) {
            log.error("Error occurred when reading xml from SAXReader. ", e);
        }

        XMLWriter writer = null;
        try {
            writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(xmlFile), StandardCharsets.UTF_8), outputFormat);
        }
        catch (Exception e) {
            log.error("Error occurred when executing XMLWriter", e);
        }
        finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            }
            catch (IOException e) {
                log.error("Error occurred when closing XMLWriter. ", e);
            }
        }
    }
}
