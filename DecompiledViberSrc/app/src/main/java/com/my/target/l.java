package com.my.target;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class l
{
  private final ArrayList<p> a = new ArrayList();

  public abstract int a();

  public ArrayList<p> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      p localp = (p)localIterator.next();
      if (paramString.equals(localp.c()))
        localArrayList.add(localp);
    }
    return localArrayList;
  }

  public void a(ArrayList<p> paramArrayList)
  {
    this.a.addAll(paramArrayList);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.l
 * JD-Core Version:    0.6.2
 */