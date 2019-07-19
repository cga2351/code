package com.viber.voip.model.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class v extends d
{
  public v(String paramString1, String paramString2, String paramString3)
  {
    this.o = paramString3;
    this.h = new d.a((TreeSet)null);
    this.i = new TreeSet();
    this.j = new TreeMap();
    this.k = new HashSet();
    this.h.a(new x(paramString1, paramString2, ""));
    this.i.add(paramString2);
    this.j.put(paramString2, new k(paramString2, paramString2, paramString2, "", ""));
    this.k.add(paramString2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.entity.v
 * JD-Core Version:    0.6.2
 */