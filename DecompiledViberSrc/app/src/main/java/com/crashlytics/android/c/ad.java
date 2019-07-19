package com.crashlytics.android.c;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class ad
{
  private static final Charset a = Charset.forName("UTF-8");
  private final File b;

  public ad(File paramFile)
  {
    this.b = paramFile;
  }

  private static String a(Map<String, String> paramMap)
    throws JSONException
  {
    return new JSONObject(paramMap).toString();
  }

  private static String a(JSONObject paramJSONObject, String paramString)
  {
    boolean bool = paramJSONObject.isNull(paramString);
    String str = null;
    if (!bool)
      str = paramJSONObject.optString(paramString, null);
    return str;
  }

  private static ay d(String paramString)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject(paramString);
    return new ay(a(localJSONObject, "userId"), a(localJSONObject, "userName"), a(localJSONObject, "userEmail"));
  }

  // ERROR //
  public ay a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 70	com/crashlytics/android/c/ad:b	(Ljava/lang/String;)Ljava/io/File;
    //   5: astore_2
    //   6: aload_2
    //   7: invokevirtual 76	java/io/File:exists	()Z
    //   10: ifne +7 -> 17
    //   13: getstatic 79	com/crashlytics/android/c/ay:a	Lcom/crashlytics/android/c/ay;
    //   16: areturn
    //   17: new 81	java/io/FileInputStream
    //   20: dup
    //   21: aload_2
    //   22: invokespecial 83	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   25: astore_3
    //   26: aload_3
    //   27: invokestatic 88	c/a/a/a/a/b/i:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   30: invokestatic 90	com/crashlytics/android/c/ad:d	(Ljava/lang/String;)Lcom/crashlytics/android/c/ay;
    //   33: astore 6
    //   35: aload_3
    //   36: ldc 92
    //   38: invokestatic 95	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   41: aload 6
    //   43: areturn
    //   44: astore 4
    //   46: aconst_null
    //   47: astore_3
    //   48: invokestatic 101	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   51: ldc 103
    //   53: ldc 105
    //   55: aload 4
    //   57: invokeinterface 111 4 0
    //   62: aload_3
    //   63: ldc 92
    //   65: invokestatic 95	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   68: getstatic 79	com/crashlytics/android/c/ay:a	Lcom/crashlytics/android/c/ay;
    //   71: areturn
    //   72: astore 5
    //   74: aconst_null
    //   75: astore_3
    //   76: aload_3
    //   77: ldc 92
    //   79: invokestatic 95	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   82: aload 5
    //   84: athrow
    //   85: astore 5
    //   87: goto -11 -> 76
    //   90: astore 4
    //   92: goto -44 -> 48
    //
    // Exception table:
    //   from	to	target	type
    //   17	26	44	java/lang/Exception
    //   17	26	72	finally
    //   26	35	85	finally
    //   48	62	85	finally
    //   26	35	90	java/lang/Exception
  }

  // ERROR //
  public void a(String paramString, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 115	com/crashlytics/android/c/ad:c	(Ljava/lang/String;)Ljava/io/File;
    //   5: astore_3
    //   6: aconst_null
    //   7: astore 4
    //   9: aload_2
    //   10: invokestatic 117	com/crashlytics/android/c/ad:a	(Ljava/util/Map;)Ljava/lang/String;
    //   13: astore 8
    //   15: new 119	java/io/BufferedWriter
    //   18: dup
    //   19: new 121	java/io/OutputStreamWriter
    //   22: dup
    //   23: new 123	java/io/FileOutputStream
    //   26: dup
    //   27: aload_3
    //   28: invokespecial 124	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   31: getstatic 20	com/crashlytics/android/c/ad:a	Ljava/nio/charset/Charset;
    //   34: invokespecial 127	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   37: invokespecial 130	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   40: astore 7
    //   42: aload 7
    //   44: aload 8
    //   46: invokevirtual 135	java/io/Writer:write	(Ljava/lang/String;)V
    //   49: aload 7
    //   51: invokevirtual 138	java/io/Writer:flush	()V
    //   54: aload 7
    //   56: ldc 140
    //   58: invokestatic 95	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   61: return
    //   62: astore 6
    //   64: aconst_null
    //   65: astore 7
    //   67: invokestatic 101	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   70: ldc 103
    //   72: ldc 142
    //   74: aload 6
    //   76: invokeinterface 111 4 0
    //   81: aload 7
    //   83: ldc 140
    //   85: invokestatic 95	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   88: return
    //   89: astore 5
    //   91: aload 4
    //   93: ldc 140
    //   95: invokestatic 95	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   98: aload 5
    //   100: athrow
    //   101: astore 5
    //   103: aload 7
    //   105: astore 4
    //   107: goto -16 -> 91
    //   110: astore 6
    //   112: goto -45 -> 67
    //
    // Exception table:
    //   from	to	target	type
    //   9	42	62	java/lang/Exception
    //   9	42	89	finally
    //   42	54	101	finally
    //   67	81	101	finally
    //   42	54	110	java/lang/Exception
  }

  public File b(String paramString)
  {
    return new File(this.b, paramString + "user" + ".meta");
  }

  public File c(String paramString)
  {
    return new File(this.b, paramString + "keys" + ".meta");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.ad
 * JD-Core Version:    0.6.2
 */