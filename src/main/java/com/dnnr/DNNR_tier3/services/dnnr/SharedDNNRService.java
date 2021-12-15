package com.dnnr.DNNR_tier3.services.dnnr;

import com.dnnr.DNNR_tier3.dataAccess.dnnr.ISharedDNNRDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Dictionary;

@Component
public class SharedDNNRService implements ISharedDNNRService
{
  @Resource ISharedDNNRDao generalDao;

  @Override public Dictionary<Integer, String> getFoodGroupList()
  {
    return generalDao.getFoodGroupList();
  }

  @Override public Dictionary<Integer, String> getIngredientList()
  {
    return generalDao.getIngredientList();
  }
}
