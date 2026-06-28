
#  SecureAuth Auditor - Authentication Security Audit Tool

SecureAuth Auditor is a Java Swing desktop application that performs a rule-based security audit of authentication settings. It evaluates password strength, multi-factor authentication (MFA), password policies, login restrictions, and account lockout settings against common security best practices to generate a comprehensive security assessment.

---

##  Features

- User-friendly Java Swing interface
- Password strength analysis
- Multi-Factor Authentication (MFA) evaluation
- Password expiry policy assessment
- Login attempt limit verification
- Account lockout policy validation
- Security score calculation (0–100)
- Risk level classification
- Detailed audit report with recommendations

---

##  Security Checks Performed

The application evaluates the following authentication security controls:

### Password Security
- Minimum password length (12+ characters)
- Uppercase letter check
- Lowercase letter check
- Numeric digit check
- Special character check

### Authentication Policies
- Multi-Factor Authentication (MFA)
- Password expiry period
- Maximum failed login attempts
- Account lockout configuration

---

##  Risk Classification

| Security Score | Risk Level |
|---------------|------------|
| 80 – 100 | LOW |
| 50 – 79 | MEDIUM |
| 0 – 49 | HIGH |

---

##  Technologies Used

- Java
- Java Swing
- Object-Oriented Programming (OOP)
- Eclipse IDE

---

##  Project Structure

```
SecureAuthAudit
│
├── Main.java
├── HomeScreen.java
├── AuditScreen.java
├── AuthAnalyzer.java
├── AuditResult.java
└── ResultScreen.java
```

---

##  How to Run

1. Open the project in Eclipse IDE.
2. Run `Main.java`.
3. Click **Start Security Audit**.
4. Enter the authentication details:
   - Username
   - Password
   - Authentication Type
   - Password Expiry (Days)
   - Maximum Login Attempts
   - Account Lockout Status
5. Click **Generate Audit Report**.
6. Review the generated security score, risk level, passed checks, failed checks, and recommendations.

---

##  Screenshots

Include screenshots of:

- Home Screen
- Authentication Audit Form
- Security Audit Report

---

##  Learning Outcomes

This project demonstrates:

- Authentication security best practices
- Password policy evaluation
- Rule-based security assessment
- Java Swing GUI development
- Object-Oriented Programming
- Event-driven programming
- Basic cybersecurity concepts

---

## 🚀 Future Improvements

- Password entropy calculation
- Password breach database integration
- Export audit report to PDF
- Export audit report to TXT
- Password policy customization
- Authentication log analysis
- User account management
- Dark mode interface

---

## 👨‍💻 Author

**Rushikesh Malapati**

Cyber Security Internship Project
