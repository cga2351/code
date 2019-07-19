package com.viber.voip.notif.i;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.a.j.a;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.util.LongSparseSet;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class c
{
  private static final Logger a = ViberEnv.getLogger();
  private h b;

  public void a(EventBus paramEventBus, h paramh)
  {
    this.b = paramh;
    paramEventBus.register(this);
  }

  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onMessageEdited(j.a parama)
  {
    parama.a.getMessageToken();
    if (this.b == null);
    long l;
    do
    {
      return;
      l = parama.a.getConversationId();
    }
    while (!this.b.a().contains(l));
    this.b.a(LongSparseSet.from(new long[] { l }));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.i.c
 * JD-Core Version:    0.6.2
 */