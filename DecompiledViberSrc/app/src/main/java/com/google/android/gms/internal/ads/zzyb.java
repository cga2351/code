package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@zzare
@SafeParcelable.Class(creator="AdSizeParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzyb extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzyb> CREATOR = new zzyc();

  @SafeParcelable.Field(id=3)
  public final int height;

  @SafeParcelable.Field(id=4)
  public final int heightPixels;

  @SafeParcelable.Field(id=6)
  public final int width;

  @SafeParcelable.Field(id=7)
  public final int widthPixels;

  @SafeParcelable.Field(id=2)
  public final String zzaap;

  @SafeParcelable.Field(id=9)
  public final boolean zzbta;

  @SafeParcelable.Field(id=5)
  public final boolean zzchg;

  @SafeParcelable.Field(id=8)
  public final zzyb[] zzchh;

  @SafeParcelable.Field(id=10)
  public final boolean zzchi;

  @SafeParcelable.Field(id=11)
  public boolean zzchj;

  public zzyb()
  {
    this("interstitial_mb", 0, 0, true, 0, 0, null, false, false, false);
  }

  public zzyb(Context paramContext, AdSize paramAdSize)
  {
    this(paramContext, new AdSize[] { paramAdSize });
  }

  public zzyb(Context paramContext, AdSize[] paramArrayOfAdSize)
  {
    AdSize localAdSize = paramArrayOfAdSize[0];
    this.zzchg = false;
    this.zzchi = localAdSize.isFluid();
    int i;
    label59: int j;
    label71: DisplayMetrics localDisplayMetrics;
    label129: int m;
    label169: int n;
    if (this.zzchi)
    {
      this.width = AdSize.BANNER.getWidth();
      this.height = AdSize.BANNER.getHeight();
      if (this.width != -1)
        break label311;
      i = 1;
      if (this.height != -2)
        break label317;
      j = 1;
      localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      if (i == 0)
        break label335;
      zzyr.zzpa();
      if (!zzazu.zzbh(paramContext))
        break label323;
      zzyr.zzpa();
      if (!zzazu.zzbi(paramContext))
        break label323;
      int i3 = localDisplayMetrics.widthPixels;
      zzyr.zzpa();
      this.widthPixels = (i3 - zzazu.zzbj(paramContext));
      double d = this.widthPixels / localDisplayMetrics.density;
      int i2 = (int)d;
      if (d - (int)d >= 0.01D)
        i2++;
      m = i2;
      if (j == 0)
        break label365;
      n = zzd(localDisplayMetrics);
      label181: zzyr.zzpa();
      this.heightPixels = zzazu.zza(localDisplayMetrics, n);
      if ((i == 0) && (j == 0))
        break label374;
      this.zzaap = (26 + m + "x" + n + "_as");
    }
    while (true)
    {
      if (paramArrayOfAdSize.length <= 1)
        break label401;
      this.zzchh = new zzyb[paramArrayOfAdSize.length];
      for (int i1 = 0; i1 < paramArrayOfAdSize.length; i1++)
        this.zzchh[i1] = new zzyb(paramContext, paramArrayOfAdSize[i1]);
      this.width = localAdSize.getWidth();
      this.height = localAdSize.getHeight();
      break;
      label311: i = 0;
      break label59;
      label317: j = 0;
      break label71;
      label323: this.widthPixels = localDisplayMetrics.widthPixels;
      break label129;
      label335: int k = this.width;
      zzyr.zzpa();
      this.widthPixels = zzazu.zza(localDisplayMetrics, this.width);
      m = k;
      break label169;
      label365: n = this.height;
      break label181;
      label374: if (this.zzchi)
        this.zzaap = "320x50_mb";
      else
        this.zzaap = localAdSize.toString();
    }
    label401: this.zzchh = null;
    this.zzbta = false;
    this.zzchj = false;
  }

  @SafeParcelable.Constructor
  zzyb(@SafeParcelable.Param(id=2) String paramString, @SafeParcelable.Param(id=3) int paramInt1, @SafeParcelable.Param(id=4) int paramInt2, @SafeParcelable.Param(id=5) boolean paramBoolean1, @SafeParcelable.Param(id=6) int paramInt3, @SafeParcelable.Param(id=7) int paramInt4, @SafeParcelable.Param(id=8) zzyb[] paramArrayOfzzyb, @SafeParcelable.Param(id=9) boolean paramBoolean2, @SafeParcelable.Param(id=10) boolean paramBoolean3, @SafeParcelable.Param(id=11) boolean paramBoolean4)
  {
    this.zzaap = paramString;
    this.height = paramInt1;
    this.heightPixels = paramInt2;
    this.zzchg = paramBoolean1;
    this.width = paramInt3;
    this.widthPixels = paramInt4;
    this.zzchh = paramArrayOfzzyb;
    this.zzbta = paramBoolean2;
    this.zzchi = paramBoolean3;
    this.zzchj = paramBoolean4;
  }

  public static int zzb(DisplayMetrics paramDisplayMetrics)
  {
    return paramDisplayMetrics.widthPixels;
  }

  public static int zzc(DisplayMetrics paramDisplayMetrics)
  {
    return (int)(zzd(paramDisplayMetrics) * paramDisplayMetrics.density);
  }

  private static int zzd(DisplayMetrics paramDisplayMetrics)
  {
    int i = (int)(paramDisplayMetrics.heightPixels / paramDisplayMetrics.density);
    if (i <= 400)
      return 32;
    if (i <= 720)
      return 50;
    return 90;
  }

  public static zzyb zzg(Context paramContext)
  {
    return new zzyb("320x50_mb", 0, 0, false, 0, 0, null, true, false, false);
  }

  public static zzyb zzou()
  {
    return new zzyb("reward_mb", 0, 0, true, 0, 0, null, false, false, false);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzaap, false);
    SafeParcelWriter.writeInt(paramParcel, 3, this.height);
    SafeParcelWriter.writeInt(paramParcel, 4, this.heightPixels);
    SafeParcelWriter.writeBoolean(paramParcel, 5, this.zzchg);
    SafeParcelWriter.writeInt(paramParcel, 6, this.width);
    SafeParcelWriter.writeInt(paramParcel, 7, this.widthPixels);
    SafeParcelWriter.writeTypedArray(paramParcel, 8, this.zzchh, paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 9, this.zzbta);
    SafeParcelWriter.writeBoolean(paramParcel, 10, this.zzchi);
    SafeParcelWriter.writeBoolean(paramParcel, 11, this.zzchj);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzyb
 * JD-Core Version:    0.6.2
 */