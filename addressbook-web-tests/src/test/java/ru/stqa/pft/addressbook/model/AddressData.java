package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "addressbook")
public class AddressData {
    @Id
    @Column(name = "id")
    private int id = 0;

    @Expose
    @Column(name = "firstname")
    private String firstname;

    @Expose
    @Column(name = "middlename")
    private String middlename;

    @Expose
    @Column(name = "lastname")
    private String lastname;

    @Expose
    @Column(name = "nickname")
    private String nickname;

    @Expose
    @Column(name = "address")
    @Type(type = "text")
    private String address;

    @Expose
    @Column(name = "home")
    @Type(type = "text")
    private String home;

    @Expose
    @Column(name = "mobile")
    @Type(type = "text")
    private String mobile;

    @Expose
    @Column(name = "work")
    @Type(type = "text")
    private String work;

    @Expose
    @Column(name = "email")
    @Type(type = "text")
    private String email;

    @Expose
    @Column(name = "email2")
    @Type(type = "text")
    private String email2;

    @Expose
    @Column(name = "email3")
    @Type(type = "text")
    private String email3;

    @Expose
    @Column(name = "homepage")
    @Type(type = "text")
    private String homepage;

//    @Expose
//    @Transient
//    private String group;

    @Transient
    private String allPhones;

    @Transient
    private String allEmail;

    @Expose
    @Column(name = "photo")
    @Type(type = "text")
    private String photo;

    @Expose
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "address_in_groups",
            joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupData> groups = new HashSet<GroupData>();

    public File getPhoto() {
        return new File(photo);
    }

    public AddressData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    public String getAllEmail() {
        return allEmail;
    }

    public AddressData withAllEmail(String allEmail) {
        this.allEmail = allEmail;
        return this;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public AddressData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public AddressData withId(int id) {
        this.id = id;
        return this;
    }

    public AddressData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public AddressData withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public AddressData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public AddressData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public AddressData withAddress(String address) {
        this.address = address;
        return this;
    }

    public AddressData withHome(String home) {
        this.home = home;
        return this;
    }

    public AddressData withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public AddressData withWork(String work) {
        this.work = work;
        return this;
    }

    public AddressData withEmail(String email) {
        this.email = email;
        return this;
    }

    public AddressData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public AddressData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public AddressData withHomepage(String homepage) {
        this.homepage = homepage;
        return this;
    }

//    public AddressData withGroup(String group) {
//        this.group = group;
//        return this;
//    }

    public AddressData inGroup(GroupData group) {
        groups.add(group);
        return this;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getAddress() {
        return address;
    }

    public String getHome() {
        return home;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWork() {
        return work;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getHomepage() {
        return homepage;
    }

//    public String getGroup() {
//        return group;
//    }

    public Groups getGroups() {
        return new Groups(groups);
    }

    @Override
    public String toString() {
        return "AddressData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressData that = (AddressData) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (middlename != null ? !middlename.equals(that.middlename) : that.middlename != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (home != null ? !home.equals(that.home) : that.home != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        if (work != null ? !work.equals(that.work) : that.work != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
        if (email3 != null ? !email3.equals(that.email3) : that.email3 != null) return false;
        return homepage != null ? homepage.equals(that.homepage) : that.homepage == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (middlename != null ? middlename.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (home != null ? home.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (work != null ? work.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (email2 != null ? email2.hashCode() : 0);
        result = 31 * result + (email3 != null ? email3.hashCode() : 0);
        result = 31 * result + (homepage != null ? homepage.hashCode() : 0);
        return result;
    }
}
