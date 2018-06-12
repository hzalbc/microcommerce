package com.ecommerce.microcommerce.model.kpi;

import com.ecommerce.microcommerce.model.account.account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface kpialphaRepository extends CrudRepository<kpialpha, Integer> {

    public List<kpialpha> findByKpiId(Integer id);


/*
    List<kpialpha> getAllKpis();

    void addKpi(kpialpha k);
*/
}
