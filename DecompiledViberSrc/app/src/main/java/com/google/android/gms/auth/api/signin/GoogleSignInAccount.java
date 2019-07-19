package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator="GoogleSignInAccountCreator")
public class GoogleSignInAccount extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zab();

  @VisibleForTesting
  private static Clock zae = DefaultClock.getInstance();

  @SafeParcelable.Field(getter="getId", id=2)
  private String mId;

  @SafeParcelable.VersionField(id=1)
  private final int versionCode;

  @SafeParcelable.Field(getter="getIdToken", id=3)
  private String zaf;

  @SafeParcelable.Field(getter="getEmail", id=4)
  private String zag;

  @SafeParcelable.Field(getter="getDisplayName", id=5)
  private String zah;

  @SafeParcelable.Field(getter="getPhotoUrl", id=6)
  private Uri zai;

  @SafeParcelable.Field(getter="getServerAuthCode", id=7)
  private String zaj;

  @SafeParcelable.Field(getter="getExpirationTimeSecs", id=8)
  private long zak;

  @SafeParcelable.Field(getter="getObfuscatedIdentifier", id=9)
  private String zal;

  @SafeParcelable.Field(id=10)
  private List<Scope> zam;

  @SafeParcelable.Field(getter="getGivenName", id=11)
  private String zan;

  @SafeParcelable.Field(getter="getFamilyName", id=12)
  private String zao;
  private Set<Scope> zap = new HashSet();

  @SafeParcelable.Constructor
  GoogleSignInAccount(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) String paramString2, @SafeParcelable.Param(id=4) String paramString3, @SafeParcelable.Param(id=5) String paramString4, @SafeParcelable.Param(id=6) Uri paramUri, @SafeParcelable.Param(id=7) String paramString5, @SafeParcelable.Param(id=8) long paramLong, @SafeParcelable.Param(id=9) String paramString6, @SafeParcelable.Param(id=10) List<Scope> paramList, @SafeParcelable.Param(id=11) String paramString7, @SafeParcelable.Param(id=12) String paramString8)
  {
    this.versionCode = paramInt;
    this.mId = paramString1;
    this.zaf = paramString2;
    this.zag = paramString3;
    this.zah = paramString4;
    this.zai = paramUri;
    this.zaj = paramString5;
    this.zak = paramLong;
    this.zal = paramString6;
    this.zam = paramList;
    this.zan = paramString7;
    this.zao = paramString8;
  }

  @KeepForSdk
  public static GoogleSignInAccount createDefault()
  {
    Account localAccount = new Account("<<default account>>", "com.google");
    HashSet localHashSet = new HashSet();
    return zaa(null, null, localAccount.name, null, null, null, null, Long.valueOf(0L), localAccount.name, localHashSet);
  }

  public static GoogleSignInAccount zaa(String paramString)
    throws JSONException
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    JSONObject localJSONObject = new JSONObject(paramString);
    String str = localJSONObject.optString("photoUrl", null);
    if (!TextUtils.isEmpty(str));
    for (Uri localUri = Uri.parse(str); ; localUri = null)
    {
      long l = Long.parseLong(localJSONObject.getString("expirationTime"));
      HashSet localHashSet = new HashSet();
      JSONArray localJSONArray = localJSONObject.getJSONArray("grantedScopes");
      int i = localJSONArray.length();
      for (int j = 0; j < i; j++)
        localHashSet.add(new Scope(localJSONArray.getString(j)));
      GoogleSignInAccount localGoogleSignInAccount = zaa(localJSONObject.optString("id"), localJSONObject.optString("tokenId", null), localJSONObject.optString("email", null), localJSONObject.optString("displayName", null), localJSONObject.optString("givenName", null), localJSONObject.optString("familyName", null), localUri, Long.valueOf(l), localJSONObject.getString("obfuscatedIdentifier"), localHashSet);
      localGoogleSignInAccount.zaj = localJSONObject.optString("serverAuthCode", null);
      return localGoogleSignInAccount;
    }
  }

  private static GoogleSignInAccount zaa(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Uri paramUri, Long paramLong, String paramString7, Set<Scope> paramSet)
  {
    if (paramLong == null)
      paramLong = Long.valueOf(zae.currentTimeMillis() / 1000L);
    return new GoogleSignInAccount(3, paramString1, paramString2, paramString3, paramString4, paramUri, null, paramLong.longValue(), Preconditions.checkNotEmpty(paramString7), new ArrayList((Collection)Preconditions.checkNotNull(paramSet)), paramString5, paramString6);
  }

  private final JSONObject zad()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (getId() != null)
        localJSONObject.put("id", getId());
      if (getIdToken() != null)
        localJSONObject.put("tokenId", getIdToken());
      if (getEmail() != null)
        localJSONObject.put("email", getEmail());
      if (getDisplayName() != null)
        localJSONObject.put("displayName", getDisplayName());
      if (getGivenName() != null)
        localJSONObject.put("givenName", getGivenName());
      if (getFamilyName() != null)
        localJSONObject.put("familyName", getFamilyName());
      if (getPhotoUrl() != null)
        localJSONObject.put("photoUrl", getPhotoUrl().toString());
      if (getServerAuthCode() != null)
        localJSONObject.put("serverAuthCode", getServerAuthCode());
      localJSONObject.put("expirationTime", this.zak);
      localJSONObject.put("obfuscatedIdentifier", this.zal);
      JSONArray localJSONArray = new JSONArray();
      Scope[] arrayOfScope = (Scope[])this.zam.toArray(new Scope[this.zam.size()]);
      Arrays.sort(arrayOfScope, zaa.zaq);
      int i = arrayOfScope.length;
      for (int j = 0; j < i; j++)
        localJSONArray.put(arrayOfScope[j].getScopeUri());
      localJSONObject.put("grantedScopes", localJSONArray);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    GoogleSignInAccount localGoogleSignInAccount;
    do
    {
      return true;
      if (!(paramObject instanceof GoogleSignInAccount))
        return false;
      localGoogleSignInAccount = (GoogleSignInAccount)paramObject;
    }
    while ((localGoogleSignInAccount.zal.equals(this.zal)) && (localGoogleSignInAccount.getRequestedScopes().equals(getRequestedScopes())));
    return false;
  }

  public Account getAccount()
  {
    if (this.zag == null)
      return null;
    return new Account(this.zag, "com.google");
  }

  public String getDisplayName()
  {
    return this.zah;
  }

  public String getEmail()
  {
    return this.zag;
  }

  public String getFamilyName()
  {
    return this.zao;
  }

  public String getGivenName()
  {
    return this.zan;
  }

  public Set<Scope> getGrantedScopes()
  {
    return new HashSet(this.zam);
  }

  public String getId()
  {
    return this.mId;
  }

  public String getIdToken()
  {
    return this.zaf;
  }

  public Uri getPhotoUrl()
  {
    return this.zai;
  }

  @KeepForSdk
  public Set<Scope> getRequestedScopes()
  {
    HashSet localHashSet = new HashSet(this.zam);
    localHashSet.addAll(this.zap);
    return localHashSet;
  }

  public String getServerAuthCode()
  {
    return this.zaj;
  }

  public int hashCode()
  {
    return 31 * (527 + this.zal.hashCode()) + getRequestedScopes().hashCode();
  }

  @KeepForSdk
  public boolean isExpired()
  {
    return zae.currentTimeMillis() / 1000L >= this.zak - 300L;
  }

  @KeepForSdk
  public GoogleSignInAccount requestExtraScopes(Scope[] paramArrayOfScope)
  {
    if (paramArrayOfScope != null)
      Collections.addAll(this.zap, paramArrayOfScope);
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeString(paramParcel, 2, getId(), false);
    SafeParcelWriter.writeString(paramParcel, 3, getIdToken(), false);
    SafeParcelWriter.writeString(paramParcel, 4, getEmail(), false);
    SafeParcelWriter.writeString(paramParcel, 5, getDisplayName(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 6, getPhotoUrl(), paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 7, getServerAuthCode(), false);
    SafeParcelWriter.writeLong(paramParcel, 8, this.zak);
    SafeParcelWriter.writeString(paramParcel, 9, this.zal, false);
    SafeParcelWriter.writeTypedList(paramParcel, 10, this.zam, false);
    SafeParcelWriter.writeString(paramParcel, 11, getGivenName(), false);
    SafeParcelWriter.writeString(paramParcel, 12, getFamilyName(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }

  public final String zab()
  {
    return this.zal;
  }

  public final String zac()
  {
    JSONObject localJSONObject = zad();
    localJSONObject.remove("serverAuthCode");
    return localJSONObject.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInAccount
 * JD-Core Version:    0.6.2
 */