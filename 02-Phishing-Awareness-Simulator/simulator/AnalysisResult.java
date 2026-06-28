package com.phishing.simulator;

import java.util.ArrayList;

public class AnalysisResult {

    private int riskScore;
    private String threatLevel;
    private ArrayList<String> indicators;

    public AnalysisResult() {
        riskScore = 0;
        indicators = new ArrayList<>();
    }

    public void addScore(int points) {
        riskScore += points;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public void addIndicator(String indicator) {
        indicators.add(indicator);
    }

    public ArrayList<String> getIndicators() {
        return indicators;
    }

    public void calculateThreatLevel() {

        if (riskScore >= 75)
            threatLevel = "HIGH";
        else if (riskScore >= 50)
            threatLevel = "MEDIUM";
        else if (riskScore >= 25)
            threatLevel = "LOW";
        else
            threatLevel = "SAFE";

    }

    public String getThreatLevel() {
        return threatLevel;
    }

}