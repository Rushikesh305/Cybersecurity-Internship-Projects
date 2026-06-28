#  PhishGuard - Rule-Based Email Phishing Analyzer

PhishGuard is a Java Swing desktop application that analyzes email content for potential phishing attacks using rule-based detection techniques. The application evaluates common phishing indicators, calculates a risk score, and provides a detailed security report with recommendations.

---

##  Features

- Analyze custom email content
- Load a sample phishing email for demonstration
- Rule-based phishing detection
- Risk score calculation (0–100)
- Threat level classification
- Detailed analysis report
- Security recommendations
- User-friendly Java Swing interface

---

##  Detection Rules

The application checks emails for several common phishing indicators:

- Fake or impersonated domains
- Urgent or threatening language
- Credential requests (Password, OTP, PIN, etc.)
- Generic greetings (Dear Customer, Dear User)
- Suspicious links (HTTP, Bit.ly, TinyURL)

Each detected indicator contributes to the overall phishing risk score.

---

## Threat Levels

| Risk Score | Threat Level |
|------------|--------------|
| 0 – 24 | SAFE |
| 25 – 49 | LOW |
| 50 – 74 | MEDIUM |
| 75 – 100 | HIGH |

---

##  Technologies Used

- Java
- Java Swing
- Object-Oriented Programming (OOP)
- Eclipse IDE

---

##  Project Structure

```
PhishGuard
│
├── Main.java
├── HomeScreen.java
├── AnalyzerScreen.java
├── EmailAnalyzer.java
├── AnalysisResult.java
└── ResultScreen.java
```

---

##  How to Run

1. Open the project in Eclipse IDE.
2. Run `Main.java`.
3. Choose one of the following:
   - Load Sample Email
   - Analyze My Email
4. Click **Analyze Email**.
5. View the generated phishing analysis report.

---

##  Screenshots

Add screenshots of the following:

- Home Screen
- Email Analyzer Screen
- Analysis Report Screen

---

##  Learning Outcomes

This project helped in understanding:

- Phishing attack indicators
- Rule-based security analysis
- Java Swing GUI development
- Object-Oriented Programming concepts
- Event-driven programming
- Basic cybersecurity principles

---

##  Future Improvements

- Email header analysis
- Attachment scanning
- URL reputation checking
- Machine learning-based phishing detection
- PDF report generation
- Email file (.eml) support

---

Cyber Security Internship Project
