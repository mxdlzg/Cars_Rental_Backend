package com.mxdlzg.rental.domain.model;

import com.mxdlzg.rental.domain.entity.RtCustomerEntity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrderDetail extends BaseDaoResult {
    private int current;
    private Timestamp operateDate;
    private List<UserInfo> userInfo;
    private Location startLocation, endLocation;

    public OrderDetail(int current, Timestamp operateDate) {
        this.current = current;
        this.operateDate = operateDate;
    }

    public void setUserInfo(List<RtCustomerEntity> list) {
        this.userInfo = new ArrayList<>();
        for (RtCustomerEntity customerEntity : list) {
            userInfo.add(new UserInfo(customerEntity.getName(),
                    customerEntity.getCardId(),
                    customerEntity.getMobile(),
                    customerEntity.getEmail()));
        }
    }

    public void setStartLocation(int id, String name, String location, String description, Timestamp date) {
        this.startLocation = new Location(id, name, location, description, date);
    }

    public void setEndLocation(int id, String name, String location, String description, Timestamp date) {
        this.endLocation = new Location(id, name, location, description, date);
    }

    public void setEndLocation() {
        this.endLocation = startLocation;
    }

    public int getCurrent() {
        return current;
    }

    public Timestamp getOperateDate() {
        return operateDate;
    }

    public List<UserInfo> getUserInfo() {
        return userInfo;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }
}

class UserInfo {
    private String name, cardId, phoneNum, email;

    public UserInfo(String name, String cardId, String phoneNum, String email) {
        this.name = name;
        this.cardId = cardId;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getCardId() {
        return cardId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getEmail() {
        return email;
    }
}

class Location {
    private String name, location, description;
    private int id;
    private Timestamp date;

    public Location(int id, String name, String location, String description, Timestamp date) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.id = id;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public Timestamp getDate() {
        return date;
    }
}
