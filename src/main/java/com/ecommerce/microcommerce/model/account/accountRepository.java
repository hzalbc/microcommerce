package com.ecommerce.microcommerce.model.account;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface accountRepository extends CrudRepository<account, Integer> {

    public List<account> findByAccountId(Integer id);
    public List<account> findByAccountCode(String cd);
    public List<account> findByAccountDescription(String descr);

}
