package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@SafeParcelable.Class(creator="ResolveAccountRequestCreator")
public class ResolveAccountRequest extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ResolveAccountRequest> CREATOR = new zam();

  @SafeParcelable.VersionField(id=1)
  private final int zale;

  @SafeParcelable.Field(getter="getSessionId", id=3)
  private final int zaoz;

  @SafeParcelable.Field(getter="getSignInAccountHint", id=4)
  private final GoogleSignInAccount zapa;

  @SafeParcelable.Field(getter="getAccount", id=2)
  private final Account zax;

  @SafeParcelable.Constructor
  ResolveAccountRequest(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) Account paramAccount, @SafeParcelable.Param(id=3) int paramInt2, @SafeParcelable.Param(id=4) GoogleSignInAccount paramGoogleSignInAccount)
  {
    this.zale = paramInt1;
    this.zax = paramAccount;
    this.zaoz = paramInt2;
    this.zapa = paramGoogleSignInAccount;
  }

  public ResolveAccountRequest(Account paramAccount, int paramInt, GoogleSignInAccount paramGoogleSignInAccount)
  {
    this(2, paramAccount, paramInt, paramGoogleSignInAccount);
  }

  public Account getAccount()
  {
    return this.zax;
  }

  public int getSessionId()
  {
    return this.zaoz;
  }

  public GoogleSignInAccount getSignInAccountHint()
  {
    return this.zapa;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zale);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getAccount(), paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, getSessionId());
    SafeParcelWriter.writeParcelable(paramParcel, 4, getSignInAccountHint(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.ResolveAccountRequest
 * JD-Core Version:    0.6.2
 */