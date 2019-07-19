package com.google.android.gms.auth;

import android.os.Bundle;
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
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.List;

@SafeParcelable.Class(creator="TokenDataCreator")
public class TokenData extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<TokenData> CREATOR = new zzk();

  @SafeParcelable.Field(getter="getGrantedScopes", id=6)
  private final List<String> zzaa;

  @SafeParcelable.Field(getter="getScopeData", id=7)
  private final String zzab;

  @SafeParcelable.VersionField(id=1)
  private final int zzv;

  @SafeParcelable.Field(getter="getToken", id=2)
  private final String zzw;

  @SafeParcelable.Field(getter="getExpirationTimeSecs", id=3)
  private final Long zzx;

  @SafeParcelable.Field(getter="isCached", id=4)
  private final boolean zzy;

  @SafeParcelable.Field(getter="isSnowballed", id=5)
  private final boolean zzz;

  @SafeParcelable.Constructor
  TokenData(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) Long paramLong, @SafeParcelable.Param(id=4) boolean paramBoolean1, @SafeParcelable.Param(id=5) boolean paramBoolean2, @SafeParcelable.Param(id=6) List<String> paramList, @SafeParcelable.Param(id=7) String paramString2)
  {
    this.zzv = paramInt;
    this.zzw = Preconditions.checkNotEmpty(paramString1);
    this.zzx = paramLong;
    this.zzy = paramBoolean1;
    this.zzz = paramBoolean2;
    this.zzaa = paramList;
    this.zzab = paramString2;
  }

  public static TokenData zza(Bundle paramBundle, String paramString)
  {
    paramBundle.setClassLoader(TokenData.class.getClassLoader());
    Bundle localBundle = paramBundle.getBundle(paramString);
    if (localBundle == null)
      return null;
    localBundle.setClassLoader(TokenData.class.getClassLoader());
    return (TokenData)localBundle.getParcelable("TokenData");
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof TokenData));
    TokenData localTokenData;
    do
    {
      return false;
      localTokenData = (TokenData)paramObject;
    }
    while ((!TextUtils.equals(this.zzw, localTokenData.zzw)) || (!Objects.equal(this.zzx, localTokenData.zzx)) || (this.zzy != localTokenData.zzy) || (this.zzz != localTokenData.zzz) || (!Objects.equal(this.zzaa, localTokenData.zzaa)) || (!Objects.equal(this.zzab, localTokenData.zzab)));
    return true;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = this.zzw;
    arrayOfObject[1] = this.zzx;
    arrayOfObject[2] = Boolean.valueOf(this.zzy);
    arrayOfObject[3] = Boolean.valueOf(this.zzz);
    arrayOfObject[4] = this.zzaa;
    arrayOfObject[5] = this.zzab;
    return Objects.hashCode(arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzv);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzw, false);
    SafeParcelWriter.writeLongObject(paramParcel, 3, this.zzx, false);
    SafeParcelWriter.writeBoolean(paramParcel, 4, this.zzy);
    SafeParcelWriter.writeBoolean(paramParcel, 5, this.zzz);
    SafeParcelWriter.writeStringList(paramParcel, 6, this.zzaa, false);
    SafeParcelWriter.writeString(paramParcel, 7, this.zzab, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }

  public final String zzb()
  {
    return this.zzw;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.TokenData
 * JD-Core Version:    0.6.2
 */