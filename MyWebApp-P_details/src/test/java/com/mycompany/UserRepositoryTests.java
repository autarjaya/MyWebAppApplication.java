package com.mycompany;


import com.mycompany.user.User;
import com.mycompany.user.UserRepository;
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

public class UserRepositoryTests {
    @Autowired private UserRepository repo;

    @Test
    public void testAddNew(){
        User user=new User();
      //  Date date=new Date();
        //user.setEmail("alex.steven@gmail.com");
        user.setAddress("Plutostraat 5");
        user.setCompany("none");
        user.setLastVisited("21-3-2021");
        user.setPhonenumber("115");
        //user.setPassword("alex123456");
        user.setAssuranceNr("M456");
        user.setFirstName("Alex");
        user.setLastName("Steven");
     //   date.setDate("21-5-2021");
      //  date.setIssues("hoofdpijn");


       User savedUser= repo.save(user);
       //Date savedDate= repo.save(date);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);

    }
    @Test
    public void testListAll(){
        Iterable<User> users = repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for(User user :users){
            System.out.println(user);
        }
    }
    @Test
    public void testUpdate(){
        Integer userId=1;
        Optional<User> optionalUser = repo.findById(userId);
        User user=optionalUser.get();
       // user.setPassword("hello1000");
        user.setAddress("Wanicastraat 74");
        user.setCompany("SZF");
        user.setPhonenumber("8885577");
        user.setLastVisited("22-4-2021");
        user.setAssuranceNr("M1234");
        repo.save(user);

        User updatedUser =repo.findById(userId).get();
       // Assertions.assertThat(updatedUser.getPassword()).isEqualTo("hello1000");
        Assertions.assertThat(updatedUser.getAddress()).isEqualTo("Wanicastraat 74");
        Assertions.assertThat(updatedUser.getCompany()).isEqualTo("SZF");
        Assertions.assertThat(updatedUser.getPhonenumber()).isEqualTo("8885577");
        Assertions.assertThat(updatedUser.getLastVisited()).isEqualTo("22-4-2021");
        Assertions.assertThat(updatedUser.getAssuranceNr()).isEqualTo("M1234");
    }
    @Test
    public void testGet(){
        Integer userId=2;
        Optional<User> optionalUser = repo.findById(userId);
        User user=optionalUser.get();

        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());
    }
    @Test
    public void testDelete(){
        Integer userId=8;
        repo.deleteById(userId);
        Optional<User> optionalUser = repo.findById(userId);
        Assertions.assertThat(optionalUser).isNotPresent();
    }

}
