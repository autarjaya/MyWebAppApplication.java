package com.mycompany.Anamnese;

import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.web.servlet.error.*;

import javax.persistence.*;





@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@Entity
@Table(name="Anamnese")


public class Anamnese {
    public Anamnese() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "Id",nullable = false)
    private Integer id;


    @Override
    public String toString() {
        return "Anamnese{" +
                "id=" + id +
                ", p_id='" + p_id + '\'' +
                ", lengte='" + lengte + '\'' +
                ", gewicht='" + gewicht + '\'' +
                ", bmi='" + BMI + '\'' +
                ", aandoening='" + aandoening + '\'' +
                ", erfelijke_ziekten='" + erfelijke_ziekten + '\'' +
                '}';
    }

    @Column(name = "P_Id", nullable = false)
    private Integer p_id;

    @Column(name = "lengte", length = 10, nullable = false)
    private String lengte;

    @Column(name = "gewicht", length = 100, nullable = false)
    private String gewicht;

    @Column(name = "BMI", length = 100, nullable = false)
    private String BMI;

    @Column(name = "aandoening", length = 100, nullable = false)
    private String aandoening;

    @Column(name = "erfelijke_ziekten", length = 100, nullable = false)
    private String erfelijke_ziekten;


    public String getLengte() {
        return lengte;
    }

    public void setLengte(String lengte) {
        this.lengte = lengte;
    }

    public String getGewicht() {
        return gewicht;
    }

    public void setGewicht(String gewicht) {
        this.gewicht = gewicht;
    }

    public String getErfelijke_ziekten() {
        return erfelijke_ziekten;
    }

    public void setErfelijke_ziekten(String erfelijke_ziekten) {
        this.erfelijke_ziekten = erfelijke_ziekten;
    }

    public String getBMI() {
        return BMI;
    }

    public void setBMI(String BMI) {
        this.BMI = BMI;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }



    public String getAandoening() {
        return aandoening;
    }

    public void setAandoening(String aandoening) {
        this.aandoening = aandoening;
    }

}



