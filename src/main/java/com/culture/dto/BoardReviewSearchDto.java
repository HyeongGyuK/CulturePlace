package com.culture.dto;

import com.culture.constant.CategoryStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class BoardReviewSearchDto {
    private CategoryStatus categoryStatus ;
}
