package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.work.i;
import androidx.work.impl.b.j;
import androidx.work.impl.d;

public class f
  implements d
{
  private static final String a = i.a("SystemAlarmScheduler");
  private final Context b;

  public f(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
  }

  private void a(j paramj)
  {
    i locali = i.a();
    String str = a;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramj.a;
    locali.b(str, String.format("Scheduling work with workSpecId %s", arrayOfObject), new Throwable[0]);
    Intent localIntent = b.a(this.b, paramj.a);
    this.b.startService(localIntent);
  }

  public void a(String paramString)
  {
    Intent localIntent = b.c(this.b, paramString);
    this.b.startService(localIntent);
  }

  public void a(j[] paramArrayOfj)
  {
    int i = paramArrayOfj.length;
    for (int j = 0; j < i; j++)
      a(paramArrayOfj[j]);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.background.systemalarm.f
 * JD-Core Version:    0.6.2
 */