package com.viber.voip.user.more.repository;

import com.viber.voip.settings.a.a;
import com.viber.voip.user.more.listitems.creators.PreferenceItemCreator;
import com.viber.voip.util.ci;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MoreListItemRepository
{
  private final List<PreferenceItemCreator> mItemCreators;
  private List<a> mItems;
  private final MoreListItemsSortOrder mOrder;

  public MoreListItemRepository(List<PreferenceItemCreator> paramList, MoreListItemsSortOrder paramMoreListItemsSortOrder)
  {
    this.mItemCreators = paramList;
    this.mOrder = paramMoreListItemsSortOrder;
  }

  public List<a> obtainFilteredListItems(ci<a> paramci)
  {
    List localList = obtainListItems();
    ArrayList localArrayList = new ArrayList(localList.size());
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramci.apply(locala))
        localArrayList.add(locala);
    }
    return localArrayList;
  }

  public List<a> obtainListItems()
  {
    if (this.mItems == null)
    {
      this.mItems = new ArrayList(this.mItemCreators.size());
      int i = this.mItemCreators.size();
      for (int j = 0; j < i; j++)
      {
        PreferenceItemCreator localPreferenceItemCreator = (PreferenceItemCreator)this.mItemCreators.get(j);
        if (localPreferenceItemCreator != null)
          this.mItems.add(localPreferenceItemCreator.create());
      }
      Collections.sort(this.mItems, this.mOrder.getComparator());
    }
    return this.mItems;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.repository.MoreListItemRepository
 * JD-Core Version:    0.6.2
 */