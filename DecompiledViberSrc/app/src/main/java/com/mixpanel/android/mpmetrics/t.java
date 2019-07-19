package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;

class t
{
  private static t h;
  private static final Object i = new Object();
  private final Context a;
  private final Boolean b;
  private final Boolean c;
  private final DisplayMetrics d;
  private final String e;
  private final Integer f;
  private final String g;

  // ERROR //
  private t(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 25	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: aload_1
    //   6: putfield 38	com/mixpanel/android/mpmetrics/t:a	Landroid/content/Context;
    //   9: aload_0
    //   10: getfield 38	com/mixpanel/android/mpmetrics/t:a	Landroid/content/Context;
    //   13: invokevirtual 44	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   16: astore_2
    //   17: aload_2
    //   18: aload_0
    //   19: getfield 38	com/mixpanel/android/mpmetrics/t:a	Landroid/content/Context;
    //   22: invokevirtual 48	android/content/Context:getPackageName	()Ljava/lang/String;
    //   25: iconst_0
    //   26: invokevirtual 54	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   29: astore 21
    //   31: aload 21
    //   33: getfield 59	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   36: astore 5
    //   38: aload 21
    //   40: getfield 63	android/content/pm/PackageInfo:versionCode	I
    //   43: invokestatic 69	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: astore 23
    //   48: aload 23
    //   50: astore 6
    //   52: aload_1
    //   53: invokevirtual 73	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   56: astore 7
    //   58: aload 7
    //   60: getfield 78	android/content/pm/ApplicationInfo:labelRes	I
    //   63: istore 8
    //   65: aload_0
    //   66: aload 5
    //   68: putfield 80	com/mixpanel/android/mpmetrics/t:e	Ljava/lang/String;
    //   71: aload_0
    //   72: aload 6
    //   74: putfield 82	com/mixpanel/android/mpmetrics/t:f	Ljava/lang/Integer;
    //   77: iload 8
    //   79: ifne +182 -> 261
    //   82: aload 7
    //   84: getfield 86	android/content/pm/ApplicationInfo:nonLocalizedLabel	Ljava/lang/CharSequence;
    //   87: ifnonnull +159 -> 246
    //   90: ldc 88
    //   92: astore 9
    //   94: aload_0
    //   95: aload 9
    //   97: putfield 90	com/mixpanel/android/mpmetrics/t:g	Ljava/lang/String;
    //   100: aload_2
    //   101: invokevirtual 94	java/lang/Object:getClass	()Ljava/lang/Class;
    //   104: astore 10
    //   106: aload 10
    //   108: ldc 96
    //   110: iconst_1
    //   111: anewarray 98	java/lang/Class
    //   114: dup
    //   115: iconst_0
    //   116: ldc 100
    //   118: aastore
    //   119: invokevirtual 104	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   122: astore 20
    //   124: aload 20
    //   126: astore 12
    //   128: aload 12
    //   130: ifnull +205 -> 335
    //   133: aload 12
    //   135: aload_2
    //   136: iconst_1
    //   137: anewarray 4	java/lang/Object
    //   140: dup
    //   141: iconst_0
    //   142: ldc 106
    //   144: aastore
    //   145: invokevirtual 112	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   148: checkcast 114	java/lang/Boolean
    //   151: astore 13
    //   153: aload 12
    //   155: aload_2
    //   156: iconst_1
    //   157: anewarray 4	java/lang/Object
    //   160: dup
    //   161: iconst_0
    //   162: ldc 116
    //   164: aastore
    //   165: invokevirtual 112	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   168: checkcast 114	java/lang/Boolean
    //   171: astore 19
    //   173: aload 19
    //   175: astore 14
    //   177: aload_0
    //   178: aload 13
    //   180: putfield 118	com/mixpanel/android/mpmetrics/t:b	Ljava/lang/Boolean;
    //   183: aload_0
    //   184: aload 14
    //   186: putfield 120	com/mixpanel/android/mpmetrics/t:c	Ljava/lang/Boolean;
    //   189: aload_0
    //   190: new 122	android/util/DisplayMetrics
    //   193: dup
    //   194: invokespecial 123	android/util/DisplayMetrics:<init>	()V
    //   197: putfield 125	com/mixpanel/android/mpmetrics/t:d	Landroid/util/DisplayMetrics;
    //   200: aload_0
    //   201: getfield 38	com/mixpanel/android/mpmetrics/t:a	Landroid/content/Context;
    //   204: ldc 127
    //   206: invokevirtual 131	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   209: checkcast 133	android/view/WindowManager
    //   212: invokeinterface 137 1 0
    //   217: aload_0
    //   218: getfield 125	com/mixpanel/android/mpmetrics/t:d	Landroid/util/DisplayMetrics;
    //   221: invokevirtual 143	android/view/Display:getMetrics	(Landroid/util/DisplayMetrics;)V
    //   224: return
    //   225: astore_3
    //   226: aconst_null
    //   227: astore 4
    //   229: ldc 145
    //   231: ldc 147
    //   233: invokestatic 152	com/mixpanel/android/b/f:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   236: aload 4
    //   238: astore 5
    //   240: aconst_null
    //   241: astore 6
    //   243: goto -191 -> 52
    //   246: aload 7
    //   248: getfield 86	android/content/pm/ApplicationInfo:nonLocalizedLabel	Ljava/lang/CharSequence;
    //   251: invokeinterface 157 1 0
    //   256: astore 9
    //   258: goto -164 -> 94
    //   261: aload_1
    //   262: iload 8
    //   264: invokevirtual 161	android/content/Context:getString	(I)Ljava/lang/String;
    //   267: astore 9
    //   269: goto -175 -> 94
    //   272: astore 11
    //   274: aconst_null
    //   275: astore 12
    //   277: goto -149 -> 128
    //   280: astore 16
    //   282: aconst_null
    //   283: astore 13
    //   285: ldc 145
    //   287: ldc 163
    //   289: invokestatic 152	com/mixpanel/android/b/f:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   292: aconst_null
    //   293: astore 14
    //   295: goto -118 -> 177
    //   298: astore 15
    //   300: aconst_null
    //   301: astore 13
    //   303: ldc 145
    //   305: ldc 163
    //   307: invokestatic 152	com/mixpanel/android/b/f:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   310: aconst_null
    //   311: astore 14
    //   313: goto -136 -> 177
    //   316: astore 18
    //   318: goto -15 -> 303
    //   321: astore 17
    //   323: goto -38 -> 285
    //   326: astore 22
    //   328: aload 5
    //   330: astore 4
    //   332: goto -103 -> 229
    //   335: aconst_null
    //   336: astore 13
    //   338: aconst_null
    //   339: astore 14
    //   341: goto -164 -> 177
    //
    // Exception table:
    //   from	to	target	type
    //   17	38	225	android/content/pm/PackageManager$NameNotFoundException
    //   106	124	272	java/lang/NoSuchMethodException
    //   133	153	280	java/lang/reflect/InvocationTargetException
    //   133	153	298	java/lang/IllegalAccessException
    //   153	173	316	java/lang/IllegalAccessException
    //   153	173	321	java/lang/reflect/InvocationTargetException
    //   38	48	326	android/content/pm/PackageManager$NameNotFoundException
  }

  static t a(Context paramContext)
  {
    synchronized (i)
    {
      if (h == null)
        h = new t(paramContext.getApplicationContext());
      return h;
    }
  }

  public String a()
  {
    return this.e;
  }

  public Integer b()
  {
    return this.f;
  }

  public String c()
  {
    return this.g;
  }

  public boolean d()
  {
    return this.b.booleanValue();
  }

  public boolean e()
  {
    return this.c.booleanValue();
  }

  public DisplayMetrics f()
  {
    return this.d;
  }

  public String g()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)this.a.getSystemService("phone");
    if (localTelephonyManager != null)
      return localTelephonyManager.getNetworkOperatorName();
    return null;
  }

  @SuppressLint({"MissingPermission"})
  public Boolean h()
  {
    int j = this.a.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE");
    Boolean localBoolean = null;
    if (j == 0)
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)this.a.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localNetworkInfo == null) || (localNetworkInfo.getType() != 1) || (!localNetworkInfo.isConnected()))
        break label62;
    }
    label62: for (boolean bool = true; ; bool = false)
    {
      localBoolean = Boolean.valueOf(bool);
      return localBoolean;
    }
  }

  @SuppressLint({"MissingPermission"})
  public Boolean i()
  {
    try
    {
      int j = this.a.getPackageManager().checkPermission("android.permission.BLUETOOTH", this.a.getPackageName());
      Object localObject = null;
      if (j == 0)
      {
        BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        localObject = null;
        if (localBluetoothAdapter != null)
        {
          Boolean localBoolean = Boolean.valueOf(localBluetoothAdapter.isEnabled());
          localObject = localBoolean;
        }
      }
      return localObject;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      return null;
    }
    catch (SecurityException localSecurityException)
    {
    }
    return null;
  }

  public String j()
  {
    String str = "none";
    if ((Build.VERSION.SDK_INT >= 18) && (this.a.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")))
      str = "ble";
    while (!this.a.getPackageManager().hasSystemFeature("android.hardware.bluetooth"))
      return str;
    return "classic";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.t
 * JD-Core Version:    0.6.2
 */