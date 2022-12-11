package per.itachi.java.xml.saxon.infra.xml.config;

import javax.xml.parsers.SAXParserFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaxonConfig {

    @Bean
    public SAXParserFactory saxParserFactory() {
        return SAXParserFactory.newInstance();
    }

}
