package per.itachi.java.xml.saxon.app.service.impl;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.annotation.Resource;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import per.itachi.java.xml.saxon.app.service.SaxonService;

@Slf4j
@Service
public class SaxonServiceImpl implements SaxonService {

    @Resource
    private SAXParserFactory saxParserFactory;

    @Resource
    private DefaultHandler defaultHandler;

    @Override
    public void showXml() {
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            Path path = Paths.get("input", "testing.xml");
            path.toFile();
            saxParser.parse(path.toFile(), defaultHandler);
        }
        catch (ParserConfigurationException | SAXException | IOException e) {
            log.error("", e);
        }
    }
}
