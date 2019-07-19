package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.i;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.j;
import androidx.work.impl.b.k;
import androidx.work.impl.h;
import androidx.work.o.a;
import java.util.HashMap;
import java.util.Map;

public class b
  implements androidx.work.impl.a
{
  private static final String a = i.a("CommandHandler");
  private final Context b;
  private final Map<String, androidx.work.impl.a> c;
  private final Object d;

  b(Context paramContext)
  {
    this.b = paramContext;
    this.c = new HashMap();
    this.d = new Object();
  }

  static Intent a(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, SystemAlarmService.class);
    localIntent.setAction("ACTION_CONSTRAINTS_CHANGED");
    return localIntent;
  }

  static Intent a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, SystemAlarmService.class);
    localIntent.setAction("ACTION_SCHEDULE_WORK");
    localIntent.putExtra("KEY_WORKSPEC_ID", paramString);
    return localIntent;
  }

  static Intent a(Context paramContext, String paramString, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, SystemAlarmService.class);
    localIntent.setAction("ACTION_EXECUTION_COMPLETED");
    localIntent.putExtra("KEY_WORKSPEC_ID", paramString);
    localIntent.putExtra("KEY_NEEDS_RESCHEDULE", paramBoolean);
    return localIntent;
  }

  private static boolean a(Bundle paramBundle, String[] paramArrayOfString)
  {
    if ((paramBundle == null) || (paramBundle.isEmpty()))
      return false;
    int i = paramArrayOfString.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label39;
      if (paramBundle.get(paramArrayOfString[j]) == null)
        break;
    }
    label39: return true;
  }

  static Intent b(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, SystemAlarmService.class);
    localIntent.setAction("ACTION_RESCHEDULE");
    return localIntent;
  }

  static Intent b(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, SystemAlarmService.class);
    localIntent.setAction("ACTION_DELAY_MET");
    localIntent.putExtra("KEY_WORKSPEC_ID", paramString);
    return localIntent;
  }

  private void b(Intent paramIntent, int paramInt, e parame)
  {
    String str1 = paramIntent.getExtras().getString("KEY_WORKSPEC_ID");
    i.a().b(a, String.format("Handling schedule work for %s", new Object[] { str1 }), new Throwable[0]);
    WorkDatabase localWorkDatabase = parame.d().d();
    localWorkDatabase.f();
    try
    {
      j localj = localWorkDatabase.m().b(str1);
      if (localj == null)
      {
        i.a().d(a, "Skipping scheduling " + str1 + " because it's no longer in the DB", new Throwable[0]);
        return;
      }
      if (localj.b.a())
      {
        i.a().d(a, "Skipping scheduling " + str1 + "because it is finished.", new Throwable[0]);
        return;
      }
      long l = localj.c();
      if (!localj.d())
      {
        i locali2 = i.a();
        String str3 = a;
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = str1;
        arrayOfObject2[1] = Long.valueOf(l);
        locali2.b(str3, String.format("Setting up Alarms for %s at %s", arrayOfObject2), new Throwable[0]);
        a.a(this.b, parame.d(), str1, l);
      }
      while (true)
      {
        localWorkDatabase.h();
        return;
        i locali1 = i.a();
        String str2 = a;
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = str1;
        arrayOfObject1[1] = Long.valueOf(l);
        locali1.b(str2, String.format("Opportunistically setting an alarm for %s at %s", arrayOfObject1), new Throwable[0]);
        a.a(this.b, parame.d(), str1, l);
        parame.a(new e.a(parame, a(this.b), paramInt));
      }
    }
    finally
    {
      localWorkDatabase.g();
    }
  }

  static Intent c(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, SystemAlarmService.class);
    localIntent.setAction("ACTION_STOP_WORK");
    localIntent.putExtra("KEY_WORKSPEC_ID", paramString);
    return localIntent;
  }

  private void c(Intent paramIntent, int paramInt, e parame)
  {
    Bundle localBundle = paramIntent.getExtras();
    synchronized (this.d)
    {
      String str = localBundle.getString("KEY_WORKSPEC_ID");
      i.a().b(a, String.format("Handing delay met for %s", new Object[] { str }), new Throwable[0]);
      if (!this.c.containsKey(str))
      {
        d locald = new d(this.b, paramInt, str, parame);
        this.c.put(str, locald);
        locald.a();
        return;
      }
      i.a().b(a, String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", new Object[] { str }), new Throwable[0]);
    }
  }

  private void d(Intent paramIntent, int paramInt, e parame)
  {
    String str = paramIntent.getExtras().getString("KEY_WORKSPEC_ID");
    i.a().b(a, String.format("Handing stopWork work for %s", new Object[] { str }), new Throwable[0]);
    parame.d().d(str);
    a.a(this.b, parame.d(), str);
    parame.a(str, false);
  }

  private void e(Intent paramIntent, int paramInt, e parame)
  {
    i.a().b(a, String.format("Handling constraints changed %s", new Object[] { paramIntent }), new Throwable[0]);
    new c(this.b, paramInt, parame).a();
  }

  private void f(Intent paramIntent, int paramInt, e parame)
  {
    i locali = i.a();
    String str = a;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramIntent;
    arrayOfObject[1] = Integer.valueOf(paramInt);
    locali.b(str, String.format("Handling reschedule %s, %s", arrayOfObject), new Throwable[0]);
    parame.d().j();
  }

  private void g(Intent paramIntent, int paramInt, e parame)
  {
    Bundle localBundle = paramIntent.getExtras();
    String str1 = localBundle.getString("KEY_WORKSPEC_ID");
    boolean bool = localBundle.getBoolean("KEY_NEEDS_RESCHEDULE");
    i locali = i.a();
    String str2 = a;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramIntent;
    arrayOfObject[1] = Integer.valueOf(paramInt);
    locali.b(str2, String.format("Handling onExecutionCompleted %s, %s", arrayOfObject), new Throwable[0]);
    a(str1, bool);
  }

  void a(Intent paramIntent, int paramInt, e parame)
  {
    String str = paramIntent.getAction();
    if ("ACTION_CONSTRAINTS_CHANGED".equals(str))
    {
      e(paramIntent, paramInt, parame);
      return;
    }
    if ("ACTION_RESCHEDULE".equals(str))
    {
      f(paramIntent, paramInt, parame);
      return;
    }
    if (!a(paramIntent.getExtras(), new String[] { "KEY_WORKSPEC_ID" }))
    {
      i.a().e(a, String.format("Invalid request for %s, requires %s.", new Object[] { str, "KEY_WORKSPEC_ID" }), new Throwable[0]);
      return;
    }
    if ("ACTION_SCHEDULE_WORK".equals(str))
    {
      b(paramIntent, paramInt, parame);
      return;
    }
    if ("ACTION_DELAY_MET".equals(str))
    {
      c(paramIntent, paramInt, parame);
      return;
    }
    if ("ACTION_STOP_WORK".equals(str))
    {
      d(paramIntent, paramInt, parame);
      return;
    }
    if ("ACTION_EXECUTION_COMPLETED".equals(str))
    {
      g(paramIntent, paramInt, parame);
      return;
    }
    i.a().d(a, String.format("Ignoring intent %s", new Object[] { paramIntent }), new Throwable[0]);
  }

  public void a(String paramString, boolean paramBoolean)
  {
    synchronized (this.d)
    {
      androidx.work.impl.a locala = (androidx.work.impl.a)this.c.remove(paramString);
      if (locala != null)
        locala.a(paramString, paramBoolean);
      return;
    }
  }

  boolean a()
  {
    while (true)
    {
      synchronized (this.d)
      {
        if (!this.c.isEmpty())
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.background.systemalarm.b
 * JD-Core Version:    0.6.2
 */