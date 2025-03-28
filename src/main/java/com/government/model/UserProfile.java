package com.government.model;

import java.util.List;

public class UserProfile {
    private String userId;
    private String name;
    private int age;
    private String gender;
    private String maritalStatus;
    private double annualIncome;
    private String occupation;
    private String educationLevel;
    private String state;
    private String district;
    private boolean isDisabled;
    private boolean belongsToMinority;
    private String areaType; // rural/urban
    private int familySize;
    private List<String> specialConditions;
    private String aadharNumber;
    private String panNumber;
    private String caste;

    // Constructors
    public UserProfile() {}

    // Getters and Setters
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getMaritalStatus() { return maritalStatus; }
    public void setMaritalStatus(String maritalStatus) { this.maritalStatus = maritalStatus; }

    public double getAnnualIncome() { return annualIncome; }
    public void setAnnualIncome(double annualIncome) { this.annualIncome = annualIncome; }

    public String getOccupation() { return occupation; }
    public void setOccupation(String occupation) { this.occupation = occupation; }

    public String getEducationLevel() { return educationLevel; }
    public void setEducationLevel(String educationLevel) { this.educationLevel = educationLevel; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public boolean isDisabled() { return isDisabled; }
    public void setDisabled(boolean disabled) { isDisabled = disabled; }

    public boolean belongsToMinority() { return belongsToMinority; }
    public void setBelongsToMinority(boolean belongsToMinority) { this.belongsToMinority = belongsToMinority; }

    public String getAreaType() { return areaType; }
    public void setAreaType(String areaType) { this.areaType = areaType; }

    public int getFamilySize() { return familySize; }
    public void setFamilySize(int familySize) { this.familySize = familySize; }

    public List<String> getSpecialConditions() { return specialConditions; }
    public void setSpecialConditions(List<String> specialConditions) { this.specialConditions = specialConditions; }

    public String getAadharNumber() { return aadharNumber; }
    public void setAadharNumber(String aadharNumber) { this.aadharNumber = aadharNumber; }

    public String getPanNumber() { return panNumber; }
    public void setPanNumber(String panNumber) { this.panNumber = panNumber; }

    public String getCaste() { return caste; }
    public void setCaste(String caste) { this.caste = caste; }
}
