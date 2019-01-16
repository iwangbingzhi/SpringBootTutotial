package com.iwbz.druiddemo.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {
    /**
     * 城市编号
     */
    private Long id;

    /**
     * 城市名称
     */
    private String userName;

    /**
     * 描述
     */
    private String description;

    private City city;
}
