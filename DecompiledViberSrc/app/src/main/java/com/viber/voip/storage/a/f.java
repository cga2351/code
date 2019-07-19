package com.viber.voip.storage.a;

import android.os.Handler;
import com.viber.voip.storage.repository.p.a;

class f
{
  private final Handler a;

  f(Handler paramHandler)
  {
    this.a = paramHandler;
  }

  public i.a a(i.a parama)
  {
    return new a(parama, this.a);
  }

  private static class a
    implements i.a
  {
    private final i.a a;
    private final Handler b;

    a(i.a parama, Handler paramHandler)
    {
      this.a = parama;
      this.b = paramHandler;
    }

    public void a(int paramInt)
    {
      this.b.post(new g(this, paramInt));
    }

    public void a(p.a parama)
    {
      this.b.post(new h(this, parama));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.a.f
 * JD-Core Version:    0.6.2
 */