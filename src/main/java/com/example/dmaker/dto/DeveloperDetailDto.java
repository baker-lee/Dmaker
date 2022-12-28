package com.example.dmaker.dto;

import com.example.dmaker.entity.Developers;
import com.example.dmaker.type.DeveloperLevel;
import com.example.dmaker.type.DeveloperSkillType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeveloperDetailDto {

    private DeveloperLevel developerLevel;
    private DeveloperSkillType developerSkillType;
    private Integer experienceYears;
    private String memberId;
    private String name;
    private Integer age;

    public static DeveloperDetailDto fromEntity(Developers developers){
        return DeveloperDetailDto.builder()
                .developerLevel(developers.getDeveloperLevel())
                .developerSkillType(developers.getDeveloperSkillType())
                .experienceYears(developers.getExperienceYears())
                .memberId(developers.getMemberId())
                .name(developers.getName())
                .age(developers.getAge())
                .build();
    }

}
