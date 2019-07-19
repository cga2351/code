package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SafeParcelable.Class(creator="CredentialPickerConfigCreator")
public final class CredentialPickerConfig extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new zze();

  @SafeParcelable.Field(getter="shouldShowCancelButton", id=2)
  private final boolean mShowCancelButton;

  @SafeParcelable.Field(id=1000)
  private final int zzu;

  @SafeParcelable.Field(getter="shouldShowAddAccountButton", id=1)
  private final boolean zzv;

  @Deprecated
  @SafeParcelable.Field(getter="isForNewAccount", id=3)
  private final boolean zzw;

  @SafeParcelable.Field(getter="getPromptInternalId", id=4)
  private final int zzx;

  @SafeParcelable.Constructor
  CredentialPickerConfig(@SafeParcelable.Param(id=1000) int paramInt1, @SafeParcelable.Param(id=1) boolean paramBoolean1, @SafeParcelable.Param(id=2) boolean paramBoolean2, @SafeParcelable.Param(id=3) boolean paramBoolean3, @SafeParcelable.Param(id=4) int paramInt2)
  {
    this.zzu = paramInt1;
    this.zzv = paramBoolean1;
    this.mShowCancelButton = paramBoolean2;
    if (paramInt1 < 2)
    {
      this.zzw = paramBoolean3;
      if (paramBoolean3);
      while (true)
      {
        this.zzx = i;
        return;
        i = j;
      }
    }
    if (paramInt2 == i);
    while (true)
    {
      this.zzw = j;
      this.zzx = paramInt2;
      return;
      j = 0;
    }
  }

  private CredentialPickerConfig(Builder paramBuilder)
  {
    this(2, Builder.zzc(paramBuilder), Builder.zzd(paramBuilder), false, Builder.zze(paramBuilder));
  }

  @Deprecated
  public final boolean isForNewAccount()
  {
    return this.zzx == 3;
  }

  public final boolean shouldShowAddAccountButton()
  {
    return this.zzv;
  }

  public final boolean shouldShowCancelButton()
  {
    return this.mShowCancelButton;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBoolean(paramParcel, 1, shouldShowAddAccountButton());
    SafeParcelWriter.writeBoolean(paramParcel, 2, shouldShowCancelButton());
    SafeParcelWriter.writeBoolean(paramParcel, 3, isForNewAccount());
    SafeParcelWriter.writeInt(paramParcel, 4, this.zzx);
    SafeParcelWriter.writeInt(paramParcel, 1000, this.zzu);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }

  public static class Builder
  {
    private boolean mShowCancelButton = true;
    private boolean zzv = false;
    private int zzy = 1;

    public CredentialPickerConfig build()
    {
      return new CredentialPickerConfig(this, null);
    }

    @Deprecated
    public Builder setForNewAccount(boolean paramBoolean)
    {
      if (paramBoolean);
      for (int i = 3; ; i = 1)
      {
        this.zzy = i;
        return this;
      }
    }

    public Builder setPrompt(int paramInt)
    {
      this.zzy = paramInt;
      return this;
    }

    public Builder setShowAddAccountButton(boolean paramBoolean)
    {
      this.zzv = paramBoolean;
      return this;
    }

    public Builder setShowCancelButton(boolean paramBoolean)
    {
      this.mShowCancelButton = paramBoolean;
      return this;
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface Prompt
  {
    public static final int CONTINUE = 1;
    public static final int SIGN_IN = 2;
    public static final int SIGN_UP = 3;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.CredentialPickerConfig
 * JD-Core Version:    0.6.2
 */