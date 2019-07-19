package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator="AuthAccountRequestCreator")
public class AuthAccountRequest extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<AuthAccountRequest> CREATOR = new zaa();

  @SafeParcelable.VersionField(id=1)
  private final int zale;

  @Deprecated
  @SafeParcelable.Field(id=2)
  private final IBinder zanw;

  @SafeParcelable.Field(id=3)
  private final Scope[] zanx;

  @SafeParcelable.Field(id=4)
  private Integer zany;

  @SafeParcelable.Field(id=5)
  private Integer zanz;

  @SafeParcelable.Field(id=6, type="android.accounts.Account")
  private Account zax;

  @SafeParcelable.Constructor
  AuthAccountRequest(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) IBinder paramIBinder, @SafeParcelable.Param(id=3) Scope[] paramArrayOfScope, @SafeParcelable.Param(id=4) Integer paramInteger1, @SafeParcelable.Param(id=5) Integer paramInteger2, @SafeParcelable.Param(id=6) Account paramAccount)
  {
    this.zale = paramInt;
    this.zanw = paramIBinder;
    this.zanx = paramArrayOfScope;
    this.zany = paramInteger1;
    this.zanz = paramInteger2;
    this.zax = paramAccount;
  }

  public AuthAccountRequest(Account paramAccount, Set<Scope> paramSet)
  {
    this(3, null, (Scope[])paramSet.toArray(new Scope[paramSet.size()]), null, null, (Account)Preconditions.checkNotNull(paramAccount));
  }

  @Deprecated
  public AuthAccountRequest(IAccountAccessor paramIAccountAccessor, Set<Scope> paramSet)
  {
    this(3, paramIAccountAccessor.asBinder(), (Scope[])paramSet.toArray(new Scope[paramSet.size()]), null, null, null);
  }

  public Account getAccount()
  {
    Account localAccount;
    if (this.zax != null)
      localAccount = this.zax;
    IBinder localIBinder;
    do
    {
      return localAccount;
      localIBinder = this.zanw;
      localAccount = null;
    }
    while (localIBinder == null);
    return AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(this.zanw));
  }

  @Nullable
  public Integer getOauthPolicy()
  {
    return this.zany;
  }

  @Nullable
  public Integer getPolicyAction()
  {
    return this.zanz;
  }

  public Set<Scope> getScopes()
  {
    return new HashSet(Arrays.asList(this.zanx));
  }

  public AuthAccountRequest setOauthPolicy(@Nullable Integer paramInteger)
  {
    this.zany = paramInteger;
    return this;
  }

  public AuthAccountRequest setPolicyAction(@Nullable Integer paramInteger)
  {
    this.zanz = paramInteger;
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zale);
    SafeParcelWriter.writeIBinder(paramParcel, 2, this.zanw, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 3, this.zanx, paramInt, false);
    SafeParcelWriter.writeIntegerObject(paramParcel, 4, this.zany, false);
    SafeParcelWriter.writeIntegerObject(paramParcel, 5, this.zanz, false);
    SafeParcelWriter.writeParcelable(paramParcel, 6, this.zax, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.AuthAccountRequest
 * JD-Core Version:    0.6.2
 */