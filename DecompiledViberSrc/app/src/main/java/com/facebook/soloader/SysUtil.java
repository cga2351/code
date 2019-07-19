package com.facebook.soloader;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public final class SysUtil
{
  private static final byte APK_SIGNATURE_VERSION = 1;

  static int copyBytes(RandomAccessFile paramRandomAccessFile, InputStream paramInputStream, int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    int i = 0;
    while (i < paramInt)
    {
      int j = paramInputStream.read(paramArrayOfByte, 0, Math.min(paramArrayOfByte.length, paramInt - i));
      if (j == -1)
        break;
      paramRandomAccessFile.write(paramArrayOfByte, 0, j);
      i += j;
    }
    return i;
  }

  public static void deleteOrThrow(File paramFile)
    throws IOException
  {
    if (!paramFile.delete())
      throw new IOException("could not delete file " + paramFile);
  }

  public static void dumbDeleteRecursive(File paramFile)
    throws IOException
  {
    if (paramFile.isDirectory())
    {
      arrayOfFile = paramFile.listFiles();
      if (arrayOfFile != null);
    }
    while ((paramFile.delete()) || (!paramFile.exists()))
    {
      File[] arrayOfFile;
      return;
      int i = arrayOfFile.length;
      for (int j = 0; j < i; j++)
        dumbDeleteRecursive(arrayOfFile[j]);
    }
    throw new IOException("could not delete: " + paramFile);
  }

  public static void fallocateIfSupported(FileDescriptor paramFileDescriptor, long paramLong)
    throws IOException
  {
    if (Build.VERSION.SDK_INT >= 21)
      LollipopSysdeps.fallocateIfSupported(paramFileDescriptor, paramLong);
  }

  public static int findAbiScore(String[] paramArrayOfString, String paramString)
  {
    for (int i = 0; i < paramArrayOfString.length; i++)
      if ((paramArrayOfString[i] != null) && (paramString.equals(paramArrayOfString[i])))
        return i;
    return -1;
  }

  // ERROR //
  static void fsyncRecursive(File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 64	java/io/File:isDirectory	()Z
    //   4: ifeq +66 -> 70
    //   7: aload_0
    //   8: invokevirtual 68	java/io/File:listFiles	()[Ljava/io/File;
    //   11: astore 8
    //   13: aload 8
    //   15: ifnonnull +30 -> 45
    //   18: new 15	java/io/IOException
    //   21: dup
    //   22: new 43	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   29: ldc 100
    //   31: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_0
    //   35: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokespecial 60	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   44: athrow
    //   45: iconst_0
    //   46: istore 9
    //   48: iload 9
    //   50: aload 8
    //   52: arraylength
    //   53: if_icmpge +29 -> 82
    //   56: aload 8
    //   58: iload 9
    //   60: aaload
    //   61: invokestatic 102	com/facebook/soloader/SysUtil:fsyncRecursive	(Ljava/io/File;)V
    //   64: iinc 9 1
    //   67: goto -19 -> 48
    //   70: aload_0
    //   71: invokevirtual 105	java/io/File:getPath	()Ljava/lang/String;
    //   74: ldc 107
    //   76: invokevirtual 111	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   79: ifeq +4 -> 83
    //   82: return
    //   83: new 29	java/io/RandomAccessFile
    //   86: dup
    //   87: aload_0
    //   88: ldc 113
    //   90: invokespecial 116	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   93: astore_1
    //   94: aload_1
    //   95: invokevirtual 120	java/io/RandomAccessFile:getFD	()Ljava/io/FileDescriptor;
    //   98: invokevirtual 125	java/io/FileDescriptor:sync	()V
    //   101: aload_1
    //   102: ifnull -20 -> 82
    //   105: iconst_0
    //   106: ifeq +17 -> 123
    //   109: aload_1
    //   110: invokevirtual 128	java/io/RandomAccessFile:close	()V
    //   113: return
    //   114: astore 7
    //   116: aconst_null
    //   117: aload 7
    //   119: invokevirtual 132	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   122: return
    //   123: aload_1
    //   124: invokevirtual 128	java/io/RandomAccessFile:close	()V
    //   127: return
    //   128: astore 5
    //   130: aload 5
    //   132: athrow
    //   133: astore 6
    //   135: aload 5
    //   137: astore_3
    //   138: aload 6
    //   140: astore_2
    //   141: aload_1
    //   142: ifnull +11 -> 153
    //   145: aload_3
    //   146: ifnull +20 -> 166
    //   149: aload_1
    //   150: invokevirtual 128	java/io/RandomAccessFile:close	()V
    //   153: aload_2
    //   154: athrow
    //   155: astore 4
    //   157: aload_3
    //   158: aload 4
    //   160: invokevirtual 132	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   163: goto -10 -> 153
    //   166: aload_1
    //   167: invokevirtual 128	java/io/RandomAccessFile:close	()V
    //   170: goto -17 -> 153
    //   173: astore_2
    //   174: aconst_null
    //   175: astore_3
    //   176: goto -35 -> 141
    //
    // Exception table:
    //   from	to	target	type
    //   109	113	114	java/lang/Throwable
    //   94	101	128	java/lang/Throwable
    //   130	133	133	finally
    //   149	153	155	java/lang/Throwable
    //   94	101	173	finally
  }

  public static int getAppVersionCode(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    int i = 0;
    if (localPackageManager != null);
    try
    {
      i = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (RuntimeException localRuntimeException)
    {
      return 0;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return 0;
  }

  public static String[] getSupportedAbis()
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      String[] arrayOfString = new String[2];
      arrayOfString[0] = Build.CPU_ABI;
      arrayOfString[1] = Build.CPU_ABI2;
      return arrayOfString;
    }
    return LollipopSysdeps.getSupportedAbis();
  }

  public static byte[] makeApkDepBlock(File paramFile, Context paramContext)
    throws IOException
  {
    File localFile = paramFile.getCanonicalFile();
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeByte((byte)1);
      localParcel.writeString(localFile.getPath());
      localParcel.writeLong(localFile.lastModified());
      localParcel.writeInt(getAppVersionCode(paramContext));
      byte[] arrayOfByte = localParcel.marshall();
      return arrayOfByte;
    }
    finally
    {
      localParcel.recycle();
    }
  }

  static void mkdirOrThrow(File paramFile)
    throws IOException
  {
    if ((!paramFile.mkdirs()) && (!paramFile.isDirectory()))
      throw new IOException("cannot mkdir: " + paramFile);
  }

  @TargetApi(21)
  @DoNotOptimize
  private static final class LollipopSysdeps
  {
    @DoNotOptimize
    public static void fallocateIfSupported(FileDescriptor paramFileDescriptor, long paramLong)
      throws IOException
    {
      try
      {
        Os.posix_fallocate(paramFileDescriptor, 0L, paramLong);
        return;
      }
      catch (ErrnoException localErrnoException)
      {
        while ((localErrnoException.errno == OsConstants.EOPNOTSUPP) || (localErrnoException.errno == OsConstants.ENOSYS) || (localErrnoException.errno == OsConstants.EINVAL));
        throw new IOException(localErrnoException.toString(), localErrnoException);
      }
    }

    @DoNotOptimize
    public static String[] getSupportedAbis()
    {
      return Build.SUPPORTED_ABIS;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.soloader.SysUtil
 * JD-Core Version:    0.6.2
 */