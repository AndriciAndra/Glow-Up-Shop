package org.scrum.domain.services;

import org.scrum.domain.project.Store;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreService {

    private List<Store> storeItems = new ArrayList<>();
    private int saleId = 1;

    public Store sellProduct(Store storeItem) {
        storeItem.setSaleId(saleId++);
        storeItems.add(storeItem);
        return storeItem;
    }

    public List<Store> getAllStoreItems() {
        return storeItems;
    }
}
