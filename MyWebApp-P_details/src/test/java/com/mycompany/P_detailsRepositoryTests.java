package com.mycompany;


import com.mycompany.P_details.P_details;
import com.mycompany.P_details.P_detailsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

public class P_detailsRepositoryTests {
    @Autowired private P_detailsRepository repo2;


    @Test
    public void testAddNew(){
        P_details p_details=new P_details();
        p_details.setId(12);
        p_details.setDate("28-5-2020");
        p_details.setSickness("Hoesten");

        P_details savedP_details= repo2.save(p_details);
        Assertions.assertThat(savedP_details).isNotNull();
        Assertions.assertThat(savedP_details.getId()).isGreaterThan(0);
    }
    @Test
    public void testListAll(){
        Iterable<P_details> p_detail=repo2.findAll();
        Assertions.assertThat(p_detail).hasSizeGreaterThan(0);

        for(P_details p_details : p_detail ){
            System.out.println(p_details);
        }
    }
    @Test
            public void testUpdate(){
    Integer p_detailsId=0;
    Optional<P_details> optionalP_details =repo2.findById(p_detailsId);
    P_details p_details=optionalP_details.get();
    p_details.setSickness("");
    p_details.setDate("");
   // p_details.setId();

    P_details updatedP_details=repo2.findById(p_detailsId).get();
    Assertions.assertThat(updatedP_details.getSickness()).isEqualTo("");
    Assertions.assertThat(updatedP_details.getDate()).isEqualTo("");
}

@Test
    public void testGet(){
        Integer p_detailsId=0;
    Optional<P_details> optionalP_details =repo2.findById(p_detailsId);
    P_details p_details=optionalP_details.get();

    Assertions.assertThat(optionalP_details).isPresent();
    System.out.println(optionalP_details.get());
}

@Test
public void testDelete(){
    Integer p_detailsId=9;
    repo2.deleteById(p_detailsId);
    Optional<P_details> optionalP_details = repo2.findById(p_detailsId);
    Assertions.assertThat(optionalP_details).isNotPresent();
}


}
