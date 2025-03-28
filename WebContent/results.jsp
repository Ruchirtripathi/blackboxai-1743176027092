<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Eligible Schemes</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1><i class="fas fa-check-circle"></i> Eligible Government Schemes</h1>
        
        <div class="user-summary">
            <h2><i class="fas fa-user"></i> Your Profile Summary</h2>
            <div class="profile-details">
                <p><strong>Name:</strong> ${user.name}</p>
                <p><strong>Age:</strong> ${user.age}</p>
                <p><strong>Gender:</strong> ${user.gender}</p>
                <p><strong>Annual Income:</strong> ₹${user.annualIncome}</p>
                <p><strong>Occupation:</strong> ${user.occupation}</p>
                <p><strong>Location:</strong> ${user.district}, ${user.state}</p>
            </div>
        </div>

        <div class="schemes-container">
            <c:choose>
                <c:when test="${not empty schemes}">
                    <c:forEach items="${schemes}" var="scheme">
                        <div class="scheme-card">
                            <div class="scheme-header">
                                <h3>${scheme.name}</h3>
                                <span class="scheme-category">${scheme.category}</span>
                            </div>
                            <div class="scheme-body">
                                <p class="scheme-description">${scheme.description}</p>
                                <div class="scheme-details">
                                    <h4><i class="fas fa-gift"></i> Benefits:</h4>
                                    <ul>
                                        <c:forEach items="${scheme.benefits}" var="benefit">
                                            <li>${benefit}</li>
                                        </c:forEach>
                                    </ul>
                                    
                                    <h4><i class="fas fa-file-alt"></i> Required Documents:</h4>
                                    <ul>
                                        <c:forEach items="${scheme.requiredDocuments}" var="doc">
                                            <li>${doc}</li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                            <div class="scheme-footer">
                                <div class="contact-info">
                                    <p><i class="fas fa-phone"></i> ${scheme.contactInfo}</p>
                                    <p><i class="fas fa-globe"></i> <a href="${scheme.websiteUrl}" target="_blank">Official Website</a></p>
                                </div>
                                <div class="department">
                                    <p><i class="fas fa-building"></i> ${scheme.ministry}</p>
                                    <p><i class="fas fa-map-marker-alt"></i> ${scheme.department}</p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <div class="no-schemes">
                        <i class="fas fa-info-circle"></i>
                        <p>No eligible schemes found based on your profile.</p>
                        <p>Please check back later or contact your local government office.</p>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>

        <a href="index.html" class="back-btn">
            <i class="fas fa-arrow-left"></i> Back to Form
        </a>
    </div>
</body>
</html>