package com.example.dmaker.dto;


import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor //필수 argument만 생성자 (final, nonnull 등)
public class DevDto {
    @NonNull
    String name;
    @NonNull
    Integer age;
    LocalDateTime startAt;

}
