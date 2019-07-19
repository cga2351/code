package com.yandex.metrica.impl.ob;

import android.util.SparseArray;

public class kh
{
  private static SparseArray<String> a;

  static
  {
    SparseArray localSparseArray = new SparseArray();
    a = localSparseArray;
    localSparseArray.put(0, "String");
    a.put(1, "Number");
    a.put(2, "Counter");
  }

  static String a(int paramInt)
  {
    return (String)a.get(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.kh
 * JD-Core Version:    0.6.2
 */