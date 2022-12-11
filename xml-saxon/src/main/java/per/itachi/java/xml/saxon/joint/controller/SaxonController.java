package per.itachi.java.xml.saxon.joint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.itachi.java.xml.saxon.app.service.SaxonService;

@RestController
@RequestMapping("/saxon")
public class SaxonController {

    @Autowired
    private SaxonService saxonService;

    @GetMapping("/xml")
    public void showXml() {
        saxonService.showXml();
    }
}
