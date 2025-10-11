package com.qa.studyMate.api.pojos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter @JsonIgnoreProperties(ignoreUnknown = true)
public class PJ_GetStudents {

    private List<Student> objects;
    private int count;

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Student {
        private int studentId;
        private String fullName;
        private String groupName;
        private String studyFormat;
        private String phoneNumber;
        private String email;
        private boolean isBlocked;
    }

}
