package com.phishing.simulator;

public class EmailAnalyzer {

    public static AnalysisResult analyze(String email) {

        AnalysisResult result = new AnalysisResult();

        String text = email.toLowerCase();

        checkUrgency(text, result);
        checkCredentials(text, result);
        checkGreeting(text, result);
        checkLinks(text, result);
        checkFakeDomains(text, result);

        if (result.getRiskScore() > 100) {
            result.addScore(-(result.getRiskScore() - 100));
        }

        result.calculateThreatLevel();

        return result;
    }

    private static void checkUrgency(String text, AnalysisResult result) {

        String[] words = {
                "urgent",
                "immediately",
                "verify",
                "suspended",
                "24 hours",
                "click here"
        };

        for (String word : words) {

            if (text.contains(word)) {

                result.addScore(20);
                result.addIndicator("Urgent language detected");
                break;

            }

        }

    }

    private static void checkCredentials(String text, AnalysisResult result) {

        String[] words = {
                "password",
                "otp",
                "credit card",
                "pin",
                "login"
        };

        for (String word : words) {

            if (text.contains(word)) {

                result.addScore(25);
                result.addIndicator("Credential request detected");
                break;

            }

        }

    }

    private static void checkGreeting(String text, AnalysisResult result) {

        if (text.contains("dear customer")
                || text.contains("dear user")
                || text.contains("dear client")) {

            result.addScore(10);
            result.addIndicator("Generic greeting");

        }

    }

    private static void checkLinks(String text, AnalysisResult result) {

        if (text.contains("http://")
                || text.contains("https://")
                || text.contains("bit.ly")
                || text.contains("tinyurl")) {

            result.addScore(20);
            result.addIndicator("Suspicious link detected");

        }

    }

    private static void checkFakeDomains(String text, AnalysisResult result) {

        String[] domains = {
                "amaz0n",
                "micr0soft",
                "paypai",
                "g00gle"
        };

        for (String domain : domains) {

            if (text.contains(domain)) {

                result.addScore(30);
                result.addIndicator("Fake domain detected");
                break;

            }

        }

    }

}