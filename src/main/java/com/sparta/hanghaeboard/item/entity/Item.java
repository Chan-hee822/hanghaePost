package com.sparta.hanghaeboard.item.entity;

import com.sparta.hanghaeboard.item.dto.request.ItemRequestDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private Long id;
    @Column(length = 500)
    private String title;
    private String content;
    @Min(value = 1, message = "Price must be greater than 0")
    private int price;
    @Column(nullable = false)
    private String username;

    public void updateFields(ItemRequestDto itemRequestDto) {
        if (itemRequestDto.getTitle() != null) {
            title = itemRequestDto.getTitle();
        }
        if (itemRequestDto.getContent() != null) {
            content = itemRequestDto.getContent();
        }
        if (itemRequestDto.getPrice() != 0) {
            price = itemRequestDto.getPrice();
        }
        if (itemRequestDto.getUsername() != null) {
            username = itemRequestDto.getUsername();
        }
    }
}
