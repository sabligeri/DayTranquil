package com.codecool.men.controller;

import com.codecool.men.controller.dto.note.NoteDTO;
import com.codecool.men.controller.dto.shoppinglist.NewItemDTO;
import com.codecool.men.repository.model.ShoppingListItem;
import com.codecool.men.service.ShoppingListItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shopping")
public class ItemController {
    private final ShoppingListItemService listItemService;

    public ItemController(ShoppingListItemService listItemService) {
        this.listItemService = listItemService;
    }
    @GetMapping
    public List<ShoppingListItem> getAllItems() {
        return listItemService.getAllItems();
    }

    @PostMapping
    public boolean addItem(@RequestBody NewItemDTO newItemDTO){
        return listItemService.addItem(newItemDTO);
    }
    @PutMapping("/quantity/{itemId}")
    public boolean updateItemQuantity(@PathVariable("itemId") Long itemId, @RequestParam int quantity) {
        return listItemService.updateItemQuantity(itemId, quantity);
    }
    @PutMapping("/bought/{itemId}")
    public boolean updateBought(@PathVariable("itemId") Long itemId, @RequestParam boolean isbought) {
        return listItemService.updateBought(itemId, isbought);
    }

    @DeleteMapping("/{itemId}")
    public boolean deleteNote( @PathVariable("itemId") Long itemId) {
        return listItemService.deleteItem(itemId);
    }




}
