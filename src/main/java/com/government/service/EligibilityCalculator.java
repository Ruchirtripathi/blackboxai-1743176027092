package com.government.service;

import com.government.model.Scheme;
import com.government.model.UserProfile;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class EligibilityCalculator {
    private final SchemeDataService schemeDataService;

    public EligibilityCalculator(SchemeDataService schemeDataService) {
        this.schemeDataService = schemeDataService;
    }

    public List<Scheme> checkEligibility(UserProfile user) {
        return schemeDataService.getAllSchemes().stream()
            .filter(scheme -> isEligibleForScheme(user, scheme))
            .collect(Collectors.toList());
    }

    private boolean isEligibleForScheme(UserProfile user, Scheme scheme) {
        EligibilityCriteria criteria = scheme.getEligibility();

        // Check age criteria
        if (criteria.getMinAge() != null && user.getAge() < criteria.getMinAge()) {
            return false;
        }
        if (criteria.getMaxAge() != null && user.getAge() > criteria.getMaxAge()) {
            return false;
        }

        // Check income criteria
        if (criteria.getMinIncome() != null && user.getAnnualIncome() < criteria.getMinIncome()) {
            return false;
        }
        if (criteria.getMaxIncome() != null && user.getAnnualIncome() > criteria.getMaxIncome()) {
            return false;
        }

        // Check gender criteria
        if (criteria.getEligibleGenders() != null && 
            !criteria.getEligibleGenders().contains(user.getGender())) {
            return false;
        }

        // Check occupation criteria
        if (criteria.getEligibleOccupations() != null && 
            !criteria.getEligibleOccupations().contains(user.getOccupation())) {
            return false;
        }

        // Check state criteria
        if (criteria.getEligibleStates() != null && 
            !criteria.getEligibleStates().contains(user.getState())) {
            return false;
        }

        // Check disability criteria
        if (criteria.getForDisabled() != null && 
            criteria.getForDisabled() != user.isDisabled()) {
            return false;
        }

        // Check minority criteria
        if (criteria.getForMinorities() != null && 
            criteria.getForMinorities() != user.belongsToMinority()) {
            return false;
        }

        // Check area type criteria
        if (criteria.getForRuralAreas() != null && 
            "urban".equalsIgnoreCase(user.getAreaType()) && criteria.getForRuralAreas()) {
            return false;
        }
        if (criteria.getForUrbanAreas() != null && 
            "rural".equalsIgnoreCase(user.getAreaType()) && criteria.getForUrbanAreas()) {
            return false;
        }

        // Check education criteria
        if (criteria.getEducationRequirement() != null && 
            !meetsEducationRequirement(user.getEducationLevel(), criteria.getEducationRequirement())) {
            return false;
        }

        // Check family size criteria
        if (criteria.getFamilySizeLimit() != null && 
            user.getFamilySize() > criteria.getFamilySizeLimit()) {
            return false;
        }

        // Check special conditions
        if (criteria.getSpecialConditions() != null && 
            !user.getSpecialConditions().containsAll(criteria.getSpecialConditions())) {
            return false;
        }

        // Check caste criteria
        if (criteria.getEligibleCastes() != null && 
            !criteria.getEligibleCastes().contains(user.getCaste())) {
            return false;
        }

        return true;
    }

    private boolean meetsEducationRequirement(String userEducation, String requiredEducation) {
        // Simplified education level comparison
        String[] levels = {"primary", "secondary", "higher secondary", "graduate", "post graduate"};
        int userLevel = -1;
        int requiredLevel = -1;
        
        for (int i = 0; i < levels.length; i++) {
            if (levels[i].equalsIgnoreCase(userEducation)) {
                userLevel = i;
            }
            if (levels[i].equalsIgnoreCase(requiredEducation)) {
                requiredLevel = i;
            }
        }
        
        return userLevel >= requiredLevel;
    }
}