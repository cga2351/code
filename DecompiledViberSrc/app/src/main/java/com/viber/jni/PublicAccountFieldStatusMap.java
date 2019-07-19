package com.viber.jni;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class PublicAccountFieldStatusMap
{
  HashMap<Integer, Integer> map = new HashMap();

  int[] getKeys()
  {
    Set localSet = this.map.keySet();
    int[] arrayOfInt = new int[localSet.size()];
    Iterator localIterator = localSet.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      Integer localInteger = (Integer)localIterator.next();
      j = i + 1;
      arrayOfInt[i] = localInteger.intValue();
    }
    return arrayOfInt;
  }

  public int getValue(int paramInt)
  {
    Integer localInteger = Integer.valueOf(paramInt);
    if (this.map.containsKey(localInteger))
      return ((Integer)this.map.get(localInteger)).intValue();
    return 0;
  }

  void put(int paramInt1, int paramInt2)
  {
    this.map.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.PublicAccountFieldStatusMap
 * JD-Core Version:    0.6.2
 */