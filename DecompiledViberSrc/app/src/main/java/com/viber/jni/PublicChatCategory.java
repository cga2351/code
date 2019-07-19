package com.viber.jni;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PublicChatCategory
{
  String mName;
  Map<String, String> mSubcategories = new HashMap();

  public PublicChatCategory(String paramString)
  {
    this.mName = paramString;
  }

  public PublicChatCategory(String paramString, Map paramMap)
  {
    this(paramString);
    this.mSubcategories = paramMap;
  }

  public String[] getKeys()
  {
    Set localSet = this.mSubcategories.keySet();
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

  public String getName()
  {
    return this.mName;
  }

  public String getValue(String paramString)
  {
    return (String)this.mSubcategories.get(paramString);
  }

  public void put(String paramString1, String paramString2)
  {
    this.mSubcategories.put(paramString1, paramString2);
  }

  public String toString()
  {
    return "PublicChatCategory{mName='" + this.mName + '\'' + ", mSubcategories=" + this.mSubcategories + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.PublicChatCategory
 * JD-Core Version:    0.6.2
 */