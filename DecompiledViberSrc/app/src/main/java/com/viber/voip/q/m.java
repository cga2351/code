package com.viber.voip.q;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public abstract class m
  implements b
{
  public abstract void a(int paramInt);

  public void c()
  {
  }

  @Subscribe(threadMode=ThreadMode.MAIN_ORDERED)
  public final void onRecordStateChanged(l paraml)
  {
    switch (paraml.b)
    {
    default:
      return;
    case 1:
      a();
      return;
    case 0:
      a(paraml.c);
      return;
    case 2:
      b();
      return;
    case 4:
      c();
      return;
    case 3:
    }
    a(paraml.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.q.m
 * JD-Core Version:    0.6.2
 */