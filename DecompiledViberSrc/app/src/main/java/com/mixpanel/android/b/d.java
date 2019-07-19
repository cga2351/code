package com.mixpanel.android.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.LruCache;
import android.util.Base64;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class d
{
  private static LruCache<String, Bitmap> e;
  private final File a;
  private final i b;
  private final MessageDigest c;
  private final com.mixpanel.android.mpmetrics.i d;

  public d(Context paramContext, String paramString)
  {
    this(paramContext, "MixpanelAPI.Images." + paramString, new c());
  }

  public d(Context paramContext, String paramString, i parami)
  {
    this.a = paramContext.getDir(paramString, 0);
    this.b = parami;
    this.d = com.mixpanel.android.mpmetrics.i.a(paramContext);
    try
    {
      MessageDigest localMessageDigest2 = MessageDigest.getInstance("SHA1");
      localMessageDigest1 = localMessageDigest2;
      this.c = localMessageDigest1;
      if (e != null);
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      try
      {
        while (true)
        {
          if (e == null)
            e = new LruCache((int)(Runtime.getRuntime().maxMemory() / 1024L) / this.d.E())
            {
              protected int a(String paramAnonymousString, Bitmap paramAnonymousBitmap)
              {
                return paramAnonymousBitmap.getRowBytes() * paramAnonymousBitmap.getHeight() / 1024;
              }
            };
          return;
          localNoSuchAlgorithmException = localNoSuchAlgorithmException;
          f.d("MixpanelAPI.ImageStore", "Images won't be stored because this platform doesn't supply a SHA1 hash function");
          MessageDigest localMessageDigest1 = null;
        }
      }
      finally
      {
      }
    }
  }

  private static float a()
  {
    Runtime localRuntime = Runtime.getRuntime();
    float f = (float)(localRuntime.totalMemory() - localRuntime.freeMemory());
    return (float)localRuntime.maxMemory() - f;
  }

  private static Bitmap a(File paramFile)
    throws d.a
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions);
    if (localOptions.outHeight * localOptions.outWidth > a())
      throw new a("Do not have enough memory for the image");
    Bitmap localBitmap = BitmapFactory.decodeFile(paramFile.getAbsolutePath());
    if (localBitmap == null)
    {
      paramFile.delete();
      throw new a("Bitmap on disk can't be opened or was corrupt");
    }
    return localBitmap;
  }

  public static void a(String paramString, Bitmap paramBitmap)
  {
    if (d(paramString) == null)
      synchronized (e)
      {
        e.put(paramString, paramBitmap);
        return;
      }
  }

  public static Bitmap d(String paramString)
  {
    synchronized (e)
    {
      Bitmap localBitmap = (Bitmap)e.get(paramString);
      return localBitmap;
    }
  }

  public static void e(String paramString)
  {
    synchronized (e)
    {
      e.remove(paramString);
      return;
    }
  }

  private File f(String paramString)
  {
    if (this.c == null)
      return null;
    byte[] arrayOfByte = this.c.digest(paramString.getBytes());
    String str = "MP_IMG_" + Base64.encodeToString(arrayOfByte, 10);
    return new File(this.a, str);
  }

  // ERROR //
  public File a(String paramString)
    throws d.a
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 200	com/mixpanel/android/b/d:f	(Ljava/lang/String;)Ljava/io/File;
    //   7: astore_3
    //   8: aload_3
    //   9: ifnull +10 -> 19
    //   12: aload_3
    //   13: invokevirtual 203	java/io/File:exists	()Z
    //   16: ifne +71 -> 87
    //   19: aload_0
    //   20: getfield 58	com/mixpanel/android/b/d:d	Lcom/mixpanel/android/mpmetrics/i;
    //   23: invokevirtual 207	com/mixpanel/android/mpmetrics/i:C	()Ljavax/net/ssl/SSLSocketFactory;
    //   26: astore 6
    //   28: aload_0
    //   29: getfield 51	com/mixpanel/android/b/d:b	Lcom/mixpanel/android/b/i;
    //   32: aload_1
    //   33: aconst_null
    //   34: aload 6
    //   36: invokeinterface 212 4 0
    //   41: astore 7
    //   43: aload 7
    //   45: ifnull +42 -> 87
    //   48: aload_3
    //   49: ifnull +38 -> 87
    //   52: aload 7
    //   54: arraylength
    //   55: ldc 213
    //   57: if_icmpge +30 -> 87
    //   60: new 215	java/io/FileOutputStream
    //   63: dup
    //   64: aload_3
    //   65: invokespecial 218	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   68: astore 8
    //   70: aload 8
    //   72: aload 7
    //   74: invokevirtual 224	java/io/OutputStream:write	([B)V
    //   77: aload 8
    //   79: ifnull +8 -> 87
    //   82: aload 8
    //   84: invokevirtual 227	java/io/OutputStream:close	()V
    //   87: aload_3
    //   88: areturn
    //   89: astore 5
    //   91: new 110	com/mixpanel/android/b/d$a
    //   94: dup
    //   95: ldc 229
    //   97: aload 5
    //   99: invokespecial 232	com/mixpanel/android/b/d$a:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   102: athrow
    //   103: astore 4
    //   105: new 110	com/mixpanel/android/b/d$a
    //   108: dup
    //   109: ldc 234
    //   111: aload 4
    //   113: invokespecial 232	com/mixpanel/android/b/d$a:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   116: athrow
    //   117: astore 13
    //   119: ldc 93
    //   121: ldc 236
    //   123: aload 13
    //   125: invokestatic 239	com/mixpanel/android/b/f:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   128: aload_3
    //   129: areturn
    //   130: astore 9
    //   132: aconst_null
    //   133: astore 8
    //   135: new 110	com/mixpanel/android/b/d$a
    //   138: dup
    //   139: ldc 241
    //   141: aload 9
    //   143: invokespecial 232	com/mixpanel/android/b/d$a:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   146: athrow
    //   147: astore 10
    //   149: aload 8
    //   151: astore_2
    //   152: aload_2
    //   153: ifnull +7 -> 160
    //   156: aload_2
    //   157: invokevirtual 227	java/io/OutputStream:close	()V
    //   160: aload 10
    //   162: athrow
    //   163: astore 12
    //   165: new 110	com/mixpanel/android/b/d$a
    //   168: dup
    //   169: ldc 243
    //   171: aload 12
    //   173: invokespecial 232	com/mixpanel/android/b/d$a:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   176: athrow
    //   177: astore 10
    //   179: goto -27 -> 152
    //   182: astore 11
    //   184: ldc 93
    //   186: ldc 236
    //   188: aload 11
    //   190: invokestatic 239	com/mixpanel/android/b/f:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   193: goto -33 -> 160
    //   196: astore 12
    //   198: aload 8
    //   200: astore_2
    //   201: goto -36 -> 165
    //   204: astore 9
    //   206: goto -71 -> 135
    //
    // Exception table:
    //   from	to	target	type
    //   19	43	89	java/io/IOException
    //   19	43	103	com/mixpanel/android/b/i$a
    //   82	87	117	java/io/IOException
    //   60	70	130	java/io/FileNotFoundException
    //   70	77	147	finally
    //   135	147	147	finally
    //   60	70	163	java/io/IOException
    //   60	70	177	finally
    //   165	177	177	finally
    //   156	160	182	java/io/IOException
    //   70	77	196	java/io/IOException
    //   70	77	204	java/io/FileNotFoundException
  }

  public Bitmap b(String paramString)
    throws d.a
  {
    Bitmap localBitmap = d(paramString);
    if (localBitmap == null)
    {
      localBitmap = a(a(paramString));
      a(paramString, localBitmap);
    }
    return localBitmap;
  }

  public void c(String paramString)
  {
    File localFile = f(paramString);
    if (localFile != null)
    {
      localFile.delete();
      e(paramString);
    }
  }

  public static class a extends Exception
  {
    public a(String paramString)
    {
      super();
    }

    public a(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.b.d
 * JD-Core Version:    0.6.2
 */