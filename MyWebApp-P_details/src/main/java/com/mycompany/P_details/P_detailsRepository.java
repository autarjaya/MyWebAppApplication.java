package com.mycompany.P_details;

import org.springframework.data.repository.CrudRepository;

public interface P_detailsRepository extends CrudRepository<P_details,Integer> {
    public Long countById(Integer id);
}
