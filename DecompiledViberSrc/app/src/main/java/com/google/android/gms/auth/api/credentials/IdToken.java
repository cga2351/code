package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@SafeParcelable.Class(creator="IdTokenCreator")
@SafeParcelable.Reserved({1000})
public final class IdToken extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<IdToken> CREATOR = new zzk();

  @SafeParcelable.Field(getter="getIdToken", id=2)
  private final String zzak;

  @SafeParcelable.Field(getter="getAccountType", id=1)
  private final String zzr;

  @SafeParcelable.Constructor
  public IdToken(@SafeParcelable.Param(id=1) String paramString1, @SafeParcelable.Param(id=2) String paramString2)
  {
    boolean bool2;
    if (!TextUtils.isEmpty(paramString1))
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2, "account type string cannot be null or empty");
      if (TextUtils.isEmpty(paramString2))
        break label53;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1, "id token string cannot be null or empty");
      this.zzr = paramString1;
      this.zzak = paramString2;
      return;
      bool2 = false;
      break;
      label53: bool1 = false;
    }
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    IdToken localIdToken;
    do
    {
      return true;
      if (!(paramObject instanceof IdToken))
        return false;
      localIdToken = (IdToken)paramObject;
    }
    while ((Objects.equal(this.zzr, localIdToken.zzr)) && (Objects.equal(this.zzak, localIdToken.zzak)));
    return false;
  }

  public final String getAccountType()
  {
    return this.zzr;
  }

  public final String getIdToken()
  {
    return this.zzak;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getAccountType(), false);
    SafeParcelWriter.writeString(paramParcel, 2, getIdToken(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.IdToken
 * JD-Core Version:    0.6.2
 */