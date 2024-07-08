package com.sparta.hanghaeboard.item.dto.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemRequestDto {
    private String title;
    private String content;
    private int price;
    private String username;
}
