package masarifyuli.co.id.javaspring.entity.employee;

import masarifyuli.co.id.javaspring.entity.BasicEntity;

import javax.persistence.*;

@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username", name = "_uniqueUsername")
        }
)
public class Employee extends BasicEntity {
    @Column(nullable = false, length = 15)
    private String username;
    @Column(nullable = false, length = 30)
    private String name;
    @Column(nullable = false, length = 255)
    private String password;
    @Column(nullable = false, length = 255)
    private String address;
    @Column(columnDefinition = " CHAR(1) NOT NULL")
    @Convert(converter = GenderConverter.class)
    private Gender gender;

    @Column(length = 30)
    private String email;
    @Column(length = 20)
    private String mobileNo;

    enum Gender {MALE, FEMALE, UNDEFINED}

    public Employee() {
    }

    public Employee(String username, String name, String password, String address, Gender gender) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.address = address;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @PrePersist
    public void beforeSave() {
        System.out.println("Event before save");
    }


}




