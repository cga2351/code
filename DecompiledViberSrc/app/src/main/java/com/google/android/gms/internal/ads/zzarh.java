package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator="AdRequestInfoParcelCreator")
public final class zzarh extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzarh> CREATOR = new zzari();

  @SafeParcelable.Field(id=6)
  private final ApplicationInfo applicationInfo;

  @SafeParcelable.Field(id=1)
  private final int versionCode;

  @SafeParcelable.Field(id=11)
  private final zzbaj zzbtd;

  @SafeParcelable.Field(id=20)
  private final float zzbty;

  @SafeParcelable.Field(id=5)
  private final String zzchl;

  @SafeParcelable.Field(id=10)
  private final String zzcih;

  @SafeParcelable.Field(id=42)
  private final boolean zzdfl;

  @SafeParcelable.Field(id=29)
  private final zzadx zzdgu;

  @SafeParcelable.Field(id=14)
  private final List<String> zzdgv;

  @SafeParcelable.Field(id=2)
  private final Bundle zzdll;

  @SafeParcelable.Field(id=3)
  private final zzxx zzdlm;

  @SafeParcelable.Field(id=4)
  private final zzyb zzdln;

  @SafeParcelable.Field(id=7)
  private final PackageInfo zzdlo;

  @SafeParcelable.Field(id=8)
  private final String zzdlp;

  @SafeParcelable.Field(id=9)
  private final String zzdlq;

  @SafeParcelable.Field(id=12)
  private final Bundle zzdlr;

  @SafeParcelable.Field(id=13)
  private final int zzdls;

  @SafeParcelable.Field(id=15)
  private final Bundle zzdlt;

  @SafeParcelable.Field(id=16)
  private final boolean zzdlu;

  @SafeParcelable.Field(id=18)
  private final int zzdlv;

  @SafeParcelable.Field(id=19)
  private final int zzdlw;

  @SafeParcelable.Field(id=21)
  private final String zzdlx;

  @SafeParcelable.Field(id=25)
  private final long zzdly;

  @SafeParcelable.Field(id=26)
  private final String zzdlz;

  @SafeParcelable.Field(id=27)
  private final List<String> zzdma;

  @SafeParcelable.Field(id=28)
  private final String zzdmb;

  @SafeParcelable.Field(id=30)
  private final List<String> zzdmc;

  @SafeParcelable.Field(id=31)
  private final long zzdmd;

  @SafeParcelable.Field(id=33)
  private final String zzdme;

  @SafeParcelable.Field(id=34)
  private final float zzdmf;

  @SafeParcelable.Field(id=35)
  private final int zzdmg;

  @SafeParcelable.Field(id=36)
  private final int zzdmh;

  @SafeParcelable.Field(id=37)
  private final boolean zzdmi;

  @SafeParcelable.Field(id=38)
  private final boolean zzdmj;

  @SafeParcelable.Field(id=39)
  private final String zzdmk;

  @SafeParcelable.Field(id=40)
  private final boolean zzdml;

  @SafeParcelable.Field(id=41)
  private final String zzdmm;

  @SafeParcelable.Field(id=43)
  private final int zzdmn;

  @SafeParcelable.Field(id=44)
  private final Bundle zzdmo;

  @SafeParcelable.Field(id=45)
  private final String zzdmp;

  @SafeParcelable.Field(id=46)
  private final zzaav zzdmq;

  @SafeParcelable.Field(id=47)
  private final boolean zzdmr;

  @SafeParcelable.Field(id=48)
  private final Bundle zzdms;

  @SafeParcelable.Field(id=49)
  private final String zzdmt;

  @SafeParcelable.Field(id=50)
  private final String zzdmu;

  @SafeParcelable.Field(id=51)
  private final String zzdmv;

  @SafeParcelable.Field(id=52)
  private final boolean zzdmw;

  @SafeParcelable.Field(id=53)
  private final List<Integer> zzdmx;

  @SafeParcelable.Field(id=54)
  private final String zzdmy;

  @SafeParcelable.Field(id=55)
  private final List<String> zzdmz;

  @SafeParcelable.Field(id=56)
  private final int zzdna;

  @SafeParcelable.Field(id=57)
  private final boolean zzdnb;

  @SafeParcelable.Field(id=58)
  private final boolean zzdnc;

  @SafeParcelable.Field(id=59)
  private final boolean zzdnd;

  @SafeParcelable.Field(id=60)
  private final ArrayList<String> zzdne;

  @SafeParcelable.Field(id=61)
  private final String zzdnf;

  @SafeParcelable.Field(id=63)
  private final zzaiz zzdng;

  @SafeParcelable.Field(id=64)
  private final String zzdnh;

  @SafeParcelable.Field(id=65)
  private final Bundle zzdni;

  @SafeParcelable.Constructor
  zzarh(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) Bundle paramBundle1, @SafeParcelable.Param(id=3) zzxx paramzzxx, @SafeParcelable.Param(id=4) zzyb paramzzyb, @SafeParcelable.Param(id=5) String paramString1, @SafeParcelable.Param(id=6) ApplicationInfo paramApplicationInfo, @SafeParcelable.Param(id=7) PackageInfo paramPackageInfo, @SafeParcelable.Param(id=8) String paramString2, @SafeParcelable.Param(id=9) String paramString3, @SafeParcelable.Param(id=10) String paramString4, @SafeParcelable.Param(id=11) zzbaj paramzzbaj, @SafeParcelable.Param(id=12) Bundle paramBundle2, @SafeParcelable.Param(id=13) int paramInt2, @SafeParcelable.Param(id=14) List<String> paramList1, @SafeParcelable.Param(id=15) Bundle paramBundle3, @SafeParcelable.Param(id=16) boolean paramBoolean1, @SafeParcelable.Param(id=18) int paramInt3, @SafeParcelable.Param(id=19) int paramInt4, @SafeParcelable.Param(id=20) float paramFloat1, @SafeParcelable.Param(id=21) String paramString5, @SafeParcelable.Param(id=25) long paramLong1, @SafeParcelable.Param(id=26) String paramString6, @SafeParcelable.Param(id=27) List<String> paramList2, @SafeParcelable.Param(id=28) String paramString7, @SafeParcelable.Param(id=29) zzadx paramzzadx, @SafeParcelable.Param(id=30) List<String> paramList3, @SafeParcelable.Param(id=31) long paramLong2, @SafeParcelable.Param(id=33) String paramString8, @SafeParcelable.Param(id=34) float paramFloat2, @SafeParcelable.Param(id=40) boolean paramBoolean2, @SafeParcelable.Param(id=35) int paramInt5, @SafeParcelable.Param(id=36) int paramInt6, @SafeParcelable.Param(id=37) boolean paramBoolean3, @SafeParcelable.Param(id=38) boolean paramBoolean4, @SafeParcelable.Param(id=39) String paramString9, @SafeParcelable.Param(id=41) String paramString10, @SafeParcelable.Param(id=42) boolean paramBoolean5, @SafeParcelable.Param(id=43) int paramInt7, @SafeParcelable.Param(id=44) Bundle paramBundle4, @SafeParcelable.Param(id=45) String paramString11, @SafeParcelable.Param(id=46) zzaav paramzzaav, @SafeParcelable.Param(id=47) boolean paramBoolean6, @SafeParcelable.Param(id=48) Bundle paramBundle5, @SafeParcelable.Param(id=49) String paramString12, @SafeParcelable.Param(id=50) String paramString13, @SafeParcelable.Param(id=51) String paramString14, @SafeParcelable.Param(id=52) boolean paramBoolean7, @SafeParcelable.Param(id=53) List<Integer> paramList, @SafeParcelable.Param(id=54) String paramString15, @SafeParcelable.Param(id=55) List<String> paramList4, @SafeParcelable.Param(id=56) int paramInt8, @SafeParcelable.Param(id=57) boolean paramBoolean8, @SafeParcelable.Param(id=58) boolean paramBoolean9, @SafeParcelable.Param(id=59) boolean paramBoolean10, @SafeParcelable.Param(id=60) ArrayList<String> paramArrayList, @SafeParcelable.Param(id=61) String paramString16, @SafeParcelable.Param(id=63) zzaiz paramzzaiz, @SafeParcelable.Param(id=64) String paramString17, @SafeParcelable.Param(id=65) Bundle paramBundle6)
  {
    this.versionCode = paramInt1;
    this.zzdll = paramBundle1;
    this.zzdlm = paramzzxx;
    this.zzdln = paramzzyb;
    this.zzchl = paramString1;
    this.applicationInfo = paramApplicationInfo;
    this.zzdlo = paramPackageInfo;
    this.zzdlp = paramString2;
    this.zzdlq = paramString3;
    this.zzcih = paramString4;
    this.zzbtd = paramzzbaj;
    this.zzdlr = paramBundle2;
    this.zzdls = paramInt2;
    this.zzdgv = paramList1;
    List localList1;
    if (paramList3 == null)
    {
      localList1 = Collections.emptyList();
      this.zzdmc = localList1;
      this.zzdlt = paramBundle3;
      this.zzdlu = paramBoolean1;
      this.zzdlv = paramInt3;
      this.zzdlw = paramInt4;
      this.zzbty = paramFloat1;
      this.zzdlx = paramString5;
      this.zzdly = paramLong1;
      this.zzdlz = paramString6;
      if (paramList2 != null)
        break label386;
    }
    label386: for (List localList2 = Collections.emptyList(); ; localList2 = Collections.unmodifiableList(paramList2))
    {
      this.zzdma = localList2;
      this.zzdmb = paramString7;
      this.zzdgu = paramzzadx;
      this.zzdmd = paramLong2;
      this.zzdme = paramString8;
      this.zzdmf = paramFloat2;
      this.zzdml = paramBoolean2;
      this.zzdmg = paramInt5;
      this.zzdmh = paramInt6;
      this.zzdmi = paramBoolean3;
      this.zzdmj = paramBoolean4;
      this.zzdmk = paramString9;
      this.zzdmm = paramString10;
      this.zzdfl = paramBoolean5;
      this.zzdmn = paramInt7;
      this.zzdmo = paramBundle4;
      this.zzdmp = paramString11;
      this.zzdmq = paramzzaav;
      this.zzdmr = paramBoolean6;
      this.zzdms = paramBundle5;
      this.zzdmt = paramString12;
      this.zzdmu = paramString13;
      this.zzdmv = paramString14;
      this.zzdmw = paramBoolean7;
      this.zzdmx = paramList;
      this.zzdmy = paramString15;
      this.zzdmz = paramList4;
      this.zzdna = paramInt8;
      this.zzdnb = paramBoolean8;
      this.zzdnc = paramBoolean9;
      this.zzdnd = paramBoolean10;
      this.zzdne = paramArrayList;
      this.zzdnf = paramString16;
      this.zzdng = paramzzaiz;
      this.zzdnh = paramString17;
      this.zzdni = paramBundle6;
      return;
      localList1 = Collections.unmodifiableList(paramList3);
      break;
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeBundle(paramParcel, 2, this.zzdll, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.zzdlm, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 4, this.zzdln, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 5, this.zzchl, false);
    SafeParcelWriter.writeParcelable(paramParcel, 6, this.applicationInfo, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 7, this.zzdlo, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 8, this.zzdlp, false);
    SafeParcelWriter.writeString(paramParcel, 9, this.zzdlq, false);
    SafeParcelWriter.writeString(paramParcel, 10, this.zzcih, false);
    SafeParcelWriter.writeParcelable(paramParcel, 11, this.zzbtd, paramInt, false);
    SafeParcelWriter.writeBundle(paramParcel, 12, this.zzdlr, false);
    SafeParcelWriter.writeInt(paramParcel, 13, this.zzdls);
    SafeParcelWriter.writeStringList(paramParcel, 14, this.zzdgv, false);
    SafeParcelWriter.writeBundle(paramParcel, 15, this.zzdlt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 16, this.zzdlu);
    SafeParcelWriter.writeInt(paramParcel, 18, this.zzdlv);
    SafeParcelWriter.writeInt(paramParcel, 19, this.zzdlw);
    SafeParcelWriter.writeFloat(paramParcel, 20, this.zzbty);
    SafeParcelWriter.writeString(paramParcel, 21, this.zzdlx, false);
    SafeParcelWriter.writeLong(paramParcel, 25, this.zzdly);
    SafeParcelWriter.writeString(paramParcel, 26, this.zzdlz, false);
    SafeParcelWriter.writeStringList(paramParcel, 27, this.zzdma, false);
    SafeParcelWriter.writeString(paramParcel, 28, this.zzdmb, false);
    SafeParcelWriter.writeParcelable(paramParcel, 29, this.zzdgu, paramInt, false);
    SafeParcelWriter.writeStringList(paramParcel, 30, this.zzdmc, false);
    SafeParcelWriter.writeLong(paramParcel, 31, this.zzdmd);
    SafeParcelWriter.writeString(paramParcel, 33, this.zzdme, false);
    SafeParcelWriter.writeFloat(paramParcel, 34, this.zzdmf);
    SafeParcelWriter.writeInt(paramParcel, 35, this.zzdmg);
    SafeParcelWriter.writeInt(paramParcel, 36, this.zzdmh);
    SafeParcelWriter.writeBoolean(paramParcel, 37, this.zzdmi);
    SafeParcelWriter.writeBoolean(paramParcel, 38, this.zzdmj);
    SafeParcelWriter.writeString(paramParcel, 39, this.zzdmk, false);
    SafeParcelWriter.writeBoolean(paramParcel, 40, this.zzdml);
    SafeParcelWriter.writeString(paramParcel, 41, this.zzdmm, false);
    SafeParcelWriter.writeBoolean(paramParcel, 42, this.zzdfl);
    SafeParcelWriter.writeInt(paramParcel, 43, this.zzdmn);
    SafeParcelWriter.writeBundle(paramParcel, 44, this.zzdmo, false);
    SafeParcelWriter.writeString(paramParcel, 45, this.zzdmp, false);
    SafeParcelWriter.writeParcelable(paramParcel, 46, this.zzdmq, paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 47, this.zzdmr);
    SafeParcelWriter.writeBundle(paramParcel, 48, this.zzdms, false);
    SafeParcelWriter.writeString(paramParcel, 49, this.zzdmt, false);
    SafeParcelWriter.writeString(paramParcel, 50, this.zzdmu, false);
    SafeParcelWriter.writeString(paramParcel, 51, this.zzdmv, false);
    SafeParcelWriter.writeBoolean(paramParcel, 52, this.zzdmw);
    SafeParcelWriter.writeIntegerList(paramParcel, 53, this.zzdmx, false);
    SafeParcelWriter.writeString(paramParcel, 54, this.zzdmy, false);
    SafeParcelWriter.writeStringList(paramParcel, 55, this.zzdmz, false);
    SafeParcelWriter.writeInt(paramParcel, 56, this.zzdna);
    SafeParcelWriter.writeBoolean(paramParcel, 57, this.zzdnb);
    SafeParcelWriter.writeBoolean(paramParcel, 58, this.zzdnc);
    SafeParcelWriter.writeBoolean(paramParcel, 59, this.zzdnd);
    SafeParcelWriter.writeStringList(paramParcel, 60, this.zzdne, false);
    SafeParcelWriter.writeString(paramParcel, 61, this.zzdnf, false);
    SafeParcelWriter.writeParcelable(paramParcel, 63, this.zzdng, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 64, this.zzdnh, false);
    SafeParcelWriter.writeBundle(paramParcel, 65, this.zzdni, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzarh
 * JD-Core Version:    0.6.2
 */