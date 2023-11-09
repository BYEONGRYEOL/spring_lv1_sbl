package com.main.sbl_spring_lv1.dto.common;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public abstract class TimeStampDto {
    @Schema(description = "생성 날짜-시각")
    protected LocalDateTime createdAt;
    @Schema(description = "수정 날짜-시각")
    protected LocalDateTime modifiedAt;
}
