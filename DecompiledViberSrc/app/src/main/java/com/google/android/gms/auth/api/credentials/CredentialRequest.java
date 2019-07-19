package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SafeParcelable.Class(creator="CredentialRequestCreator")
public final class CredentialRequest extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<CredentialRequest> CREATOR = new zzg();

  @SafeParcelable.Field(getter="getAccountTypes", id=2)
  private final String[] zzaa;

  @SafeParcelable.Field(getter="getCredentialPickerConfig", id=3)
  private final CredentialPickerConfig zzab;

  @SafeParcelable.Field(getter="getCredentialHintPickerConfig", id=4)
  private final CredentialPickerConfig zzac;

  @SafeParcelable.Field(getter="isIdTokenRequested", id=5)
  private final boolean zzad;

  @SafeParcelable.Field(getter="getServerClientId", id=6)
  private final String zzae;

  @SafeParcelable.Field(getter="getIdTokenNonce", id=7)
  private final String zzaf;

  @SafeParcelable.Field(getter="getRequireUserMediation", id=8)
  private final boolean zzag;

  @SafeParcelable.Field(id=1000)
  private final int zzu;

  @SafeParcelable.Field(getter="isPasswordLoginSupported", id=1)
  private final boolean zzz;

  @SafeParcelable.Constructor
  CredentialRequest(@SafeParcelable.Param(id=1000) int paramInt, @SafeParcelable.Param(id=1) boolean paramBoolean1, @SafeParcelable.Param(id=2) String[] paramArrayOfString, @SafeParcelable.Param(id=3) CredentialPickerConfig paramCredentialPickerConfig1, @SafeParcelable.Param(id=4) CredentialPickerConfig paramCredentialPickerConfig2, @SafeParcelable.Param(id=5) boolean paramBoolean2, @SafeParcelable.Param(id=6) String paramString1, @SafeParcelable.Param(id=7) String paramString2, @SafeParcelable.Param(id=8) boolean paramBoolean3)
  {
    this.zzu = paramInt;
    this.zzz = paramBoolean1;
    this.zzaa = ((String[])Preconditions.checkNotNull(paramArrayOfString));
    if (paramCredentialPickerConfig1 == null)
      paramCredentialPickerConfig1 = new CredentialPickerConfig.Builder().build();
    this.zzab = paramCredentialPickerConfig1;
    if (paramCredentialPickerConfig2 == null)
      paramCredentialPickerConfig2 = new CredentialPickerConfig.Builder().build();
    this.zzac = paramCredentialPickerConfig2;
    if (paramInt < 3)
    {
      this.zzad = true;
      this.zzae = null;
    }
    for (this.zzaf = null; ; this.zzaf = paramString2)
    {
      this.zzag = paramBoolean3;
      return;
      this.zzad = paramBoolean2;
      this.zzae = paramString1;
    }
  }

  private CredentialRequest(Builder paramBuilder)
  {
    this(4, Builder.zzc(paramBuilder), Builder.zzd(paramBuilder), Builder.zze(paramBuilder), Builder.zzf(paramBuilder), Builder.zzg(paramBuilder), Builder.zzh(paramBuilder), Builder.zzi(paramBuilder), false);
  }

  public final String[] getAccountTypes()
  {
    return this.zzaa;
  }

  public final Set<String> getAccountTypesSet()
  {
    return new HashSet(Arrays.asList(this.zzaa));
  }

  public final CredentialPickerConfig getCredentialHintPickerConfig()
  {
    return this.zzac;
  }

  public final CredentialPickerConfig getCredentialPickerConfig()
  {
    return this.zzab;
  }

  public final String getIdTokenNonce()
  {
    return this.zzaf;
  }

  public final String getServerClientId()
  {
    return this.zzae;
  }

  @Deprecated
  public final boolean getSupportsPasswordLogin()
  {
    return isPasswordLoginSupported();
  }

  public final boolean isIdTokenRequested()
  {
    return this.zzad;
  }

  public final boolean isPasswordLoginSupported()
  {
    return this.zzz;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBoolean(paramParcel, 1, isPasswordLoginSupported());
    SafeParcelWriter.writeStringArray(paramParcel, 2, getAccountTypes(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, getCredentialPickerConfig(), paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 4, getCredentialHintPickerConfig(), paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 5, isIdTokenRequested());
    SafeParcelWriter.writeString(paramParcel, 6, getServerClientId(), false);
    SafeParcelWriter.writeString(paramParcel, 7, getIdTokenNonce(), false);
    SafeParcelWriter.writeInt(paramParcel, 1000, this.zzu);
    SafeParcelWriter.writeBoolean(paramParcel, 8, this.zzag);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }

  public static final class Builder
  {
    private String[] zzaa;
    private CredentialPickerConfig zzab;
    private CredentialPickerConfig zzac;
    private boolean zzad = false;
    private String zzae = null;
    private String zzaf;
    private boolean zzag = false;
    private boolean zzz;

    public final CredentialRequest build()
    {
      if (this.zzaa == null)
        this.zzaa = new String[0];
      if ((!this.zzz) && (this.zzaa.length == 0))
        throw new IllegalStateException("At least one authentication method must be specified");
      return new CredentialRequest(this, null);
    }

    public final Builder setAccountTypes(String[] paramArrayOfString)
    {
      if (paramArrayOfString == null)
        paramArrayOfString = new String[0];
      this.zzaa = paramArrayOfString;
      return this;
    }

    public final Builder setCredentialHintPickerConfig(CredentialPickerConfig paramCredentialPickerConfig)
    {
      this.zzac = paramCredentialPickerConfig;
      return this;
    }

    public final Builder setCredentialPickerConfig(CredentialPickerConfig paramCredentialPickerConfig)
    {
      this.zzab = paramCredentialPickerConfig;
      return this;
    }

    public final Builder setIdTokenNonce(String paramString)
    {
      this.zzaf = paramString;
      return this;
    }

    public final Builder setIdTokenRequested(boolean paramBoolean)
    {
      this.zzad = paramBoolean;
      return this;
    }

    public final Builder setPasswordLoginSupported(boolean paramBoolean)
    {
      this.zzz = paramBoolean;
      return this;
    }

    public final Builder setServerClientId(String paramString)
    {
      this.zzae = paramString;
      return this;
    }

    @Deprecated
    public final Builder setSupportsPasswordLogin(boolean paramBoolean)
    {
      return setPasswordLoginSupported(paramBoolean);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.CredentialRequest
 * JD-Core Version:    0.6.2
 */