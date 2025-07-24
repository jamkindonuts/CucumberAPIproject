package com.qa.studyMate.api.pojos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PJ_CreateStudent {

    private String name;
    private String lastName;
    private int phoneNumber;
    private String email;
    private int groupId;
    private String studyFormat;
    private String message;


}
