package com.ani.logging.lombok;

import lombok.*;

import java.time.LocalDate;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Device {
    private Long dvId;
    private String mfg;
    private LocalDate mfgDt;
}
