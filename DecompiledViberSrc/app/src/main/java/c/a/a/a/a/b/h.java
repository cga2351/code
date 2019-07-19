package c.a.a.a.a.b;

import android.os.Process;

public abstract class h
  implements Runnable
{
  protected abstract void a();

  public final void run()
  {
    Process.setThreadPriority(10);
    a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.b.h
 * JD-Core Version:    0.6.2
 */