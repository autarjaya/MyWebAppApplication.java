package com.mycompany.Anamnese;

import org.springframework.data.repository.*;

public interface AnamneseRepository extends CrudRepository<Anamnese,Integer> {
    public Long countById(Integer id);
}

