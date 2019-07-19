package com.viber.voip.registration;

import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.p;
import com.viber.voip.settings.d.x;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.z;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class s
{
  public static byte a = 0;
  public static byte b = 1;
  public static byte c = 2;
  public static byte d = 3;
  private static final Logger e = ViberEnv.getLogger();
  private static String f;
  private static a g;
  private static byte h = a;

  // ERROR //
  private static a a(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: getstatic 44	com/viber/voip/registration/s:f	Ljava/lang/String;
    //   7: invokevirtual 50	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifeq +14 -> 24
    //   13: getstatic 52	com/viber/voip/registration/s:g	Lcom/viber/voip/registration/s$a;
    //   16: astore 12
    //   18: ldc 2
    //   20: monitorexit
    //   21: aload 12
    //   23: areturn
    //   24: ldc 2
    //   26: monitorexit
    //   27: new 54	java/io/FileInputStream
    //   30: dup
    //   31: invokestatic 59	com/viber/voip/p:a	()Ljava/lang/String;
    //   34: invokespecial 62	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   37: astore_2
    //   38: sipush 1024
    //   41: newarray byte
    //   43: astore 6
    //   45: aload_2
    //   46: aload 6
    //   48: invokevirtual 66	java/io/FileInputStream:read	([B)I
    //   51: istore 7
    //   53: iload 7
    //   55: newarray byte
    //   57: astore 8
    //   59: aload 6
    //   61: iconst_0
    //   62: aload 8
    //   64: iconst_0
    //   65: iload 7
    //   67: invokestatic 72	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   70: aload_0
    //   71: new 46	java/lang/String
    //   74: dup
    //   75: aload 8
    //   77: invokespecial 75	java/lang/String:<init>	([B)V
    //   80: invokestatic 80	com/viber/voip/util/z:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   83: invokestatic 84	com/viber/voip/registration/s$a:a	(Ljava/lang/String;)Lcom/viber/voip/registration/s$a;
    //   86: astore 9
    //   88: ldc 2
    //   90: monitorenter
    //   91: aload_0
    //   92: putstatic 44	com/viber/voip/registration/s:f	Ljava/lang/String;
    //   95: aload 9
    //   97: putstatic 52	com/viber/voip/registration/s:g	Lcom/viber/voip/registration/s$a;
    //   100: ldc 2
    //   102: monitorexit
    //   103: aload 9
    //   105: invokestatic 87	com/viber/voip/registration/s:a	(Lcom/viber/voip/registration/s$a;)V
    //   108: aload_2
    //   109: invokestatic 92	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   112: aload 9
    //   114: areturn
    //   115: astore_1
    //   116: ldc 2
    //   118: monitorexit
    //   119: aload_1
    //   120: athrow
    //   121: astore 10
    //   123: ldc 2
    //   125: monitorexit
    //   126: aload 10
    //   128: athrow
    //   129: astore 4
    //   131: aload_2
    //   132: astore 5
    //   134: aload 5
    //   136: invokestatic 92	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   139: aconst_null
    //   140: invokestatic 87	com/viber/voip/registration/s:a	(Lcom/viber/voip/registration/s$a;)V
    //   143: aconst_null
    //   144: areturn
    //   145: astore_3
    //   146: aconst_null
    //   147: astore_2
    //   148: aload_2
    //   149: invokestatic 92	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   152: aload_3
    //   153: athrow
    //   154: astore_3
    //   155: goto -7 -> 148
    //   158: astore 11
    //   160: aconst_null
    //   161: astore 5
    //   163: goto -29 -> 134
    //
    // Exception table:
    //   from	to	target	type
    //   3	21	115	finally
    //   24	27	115	finally
    //   116	119	115	finally
    //   91	103	121	finally
    //   123	126	121	finally
    //   38	91	129	java/lang/Exception
    //   103	108	129	java/lang/Exception
    //   126	129	129	java/lang/Exception
    //   27	38	145	finally
    //   38	91	154	finally
    //   103	108	154	finally
    //   126	129	154	finally
    //   27	38	158	java/lang/Exception
  }

  public static String a()
  {
    ViberApplication localViberApplication = ViberApplication.getInstance();
    af localaf = UserManager.from(ViberApplication.getApplication()).getRegistrationValues();
    String str1 = localaf.g();
    String str4;
    if (str1 == null)
    {
      String str2 = localaf.b();
      String str3 = localaf.f();
      if ((!TextUtils.isEmpty(str2)) && (!"0".equals(str2)) && (!TextUtils.isEmpty(str3)) && (!"0".equals(str3)))
      {
        str4 = str2 + str3;
        str1 = localViberApplication.getEngine(true).getPhoneController().canonizePhoneNumberForCountryCode(Integer.valueOf(str2).intValue(), str3);
        if (TextUtils.isEmpty(str1))
          break label121;
      }
    }
    return str1;
    label121: return str4;
  }

  public static String a(ao.b paramb)
  {
    String str1 = a();
    String str2;
    if (TextUtils.isEmpty(str1))
      str2 = null;
    a locala;
    do
    {
      return str2;
      str2 = "";
      locala = a(str1);
    }
    while ((locala == null) || (!str1.equals(locala.a)));
    return locala.a(paramb);
  }

  public static void a(byte paramByte)
  {
    h = paramByte;
  }

  public static void a(ao.b paramb, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      paramString = "";
    String str = a();
    if (!TextUtils.isEmpty(str))
    {
      a locala = a(str);
      if ((locala == null) || (!locala.a.equals(str)))
      {
        new File(p.a).mkdirs();
        locala = new a(str);
      }
      locala.a(paramb, paramString);
      a(str, locala);
    }
  }

  private static void a(a parama)
  {
    long l1 = 0L;
    if ((parama != null) && (!TextUtils.isEmpty(parama.g)));
    try
    {
      long l2 = Long.parseLong(parama.g);
      l1 = l2;
      label28: d.x.c.a(l1);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label28;
    }
  }

  private static void a(String paramString, a parama)
  {
    try
    {
      String str = z.b(paramString, a.a(parama));
      FileOutputStream localFileOutputStream = new FileOutputStream(p.a());
      localFileOutputStream.write(str.getBytes());
      localFileOutputStream.flush();
      localFileOutputStream.close();
      try
      {
        f = paramString;
        g = parama;
        a(parama);
        label58: g();
        return;
      }
      finally
      {
      }
    }
    catch (Exception localException)
    {
      break label58;
    }
  }

  public static void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1));
    for (a locala = null; (locala == null) || (!paramString1.equals(locala.a)); locala = a(paramString1))
      return;
    locala.a = paramString2;
    a(paramString2, locala);
  }

  public static void b()
  {
    b(ao.b.a);
    b(ao.b.b);
    b(ao.b.c);
    b(ao.b.d);
  }

  public static boolean b(ao.b paramb)
  {
    String str = a(paramb);
    if ((str != null) && (!str.equals("")))
    {
      a(paramb, "");
      return true;
    }
    return false;
  }

  public static void c()
  {
    ViberApplication.getInstance().getBackupManager().a();
  }

  public static void d()
  {
    g = null;
    f = null;
    String str = a();
    if (!TextUtils.isEmpty(str))
      a(str);
  }

  public static byte e()
  {
    return h;
  }

  public static void f()
  {
    if (d.x.c.d() != 0L);
    String str;
    a locala;
    do
    {
      do
      {
        return;
        str = a();
      }
      while (TextUtils.isEmpty(str));
      locala = a(str);
    }
    while ((locala == null) || (!TextUtils.isEmpty(locala.g)));
    locala.a();
    a(str, locala);
  }

  private static void g()
  {
    ViberApplication.getInstance().getBackupManager().b();
  }

  public static class a
  {
    public String a = "";
    public String b = "";
    public String c = "";
    public String d = "";
    public String e = "";
    public String f = "";
    public String g = "";

    public a(String paramString)
    {
      this.a = paramString;
    }

    public static a a(String paramString)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        a locala = new a(localJSONObject.getString("number"));
        locala.b = localJSONObject.getString("udid");
        locala.c = localJSONObject.getString("secondary_udid");
        locala.d = localJSONObject.getString("device_key");
        locala.e = localJSONObject.getString("secondary_device_key");
        if (localJSONObject.has("rakuten_r_token"))
          locala.f = localJSONObject.getString("rakuten_r_token");
        locala.g = localJSONObject.optString("modified_date", "");
        return locala;
      }
      catch (JSONException localJSONException)
      {
      }
      return null;
    }

    public static String a(a parama)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("number", parama.a);
        localJSONObject.put("udid", parama.b);
        localJSONObject.put("secondary_udid", parama.c);
        localJSONObject.put("device_key", parama.d);
        localJSONObject.put("secondary_device_key", parama.e);
        localJSONObject.put("rakuten_r_token", parama.f);
        localJSONObject.put("modified_date", parama.g);
        String str = localJSONObject.toString();
        return str;
      }
      catch (JSONException localJSONException)
      {
      }
      return null;
    }

    public String a(ao.b paramb)
    {
      switch (s.1.a[paramb.ordinal()])
      {
      default:
        return "";
      case 1:
        return this.b;
      case 2:
        return this.c;
      case 3:
        return this.d;
      case 4:
        return this.e;
      case 5:
        return this.f;
      case 6:
      }
      return this.g;
    }

    void a()
    {
      this.g = Long.toString(System.currentTimeMillis());
    }

    public void a(ao.b paramb, String paramString)
    {
      if (paramb != ao.b.f)
        a();
      switch (s.1.a[paramb.ordinal()])
      {
      default:
        return;
      case 1:
        this.b = paramString;
        return;
      case 2:
        this.c = paramString;
        return;
      case 3:
        this.d = paramString;
        return;
      case 4:
        this.e = paramString;
        return;
      case 5:
        this.f = paramString;
        return;
      case 6:
      }
      this.g = paramString;
    }

    public String toString()
    {
      return "Keychain{number='" + this.a + '\'' + ", udid='" + this.b + '\'' + ", secondaryUdid='" + this.c + '\'' + ", deviceKey='" + this.d + '\'' + ", secondaryDeviceKey='" + this.e + '\'' + ", rakutenRToken='" + this.f + '\'' + ", modifiedDate='" + this.g + '\'' + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.s
 * JD-Core Version:    0.6.2
 */