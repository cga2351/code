package c.a.a.a;

import android.os.SystemClock;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

class e
  implements Callable<Map<String, k>>
{
  final String a;

  e(String paramString)
  {
    this.a = paramString;
  }

  // ERROR //
  private k a(ZipEntry paramZipEntry, ZipFile paramZipFile)
  {
    // Byte code:
    //   0: aload_2
    //   1: aload_1
    //   2: invokevirtual 25	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   5: astore 6
    //   7: aload 6
    //   9: astore 4
    //   11: new 27	java/util/Properties
    //   14: dup
    //   15: invokespecial 28	java/util/Properties:<init>	()V
    //   18: astore 7
    //   20: aload 7
    //   22: aload 4
    //   24: invokevirtual 32	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   27: aload 7
    //   29: ldc 34
    //   31: invokevirtual 38	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   34: astore 8
    //   36: aload 7
    //   38: ldc 40
    //   40: invokevirtual 38	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore 9
    //   45: aload 7
    //   47: ldc 42
    //   49: invokevirtual 38	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   52: astore 10
    //   54: aload 8
    //   56: invokestatic 48	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   59: ifne +11 -> 70
    //   62: aload 9
    //   64: invokestatic 48	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   67: ifeq +74 -> 141
    //   70: new 50	java/lang/IllegalStateException
    //   73: dup
    //   74: new 52	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   81: ldc 55
    //   83: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_1
    //   87: invokevirtual 65	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   90: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokespecial 70	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   99: athrow
    //   100: astore_3
    //   101: invokestatic 76	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   104: ldc 78
    //   106: new 52	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   113: ldc 80
    //   115: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_1
    //   119: invokevirtual 65	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   122: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: aload_3
    //   129: invokeinterface 86 4 0
    //   134: aload 4
    //   136: invokestatic 91	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;)V
    //   139: aconst_null
    //   140: areturn
    //   141: new 93	c/a/a/a/k
    //   144: dup
    //   145: aload 8
    //   147: aload 9
    //   149: aload 10
    //   151: invokespecial 96	c/a/a/a/k:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   154: astore 11
    //   156: aload 4
    //   158: invokestatic 91	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;)V
    //   161: aload 11
    //   163: areturn
    //   164: astore 5
    //   166: aconst_null
    //   167: astore 4
    //   169: aload 4
    //   171: invokestatic 91	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;)V
    //   174: aload 5
    //   176: athrow
    //   177: astore 5
    //   179: goto -10 -> 169
    //   182: astore_3
    //   183: aconst_null
    //   184: astore 4
    //   186: goto -85 -> 101
    //
    // Exception table:
    //   from	to	target	type
    //   11	70	100	java/io/IOException
    //   70	100	100	java/io/IOException
    //   141	156	100	java/io/IOException
    //   0	7	164	finally
    //   11	70	177	finally
    //   70	100	177	finally
    //   101	134	177	finally
    //   141	156	177	finally
    //   0	7	182	java/io/IOException
  }

  private Map<String, k> c()
  {
    HashMap localHashMap = new HashMap();
    try
    {
      Class.forName("com.google.android.gms.ads.AdView");
      k localk = new k("com.google.firebase.firebase-ads", "0.0.0", "binary");
      localHashMap.put(localk.a(), localk);
      c.g().b("Fabric", "Found kit: com.google.firebase.firebase-ads");
      return localHashMap;
    }
    catch (Exception localException)
    {
    }
    return localHashMap;
  }

  private Map<String, k> d()
    throws Exception
  {
    HashMap localHashMap = new HashMap();
    ZipFile localZipFile = b();
    Enumeration localEnumeration = localZipFile.entries();
    while (localEnumeration.hasMoreElements())
    {
      ZipEntry localZipEntry = (ZipEntry)localEnumeration.nextElement();
      if ((localZipEntry.getName().startsWith("fabric/")) && (localZipEntry.getName().length() > "fabric/".length()))
      {
        k localk = a(localZipEntry, localZipFile);
        if (localk != null)
        {
          localHashMap.put(localk.a(), localk);
          l locall = c.g();
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = localk.a();
          arrayOfObject[1] = localk.b();
          locall.b("Fabric", String.format("Found kit:[%s] version:[%s]", arrayOfObject));
        }
      }
    }
    if (localZipFile != null);
    try
    {
      localZipFile.close();
      return localHashMap;
    }
    catch (IOException localIOException)
    {
    }
    return localHashMap;
  }

  public Map<String, k> a()
    throws Exception
  {
    HashMap localHashMap = new HashMap();
    long l = SystemClock.elapsedRealtime();
    localHashMap.putAll(c());
    localHashMap.putAll(d());
    c.g().b("Fabric", "finish scanning in " + (SystemClock.elapsedRealtime() - l));
    return localHashMap;
  }

  protected ZipFile b()
    throws IOException
  {
    return new ZipFile(this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.e
 * JD-Core Version:    0.6.2
 */