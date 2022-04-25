package com.chl.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

/**
 * @description:
 * @author: mqxu
 * @create: 2020-12-18 10:47
 **/
@Data
@AllArgsConstructor
@NonNull
@Builder
public class Student {
    private String sId;
    private String sName;
}
