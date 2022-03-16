package com.mycompany.user;



import javax.persistence.*;

@Entity
@Table(name="users")

public class User {
    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
               // ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", geboorteDatum='" + geboorteDatum + '\'' +
                ", address='" + address + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", Company='" + Company + '\'' +
                ", lastVisited='" + lastVisited + '\'' +
                ", AssuranceNr='" + AssuranceNr + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;




    //@Column(nullable = false, unique = true,length = 45)
    //private String email;

    //@Column(length = 15,nullable = false)
   // private String password;

    @Column(length = 45,nullable = false,name="first_name")
    private String firstName;

    @Column(length = 45,nullable = false,name="last_name")
    private String lastName;

    @Column(length = 45,nullable = false,name="geboortedatum")
    private String geboorteDatum;

    @Column(length = 45,nullable = false,name="address")
    private String address;

    @Column(length = 10,nullable = false,name = "phonenumber")
    private String phonenumber;

    @Column(length = 45,nullable = false,name = "Company")
    private String Company;

    @Column(length = 10,nullable = false,name = "lastVisited")
    private String lastVisited;

   // private boolean enabled;
   @Column(length = 45,nullable = false,name = "AssuranceNr")
   private String AssuranceNr;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //public String getEmail() {
      //  return email;
    //}

    //public void setEmail(String email) {
      //  this.email = email;
    //}


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

   public String getGeboorteDatum(){return geboorteDatum;}

   public void setGeboorteDatum(String geboorteDatum){this.geboorteDatum = geboorteDatum;}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getLastVisited() {
        return lastVisited;
    }

    public void setLastVisited(String lastVisited) {
        this.lastVisited = lastVisited;
    }

    public String getAssuranceNr() {
        return AssuranceNr;
    }

    public void setAssuranceNr(String assuranceNr) {
        AssuranceNr = assuranceNr;
    }
}
