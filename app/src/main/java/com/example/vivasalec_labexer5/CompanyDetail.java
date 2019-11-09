package com.example.vivasalec_labexer5;

public class CompanyDetail {
    private int CompanyLogo;
    private String CompName, CompCountry, CompIndustry, CompCeo, CompInfo;

    public CompanyDetail(int CompanyLogo, String CompName, String CompCountry, String CompIndustry, String CompCeo, String CompInfo) {
        this.CompanyLogo = CompanyLogo;
        this.CompName = CompName;
        this.CompCountry = CompCountry;
        this.CompIndustry = CompIndustry;
        this.CompCeo = CompCeo;
        this.CompInfo = CompInfo;
    }

    public int getCompanyLogo() {
        return CompanyLogo;
    }

    public String getCompanyName() {
        return CompName;
    }

    public String getCompanyCountry() {
        return CompCountry;
    }

    public String getCompanyIndustry() {
        return CompIndustry;
    }

    public String getCompanyCeo() {
        return CompCeo;
    }

    public String getCompanyInfo() {
        return CompInfo;
    }
}