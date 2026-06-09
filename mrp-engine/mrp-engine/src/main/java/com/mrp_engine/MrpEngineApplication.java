package com.mrp_engine;

import com.mrp_engine.entity.BomLink;
import com.mrp_engine.entity.InventoryStatus;
import com.mrp_engine.repository.BomRepository;
import com.mrp_engine.repository.InventoryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class MrpEngineApplication {
    private final BomRepository bomRepository;
    private final InventoryRepository inventoryRepository;

    public MrpEngineApplication(BomRepository bomRepository, InventoryRepository inventoryRepository) {
        this.bomRepository = bomRepository;
        this.inventoryRepository = inventoryRepository;
    }

    public Map<String,Integer> explodeBom(
            Long productId,
            Integer quantity){

        Map<String,Integer> result = new HashMap<>();
        calculate(productId,quantity,result);
        return result;
    }
    private void calculate(
            Long itemId,
            Integer requiredQty,
            Map<String,Integer>result){
        List<BomLink> children = bomRepository.findByParentItemId(itemId);
        if (children.isEmpty()){
            InventoryStatus inventoryStatus = inventoryRepository.findByItemId(itemId).orElse(null);

            int stock = inventoryStatus == null ? 0 : inventoryStatus.getOnHandQuantity();
            int netRequired = Math.max(requiredQty - stock,0);
            result.put("Item-" + itemId, netRequired);
            return;
        }
        for(BomLink child : children){
            calculate(child.getChildItem().getId(),
                    requiredQty * child.getQuantityRequired(),
                    result
            );
        }
    }
	public static void main(String[] args) {

        SpringApplication.run(MrpEngineApplication.class, args);
	}

}
