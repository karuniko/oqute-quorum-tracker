package com.oqute.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * Created by karuniko on 09.04.16.
 */
@ToString(includeFieldNames=true)
@Entity
public class Person {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    @Id
    private Long id;
    @Getter
    @Setter
    private String pass;
}
