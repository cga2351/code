package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@SafeParcelable.Class(creator="ResolveAccountResponseCreator")
public class ResolveAccountResponse extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new zan();

  @SafeParcelable.Field(getter="getConnectionResult", id=3)
  private ConnectionResult zadh;

  @SafeParcelable.Field(getter="getSaveDefaultAccount", id=4)
  private boolean zagf;

  @SafeParcelable.VersionField(id=1)
  private final int zale;

  @SafeParcelable.Field(id=2)
  private IBinder zanw;

  @SafeParcelable.Field(getter="isFromCrossClientAuth", id=5)
  private boolean zapb;

  public ResolveAccountResponse(int paramInt)
  {
    this(new ConnectionResult(paramInt, null));
  }

  @SafeParcelable.Constructor
  ResolveAccountResponse(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) IBinder paramIBinder, @SafeParcelable.Param(id=3) ConnectionResult paramConnectionResult, @SafeParcelable.Param(id=4) boolean paramBoolean1, @SafeParcelable.Param(id=5) boolean paramBoolean2)
  {
    this.zale = paramInt;
    this.zanw = paramIBinder;
    this.zadh = paramConnectionResult;
    this.zagf = paramBoolean1;
    this.zapb = paramBoolean2;
  }

  public ResolveAccountResponse(ConnectionResult paramConnectionResult)
  {
    this(1, null, paramConnectionResult, false, false);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    ResolveAccountResponse localResolveAccountResponse;
    do
    {
      return true;
      if (!(paramObject instanceof ResolveAccountResponse))
        return false;
      localResolveAccountResponse = (ResolveAccountResponse)paramObject;
    }
    while ((this.zadh.equals(localResolveAccountResponse.zadh)) && (getAccountAccessor().equals(localResolveAccountResponse.getAccountAccessor())));
    return false;
  }

  public IAccountAccessor getAccountAccessor()
  {
    return IAccountAccessor.Stub.asInterface(this.zanw);
  }

  public ConnectionResult getConnectionResult()
  {
    return this.zadh;
  }

  public boolean getSaveDefaultAccount()
  {
    return this.zagf;
  }

  public boolean isFromCrossClientAuth()
  {
    return this.zapb;
  }

  public ResolveAccountResponse setAccountAccessor(IAccountAccessor paramIAccountAccessor)
  {
    if (paramIAccountAccessor == null);
    for (IBinder localIBinder = null; ; localIBinder = paramIAccountAccessor.asBinder())
    {
      this.zanw = localIBinder;
      return this;
    }
  }

  public ResolveAccountResponse setIsFromCrossClientAuth(boolean paramBoolean)
  {
    this.zapb = paramBoolean;
    return this;
  }

  public ResolveAccountResponse setSaveDefaultAccount(boolean paramBoolean)
  {
    this.zagf = paramBoolean;
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zale);
    SafeParcelWriter.writeIBinder(paramParcel, 2, this.zanw, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, getConnectionResult(), paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 4, getSaveDefaultAccount());
    SafeParcelWriter.writeBoolean(paramParcel, 5, isFromCrossClientAuth());
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.ResolveAccountResponse
 * JD-Core Version:    0.6.2
 */