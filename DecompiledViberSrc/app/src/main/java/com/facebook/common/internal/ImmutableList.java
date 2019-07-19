package com.facebook.common.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableList<E> extends ArrayList<E>
{
  private ImmutableList(int paramInt)
  {
    super(paramInt);
  }

  private ImmutableList(List<E> paramList)
  {
    super(paramList);
  }

  public static <E> ImmutableList<E> copyOf(List<E> paramList)
  {
    return new ImmutableList(paramList);
  }

  public static <E> ImmutableList<E> of(E[] paramArrayOfE)
  {
    ImmutableList localImmutableList = new ImmutableList(paramArrayOfE.length);
    Collections.addAll(localImmutableList, paramArrayOfE);
    return localImmutableList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.internal.ImmutableList
 * JD-Core Version:    0.6.2
 */