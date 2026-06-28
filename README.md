# Web Application Vulnerability Assessment

## Objective

Perform a vulnerability assessment on a deliberately vulnerable web application using OWASP ZAP.

## Tools Used

* OWASP ZAP
* DVWA (Damn Vulnerable Web Application)
* Kali Linux

## Procedure

1. Installed and configured DVWA.
2. Set DVWA Security Level to **Low**.
3. Accessed the application through the browser.
4. Performed an automated scan using OWASP ZAP.
5. Generated an HTML vulnerability assessment report.

## Results

* High Risk Alerts: 0
* Medium Risk Alerts: 2
* Low Risk Alerts: 4
* Informational Alerts: 3

## Files Included

* `zap_report.html` – OWASP ZAP HTML report
* summary.png

## Conclusion

The assessment demonstrated how OWASP ZAP identifies common web application security issues. The generated report provides detailed findings that can be used to improve application security.
