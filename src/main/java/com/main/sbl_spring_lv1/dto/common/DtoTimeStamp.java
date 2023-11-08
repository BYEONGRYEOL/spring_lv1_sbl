package com.main.sbl_spring_lv1.dto.common;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public abstract class DtoTimeStamp {
    protected LocalDateTime createdAt;
    protected LocalDateTime modifiedAt;
}
