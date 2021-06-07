package com.ani.logging.lombok;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DataService {

    public void publishData() {
        log.info("data published");
    }
}
