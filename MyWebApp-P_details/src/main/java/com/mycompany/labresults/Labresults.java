package com.mycompany.labresults;

import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.web.servlet.error.*;

import javax.persistence.*;


@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@Entity
@Table(name="Labresults")


public class Labresults {
    public Labresults(){

    }
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id",nullable = false)
    private Integer id;


    @Override
    public String toString() {
        return "Labresults{" +
                "id=" + id +
                ", l_id='" + l_id + '\'' +
                ", naam='" + naam + '\'' +
                ", Date='" + Date + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

    @Column(name = "L_Id",nullable = false)
    private Integer l_id;
    @Column(name = "Date",length = 10,nullable = false)
    private String Date;

    @Column(name = "result",length = 100,nullable = false)
    private String result;




    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    @Column(name = "Naam",nullable = false)
    private String naam;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }



    public Integer getL_id() {
        return l_id;
    }

    public void setL_id(Integer l_id) {
        this.l_id = l_id;
    }


    public String  getResult() {
        return result;
    }

    public void setResult(String result ) {
        this.result = result;
    }
}
