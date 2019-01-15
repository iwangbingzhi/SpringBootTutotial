package com.iwbz.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Data
@Getter
@Setter
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -1L;

    private String username;
    private Integer age;
}
