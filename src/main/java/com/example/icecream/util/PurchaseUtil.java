package com.example.icecream.util;

import com.example.icecream.dto.CustomerDTO;
import com.example.icecream.dto.FlavorDTO;
import com.example.icecream.dto.PurchaseDTO;
import com.example.icecream.dto.PurchaseItemDTO;
import com.example.icecream.model.Purchase;

import java.util.List;
import java.util.stream.Collectors;

public class PurchaseUtil {

    public static List<PurchaseDTO> getPurchaseDTOList(List<Purchase> purchases) {
        List<PurchaseDTO> purchaseDTOs = purchases.stream()
                .map(purchase -> {
                    List<PurchaseItemDTO> purchaseItems = purchase.getPurchaseItems().stream()
                            .map(purchaseItem -> new PurchaseItemDTO(
                                    purchaseItem.getId(),
                                    purchaseItem.getCreatedAt(),
                                    new FlavorDTO(purchaseItem.getFlavor().getId(), purchaseItem.getFlavor().getFlavorName(),purchaseItem.getFlavor().getStatus(), purchaseItem.getFlavor().getDescription()),
                                    purchaseItem.getQuantity(),
                                    purchaseItem.getUnitPrice()))
                            .collect(Collectors.toList());

                    return new PurchaseDTO(
                            purchase.getId(),
                            purchase.getCreatedAt(),
                            purchase.getTotalPrice(),
                            new CustomerDTO(purchase.getCustomer().getId(), purchase.getCustomer().getName(), purchase.getCustomer().getEmail(), purchase.getCustomer().getPhoneNumber()),
                            purchaseItems
                    );
                })
                .collect(Collectors.toList());

        return purchaseDTOs;
    }

    public static PurchaseDTO getPurchaseDTO(Purchase purchase) {
        List<PurchaseItemDTO> purchaseItems = purchase.getPurchaseItems().stream()
                .map(purchaseItem -> new PurchaseItemDTO(
                        purchaseItem.getId(),
                        purchaseItem.getCreatedAt(),
                        new FlavorDTO(purchaseItem.getFlavor().getId(), purchaseItem.getFlavor().getFlavorName(),purchaseItem.getFlavor().getStatus(), purchaseItem.getFlavor().getDescription()),
                        purchaseItem.getQuantity(),
                        purchaseItem.getUnitPrice()))
                .collect(Collectors.toList());

        PurchaseDTO purchaseDTO = new PurchaseDTO(
                purchase.getId(),
                purchase.getCreatedAt(),
                purchase.getTotalPrice(),
                new CustomerDTO(purchase.getCustomer().getId(), purchase.getCustomer().getName(), purchase.getCustomer().getEmail(), purchase.getCustomer().getPhoneNumber()),
                purchaseItems
        );

        return purchaseDTO;
    }

}
