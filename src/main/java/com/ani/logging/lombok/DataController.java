package com.ani.logging.lombok;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/data")
public class DataController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/read")
    public String read() {
        logger.info("Reading Data");
        return "reading data";
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Device hello( @RequestBody Device dv ) {

        //repo.save(s)
        return  dv;
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
