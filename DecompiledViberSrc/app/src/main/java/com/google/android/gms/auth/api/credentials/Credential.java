package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
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
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;

@SafeParcelable.Class(creator="CredentialCreator")
@SafeParcelable.Reserved({1000})
public class Credential extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<Credential> CREATOR = new zzc();
  public static final String EXTRA_KEY = "com.google.android.gms.credentials.Credential";

  @Nonnull
  @SafeParcelable.Field(getter="getId", id=1)
  private final String mId;

  @SafeParcelable.Field(getter="getName", id=2)
  private final String mName;

  @SafeParcelable.Field(getter="getProfilePictureUri", id=3)
  private final Uri zzo;

  @Nonnull
  @SafeParcelable.Field(getter="getIdTokens", id=4)
  private final List<IdToken> zzp;

  @SafeParcelable.Field(getter="getPassword", id=5)
  private final String zzq;

  @SafeParcelable.Field(getter="getAccountType", id=6)
  private final String zzr;

  @SafeParcelable.Field(getter="getGivenName", id=9)
  private final String zzs;

  @SafeParcelable.Field(getter="getFamilyName", id=10)
  private final String zzt;

  @SafeParcelable.Constructor
  Credential(@SafeParcelable.Param(id=1) String paramString1, @SafeParcelable.Param(id=2) String paramString2, @SafeParcelable.Param(id=3) Uri paramUri, @SafeParcelable.Param(id=4) List<IdToken> paramList, @SafeParcelable.Param(id=5) String paramString3, @SafeParcelable.Param(id=6) String paramString4, @SafeParcelable.Param(id=9) String paramString5, @SafeParcelable.Param(id=10) String paramString6)
  {
    String str = ((String)Preconditions.checkNotNull(paramString1, "credential identifier cannot be null")).trim();
    Preconditions.checkNotEmpty(str, "credential identifier cannot be empty");
    if ((paramString3 != null) && (TextUtils.isEmpty(paramString3)))
      throw new IllegalArgumentException("Password must not be empty if set");
    if (paramString4 != null)
    {
      Uri localUri;
      boolean bool;
      if (!TextUtils.isEmpty(paramString4))
      {
        localUri = Uri.parse(paramString4);
        if ((!localUri.isAbsolute()) || (!localUri.isHierarchical()) || (TextUtils.isEmpty(localUri.getScheme())) || (TextUtils.isEmpty(localUri.getAuthority())))
          bool = false;
      }
      while (!Boolean.valueOf(bool).booleanValue())
      {
        throw new IllegalArgumentException("Account type must be a valid Http/Https URI");
        if (("http".equalsIgnoreCase(localUri.getScheme())) || ("https".equalsIgnoreCase(localUri.getScheme())))
          bool = true;
        else
          bool = false;
      }
    }
    if ((!TextUtils.isEmpty(paramString4)) && (!TextUtils.isEmpty(paramString3)))
      throw new IllegalArgumentException("Password and AccountType are mutually exclusive");
    if ((paramString2 != null) && (TextUtils.isEmpty(paramString2.trim())))
      paramString2 = null;
    this.mName = paramString2;
    this.zzo = paramUri;
    if (paramList == null);
    for (List localList = Collections.emptyList(); ; localList = Collections.unmodifiableList(paramList))
    {
      this.zzp = localList;
      this.mId = str;
      this.zzq = paramString3;
      this.zzr = paramString4;
      this.zzs = paramString5;
      this.zzt = paramString6;
      return;
    }
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Credential localCredential;
    do
    {
      return true;
      if (!(paramObject instanceof Credential))
        return false;
      localCredential = (Credential)paramObject;
    }
    while ((TextUtils.equals(this.mId, localCredential.mId)) && (TextUtils.equals(this.mName, localCredential.mName)) && (Objects.equal(this.zzo, localCredential.zzo)) && (TextUtils.equals(this.zzq, localCredential.zzq)) && (TextUtils.equals(this.zzr, localCredential.zzr)));
    return false;
  }

  public String getAccountType()
  {
    return this.zzr;
  }

  public String getFamilyName()
  {
    return this.zzt;
  }

  public String getGivenName()
  {
    return this.zzs;
  }

  @Nonnull
  public String getId()
  {
    return this.mId;
  }

  @Nonnull
  public List<IdToken> getIdTokens()
  {
    return this.zzp;
  }

  public String getName()
  {
    return this.mName;
  }

  public String getPassword()
  {
    return this.zzq;
  }

  public Uri getProfilePictureUri()
  {
    return this.zzo;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = this.mId;
    arrayOfObject[1] = this.mName;
    arrayOfObject[2] = this.zzo;
    arrayOfObject[3] = this.zzq;
    arrayOfObject[4] = this.zzr;
    return Objects.hashCode(arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getId(), false);
    SafeParcelWriter.writeString(paramParcel, 2, getName(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, getProfilePictureUri(), paramInt, false);
    SafeParcelWriter.writeTypedList(paramParcel, 4, getIdTokens(), false);
    SafeParcelWriter.writeString(paramParcel, 5, getPassword(), false);
    SafeParcelWriter.writeString(paramParcel, 6, getAccountType(), false);
    SafeParcelWriter.writeString(paramParcel, 9, getGivenName(), false);
    SafeParcelWriter.writeString(paramParcel, 10, getFamilyName(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }

  public static class Builder
  {
    private final String mId;
    private String mName;
    private Uri zzo;
    private List<IdToken> zzp;
    private String zzq;
    private String zzr;
    private String zzs;
    private String zzt;

    public Builder(Credential paramCredential)
    {
      this.mId = Credential.zzc(paramCredential);
      this.mName = Credential.zzd(paramCredential);
      this.zzo = Credential.zze(paramCredential);
      this.zzp = Credential.zzf(paramCredential);
      this.zzq = Credential.zzg(paramCredential);
      this.zzr = Credential.zzh(paramCredential);
      this.zzs = Credential.zzi(paramCredential);
      this.zzt = Credential.zzj(paramCredential);
    }

    public Builder(String paramString)
    {
      this.mId = paramString;
    }

    public Credential build()
    {
      return new Credential(this.mId, this.mName, this.zzo, this.zzp, this.zzq, this.zzr, this.zzs, this.zzt);
    }

    public Builder setAccountType(String paramString)
    {
      this.zzr = paramString;
      return this;
    }

    public Builder setName(String paramString)
    {
      this.mName = paramString;
      return this;
    }

    public Builder setPassword(String paramString)
    {
      this.zzq = paramString;
      return this;
    }

    public Builder setProfilePictureUri(Uri paramUri)
    {
      this.zzo = paramUri;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.Credential
 * JD-Core Version:    0.6.2
 */