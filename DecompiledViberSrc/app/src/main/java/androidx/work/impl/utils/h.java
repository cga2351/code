package androidx.work.impl.utils;

import androidx.work.i;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.k;
import androidx.work.impl.c;
import androidx.work.o.a;

public class h
  implements Runnable
{
  private static final String a = i.a("StopWorkRunnable");
  private androidx.work.impl.h b;
  private String c;

  public h(androidx.work.impl.h paramh, String paramString)
  {
    this.b = paramh;
    this.c = paramString;
  }

  public void run()
  {
    WorkDatabase localWorkDatabase = this.b.d();
    k localk = localWorkDatabase.m();
    localWorkDatabase.f();
    try
    {
      if (localk.f(this.c) == o.a.b)
      {
        o.a locala = o.a.a;
        String[] arrayOfString = new String[1];
        arrayOfString[0] = this.c;
        localk.a(locala, arrayOfString);
      }
      boolean bool = this.b.g().b(this.c);
      i locali = i.a();
      String str = a;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.c;
      arrayOfObject[1] = Boolean.valueOf(bool);
      locali.b(str, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", arrayOfObject), new Throwable[0]);
      localWorkDatabase.h();
      return;
    }
    finally
    {
      localWorkDatabase.g();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.utils.h
 * JD-Core Version:    0.6.2
 */