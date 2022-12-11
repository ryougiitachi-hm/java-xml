package per.itachi.java.xml.saxon.infra.xml;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

@Slf4j
@Component
public class DefaultSaxonHandler extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        log.info("Started parsing document.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        log.info("Started parsing element, uri={}, localName={}, qName={}.", uri, localName, qName);
        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        log.info("The value of current element is [{}] ", value);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        log.info("Finished parsing element, uri={}, localName={}, qName={}.", uri, localName, qName);
        super.endElement(uri, localName, qName);
    }

    @Override
    public void endDocument() throws SAXException {
        log.info("Finished parsing document.");
    }
}
