package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator="AdResponseParcelCreator")
public final class zzarj extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzarj> CREATOR = new zzark();

  @SafeParcelable.Field(id=5)
  private final int errorCode;

  @SafeParcelable.Field(id=12)
  private final int orientation;

  @SafeParcelable.Field(id=1)
  private final int versionCode;

  @SafeParcelable.Field(id=37)
  private final zzarl zzbqy;

  @SafeParcelable.Field(id=49)
  private final boolean zzbrm;

  @SafeParcelable.Field(id=53)
  private final boolean zzbrn;

  @SafeParcelable.Field(id=23)
  private final boolean zzbta;

  @SafeParcelable.Field(id=30)
  private final String zzceq;

  @SafeParcelable.Field(id=31)
  private final boolean zzchi;

  @SafeParcelable.Field(id=32)
  private final boolean zzchj;

  @SafeParcelable.Field(id=4)
  private final List<String> zzdfg;

  @SafeParcelable.Field(id=6)
  private final List<String> zzdfh;

  @SafeParcelable.Field(id=52)
  private final List<String> zzdfi;

  @SafeParcelable.Field(id=40)
  private final List<String> zzdfk;

  @SafeParcelable.Field(id=42)
  private final boolean zzdfl;

  @SafeParcelable.Field(id=11)
  private final long zzdfn;

  @SafeParcelable.Field(id=2)
  private final String zzdkp;

  @SafeParcelable.Field(id=24)
  private final boolean zzdlu;

  @SafeParcelable.Field(id=38)
  private final boolean zzdmj;

  @SafeParcelable.Field(id=39)
  private String zzdmk;

  @SafeParcelable.Field(id=47)
  private final boolean zzdmw;

  @SafeParcelable.Field(id=3)
  private String zzdnj;

  @SafeParcelable.Field(id=7)
  private final long zzdnk;

  @SafeParcelable.Field(id=8)
  private final boolean zzdnl;

  @SafeParcelable.Field(id=9)
  private final long zzdnm;

  @SafeParcelable.Field(id=10)
  private final List<String> zzdnn;

  @SafeParcelable.Field(id=13)
  private final String zzdno;

  @SafeParcelable.Field(id=14)
  private final long zzdnp;

  @SafeParcelable.Field(id=15)
  private final String zzdnq;

  @SafeParcelable.Field(id=18)
  private final boolean zzdnr;

  @SafeParcelable.Field(id=19)
  private final String zzdns;

  @SafeParcelable.Field(id=21)
  private final String zzdnt;

  @SafeParcelable.Field(id=22)
  private final boolean zzdnu;

  @SafeParcelable.Field(id=25)
  private final boolean zzdnv;

  @SafeParcelable.Field(id=26)
  private final boolean zzdnw;

  @SafeParcelable.Field(id=28)
  private zzarv zzdnx;

  @SafeParcelable.Field(id=29)
  private String zzdny;

  @SafeParcelable.Field(id=33)
  private final zzatp zzdnz;

  @SafeParcelable.Field(id=34)
  private final List<String> zzdoa;

  @SafeParcelable.Field(id=35)
  private final List<String> zzdob;

  @SafeParcelable.Field(id=36)
  private final boolean zzdoc;

  @SafeParcelable.Field(id=43)
  private final String zzdod;

  @SafeParcelable.Field(id=44)
  private final zzauz zzdoe;

  @SafeParcelable.Field(id=45)
  private final String zzdof;

  @SafeParcelable.Field(id=46)
  private final boolean zzdog;

  @SafeParcelable.Field(id=48)
  private Bundle zzdoh;

  @SafeParcelable.Field(id=50)
  private final int zzdoi;

  @SafeParcelable.Field(id=51)
  private final boolean zzdoj;

  @SafeParcelable.Field(id=54)
  private final String zzdok;

  @SafeParcelable.Field(id=55)
  private String zzdol;

  @SafeParcelable.Field(id=56)
  private boolean zzdom;

  @SafeParcelable.Field(id=57)
  private boolean zzdon;

  @SafeParcelable.Constructor
  zzarj(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) String paramString2, @SafeParcelable.Param(id=4) List<String> paramList1, @SafeParcelable.Param(id=5) int paramInt2, @SafeParcelable.Param(id=6) List<String> paramList2, @SafeParcelable.Param(id=7) long paramLong1, @SafeParcelable.Param(id=8) boolean paramBoolean1, @SafeParcelable.Param(id=9) long paramLong2, @SafeParcelable.Param(id=10) List<String> paramList3, @SafeParcelable.Param(id=11) long paramLong3, @SafeParcelable.Param(id=12) int paramInt3, @SafeParcelable.Param(id=13) String paramString3, @SafeParcelable.Param(id=14) long paramLong4, @SafeParcelable.Param(id=15) String paramString4, @SafeParcelable.Param(id=18) boolean paramBoolean2, @SafeParcelable.Param(id=19) String paramString5, @SafeParcelable.Param(id=21) String paramString6, @SafeParcelable.Param(id=22) boolean paramBoolean3, @SafeParcelable.Param(id=23) boolean paramBoolean4, @SafeParcelable.Param(id=24) boolean paramBoolean5, @SafeParcelable.Param(id=25) boolean paramBoolean6, @SafeParcelable.Param(id=26) boolean paramBoolean7, @SafeParcelable.Param(id=28) zzarv paramzzarv, @SafeParcelable.Param(id=29) String paramString7, @SafeParcelable.Param(id=30) String paramString8, @SafeParcelable.Param(id=31) boolean paramBoolean8, @SafeParcelable.Param(id=32) boolean paramBoolean9, @SafeParcelable.Param(id=33) zzatp paramzzatp, @SafeParcelable.Param(id=34) List<String> paramList4, @SafeParcelable.Param(id=35) List<String> paramList5, @SafeParcelable.Param(id=36) boolean paramBoolean10, @SafeParcelable.Param(id=37) zzarl paramzzarl, @SafeParcelable.Param(id=38) boolean paramBoolean11, @SafeParcelable.Param(id=39) String paramString9, @SafeParcelable.Param(id=40) List<String> paramList6, @SafeParcelable.Param(id=42) boolean paramBoolean12, @SafeParcelable.Param(id=43) String paramString10, @SafeParcelable.Param(id=44) zzauz paramzzauz, @SafeParcelable.Param(id=45) String paramString11, @SafeParcelable.Param(id=46) boolean paramBoolean13, @SafeParcelable.Param(id=47) boolean paramBoolean14, @SafeParcelable.Param(id=48) Bundle paramBundle, @SafeParcelable.Param(id=49) boolean paramBoolean15, @SafeParcelable.Param(id=50) int paramInt4, @SafeParcelable.Param(id=51) boolean paramBoolean16, @SafeParcelable.Param(id=52) List<String> paramList7, @SafeParcelable.Param(id=53) boolean paramBoolean17, @SafeParcelable.Param(id=54) String paramString12, @SafeParcelable.Param(id=55) String paramString13, @SafeParcelable.Param(id=56) boolean paramBoolean18, @SafeParcelable.Param(id=57) boolean paramBoolean19)
  {
    this.versionCode = paramInt1;
    this.zzdkp = paramString1;
    this.zzdnj = paramString2;
    List localList1;
    List localList2;
    label55: List localList3;
    if (paramList1 != null)
    {
      localList1 = Collections.unmodifiableList(paramList1);
      this.zzdfg = localList1;
      this.errorCode = paramInt2;
      if (paramList2 == null)
        break label422;
      localList2 = Collections.unmodifiableList(paramList2);
      this.zzdfh = localList2;
      this.zzdnk = paramLong1;
      this.zzdnl = paramBoolean1;
      this.zzdnm = paramLong2;
      if (paramList3 == null)
        break label428;
      localList3 = Collections.unmodifiableList(paramList3);
      label91: this.zzdnn = localList3;
      this.zzdfn = paramLong3;
      this.orientation = paramInt3;
      this.zzdno = paramString3;
      this.zzdnp = paramLong4;
      this.zzdnq = paramString4;
      this.zzdnr = paramBoolean2;
      this.zzdns = paramString5;
      this.zzdnt = paramString6;
      this.zzdnu = paramBoolean3;
      this.zzbta = paramBoolean4;
      this.zzdlu = paramBoolean5;
      this.zzdnv = paramBoolean6;
      this.zzdog = paramBoolean13;
      this.zzdnw = paramBoolean7;
      this.zzdnx = paramzzarv;
      this.zzdny = paramString7;
      this.zzceq = paramString8;
      if ((this.zzdnj == null) && (this.zzdnx != null))
      {
        zzasa localzzasa = (zzasa)this.zzdnx.zza(zzasa.CREATOR);
        if ((localzzasa != null) && (!TextUtils.isEmpty(localzzasa.zzdoy)))
          this.zzdnj = localzzasa.zzdoy;
      }
      this.zzchi = paramBoolean8;
      this.zzchj = paramBoolean9;
      this.zzdnz = paramzzatp;
      this.zzdoa = paramList4;
      this.zzdob = paramList5;
      this.zzdoc = paramBoolean10;
      this.zzbqy = paramzzarl;
      this.zzdmj = paramBoolean11;
      this.zzdmk = paramString9;
      this.zzdfk = paramList6;
      this.zzdfl = paramBoolean12;
      this.zzdod = paramString10;
      this.zzdoe = paramzzauz;
      this.zzdof = paramString11;
      this.zzdmw = paramBoolean14;
      this.zzdoh = paramBundle;
      this.zzbrm = paramBoolean15;
      this.zzdoi = paramInt4;
      this.zzdoj = paramBoolean16;
      if (paramList7 == null)
        break label434;
    }
    label422: label428: label434: for (List localList4 = Collections.unmodifiableList(paramList7); ; localList4 = null)
    {
      this.zzdfi = localList4;
      this.zzbrn = paramBoolean17;
      this.zzdok = paramString12;
      this.zzdol = paramString13;
      this.zzdom = paramBoolean18;
      this.zzdon = paramBoolean19;
      return;
      localList1 = null;
      break;
      localList2 = null;
      break label55;
      localList3 = null;
      break label91;
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzdkp, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.zzdnj, false);
    SafeParcelWriter.writeStringList(paramParcel, 4, this.zzdfg, false);
    SafeParcelWriter.writeInt(paramParcel, 5, this.errorCode);
    SafeParcelWriter.writeStringList(paramParcel, 6, this.zzdfh, false);
    SafeParcelWriter.writeLong(paramParcel, 7, this.zzdnk);
    SafeParcelWriter.writeBoolean(paramParcel, 8, this.zzdnl);
    SafeParcelWriter.writeLong(paramParcel, 9, this.zzdnm);
    SafeParcelWriter.writeStringList(paramParcel, 10, this.zzdnn, false);
    SafeParcelWriter.writeLong(paramParcel, 11, this.zzdfn);
    SafeParcelWriter.writeInt(paramParcel, 12, this.orientation);
    SafeParcelWriter.writeString(paramParcel, 13, this.zzdno, false);
    SafeParcelWriter.writeLong(paramParcel, 14, this.zzdnp);
    SafeParcelWriter.writeString(paramParcel, 15, this.zzdnq, false);
    SafeParcelWriter.writeBoolean(paramParcel, 18, this.zzdnr);
    SafeParcelWriter.writeString(paramParcel, 19, this.zzdns, false);
    SafeParcelWriter.writeString(paramParcel, 21, this.zzdnt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 22, this.zzdnu);
    SafeParcelWriter.writeBoolean(paramParcel, 23, this.zzbta);
    SafeParcelWriter.writeBoolean(paramParcel, 24, this.zzdlu);
    SafeParcelWriter.writeBoolean(paramParcel, 25, this.zzdnv);
    SafeParcelWriter.writeBoolean(paramParcel, 26, this.zzdnw);
    SafeParcelWriter.writeParcelable(paramParcel, 28, this.zzdnx, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 29, this.zzdny, false);
    SafeParcelWriter.writeString(paramParcel, 30, this.zzceq, false);
    SafeParcelWriter.writeBoolean(paramParcel, 31, this.zzchi);
    SafeParcelWriter.writeBoolean(paramParcel, 32, this.zzchj);
    SafeParcelWriter.writeParcelable(paramParcel, 33, this.zzdnz, paramInt, false);
    SafeParcelWriter.writeStringList(paramParcel, 34, this.zzdoa, false);
    SafeParcelWriter.writeStringList(paramParcel, 35, this.zzdob, false);
    SafeParcelWriter.writeBoolean(paramParcel, 36, this.zzdoc);
    SafeParcelWriter.writeParcelable(paramParcel, 37, this.zzbqy, paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 38, this.zzdmj);
    SafeParcelWriter.writeString(paramParcel, 39, this.zzdmk, false);
    SafeParcelWriter.writeStringList(paramParcel, 40, this.zzdfk, false);
    SafeParcelWriter.writeBoolean(paramParcel, 42, this.zzdfl);
    SafeParcelWriter.writeString(paramParcel, 43, this.zzdod, false);
    SafeParcelWriter.writeParcelable(paramParcel, 44, this.zzdoe, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 45, this.zzdof, false);
    SafeParcelWriter.writeBoolean(paramParcel, 46, this.zzdog);
    SafeParcelWriter.writeBoolean(paramParcel, 47, this.zzdmw);
    SafeParcelWriter.writeBundle(paramParcel, 48, this.zzdoh, false);
    SafeParcelWriter.writeBoolean(paramParcel, 49, this.zzbrm);
    SafeParcelWriter.writeInt(paramParcel, 50, this.zzdoi);
    SafeParcelWriter.writeBoolean(paramParcel, 51, this.zzdoj);
    SafeParcelWriter.writeStringList(paramParcel, 52, this.zzdfi, false);
    SafeParcelWriter.writeBoolean(paramParcel, 53, this.zzbrn);
    SafeParcelWriter.writeString(paramParcel, 54, this.zzdok, false);
    SafeParcelWriter.writeString(paramParcel, 55, this.zzdol, false);
    SafeParcelWriter.writeBoolean(paramParcel, 56, this.zzdom);
    SafeParcelWriter.writeBoolean(paramParcel, 57, this.zzdon);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzarj
 * JD-Core Version:    0.6.2
 */