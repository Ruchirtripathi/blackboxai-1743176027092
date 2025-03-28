package com.government.service;

import com.government.model.Scheme;
import com.government.model.EligibilityCriteria;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class SchemeDataService {
    private Map<String, Scheme> schemes;
    private Map<String, List<Scheme>> schemesByCategory;

    public SchemeDataService() {
        schemes = new HashMap<>();
        schemesByCategory = new HashMap<>();
        initializeSchemes();
    }

    private void initializeSchemes() {
        // 0. Housing Schemes
        Scheme pmAwasYojana = createHousingScheme(
            "PMAY-001",
            "Pradhan Mantri Awas Yojana",
            "Housing scheme for urban poor",
            Arrays.asList("Interest subsidy", "Financial assistance"),
            Arrays.asList("Aadhar", "Income certificate", "Address proof"),
            "Ministry of Housing",
            "https://pmaymis.gov.in"
        );
        addScheme(pmAwasYojana);

        // 1. Health Schemes
        Scheme pmJanArogya = createHealthScheme(
            "PM-JAN-001",
            "PM Jan Arogya Yojana",
            "Health insurance for poor families",
            Arrays.asList("5 lakh health cover", "Cashless treatment"),
            Arrays.asList("Aadhar", "BPL certificate"),
            "Ministry of Health",
            "https://pmjay.gov.in"
        );
        addScheme(pmJanArogya);

        // 2. Education Schemes
        Scheme pmScholarship = createEducationScheme(
            "PM-SCHOLAR-001",
            "PM Scholarship for Higher Education",
            "Scholarship for higher education students",
            Arrays.asList("Monthly stipend", "Tuition fee waiver"),
            Arrays.asList("Aadhar", "Income certificate", "Mark sheets"),
            "Ministry of Education",
            "https://scholarships.gov.in"
        );
        addScheme(pmScholarship);

        // 2. Health Schemes
        Scheme pmJanArogya = createHealthScheme(
            "PM-JAN-001",
            "PM Jan Arogya Yojana",
            "Health insurance for poor families",
            Arrays.asList("5 lakh health cover", "Cashless treatment"),
            Arrays.asList("Aadhar", "BPL certificate"),
            "Ministry of Health",
            "https://pmjay.gov.in"
        );
        addScheme(pmJanArogya);

        // 3. Agriculture Schemes
        Scheme pmKisan = createAgricultureScheme(
            "PM-KISAN-001",
            "PM Kisan Samman Nidhi",
            "Income support for farmers",
            Arrays.asList("6000/year in 3 installments"),
            Arrays.asList("Aadhar", "Land records"),
            "Ministry of Agriculture",
            "https://pmkisan.gov.in"
        );
        addScheme(pmKisan);

        // 4. Women Welfare Schemes
        Scheme sukanyaSamriddhi = createWomenScheme(
            "SSY-001",
            "Sukanya Samriddhi Yojana",
            "Savings scheme for girl child",
            Arrays.asList("High interest rate", "Tax benefits"),
            Arrays.asList("Birth certificate", "Aadhar"),
            "Ministry of Women and Child",
            "https://ssy.gov.in"
        );
        addScheme(sukanyaSamriddhi);
    }

    private Scheme createEducationScheme(String id, String name, String desc, 
        List<String> benefits, List<String> docs, String dept, String url) {
        
        EligibilityCriteria criteria = new EligibilityCriteria();
        criteria.setMinAge(18);
        criteria.setMaxAge(25);
        criteria.setMaxIncome(250000.0);
        criteria.setEducationRequirement("Higher Secondary");
        
        return new Scheme(id, name, desc, criteria, benefits, docs, dept, 
                        "Education", url, "1800-123-4567");
    }

    private Scheme createHealthScheme(String id, String name, String desc, 
        List<String> benefits, List<String> docs, String dept, String url) {
        
        EligibilityCriteria criteria = new EligibilityCriteria();
        criteria.setMaxIncome(100000.0);
        criteria.setForRuralAreas(true);
        criteria.setFamilySizeLimit(5);
        
        return new Scheme(id, name, desc, criteria, benefits, docs, dept, 
                        "Health", url, "1800-111-2222");
    }

    private Scheme createAgricultureScheme(String id, String name, String desc, 
        List<String> benefits, List<String> docs, String dept, String url) {
        
        EligibilityCriteria criteria = new EligibilityCriteria();
        criteria.setEligibleOccupations(Arrays.asList("farmer", "agricultural laborer"));
        criteria.setForRuralAreas(true);
        
        return new Scheme(id, name, desc, criteria, benefits, docs, dept, 
                        "Agriculture", url, "1800-333-4444");
    }

    private Scheme createHousingScheme(String id, String name, String desc,
        List<String> benefits, List<String> docs, String dept, String url) {
        
        EligibilityCriteria criteria = new EligibilityCriteria();
        criteria.setMaxIncome(300000.0);
        criteria.setEligibleCastes(Arrays.asList("General", "OBC", "SC", "ST"));
        criteria.setForUrbanAreas(true);
        
        return new Scheme(id, name, desc, criteria, benefits, docs, dept,
                        "Housing", url, "1800-777-8888", "Ministry of Housing", url);
    }

    private Scheme createWomenScheme(String id, String name, String desc, 
        List<String> benefits, List<String> docs, String dept, String url) {
        
        EligibilityCriteria criteria = new EligibilityCriteria();
        criteria.setEligibleGenders(Arrays.asList("female"));
        criteria.setMaxAge(10); // For girl child
        criteria.setMinAge(0);
        
        return new Scheme(id, name, desc, criteria, benefits, docs, dept, 
                        "Women Welfare", url, "1800-555-6666", "Ministry of Women and Child", url);
    }

    public void addScheme(Scheme scheme) {
        schemes.put(scheme.getId(), scheme);
        schemesByCategory.computeIfAbsent(scheme.getCategory(), k -> new ArrayList<>()).add(scheme);
    }

    public Scheme getSchemeById(String id) {
        return schemes.get(id);
    }

    public List<Scheme> getSchemesByCategory(String category) {
        return schemesByCategory.getOrDefault(category, new ArrayList<>());
    }

    public List<Scheme> getAllSchemes() {
        return new ArrayList<>(schemes.values());
    }
}