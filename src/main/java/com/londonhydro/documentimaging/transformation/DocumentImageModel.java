package com.londonhydro.documentimaging.transformation;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:document.properties")
@ConfigurationProperties(prefix = "letter")



public class DocumentImageModel {



    public static String subject;
    public static String documentType;
    public static String fourthParagraph;
    //@Value("${letter.thirdParagraph}")
    public static String thirdParagraph;
    public static String secondParagraph;
    public static String serviceType;
    //@Value("${letter.addressOne}")
    public static String addressOne;
    //@Value("${letter.fullNames}")
    public static String fullNames;
    //@Value("${letter.firstParagraph}")
    public static String firstParagraph;
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }


    public  String getAddressOne() {return addressOne;}

    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }


    public  String  getFullNames() {return fullNames;
    }

    public void setFullNames(String fullNames) {
        this.fullNames = fullNames;
    }


    public String getFirstParagraph() {
        return firstParagraph;
    }

    public void setFirstParagraph(String firstParagraph) {
        this.firstParagraph = firstParagraph;
    }

    public String getSecondParagraph() {
        return secondParagraph;
    }

    public void setSecondParagraph(String secondParagraph) {
        this.secondParagraph = secondParagraph;
    }

    public String getSubject() { return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getThirdParagraph() {
        return thirdParagraph;
    }

    public void setThirdParagraph(String thirdParagraph) {
        this.thirdParagraph = thirdParagraph;
    }

    public String getFourthParagraph() {
        return fourthParagraph;
    }

    public void setFourthParagraph(String fourthParagraph) {
        this.fourthParagraph = fourthParagraph;
    }


    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }


}
