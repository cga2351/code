package c.a.a.a.a.d;

import android.content.Context;

public class i
  implements Runnable
{
  private final Context a;
  private final e b;

  public i(Context paramContext, e parame)
  {
    this.a = paramContext;
    this.b = parame;
  }

  public void run()
  {
    try
    {
      c.a.a.a.a.b.i.a(this.a, "Performing time based file roll over.");
      if (!this.b.c())
        this.b.d();
      return;
    }
    catch (Exception localException)
    {
      c.a.a.a.a.b.i.a(this.a, "Failed to roll over file", localException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.d.i
 * JD-Core Version:    0.6.2
 */