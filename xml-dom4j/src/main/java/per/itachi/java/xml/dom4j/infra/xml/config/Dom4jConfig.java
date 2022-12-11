package per.itachi.java.xml.dom4j.infra.xml.config;

import java.nio.charset.StandardCharsets;
import org.dom4j.io.OutputFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Dom4jConfig {

    @Bean
    public OutputFormat outputFormat() {
        OutputFormat outputFormat = new OutputFormat();
        outputFormat.setNewlines(false); // false by default.
        // Either of these 2 indents is set to get effective.
        outputFormat.setIndent(false); // false by default.
        outputFormat.setIndent("\t"); // none by default. can be any valid character even a word such as "false".
        // There will be a blank line at the top if both newlines and this value are true.
        // false by default.
        outputFormat.setSuppressDeclaration(false);// false by default. XML header won't be output if true.
        outputFormat.setEncoding(StandardCharsets.UTF_8.toString()); // follow the system by default, such as UTF-8
        return outputFormat;
    }

}
