package com.dnnr.DNNR_tier3.controllers.dnnr;

import com.dnnr.DNNR_tier3.services.dnnr.ISharedDNNRService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Dictionary;

@RestController
public class SharedDNNRController implements ISharedDNNRController
{
  @Resource ISharedDNNRService sharedDNNRService;

  @GetMapping(value = "/foodgroups") @Override public Dictionary<Integer, String> getFoodGroupListAsync()
  {
    return sharedDNNRService.getFoodGroupList();
  }

  @GetMapping(value = "/ingredients") @Override public Dictionary<Integer, String> getIngredientListAsync()
  {
    return sharedDNNRService.getIngredientList();
  }

}
