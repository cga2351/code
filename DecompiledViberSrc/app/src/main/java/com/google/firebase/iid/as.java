package com.google.firebase.iid;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import com.google.firebase.d.g;
import java.io.IOException;
import java.util.concurrent.Executor;

final class as
  implements b
{
  private final FirebaseApp a;
  private final p b;
  private final v c;
  private final Executor d;
  private final g e;

  as(FirebaseApp paramFirebaseApp, p paramp, Executor paramExecutor, g paramg)
  {
    this(paramFirebaseApp, paramp, paramExecutor, new v(paramFirebaseApp.a(), paramp), paramg);
  }

  private as(FirebaseApp paramFirebaseApp, p paramp, Executor paramExecutor, v paramv, g paramg)
  {
    this.a = paramFirebaseApp;
    this.b = paramp;
    this.c = paramv;
    this.d = paramExecutor;
    this.e = paramg;
  }

  private final <T> Task<Void> a(Task<T> paramTask)
  {
    return paramTask.continueWith(aj.a(), new at(this));
  }

  private final Task<Bundle> a(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    paramBundle.putString("scope", paramString3);
    paramBundle.putString("sender", paramString2);
    paramBundle.putString("subtype", paramString2);
    paramBundle.putString("appid", paramString1);
    paramBundle.putString("gmp_app_id", this.a.c().a());
    paramBundle.putString("gmsv", Integer.toString(this.b.d()));
    paramBundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
    paramBundle.putString("app_ver", this.b.b());
    paramBundle.putString("app_ver_name", this.b.c());
    paramBundle.putString("cliv", "fiid-12451000");
    paramBundle.putString("Firebase-Client", this.e.a());
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    this.d.execute(new au(this, paramBundle, localTaskCompletionSource));
    return localTaskCompletionSource.getTask();
  }

  private static String a(Bundle paramBundle)
    throws IOException
  {
    if (paramBundle == null)
      throw new IOException("SERVICE_NOT_AVAILABLE");
    String str1 = paramBundle.getString("registration_id");
    if (str1 != null);
    do
    {
      return str1;
      str1 = paramBundle.getString("unregistered");
    }
    while (str1 != null);
    String str2 = paramBundle.getString("error");
    if ("RST".equals(str2))
      throw new IOException("INSTANCE_ID_RESET");
    if (str2 != null)
      throw new IOException(str2);
    String str3 = String.valueOf(paramBundle);
    Log.w("FirebaseInstanceId", 21 + String.valueOf(str3).length() + "Unexpected response: " + str3, new Throwable());
    throw new IOException("SERVICE_NOT_AVAILABLE");
  }

  private final Task<String> b(Task<Bundle> paramTask)
  {
    return paramTask.continueWith(this.d, new aw(this));
  }

  public final Task<Void> a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("iid-operation", "delete");
    localBundle.putString("delete", "1");
    return a(b(a(paramString, "*", "*", localBundle)));
  }

  public final Task<Void> a(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    String str1 = String.valueOf("/topics/");
    String str2 = String.valueOf(paramString3);
    String str3;
    String str4;
    String str5;
    if (str2.length() != 0)
    {
      str3 = str1.concat(str2);
      localBundle.putString("gcm.topic", str3);
      str4 = String.valueOf("/topics/");
      str5 = String.valueOf(paramString3);
      if (str5.length() == 0)
        break label111;
    }
    label111: for (String str6 = str4.concat(str5); ; str6 = new String(str4))
    {
      return a(b(a(paramString1, paramString2, str6, localBundle)));
      str3 = new String(str1);
      break;
    }
  }

  public final Task<String> a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return b(a(paramString1, paramString3, paramString4, new Bundle()));
  }

  public final boolean a()
  {
    return this.b.a() != 0;
  }

  public final Task<Void> b(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    String str1 = String.valueOf("/topics/");
    String str2 = String.valueOf(paramString3);
    String str3;
    String str4;
    String str5;
    if (str2.length() != 0)
    {
      str3 = str1.concat(str2);
      localBundle.putString("gcm.topic", str3);
      localBundle.putString("delete", "1");
      str4 = String.valueOf("/topics/");
      str5 = String.valueOf(paramString3);
      if (str5.length() == 0)
        break label120;
    }
    label120: for (String str6 = str4.concat(str5); ; str6 = new String(str4))
    {
      return a(b(a(paramString1, paramString2, str6, localBundle)));
      str3 = new String(str1);
      break;
    }
  }

  public final Task<Void> b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("delete", "1");
    return a(b(a(paramString1, paramString3, paramString4, localBundle)));
  }

  public final boolean b()
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.iid.as
 * JD-Core Version:    0.6.2
 */