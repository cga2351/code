package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.zzh;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzagu;
import com.google.android.gms.internal.ads.zzagw;
import com.google.android.gms.internal.ads.zzare;
import com.google.android.gms.internal.ads.zzbaj;
import com.google.android.gms.internal.ads.zzbha;
import com.google.android.gms.internal.ads.zzxp;

@zzare
@SafeParcelable.Class(creator="AdOverlayInfoCreator")
@SafeParcelable.Reserved({1})
public final class AdOverlayInfoParcel extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new zzn();

  @SafeParcelable.Field(id=11)
  public final int orientation;

  @SafeParcelable.Field(id=13)
  public final String url;

  @SafeParcelable.Field(id=14)
  public final zzbaj zzbtd;

  @SafeParcelable.Field(getter="getAdClickListenerAsBinder", id=3, type="android.os.IBinder")
  public final zzxp zzcgj;

  @SafeParcelable.Field(getter="getAdMetadataGmsgListenerAsBinder", id=18, type="android.os.IBinder")
  public final zzagu zzczo;

  @SafeParcelable.Field(getter="getAppEventGmsgListenerAsBinder", id=6, type="android.os.IBinder")
  public final zzagw zzczp;

  @SafeParcelable.Field(getter="getAdWebViewAsBinder", id=5, type="android.os.IBinder")
  public final zzbha zzdbu;

  @SafeParcelable.Field(id=2)
  public final zzc zzdkn;

  @SafeParcelable.Field(getter="getAdOverlayListenerAsBinder", id=4, type="android.os.IBinder")
  public final zzo zzdko;

  @SafeParcelable.Field(id=7)
  public final String zzdkp;

  @SafeParcelable.Field(id=8)
  public final boolean zzdkq;

  @SafeParcelable.Field(id=9)
  public final String zzdkr;

  @SafeParcelable.Field(getter="getLeaveApplicationListenerAsBinder", id=10, type="android.os.IBinder")
  public final zzu zzdks;

  @SafeParcelable.Field(id=12)
  public final int zzdkt;

  @SafeParcelable.Field(id=16)
  public final String zzdku;

  @SafeParcelable.Field(id=17)
  public final zzh zzdkv;

  @SafeParcelable.Constructor
  AdOverlayInfoParcel(@SafeParcelable.Param(id=2) zzc paramzzc, @SafeParcelable.Param(id=3) IBinder paramIBinder1, @SafeParcelable.Param(id=4) IBinder paramIBinder2, @SafeParcelable.Param(id=5) IBinder paramIBinder3, @SafeParcelable.Param(id=6) IBinder paramIBinder4, @SafeParcelable.Param(id=7) String paramString1, @SafeParcelable.Param(id=8) boolean paramBoolean, @SafeParcelable.Param(id=9) String paramString2, @SafeParcelable.Param(id=10) IBinder paramIBinder5, @SafeParcelable.Param(id=11) int paramInt1, @SafeParcelable.Param(id=12) int paramInt2, @SafeParcelable.Param(id=13) String paramString3, @SafeParcelable.Param(id=14) zzbaj paramzzbaj, @SafeParcelable.Param(id=16) String paramString4, @SafeParcelable.Param(id=17) zzh paramzzh, @SafeParcelable.Param(id=18) IBinder paramIBinder6)
  {
    this.zzdkn = paramzzc;
    this.zzcgj = ((zzxp)ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(paramIBinder1)));
    this.zzdko = ((zzo)ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(paramIBinder2)));
    this.zzdbu = ((zzbha)ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(paramIBinder3)));
    this.zzczo = ((zzagu)ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(paramIBinder6)));
    this.zzczp = ((zzagw)ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(paramIBinder4)));
    this.zzdkp = paramString1;
    this.zzdkq = paramBoolean;
    this.zzdkr = paramString2;
    this.zzdks = ((zzu)ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(paramIBinder5)));
    this.orientation = paramInt1;
    this.zzdkt = paramInt2;
    this.url = paramString3;
    this.zzbtd = paramzzbaj;
    this.zzdku = paramString4;
    this.zzdkv = paramzzh;
  }

  public AdOverlayInfoParcel(zzc paramzzc, zzxp paramzzxp, zzo paramzzo, zzu paramzzu, zzbaj paramzzbaj)
  {
    this.zzdkn = paramzzc;
    this.zzcgj = paramzzxp;
    this.zzdko = paramzzo;
    this.zzdbu = null;
    this.zzczo = null;
    this.zzczp = null;
    this.zzdkp = null;
    this.zzdkq = false;
    this.zzdkr = null;
    this.zzdks = paramzzu;
    this.orientation = -1;
    this.zzdkt = 4;
    this.url = null;
    this.zzbtd = paramzzbaj;
    this.zzdku = null;
    this.zzdkv = null;
  }

  public AdOverlayInfoParcel(zzxp paramzzxp, zzo paramzzo, zzu paramzzu, zzbha paramzzbha, int paramInt, zzbaj paramzzbaj, String paramString, zzh paramzzh)
  {
    this.zzdkn = null;
    this.zzcgj = null;
    this.zzdko = paramzzo;
    this.zzdbu = paramzzbha;
    this.zzczo = null;
    this.zzczp = null;
    this.zzdkp = null;
    this.zzdkq = false;
    this.zzdkr = null;
    this.zzdks = null;
    this.orientation = paramInt;
    this.zzdkt = 1;
    this.url = null;
    this.zzbtd = paramzzbaj;
    this.zzdku = paramString;
    this.zzdkv = paramzzh;
  }

  public AdOverlayInfoParcel(zzxp paramzzxp, zzo paramzzo, zzu paramzzu, zzbha paramzzbha, boolean paramBoolean, int paramInt, zzbaj paramzzbaj)
  {
    this.zzdkn = null;
    this.zzcgj = paramzzxp;
    this.zzdko = paramzzo;
    this.zzdbu = paramzzbha;
    this.zzczo = null;
    this.zzczp = null;
    this.zzdkp = null;
    this.zzdkq = paramBoolean;
    this.zzdkr = null;
    this.zzdks = paramzzu;
    this.orientation = paramInt;
    this.zzdkt = 2;
    this.url = null;
    this.zzbtd = paramzzbaj;
    this.zzdku = null;
    this.zzdkv = null;
  }

  public AdOverlayInfoParcel(zzxp paramzzxp, zzo paramzzo, zzagu paramzzagu, zzagw paramzzagw, zzu paramzzu, zzbha paramzzbha, boolean paramBoolean, int paramInt, String paramString, zzbaj paramzzbaj)
  {
    this.zzdkn = null;
    this.zzcgj = paramzzxp;
    this.zzdko = paramzzo;
    this.zzdbu = paramzzbha;
    this.zzczo = paramzzagu;
    this.zzczp = paramzzagw;
    this.zzdkp = null;
    this.zzdkq = paramBoolean;
    this.zzdkr = null;
    this.zzdks = paramzzu;
    this.orientation = paramInt;
    this.zzdkt = 3;
    this.url = paramString;
    this.zzbtd = paramzzbaj;
    this.zzdku = null;
    this.zzdkv = null;
  }

  public AdOverlayInfoParcel(zzxp paramzzxp, zzo paramzzo, zzagu paramzzagu, zzagw paramzzagw, zzu paramzzu, zzbha paramzzbha, boolean paramBoolean, int paramInt, String paramString1, String paramString2, zzbaj paramzzbaj)
  {
    this.zzdkn = null;
    this.zzcgj = paramzzxp;
    this.zzdko = paramzzo;
    this.zzdbu = paramzzbha;
    this.zzczo = paramzzagu;
    this.zzczp = paramzzagw;
    this.zzdkp = paramString2;
    this.zzdkq = paramBoolean;
    this.zzdkr = paramString1;
    this.zzdks = paramzzu;
    this.orientation = paramInt;
    this.zzdkt = 3;
    this.url = null;
    this.zzbtd = paramzzbaj;
    this.zzdku = null;
    this.zzdkv = null;
  }

  public static void zza(Intent paramIntent, AdOverlayInfoParcel paramAdOverlayInfoParcel)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", paramAdOverlayInfoParcel);
    paramIntent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", localBundle);
  }

  public static AdOverlayInfoParcel zzc(Intent paramIntent)
  {
    try
    {
      Bundle localBundle = paramIntent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      localBundle.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
      AdOverlayInfoParcel localAdOverlayInfoParcel = (AdOverlayInfoParcel)localBundle.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      return localAdOverlayInfoParcel;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.zzdkn, paramInt, false);
    SafeParcelWriter.writeIBinder(paramParcel, 3, ObjectWrapper.wrap(this.zzcgj).asBinder(), false);
    SafeParcelWriter.writeIBinder(paramParcel, 4, ObjectWrapper.wrap(this.zzdko).asBinder(), false);
    SafeParcelWriter.writeIBinder(paramParcel, 5, ObjectWrapper.wrap(this.zzdbu).asBinder(), false);
    SafeParcelWriter.writeIBinder(paramParcel, 6, ObjectWrapper.wrap(this.zzczp).asBinder(), false);
    SafeParcelWriter.writeString(paramParcel, 7, this.zzdkp, false);
    SafeParcelWriter.writeBoolean(paramParcel, 8, this.zzdkq);
    SafeParcelWriter.writeString(paramParcel, 9, this.zzdkr, false);
    SafeParcelWriter.writeIBinder(paramParcel, 10, ObjectWrapper.wrap(this.zzdks).asBinder(), false);
    SafeParcelWriter.writeInt(paramParcel, 11, this.orientation);
    SafeParcelWriter.writeInt(paramParcel, 12, this.zzdkt);
    SafeParcelWriter.writeString(paramParcel, 13, this.url, false);
    SafeParcelWriter.writeParcelable(paramParcel, 14, this.zzbtd, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 16, this.zzdku, false);
    SafeParcelWriter.writeParcelable(paramParcel, 17, this.zzdkv, paramInt, false);
    SafeParcelWriter.writeIBinder(paramParcel, 18, ObjectWrapper.wrap(this.zzczo).asBinder(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel
 * JD-Core Version:    0.6.2
 */