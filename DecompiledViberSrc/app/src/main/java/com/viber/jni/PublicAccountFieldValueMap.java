package com.viber.jni;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class PublicAccountFieldValueMap
{
  HashMap<Integer, String> map = new HashMap();

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

  String getValue(int paramInt)
  {
    Integer localInteger = Integer.valueOf(paramInt);
    return (String)this.map.get(localInteger);
  }

  public void put(int paramInt, String paramString)
  {
    this.map.put(Integer.valueOf(paramInt), paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.PublicAccountFieldValueMap
 * JD-Core Version:    0.6.2
 */