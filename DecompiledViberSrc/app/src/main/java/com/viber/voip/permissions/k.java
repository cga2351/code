package com.viber.voip.permissions;

import android.util.Pair;
import android.util.SparseIntArray;

public class k
{
  private final SparseIntArray a = new SparseIntArray();

  public int a(int paramInt)
  {
    int i = this.a.get(paramInt, -1);
    if (i == -1)
      throw new IllegalArgumentException("Request code is not found for action = " + paramInt);
    return i;
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.a.put(paramInt1, paramInt2);
  }

  public Pair<Integer, m>[] a()
  {
    int i = this.a.size();
    Pair[] arrayOfPair = new Pair[i];
    for (int j = 0; j < i; j++)
      arrayOfPair[j] = m.a(this.a.valueAt(j));
    return arrayOfPair;
  }

  public Pair<Integer, m>[] a(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    Pair[] arrayOfPair = new Pair[i];
    for (int j = 0; j < i; j++)
      arrayOfPair[j] = m.a(a(paramArrayOfInt[j]));
    return arrayOfPair;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.permissions.k
 * JD-Core Version:    0.6.2
 */