package c.a.a.a.a.b;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import c.a.a.a.c;
import c.a.a.a.l;

public class g
{
  protected String a()
  {
    return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
  }

  public String a(Context paramContext)
  {
    String str = c(paramContext);
    if (TextUtils.isEmpty(str))
      str = d(paramContext);
    if (TextUtils.isEmpty(str))
      str = b(paramContext);
    if (TextUtils.isEmpty(str))
      e(paramContext);
    return str;
  }

  protected String b(Context paramContext)
  {
    return new r().a(paramContext);
  }

  // ERROR //
  protected String c(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: invokevirtual 44	android/content/Context:getPackageName	()Ljava/lang/String;
    //   6: astore 4
    //   8: aload_1
    //   9: invokevirtual 48	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   12: aload 4
    //   14: sipush 128
    //   17: invokevirtual 54	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   20: getfield 60	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   23: astore 5
    //   25: aconst_null
    //   26: astore_2
    //   27: aload 5
    //   29: ifnull +62 -> 91
    //   32: aload 5
    //   34: ldc 62
    //   36: invokevirtual 68	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   39: astore 6
    //   41: ldc 70
    //   43: aload 6
    //   45: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   48: ifeq +88 -> 136
    //   51: invokestatic 82	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   54: ldc 84
    //   56: ldc 86
    //   58: invokeinterface 91 3 0
    //   63: aload_2
    //   64: ifnonnull +27 -> 91
    //   67: invokestatic 82	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   70: ldc 84
    //   72: ldc 93
    //   74: invokeinterface 91 3 0
    //   79: aload 5
    //   81: ldc 95
    //   83: invokevirtual 68	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   86: astore 8
    //   88: aload 8
    //   90: astore_2
    //   91: aload_2
    //   92: areturn
    //   93: astore_3
    //   94: invokestatic 82	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   97: ldc 84
    //   99: new 97	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   106: ldc 100
    //   108: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_3
    //   112: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokeinterface 91 3 0
    //   123: aload_2
    //   124: areturn
    //   125: astore 7
    //   127: aload 6
    //   129: astore_2
    //   130: aload 7
    //   132: astore_3
    //   133: goto -39 -> 94
    //   136: aload 6
    //   138: astore_2
    //   139: goto -76 -> 63
    //
    // Exception table:
    //   from	to	target	type
    //   2	25	93	java/lang/Exception
    //   32	41	93	java/lang/Exception
    //   67	88	93	java/lang/Exception
    //   41	63	125	java/lang/Exception
  }

  protected String d(Context paramContext)
  {
    int i = i.a(paramContext, "io.fabric.ApiKey", "string");
    if (i == 0)
    {
      c.g().a("Fabric", "Falling back to Crashlytics key lookup from Strings");
      i = i.a(paramContext, "com.crashlytics.ApiKey", "string");
    }
    String str = null;
    if (i != 0)
      str = paramContext.getResources().getString(i);
    return str;
  }

  protected void e(Context paramContext)
  {
    if ((c.h()) || (i.i(paramContext)))
      throw new IllegalArgumentException(a());
    c.g().e("Fabric", a());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.b.g
 * JD-Core Version:    0.6.2
 */