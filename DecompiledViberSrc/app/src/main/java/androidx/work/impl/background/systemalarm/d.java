package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager.WakeLock;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.a;
import androidx.work.impl.b.j;
import androidx.work.impl.b.k;
import androidx.work.impl.h;
import java.util.Collections;
import java.util.List;

public class d
  implements a, androidx.work.impl.a.c, g.a
{
  private static final String a = androidx.work.i.a("DelayMetCommandHandler");
  private final Context b;
  private final int c;
  private final String d;
  private final e e;
  private final androidx.work.impl.a.d f;
  private final Object g;
  private boolean h;
  private PowerManager.WakeLock i;
  private boolean j;

  d(Context paramContext, int paramInt, String paramString, e parame)
  {
    this.b = paramContext;
    this.c = paramInt;
    this.e = parame;
    this.d = paramString;
    this.f = new androidx.work.impl.a.d(this.b, this);
    this.j = false;
    this.h = false;
    this.g = new Object();
  }

  private void b()
  {
    while (true)
    {
      synchronized (this.g)
      {
        if (!this.h)
        {
          androidx.work.i locali2 = androidx.work.i.a();
          String str2 = a;
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = this.d;
          locali2.b(str2, String.format("Stopping work for workspec %s", arrayOfObject2), new Throwable[0]);
          Intent localIntent1 = b.c(this.b, this.d);
          this.e.a(new e.a(this.e, localIntent1, this.c));
          if (this.e.b().e(this.d))
          {
            androidx.work.i locali4 = androidx.work.i.a();
            String str4 = a;
            Object[] arrayOfObject4 = new Object[1];
            arrayOfObject4[0] = this.d;
            locali4.b(str4, String.format("WorkSpec %s needs to be rescheduled", arrayOfObject4), new Throwable[0]);
            Intent localIntent2 = b.a(this.b, this.d);
            this.e.a(new e.a(this.e, localIntent2, this.c));
            this.h = true;
            return;
          }
          androidx.work.i locali3 = androidx.work.i.a();
          String str3 = a;
          Object[] arrayOfObject3 = new Object[1];
          arrayOfObject3[0] = this.d;
          locali3.b(str3, String.format("Processor does not have WorkSpec %s. No need to reschedule ", arrayOfObject3), new Throwable[0]);
        }
      }
      androidx.work.i locali1 = androidx.work.i.a();
      String str1 = a;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = this.d;
      locali1.b(str1, String.format("Already stopped work for %s", arrayOfObject1), new Throwable[0]);
    }
  }

  private void c()
  {
    synchronized (this.g)
    {
      this.f.a();
      this.e.c().a(this.d);
      if ((this.i != null) && (this.i.isHeld()))
      {
        androidx.work.i locali = androidx.work.i.a();
        String str = a;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = this.i;
        arrayOfObject[1] = this.d;
        locali.b(str, String.format("Releasing wakelock %s for WorkSpec %s", arrayOfObject), new Throwable[0]);
        this.i.release();
      }
      return;
    }
  }

  void a()
  {
    Context localContext = this.b;
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = this.d;
    arrayOfObject1[1] = Integer.valueOf(this.c);
    this.i = androidx.work.impl.utils.i.a(localContext, String.format("%s (%s)", arrayOfObject1));
    androidx.work.i locali1 = androidx.work.i.a();
    String str1 = a;
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = this.i;
    arrayOfObject2[1] = this.d;
    locali1.b(str1, String.format("Acquiring wakelock %s for WorkSpec %s", arrayOfObject2), new Throwable[0]);
    this.i.acquire();
    j localj = this.e.d().d().m().b(this.d);
    if (localj == null)
    {
      b();
      return;
    }
    this.j = localj.d();
    if (!this.j)
    {
      androidx.work.i locali2 = androidx.work.i.a();
      String str2 = a;
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = this.d;
      locali2.b(str2, String.format("No constraints for %s", arrayOfObject3), new Throwable[0]);
      a(Collections.singletonList(this.d));
      return;
    }
    this.f.a(Collections.singletonList(localj));
  }

  public void a(String paramString)
  {
    androidx.work.i.a().b(a, String.format("Exceeded time limits on execution for %s", new Object[] { paramString }), new Throwable[0]);
    b();
  }

  public void a(String paramString, boolean paramBoolean)
  {
    androidx.work.i locali = androidx.work.i.a();
    String str = a;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramString;
    arrayOfObject[1] = Boolean.valueOf(paramBoolean);
    locali.b(str, String.format("onExecuted %s, %s", arrayOfObject), new Throwable[0]);
    c();
    if (paramBoolean)
    {
      Intent localIntent2 = b.a(this.b, this.d);
      this.e.a(new e.a(this.e, localIntent2, this.c));
    }
    if (this.j)
    {
      Intent localIntent1 = b.a(this.b);
      this.e.a(new e.a(this.e, localIntent1, this.c));
    }
  }

  public void a(List<String> paramList)
  {
    if (!paramList.contains(this.d))
      return;
    androidx.work.i locali = androidx.work.i.a();
    String str = a;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.d;
    locali.b(str, String.format("onAllConstraintsMet for %s", arrayOfObject), new Throwable[0]);
    if (this.e.b().a(this.d))
    {
      this.e.c().a(this.d, 600000L, this);
      return;
    }
    c();
  }

  public void b(List<String> paramList)
  {
    b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.background.systemalarm.d
 * JD-Core Version:    0.6.2
 */