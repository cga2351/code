package com.swmansion.gesturehandler.react;

import android.util.SparseArray;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.swmansion.gesturehandler.b;
import com.swmansion.gesturehandler.c;

public class d
  implements c
{
  private SparseArray<int[]> a = new SparseArray();
  private SparseArray<int[]> b = new SparseArray();

  private int[] a(ReadableMap paramReadableMap, String paramString)
  {
    ReadableArray localReadableArray = paramReadableMap.getArray(paramString);
    int[] arrayOfInt = new int[localReadableArray.size()];
    for (int i = 0; i < arrayOfInt.length; i++)
      arrayOfInt[i] = localReadableArray.getInt(i);
    return arrayOfInt;
  }

  public void a()
  {
    this.a.clear();
    this.b.clear();
  }

  public void a(int paramInt)
  {
    this.a.remove(paramInt);
    this.b.remove(paramInt);
  }

  public void a(b paramb, ReadableMap paramReadableMap)
  {
    paramb.a(this);
    if (paramReadableMap.hasKey("waitFor"))
    {
      int[] arrayOfInt2 = a(paramReadableMap, "waitFor");
      this.a.put(paramb.d(), arrayOfInt2);
    }
    if (paramReadableMap.hasKey("simultaneousHandlers"))
    {
      int[] arrayOfInt1 = a(paramReadableMap, "simultaneousHandlers");
      this.b.put(paramb.d(), arrayOfInt1);
    }
  }

  public boolean a(b paramb1, b paramb2)
  {
    int[] arrayOfInt = (int[])this.a.get(paramb1.d());
    boolean bool = false;
    if (arrayOfInt != null);
    for (int i = 0; ; i++)
    {
      int j = arrayOfInt.length;
      bool = false;
      if (i < j)
      {
        if (arrayOfInt[i] == paramb2.d())
          bool = true;
      }
      else
        return bool;
    }
  }

  public boolean b(b paramb1, b paramb2)
  {
    return false;
  }

  public boolean c(b paramb1, b paramb2)
  {
    int[] arrayOfInt = (int[])this.b.get(paramb1.d());
    boolean bool = false;
    if (arrayOfInt != null);
    for (int i = 0; ; i++)
    {
      int j = arrayOfInt.length;
      bool = false;
      if (i < j)
      {
        if (arrayOfInt[i] == paramb2.d())
          bool = true;
      }
      else
        return bool;
    }
  }

  public boolean d(b paramb1, b paramb2)
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.swmansion.gesturehandler.react.d
 * JD-Core Version:    0.6.2
 */