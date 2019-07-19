package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zal;

@KeepForSdk
public final class ListenerHolder<L>
{
  private final zaa zaji;
  private volatile L zajj;
  private final ListenerKey<L> zajk;

  @KeepForSdk
  ListenerHolder(Looper paramLooper, L paramL, String paramString)
  {
    this.zaji = new zaa(paramLooper);
    this.zajj = Preconditions.checkNotNull(paramL, "Listener must not be null");
    this.zajk = new ListenerKey(paramL, Preconditions.checkNotEmpty(paramString));
  }

  @KeepForSdk
  public final void clear()
  {
    this.zajj = null;
  }

  @KeepForSdk
  public final ListenerKey<L> getListenerKey()
  {
    return this.zajk;
  }

  @KeepForSdk
  public final boolean hasListener()
  {
    return this.zajj != null;
  }

  @KeepForSdk
  public final void notifyListener(Notifier<? super L> paramNotifier)
  {
    Preconditions.checkNotNull(paramNotifier, "Notifier must not be null");
    Message localMessage = this.zaji.obtainMessage(1, paramNotifier);
    this.zaji.sendMessage(localMessage);
  }

  @KeepForSdk
  final void notifyListenerInternal(Notifier<? super L> paramNotifier)
  {
    Object localObject = this.zajj;
    if (localObject == null)
    {
      paramNotifier.onNotifyListenerFailed();
      return;
    }
    try
    {
      paramNotifier.notifyListener(localObject);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      paramNotifier.onNotifyListenerFailed();
      throw localRuntimeException;
    }
  }

  @KeepForSdk
  public static final class ListenerKey<L>
  {
    private final L zajj;
    private final String zajm;

    @KeepForSdk
    ListenerKey(L paramL, String paramString)
    {
      this.zajj = paramL;
      this.zajm = paramString;
    }

    public final boolean equals(Object paramObject)
    {
      if (this == paramObject);
      ListenerKey localListenerKey;
      do
      {
        return true;
        if (!(paramObject instanceof ListenerKey))
          return false;
        localListenerKey = (ListenerKey)paramObject;
      }
      while ((this.zajj == localListenerKey.zajj) && (this.zajm.equals(localListenerKey.zajm)));
      return false;
    }

    public final int hashCode()
    {
      return 31 * System.identityHashCode(this.zajj) + this.zajm.hashCode();
    }
  }

  @KeepForSdk
  public static abstract interface Notifier<L>
  {
    @KeepForSdk
    public abstract void notifyListener(L paramL);

    @KeepForSdk
    public abstract void onNotifyListenerFailed();
  }

  private final class zaa extends zal
  {
    public zaa(Looper arg2)
    {
      super();
    }

    public final void handleMessage(Message paramMessage)
    {
      int i = 1;
      if (paramMessage.what == i);
      while (true)
      {
        Preconditions.checkArgument(i);
        ListenerHolder.this.notifyListenerInternal((ListenerHolder.Notifier)paramMessage.obj);
        return;
        int j = 0;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.ListenerHolder
 * JD-Core Version:    0.6.2
 */