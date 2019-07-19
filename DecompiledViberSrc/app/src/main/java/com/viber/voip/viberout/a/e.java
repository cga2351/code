package com.viber.voip.viberout.a;

import android.os.Handler;
import com.viber.jni.viberout.ViberOutBalanceDelegate;
import com.viber.jni.viberout.ViberOutBalanceListener;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class e
  implements ViberOutBalanceDelegate
{
  private final ViberOutBalanceListener a;
  private final Handler b;
  private final List<a> c = new ArrayList();

  @Inject
  public e(ViberOutBalanceListener paramViberOutBalanceListener, Handler paramHandler)
  {
    this.a = paramViberOutBalanceListener;
    this.b = paramHandler;
  }

  public void a()
  {
    int i = this.c.size();
    for (int j = 0; j < i; j++)
      ((a)this.c.get(j)).a();
  }

  public void a(a parama)
  {
    if (this.c.isEmpty())
      this.a.registerDelegate(this, this.b);
    this.c.add(parama);
  }

  public void b(a parama)
  {
    this.c.remove(parama);
    if (this.c.isEmpty())
      this.a.removeDelegate(this);
  }

  public boolean onViberOutBalanceChange(long paramLong)
  {
    a();
    return true;
  }

  public static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.a.e
 * JD-Core Version:    0.6.2
 */