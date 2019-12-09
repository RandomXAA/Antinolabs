package com.example.antinolabs;

public class UserListData {

    private String userName;
    private String userAge;
    private String userImage;
    private String userLocation;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public UserListData(String userName, String userAge, String userImage, String userLocation) {
        this.userName = userName;
        this.userAge = userAge;
        this.userImage = userImage;
        this.userLocation = userLocation;
    }
}
