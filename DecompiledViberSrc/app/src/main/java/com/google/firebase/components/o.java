package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Arrays;
import java.util.List;

@KeepForSdk
public class o extends p
{
  private final List<b<?>> a;

  @KeepForSdk
  public o(List<b<?>> paramList)
  {
    super("Dependency cycle detected: " + Arrays.toString(paramList.toArray()));
    this.a = paramList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.components.o
 * JD-Core Version:    0.6.2
 */