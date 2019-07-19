package com.google.android.gms.iid;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.security.KeyPair;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ShowFirstParty
public class zzaf
{
  private static int zzcp = 0;
  private static final zzaj<Boolean> zzct = zzai.zzy().zzd("gcm_iid_use_messenger_ipc", true);
  private static String zzcu = null;
  private static boolean zzcv = false;
  private static int zzcw = 0;
  private static int zzcx = 0;
  private static BroadcastReceiver zzcy = null;
  private PendingIntent zzaf;
  private Messenger zzaj;
  private Map<String, Object> zzcz = new ArrayMap();
  private Messenger zzda;
  private MessengerCompat zzdb;
  private Context zzl;

  public zzaf(Context paramContext)
  {
    this.zzl = paramContext;
  }

  private static void zzd(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 instanceof ConditionVariable))
      ((ConditionVariable)paramObject1).open();
    Messenger localMessenger;
    Message localMessage;
    if ((paramObject1 instanceof Messenger))
    {
      localMessenger = (Messenger)paramObject1;
      localMessage = Message.obtain();
      localMessage.obj = paramObject2;
    }
    try
    {
      localMessenger.send(localMessage);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      String str = String.valueOf(localRemoteException);
      Log.w("InstanceID", 24 + String.valueOf(str).length() + "Failed to send response " + str);
    }
  }

  private final void zzd(String paramString, Object paramObject)
  {
    synchronized (getClass())
    {
      Object localObject2 = this.zzcz.get(paramString);
      this.zzcz.put(paramString, paramObject);
      zzd(localObject2, paramObject);
      return;
    }
  }

  private static boolean zzd(PackageManager paramPackageManager, String paramString)
  {
    try
    {
      ApplicationInfo localApplicationInfo = paramPackageManager.getApplicationInfo(paramString, 0);
      zzcu = localApplicationInfo.packageName;
      zzcx = localApplicationInfo.uid;
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }

  private static boolean zzd(PackageManager paramPackageManager, String paramString1, String paramString2)
  {
    if (paramPackageManager.checkPermission("com.google.android.c2dm.permission.SEND", paramString1) == 0)
      return zzd(paramPackageManager, paramString1);
    Log.w("InstanceID", 56 + String.valueOf(paramString1).length() + String.valueOf(paramString2).length() + "Possible malicious package " + paramString1 + " declares " + paramString2 + " without permission");
    return false;
  }

  private final void zzg(Intent paramIntent)
  {
    try
    {
      if (this.zzaf == null)
      {
        Intent localIntent = new Intent();
        localIntent.setPackage("com.google.example.invalidpackage");
        this.zzaf = PendingIntent.getBroadcast(this.zzl, 0, localIntent, 0);
      }
      paramIntent.putExtra("app", this.zzaf);
      return;
    }
    finally
    {
    }
  }

  static String zzi(Bundle paramBundle)
    throws IOException
  {
    if (paramBundle == null)
      throw new IOException("SERVICE_NOT_AVAILABLE");
    String str1 = paramBundle.getString("registration_id");
    if (str1 == null)
      str1 = paramBundle.getString("unregistered");
    if (str1 == null)
    {
      String str2 = paramBundle.getString("error");
      if (str2 != null)
        throw new IOException(str2);
      String str3 = String.valueOf(paramBundle);
      Log.w("InstanceID", 29 + String.valueOf(str3).length() + "Unexpected response from GCM " + str3, new Throwable());
      throw new IOException("SERVICE_NOT_AVAILABLE");
    }
    return str1;
  }

  private final Bundle zzj(Bundle paramBundle)
    throws IOException
  {
    Bundle localBundle = zzk(paramBundle);
    if ((localBundle != null) && (localBundle.containsKey("google.messenger")))
    {
      localBundle = zzk(paramBundle);
      if ((localBundle != null) && (localBundle.containsKey("google.messenger")))
        localBundle = null;
    }
    return localBundle;
  }

  // ERROR //
  private final Bundle zzk(Bundle paramBundle)
    throws IOException
  {
    // Byte code:
    //   0: new 74	android/os/ConditionVariable
    //   3: dup
    //   4: invokespecial 240	android/os/ConditionVariable:<init>	()V
    //   7: astore_2
    //   8: invokestatic 243	com/google/android/gms/iid/zzaf:zzx	()Ljava/lang/String;
    //   11: astore_3
    //   12: aload_0
    //   13: invokevirtual 131	java/lang/Object:getClass	()Ljava/lang/Class;
    //   16: astore 4
    //   18: aload 4
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 67	com/google/android/gms/iid/zzaf:zzcz	Ljava/util/Map;
    //   25: aload_3
    //   26: aload_2
    //   27: invokeinterface 141 3 0
    //   32: pop
    //   33: aload 4
    //   35: monitorexit
    //   36: aload_0
    //   37: getfield 245	com/google/android/gms/iid/zzaf:zzaj	Landroid/os/Messenger;
    //   40: ifnonnull +33 -> 73
    //   43: aload_0
    //   44: getfield 69	com/google/android/gms/iid/zzaf:zzl	Landroid/content/Context;
    //   47: invokestatic 248	com/google/android/gms/iid/zzaf:zzl	(Landroid/content/Context;)Ljava/lang/String;
    //   50: pop
    //   51: aload_0
    //   52: new 79	android/os/Messenger
    //   55: dup
    //   56: new 250	com/google/android/gms/iid/zzag
    //   59: dup
    //   60: aload_0
    //   61: invokestatic 256	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   64: invokespecial 259	com/google/android/gms/iid/zzag:<init>	(Lcom/google/android/gms/iid/zzaf;Landroid/os/Looper;)V
    //   67: invokespecial 262	android/os/Messenger:<init>	(Landroid/os/Handler;)V
    //   70: putfield 245	com/google/android/gms/iid/zzaf:zzaj	Landroid/os/Messenger;
    //   73: getstatic 48	com/google/android/gms/iid/zzaf:zzcu	Ljava/lang/String;
    //   76: ifnonnull +22 -> 98
    //   79: new 203	java/io/IOException
    //   82: dup
    //   83: ldc_w 264
    //   86: invokespecial 208	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   89: athrow
    //   90: astore 5
    //   92: aload 4
    //   94: monitorexit
    //   95: aload 5
    //   97: athrow
    //   98: getstatic 50	com/google/android/gms/iid/zzaf:zzcv	Z
    //   101: ifeq +312 -> 413
    //   104: ldc_w 266
    //   107: astore 7
    //   109: new 180	android/content/Intent
    //   112: dup
    //   113: aload 7
    //   115: invokespecial 267	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   118: astore 8
    //   120: aload 8
    //   122: getstatic 48	com/google/android/gms/iid/zzaf:zzcu	Ljava/lang/String;
    //   125: invokevirtual 187	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   128: pop
    //   129: aload 8
    //   131: aload_1
    //   132: invokevirtual 271	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   135: pop
    //   136: aload_0
    //   137: aload 8
    //   139: invokespecial 273	com/google/android/gms/iid/zzaf:zzg	(Landroid/content/Intent;)V
    //   142: aload 8
    //   144: ldc_w 275
    //   147: new 103	java/lang/StringBuilder
    //   150: dup
    //   151: iconst_5
    //   152: aload_3
    //   153: invokestatic 99	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   156: invokevirtual 107	java/lang/String:length	()I
    //   159: iadd
    //   160: invokespecial 110	java/lang/StringBuilder:<init>	(I)V
    //   163: ldc_w 277
    //   166: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_3
    //   170: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: ldc_w 279
    //   176: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokevirtual 282	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   185: pop
    //   186: aload 8
    //   188: ldc_w 284
    //   191: new 103	java/lang/StringBuilder
    //   194: dup
    //   195: iconst_5
    //   196: aload_3
    //   197: invokestatic 99	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   200: invokevirtual 107	java/lang/String:length	()I
    //   203: iadd
    //   204: invokespecial 110	java/lang/StringBuilder:<init>	(I)V
    //   207: ldc_w 277
    //   210: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_3
    //   214: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: ldc_w 279
    //   220: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokevirtual 282	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   229: pop
    //   230: ldc_w 286
    //   233: getstatic 48	com/google/android/gms/iid/zzaf:zzcu	Ljava/lang/String;
    //   236: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   239: istore 13
    //   241: aload 8
    //   243: ldc_w 292
    //   246: invokevirtual 295	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   249: astore 14
    //   251: aload 14
    //   253: ifnull +13 -> 266
    //   256: ldc_w 297
    //   259: aload 14
    //   261: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   264: istore 13
    //   266: ldc 101
    //   268: iconst_3
    //   269: invokestatic 301	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   272: ifeq +51 -> 323
    //   275: aload 8
    //   277: invokevirtual 305	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   280: invokestatic 99	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   283: astore 36
    //   285: ldc 101
    //   287: new 103	java/lang/StringBuilder
    //   290: dup
    //   291: bipush 8
    //   293: aload 36
    //   295: invokestatic 99	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   298: invokevirtual 107	java/lang/String:length	()I
    //   301: iadd
    //   302: invokespecial 110	java/lang/StringBuilder:<init>	(I)V
    //   305: ldc_w 307
    //   308: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload 36
    //   313: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: invokestatic 310	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   322: pop
    //   323: aload_0
    //   324: getfield 312	com/google/android/gms/iid/zzaf:zzda	Landroid/os/Messenger;
    //   327: ifnull +114 -> 441
    //   330: aload 8
    //   332: ldc 235
    //   334: aload_0
    //   335: getfield 245	com/google/android/gms/iid/zzaf:zzaj	Landroid/os/Messenger;
    //   338: invokevirtual 199	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   341: pop
    //   342: invokestatic 85	android/os/Message:obtain	()Landroid/os/Message;
    //   345: astore 33
    //   347: aload 33
    //   349: aload 8
    //   351: putfield 89	android/os/Message:obj	Ljava/lang/Object;
    //   354: aload_0
    //   355: getfield 312	com/google/android/gms/iid/zzaf:zzda	Landroid/os/Messenger;
    //   358: aload 33
    //   360: invokevirtual 93	android/os/Messenger:send	(Landroid/os/Message;)V
    //   363: aload_2
    //   364: ldc2_w 313
    //   367: invokevirtual 318	android/os/ConditionVariable:block	(J)Z
    //   370: pop
    //   371: aload_0
    //   372: invokevirtual 131	java/lang/Object:getClass	()Ljava/lang/Class;
    //   375: astore 19
    //   377: aload 19
    //   379: monitorenter
    //   380: aload_0
    //   381: getfield 67	com/google/android/gms/iid/zzaf:zzcz	Ljava/util/Map;
    //   384: aload_3
    //   385: invokeinterface 321 2 0
    //   390: astore 21
    //   392: aload 21
    //   394: instanceof 212
    //   397: ifeq +256 -> 653
    //   400: aload 21
    //   402: checkcast 212	android/os/Bundle
    //   405: astore 24
    //   407: aload 19
    //   409: monitorexit
    //   410: aload 24
    //   412: areturn
    //   413: ldc_w 323
    //   416: astore 7
    //   418: goto -309 -> 109
    //   421: astore 34
    //   423: ldc 101
    //   425: iconst_3
    //   426: invokestatic 301	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   429: ifeq +12 -> 441
    //   432: ldc 101
    //   434: ldc_w 325
    //   437: invokestatic 310	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   440: pop
    //   441: iload 13
    //   443: ifeq +104 -> 547
    //   446: ldc 2
    //   448: monitorenter
    //   449: getstatic 58	com/google/android/gms/iid/zzaf:zzcy	Landroid/content/BroadcastReceiver;
    //   452: ifnonnull +72 -> 524
    //   455: new 327	com/google/android/gms/iid/zzah
    //   458: dup
    //   459: aload_0
    //   460: invokespecial 330	com/google/android/gms/iid/zzah:<init>	(Lcom/google/android/gms/iid/zzaf;)V
    //   463: putstatic 58	com/google/android/gms/iid/zzaf:zzcy	Landroid/content/BroadcastReceiver;
    //   466: ldc 101
    //   468: iconst_3
    //   469: invokestatic 301	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   472: ifeq +12 -> 484
    //   475: ldc 101
    //   477: ldc_w 332
    //   480: invokestatic 310	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   483: pop
    //   484: new 334	android/content/IntentFilter
    //   487: dup
    //   488: ldc_w 336
    //   491: invokespecial 337	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   494: astore 29
    //   496: aload 29
    //   498: aload_0
    //   499: getfield 69	com/google/android/gms/iid/zzaf:zzl	Landroid/content/Context;
    //   502: invokevirtual 342	android/content/Context:getPackageName	()Ljava/lang/String;
    //   505: invokevirtual 345	android/content/IntentFilter:addCategory	(Ljava/lang/String;)V
    //   508: aload_0
    //   509: getfield 69	com/google/android/gms/iid/zzaf:zzl	Landroid/content/Context;
    //   512: getstatic 58	com/google/android/gms/iid/zzaf:zzcy	Landroid/content/BroadcastReceiver;
    //   515: aload 29
    //   517: ldc 163
    //   519: aconst_null
    //   520: invokevirtual 349	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   523: pop
    //   524: ldc 2
    //   526: monitorexit
    //   527: aload_0
    //   528: getfield 69	com/google/android/gms/iid/zzaf:zzl	Landroid/content/Context;
    //   531: aload 8
    //   533: invokevirtual 352	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   536: goto -173 -> 363
    //   539: astore 28
    //   541: ldc 2
    //   543: monitorexit
    //   544: aload 28
    //   546: athrow
    //   547: aload 8
    //   549: ldc 235
    //   551: aload_0
    //   552: getfield 245	com/google/android/gms/iid/zzaf:zzaj	Landroid/os/Messenger;
    //   555: invokevirtual 199	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   558: pop
    //   559: aload 8
    //   561: ldc_w 354
    //   564: ldc_w 297
    //   567: invokevirtual 282	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   570: pop
    //   571: aload_0
    //   572: getfield 356	com/google/android/gms/iid/zzaf:zzdb	Lcom/google/android/gms/iid/MessengerCompat;
    //   575: ifnull +47 -> 622
    //   578: invokestatic 85	android/os/Message:obtain	()Landroid/os/Message;
    //   581: astore 25
    //   583: aload 25
    //   585: aload 8
    //   587: putfield 89	android/os/Message:obj	Ljava/lang/Object;
    //   590: aload_0
    //   591: getfield 356	com/google/android/gms/iid/zzaf:zzdb	Lcom/google/android/gms/iid/MessengerCompat;
    //   594: aload 25
    //   596: invokevirtual 359	com/google/android/gms/iid/MessengerCompat:send	(Landroid/os/Message;)V
    //   599: goto -236 -> 363
    //   602: astore 26
    //   604: ldc 101
    //   606: iconst_3
    //   607: invokestatic 301	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   610: ifeq +12 -> 622
    //   613: ldc 101
    //   615: ldc_w 325
    //   618: invokestatic 310	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   621: pop
    //   622: getstatic 50	com/google/android/gms/iid/zzaf:zzcv	Z
    //   625: ifeq +15 -> 640
    //   628: aload_0
    //   629: getfield 69	com/google/android/gms/iid/zzaf:zzl	Landroid/content/Context;
    //   632: aload 8
    //   634: invokevirtual 352	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   637: goto -274 -> 363
    //   640: aload_0
    //   641: getfield 69	com/google/android/gms/iid/zzaf:zzl	Landroid/content/Context;
    //   644: aload 8
    //   646: invokevirtual 363	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   649: pop
    //   650: goto -287 -> 363
    //   653: aload 21
    //   655: instanceof 95
    //   658: ifeq +24 -> 682
    //   661: new 203	java/io/IOException
    //   664: dup
    //   665: aload 21
    //   667: checkcast 95	java/lang/String
    //   670: invokespecial 208	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   673: athrow
    //   674: astore 20
    //   676: aload 19
    //   678: monitorexit
    //   679: aload 20
    //   681: athrow
    //   682: aload 21
    //   684: invokestatic 99	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   687: astore 22
    //   689: ldc 101
    //   691: new 103	java/lang/StringBuilder
    //   694: dup
    //   695: bipush 12
    //   697: aload 22
    //   699: invokestatic 99	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   702: invokevirtual 107	java/lang/String:length	()I
    //   705: iadd
    //   706: invokespecial 110	java/lang/StringBuilder:<init>	(I)V
    //   709: ldc_w 365
    //   712: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: aload 22
    //   717: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   723: invokestatic 126	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   726: pop
    //   727: new 203	java/io/IOException
    //   730: dup
    //   731: ldc_w 367
    //   734: invokespecial 208	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   737: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   21	36	90	finally
    //   92	95	90	finally
    //   354	363	421	android/os/RemoteException
    //   449	484	539	finally
    //   484	524	539	finally
    //   524	527	539	finally
    //   541	544	539	finally
    //   590	599	602	android/os/RemoteException
    //   380	410	674	finally
    //   653	674	674	finally
    //   676	679	674	finally
    //   682	738	674	finally
  }

  @ShowFirstParty
  public static boolean zzk(Context paramContext)
  {
    if (zzcu != null)
      zzl(paramContext);
    return zzcv;
  }

  @ShowFirstParty
  public static String zzl(Context paramContext)
  {
    if (zzcu != null)
      return zzcu;
    zzcw = Process.myUid();
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (!PlatformVersion.isAtLeastO())
    {
      Iterator localIterator2 = localPackageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0).iterator();
      while (localIterator2.hasNext())
        if (zzd(localPackageManager, ((ResolveInfo)localIterator2.next()).serviceInfo.packageName, "com.google.android.c2dm.intent.REGISTER"))
          zzcv = false;
      for (int j = 1; j != 0; j = 0)
        return zzcu;
    }
    Iterator localIterator1 = localPackageManager.queryBroadcastReceivers(new Intent("com.google.iid.TOKEN_REQUEST"), 0).iterator();
    while (localIterator1.hasNext())
      if (zzd(localPackageManager, ((ResolveInfo)localIterator1.next()).activityInfo.packageName, "com.google.iid.TOKEN_REQUEST"))
        zzcv = true;
    for (int i = 1; i != 0; i = 0)
      return zzcu;
    Log.w("InstanceID", "Failed to resolve IID implementation package, falling back");
    if (zzd(localPackageManager, "com.google.android.gms"))
    {
      zzcv = PlatformVersion.isAtLeastO();
      return zzcu;
    }
    if ((!PlatformVersion.isAtLeastLollipop()) && (zzd(localPackageManager, "com.google.android.gsf")))
    {
      zzcv = false;
      return zzcu;
    }
    Log.w("InstanceID", "Google Play services is missing, unable to get tokens");
    return null;
  }

  private static int zzm(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      int i = localPackageManager.getPackageInfo(zzl(paramContext), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return -1;
  }

  private static String zzx()
  {
    try
    {
      int i = zzcp;
      zzcp = i + 1;
      String str = Integer.toString(i);
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  final Bundle zzd(Bundle paramBundle, KeyPair paramKeyPair)
    throws IOException
  {
    int i = zzm(this.zzl);
    paramBundle.putString("gmsv", Integer.toString(i));
    paramBundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
    paramBundle.putString("app_ver", Integer.toString(InstanceID.zzg(this.zzl)));
    paramBundle.putString("app_ver_name", InstanceID.zzh(this.zzl));
    paramBundle.putString("cliv", "iid-12451000");
    paramBundle.putString("appid", InstanceID.zzd(paramKeyPair));
    Task localTask;
    if ((i >= 12000000) && (((Boolean)zzct.get()).booleanValue()))
      localTask = new zzr(this.zzl).zzd(1, paramBundle);
    try
    {
      Bundle localBundle = (Bundle)Tasks.await(localTask);
      return localBundle;
    }
    catch (InterruptedException localInterruptedException)
    {
      if (Log.isLoggable("InstanceID", 3))
      {
        String str = String.valueOf(localInterruptedException);
        Log.d("InstanceID", 22 + String.valueOf(str).length() + "Error making request: " + str);
      }
      if (((localInterruptedException.getCause() instanceof zzaa)) && (((zzaa)localInterruptedException.getCause()).getErrorCode() == 4))
        return zzj(paramBundle);
      return null;
      return zzj(paramBundle);
    }
    catch (ExecutionException localExecutionException)
    {
      label141: break label141;
    }
  }

  public final void zze(Message paramMessage)
  {
    if (paramMessage == null)
      return;
    if ((paramMessage.obj instanceof Intent))
    {
      Intent localIntent = (Intent)paramMessage.obj;
      localIntent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
      if (localIntent.hasExtra("google.messenger"))
      {
        Parcelable localParcelable = localIntent.getParcelableExtra("google.messenger");
        if ((localParcelable instanceof MessengerCompat))
          this.zzdb = ((MessengerCompat)localParcelable);
        if ((localParcelable instanceof Messenger))
          this.zzda = ((Messenger)localParcelable);
      }
      zzh((Intent)paramMessage.obj);
      return;
    }
    Log.w("InstanceID", "Dropping invalid message");
  }

  public final void zzh(Intent paramIntent)
  {
    if (paramIntent == null)
      if (Log.isLoggable("InstanceID", 3))
        Log.d("InstanceID", "Unexpected response: null");
    do
    {
      return;
      String str1 = paramIntent.getAction();
      if (("com.google.android.c2dm.intent.REGISTRATION".equals(str1)) || ("com.google.android.gms.iid.InstanceID".equals(str1)))
        break;
    }
    while (!Log.isLoggable("InstanceID", 3));
    String str16 = String.valueOf(paramIntent.getAction());
    if (str16.length() != 0);
    for (String str17 = "Unexpected response ".concat(str16); ; str17 = new String("Unexpected response "))
    {
      Log.d("InstanceID", str17);
      return;
    }
    String str2 = paramIntent.getStringExtra("registration_id");
    if (str2 == null)
      str2 = paramIntent.getStringExtra("unregistered");
    String str7;
    String str14;
    label225: String str12;
    label292: String str9;
    String str8;
    if (str2 == null)
    {
      str7 = paramIntent.getStringExtra("error");
      if (str7 == null)
      {
        String str15 = String.valueOf(paramIntent.getExtras());
        Log.w("InstanceID", 49 + String.valueOf(str15).length() + "Unexpected response, no error or registration id " + str15);
        return;
      }
      if (Log.isLoggable("InstanceID", 3))
      {
        String str13 = String.valueOf(str7);
        if (str13.length() != 0)
        {
          str14 = "Received InstanceID error ".concat(str13);
          Log.d("InstanceID", str14);
        }
      }
      else
      {
        if (!str7.startsWith("|"))
          break label615;
        String[] arrayOfString = str7.split("\\|");
        if (!"ID".equals(arrayOfString[1]))
        {
          String str11 = String.valueOf(str7);
          if (str11.length() == 0)
            break label459;
          str12 = "Unexpected structured response ".concat(str11);
          Log.w("InstanceID", str12);
        }
        if (arrayOfString.length <= 2)
          break label474;
        str9 = arrayOfString[2];
        str8 = arrayOfString[3];
        if (str8.startsWith(":"))
          str8 = str8.substring(1);
        label338: paramIntent.putExtra("error", str8);
      }
    }
    while (true)
    {
      if (str9 == null)
      {
        synchronized (getClass())
        {
          Iterator localIterator = this.zzcz.keySet().iterator();
          if (!localIterator.hasNext())
            break label485;
          String str10 = (String)localIterator.next();
          Object localObject2 = this.zzcz.get(str10);
          this.zzcz.put(str10, str8);
          zzd(localObject2, str8);
        }
        str14 = new String("Received InstanceID error ");
        break label225;
        label459: str12 = new String("Unexpected structured response ");
        break label292;
        label474: str8 = "UNKNOWN";
        str9 = null;
        break label338;
        label485: return;
      }
      zzd(str9, str8);
      return;
      Matcher localMatcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(str2);
      if (!localMatcher.matches())
      {
        if (!Log.isLoggable("InstanceID", 3))
          break;
        String str5 = String.valueOf(str2);
        if (str5.length() != 0);
        for (String str6 = "Unexpected response string: ".concat(str5); ; str6 = new String("Unexpected response string: "))
        {
          Log.d("InstanceID", str6);
          return;
        }
      }
      String str3 = localMatcher.group(1);
      String str4 = localMatcher.group(2);
      Bundle localBundle = paramIntent.getExtras();
      localBundle.putString("registration_id", str4);
      zzd(str3, localBundle);
      return;
      label615: str8 = str7;
      str9 = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.iid.zzaf
 * JD-Core Version:    0.6.2
 */