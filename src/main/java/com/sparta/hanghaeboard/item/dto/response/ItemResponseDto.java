package com.sparta.hanghaeboard.item.dto.response;

import com.sparta.hanghaeboard.item.entity.Item;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemResponseDto {
    private Long id;
    private String title;
    private String content;
    private int price;
    private String username;

    public static ItemResponseDto from(Item item) {
        return ItemResponseDto.builder()
                .id(item.getId())
                .title(item.getTitle())
                .content(item.getContent())
                .price(item.getPrice())
                .username(item.getUsername())
                .build();
    }
}
