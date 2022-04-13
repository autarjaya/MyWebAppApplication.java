package com.mycompany.labresults;

import org.springframework.data.repository.CrudRepository;

public interface LabresultsRepository extends CrudRepository<Labresults,Integer> {
    public Long countById(Integer id);
}

