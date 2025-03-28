package com.government;

import com.government.model.Scheme;
import com.government.model.UserProfile;
import com.government.service.EligibilityCalculator;
import com.government.service.SchemeDataService;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class SchemeFinderServlet extends HttpServlet {
    private SchemeDataService schemeDataService;
    private EligibilityCalculator eligibilityCalculator;

    @Override
    public void init() throws ServletException {
        super.init();
        schemeDataService = new SchemeDataService();
        eligibilityCalculator = new EligibilityCalculator(schemeDataService);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Create user profile from form data
            UserProfile user = createUserProfile(request);

            // Get eligible schemes
            List<Scheme> eligibleSchemes = eligibilityCalculator.checkEligibility(user);

            // Set attributes for JSP
            request.setAttribute("schemes", eligibleSchemes);
            request.setAttribute("user", user);

            // Forward to results page
            request.getRequestDispatcher("results.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Invalid input: " + e.getMessage());
            request.getRequestDispatcher("index.html").forward(request, response);
        }
    }

    private UserProfile createUserProfile(HttpServletRequest request) {
        UserProfile user = new UserProfile();
        user.setName(request.getParameter("name"));
        user.setAge(Integer.parseInt(request.getParameter("age")));
        user.setGender(request.getParameter("gender"));
        user.setMaritalStatus(request.getParameter("maritalStatus"));
        user.setAnnualIncome(Double.parseDouble(request.getParameter("income")));
        user.setOccupation(request.getParameter("occupation"));
        user.setEducationLevel(request.getParameter("education"));
        user.setState(request.getParameter("state"));
        user.setDistrict(request.getParameter("district"));
        user.setDisabled(Boolean.parseBoolean(request.getParameter("isDisabled")));
        user.setBelongsToMinority(Boolean.parseBoolean(request.getParameter("isMinority")));
        user.setAreaType(request.getParameter("areaType"));
        user.setFamilySize(Integer.parseInt(request.getParameter("familySize")));
        
        // Handle special conditions (comma-separated)
        String specialConditions = request.getParameter("specialConditions");
        if (specialConditions != null && !specialConditions.isEmpty()) {
            user.setSpecialConditions(Arrays.asList(specialConditions.split(",")));
        }

        return user;
    }
}
