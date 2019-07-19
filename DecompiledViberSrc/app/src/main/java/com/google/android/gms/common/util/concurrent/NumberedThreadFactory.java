package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@KeepForSdk
public class NumberedThreadFactory
  implements ThreadFactory
{
  private final int priority;
  private final ThreadFactory zzhp = Executors.defaultThreadFactory();
  private final String zzhq;
  private final AtomicInteger zzhr = new AtomicInteger();

  @KeepForSdk
  public NumberedThreadFactory(String paramString)
  {
    this(paramString, 0);
  }

  private NumberedThreadFactory(String paramString, int paramInt)
  {
    this.zzhq = ((String)Preconditions.checkNotNull(paramString, "Name must not be null"));
    this.priority = 0;
  }

  public Thread newThread(Runnable paramRunnable)
  {
    Thread localThread = this.zzhp.newThread(new zza(paramRunnable, 0));
    String str = this.zzhq;
    int i = this.zzhr.getAndIncrement();
    localThread.setName(13 + String.valueOf(str).length() + str + "[" + i + "]");
    return localThread;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.concurrent.NumberedThreadFactory
 * JD-Core Version:    0.6.2
 */