package com.oqute.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by karuniko on 09.04.16.
 */
@ToString(includeFieldNames=true)
public class Person {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private Long id;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
