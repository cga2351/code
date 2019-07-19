package com.facebook.soloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Parcel;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipEntry;

public class ApkSoSource extends ExtractFromZipSoSource
{
  private static final byte APK_SO_SOURCE_SIGNATURE_VERSION = 2;
  private static final byte LIBS_DIR_DOESNT_EXIST = 1;
  private static final byte LIBS_DIR_DONT_CARE = 0;
  private static final byte LIBS_DIR_SNAPSHOT = 2;
  public static final int PREFER_ANDROID_LIBS_DIRECTORY = 1;
  private static final String TAG = "ApkSoSource";
  private final int mFlags;

  public ApkSoSource(Context paramContext, File paramFile, String paramString, int paramInt)
  {
    super(paramContext, paramString, paramFile, "^lib/([^/]+)/([^/]+\\.so)$");
    this.mFlags = paramInt;
  }

  public ApkSoSource(Context paramContext, String paramString, int paramInt)
  {
    this(paramContext, new File(paramContext.getApplicationInfo().sourceDir), paramString, paramInt);
  }

  protected byte[] getDepsBlock()
    throws IOException
  {
    File localFile1 = this.mZipFileName.getCanonicalFile();
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeByte((byte)2);
      localParcel.writeString(localFile1.getPath());
      localParcel.writeLong(localFile1.lastModified());
      localParcel.writeInt(SysUtil.getAppVersionCode(this.mContext));
      if ((0x1 & this.mFlags) == 0)
      {
        localParcel.writeByte((byte)0);
        byte[] arrayOfByte4 = localParcel.marshall();
        return arrayOfByte4;
      }
      String str = this.mContext.getApplicationInfo().nativeLibraryDir;
      if (str == null)
      {
        localParcel.writeByte((byte)1);
        byte[] arrayOfByte1 = localParcel.marshall();
        return arrayOfByte1;
      }
      File localFile2 = new File(str).getCanonicalFile();
      if (!localFile2.exists())
      {
        localParcel.writeByte((byte)1);
        byte[] arrayOfByte3 = localParcel.marshall();
        return arrayOfByte3;
      }
      localParcel.writeByte((byte)2);
      localParcel.writeString(localFile2.getPath());
      localParcel.writeLong(localFile2.lastModified());
      byte[] arrayOfByte2 = localParcel.marshall();
      return arrayOfByte2;
    }
    finally
    {
      localParcel.recycle();
    }
  }

  protected UnpackingSoSource.Unpacker makeUnpacker()
    throws IOException
  {
    return new ApkUnpacker(this);
  }

  protected class ApkUnpacker extends ExtractFromZipSoSource.ZipUnpacker
  {
    private final int mFlags = ApkSoSource.this.mFlags;
    private File mLibDir = new File(ApkSoSource.this.mContext.getApplicationInfo().nativeLibraryDir);

    ApkUnpacker(ExtractFromZipSoSource arg2)
      throws IOException
    {
      super(localUnpackingSoSource);
    }

    protected boolean shouldExtract(ZipEntry paramZipEntry, String paramString)
    {
      boolean bool = true;
      String str1 = paramZipEntry.getName();
      String str2;
      if (paramString.equals(ApkSoSource.this.mCorruptedLib))
      {
        ApkSoSource.this.mCorruptedLib = null;
        Object[] arrayOfObject3 = new Object[bool];
        arrayOfObject3[0] = paramString;
        str2 = String.format("allowing consideration of corrupted lib %s", arrayOfObject3);
      }
      while (true)
      {
        Log.d("ApkSoSource", str2);
        return bool;
        if ((0x1 & this.mFlags) == 0)
        {
          str2 = "allowing consideration of " + str1 + ": self-extraction preferred";
        }
        else
        {
          File localFile = new File(this.mLibDir, paramString);
          if (!localFile.isFile())
          {
            Object[] arrayOfObject2 = new Object[2];
            arrayOfObject2[0] = str1;
            arrayOfObject2[bool] = paramString;
            str2 = String.format("allowing considering of %s: %s not in system lib dir", arrayOfObject2);
          }
          else
          {
            long l1 = localFile.length();
            long l2 = paramZipEntry.getSize();
            if (l1 != l2)
            {
              Object[] arrayOfObject1 = new Object[3];
              arrayOfObject1[0] = localFile;
              arrayOfObject1[bool] = Long.valueOf(l1);
              arrayOfObject1[2] = Long.valueOf(l2);
              str2 = String.format("allowing consideration of %s: sysdir file length is %s, but the file is %s bytes long in the APK", arrayOfObject1);
            }
            else
            {
              str2 = "not allowing consideration of " + str1 + ": deferring to libdir";
              bool = false;
            }
          }
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.soloader.ApkSoSource
 * JD-Core Version:    0.6.2
 */