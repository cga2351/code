package com.viber.voip.util.e;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.ContactsContract.Contacts;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.d.c;
import com.viber.voip.stickers.c.g;
import com.viber.voip.util.ap;
import com.viber.voip.util.at;
import com.viber.voip.util.bv;
import com.viber.voip.util.cj;
import com.viber.voip.util.da;
import com.viber.voip.util.dv;
import com.viber.voip.util.dx;
import com.viber.voip.util.dx.a;
import com.viber.voip.util.dx.b;
import com.viber.voip.util.dx.c;
import com.viber.voip.util.dx.d;
import com.viber.voip.util.dx.e;
import com.viber.voip.util.upload.b.a;
import com.viber.voip.util.upload.b.b;
import com.viber.voip.util.upload.b.d;
import com.viber.voip.util.upload.f;
import com.viber.voip.util.upload.h;
import com.viber.voip.util.upload.i.c;
import com.viber.voip.util.upload.i.e;
import com.viber.voip.util.upload.i.o;
import com.viber.voip.util.upload.p;
import com.viber.voip.util.upload.s;
import com.viber.voip.util.upload.t.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Response;

public class e extends i
{
  private static final Logger d = ViberEnv.getLogger();
  private static final Pattern e = Pattern.compile("\\d+");
  private static final String f = ContactsContract.Contacts.CONTENT_URI.toString();

  @Deprecated
  public e(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }

  // ERROR //
  public static android.graphics.Bitmap a(Context paramContext, Uri paramUri, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: invokestatic 67	com/viber/voip/util/e/e:b	(Landroid/content/Context;Landroid/net/Uri;Z)Ljava/io/InputStream;
    //   6: astore 12
    //   8: aload 12
    //   10: astore 4
    //   12: aload 4
    //   14: ifnull +26 -> 40
    //   17: aload 4
    //   19: invokevirtual 73	java/io/InputStream:available	()I
    //   22: ifle +18 -> 40
    //   25: aload 4
    //   27: invokestatic 78	com/viber/voip/util/dq:a	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   30: astore 18
    //   32: aload 4
    //   34: invokestatic 83	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   37: aload 18
    //   39: areturn
    //   40: aload 4
    //   42: invokestatic 83	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   45: aconst_null
    //   46: areturn
    //   47: astore 11
    //   49: aconst_null
    //   50: astore 4
    //   52: invokestatic 88	com/viber/voip/analytics/g:a	()Lcom/viber/voip/analytics/g;
    //   55: ldc 90
    //   57: ldc 92
    //   59: invokestatic 98	com/viber/voip/analytics/story/l/d:c	(Ljava/lang/String;Ljava/lang/String;)Lcom/viber/voip/analytics/story/e;
    //   62: invokevirtual 101	com/viber/voip/analytics/g:a	(Lcom/viber/voip/analytics/story/e;)V
    //   65: aload 4
    //   67: invokestatic 83	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   70: aconst_null
    //   71: areturn
    //   72: astore 10
    //   74: aconst_null
    //   75: astore 4
    //   77: invokestatic 88	com/viber/voip/analytics/g:a	()Lcom/viber/voip/analytics/g;
    //   80: ldc 90
    //   82: ldc 103
    //   84: invokestatic 98	com/viber/voip/analytics/story/l/d:c	(Ljava/lang/String;Ljava/lang/String;)Lcom/viber/voip/analytics/story/e;
    //   87: invokevirtual 101	com/viber/voip/analytics/g:a	(Lcom/viber/voip/analytics/story/e;)V
    //   90: aload 4
    //   92: invokestatic 83	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   95: aconst_null
    //   96: areturn
    //   97: astore 9
    //   99: aconst_null
    //   100: astore 4
    //   102: invokestatic 88	com/viber/voip/analytics/g:a	()Lcom/viber/voip/analytics/g;
    //   105: ldc 90
    //   107: ldc 105
    //   109: invokestatic 98	com/viber/voip/analytics/story/l/d:c	(Ljava/lang/String;Ljava/lang/String;)Lcom/viber/voip/analytics/story/e;
    //   112: invokevirtual 101	com/viber/voip/analytics/g:a	(Lcom/viber/voip/analytics/story/e;)V
    //   115: invokestatic 111	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
    //   118: invokevirtual 114	com/viber/voip/ViberApplication:onOutOfMemory	()V
    //   121: aload 4
    //   123: invokestatic 83	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   126: aconst_null
    //   127: areturn
    //   128: astore 8
    //   130: aconst_null
    //   131: astore 7
    //   133: invokestatic 88	com/viber/voip/analytics/g:a	()Lcom/viber/voip/analytics/g;
    //   136: ldc 90
    //   138: ldc 116
    //   140: aload 8
    //   142: invokevirtual 122	java/lang/Object:getClass	()Ljava/lang/Class;
    //   145: invokevirtual 127	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   148: aload 8
    //   150: invokevirtual 130	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   153: invokestatic 133	com/viber/voip/analytics/story/l/d:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/viber/voip/analytics/story/e;
    //   156: invokevirtual 101	com/viber/voip/analytics/g:a	(Lcom/viber/voip/analytics/story/e;)V
    //   159: aload 7
    //   161: invokestatic 83	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   164: aconst_null
    //   165: areturn
    //   166: astore 6
    //   168: aconst_null
    //   169: astore 7
    //   171: invokestatic 88	com/viber/voip/analytics/g:a	()Lcom/viber/voip/analytics/g;
    //   174: ldc 90
    //   176: aload 6
    //   178: invokevirtual 136	com/viber/voip/util/upload/b$a:a	()Lcom/viber/voip/util/upload/b$b;
    //   181: invokestatic 139	com/viber/voip/analytics/story/l/d:a	(Ljava/lang/String;Lcom/viber/voip/util/upload/b$b;)Lcom/viber/voip/analytics/story/e;
    //   184: invokevirtual 101	com/viber/voip/analytics/g:a	(Lcom/viber/voip/analytics/story/e;)V
    //   187: aload 7
    //   189: invokestatic 83	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   192: aconst_null
    //   193: areturn
    //   194: astore_3
    //   195: aconst_null
    //   196: astore 4
    //   198: aload_3
    //   199: astore 5
    //   201: aload 4
    //   203: invokestatic 83	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   206: aload 5
    //   208: athrow
    //   209: astore 5
    //   211: goto -10 -> 201
    //   214: astore 5
    //   216: aload 7
    //   218: astore 4
    //   220: goto -19 -> 201
    //   223: astore 17
    //   225: aload 4
    //   227: astore 7
    //   229: aload 17
    //   231: astore 6
    //   233: goto -62 -> 171
    //   236: astore 16
    //   238: aload 4
    //   240: astore 7
    //   242: aload 16
    //   244: astore 8
    //   246: goto -113 -> 133
    //   249: astore 15
    //   251: goto -149 -> 102
    //   254: astore 14
    //   256: goto -179 -> 77
    //   259: astore 13
    //   261: goto -209 -> 52
    //
    // Exception table:
    //   from	to	target	type
    //   0	8	47	java/io/FileNotFoundException
    //   0	8	72	java/io/IOException
    //   0	8	97	java/lang/OutOfMemoryError
    //   0	8	128	java/lang/RuntimeException
    //   0	8	166	com/viber/voip/util/upload/b$a
    //   0	8	194	finally
    //   17	32	209	finally
    //   52	65	209	finally
    //   77	90	209	finally
    //   102	121	209	finally
    //   133	159	214	finally
    //   171	187	214	finally
    //   17	32	223	com/viber/voip/util/upload/b$a
    //   17	32	236	java/lang/RuntimeException
    //   17	32	249	java/lang/OutOfMemoryError
    //   17	32	254	java/io/IOException
    //   17	32	259	java/io/FileNotFoundException
  }

  // ERROR //
  public static android.graphics.Bitmap a(Uri paramUri, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: iload_2
    //   3: iload_3
    //   4: iload 4
    //   6: invokestatic 143	com/viber/voip/util/e/e:b	(Landroid/net/Uri;ZZII)Ljava/io/InputStream;
    //   9: astore 13
    //   11: aload 13
    //   13: astore 6
    //   15: aload 6
    //   17: ifnull +18 -> 35
    //   20: aload 6
    //   22: invokestatic 78	com/viber/voip/util/dq:a	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   25: astore 18
    //   27: aload 6
    //   29: invokestatic 83	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   32: aload 18
    //   34: areturn
    //   35: aload 6
    //   37: invokestatic 83	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   40: aconst_null
    //   41: areturn
    //   42: astore 12
    //   44: aconst_null
    //   45: astore 6
    //   47: invokestatic 88	com/viber/voip/analytics/g:a	()Lcom/viber/voip/analytics/g;
    //   50: ldc 145
    //   52: ldc 92
    //   54: invokestatic 98	com/viber/voip/analytics/story/l/d:c	(Ljava/lang/String;Ljava/lang/String;)Lcom/viber/voip/analytics/story/e;
    //   57: invokevirtual 101	com/viber/voip/analytics/g:a	(Lcom/viber/voip/analytics/story/e;)V
    //   60: aload 6
    //   62: invokestatic 83	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   65: aconst_null
    //   66: areturn
    //   67: astore 11
    //   69: aconst_null
    //   70: astore 9
    //   72: invokestatic 88	com/viber/voip/analytics/g:a	()Lcom/viber/voip/analytics/g;
    //   75: ldc 145
    //   77: aload 11
    //   79: invokevirtual 136	com/viber/voip/util/upload/b$a:a	()Lcom/viber/voip/util/upload/b$b;
    //   82: invokestatic 139	com/viber/voip/analytics/story/l/d:a	(Ljava/lang/String;Lcom/viber/voip/util/upload/b$b;)Lcom/viber/voip/analytics/story/e;
    //   85: invokevirtual 101	com/viber/voip/analytics/g:a	(Lcom/viber/voip/analytics/story/e;)V
    //   88: aload 9
    //   90: invokestatic 83	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   93: aconst_null
    //   94: areturn
    //   95: astore 10
    //   97: aconst_null
    //   98: astore 6
    //   100: invokestatic 88	com/viber/voip/analytics/g:a	()Lcom/viber/voip/analytics/g;
    //   103: ldc 145
    //   105: ldc 105
    //   107: invokestatic 98	com/viber/voip/analytics/story/l/d:c	(Ljava/lang/String;Ljava/lang/String;)Lcom/viber/voip/analytics/story/e;
    //   110: invokevirtual 101	com/viber/voip/analytics/g:a	(Lcom/viber/voip/analytics/story/e;)V
    //   113: invokestatic 111	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
    //   116: invokevirtual 114	com/viber/voip/ViberApplication:onOutOfMemory	()V
    //   119: aload 6
    //   121: invokestatic 83	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   124: aconst_null
    //   125: areturn
    //   126: astore 8
    //   128: aconst_null
    //   129: astore 9
    //   131: invokestatic 88	com/viber/voip/analytics/g:a	()Lcom/viber/voip/analytics/g;
    //   134: ldc 145
    //   136: ldc 116
    //   138: aload 8
    //   140: invokevirtual 122	java/lang/Object:getClass	()Ljava/lang/Class;
    //   143: invokevirtual 127	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   146: aload 8
    //   148: invokevirtual 130	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   151: invokestatic 133	com/viber/voip/analytics/story/l/d:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/viber/voip/analytics/story/e;
    //   154: invokevirtual 101	com/viber/voip/analytics/g:a	(Lcom/viber/voip/analytics/story/e;)V
    //   157: aload 9
    //   159: invokestatic 83	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   162: aconst_null
    //   163: areturn
    //   164: astore 5
    //   166: aconst_null
    //   167: astore 6
    //   169: aload 5
    //   171: astore 7
    //   173: aload 6
    //   175: invokestatic 83	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   178: aload 7
    //   180: athrow
    //   181: astore 7
    //   183: goto -10 -> 173
    //   186: astore 7
    //   188: aload 9
    //   190: astore 6
    //   192: goto -19 -> 173
    //   195: astore 17
    //   197: aload 6
    //   199: astore 9
    //   201: aload 17
    //   203: astore 8
    //   205: goto -74 -> 131
    //   208: astore 16
    //   210: goto -110 -> 100
    //   213: astore 15
    //   215: aload 6
    //   217: astore 9
    //   219: aload 15
    //   221: astore 11
    //   223: goto -151 -> 72
    //   226: astore 14
    //   228: goto -181 -> 47
    //
    // Exception table:
    //   from	to	target	type
    //   0	11	42	java/io/FileNotFoundException
    //   0	11	67	com/viber/voip/util/upload/b$a
    //   0	11	95	java/lang/OutOfMemoryError
    //   0	11	126	java/lang/RuntimeException
    //   0	11	164	finally
    //   20	27	181	finally
    //   47	60	181	finally
    //   100	119	181	finally
    //   72	88	186	finally
    //   131	157	186	finally
    //   20	27	195	java/lang/RuntimeException
    //   20	27	208	java/lang/OutOfMemoryError
    //   20	27	213	com/viber/voip/util/upload/b$a
    //   20	27	226	java/io/FileNotFoundException
  }

  @Deprecated
  public static e a(Context paramContext)
  {
    e locale = ViberApplication.getInstance().getImageFetcher();
    if (locale == null)
      throw new AssertionError("ImageFetcher not found.");
    return locale;
  }

  private static File a(Uri paramUri, Context paramContext)
  {
    String str = paramUri.getLastPathSegment();
    File localFile1 = dv.t.b(paramContext, str, false);
    if (localFile1 == null)
      localFile1 = null;
    File localFile2;
    do
    {
      do
      {
        return localFile1;
        localFile2 = dv.n.b(paramContext, paramUri.toString(), false);
      }
      while (!at.a(localFile2));
      if (at.a(localFile1))
      {
        at.f(localFile2);
        return localFile1;
      }
    }
    while (at.a(localFile2, localFile1));
    at.f(localFile2);
    return localFile1;
  }

  @SuppressLint({"NewApi"})
  public static InputStream a(Context paramContext, Uri paramUri, boolean paramBoolean, int paramInt, String paramString)
    throws FileNotFoundException, b.a
  {
    if (paramUri == null)
      return null;
    String str = paramUri.getScheme();
    if (str == null)
    {
      Uri localUri = paramUri.buildUpon().scheme("file").build();
      return paramContext.getContentResolver().openInputStream(localUri);
    }
    if (str.startsWith("http"))
      return a(paramUri, paramInt, paramString);
    if (paramUri.toString().startsWith(f))
    {
      if (paramBoolean)
        return ContactsContract.Contacts.openContactPhotoInputStream(paramContext.getContentResolver(), paramUri, true);
      return ContactsContract.Contacts.openContactPhotoInputStream(paramContext.getContentResolver(), paramUri);
    }
    return paramContext.getContentResolver().openInputStream(paramUri);
  }

  private static InputStream a(Uri paramUri, int paramInt, String paramString)
    throws FileNotFoundException, b.a
  {
    return a(paramUri, true, true, -2, -2, paramInt, paramString);
  }

  private static InputStream a(Uri paramUri, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, String paramString)
    throws FileNotFoundException, b.a
  {
    String str = b(paramUri, paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramInt3, paramString);
    if (da.a(str))
      return null;
    return new FileInputStream(new File(str));
  }

  public static String a(Uri paramUri)
  {
    try
    {
      String str = c(paramUri, false, false, 0, 0);
      return str;
    }
    catch (b.a locala)
    {
    }
    return null;
  }

  private static String a(Uri paramUri, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3)
    throws b.a
  {
    return b(paramUri, paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramInt3, null);
  }

  private static void a(b.a parama, String paramString)
  {
    if (parama.a() != null)
      switch (2.a[parama.a().ordinal()])
      {
      default:
      case 1:
      case 2:
      }
    while (true)
    {
      if (parama.a().a())
        ViberApplication.getInstance().getDownloadValve().a(paramString);
      return;
      if (dx.b(Uri.parse(paramString)))
        c.c().a(paramString);
    }
  }

  private static boolean a(File paramFile)
  {
    return !paramFile.exists();
  }

  @SuppressLint({"NewApi"})
  public static InputStream b(Context paramContext, Uri paramUri, boolean paramBoolean)
    throws FileNotFoundException, b.a
  {
    return a(paramContext, paramUri, paramBoolean, -1, null);
  }

  private static InputStream b(Uri paramUri, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
    throws FileNotFoundException, b.a
  {
    return a(paramUri, paramBoolean1, paramBoolean2, paramInt1, paramInt2, -1, null);
  }

  private static String b(Uri paramUri, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, String paramString)
    throws b.a
  {
    String str1 = paramUri.toString();
    Application localApplication = ViberApplication.getApplication();
    Object localObject1 = dv.n.b(localApplication, str1, false);
    File localFile1 = at.g((File)localObject1);
    if ((localObject1 == null) || (localFile1 == null))
      return null;
    Object localObject3;
    Object localObject2;
    if (com.viber.voip.messages.extras.map.b.a(str1))
    {
      File localFile8 = dv.r.b(localApplication, str1, false);
      File localFile9 = at.g(localFile8);
      if ((localFile8 == null) || (localFile9 == null))
        return null;
      h localh = new h(str1, localFile8.getPath(), localFile9.getPath(), paramBoolean2, paramBoolean1, paramInt1, paramInt2, ViberApplication.getApplication().getString(R.string.google_map_key));
      localObject3 = null;
      localObject2 = localh;
      localObject1 = localFile8;
      if (paramString != null)
        ((com.viber.voip.util.upload.b)localObject2).a(paramString);
      File localFile2 = ((File)localObject1).getParentFile();
      if (!localFile2.exists())
        localFile2.mkdirs();
      if (a((File)localObject1))
      {
        if (!b(str1))
          break label1225;
        if (!cj.b(localApplication))
          break label1200;
      }
    }
    while (true)
    {
      try
      {
        ((com.viber.voip.util.upload.b)localObject2).a(new b.d()
        {
          public void a(String paramAnonymousString, Response paramAnonymousResponse)
            throws b.a
          {
            if (!bv.a(paramAnonymousResponse.header("Content-Type")));
          }
        });
        ((com.viber.voip.util.upload.b)localObject2).f();
        ViberApplication.getInstance().getDownloadValve().d(str1);
        if (localObject1 == null)
          break label1231;
        return ((File)localObject1).getPath();
        if (str1.contains("stickers/icons"))
        {
          Matcher localMatcher = e.matcher(paramUri.getLastPathSegment());
          if (localMatcher.find())
          {
            localObject1 = new File(g.k(Integer.valueOf(localMatcher.group()).intValue()));
            File localFile7 = at.g((File)localObject1);
            localObject2 = new com.viber.voip.util.upload.b(str1, ((File)localObject1).getPath(), localFile7.getPath());
            localObject3 = null;
            break;
          }
          return null;
        }
        if (dx.l(paramUri))
        {
          localObject1 = dv.q.b(localApplication, str1, false);
          if (localObject1 == null)
            return null;
          dx.b localb = dx.m(paramUri);
          localObject2 = s.a(localApplication, ((File)localObject1).getPath(), localFile1.getPath(), localb.a, localb.b, localb.c);
          localObject3 = null;
          break;
        }
        if (dx.d(paramUri))
        {
          dx.d locald1;
          try
          {
            locald1 = dx.p(paramUri);
            if ((locald1.b == t.d.d) || (locald1.b == t.d.e))
            {
              localObject1 = dv.B.b(localApplication, str1, false);
              if (localObject1 == null)
                return null;
            }
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            d.a(localIllegalArgumentException, "Can't download image");
            return null;
          }
          String str7 = locald1.e;
          localObject2 = s.a(locald1.b, locald1.c, locald1.a, locald1.f, locald1.d, ((File)localObject1).getPath(), localFile1.getPath());
          localObject3 = str7;
          break;
        }
        if (dx.c(paramUri))
        {
          String str6 = paramUri.getLastPathSegment();
          localObject1 = dv.s.b(localApplication, str6, false);
          if (localObject1 == null)
            return null;
          at.e(((File)localObject1).getParentFile());
          localObject2 = s.b(((File)localObject1).getPath(), localFile1.getPath(), str6);
          localObject3 = null;
          break;
        }
        if (dx.b(paramUri))
        {
          String str5 = paramUri.getLastPathSegment();
          localObject1 = a(paramUri, localApplication);
          if (localObject1 == null)
            return null;
          localObject2 = s.a(((File)localObject1).getPath(), localFile1.getPath(), str5);
          localObject3 = null;
          break;
        }
        if (dx.e(paramUri))
        {
          String str4 = (String)paramUri.getPathSegments().get(2);
          localObject2 = new i.e(((File)localObject1).getPath(), localFile1.getPath(), str4, null, t.d.a, i.c.b, i.o.c);
          localObject3 = null;
          break;
        }
        if (dx.f(paramUri))
        {
          File localFile6 = dv.q.b(localApplication, str1, false);
          dx.c localc = new dx.c(paramUri);
          if (localc.d == i.c.d)
          {
            i = 1;
            if (i == 0)
              continue;
            locald = t.d.h;
            i.e locale1 = new i.e(localFile6.getPath(), localFile1.getPath(), localc.a, localc.e, locald, localc.d, localc.c);
            if ((i != 0) && (localc.f != null))
              ((i.e)locale1).a(localc.f.booleanValue());
            localObject2 = locale1;
            localObject1 = localFile6;
            localObject3 = null;
            break;
          }
          int i = 0;
          continue;
          t.d locald = t.d.a;
          continue;
        }
        if (dx.g(paramUri))
        {
          String str3 = dx.i(paramUri);
          localObject1 = dv.C.b(localApplication, str3, false);
          File localFile5 = at.g((File)localObject1);
          if ((localObject1 == null) || (localFile5 == null))
            return null;
          localObject2 = new f(localApplication, str3, ((File)localObject1).getPath(), localFile5.getPath(), paramInt3);
          localObject3 = null;
          break;
        }
        if (dx.h(paramUri))
        {
          String str2 = dx.j(paramUri);
          localObject1 = dv.E.b(localApplication, str2, false);
          File localFile4 = at.g((File)localObject1);
          if ((localObject1 == null) || (localFile4 == null))
            return null;
          localObject2 = new f(localApplication, str2, ((File)localObject1).getPath(), localFile4.getPath(), paramInt3);
          localObject3 = null;
          break;
        }
        if (dx.k(paramUri))
        {
          dx.a locala1 = dx.a(localApplication, paramUri);
          localObject1 = dv.H.b(localApplication, locala1.b(), false);
          File localFile3 = at.g((File)localObject1);
          if ((localObject1 == null) || (localFile3 == null))
            return null;
          localObject2 = new f(localApplication, locala1.a(), ((File)localObject1).getPath(), localFile3.getPath(), paramInt3);
          localObject3 = null;
          break;
        }
        if (dx.n(paramUri))
        {
          dx.e locale = dx.o(paramUri);
          localObject1 = dv.q.b(localApplication, locale.a(), false);
          if ((((File)localObject1).exists()) && (((File)localObject1).length() == 0L))
            ((File)localObject1).delete();
          localObject2 = new p(localApplication, locale.b(), locale.a(), (File)localObject1);
          localObject3 = null;
          break;
        }
        localObject2 = new f(localApplication, str1, ((File)localObject1).getPath(), localFile1.getPath(), paramInt3);
        localObject3 = null;
      }
      catch (b.a locala)
      {
        a(locala, str1);
        throw locala;
      }
      label1200: if (localObject3 != null)
      {
        localObject1 = new File(localObject3);
      }
      else
      {
        localObject1 = null;
        continue;
        label1225: localObject1 = null;
      }
    }
    label1231: return null;
  }

  private void b(Context paramContext)
  {
    c(paramContext);
  }

  private static boolean b(String paramString)
  {
    return ViberApplication.getInstance().getDownloadValve().c(paramString);
  }

  private static String c(Uri paramUri, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
    throws b.a
  {
    return a(paramUri, paramBoolean1, paramBoolean2, paramInt1, paramInt2, -1);
  }

  private void c(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (!localNetworkInfo.isConnectedOrConnecting()));
  }

  // ERROR //
  protected k.d a(Uri paramUri, f paramf)
  {
    // Byte code:
    //   0: bipush 254
    //   2: istore_3
    //   3: aload_2
    //   4: getfield 629	com/viber/voip/util/e/f:n	Ljava/lang/String;
    //   7: ifnull +57 -> 64
    //   10: new 631	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 632	java/lang/StringBuilder:<init>	()V
    //   17: aload_2
    //   18: getfield 629	com/viber/voip/util/e/f:n	Ljava/lang/String;
    //   21: invokevirtual 636	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc_w 638
    //   27: invokevirtual 636	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 639	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: pop
    //   34: aload_1
    //   35: aload_2
    //   36: aload_0
    //   37: getfield 642	com/viber/voip/util/e/e:c	Landroid/content/Context;
    //   40: invokestatic 645	com/viber/voip/util/e/e:a	(Landroid/net/Uri;Lcom/viber/voip/util/e/f;Landroid/content/Context;)Landroid/graphics/Bitmap;
    //   43: astore 13
    //   45: aload 13
    //   47: astore 6
    //   49: new 647	com/viber/voip/util/e/k$d
    //   52: dup
    //   53: iconst_0
    //   54: aload 6
    //   56: invokespecial 650	com/viber/voip/util/e/k$d:<init>	(ILandroid/graphics/Bitmap;)V
    //   59: astore 14
    //   61: aload 14
    //   63: areturn
    //   64: goto -30 -> 34
    //   67: astore 10
    //   69: aconst_null
    //   70: astore 11
    //   72: new 647	com/viber/voip/util/e/k$d
    //   75: dup
    //   76: iconst_m1
    //   77: aload 11
    //   79: invokespecial 650	com/viber/voip/util/e/k$d:<init>	(ILandroid/graphics/Bitmap;)V
    //   82: astore 12
    //   84: invokestatic 88	com/viber/voip/analytics/g:a	()Lcom/viber/voip/analytics/g;
    //   87: ldc_w 652
    //   90: ldc 92
    //   92: invokestatic 98	com/viber/voip/analytics/story/l/d:c	(Ljava/lang/String;Ljava/lang/String;)Lcom/viber/voip/analytics/story/e;
    //   95: invokevirtual 101	com/viber/voip/analytics/g:a	(Lcom/viber/voip/analytics/story/e;)V
    //   98: aload 12
    //   100: areturn
    //   101: astore 9
    //   103: aconst_null
    //   104: astore 6
    //   106: invokestatic 88	com/viber/voip/analytics/g:a	()Lcom/viber/voip/analytics/g;
    //   109: ldc_w 652
    //   112: ldc 103
    //   114: invokestatic 98	com/viber/voip/analytics/story/l/d:c	(Ljava/lang/String;Ljava/lang/String;)Lcom/viber/voip/analytics/story/e;
    //   117: invokevirtual 101	com/viber/voip/analytics/g:a	(Lcom/viber/voip/analytics/story/e;)V
    //   120: new 647	com/viber/voip/util/e/k$d
    //   123: dup
    //   124: iload_3
    //   125: aload 6
    //   127: invokespecial 650	com/viber/voip/util/e/k$d:<init>	(ILandroid/graphics/Bitmap;)V
    //   130: areturn
    //   131: astore 7
    //   133: aconst_null
    //   134: astore 6
    //   136: invokestatic 88	com/viber/voip/analytics/g:a	()Lcom/viber/voip/analytics/g;
    //   139: ldc_w 652
    //   142: ldc 105
    //   144: invokestatic 98	com/viber/voip/analytics/story/l/d:c	(Ljava/lang/String;Ljava/lang/String;)Lcom/viber/voip/analytics/story/e;
    //   147: invokevirtual 101	com/viber/voip/analytics/g:a	(Lcom/viber/voip/analytics/story/e;)V
    //   150: new 647	com/viber/voip/util/e/k$d
    //   153: dup
    //   154: bipush 253
    //   156: aload 6
    //   158: invokespecial 650	com/viber/voip/util/e/k$d:<init>	(ILandroid/graphics/Bitmap;)V
    //   161: astore 8
    //   163: invokestatic 111	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
    //   166: invokevirtual 114	com/viber/voip/ViberApplication:onOutOfMemory	()V
    //   169: aload 8
    //   171: areturn
    //   172: astore 5
    //   174: aconst_null
    //   175: astore 6
    //   177: invokestatic 88	com/viber/voip/analytics/g:a	()Lcom/viber/voip/analytics/g;
    //   180: ldc_w 652
    //   183: ldc 116
    //   185: aload 5
    //   187: invokevirtual 122	java/lang/Object:getClass	()Ljava/lang/Class;
    //   190: invokevirtual 127	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   193: aload 5
    //   195: invokevirtual 130	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   198: invokestatic 133	com/viber/voip/analytics/story/l/d:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/viber/voip/analytics/story/e;
    //   201: invokevirtual 101	com/viber/voip/analytics/g:a	(Lcom/viber/voip/analytics/story/e;)V
    //   204: new 647	com/viber/voip/util/e/k$d
    //   207: dup
    //   208: bipush 252
    //   210: aload 6
    //   212: invokespecial 650	com/viber/voip/util/e/k$d:<init>	(ILandroid/graphics/Bitmap;)V
    //   215: areturn
    //   216: astore 4
    //   218: invokestatic 88	com/viber/voip/analytics/g:a	()Lcom/viber/voip/analytics/g;
    //   221: ldc_w 652
    //   224: aload 4
    //   226: invokevirtual 136	com/viber/voip/util/upload/b$a:a	()Lcom/viber/voip/util/upload/b$b;
    //   229: invokestatic 139	com/viber/voip/analytics/story/l/d:a	(Ljava/lang/String;Lcom/viber/voip/util/upload/b$b;)Lcom/viber/voip/analytics/story/e;
    //   232: invokevirtual 101	com/viber/voip/analytics/g:a	(Lcom/viber/voip/analytics/story/e;)V
    //   235: aload 4
    //   237: invokevirtual 136	com/viber/voip/util/upload/b$a:a	()Lcom/viber/voip/util/upload/b$b;
    //   240: getstatic 655	com/viber/voip/util/upload/b$b:f	Lcom/viber/voip/util/upload/b$b;
    //   243: if_acmpne +6 -> 249
    //   246: bipush 251
    //   248: istore_3
    //   249: new 647	com/viber/voip/util/e/k$d
    //   252: dup
    //   253: iload_3
    //   254: aconst_null
    //   255: invokespecial 650	com/viber/voip/util/e/k$d:<init>	(ILandroid/graphics/Bitmap;)V
    //   258: areturn
    //   259: astore 5
    //   261: goto -84 -> 177
    //   264: astore 17
    //   266: goto -130 -> 136
    //   269: astore 16
    //   271: goto -165 -> 106
    //   274: astore 15
    //   276: aload 6
    //   278: astore 11
    //   280: goto -208 -> 72
    //
    // Exception table:
    //   from	to	target	type
    //   34	45	67	java/io/FileNotFoundException
    //   34	45	101	java/io/IOException
    //   34	45	131	java/lang/OutOfMemoryError
    //   34	45	172	java/lang/RuntimeException
    //   34	45	216	com/viber/voip/util/upload/b$a
    //   49	61	216	com/viber/voip/util/upload/b$a
    //   49	61	259	java/lang/RuntimeException
    //   49	61	264	java/lang/OutOfMemoryError
    //   49	61	269	java/io/IOException
    //   49	61	274	java/io/FileNotFoundException
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.e.e
 * JD-Core Version:    0.6.2
 */