package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

@KeepForSdk
@ShowFirstParty
@SafeParcelable.Class(creator="BitmapTeleporterCreator")
public class BitmapTeleporter extends AbstractSafeParcelable
  implements ReflectedParcelable
{

  @KeepForSdk
  public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new zaa();

  @SafeParcelable.Field(id=3)
  private final int mType;

  @SafeParcelable.VersionField(id=1)
  private final int zale;

  @SafeParcelable.Field(id=2)
  private ParcelFileDescriptor zalf;
  private Bitmap zalg;
  private boolean zalh;
  private File zali;

  @SafeParcelable.Constructor
  BitmapTeleporter(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) ParcelFileDescriptor paramParcelFileDescriptor, @SafeParcelable.Param(id=3) int paramInt2)
  {
    this.zale = paramInt1;
    this.zalf = paramParcelFileDescriptor;
    this.mType = paramInt2;
    this.zalg = null;
    this.zalh = false;
  }

  @KeepForSdk
  public BitmapTeleporter(Bitmap paramBitmap)
  {
    this.zale = 1;
    this.zalf = null;
    this.mType = 0;
    this.zalg = paramBitmap;
    this.zalh = true;
  }

  private static void zaa(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException localIOException)
    {
      Log.w("BitmapTeleporter", "Could not close stream", localIOException);
    }
  }

  // ERROR //
  private final java.io.FileOutputStream zabz()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 80	com/google/android/gms/common/data/BitmapTeleporter:zali	Ljava/io/File;
    //   4: ifnonnull +13 -> 17
    //   7: new 82	java/lang/IllegalStateException
    //   10: dup
    //   11: ldc 84
    //   13: invokespecial 87	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: ldc 89
    //   19: ldc 91
    //   21: aload_0
    //   22: getfield 80	com/google/android/gms/common/data/BitmapTeleporter:zali	Ljava/io/File;
    //   25: invokestatic 97	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   28: astore_2
    //   29: new 99	java/io/FileOutputStream
    //   32: dup
    //   33: aload_2
    //   34: invokespecial 102	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   37: astore_3
    //   38: aload_0
    //   39: aload_2
    //   40: ldc 103
    //   42: invokestatic 109	android/os/ParcelFileDescriptor:open	(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
    //   45: putfield 48	com/google/android/gms/common/data/BitmapTeleporter:zalf	Landroid/os/ParcelFileDescriptor;
    //   48: aload_2
    //   49: invokevirtual 113	java/io/File:delete	()Z
    //   52: pop
    //   53: aload_3
    //   54: areturn
    //   55: astore_1
    //   56: new 82	java/lang/IllegalStateException
    //   59: dup
    //   60: ldc 115
    //   62: aload_1
    //   63: invokespecial 118	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   66: athrow
    //   67: astore 4
    //   69: new 82	java/lang/IllegalStateException
    //   72: dup
    //   73: ldc 120
    //   75: invokespecial 87	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   78: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   17	29	55	java/io/IOException
    //   29	48	67	java/io/FileNotFoundException
  }

  @KeepForSdk
  public Bitmap get()
  {
    DataInputStream localDataInputStream;
    if (!this.zalh)
      localDataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.zalf));
    try
    {
      byte[] arrayOfByte = new byte[localDataInputStream.readInt()];
      int i = localDataInputStream.readInt();
      int j = localDataInputStream.readInt();
      Bitmap.Config localConfig = Bitmap.Config.valueOf(localDataInputStream.readUTF());
      localDataInputStream.read(arrayOfByte);
      zaa(localDataInputStream);
      ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte);
      Bitmap localBitmap = Bitmap.createBitmap(i, j, localConfig);
      localBitmap.copyPixelsFromBuffer(localByteBuffer);
      this.zalg = localBitmap;
      this.zalh = true;
      return this.zalg;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException("Could not read from parcel file descriptor", localIOException);
    }
    finally
    {
      zaa(localDataInputStream);
    }
  }

  @KeepForSdk
  public void release()
  {
    if (!this.zalh);
    try
    {
      this.zalf.close();
      return;
    }
    catch (IOException localIOException)
    {
      Log.w("BitmapTeleporter", "Could not close PFD", localIOException);
    }
  }

  @KeepForSdk
  public void setTempDir(File paramFile)
  {
    if (paramFile == null)
      throw new NullPointerException("Cannot set null temp directory");
    this.zali = paramFile;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Bitmap localBitmap;
    byte[] arrayOfByte;
    DataOutputStream localDataOutputStream;
    if (this.zalf == null)
    {
      localBitmap = this.zalg;
      ByteBuffer localByteBuffer = ByteBuffer.allocate(localBitmap.getRowBytes() * localBitmap.getHeight());
      localBitmap.copyPixelsToBuffer(localByteBuffer);
      arrayOfByte = localByteBuffer.array();
      localDataOutputStream = new DataOutputStream(new BufferedOutputStream(zabz()));
    }
    try
    {
      localDataOutputStream.writeInt(arrayOfByte.length);
      localDataOutputStream.writeInt(localBitmap.getWidth());
      localDataOutputStream.writeInt(localBitmap.getHeight());
      localDataOutputStream.writeUTF(localBitmap.getConfig().toString());
      localDataOutputStream.write(arrayOfByte);
      zaa(localDataOutputStream);
      int i = paramInt | 0x1;
      int j = SafeParcelWriter.beginObjectHeader(paramParcel);
      SafeParcelWriter.writeInt(paramParcel, 1, this.zale);
      SafeParcelWriter.writeParcelable(paramParcel, 2, this.zalf, i, false);
      SafeParcelWriter.writeInt(paramParcel, 3, this.mType);
      SafeParcelWriter.finishObjectHeader(paramParcel, j);
      this.zalf = null;
      return;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException("Could not write into unlinked file", localIOException);
    }
    finally
    {
      zaa(localDataOutputStream);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.BitmapTeleporter
 * JD-Core Version:    0.6.2
 */