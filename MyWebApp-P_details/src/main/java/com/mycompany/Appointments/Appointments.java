package com.mycompany.Appointments;


import javax.persistence.*;

@Entity
@Table(name="Appointments")
public class Appointments {
    public Appointments(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "P_Id",nullable = false)
    private Integer p_id;

    @Column(name = "Date",length = 10,nullable = false)
    private String Date;

    @Column(name = "Time",length = 10,nullable = false)
    private String Time;


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

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    @Override
    public String toString() {
        return "Appointments{" +
                "id=" + id +
                ", p_id=" + p_id +
                ", Date='" + Date + '\'' +
                ", Time='" + Time + '\'' +
                '}';
    }
}
