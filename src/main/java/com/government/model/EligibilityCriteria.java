package com.government.model;

import java.util.List;

public class EligibilityCriteria {
    private Integer minAge;
    private Integer maxAge;
    private Double minIncome;
    private Double maxIncome;
    private List<String> eligibleGenders;
    private List<String> eligibleOccupations;
    private List<String> eligibleStates;
    private List<String> specialConditions;
    private List<String> eligibleCastes;
    private Boolean forDisabled;
    private Boolean forMinorities;
    private Boolean forRuralAreas;
    private Boolean forUrbanAreas;
    private String educationRequirement;
    private Integer familySizeLimit;

    // Constructors
    public EligibilityCriteria() {}

    // Getters and Setters
    public Integer getMinAge() { return minAge; }
    public void setMinAge(Integer minAge) { this.minAge = minAge; }

    public Integer getMaxAge() { return maxAge; }
    public void setMaxAge(Integer maxAge) { this.maxAge = maxAge; }

    public Double getMinIncome() { return minIncome; }
    public void setMinIncome(Double minIncome) { this.minIncome = minIncome; }

    public Double getMaxIncome() { return maxIncome; }
    public void setMaxIncome(Double maxIncome) { this.maxIncome = maxIncome; }

    public List<String> getEligibleGenders() { return eligibleGenders; }
    public void setEligibleGenders(List<String> eligibleGenders) { this.eligibleGenders = eligibleGenders; }

    public List<String> getEligibleOccupations() { return eligibleOccupations; }
    public void setEligibleOccupations(List<String> eligibleOccupations) { this.eligibleOccupations = eligibleOccupations; }

    public List<String> getEligibleStates() { return eligibleStates; }
    public void setEligibleStates(List<String> eligibleStates) { this.eligibleStates = eligibleStates; }

    public List<String> getSpecialConditions() { return specialConditions; }
    public void setSpecialConditions(List<String> specialConditions) { this.specialConditions = specialConditions; }

    public Boolean getForDisabled() { return forDisabled; }
    public void setForDisabled(Boolean forDisabled) { this.forDisabled = forDisabled; }

    public Boolean getForMinorities() { return forMinorities; }
    public void setForMinorities(Boolean forMinorities) { this.forMinorities = forMinorities; }

    public Boolean getForRuralAreas() { return forRuralAreas; }
    public void setForRuralAreas(Boolean forRuralAreas) { this.forRuralAreas = forRuralAreas; }

    public Boolean getForUrbanAreas() { return forUrbanAreas; }
    public void setForUrbanAreas(Boolean forUrbanAreas) { this.forUrbanAreas = forUrbanAreas; }

    public String getEducationRequirement() { return educationRequirement; }
    public void setEducationRequirement(String educationRequirement) { this.educationRequirement = educationRequirement; }

    public Integer getFamilySizeLimit() { return familySizeLimit; }
    public void setFamilySizeLimit(Integer familySizeLimit) { this.familySizeLimit = familySizeLimit; }

    public List<String> getEligibleCastes() { return eligibleCastes; }
    public void setEligibleCastes(List<String> eligibleCastes) { this.eligibleCastes = eligibleCastes; }
}
