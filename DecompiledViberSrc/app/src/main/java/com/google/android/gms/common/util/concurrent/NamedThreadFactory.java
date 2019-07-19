package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@KeepForSdk
public class NamedThreadFactory
  implements ThreadFactory
{
  private final String name;
  private final int priority;
  private final ThreadFactory zzhp = Executors.defaultThreadFactory();

  @KeepForSdk
  public NamedThreadFactory(String paramString)
  {
    this(paramString, 0);
  }

  private NamedThreadFactory(String paramString, int paramInt)
  {
    this.name = ((String)Preconditions.checkNotNull(paramString, "Name must not be null"));
    this.priority = 0;
  }

  public Thread newThread(Runnable paramRunnable)
  {
    Thread localThread = this.zzhp.newThread(new zza(paramRunnable, 0));
    localThread.setName(this.name);
    return localThread;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.concurrent.NamedThreadFactory
 * JD-Core Version:    0.6.2
 */