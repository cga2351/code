package com.viber.voip.messages.a;

import com.viber.voip.messages.controller.manager.BotFavoriteLinksCommunicator.SaveLinkActionMessage;
import com.viber.voip.util.av;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class f
{
  public static class a
  {
    public final String a;
    public final int b;
    public final String c;

    public a(String paramString1, int paramInt, String paramString2)
    {
      this.a = paramString1;
      this.b = paramInt;
      this.c = paramString2;
    }

    public static void a(EventBus paramEventBus, BotFavoriteLinksCommunicator.SaveLinkActionMessage paramSaveLinkActionMessage)
    {
      if (!paramSaveLinkActionMessage.isSilent())
        paramEventBus.post(new a(paramSaveLinkActionMessage.getUrl(), paramSaveLinkActionMessage.getSource(), paramSaveLinkActionMessage.getMediaToken()));
    }

    public static abstract class a<T> extends e<T, f.a>
    {
      private final int a;

      public a(T paramT, int paramInt)
      {
        super();
        this.a = paramInt;
      }

      protected boolean a(f.a parama)
      {
        return !av.d(parama.b, this.a);
      }

      @Subscribe(threadMode=ThreadMode.MAIN)
      public final void onEvent(f.a parama)
      {
        a(parama);
      }
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
 * Qualified Name:     com.viber.voip.messages.a.f
 * JD-Core Version:    0.6.2
 */