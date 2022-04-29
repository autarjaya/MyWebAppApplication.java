package com.mycompany.P_details;

import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.web.servlet.error.*;

import javax.persistence.*;

@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@Entity
@Table(name="Patient_Details")


public class P_details {
    public P_details(){

    }
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   //@Column(name = "Id",nullable = false)
    private Integer id;

    @Override
    public String toString() {
        return "P_details{" +
                "id=" + id +
                ", p_id='" + p_id + '\'' +
                ", naam='" + naam + '\'' +
                ", Date='" + Date + '\'' +
                ", sickness='" + sickness + '\'' +
                ", medicine='" + medicine + '\'' +
                '}';
    }

    @Column(name = "P_Id",nullable = false)
    private Integer p_id;
    @Column(name = "Date",length = 10,nullable = false)
    private String Date;

    @Column(name="Sickness",length = 50,nullable =false)
    private String sickness;

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    @Column(name = "Medicine",nullable = false)
    private String medicine;




    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    @Column(name = "Naam")
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

    public String getSickness() {
        return sickness;
    }

    public void setSickness(String sickness) {
        this.sickness = sickness;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }
}
