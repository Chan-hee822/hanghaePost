package com.sparta.hanghaeboard.item.controller;

import com.sparta.hanghaeboard.item.dto.request.ItemRequestDto;
import com.sparta.hanghaeboard.item.dto.response.ItemResponseDto;
import com.sparta.hanghaeboard.item.dto.response.ItemSearchResponseDto;
import com.sparta.hanghaeboard.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class ItemController {
    private final ItemService itemService;

    @PostMapping()
    public ItemResponseDto createPost(@RequestBody ItemRequestDto itemRequestDto) {
        return itemService.createPost(itemRequestDto);
    }

    @GetMapping()
    public List<ItemSearchResponseDto> searchPosts() {
        return itemService.searchPosts();
    }

    @PutMapping("/{id}")
    public Long updatePost(
            @PathVariable(value = "id") Long postId,
            @RequestBody ItemRequestDto itemRequestDto
    ) {
        return itemService.updatePost(postId, itemRequestDto);
    }

    @DeleteMapping("/{id}")
    public Long deletePost(
            @PathVariable(value = "id") Long postId
    ) {
        return itemService.deletePost(postId);
    }
}
