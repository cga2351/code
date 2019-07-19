package android.support.v4.graphics;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import java.io.File;

class TypefaceCompatApi21Impl extends TypefaceCompatBaseImpl
{
  private static final String TAG = "TypefaceCompatApi21Impl";

  private File getFile(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    try
    {
      String str = Os.readlink("/proc/self/fd/" + paramParcelFileDescriptor.getFd());
      if (OsConstants.S_ISREG(Os.stat(str).st_mode))
      {
        File localFile = new File(str);
        return localFile;
      }
      return null;
    }
    catch (ErrnoException localErrnoException)
    {
    }
    return null;
  }

  // ERROR //
  public android.graphics.Typeface createFromFontInfo(android.content.Context paramContext, android.os.CancellationSignal paramCancellationSignal, android.support.v4.provider.FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_3
    //   1: arraylength
    //   2: iconst_1
    //   3: if_icmpge +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: aload_0
    //   9: aload_3
    //   10: iload 4
    //   12: invokevirtual 75	android/support/v4/graphics/TypefaceCompatApi21Impl:findBestInfo	([Landroid/support/v4/provider/FontsContractCompat$FontInfo;I)Landroid/support/v4/provider/FontsContractCompat$FontInfo;
    //   15: astore 5
    //   17: aload_1
    //   18: invokevirtual 81	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   21: astore 6
    //   23: aload 6
    //   25: aload 5
    //   27: invokevirtual 87	android/support/v4/provider/FontsContractCompat$FontInfo:getUri	()Landroid/net/Uri;
    //   30: ldc 89
    //   32: aload_2
    //   33: invokevirtual 95	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   36: astore 8
    //   38: aload_0
    //   39: aload 8
    //   41: invokespecial 97	android/support/v4/graphics/TypefaceCompatApi21Impl:getFile	(Landroid/os/ParcelFileDescriptor;)Ljava/io/File;
    //   44: astore 14
    //   46: aload 14
    //   48: ifnull +11 -> 59
    //   51: aload 14
    //   53: invokevirtual 101	java/io/File:canRead	()Z
    //   56: ifne +185 -> 241
    //   59: new 103	java/io/FileInputStream
    //   62: dup
    //   63: aload 8
    //   65: invokevirtual 107	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   68: invokespecial 110	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   71: astore 15
    //   73: aload_0
    //   74: aload_1
    //   75: aload 15
    //   77: invokespecial 114	android/support/v4/graphics/TypefaceCompatBaseImpl:createFromInputStream	(Landroid/content/Context;Ljava/io/InputStream;)Landroid/graphics/Typeface;
    //   80: astore 19
    //   82: aload 15
    //   84: ifnull +12 -> 96
    //   87: iconst_0
    //   88: ifeq +73 -> 161
    //   91: aload 15
    //   93: invokevirtual 117	java/io/FileInputStream:close	()V
    //   96: aload 8
    //   98: ifnull +12 -> 110
    //   101: iconst_0
    //   102: ifeq +86 -> 188
    //   105: aload 8
    //   107: invokevirtual 118	android/os/ParcelFileDescriptor:close	()V
    //   110: aload 19
    //   112: areturn
    //   113: astore 21
    //   115: aconst_null
    //   116: aload 21
    //   118: invokevirtual 122	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   121: goto -25 -> 96
    //   124: astore 12
    //   126: aload 12
    //   128: athrow
    //   129: astore 13
    //   131: aload 12
    //   133: astore 10
    //   135: aload 13
    //   137: astore 9
    //   139: aload 8
    //   141: ifnull +13 -> 154
    //   144: aload 10
    //   146: ifnull +150 -> 296
    //   149: aload 8
    //   151: invokevirtual 118	android/os/ParcelFileDescriptor:close	()V
    //   154: aload 9
    //   156: athrow
    //   157: astore 7
    //   159: aconst_null
    //   160: areturn
    //   161: aload 15
    //   163: invokevirtual 117	java/io/FileInputStream:close	()V
    //   166: goto -70 -> 96
    //   169: astore 9
    //   171: aconst_null
    //   172: astore 10
    //   174: goto -35 -> 139
    //   177: astore 20
    //   179: aconst_null
    //   180: aload 20
    //   182: invokevirtual 122	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   185: goto -75 -> 110
    //   188: aload 8
    //   190: invokevirtual 118	android/os/ParcelFileDescriptor:close	()V
    //   193: goto -83 -> 110
    //   196: astore 17
    //   198: aload 17
    //   200: athrow
    //   201: astore 16
    //   203: aload 15
    //   205: ifnull +13 -> 218
    //   208: aload 17
    //   210: ifnull +23 -> 233
    //   213: aload 15
    //   215: invokevirtual 117	java/io/FileInputStream:close	()V
    //   218: aload 16
    //   220: athrow
    //   221: astore 18
    //   223: aload 17
    //   225: aload 18
    //   227: invokevirtual 122	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   230: goto -12 -> 218
    //   233: aload 15
    //   235: invokevirtual 117	java/io/FileInputStream:close	()V
    //   238: goto -20 -> 218
    //   241: aload 14
    //   243: invokestatic 128	android/graphics/Typeface:createFromFile	(Ljava/io/File;)Landroid/graphics/Typeface;
    //   246: astore 22
    //   248: aload 8
    //   250: ifnull +12 -> 262
    //   253: iconst_0
    //   254: ifeq +22 -> 276
    //   257: aload 8
    //   259: invokevirtual 118	android/os/ParcelFileDescriptor:close	()V
    //   262: aload 22
    //   264: areturn
    //   265: astore 23
    //   267: aconst_null
    //   268: aload 23
    //   270: invokevirtual 122	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   273: goto -11 -> 262
    //   276: aload 8
    //   278: invokevirtual 118	android/os/ParcelFileDescriptor:close	()V
    //   281: goto -19 -> 262
    //   284: astore 11
    //   286: aload 10
    //   288: aload 11
    //   290: invokevirtual 122	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   293: goto -139 -> 154
    //   296: aload 8
    //   298: invokevirtual 118	android/os/ParcelFileDescriptor:close	()V
    //   301: goto -147 -> 154
    //   304: astore 16
    //   306: aconst_null
    //   307: astore 17
    //   309: goto -106 -> 203
    //
    // Exception table:
    //   from	to	target	type
    //   91	96	113	java/lang/Throwable
    //   38	46	124	java/lang/Throwable
    //   51	59	124	java/lang/Throwable
    //   59	73	124	java/lang/Throwable
    //   115	121	124	java/lang/Throwable
    //   161	166	124	java/lang/Throwable
    //   218	221	124	java/lang/Throwable
    //   223	230	124	java/lang/Throwable
    //   233	238	124	java/lang/Throwable
    //   241	248	124	java/lang/Throwable
    //   126	129	129	finally
    //   23	38	157	java/io/IOException
    //   105	110	157	java/io/IOException
    //   149	154	157	java/io/IOException
    //   154	157	157	java/io/IOException
    //   179	185	157	java/io/IOException
    //   188	193	157	java/io/IOException
    //   257	262	157	java/io/IOException
    //   267	273	157	java/io/IOException
    //   276	281	157	java/io/IOException
    //   286	293	157	java/io/IOException
    //   296	301	157	java/io/IOException
    //   38	46	169	finally
    //   51	59	169	finally
    //   59	73	169	finally
    //   91	96	169	finally
    //   115	121	169	finally
    //   161	166	169	finally
    //   213	218	169	finally
    //   218	221	169	finally
    //   223	230	169	finally
    //   233	238	169	finally
    //   241	248	169	finally
    //   105	110	177	java/lang/Throwable
    //   73	82	196	java/lang/Throwable
    //   198	201	201	finally
    //   213	218	221	java/lang/Throwable
    //   257	262	265	java/lang/Throwable
    //   149	154	284	java/lang/Throwable
    //   73	82	304	finally
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.graphics.TypefaceCompatApi21Impl
 * JD-Core Version:    0.6.2
 */