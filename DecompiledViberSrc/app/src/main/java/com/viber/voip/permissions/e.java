package com.viber.voip.permissions;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Pair;

public abstract class e extends f
{
  private final Fragment mFragment;

  @SafeVarargs
  public e(Fragment paramFragment, Pair<Integer, m>[] paramArrayOfPair)
  {
    super(null, paramArrayOfPair);
    this.mFragment = paramFragment;
  }

  protected Context getContext()
  {
    return this.mFragment.getActivity();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.permissions.e
 * JD-Core Version:    0.6.2
 */