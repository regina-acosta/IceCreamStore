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
                                    new FlavorDTO(purchaseItem.getFlavor().getId(), purchaseItem.getFlavor().getFlavorName(),purchaseItem.getFlavor().getStatus(), purchaseItem.getFlavor().getUnitPrice(), purchaseItem.getFlavor().getDescription()),
                                    purchaseItem.getQuantity()
                                    ))
                            .collect(Collectors.toList());

                    return new PurchaseDTO(
                            purchase.getId(),
                            purchase.getCreatedAt(),
                            purchase.getTotalPrice(),
                            purchase.getCustomer().getId(),                            purchaseItems
                    );
                })
                .collect(Collectors.toList());

        return purchaseDTOs;
    }

    public static PurchaseDTO getPurchaseDTO(Purchase purchase) {
        List<PurchaseItemDTO> purchaseItems = purchase.getPurchaseItems().stream()
                .map(purchaseItem -> new PurchaseItemDTO(
                        purchaseItem.getId(),
                        new FlavorDTO(purchaseItem.getFlavor().getId(), purchaseItem.getFlavor().getFlavorName(),purchaseItem.getFlavor().getStatus(), purchaseItem.getFlavor().getUnitPrice(),purchaseItem.getFlavor().getDescription()),
                        purchaseItem.getQuantity()))
                .collect(Collectors.toList());

        PurchaseDTO purchaseDTO = new PurchaseDTO(
                purchase.getId(),
                purchase.getCreatedAt(),
                purchase.getTotalPrice(),
                purchase.getCustomer().getId(),
                purchaseItems
        );

        return purchaseDTO;
    }

}
