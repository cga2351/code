package com.viber.voip;

import android.os.Looper;
import android.os.Message;
import com.viber.dexshared.Logger;

public class ao extends aj
{
  final Object b = new Object();
  private boolean c;

  public ao(av.e parame, Looper paramLooper)
  {
    super(parame, paramLooper);
  }

  protected Logger a(av.e parame)
  {
    return ViberEnv.getLogger("release-tag");
  }

  public void a()
  {
    synchronized (this.b)
    {
      this.c = true;
      return;
    }
  }

  public void b()
  {
    synchronized (this.b)
    {
      this.c = false;
      this.b.notify();
      return;
    }
  }

  public void dispatchMessage(Message paramMessage)
  {
    while (true)
    {
      if (this.c)
        synchronized (this.b)
        {
          boolean bool = this.c;
          if (!bool);
        }
      try
      {
        this.b.wait();
        label32: continue;
        localObject2 = finally;
        throw localObject2;
        super.dispatchMessage(paramMessage);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label32;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ao
 * JD-Core Version:    0.6.2
 */