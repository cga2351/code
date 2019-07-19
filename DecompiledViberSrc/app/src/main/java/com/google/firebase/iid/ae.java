package com.google.firebase.iid;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.IOException;
import java.util.Map;

final class ae
{
  private int a = 0;
  private final Map<Integer, TaskCompletionSource<Void>> b = new ArrayMap();
  private final aa c;

  ae(aa paramaa)
  {
    this.c = paramaa;
  }

  private static boolean a(FirebaseInstanceId paramFirebaseInstanceId, String paramString)
  {
    String[] arrayOfString = paramString.split("!");
    if (arrayOfString.length == 2)
    {
      String str1 = arrayOfString[0];
      String str2 = arrayOfString[1];
      int i = -1;
      try
      {
        switch (str1.hashCode())
        {
        case 83:
          if (str1.equals("S"))
            i = 0;
          break;
        case 85:
          if (str1.equals("U"))
          {
            i = 1;
            break;
            paramFirebaseInstanceId.zzb(str2);
            if (!FirebaseInstanceId.zzm())
              break label208;
            Log.d("FirebaseInstanceId", "subscribe operation succeeded");
            return true;
          }
          break;
        case 84:
        }
      }
      catch (IOException localIOException)
      {
        String str3 = String.valueOf(localIOException.getMessage());
        if (str3.length() != 0);
        for (String str4 = "Topic sync failed: ".concat(str3); ; str4 = new String("Topic sync failed: "))
        {
          Log.e("FirebaseInstanceId", str4);
          return false;
          paramFirebaseInstanceId.zzc(str2);
          if (!FirebaseInstanceId.zzm())
            break;
          Log.d("FirebaseInstanceId", "unsubscribe operation succeeded");
          return true;
        }
        switch (i)
        {
        case 0:
        case 1:
        }
      }
    }
    label208: return true;
  }

  private final String b()
  {
    synchronized (this.c)
    {
      String str = this.c.a();
      if (!TextUtils.isEmpty(str))
      {
        String[] arrayOfString = str.split(",");
        if ((arrayOfString.length > 1) && (!TextUtils.isEmpty(arrayOfString[1])))
          return arrayOfString[1];
      }
    }
    return null;
  }

  private final boolean b(String paramString)
  {
    while (true)
    {
      String str5;
      try
      {
        synchronized (this.c)
        {
          String str1 = this.c.a();
          String str2 = String.valueOf(",");
          String str3 = String.valueOf(paramString);
          String str4;
          if (str3.length() != 0)
          {
            str4 = str2.concat(str3);
            if (!str1.startsWith(str4))
              break label159;
            str5 = String.valueOf(",");
            String str6 = String.valueOf(paramString);
            if (str6.length() != 0)
            {
              str7 = str5.concat(str6);
              String str8 = str1.substring(str7.length());
              this.c.a(str8);
              bool = true;
              return bool;
            }
          }
          else
          {
            str4 = new String(str2);
          }
        }
      }
      finally
      {
      }
      String str7 = new String(str5);
      continue;
      label159: boolean bool = false;
    }
  }

  final Task<Void> a(String paramString)
  {
    while (true)
    {
      String str;
      try
      {
        synchronized (this.c)
        {
          str = this.c.a();
          this.c.a(1 + String.valueOf(str).length() + String.valueOf(paramString).length() + str + "," + paramString);
          TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
          Map localMap = this.b;
          if (TextUtils.isEmpty(str))
          {
            i = 0;
            localMap.put(Integer.valueOf(i + this.a), localTaskCompletionSource);
            Task localTask = localTaskCompletionSource.getTask();
            return localTask;
          }
        }
      }
      finally
      {
      }
      int j = str.split(",").length;
      int i = j - 1;
    }
  }

  final boolean a()
  {
    try
    {
      String str = b();
      if (str != null)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  final boolean a(FirebaseInstanceId paramFirebaseInstanceId)
  {
    while (true)
    {
      String str;
      try
      {
        str = b();
        if (str == null)
        {
          if (FirebaseInstanceId.zzm())
            Log.d("FirebaseInstanceId", "topic sync succeeded");
          return true;
        }
        if (!a(paramFirebaseInstanceId, str))
          return false;
      }
      finally
      {
      }
      try
      {
        TaskCompletionSource localTaskCompletionSource = (TaskCompletionSource)this.b.remove(Integer.valueOf(this.a));
        b(str);
        this.a = (1 + this.a);
        if (localTaskCompletionSource == null)
          continue;
        localTaskCompletionSource.setResult(null);
      }
      finally
      {
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.iid.ae
 * JD-Core Version:    0.6.2
 */