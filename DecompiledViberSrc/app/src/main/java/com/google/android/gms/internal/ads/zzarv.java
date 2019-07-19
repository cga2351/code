package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@zzare
@SafeParcelable.Class(creator="LargeParcelTeleporterCreator")
@SafeParcelable.Reserved({1})
public final class zzarv extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzarv> CREATOR = new zzarx();

  @SafeParcelable.Field(id=2)
  private ParcelFileDescriptor zzdoq;
  private Parcelable zzdor;
  private boolean zzdos;

  @SafeParcelable.Constructor
  public zzarv(@SafeParcelable.Param(id=2) ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.zzdoq = paramParcelFileDescriptor;
    this.zzdor = null;
    this.zzdos = true;
  }

  // ERROR //
  private final <T> ParcelFileDescriptor zzi(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 52	android/os/ParcelFileDescriptor:createPipe	()[Landroid/os/ParcelFileDescriptor;
    //   3: astore 4
    //   5: new 54	android/os/ParcelFileDescriptor$AutoCloseOutputStream
    //   8: dup
    //   9: aload 4
    //   11: iconst_1
    //   12: aaload
    //   13: invokespecial 56	android/os/ParcelFileDescriptor$AutoCloseOutputStream:<init>	(Landroid/os/ParcelFileDescriptor;)V
    //   16: astore_3
    //   17: new 58	java/lang/Thread
    //   20: dup
    //   21: new 60	com/google/android/gms/internal/ads/zzarw
    //   24: dup
    //   25: aload_0
    //   26: aload_3
    //   27: aload_1
    //   28: invokespecial 63	com/google/android/gms/internal/ads/zzarw:<init>	(Lcom/google/android/gms/internal/ads/zzarv;Ljava/io/OutputStream;[B)V
    //   31: invokespecial 66	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   34: invokevirtual 69	java/lang/Thread:start	()V
    //   37: aload 4
    //   39: iconst_0
    //   40: aaload
    //   41: astore 5
    //   43: aload 5
    //   45: areturn
    //   46: astore_2
    //   47: aconst_null
    //   48: astore_3
    //   49: ldc 71
    //   51: aload_2
    //   52: invokestatic 77	com/google/android/gms/internal/ads/zzaxa:zzc	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   55: invokestatic 83	com/google/android/gms/ads/internal/zzk:zzlk	()Lcom/google/android/gms/internal/ads/zzawn;
    //   58: aload_2
    //   59: ldc 85
    //   61: invokevirtual 91	com/google/android/gms/internal/ads/zzawn:zza	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   64: aload_3
    //   65: invokestatic 97	com/google/android/gms/common/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   68: aconst_null
    //   69: areturn
    //   70: astore_2
    //   71: goto -22 -> 49
    //
    // Exception table:
    //   from	to	target	type
    //   0	17	46	java/io/IOException
    //   17	43	70	java/io/IOException
  }

  private final ParcelFileDescriptor zzts()
  {
    Parcel localParcel;
    if (this.zzdoq == null)
      localParcel = Parcel.obtain();
    try
    {
      this.zzdor.writeToParcel(localParcel, 0);
      byte[] arrayOfByte = localParcel.marshall();
      localParcel.recycle();
      this.zzdoq = zzi(arrayOfByte);
      return this.zzdoq;
    }
    finally
    {
      localParcel.recycle();
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzts();
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.zzdoq, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }

  // ERROR //
  public final <T extends com.google.android.gms.common.internal.safeparcel.SafeParcelable> T zza(Parcelable.Creator<T> paramCreator)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	com/google/android/gms/internal/ads/zzarv:zzdos	Z
    //   4: ifeq +105 -> 109
    //   7: aload_0
    //   8: getfield 38	com/google/android/gms/internal/ads/zzarv:zzdoq	Landroid/os/ParcelFileDescriptor;
    //   11: ifnonnull +10 -> 21
    //   14: ldc 138
    //   16: invokestatic 142	com/google/android/gms/internal/ads/zzaxa:zzen	(Ljava/lang/String;)V
    //   19: aconst_null
    //   20: areturn
    //   21: new 144	java/io/DataInputStream
    //   24: dup
    //   25: new 146	android/os/ParcelFileDescriptor$AutoCloseInputStream
    //   28: dup
    //   29: aload_0
    //   30: getfield 38	com/google/android/gms/internal/ads/zzarv:zzdoq	Landroid/os/ParcelFileDescriptor;
    //   33: invokespecial 147	android/os/ParcelFileDescriptor$AutoCloseInputStream:<init>	(Landroid/os/ParcelFileDescriptor;)V
    //   36: invokespecial 150	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   39: astore_2
    //   40: aload_2
    //   41: invokevirtual 154	java/io/DataInputStream:readInt	()I
    //   44: newarray byte
    //   46: astore 5
    //   48: aload_2
    //   49: aload 5
    //   51: iconst_0
    //   52: aload 5
    //   54: arraylength
    //   55: invokevirtual 158	java/io/DataInputStream:readFully	([BII)V
    //   58: aload_2
    //   59: invokestatic 97	com/google/android/gms/common/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   62: invokestatic 105	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   65: astore 6
    //   67: aload 6
    //   69: aload 5
    //   71: iconst_0
    //   72: aload 5
    //   74: arraylength
    //   75: invokevirtual 161	android/os/Parcel:unmarshall	([BII)V
    //   78: aload 6
    //   80: iconst_0
    //   81: invokevirtual 165	android/os/Parcel:setDataPosition	(I)V
    //   84: aload_0
    //   85: aload_1
    //   86: aload 6
    //   88: invokeinterface 171 2 0
    //   93: checkcast 173	com/google/android/gms/common/internal/safeparcel/SafeParcelable
    //   96: putfield 40	com/google/android/gms/internal/ads/zzarv:zzdor	Landroid/os/Parcelable;
    //   99: aload 6
    //   101: invokevirtual 118	android/os/Parcel:recycle	()V
    //   104: aload_0
    //   105: iconst_0
    //   106: putfield 42	com/google/android/gms/internal/ads/zzarv:zzdos	Z
    //   109: aload_0
    //   110: getfield 40	com/google/android/gms/internal/ads/zzarv:zzdor	Landroid/os/Parcelable;
    //   113: checkcast 173	com/google/android/gms/common/internal/safeparcel/SafeParcelable
    //   116: areturn
    //   117: astore 4
    //   119: ldc 175
    //   121: aload 4
    //   123: invokestatic 77	com/google/android/gms/internal/ads/zzaxa:zzc	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   126: aload_2
    //   127: invokestatic 97	com/google/android/gms/common/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   130: aconst_null
    //   131: areturn
    //   132: astore_3
    //   133: aload_2
    //   134: invokestatic 97	com/google/android/gms/common/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   137: aload_3
    //   138: athrow
    //   139: astore 7
    //   141: aload 6
    //   143: invokevirtual 118	android/os/Parcel:recycle	()V
    //   146: aload 7
    //   148: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   40	58	117	java/io/IOException
    //   40	58	132	finally
    //   119	126	132	finally
    //   67	99	139	finally
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzarv
 * JD-Core Version:    0.6.2
 */