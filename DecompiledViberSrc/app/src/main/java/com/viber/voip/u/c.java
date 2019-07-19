package com.viber.voip.u;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public abstract class c
  implements com.viber.voip.q.b
{
  public abstract void a(int paramInt);

  public void c()
  {
  }

  @Subscribe(threadMode=ThreadMode.MAIN_ORDERED)
  public final void onRecordStateChanged(b paramb)
  {
    switch (paramb.b)
    {
    default:
      return;
    case 1:
      a();
      return;
    case 0:
      a(paramb.c);
      return;
    case 2:
      b();
      return;
    case 4:
      c();
      return;
    case 3:
    }
    a(paramb.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.u.c
 * JD-Core Version:    0.6.2
 */