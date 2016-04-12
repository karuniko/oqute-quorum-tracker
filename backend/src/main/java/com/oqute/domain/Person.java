package com.oqute.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
