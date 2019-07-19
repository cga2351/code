package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator="SignInAccountCreator")
@SafeParcelable.Reserved({1})
public class SignInAccount extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<SignInAccount> CREATOR = new zzd();

  @Deprecated
  @SafeParcelable.Field(defaultValue="", id=4)
  private String zzba;

  @SafeParcelable.Field(getter="getGoogleSignInAccount", id=7)
  private GoogleSignInAccount zzbb;

  @Deprecated
  @SafeParcelable.Field(defaultValue="", id=8)
  private String zzbc;

  @SafeParcelable.Constructor
  SignInAccount(@SafeParcelable.Param(id=4) String paramString1, @SafeParcelable.Param(id=7) GoogleSignInAccount paramGoogleSignInAccount, @SafeParcelable.Param(id=8) String paramString2)
  {
    this.zzbb = paramGoogleSignInAccount;
    this.zzba = Preconditions.checkNotEmpty(paramString1, "8.3 and 8.4 SDKs require non-null email");
    this.zzbc = Preconditions.checkNotEmpty(paramString2, "8.3 and 8.4 SDKs require non-null userId");
  }

  @Nullable
  public final GoogleSignInAccount getGoogleSignInAccount()
  {
    return this.zzbb;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzba, false);
    SafeParcelWriter.writeParcelable(paramParcel, 7, this.zzbb, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 8, this.zzbc, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.SignInAccount
 * JD-Core Version:    0.6.2
 */