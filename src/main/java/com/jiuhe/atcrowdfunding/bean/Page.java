package com.jiuhe.atcrowdfunding.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Page<T> {

    public static final Page EMPTY = null;

//    private Integer offset;
//    private Integer limit;

    private int total;
    private List<T> rows;

}
