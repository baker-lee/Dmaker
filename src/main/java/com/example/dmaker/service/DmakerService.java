package com.example.dmaker.service;

import com.example.dmaker.dto.CreateDeveloper;
import com.example.dmaker.entity.Developers;
import com.example.dmaker.exception.DMakerErrorCode;
import com.example.dmaker.exception.DMakerException;
import com.example.dmaker.repository.DeveloperRepository;
import com.example.dmaker.type.DeveloperLevel;
import com.example.dmaker.type.DeveloperSkillType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.Optional;

import static com.example.dmaker.exception.DMakerErrorCode.DUPLICATED_MEMBER_ID;
import static com.example.dmaker.exception.DMakerErrorCode.LEVEL_EXPERIENCE_YEARS_NOT_MATCHED;

@Service
@RequiredArgsConstructor
@Transactional
public class DmakerService {
    private final DeveloperRepository developerRepository;
    private final EntityManager em;

    @Transactional
    public void createDeveloper(CreateDeveloper.Request request) {
        Developers developers = Developers.builder()
                .developerLevel(DeveloperLevel.JUNIOR)
                .developerSkillType(DeveloperSkillType.FRONT_END)
                .experienceYears(2)
                .name("Olaf")
                .age(5)
                .build();

        developerRepository.save(developers);
    }

    private void validateCreatDeveloperRequest(CreateDeveloper.Request request) {
        DeveloperLevel developerLevel = request.getDeveloperLevel();
        Integer experienceYears = request.getExperienceYears();
        if (developerLevel == DeveloperLevel.SENIOR
                && experienceYears < 10) {
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }

        if (developerLevel == DeveloperLevel.JUNGNIOR
                && (experienceYears < 4 || experienceYears > 10)) {
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }

        if (developerLevel == DeveloperLevel.JUNGNIOR && experienceYears > 4) {
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }

        Optional<Developers> developer = developerRepository.findByMemberId(request.getMemberId());
        if (developer.isPresent())
            throw new DMakerException((DUPLICATED_MEMBER_ID));
    }
}
