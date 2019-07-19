package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

@ShowFirstParty
public abstract class zac
{
  private static final Object sLock = new Object();

  @GuardedBy("sLock")
  private static final Map<Object, zac> zacj = new WeakHashMap();

  public abstract void remove(int paramInt);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.zac
 * JD-Core Version:    0.6.2
 */