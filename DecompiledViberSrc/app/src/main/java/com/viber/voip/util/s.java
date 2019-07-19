package com.viber.voip.util;

import android.os.Handler;
import com.viber.voip.av;
import com.viber.voip.av.e;

public abstract class s extends r
{
  protected Handler c = av.a(av.e.a);
  protected Runnable d;

  public s(Runnable paramRunnable)
  {
    this.d = paramRunnable;
  }

  public void a()
  {
    super.a();
    d();
  }

  protected abstract void ac_();

  protected void d()
  {
    if (this.d == null)
      return;
    if ((this.d instanceof r))
      ((r)this.d).a();
    this.c.removeCallbacks(this.d);
    this.d = null;
  }

  public void run()
  {
    ac_();
    if (this.d != null)
      this.c.post(this.d);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.s
 * JD-Core Version:    0.6.2
 */