package com.dnnr.DNNR_tier3.services.group;

import com.dnnr.DNNR_tier3.dataAccess.groupDao.IGroupDao;
import com.dnnr.DNNR_tier3.models.CustomPair;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class GroupService implements IGroupService
{
  @Resource IGroupDao Dao;



  @Override public List<CustomPair> getShuffledRecipes()
  {
    return Dao.getShuffledRecipes();
  }

  @Override public List<CustomPair> getShuffledRestaurants()
  {
    return Dao.getShuffledRestaurants();
  }
}
