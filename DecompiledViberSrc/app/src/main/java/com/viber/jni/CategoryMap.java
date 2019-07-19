package com.viber.jni;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CategoryMap
{
  HashMap<String, PublicChatCategory> map = new HashMap();

  public String[] getKeys()
  {
    Set localSet = this.map.keySet();
    String[] arrayOfString = new String[localSet.size()];
    Iterator localIterator = localSet.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      String str = (String)localIterator.next();
      j = i + 1;
      arrayOfString[i] = str;
    }
    return arrayOfString;
  }

  public PublicChatCategory getValue(String paramString)
  {
    return (PublicChatCategory)this.map.get(paramString);
  }

  void put(String paramString, PublicChatCategory paramPublicChatCategory)
  {
    this.map.put(paramString, paramPublicChatCategory);
  }

  public String toString()
  {
    Iterator localIterator = this.map.keySet().iterator();
    String str2;
    for (String str1 = "CategoryMap{"; localIterator.hasNext(); str1 = str1 + "key:" + str2 + " val: " + this.map.get(str2) + "\n")
      str2 = (String)localIterator.next();
    return str1 + "]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.CategoryMap
 * JD-Core Version:    0.6.2
 */