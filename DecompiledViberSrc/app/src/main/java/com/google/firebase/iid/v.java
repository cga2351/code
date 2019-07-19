package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;

final class v
{
  private static int a = 0;
  private static PendingIntent b;

  @GuardedBy("responseCallbacks")
  private final SimpleArrayMap<String, TaskCompletionSource<Bundle>> c = new SimpleArrayMap();
  private final Context d;
  private final p e;
  private Messenger f;
  private Messenger g;
  private zzm h;

  public v(Context paramContext, p paramp)
  {
    this.d = paramContext;
    this.e = paramp;
    this.f = new Messenger(new y(this, Looper.getMainLooper()));
  }

  private static String a()
  {
    try
    {
      int i = a;
      a = i + 1;
      String str = Integer.toString(i);
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private static void a(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (b == null)
      {
        Intent localIntent = new Intent();
        localIntent.setPackage("com.google.example.invalidpackage");
        b = PendingIntent.getBroadcast(paramContext, 0, localIntent, 0);
      }
      paramIntent.putExtra("app", b);
      return;
    }
    finally
    {
    }
  }

  private final void a(Message paramMessage)
  {
    if ((paramMessage != null) && ((paramMessage.obj instanceof Intent)))
    {
      Intent localIntent1 = (Intent)paramMessage.obj;
      localIntent1.setExtrasClassLoader(new zzm.a());
      if (localIntent1.hasExtra("google.messenger"))
      {
        Parcelable localParcelable = localIntent1.getParcelableExtra("google.messenger");
        if ((localParcelable instanceof zzm))
          this.h = ((zzm)localParcelable);
        if ((localParcelable instanceof Messenger))
          this.g = ((Messenger)localParcelable);
      }
      Intent localIntent2 = (Intent)paramMessage.obj;
      String str1 = localIntent2.getAction();
      String str16;
      if (!"com.google.android.c2dm.intent.REGISTRATION".equals(str1))
        if (Log.isLoggable("FirebaseInstanceId", 3))
        {
          String str15 = String.valueOf(str1);
          if (str15.length() == 0)
            break label152;
          str16 = "Unexpected response action: ".concat(str15);
          Log.d("FirebaseInstanceId", str16);
        }
      label152: String str2;
      label382: Matcher localMatcher;
      label396: label445: 
      do
      {
        return;
        str16 = new String("Unexpected response action: ");
        break;
        str2 = localIntent2.getStringExtra("registration_id");
        if (str2 == null)
          str2 = localIntent2.getStringExtra("unregistered");
        if (str2 == null)
        {
          String str7 = localIntent2.getStringExtra("error");
          if (str7 == null)
          {
            String str14 = String.valueOf(localIntent2.getExtras());
            Log.w("FirebaseInstanceId", 49 + String.valueOf(str14).length() + "Unexpected response, no error or registration id " + str14);
            return;
          }
          String str13;
          String[] arrayOfString;
          String str8;
          if (Log.isLoggable("FirebaseInstanceId", 3))
          {
            String str12 = String.valueOf(str7);
            if (str12.length() != 0)
            {
              str13 = "Received InstanceID error ".concat(str12);
              Log.d("FirebaseInstanceId", str13);
            }
          }
          else
          {
            if (!str7.startsWith("|"))
              break label445;
            arrayOfString = str7.split("\\|");
            if ((arrayOfString.length > 2) && ("ID".equals(arrayOfString[1])))
              break label396;
            str8 = String.valueOf(str7);
            if (str8.length() == 0)
              break label382;
          }
          for (String str9 = "Unexpected structured response ".concat(str8); ; str9 = new String("Unexpected structured response "))
          {
            Log.w("FirebaseInstanceId", str9);
            return;
            str13 = new String("Received InstanceID error ");
            break;
          }
          String str10 = arrayOfString[2];
          String str11 = arrayOfString[3];
          if (str11.startsWith(":"))
            str11 = str11.substring(1);
          a(str10, localIntent2.putExtra("error", str11).getExtras());
          return;
          SimpleArrayMap localSimpleArrayMap = this.c;
          int i = 0;
          try
          {
            while (i < this.c.size())
            {
              a((String)this.c.keyAt(i), localIntent2.getExtras());
              i++;
            }
            return;
          }
          finally
          {
          }
        }
        localMatcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(str2);
        if (localMatcher.matches())
          break label584;
      }
      while (!Log.isLoggable("FirebaseInstanceId", 3));
      String str5 = String.valueOf(str2);
      if (str5.length() != 0);
      for (String str6 = "Unexpected response string: ".concat(str5); ; str6 = new String("Unexpected response string: "))
      {
        Log.d("FirebaseInstanceId", str6);
        return;
      }
      label584: String str3 = localMatcher.group(1);
      String str4 = localMatcher.group(2);
      Bundle localBundle = localIntent2.getExtras();
      localBundle.putString("registration_id", str4);
      a(str3, localBundle);
      return;
    }
    Log.w("FirebaseInstanceId", "Dropping invalid message");
  }

  private final void a(String paramString, Bundle paramBundle)
  {
    TaskCompletionSource localTaskCompletionSource;
    synchronized (this.c)
    {
      localTaskCompletionSource = (TaskCompletionSource)this.c.remove(paramString);
      if (localTaskCompletionSource == null)
      {
        String str1 = String.valueOf(paramString);
        if (str1.length() != 0)
        {
          str2 = "Missing callback for ".concat(str1);
          Log.w("FirebaseInstanceId", str2);
          return;
        }
        String str2 = new String("Missing callback for ");
      }
    }
    localTaskCompletionSource.setResult(paramBundle);
  }

  private final Bundle b(Bundle paramBundle)
    throws IOException
  {
    Bundle localBundle = c(paramBundle);
    if ((localBundle != null) && (localBundle.containsKey("google.messenger")))
    {
      localBundle = c(paramBundle);
      if ((localBundle != null) && (localBundle.containsKey("google.messenger")))
        localBundle = null;
    }
    return localBundle;
  }

  // ERROR //
  private final Bundle c(Bundle paramBundle)
    throws IOException
  {
    // Byte code:
    //   0: invokestatic 286	com/google/firebase/iid/v:a	()Ljava/lang/String;
    //   3: astore_2
    //   4: new 262	com/google/android/gms/tasks/TaskCompletionSource
    //   7: dup
    //   8: invokespecial 287	com/google/android/gms/tasks/TaskCompletionSource:<init>	()V
    //   11: astore_3
    //   12: aload_0
    //   13: getfield 36	com/google/firebase/iid/v:c	Landroid/support/v4/util/SimpleArrayMap;
    //   16: astore 4
    //   18: aload 4
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 36	com/google/firebase/iid/v:c	Landroid/support/v4/util/SimpleArrayMap;
    //   25: aload_2
    //   26: aload_3
    //   27: invokevirtual 291	android/support/v4/util/SimpleArrayMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   30: pop
    //   31: aload 4
    //   33: monitorexit
    //   34: aload_0
    //   35: getfield 40	com/google/firebase/iid/v:e	Lcom/google/firebase/iid/p;
    //   38: invokevirtual 295	com/google/firebase/iid/p:a	()I
    //   41: ifne +22 -> 63
    //   44: new 271	java/io/IOException
    //   47: dup
    //   48: ldc_w 297
    //   51: invokespecial 298	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   54: athrow
    //   55: astore 5
    //   57: aload 4
    //   59: monitorexit
    //   60: aload 5
    //   62: athrow
    //   63: new 70	android/content/Intent
    //   66: dup
    //   67: invokespecial 71	android/content/Intent:<init>	()V
    //   70: astore 7
    //   72: aload 7
    //   74: ldc_w 300
    //   77: invokevirtual 77	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   80: pop
    //   81: aload_0
    //   82: getfield 40	com/google/firebase/iid/v:e	Lcom/google/firebase/iid/p;
    //   85: invokevirtual 295	com/google/firebase/iid/p:a	()I
    //   88: iconst_2
    //   89: if_icmpne +224 -> 313
    //   92: aload 7
    //   94: ldc_w 302
    //   97: invokevirtual 305	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   100: pop
    //   101: aload 7
    //   103: aload_1
    //   104: invokevirtual 309	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   107: pop
    //   108: aload_0
    //   109: getfield 38	com/google/firebase/iid/v:d	Landroid/content/Context;
    //   112: aload 7
    //   114: invokestatic 311	com/google/firebase/iid/v:a	(Landroid/content/Context;Landroid/content/Intent;)V
    //   117: aload 7
    //   119: ldc_w 313
    //   122: new 173	java/lang/StringBuilder
    //   125: dup
    //   126: iconst_5
    //   127: aload_2
    //   128: invokestatic 142	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   131: invokevirtual 146	java/lang/String:length	()I
    //   134: iadd
    //   135: invokespecial 176	java/lang/StringBuilder:<init>	(I)V
    //   138: ldc_w 315
    //   141: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_2
    //   145: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc 191
    //   150: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokevirtual 212	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   159: pop
    //   160: ldc 132
    //   162: iconst_3
    //   163: invokestatic 138	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   166: ifeq +51 -> 217
    //   169: aload 7
    //   171: invokevirtual 171	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   174: invokestatic 142	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   177: astore 29
    //   179: ldc 132
    //   181: new 173	java/lang/StringBuilder
    //   184: dup
    //   185: bipush 8
    //   187: aload 29
    //   189: invokestatic 142	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   192: invokevirtual 146	java/lang/String:length	()I
    //   195: iadd
    //   196: invokespecial 176	java/lang/StringBuilder:<init>	(I)V
    //   199: ldc_w 317
    //   202: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload 29
    //   207: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 155	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   216: pop
    //   217: aload 7
    //   219: ldc 105
    //   221: aload_0
    //   222: getfield 58	com/google/firebase/iid/v:f	Landroid/os/Messenger;
    //   225: invokevirtual 89	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   228: pop
    //   229: aload_0
    //   230: getfield 119	com/google/firebase/iid/v:g	Landroid/os/Messenger;
    //   233: ifnonnull +10 -> 243
    //   236: aload_0
    //   237: getfield 117	com/google/firebase/iid/v:h	Lcom/google/firebase/iid/zzm;
    //   240: ifnull +117 -> 357
    //   243: invokestatic 321	android/os/Message:obtain	()Landroid/os/Message;
    //   246: astore 13
    //   248: aload 13
    //   250: aload 7
    //   252: putfield 96	android/os/Message:obj	Ljava/lang/Object;
    //   255: aload_0
    //   256: getfield 119	com/google/firebase/iid/v:g	Landroid/os/Messenger;
    //   259: ifnull +66 -> 325
    //   262: aload_0
    //   263: getfield 119	com/google/firebase/iid/v:g	Landroid/os/Messenger;
    //   266: aload 13
    //   268: invokevirtual 324	android/os/Messenger:send	(Landroid/os/Message;)V
    //   271: aload_3
    //   272: invokevirtual 328	com/google/android/gms/tasks/TaskCompletionSource:getTask	()Lcom/google/android/gms/tasks/Task;
    //   275: ldc2_w 329
    //   278: getstatic 336	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   281: invokestatic 342	com/google/android/gms/tasks/Tasks:await	(Lcom/google/android/gms/tasks/Task;JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    //   284: checkcast 247	android/os/Bundle
    //   287: astore 24
    //   289: aload_0
    //   290: getfield 36	com/google/firebase/iid/v:c	Landroid/support/v4/util/SimpleArrayMap;
    //   293: astore 25
    //   295: aload 25
    //   297: monitorenter
    //   298: aload_0
    //   299: getfield 36	com/google/firebase/iid/v:c	Landroid/support/v4/util/SimpleArrayMap;
    //   302: aload_2
    //   303: invokevirtual 260	android/support/v4/util/SimpleArrayMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   306: pop
    //   307: aload 25
    //   309: monitorexit
    //   310: aload 24
    //   312: areturn
    //   313: aload 7
    //   315: ldc_w 344
    //   318: invokevirtual 305	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   321: pop
    //   322: goto -221 -> 101
    //   325: aload_0
    //   326: getfield 117	com/google/firebase/iid/v:h	Lcom/google/firebase/iid/zzm;
    //   329: aload 13
    //   331: invokevirtual 345	com/google/firebase/iid/zzm:send	(Landroid/os/Message;)V
    //   334: goto -63 -> 271
    //   337: astore 14
    //   339: ldc 132
    //   341: iconst_3
    //   342: invokestatic 138	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   345: ifeq +12 -> 357
    //   348: ldc 132
    //   350: ldc_w 347
    //   353: invokestatic 155	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   356: pop
    //   357: aload_0
    //   358: getfield 40	com/google/firebase/iid/v:e	Lcom/google/firebase/iid/p;
    //   361: invokevirtual 295	com/google/firebase/iid/p:a	()I
    //   364: iconst_2
    //   365: if_icmpne +15 -> 380
    //   368: aload_0
    //   369: getfield 38	com/google/firebase/iid/v:d	Landroid/content/Context;
    //   372: aload 7
    //   374: invokevirtual 353	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   377: goto -106 -> 271
    //   380: aload_0
    //   381: getfield 38	com/google/firebase/iid/v:d	Landroid/content/Context;
    //   384: aload 7
    //   386: invokevirtual 357	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   389: pop
    //   390: goto -119 -> 271
    //   393: astore 26
    //   395: aload 25
    //   397: monitorexit
    //   398: aload 26
    //   400: athrow
    //   401: astore 23
    //   403: ldc 132
    //   405: ldc_w 359
    //   408: invokestatic 187	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   411: pop
    //   412: new 271	java/io/IOException
    //   415: dup
    //   416: ldc_w 361
    //   419: invokespecial 298	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   422: athrow
    //   423: astore 17
    //   425: aload_0
    //   426: getfield 36	com/google/firebase/iid/v:c	Landroid/support/v4/util/SimpleArrayMap;
    //   429: astore 18
    //   431: aload 18
    //   433: monitorenter
    //   434: aload_0
    //   435: getfield 36	com/google/firebase/iid/v:c	Landroid/support/v4/util/SimpleArrayMap;
    //   438: aload_2
    //   439: invokevirtual 260	android/support/v4/util/SimpleArrayMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   442: pop
    //   443: aload 18
    //   445: monitorexit
    //   446: aload 17
    //   448: athrow
    //   449: astore 22
    //   451: new 271	java/io/IOException
    //   454: dup
    //   455: aload 22
    //   457: invokespecial 364	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   460: athrow
    //   461: astore 19
    //   463: aload 18
    //   465: monitorexit
    //   466: aload 19
    //   468: athrow
    //   469: astore 16
    //   471: goto -68 -> 403
    //
    // Exception table:
    //   from	to	target	type
    //   21	34	55	finally
    //   57	60	55	finally
    //   255	271	337	android/os/RemoteException
    //   325	334	337	android/os/RemoteException
    //   298	310	393	finally
    //   395	398	393	finally
    //   271	289	401	java/lang/InterruptedException
    //   271	289	423	finally
    //   403	423	423	finally
    //   451	461	423	finally
    //   271	289	449	java/util/concurrent/ExecutionException
    //   434	446	461	finally
    //   463	466	461	finally
    //   271	289	469	java/util/concurrent/TimeoutException
  }

  final Bundle a(Bundle paramBundle)
    throws IOException
  {
    Task localTask;
    if (this.e.d() >= 12000000)
      localTask = e.a(this.d).b(1, paramBundle);
    try
    {
      Bundle localBundle = (Bundle)Tasks.await(localTask);
      return localBundle;
    }
    catch (InterruptedException localInterruptedException)
    {
      if (Log.isLoggable("FirebaseInstanceId", 3))
      {
        String str = String.valueOf(localInterruptedException);
        Log.d("FirebaseInstanceId", 22 + String.valueOf(str).length() + "Error making request: " + str);
      }
      if (((localInterruptedException.getCause() instanceof n)) && (((n)localInterruptedException.getCause()).a() == 4))
        return b(paramBundle);
      return null;
      return b(paramBundle);
    }
    catch (ExecutionException localExecutionException)
    {
      label39: break label39;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.iid.v
 * JD-Core Version:    0.6.2
 */