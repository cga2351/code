package com.viber.voip.permissions;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Pair;

public abstract class g extends h
{
  private final Fragment a;

  @SafeVarargs
  public g(Fragment paramFragment, Pair<Integer, m>[] paramArrayOfPair)
  {
    super(null, paramArrayOfPair);
    this.a = paramFragment;
  }

  protected Context getContext()
  {
    return this.a.getContext();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.permissions.g
 * JD-Core Version:    0.6.2
 */