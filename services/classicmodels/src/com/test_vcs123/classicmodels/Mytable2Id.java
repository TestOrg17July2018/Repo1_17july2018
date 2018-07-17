/*Copyright (c) 2018-2019 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.test_vcs123.classicmodels;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

public class Mytable2Id implements Serializable {

    private Integer id;
    private Integer col1;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCol1() {
        return this.col1;
    }

    public void setCol1(Integer col1) {
        this.col1 = col1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mytable2)) return false;
        final Mytable2 mytable2 = (Mytable2) o;
        return Objects.equals(getId(), mytable2.getId()) &&
                Objects.equals(getCol1(), mytable2.getCol1());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getCol1());
    }
}