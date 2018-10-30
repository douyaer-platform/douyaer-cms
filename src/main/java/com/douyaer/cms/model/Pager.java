package com.douyaer.cms.model;

import lombok.Data;
import java.util.List;

@Data
public class Pager {
    public List<?> list;
    public int total;
    public int page;
}