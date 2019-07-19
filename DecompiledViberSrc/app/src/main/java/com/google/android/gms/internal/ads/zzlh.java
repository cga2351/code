package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class zzlh
  implements Parcelable
{
  public static final Parcelable.Creator<zzlh> CREATOR = new zzli();
  public final int height;
  public final int width;
  public final int zzafs;
  public final float zzaft;
  public final int zzafu;
  public final int zzafv;
  public final List<byte[]> zzafw;
  private int zzafx;
  private final String zzatl;
  public final int zzatm;
  public final String zzatn;
  private final zzpo zzato;
  private final String zzatp;
  public final String zzatq;
  public final zzne zzatr;
  public final float zzats;
  public final int zzatt;
  private final int zzatu;
  private final byte[] zzatv;
  private final zztb zzatw;
  public final int zzatx;
  private final int zzaty;
  private final int zzatz;
  public final long zzaua;
  public final int zzaub;
  public final String zzauc;
  private final int zzaud;

  zzlh(Parcel paramParcel)
  {
    this.zzatl = paramParcel.readString();
    this.zzatp = paramParcel.readString();
    this.zzatq = paramParcel.readString();
    this.zzatn = paramParcel.readString();
    this.zzatm = paramParcel.readInt();
    this.zzafs = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.zzats = paramParcel.readFloat();
    this.zzatt = paramParcel.readInt();
    this.zzaft = paramParcel.readFloat();
    int i;
    if (paramParcel.readInt() != 0)
    {
      i = 1;
      if (i == 0)
        break label265;
    }
    label265: for (byte[] arrayOfByte = paramParcel.createByteArray(); ; arrayOfByte = null)
    {
      this.zzatv = arrayOfByte;
      this.zzatu = paramParcel.readInt();
      this.zzatw = ((zztb)paramParcel.readParcelable(zztb.class.getClassLoader()));
      this.zzafu = paramParcel.readInt();
      this.zzafv = paramParcel.readInt();
      this.zzatx = paramParcel.readInt();
      this.zzaty = paramParcel.readInt();
      this.zzatz = paramParcel.readInt();
      this.zzaub = paramParcel.readInt();
      this.zzauc = paramParcel.readString();
      this.zzaud = paramParcel.readInt();
      this.zzaua = paramParcel.readLong();
      int j = paramParcel.readInt();
      this.zzafw = new ArrayList(j);
      for (int k = 0; k < j; k++)
        this.zzafw.add(paramParcel.createByteArray());
      i = 0;
      break;
    }
    this.zzatr = ((zzne)paramParcel.readParcelable(zzne.class.getClassLoader()));
    this.zzato = ((zzpo)paramParcel.readParcelable(zzpo.class.getClassLoader()));
  }

  private zzlh(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, int paramInt5, float paramFloat2, byte[] paramArrayOfByte, int paramInt6, zztb paramzztb, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, String paramString5, int paramInt13, long paramLong, List<byte[]> paramList, zzne paramzzne, zzpo paramzzpo)
  {
    this.zzatl = paramString1;
    this.zzatp = paramString2;
    this.zzatq = paramString3;
    this.zzatn = paramString4;
    this.zzatm = paramInt1;
    this.zzafs = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
    this.zzats = paramFloat1;
    this.zzatt = paramInt5;
    this.zzaft = paramFloat2;
    this.zzatv = paramArrayOfByte;
    this.zzatu = paramInt6;
    this.zzatw = paramzztb;
    this.zzafu = paramInt7;
    this.zzafv = paramInt8;
    this.zzatx = paramInt9;
    this.zzaty = paramInt10;
    this.zzatz = paramInt11;
    this.zzaub = paramInt12;
    this.zzauc = paramString5;
    this.zzaud = paramInt13;
    this.zzaua = paramLong;
    if (paramList == null)
      paramList = Collections.emptyList();
    this.zzafw = paramList;
    this.zzatr = paramzzne;
    this.zzato = paramzzpo;
  }

  public static zzlh zza(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, List<byte[]> paramList, int paramInt5, float paramFloat2, byte[] paramArrayOfByte, int paramInt6, zztb paramzztb, zzne paramzzne)
  {
    return new zzlh(paramString1, null, paramString2, null, -1, paramInt2, paramInt3, paramInt4, -1.0F, paramInt5, paramFloat2, paramArrayOfByte, paramInt6, paramzztb, -1, -1, -1, -1, -1, 0, null, -1, 9223372036854775807L, paramList, paramzzne, null);
  }

  public static zzlh zza(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, List<byte[]> paramList, zzne paramzzne, int paramInt6, String paramString4)
  {
    return new zzlh(paramString1, null, paramString2, null, -1, paramInt2, -1, -1, -1.0F, -1, -1.0F, null, -1, null, paramInt3, paramInt4, paramInt5, -1, -1, paramInt6, paramString4, -1, 9223372036854775807L, paramList, paramzzne, null);
  }

  public static zzlh zza(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<byte[]> paramList, zzne paramzzne, int paramInt5, String paramString4)
  {
    return zza(paramString1, paramString2, null, -1, -1, paramInt3, paramInt4, -1, null, paramzzne, 0, paramString4);
  }

  public static zzlh zza(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3, zzne paramzzne, long paramLong, List<byte[]> paramList)
  {
    return new zzlh(paramString1, null, paramString2, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt2, paramString4, -1, paramLong, paramList, paramzzne, null);
  }

  public static zzlh zza(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, zzne paramzzne)
  {
    return zza(paramString1, paramString2, null, -1, paramInt2, paramString4, -1, paramzzne, 9223372036854775807L, Collections.emptyList());
  }

  public static zzlh zza(String paramString1, String paramString2, String paramString3, int paramInt, zzne paramzzne)
  {
    return new zzlh(paramString1, null, paramString2, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, 9223372036854775807L, null, null, null);
  }

  public static zzlh zza(String paramString1, String paramString2, String paramString3, int paramInt, List<byte[]> paramList, String paramString4, zzne paramzzne)
  {
    return new zzlh(paramString1, null, paramString2, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, paramString4, -1, 9223372036854775807L, paramList, paramzzne, null);
  }

  @TargetApi(16)
  private static void zza(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    if (paramInt != -1)
      paramMediaFormat.setInteger(paramString, paramInt);
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    zzlh localzzlh;
    int i22;
    int i23;
    do
    {
      boolean bool13;
      do
      {
        boolean bool12;
        do
        {
          boolean bool11;
          do
          {
            boolean bool10;
            do
            {
              boolean bool9;
              do
              {
                boolean bool8;
                do
                {
                  boolean bool7;
                  do
                  {
                    int i20;
                    int i21;
                    do
                    {
                      boolean bool6;
                      do
                      {
                        boolean bool5;
                        do
                        {
                          int i18;
                          int i19;
                          do
                          {
                            boolean bool4;
                            do
                            {
                              int i16;
                              int i17;
                              do
                              {
                                int i14;
                                int i15;
                                do
                                {
                                  int i12;
                                  int i13;
                                  do
                                  {
                                    int i10;
                                    int i11;
                                    do
                                    {
                                      int i8;
                                      int i9;
                                      do
                                      {
                                        int i6;
                                        int i7;
                                        do
                                        {
                                          boolean bool3;
                                          do
                                          {
                                            int i4;
                                            int i5;
                                            do
                                            {
                                              boolean bool2;
                                              do
                                              {
                                                int i2;
                                                int i3;
                                                do
                                                {
                                                  int n;
                                                  int i1;
                                                  do
                                                  {
                                                    int k;
                                                    int m;
                                                    do
                                                    {
                                                      int i;
                                                      int j;
                                                      do
                                                      {
                                                        Class localClass1;
                                                        Class localClass2;
                                                        do
                                                        {
                                                          do
                                                          {
                                                            return bool1;
                                                            bool1 = false;
                                                          }
                                                          while (paramObject == null);
                                                          localClass1 = getClass();
                                                          localClass2 = paramObject.getClass();
                                                          bool1 = false;
                                                        }
                                                        while (localClass1 != localClass2);
                                                        localzzlh = (zzlh)paramObject;
                                                        i = this.zzatm;
                                                        j = localzzlh.zzatm;
                                                        bool1 = false;
                                                      }
                                                      while (i != j);
                                                      k = this.zzafs;
                                                      m = localzzlh.zzafs;
                                                      bool1 = false;
                                                    }
                                                    while (k != m);
                                                    n = this.width;
                                                    i1 = localzzlh.width;
                                                    bool1 = false;
                                                  }
                                                  while (n != i1);
                                                  i2 = this.height;
                                                  i3 = localzzlh.height;
                                                  bool1 = false;
                                                }
                                                while (i2 != i3);
                                                bool2 = this.zzats < localzzlh.zzats;
                                                bool1 = false;
                                              }
                                              while (bool2);
                                              i4 = this.zzatt;
                                              i5 = localzzlh.zzatt;
                                              bool1 = false;
                                            }
                                            while (i4 != i5);
                                            bool3 = this.zzaft < localzzlh.zzaft;
                                            bool1 = false;
                                          }
                                          while (bool3);
                                          i6 = this.zzatu;
                                          i7 = localzzlh.zzatu;
                                          bool1 = false;
                                        }
                                        while (i6 != i7);
                                        i8 = this.zzafu;
                                        i9 = localzzlh.zzafu;
                                        bool1 = false;
                                      }
                                      while (i8 != i9);
                                      i10 = this.zzafv;
                                      i11 = localzzlh.zzafv;
                                      bool1 = false;
                                    }
                                    while (i10 != i11);
                                    i12 = this.zzatx;
                                    i13 = localzzlh.zzatx;
                                    bool1 = false;
                                  }
                                  while (i12 != i13);
                                  i14 = this.zzaty;
                                  i15 = localzzlh.zzaty;
                                  bool1 = false;
                                }
                                while (i14 != i15);
                                i16 = this.zzatz;
                                i17 = localzzlh.zzatz;
                                bool1 = false;
                              }
                              while (i16 != i17);
                              bool4 = this.zzaua < localzzlh.zzaua;
                              bool1 = false;
                            }
                            while (bool4);
                            i18 = this.zzaub;
                            i19 = localzzlh.zzaub;
                            bool1 = false;
                          }
                          while (i18 != i19);
                          bool5 = zzsy.zza(this.zzatl, localzzlh.zzatl);
                          bool1 = false;
                        }
                        while (!bool5);
                        bool6 = zzsy.zza(this.zzauc, localzzlh.zzauc);
                        bool1 = false;
                      }
                      while (!bool6);
                      i20 = this.zzaud;
                      i21 = localzzlh.zzaud;
                      bool1 = false;
                    }
                    while (i20 != i21);
                    bool7 = zzsy.zza(this.zzatp, localzzlh.zzatp);
                    bool1 = false;
                  }
                  while (!bool7);
                  bool8 = zzsy.zza(this.zzatq, localzzlh.zzatq);
                  bool1 = false;
                }
                while (!bool8);
                bool9 = zzsy.zza(this.zzatn, localzzlh.zzatn);
                bool1 = false;
              }
              while (!bool9);
              bool10 = zzsy.zza(this.zzatr, localzzlh.zzatr);
              bool1 = false;
            }
            while (!bool10);
            bool11 = zzsy.zza(this.zzato, localzzlh.zzato);
            bool1 = false;
          }
          while (!bool11);
          bool12 = zzsy.zza(this.zzatw, localzzlh.zzatw);
          bool1 = false;
        }
        while (!bool12);
        bool13 = Arrays.equals(this.zzatv, localzzlh.zzatv);
        bool1 = false;
      }
      while (!bool13);
      i22 = this.zzafw.size();
      i23 = localzzlh.zzafw.size();
      bool1 = false;
    }
    while (i22 != i23);
    for (int i24 = 0; ; i24++)
    {
      if (i24 >= this.zzafw.size())
        break label668;
      boolean bool14 = Arrays.equals((byte[])this.zzafw.get(i24), (byte[])localzzlh.zzafw.get(i24));
      bool1 = false;
      if (!bool14)
        break;
    }
    label668: return true;
  }

  public final int hashCode()
  {
    int i;
    int k;
    label34: int n;
    label52: int i2;
    label72: int i4;
    label132: int i6;
    label160: int i7;
    int i8;
    if (this.zzafx == 0)
    {
      if (this.zzatl != null)
        break label198;
      i = 0;
      int j = 31 * (i + 527);
      if (this.zzatp != null)
        break label209;
      k = 0;
      int m = 31 * (k + j);
      if (this.zzatq != null)
        break label220;
      n = 0;
      int i1 = 31 * (n + m);
      if (this.zzatn != null)
        break label232;
      i2 = 0;
      int i3 = 31 * (31 * (31 * (31 * (31 * (31 * (i2 + i1) + this.zzatm) + this.width) + this.height) + this.zzafu) + this.zzafv);
      if (this.zzauc != null)
        break label244;
      i4 = 0;
      int i5 = 31 * (31 * (i4 + i3) + this.zzaud);
      if (this.zzatr != null)
        break label256;
      i6 = 0;
      i7 = 31 * (i6 + i5);
      zzpo localzzpo = this.zzato;
      i8 = 0;
      if (localzzpo != null)
        break label268;
    }
    while (true)
    {
      this.zzafx = (i7 + i8);
      return this.zzafx;
      label198: i = this.zzatl.hashCode();
      break;
      label209: k = this.zzatp.hashCode();
      break label34;
      label220: n = this.zzatq.hashCode();
      break label52;
      label232: i2 = this.zzatn.hashCode();
      break label72;
      label244: i4 = this.zzauc.hashCode();
      break label132;
      label256: i6 = this.zzatr.hashCode();
      break label160;
      label268: i8 = this.zzato.hashCode();
    }
  }

  public final String toString()
  {
    String str1 = this.zzatl;
    String str2 = this.zzatp;
    String str3 = this.zzatq;
    int i = this.zzatm;
    String str4 = this.zzauc;
    int j = this.width;
    int k = this.height;
    float f = this.zzats;
    int m = this.zzafu;
    int n = this.zzafv;
    return 100 + String.valueOf(str1).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + "Format(" + str1 + ", " + str2 + ", " + str3 + ", " + i + ", " + str4 + ", [" + j + ", " + k + ", " + f + "], [" + m + ", " + n + "])";
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.zzatl);
    paramParcel.writeString(this.zzatp);
    paramParcel.writeString(this.zzatq);
    paramParcel.writeString(this.zzatn);
    paramParcel.writeInt(this.zzatm);
    paramParcel.writeInt(this.zzafs);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeFloat(this.zzats);
    paramParcel.writeInt(this.zzatt);
    paramParcel.writeFloat(this.zzaft);
    if (this.zzatv != null);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      if (this.zzatv != null)
        paramParcel.writeByteArray(this.zzatv);
      paramParcel.writeInt(this.zzatu);
      paramParcel.writeParcelable(this.zzatw, paramInt);
      paramParcel.writeInt(this.zzafu);
      paramParcel.writeInt(this.zzafv);
      paramParcel.writeInt(this.zzatx);
      paramParcel.writeInt(this.zzaty);
      paramParcel.writeInt(this.zzatz);
      paramParcel.writeInt(this.zzaub);
      paramParcel.writeString(this.zzauc);
      paramParcel.writeInt(this.zzaud);
      paramParcel.writeLong(this.zzaua);
      int j = this.zzafw.size();
      paramParcel.writeInt(j);
      for (int k = 0; k < j; k++)
        paramParcel.writeByteArray((byte[])this.zzafw.get(k));
    }
    paramParcel.writeParcelable(this.zzatr, 0);
    paramParcel.writeParcelable(this.zzato, 0);
  }

  public final zzlh zza(zzpo paramzzpo)
  {
    return new zzlh(this.zzatl, this.zzatp, this.zzatq, this.zzatn, this.zzatm, this.zzafs, this.width, this.height, this.zzats, this.zzatt, this.zzaft, this.zzatv, this.zzatu, this.zzatw, this.zzafu, this.zzafv, this.zzatx, this.zzaty, this.zzatz, this.zzaub, this.zzauc, this.zzaud, this.zzaua, this.zzafw, this.zzatr, paramzzpo);
  }

  public final zzlh zzae(int paramInt)
  {
    return new zzlh(this.zzatl, this.zzatp, this.zzatq, this.zzatn, this.zzatm, paramInt, this.width, this.height, this.zzats, this.zzatt, this.zzaft, this.zzatv, this.zzatu, this.zzatw, this.zzafu, this.zzafv, this.zzatx, this.zzaty, this.zzatz, this.zzaub, this.zzauc, this.zzaud, this.zzaua, this.zzafw, this.zzatr, this.zzato);
  }

  public final zzlh zzc(int paramInt1, int paramInt2)
  {
    return new zzlh(this.zzatl, this.zzatp, this.zzatq, this.zzatn, this.zzatm, this.zzafs, this.width, this.height, this.zzats, this.zzatt, this.zzaft, this.zzatv, this.zzatu, this.zzatw, this.zzafu, this.zzafv, this.zzatx, paramInt1, paramInt2, this.zzaub, this.zzauc, this.zzaud, this.zzaua, this.zzafw, this.zzatr, this.zzato);
  }

  public final zzlh zzed(long paramLong)
  {
    return new zzlh(this.zzatl, this.zzatp, this.zzatq, this.zzatn, this.zzatm, this.zzafs, this.width, this.height, this.zzats, this.zzatt, this.zzaft, this.zzatv, this.zzatu, this.zzatw, this.zzafu, this.zzafv, this.zzatx, this.zzaty, this.zzatz, this.zzaub, this.zzauc, this.zzaud, paramLong, this.zzafw, this.zzatr, this.zzato);
  }

  @SuppressLint({"InlinedApi"})
  @TargetApi(16)
  public final MediaFormat zzen()
  {
    MediaFormat localMediaFormat = new MediaFormat();
    localMediaFormat.setString("mime", this.zzatq);
    String str = this.zzauc;
    if (str != null)
      localMediaFormat.setString("language", str);
    zza(localMediaFormat, "max-input-size", this.zzafs);
    zza(localMediaFormat, "width", this.width);
    zza(localMediaFormat, "height", this.height);
    float f = this.zzats;
    if (f != -1.0F)
      localMediaFormat.setFloat("frame-rate", f);
    zza(localMediaFormat, "rotation-degrees", this.zzatt);
    zza(localMediaFormat, "channel-count", this.zzafu);
    zza(localMediaFormat, "sample-rate", this.zzafv);
    zza(localMediaFormat, "encoder-delay", this.zzaty);
    zza(localMediaFormat, "encoder-padding", this.zzatz);
    for (int i = 0; i < this.zzafw.size(); i++)
      localMediaFormat.setByteBuffer(15 + "csd-" + i, ByteBuffer.wrap((byte[])this.zzafw.get(i)));
    zztb localzztb = this.zzatw;
    if (localzztb != null)
    {
      zza(localMediaFormat, "color-transfer", localzztb.zzbbp);
      zza(localMediaFormat, "color-standard", localzztb.zzbbo);
      zza(localMediaFormat, "color-range", localzztb.zzbbq);
      byte[] arrayOfByte = localzztb.zzbnt;
      if (arrayOfByte != null)
        localMediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(arrayOfByte));
    }
    return localMediaFormat;
  }

  public final int zzhc()
  {
    if ((this.width == -1) || (this.height == -1))
      return -1;
    return this.width * this.height;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzlh
 * JD-Core Version:    0.6.2
 */