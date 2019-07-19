package com.facebook.react.devsupport;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import java.util.LinkedList;
import java.util.Queue;

public class ViewHierarchyUtil
{
  public static Pair<View, Integer> getDeepestLeaf(View paramView)
  {
    LinkedList localLinkedList = new LinkedList();
    Pair localPair1 = new Pair(paramView, Integer.valueOf(1));
    localLinkedList.add(localPair1);
    Object localObject = localPair1;
    while (!localLinkedList.isEmpty())
    {
      Pair localPair2 = (Pair)localLinkedList.poll();
      if (((Integer)localPair2.second).intValue() > ((Integer)((Pair)localObject).second).intValue())
        localObject = localPair2;
      if ((localPair2.first instanceof ViewGroup))
      {
        ViewGroup localViewGroup = (ViewGroup)localPair2.first;
        Integer localInteger = Integer.valueOf(1 + ((Integer)localPair2.second).intValue());
        for (int i = 0; i < localViewGroup.getChildCount(); i++)
          localLinkedList.add(new Pair(localViewGroup.getChildAt(i), localInteger));
      }
    }
    return localObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.ViewHierarchyUtil
 * JD-Core Version:    0.6.2
 */