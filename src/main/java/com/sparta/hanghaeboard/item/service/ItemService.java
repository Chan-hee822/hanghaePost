package com.sparta.hanghaeboard.item.service;

import com.sparta.hanghaeboard.item.dto.request.ItemRequestDto;
import com.sparta.hanghaeboard.item.dto.response.ItemResponseDto;
import com.sparta.hanghaeboard.item.dto.response.ItemSearchResponseDto;
import com.sparta.hanghaeboard.item.entity.Item;
import com.sparta.hanghaeboard.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemResponseDto createPost(ItemRequestDto itemRequestDto) {
        Item item = Item.builder()
                .title(itemRequestDto.getTitle())
                .content(itemRequestDto.getContent())
                .price(itemRequestDto.getPrice())
                .username(itemRequestDto.getUsername())
                .build();

        return ItemResponseDto.from(itemRepository.save(item));
    }

    public List<ItemSearchResponseDto> searchPosts() {
        return itemRepository.findAll().stream().map(ItemSearchResponseDto::from).toList();
    }

    @Transactional
    public Long updatePost(Long postId, ItemRequestDto itemRequestDto) {
        Item item = getItem(postId);

        item.updateFields(itemRequestDto);

        return item.getId();
    }

    public Long deletePost(Long postId) {
        Item item = getItem(postId);

        itemRepository.delete(item);

        return item.getId();
    }

    private Item getItem(Long postId) {
        return itemRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("선택한 게시글은 존재하지 않습니다."));
    }
}
