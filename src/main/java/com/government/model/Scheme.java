package com.government.model;

import java.util.List;

public class Scheme {
    private String id;
    private String name;
    private String description;
    private EligibilityCriteria eligibility;
    private List<String> benefits;
    private List<String> requiredDocuments;
    private String department;
    private String category;
    private String websiteUrl;
    private String contactInfo;
    private String ministry;
    private String website;

    // Constructors
    public Scheme() {}
    
    public Scheme(String id, String name, String description, EligibilityCriteria eligibility, 
                 List<String> benefits, List<String> requiredDocuments, String department, 
                 String category, String websiteUrl, String contactInfo, String ministry, String website) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.eligibility = eligibility;
        this.benefits = benefits;
        this.requiredDocuments = requiredDocuments;
        this.department = department;
        this.category = category;
        this.websiteUrl = websiteUrl;
        this.contactInfo = contactInfo;
        this.ministry = ministry;
        this.website = website;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public EligibilityCriteria getEligibility() { return eligibility; }
    public void setEligibility(EligibilityCriteria eligibility) { this.eligibility = eligibility; }
    
    public List<String> getBenefits() { return benefits; }
    public void setBenefits(List<String> benefits) { this.benefits = benefits; }
    
    public List<String> getRequiredDocuments() { return requiredDocuments; }
    public void setRequiredDocuments(List<String> requiredDocuments) { this.requiredDocuments = requiredDocuments; }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    
    public String getWebsiteUrl() { return websiteUrl; }
    public void setWebsiteUrl(String websiteUrl) { this.websiteUrl = websiteUrl; }
    
    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }

    public String getMinistry() { return ministry; }
    public void setMinistry(String ministry) { this.ministry = ministry; }

    public String getWebsite() { return website; }
    public void setWebsite(String website) { this.website = website; }
}
