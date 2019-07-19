package com.viber.voip.messages.a;

import com.viber.voip.util.av;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class i
{
  public static abstract class a<T> extends e<T, i.b>
  {
    private final int a;

    public a(T paramT, int paramInt)
    {
      super();
      this.a = paramInt;
    }

    protected boolean a(i.b paramb)
    {
      return !av.d(paramb.a, this.a);
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public final void onEvent(i.b paramb)
    {
      a(paramb);
    }
  }

  public static class b
  {
    public final int a;

    public b(int paramInt)
    {
      this.a = paramInt;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.a.i
 * JD-Core Version:    0.6.2
 */