package com.example.cangqiong.Service;

import com.example.cangqiong.entity.Shop;
import com.example.cangqiong.repository.ShopRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
    @Autowired
    private ShopRepositroy shopRepositroy;
    public Shop shopfindByphone(Shop shop){return shopRepositroy.findByPhonenumber(shop.getPhonenumber());}
    public void shopsave(Shop shop){shopRepositroy.save(shop);}
    public long shopcount(){return shopRepositroy.count();}
}
