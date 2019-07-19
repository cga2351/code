package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;

@KeepForSdk
public class BooleanResult
  implements Result
{
  private final Status mStatus;
  private final boolean zabg;

  @KeepForSdk
  @ShowFirstParty
  public BooleanResult(Status paramStatus, boolean paramBoolean)
  {
    this.mStatus = ((Status)Preconditions.checkNotNull(paramStatus, "Status must not be null"));
    this.zabg = paramBoolean;
  }

  @KeepForSdk
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    BooleanResult localBooleanResult;
    do
    {
      return true;
      if (!(paramObject instanceof BooleanResult))
        return false;
      localBooleanResult = (BooleanResult)paramObject;
    }
    while ((this.mStatus.equals(localBooleanResult.mStatus)) && (this.zabg == localBooleanResult.zabg));
    return false;
  }

  @KeepForSdk
  public Status getStatus()
  {
    return this.mStatus;
  }

  @KeepForSdk
  public boolean getValue()
  {
    return this.zabg;
  }

  @KeepForSdk
  public final int hashCode()
  {
    int i = 31 * (527 + this.mStatus.hashCode());
    if (this.zabg);
    for (int j = 1; ; j = 0)
      return j + i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.BooleanResult
 * JD-Core Version:    0.6.2
 */