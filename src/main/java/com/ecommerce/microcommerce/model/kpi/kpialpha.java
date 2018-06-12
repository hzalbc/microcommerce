package com.ecommerce.microcommerce.model.kpi;

import com.ecommerce.microcommerce.model.account.account;
import com.ecommerce.microcommerce.model.dim.dim;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "kpialpha")
    public class kpialpha {

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Integer kpiId;


        @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
        @JoinColumn()

        private dim kpiDim1;

        private Integer kpiDim2Id;
        private Integer kpiDim3Id;
        private Integer kpiDim4Id;
        private Integer kpiDim5Id;
        private Integer kpiReportId;
        private Integer kpiDeptId;
        //private String kpi_date_modif;
        //private String kpi_date_ajout;
        private Integer kpiActif; //tinyint(4) NOT NULL DEFAULT '1',
        private Integer kpiOrder;

        @ManyToOne(/*fetch = FetchType.LAZY, */cascade = {CascadeType.ALL})
        @JoinColumn(name = "accountId")
        private account kpiAccount;

    public kpialpha(){

    }

    public kpialpha(dim kpiDim1, Integer kpiDim2Id, Integer kpiDim3Id, Integer kpiDim4Id, Integer kpiDim5Id, Integer kpiReportId, Integer kpiDeptId, Integer kpiActif, Integer kpiOrder, account kpiAcc) {
        this.kpiDim1 = kpiDim1;
        this.kpiDim1.setDimType(kpiDim1.getDimType());
        this.kpiDim1.setDimCode(kpiDim1.getDimCode());
        this.kpiDim1.setDimDescription(kpiDim1.getDimDescription());


        this.kpiDim2Id = kpiDim2Id;
        this.kpiDim3Id = kpiDim3Id;
        this.kpiDim4Id = kpiDim4Id;
        this.kpiDim5Id = kpiDim5Id;
        this.kpiReportId = kpiReportId;
        this.kpiDeptId = kpiDeptId;
        this.kpiActif = kpiActif;
        this.kpiOrder = kpiOrder;
        //this.kpiAccount = kpiAccount;
        this.kpiAccount = kpiAcc;
        this.kpiAccount.setAccountCode(kpiAcc.getAccountCode());
        this.kpiAccount.setAccountDescription(kpiAcc.getAccountDescription());
    }

    public Integer getKpiId() {
        return kpiId;
    }

    public void setKpiId(Integer kpiId) {
        this.kpiId = kpiId;
    }

    public dim getKpiDim1() {
        return kpiDim1;
    }

    @Override
    public String toString() {
        return "kpialpha{" +
                "kpiId=" + kpiId +
                ", kpiDim2Id=" + kpiDim2Id +
                ", kpiDim3Id=" + kpiDim3Id +
                ", kpiDim4Id=" + kpiDim4Id +
                ", kpiDim5Id=" + kpiDim5Id +
                ", kpiReportId=" + kpiReportId +
                ", kpiDeptId=" + kpiDeptId +
                ", kpiActif=" + kpiActif +
                ", kpiOrder=" + kpiOrder +
                '}';
    }

    public void setKpiDim1(dim kpiDim1) {
        this.kpiDim1 = kpiDim1;
    }

    public Integer getKpiDim2Id() {
        return kpiDim2Id;
    }

    public void setKpiDim2Id(Integer kpiDim2Id) {
        this.kpiDim2Id = kpiDim2Id;
    }

    public Integer getKpiDim3Id() {
        return kpiDim3Id;
    }

    public void setKpiDim3Id(Integer kpiDim3Id) {
        this.kpiDim3Id = kpiDim3Id;
    }

    public Integer getKpiDim4Id() {
        return kpiDim4Id;
    }

    public void setKpiDim4Id(Integer kpiDim4Id) {
        this.kpiDim4Id = kpiDim4Id;
    }

    public Integer getKpiDim5Id() {
        return kpiDim5Id;
    }

    public void setKpiDim5Id(Integer kpiDim5Id) {
        this.kpiDim5Id = kpiDim5Id;
    }

    public Integer getKpiReportId() {
        return kpiReportId;
    }

    public void setKpiReportId(Integer kpiReportId) {
        this.kpiReportId = kpiReportId;
    }

    public Integer getKpiDeptId() {
        return kpiDeptId;
    }

    public void setKpiDeptId(Integer kpiDeptId) {
        this.kpiDeptId = kpiDeptId;
    }

    public Integer getKpiActif() {
        return kpiActif;
    }

    public void setKpiActif(Integer kpiActif) {
        this.kpiActif = kpiActif;
    }

    public Integer getKpiOrder() {
        return kpiOrder;
    }

    public void setKpiOrder(Integer kpiOrder) {
        this.kpiOrder = kpiOrder;
    }

    public account getKpiAccount() {
        return kpiAccount;
    }

    public void setKpiAccount(account kpiAccount) {
        this.kpiAccount = kpiAccount;
    }
/*
    public account getKpiAccount() {
        return kpiAccount;
    }

    public void setKpiAccount(account kpiAccount) {
        this.kpiAccount = kpiAccount;
    }
*/
        /*
        @OneToOne()
        @JoinColumn(name="dim_id")
        private dimension1 dim;
        */
        /*
        @OneToOne()
        @JoinColumn(name="log_id")
        private changelog chlog;

        @OneToOne()
        @JoinColumn(name="rep_id")
        private report rep;
        */


}
