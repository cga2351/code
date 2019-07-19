package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class aa
{
  private final SharedPreferences a;
  private final Context b;
  private final ay c;
  private final Map<String, d> d = new ArrayMap();

  public aa(Context paramContext)
  {
    this(paramContext, new ay());
  }

  private aa(Context paramContext, ay paramay)
  {
    this.b = paramContext;
    this.a = paramContext.getSharedPreferences("com.google.android.gms.appid", 0);
    this.c = paramay;
    File localFile = new File(ContextCompat.getNoBackupFilesDir(this.b), "com.google.android.gms.appid-no-backup");
    if (!localFile.exists());
    String str1;
    try
    {
      if ((localFile.createNewFile()) && (!c()))
      {
        Log.i("FirebaseInstanceId", "App restored, clearing state");
        b();
        FirebaseInstanceId.getInstance().zzn();
      }
      return;
    }
    catch (IOException localIOException)
    {
      while (!Log.isLoggable("FirebaseInstanceId", 3));
      str1 = String.valueOf(localIOException.getMessage());
      if (str1.length() == 0);
    }
    for (String str2 = "Error creating file in no backup dir: ".concat(str1); ; str2 = new String("Error creating file in no backup dir: "))
    {
      Log.d("FirebaseInstanceId", str2);
      return;
    }
  }

  static String a(String paramString1, String paramString2)
  {
    return 3 + String.valueOf(paramString1).length() + String.valueOf(paramString2).length() + paramString1 + "|S|" + paramString2;
  }

  private static String c(String paramString1, String paramString2, String paramString3)
  {
    return 4 + String.valueOf(paramString1).length() + String.valueOf(paramString2).length() + String.valueOf(paramString3).length() + paramString1 + "|T|" + paramString2 + "|" + paramString3;
  }

  private final boolean c()
  {
    try
    {
      boolean bool = this.a.getAll().isEmpty();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final z a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      z localz = z.a(this.a.getString(c(paramString1, paramString2, paramString3), null));
      return localz;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final String a()
  {
    try
    {
      String str = this.a.getString("topic_operaion_queue", "");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void a(String paramString)
  {
    try
    {
      this.a.edit().putString("topic_operaion_queue", paramString).apply();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      String str = z.a(paramString4, paramString5, System.currentTimeMillis());
      if (str == null);
      while (true)
      {
        return;
        SharedPreferences.Editor localEditor = this.a.edit();
        localEditor.putString(c(paramString1, paramString2, paramString3), str);
        localEditor.commit();
      }
    }
    finally
    {
    }
  }

  // ERROR //
  public final d b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 31	com/google/firebase/iid/aa:d	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 196 2 0
    //   12: checkcast 198	com/google/firebase/iid/d
    //   15: astore_3
    //   16: aload_3
    //   17: ifnull +7 -> 24
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_3
    //   23: areturn
    //   24: aload_0
    //   25: getfield 45	com/google/firebase/iid/aa:c	Lcom/google/firebase/iid/ay;
    //   28: aload_0
    //   29: getfield 33	com/google/firebase/iid/aa:b	Landroid/content/Context;
    //   32: aload_1
    //   33: invokevirtual 201	com/google/firebase/iid/ay:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/google/firebase/iid/d;
    //   36: astore 8
    //   38: aload 8
    //   40: astore_3
    //   41: aload_0
    //   42: getfield 31	com/google/firebase/iid/aa:d	Ljava/util/Map;
    //   45: aload_1
    //   46: aload_3
    //   47: invokeinterface 205 3 0
    //   52: pop
    //   53: goto -33 -> 20
    //   56: astore_2
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_2
    //   60: athrow
    //   61: astore 4
    //   63: ldc 69
    //   65: ldc 207
    //   67: invokestatic 210	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   70: pop
    //   71: invokestatic 85	com/google/firebase/iid/FirebaseInstanceId:getInstance	()Lcom/google/firebase/iid/FirebaseInstanceId;
    //   74: invokevirtual 88	com/google/firebase/iid/FirebaseInstanceId:zzn	()V
    //   77: aload_0
    //   78: getfield 45	com/google/firebase/iid/aa:c	Lcom/google/firebase/iid/ay;
    //   81: aload_0
    //   82: getfield 33	com/google/firebase/iid/aa:b	Landroid/content/Context;
    //   85: aload_1
    //   86: invokevirtual 212	com/google/firebase/iid/ay:b	(Landroid/content/Context;Ljava/lang/String;)Lcom/google/firebase/iid/d;
    //   89: astore 6
    //   91: aload 6
    //   93: astore_3
    //   94: goto -53 -> 41
    //
    // Exception table:
    //   from	to	target	type
    //   2	16	56	finally
    //   24	38	56	finally
    //   41	53	56	finally
    //   63	91	56	finally
    //   24	38	61	com/google/firebase/iid/ba
  }

  public final void b()
  {
    try
    {
      this.d.clear();
      ay.a(this.b);
      this.a.edit().clear().commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void b(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      String str = c(paramString1, paramString2, paramString3);
      SharedPreferences.Editor localEditor = this.a.edit();
      localEditor.remove(str);
      localEditor.commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void c(String paramString)
  {
    SharedPreferences.Editor localEditor;
    try
    {
      String str1 = String.valueOf(paramString).concat("|T|");
      localEditor = this.a.edit();
      Iterator localIterator = this.a.getAll().keySet().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (str2.startsWith(str1))
          localEditor.remove(str2);
      }
    }
    finally
    {
    }
    localEditor.commit();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.iid.aa
 * JD-Core Version:    0.6.2
 */