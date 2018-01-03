package it.univaq.disim.se.masaccio.data;

public enum UserProfileType {
    USER("USER"),
    RESPONDER("RESPONDER"),
    EMPLOYEE("EMPLOYEE"),
    ADMIN("ADMIN");

    String userProfileType;

    private UserProfileType(String userProfileType){
        this.userProfileType = userProfileType;
    }

    public String getUserProfileType(){
        return userProfileType;
    }

}
