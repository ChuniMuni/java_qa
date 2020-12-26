package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String firstname;
    private final String midllename;
    private final String lastname;
    private final String nick;
    private final String title;
    private final String company;
    private final String address;
    private final String tel1;
    private final String tel2;
    private final String tel3;
    private final String tel4;
    private final String email1;
    private final String email2;
    private final String email3;
    private final String url;
    private final String address2;
    private final String phone2;
    private final String notes;

    public ContactData(String firstname, String midllename, String lastname, String nick, String title, String company, String address, String tel1, String tel2, String tel3, String tel4, String email1, String email2, String email3, String url, String address2, String phone2, String notes) {
        this.firstname = firstname;
        this.midllename = midllename;
        this.lastname = lastname;
        this.nick = nick;
        this.title = title;
        this.company = company;
        this.address = address;
        this.tel1 = tel1;
        this.tel2 = tel2;
        this.tel3 = tel3;
        this.tel4 = tel4;
        this.email1 = email1;
        this.email2 = email2;
        this.email3 = email3;
        this.url = url;
        this.address2 = address2;
        this.phone2 = phone2;
        this.notes = notes;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMidllename() {
        return midllename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNick() {
        return nick;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getTel1() {
        return tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public String getTel3() {
        return tel3;
    }

    public String getTel4() {
        return tel4;
    }

    public String getEmail1() {
        return email1;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getUrl() {
        return url;
    }

    public String getAddress2() {
        return address2;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getNotes() {
        return notes;
    }
}
