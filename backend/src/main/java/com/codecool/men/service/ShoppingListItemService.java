package com.codecool.men.service;

import com.codecool.men.controller.dto.shoppinglist.NewItemDTO;
import com.codecool.men.controller.exceptions.OperationFailedException;
import com.codecool.men.repository.ShoppingListRepository;
import com.codecool.men.repository.model.Note;
import com.codecool.men.repository.model.ShoppingListItem;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingListItemService {
    private final ShoppingListRepository shoppingListRepository;

    public ShoppingListItemService(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

    public List<ShoppingListItem> getAllItems(){
        return shoppingListRepository.findAll();
    }

    public boolean addItem(NewItemDTO newItemDTO){
        ShoppingListItem shoppingListItem = new ShoppingListItem();
        createItem(newItemDTO, shoppingListItem);
        return true;
    }

    private void createItem(NewItemDTO newItemDTO, ShoppingListItem shoppingListItem){
        shoppingListItem.setProductName(newItemDTO.name());
        shoppingListItem.setBought(false);
        shoppingListRepository.save(shoppingListItem);
    }

    public boolean updateItemQuantity(Long itemId, int quantity) {
        Optional<ShoppingListItem> optionalItem = shoppingListRepository.findById(itemId);
        if (optionalItem.isPresent()) {
            ShoppingListItem item = optionalItem.get();
            item.setQuantity(quantity);
            shoppingListRepository.save(item);
            return true;
        }
        return false; // Item with given ID not found
    }

    public boolean updateBought(Long itemId, boolean isBought){
        Optional<ShoppingListItem> listItemOptional = shoppingListRepository.findById(itemId);
        if (listItemOptional.isPresent()) {
            ShoppingListItem item = listItemOptional.get();
            item.setBought(isBought);
            shoppingListRepository.save(item);
            return true;
        }
        return false;
    }

    public boolean deleteItem(long itemId) {
        ShoppingListItem shoppingListItem = shoppingListRepository.findById(itemId).orElse(null);
        if (shoppingListItem != null) {
            shoppingListRepository.delete(shoppingListItem);
            return true;
        }
        throw new OperationFailedException("Note not found!");
    }

}
