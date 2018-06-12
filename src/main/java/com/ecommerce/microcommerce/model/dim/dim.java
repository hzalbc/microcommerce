package com.ecommerce.microcommerce.model.dim;

import javax.persistence.*;

@Entity
@Table(name = "dim")
public class dim {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer dimId;

    public String dimType;
    public String dimCode;
    public String dimDescription;

    public dim(){

    }

    public dim(String dimType, String dimCode, String dimDescription) {
        this.dimType = dimType;
        this.dimCode = dimCode;
        this.dimDescription = dimDescription;
    }

    public Integer getDimId() {
        return dimId;
    }

    public void setDimId(Integer dimId) {
        this.dimId = dimId;
    }

    public String getDimType() {
        return dimType;
    }

    public void setDimType(String dimType) {
        this.dimType = dimType;
    }

    public String getDimCode() {
        return dimCode;
    }

    public void setDimCode(String dimCode) {
        this.dimCode = dimCode;
    }

    public String getDimDescription() {
        return dimDescription;
    }

    public void setDimDescription(String dimDescription) {
        this.dimDescription = dimDescription;
    }
}
