package com.liferay.training.customers.bean;

import com.liferay.portal.kernel.util.StringPool;

import java.util.List;
import java.util.StringJoiner;

/**
 * @author luism on 15/05/2020
 * @project training-project
 */
public class Bean {

    private String name;
    private String lastName;
    private List<Bean> hijos;

    public Bean() {
        name = StringPool.BLANK;
        lastName = StringPool.BLANK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Bean> getHijos() {
        return hijos;
    }

    public void setHijos(List<Bean> hijos) {
        this.hijos = hijos;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Bean.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("lastName='" + lastName + "'")
                .add("hijos=" + hijos)
                .toString();
    }
}
