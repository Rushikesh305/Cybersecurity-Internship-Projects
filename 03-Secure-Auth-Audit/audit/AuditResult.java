package com.secureauth.audit;

import java.util.ArrayList;

public class AuditResult {

    private int score;
    private String riskLevel;

    private ArrayList<String> passedChecks;
    private ArrayList<String> failedChecks;
    private ArrayList<String> recommendations;

    public AuditResult() {

        score = 0;

        passedChecks = new ArrayList<>();
        failedChecks = new ArrayList<>();
        recommendations = new ArrayList<>();

    }

    public void addScore(int points) {
        score += points;
    }

    public int getScore() {
        return score;
    }

    public void addPassedCheck(String check) {
        passedChecks.add(check);
    }

    public void addFailedCheck(String check) {
        failedChecks.add(check);
    }

    public void addRecommendation(String recommendation) {
        recommendations.add(recommendation);
    }

    public ArrayList<String> getPassedChecks() {
        return passedChecks;
    }

    public ArrayList<String> getFailedChecks() {
        return failedChecks;
    }

    public ArrayList<String> getRecommendations() {
        return recommendations;
    }

    public void calculateRiskLevel() {

        if(score >= 80)
            riskLevel = "LOW";

        else if(score >= 50)
            riskLevel = "MEDIUM";

        else
            riskLevel = "HIGH";

    }

    public String getRiskLevel() {
        return riskLevel;
    }

}