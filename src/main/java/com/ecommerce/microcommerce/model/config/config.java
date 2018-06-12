package com.ecommerce.microcommerce.model.config;

public class config {
    Integer rowBeginIndex, rowEndIndex;

    public config(Integer rowBeginIndex, Integer rowEndIndex) {
        this.rowBeginIndex = rowBeginIndex;
        this.rowEndIndex = rowEndIndex;
    }

    public Integer getRowBeginIndex() {
        return rowBeginIndex;
    }

    public void setRowBeginIndex(Integer rowBeginIndex) {
        this.rowBeginIndex = rowBeginIndex;
    }

    public Integer getRowEndIndex() {
        return rowEndIndex;
    }

    public void setRowEndIndex(Integer rowEndIndex) {
        this.rowEndIndex = rowEndIndex;
    }
}
