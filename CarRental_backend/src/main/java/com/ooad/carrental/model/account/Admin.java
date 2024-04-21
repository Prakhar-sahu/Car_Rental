package com.ooad.carrental.model.account;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Admins")
public class Admin extends Account {
    private Date dateJoined;
    @Id
    private String id;
    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    public String getId() {
        return id;
    }
}