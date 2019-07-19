package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@zzare
@SafeParcelable.Class(creator="CacheOfferingCreator")
@SafeParcelable.Reserved({1})
public final class zzvt extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzvt> CREATOR = new zzvu();

  @SafeParcelable.Field(id=2)
  public final String url;

  @SafeParcelable.Field(id=3)
  private final long zzbwt;

  @SafeParcelable.Field(id=4)
  private final String zzbwu;

  @SafeParcelable.Field(id=5)
  private final String zzbwv;

  @SafeParcelable.Field(id=6)
  private final String zzbww;

  @SafeParcelable.Field(id=7)
  private final Bundle zzbwx;

  @SafeParcelable.Field(id=8)
  public final boolean zzbwy;

  @SafeParcelable.Field(id=9)
  public long zzbwz;

  @SafeParcelable.Constructor
  zzvt(@SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) long paramLong1, @SafeParcelable.Param(id=4) String paramString2, @SafeParcelable.Param(id=5) String paramString3, @SafeParcelable.Param(id=6) String paramString4, @SafeParcelable.Param(id=7) Bundle paramBundle, @SafeParcelable.Param(id=8) boolean paramBoolean, @SafeParcelable.Param(id=9) long paramLong2)
  {
    this.url = paramString1;
    this.zzbwt = paramLong1;
    if (paramString2 != null)
    {
      this.zzbwu = paramString2;
      if (paramString3 == null)
        break label78;
      label30: this.zzbwv = paramString3;
      if (paramString4 == null)
        break label85;
      label41: this.zzbww = paramString4;
      if (paramBundle == null)
        break label92;
    }
    while (true)
    {
      this.zzbwx = paramBundle;
      this.zzbwy = paramBoolean;
      this.zzbwz = paramLong2;
      return;
      paramString2 = "";
      break;
      label78: paramString3 = "";
      break label30;
      label85: paramString4 = "";
      break label41;
      label92: paramBundle = new Bundle();
    }
  }

  public static zzvt zzbo(String paramString)
  {
    return zze(Uri.parse(paramString));
  }

  public static zzvt zze(Uri paramUri)
  {
    long l = 0L;
    try
    {
      if (!"gcache".equals(paramUri.getScheme()))
        return null;
      List localList = paramUri.getPathSegments();
      if (localList.size() != 2)
      {
        int i = localList.size();
        zzaxa.zzep(62 + "Expected 2 path parts for namespace and id, found :" + i);
        return null;
      }
      str1 = (String)localList.get(0);
      str2 = (String)localList.get(1);
      str3 = paramUri.getHost();
      str4 = paramUri.getQueryParameter("url");
      bool = "1".equals(paramUri.getQueryParameter("read_only"));
      str5 = paramUri.getQueryParameter("expiration");
      if (str5 == null)
      {
        localBundle = new Bundle();
        zzk.zzli();
        Iterator localIterator = paramUri.getQueryParameterNames().iterator();
        while (localIterator.hasNext())
        {
          String str6 = (String)localIterator.next();
          if (str6.startsWith("tag."))
            localBundle.putString(str6.substring(4), paramUri.getQueryParameter(str6));
        }
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      String str1;
      String str2;
      String str3;
      String str4;
      boolean bool;
      Bundle localBundle;
      while (true)
      {
        String str5;
        zzaxa.zzd("Unable to parse Uri into cache offering.", localNullPointerException);
        return null;
        l = Long.parseLong(str5);
      }
      zzvt localzzvt = new zzvt(str4, l, str3, str1, str2, localBundle, bool, 0L);
      return localzzvt;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label212: break label212;
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.url, false);
    SafeParcelWriter.writeLong(paramParcel, 3, this.zzbwt);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzbwu, false);
    SafeParcelWriter.writeString(paramParcel, 5, this.zzbwv, false);
    SafeParcelWriter.writeString(paramParcel, 6, this.zzbww, false);
    SafeParcelWriter.writeBundle(paramParcel, 7, this.zzbwx, false);
    SafeParcelWriter.writeBoolean(paramParcel, 8, this.zzbwy);
    SafeParcelWriter.writeLong(paramParcel, 9, this.zzbwz);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzvt
 * JD-Core Version:    0.6.2
 */