package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.PlatformVersion;

public abstract class zab
{
  private final int type;

  public zab(int paramInt)
  {
    this.type = paramInt;
  }

  private static Status zaa(RemoteException paramRemoteException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((PlatformVersion.isAtLeastIceCreamSandwichMR1()) && ((paramRemoteException instanceof TransactionTooLargeException)))
      localStringBuilder.append("TransactionTooLargeException: ");
    localStringBuilder.append(paramRemoteException.getLocalizedMessage());
    return new Status(8, localStringBuilder.toString());
  }

  public abstract void zaa(Status paramStatus);

  public abstract void zaa(GoogleApiManager.zaa<?> paramzaa)
    throws DeadObjectException;

  public abstract void zaa(zaab paramzaab, boolean paramBoolean);

  public abstract void zaa(RuntimeException paramRuntimeException);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zab
 * JD-Core Version:    0.6.2
 */