package com.ecommerce.microcommerce.model.dim;

import com.ecommerce.microcommerce.model.account.account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface dimRepository extends CrudRepository<dim, Integer> {

    public List<dim> findByDimId(Integer id);
    public List<dim> findByDimType(String type);
    public List<dim> findByDimCode(String cd);
    public List<dim> findByDimDescription(String descr);

}
