package com.chl.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

/**
 * @description:
 * @author: mqxu
 * @create: 2020-12-18 10:46
 **/
@Data
@AllArgsConstructor
@NonNull
@Builder
public class Teacher {
    private String tId;
    private String tName;
}
