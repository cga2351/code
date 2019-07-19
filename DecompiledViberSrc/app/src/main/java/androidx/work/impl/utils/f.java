package androidx.work.impl.utils;

import androidx.work.WorkerParameters.a;
import androidx.work.impl.c;
import androidx.work.impl.h;

public class f
  implements Runnable
{
  private h a;
  private String b;
  private WorkerParameters.a c;

  public f(h paramh, String paramString, WorkerParameters.a parama)
  {
    this.a = paramh;
    this.b = paramString;
    this.c = parama;
  }

  public void run()
  {
    this.a.g().a(this.b, this.c);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.utils.f
 * JD-Core Version:    0.6.2
 */