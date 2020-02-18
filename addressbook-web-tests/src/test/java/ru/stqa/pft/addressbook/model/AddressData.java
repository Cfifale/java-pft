package ru.stqa.pft.addressbook.model;

public class AddressData {
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String address;
    private final String home;
    private final String mobile;
    private final String work;
    private final String email;
    private final String email2;
    private final String email3;
    private final String homepage;

    public AddressData(String firstname, String middlename, String lastname, String nickname, String address, String home, String mobile, String work, String email, String email2, String email3, String homepage) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
        this.work = work;
        this.email = email;
        this.email2 = email2;
        this.email3 = email3;
        this.homepage = homepage;
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
}
