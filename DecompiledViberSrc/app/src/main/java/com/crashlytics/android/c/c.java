package com.crashlytics.android.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import c.a.a.a.l;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class c
{
  private final Context a;
  private final a b;

  c(Context paramContext, a parama)
  {
    this.a = paramContext;
    this.b = parama;
  }

  private File a(File paramFile)
  {
    if (Build.VERSION.SDK_INT < 9);
    while (!paramFile.getAbsolutePath().startsWith("/data"))
      return paramFile;
    try
    {
      File localFile = new File(this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 0).nativeLibraryDir, paramFile.getName());
      return localFile;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      c.a.a.a.c.g().e("CrashlyticsCore", "Error getting ApplicationInfo", localNameNotFoundException);
    }
    return paramFile;
  }

  private static JSONObject a(String paramString, al paramal)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("base_address", paramal.a);
    localJSONObject.put("size", paramal.b);
    localJSONObject.put("name", paramal.d);
    localJSONObject.put("uuid", paramString);
    return localJSONObject;
  }

  private static boolean a(al paramal)
  {
    return (paramal.c.indexOf('x') != -1) && (paramal.d.indexOf('/') != -1);
  }

  private static byte[] a(JSONArray paramJSONArray)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("binary_images", paramJSONArray);
      return localJSONObject.toString().getBytes();
    }
    catch (JSONException localJSONException)
    {
      c.a.a.a.c.g().d("CrashlyticsCore", "Binary images string is null", localJSONException);
    }
    return new byte[0];
  }

  private static String b(JSONArray paramJSONArray)
    throws JSONException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < paramJSONArray.length(); i++)
      localStringBuilder.append(paramJSONArray.getString(i));
    return localStringBuilder.toString();
  }

  private JSONArray b(BufferedReader paramBufferedReader)
    throws IOException
  {
    JSONArray localJSONArray = new JSONArray();
    while (true)
    {
      String str = paramBufferedReader.readLine();
      if (str == null)
        break;
      JSONObject localJSONObject = c(str);
      if (localJSONObject != null)
        localJSONArray.put(localJSONObject);
    }
    return localJSONArray;
  }

  private JSONArray b(String paramString)
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      String str = b(new JSONObject(paramString).getJSONArray("maps"));
      String[] arrayOfString = str.split("\\|");
      for (int i = 0; i < arrayOfString.length; i++)
      {
        JSONObject localJSONObject = c(arrayOfString[i]);
        if (localJSONObject != null)
          localJSONArray.put(localJSONObject);
      }
    }
    catch (JSONException localJSONException)
    {
      c.a.a.a.c.g().d("CrashlyticsCore", "Unable to parse proc maps string", localJSONException);
      return localJSONArray;
    }
    return localJSONArray;
  }

  // ERROR //
  private JSONObject c(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 194	com/crashlytics/android/c/am:a	(Ljava/lang/String;)Lcom/crashlytics/android/c/al;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnull +10 -> 16
    //   9: aload_2
    //   10: invokestatic 196	com/crashlytics/android/c/c:a	(Lcom/crashlytics/android/c/al;)Z
    //   13: ifne +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: aload_2
    //   20: getfield 109	com/crashlytics/android/c/al:d	Ljava/lang/String;
    //   23: invokespecial 199	com/crashlytics/android/c/c:d	(Ljava/lang/String;)Ljava/io/File;
    //   26: astore_3
    //   27: aload_0
    //   28: getfield 17	com/crashlytics/android/c/c:b	Lcom/crashlytics/android/c/c$a;
    //   31: aload_3
    //   32: invokeinterface 204 2 0
    //   37: astore 5
    //   39: aload 5
    //   41: aload_2
    //   42: invokestatic 206	com/crashlytics/android/c/c:a	(Ljava/lang/String;Lcom/crashlytics/android/c/al;)Lorg/json/JSONObject;
    //   45: astore 7
    //   47: aload 7
    //   49: areturn
    //   50: astore 4
    //   52: invokestatic 73	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   55: ldc 75
    //   57: new 139	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   64: ldc 208
    //   66: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_2
    //   70: getfield 109	com/crashlytics/android/c/al:d	Ljava/lang/String;
    //   73: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: aload 4
    //   81: invokeinterface 210 4 0
    //   86: aconst_null
    //   87: areturn
    //   88: astore 6
    //   90: invokestatic 73	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   93: ldc 75
    //   95: ldc 212
    //   97: aload 6
    //   99: invokeinterface 210 4 0
    //   104: aconst_null
    //   105: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   27	39	50	java/io/IOException
    //   39	47	88	org/json/JSONException
  }

  private File d(String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists())
      localFile = a(localFile);
    return localFile;
  }

  byte[] a(BufferedReader paramBufferedReader)
    throws IOException
  {
    return a(b(paramBufferedReader));
  }

  byte[] a(String paramString)
    throws IOException
  {
    return a(b(paramString));
  }

  static abstract interface a
  {
    public abstract String a(File paramFile)
      throws IOException;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.c
 * JD-Core Version:    0.6.2
 */