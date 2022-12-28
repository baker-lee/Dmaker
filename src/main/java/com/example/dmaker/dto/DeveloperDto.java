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
public class DeveloperDto {
    private DeveloperLevel developerLevel;
    private DeveloperSkillType developerSkillType;
    private String memberId;

    public static DeveloperDto fromEntity(Developers developers){
        return DeveloperDto.builder()
                .developerLevel(developers.getDeveloperLevel())
                .developerSkillType(developers.getDeveloperSkillType())
                .memberId(developers.getMemberId())
                .build();
    }
}
