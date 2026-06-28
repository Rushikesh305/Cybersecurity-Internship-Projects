package com.secureauth.audit;

public class AuthAnalyzer {

    public static AuditResult analyze(
            String password,
            boolean mfaEnabled,
            int expiryDays,
            int loginAttempts,
            boolean lockoutEnabled) {

        AuditResult result = new AuditResult();

        checkPasswordLength(password, result);
        checkUppercase(password, result);
        checkLowercase(password, result);
        checkNumber(password, result);
        checkSpecialCharacter(password, result);

        checkMFA(mfaEnabled, result);
        checkPasswordExpiry(expiryDays, result);
        checkLoginAttempts(loginAttempts, result);
        checkAccountLockout(lockoutEnabled, result);

        result.calculateRiskLevel();

        return result;
    }

    private static void checkPasswordLength(String password, AuditResult result) {

        if(password.length() >= 12) {

            result.addScore(20);
            result.addPassedCheck("Password length is strong (12+ characters)");

        } else {

            result.addFailedCheck("Password is shorter than 12 characters");
            result.addRecommendation("Use a password with at least 12 characters.");

        }

    }

    private static void checkUppercase(String password, AuditResult result) {

        if(password.matches(".*[A-Z].*")) {

            result.addScore(10);
            result.addPassedCheck("Contains uppercase letter");

        } else {

            result.addFailedCheck("No uppercase letter found");
            result.addRecommendation("Add at least one uppercase letter.");

        }

    }

    private static void checkLowercase(String password, AuditResult result) {

        if(password.matches(".*[a-z].*")) {

            result.addScore(10);
            result.addPassedCheck("Contains lowercase letter");

        } else {

            result.addFailedCheck("No lowercase letter found");
            result.addRecommendation("Add at least one lowercase letter.");

        }

    }

    private static void checkNumber(String password, AuditResult result) {

        if(password.matches(".*\\d.*")) {

            result.addScore(10);
            result.addPassedCheck("Contains numeric digit");

        } else {

            result.addFailedCheck("No number found");
            result.addRecommendation("Include at least one numeric digit.");

        }

    }

    private static void checkSpecialCharacter(String password, AuditResult result) {

        if(password.matches(".*[^a-zA-Z0-9].*")) {

            result.addScore(10);
            result.addPassedCheck("Contains special character");

        } else {

            result.addFailedCheck("No special character found");
            result.addRecommendation("Use at least one special character.");

        }

    }

    private static void checkMFA(boolean enabled, AuditResult result) {

        if(enabled) {

            result.addScore(20);
            result.addPassedCheck("Multi-Factor Authentication enabled");

        } else {

            result.addFailedCheck("Multi-Factor Authentication disabled");
            result.addRecommendation("Enable Multi-Factor Authentication (MFA).");

        }

    }

    private static void checkPasswordExpiry(int days, AuditResult result) {

        if(days <= 90) {

            result.addScore(10);
            result.addPassedCheck("Password expiry policy is acceptable");

        } else {

            result.addFailedCheck("Password expiry period is too long");
            result.addRecommendation("Set password expiry to 90 days or less.");

        }

    }

    private static void checkLoginAttempts(int attempts, AuditResult result) {

        if(attempts <= 5) {

            result.addScore(5);
            result.addPassedCheck("Login attempt limit is secure");

        } else {

            result.addFailedCheck("Too many login attempts allowed");
            result.addRecommendation("Limit failed login attempts to 5 or fewer.");

        }

    }

    private static void checkAccountLockout(boolean enabled, AuditResult result) {

        if(enabled) {

            result.addScore(5);
            result.addPassedCheck("Account lockout is enabled");

        } else {

            result.addFailedCheck("Account lockout is disabled");
            result.addRecommendation("Enable account lockout after repeated failed logins.");

        }

    }

}