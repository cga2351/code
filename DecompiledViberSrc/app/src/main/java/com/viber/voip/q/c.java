package com.viber.voip.q;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.p.e;
import com.viber.voip.p.e.a;
import com.viber.voip.sound.AudioStreamManager;
import java.util.LinkedList;

public class c extends AudioStreamManager
{
  private static final Logger a = ViberEnv.getLogger();
  private final com.viber.voip.p.c b = new e(paramContext, this.d);
  private volatile boolean c;
  private final e.a d = new e.a()
  {
    public void onProximityChanged(boolean paramAnonymousBoolean)
    {
      if (c.a(c.this) == paramAnonymousBoolean)
        return;
      c.a(c.this, paramAnonymousBoolean);
      if (paramAnonymousBoolean)
      {
        c.this.changeStream(0);
        return;
      }
      c.this.restoreStream();
    }
  };

  public c(Context paramContext)
  {
    super(paramContext);
  }

  void a()
  {
    if (this.b.a())
      this.b.b();
  }

  void b()
  {
    this.c = false;
    if (this.b.a())
      this.b.c();
  }

  public boolean changeStream(int paramInt)
  {
    synchronized (this.mStreamStack)
    {
      boolean bool1 = this.mStreamStack.isEmpty();
      boolean bool2 = super.changeStream(paramInt);
      if ((bool2) && (bool1))
        a();
      return bool2;
    }
  }

  public boolean restoreStream()
  {
    synchronized (this.mStreamStack)
    {
      if ((this.c) && (getCurrentAudioStream() == 0))
        this.mStreamStack.poll();
      boolean bool1 = super.restoreStream();
      boolean bool2 = this.mStreamStack.isEmpty();
      if ((bool1) && (bool2))
        b();
      return bool1;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.q.c
 * JD-Core Version:    0.6.2
 */