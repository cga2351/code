package com.viber.voip.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class bx
{
  private static final Logger a = ViberEnv.getLogger();
  private static bx i;
  private static final Object j = new Object();
  private final Context b;
  private final Boolean c;
  private final Boolean d;
  private final DisplayMetrics e;
  private final String f;
  private final Integer g;
  private final String h;

  // ERROR //
  private bx(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 35	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: aload_1
    //   6: putfield 48	com/viber/voip/util/bx:b	Landroid/content/Context;
    //   9: aload_0
    //   10: getfield 48	com/viber/voip/util/bx:b	Landroid/content/Context;
    //   13: invokevirtual 54	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   16: astore_2
    //   17: aload_2
    //   18: aload_0
    //   19: getfield 48	com/viber/voip/util/bx:b	Landroid/content/Context;
    //   22: invokevirtual 58	android/content/Context:getPackageName	()Ljava/lang/String;
    //   25: iconst_0
    //   26: invokevirtual 64	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   29: astore 21
    //   31: aload 21
    //   33: getfield 69	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   36: astore 5
    //   38: aload 21
    //   40: getfield 73	android/content/pm/PackageInfo:versionCode	I
    //   43: invokestatic 79	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: astore 23
    //   48: aload 23
    //   50: astore 6
    //   52: aload_1
    //   53: invokevirtual 83	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   56: astore 7
    //   58: aload 7
    //   60: getfield 88	android/content/pm/ApplicationInfo:labelRes	I
    //   63: istore 8
    //   65: aload_0
    //   66: aload 5
    //   68: putfield 90	com/viber/voip/util/bx:f	Ljava/lang/String;
    //   71: aload_0
    //   72: aload 6
    //   74: putfield 92	com/viber/voip/util/bx:g	Ljava/lang/Integer;
    //   77: iload 8
    //   79: ifne +175 -> 254
    //   82: aload 7
    //   84: getfield 96	android/content/pm/ApplicationInfo:nonLocalizedLabel	Ljava/lang/CharSequence;
    //   87: ifnonnull +152 -> 239
    //   90: ldc 98
    //   92: astore 9
    //   94: aload_0
    //   95: aload 9
    //   97: putfield 100	com/viber/voip/util/bx:h	Ljava/lang/String;
    //   100: aload_2
    //   101: invokevirtual 104	java/lang/Object:getClass	()Ljava/lang/Class;
    //   104: astore 10
    //   106: aload 10
    //   108: ldc 106
    //   110: iconst_1
    //   111: anewarray 108	java/lang/Class
    //   114: dup
    //   115: iconst_0
    //   116: ldc 110
    //   118: aastore
    //   119: invokevirtual 114	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   122: astore 20
    //   124: aload 20
    //   126: astore 12
    //   128: aload 12
    //   130: ifnull +190 -> 320
    //   133: aload 12
    //   135: aload_2
    //   136: iconst_1
    //   137: anewarray 4	java/lang/Object
    //   140: dup
    //   141: iconst_0
    //   142: ldc 116
    //   144: aastore
    //   145: invokevirtual 122	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   148: checkcast 124	java/lang/Boolean
    //   151: astore 13
    //   153: aload 12
    //   155: aload_2
    //   156: iconst_1
    //   157: anewarray 4	java/lang/Object
    //   160: dup
    //   161: iconst_0
    //   162: ldc 126
    //   164: aastore
    //   165: invokevirtual 122	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   168: checkcast 124	java/lang/Boolean
    //   171: astore 19
    //   173: aload 19
    //   175: astore 14
    //   177: aload_0
    //   178: aload 13
    //   180: putfield 128	com/viber/voip/util/bx:c	Ljava/lang/Boolean;
    //   183: aload_0
    //   184: aload 14
    //   186: putfield 130	com/viber/voip/util/bx:d	Ljava/lang/Boolean;
    //   189: aload_0
    //   190: new 132	android/util/DisplayMetrics
    //   193: dup
    //   194: invokespecial 133	android/util/DisplayMetrics:<init>	()V
    //   197: putfield 135	com/viber/voip/util/bx:e	Landroid/util/DisplayMetrics;
    //   200: aload_0
    //   201: getfield 48	com/viber/voip/util/bx:b	Landroid/content/Context;
    //   204: ldc 137
    //   206: invokevirtual 141	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   209: checkcast 143	android/view/WindowManager
    //   212: invokeinterface 147 1 0
    //   217: aload_0
    //   218: getfield 135	com/viber/voip/util/bx:e	Landroid/util/DisplayMetrics;
    //   221: invokevirtual 153	android/view/Display:getMetrics	(Landroid/util/DisplayMetrics;)V
    //   224: return
    //   225: astore_3
    //   226: aconst_null
    //   227: astore 4
    //   229: aload 4
    //   231: astore 5
    //   233: aconst_null
    //   234: astore 6
    //   236: goto -184 -> 52
    //   239: aload 7
    //   241: getfield 96	android/content/pm/ApplicationInfo:nonLocalizedLabel	Ljava/lang/CharSequence;
    //   244: invokeinterface 158 1 0
    //   249: astore 9
    //   251: goto -157 -> 94
    //   254: aload_1
    //   255: iload 8
    //   257: invokevirtual 162	android/content/Context:getString	(I)Ljava/lang/String;
    //   260: astore 9
    //   262: goto -168 -> 94
    //   265: astore 11
    //   267: aconst_null
    //   268: astore 12
    //   270: goto -142 -> 128
    //   273: astore 16
    //   275: aconst_null
    //   276: astore 13
    //   278: aconst_null
    //   279: astore 14
    //   281: goto -104 -> 177
    //   284: astore 18
    //   286: aconst_null
    //   287: astore 14
    //   289: goto -112 -> 177
    //   292: astore 15
    //   294: aconst_null
    //   295: astore 13
    //   297: aconst_null
    //   298: astore 14
    //   300: goto -123 -> 177
    //   303: astore 17
    //   305: aconst_null
    //   306: astore 14
    //   308: goto -131 -> 177
    //   311: astore 22
    //   313: aload 5
    //   315: astore 4
    //   317: goto -88 -> 229
    //   320: aconst_null
    //   321: astore 13
    //   323: aconst_null
    //   324: astore 14
    //   326: goto -149 -> 177
    //
    // Exception table:
    //   from	to	target	type
    //   17	38	225	android/content/pm/PackageManager$NameNotFoundException
    //   106	124	265	java/lang/NoSuchMethodException
    //   133	153	273	java/lang/IllegalAccessException
    //   153	173	284	java/lang/IllegalAccessException
    //   133	153	292	java/lang/reflect/InvocationTargetException
    //   153	173	303	java/lang/reflect/InvocationTargetException
    //   38	48	311	android/content/pm/PackageManager$NameNotFoundException
  }

  public static bx a(Context paramContext)
  {
    synchronized (j)
    {
      if (i == null)
        i = new bx(paramContext.getApplicationContext());
      return i;
    }
  }

  public boolean a()
  {
    return this.c.booleanValue();
  }

  public boolean b()
  {
    return this.d.booleanValue();
  }

  public String c()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)this.b.getSystemService("phone");
    if (localTelephonyManager != null)
    {
      switch (localTelephonyManager.getPhoneType())
      {
      default:
        return null;
      case 0:
        return "none";
      case 1:
        return "gsm";
      case 2:
        return "cdma";
      case 3:
      }
      return "sip";
    }
    return null;
  }

  public String d()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)this.b.getSystemService("phone");
    if (localTelephonyManager != null)
      return localTelephonyManager.getNetworkOperatorName();
    return null;
  }

  @SuppressLint({"MissingPermission"})
  public Boolean e()
  {
    int k = this.b.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE");
    Boolean localBoolean = null;
    if (k == 0)
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)this.b.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localNetworkInfo == null) || (localNetworkInfo.getType() != 1) || (!localNetworkInfo.isConnected()))
        break label62;
    }
    label62: for (boolean bool = true; ; bool = false)
    {
      localBoolean = Boolean.valueOf(bool);
      return localBoolean;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.bx
 * JD-Core Version:    0.6.2
 */