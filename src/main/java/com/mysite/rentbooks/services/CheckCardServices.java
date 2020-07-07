package com.mysite.rentbooks.services;

import com.mysite.rentbooks.models.Client;
import com.mysite.rentbooks.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CheckCardServices implements ICheckCardService {

    @Autowired
    private ClientRepository clientRepository;

    Map<Integer, Integer> discounts = new HashMap<Integer, Integer>();

    public CheckCardServices(){
        discounts.put(10000, 5);
        discounts.put(30000, 10);
        discounts.put(50000, 15);
    }

    @Override
    public int getDiscount(String card) {
        int clientDiscount = 0;
        Client client = clientRepository.findByCard(card);
        if (client != null) {
            for (Map.Entry<Integer, Integer> item : discounts.entrySet()) {
                if (client.getTotalBuyAmount() >= item.getKey() && clientDiscount < item.getValue()) {
                    clientDiscount = item.getValue();
                }
            }
        }
        return clientDiscount;

    }
}
