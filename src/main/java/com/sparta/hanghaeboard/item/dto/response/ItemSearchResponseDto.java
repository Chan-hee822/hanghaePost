package com.sparta.hanghaeboard.item.dto.response;

import com.sparta.hanghaeboard.item.entity.Item;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemSearchResponseDto {
    private Long id;
    private String title;
    private int price;
    private String username;

    public static ItemSearchResponseDto from(Item item) {
        return ItemSearchResponseDto.builder()
                .id(item.getId())
                .title(item.getTitle())
                .price(item.getPrice())
                .username(item.getUsername())
                .build();
    }
}
