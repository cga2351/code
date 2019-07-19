package com.google.android.gms.common.internal;

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

@SafeParcelable.Class(creator="SignInButtonConfigCreator")
public class SignInButtonConfig extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<SignInButtonConfig> CREATOR = new zao();

  @SafeParcelable.VersionField(id=1)
  private final int zale;

  @Deprecated
  @SafeParcelable.Field(getter="getScopes", id=4)
  private final Scope[] zanx;

  @SafeParcelable.Field(getter="getButtonSize", id=2)
  private final int zapc;

  @SafeParcelable.Field(getter="getColorScheme", id=3)
  private final int zapd;

  @SafeParcelable.Constructor
  SignInButtonConfig(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) int paramInt2, @SafeParcelable.Param(id=3) int paramInt3, @SafeParcelable.Param(id=4) Scope[] paramArrayOfScope)
  {
    this.zale = paramInt1;
    this.zapc = paramInt2;
    this.zapd = paramInt3;
    this.zanx = paramArrayOfScope;
  }

  public SignInButtonConfig(int paramInt1, int paramInt2, Scope[] paramArrayOfScope)
  {
    this(1, paramInt1, paramInt2, null);
  }

  public int getButtonSize()
  {
    return this.zapc;
  }

  public int getColorScheme()
  {
    return this.zapd;
  }

  @Deprecated
  public Scope[] getScopes()
  {
    return this.zanx;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zale);
    SafeParcelWriter.writeInt(paramParcel, 2, getButtonSize());
    SafeParcelWriter.writeInt(paramParcel, 3, getColorScheme());
    SafeParcelWriter.writeTypedArray(paramParcel, 4, getScopes(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.SignInButtonConfig
 * JD-Core Version:    0.6.2
 */