package com.example.dmaker.dto;

import com.example.dmaker.entity.Developers;
import com.example.dmaker.type.DeveloperLevel;
import com.example.dmaker.type.DeveloperSkillType;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class CreateDeveloper {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    public static class Request{
        @NotNull
        private DeveloperLevel developerLevel;
        @NotNull
        private DeveloperSkillType developerSkillType;
        @NotNull
        @Min(0)
        @Max(20)
        private Integer experienceYears;

        @NotNull
        @Size(min = 3, max = 50, message = "memberId size must 3 to 50")
        private String memberId;
        @NotNull
        @Size(min = 3, max = 20, message = "name size must 3 to 20")
        private String name;

        @Min(18)
        private Integer age;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response{
        private DeveloperLevel developerLevel;
        private DeveloperSkillType developerSkillType;
        private Integer experienceYears;
        private Integer age;

        private String memberId;

        public static Response fromEntity(Developers developers){
            return Response.builder()
                    .developerLevel(developers.getDeveloperLevel())
                    .developerSkillType(developers.getDeveloperSkillType())
                    .experienceYears(developers.getExperienceYears())
                    .memberId(developers.getMemberId())
                    .age(developers.getAge())
                    .build();
        }
    }
}
