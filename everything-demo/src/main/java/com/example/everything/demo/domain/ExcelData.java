package com.example.everything.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
public class ExcelData implements Serializable {
    private static final long serialVersionUID = 9019080188569255939L;
    private String fileName;
    private String[] head;
    private List<String[]> data;
}
