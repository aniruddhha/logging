package com.ani.logging.lombok;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/data")
public class DataController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/read")
    public String read() {
        logger.info("Reading Data");
        return "reading data";
    }

    @GetMapping("/start/{sts}")
    public String start(@PathVariable boolean sts) {
        if(sts) {
            logger.debug("Started");
            return  "started";
        }else {
            RuntimeException ex = new RuntimeException("Data Locked");
            logger.error("Locked", ex);
            throw ex;
        }
    }
}
