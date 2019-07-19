package com.viber.voip.notif.i;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.a.h.a;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.util.LongSparseSet;
import com.viber.voip.util.da;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class d
{
  private static final Logger b = ViberEnv.getLogger();
  final LongSparseSet a = new LongSparseSet();
  private h c;

  public void a(MessageEntity paramMessageEntity)
  {
    synchronized (this.a)
    {
      this.a.add(paramMessageEntity.getMessageToken());
      return;
    }
  }

  public void a(EventBus paramEventBus, h paramh)
  {
    synchronized (this.a)
    {
      this.c = paramh;
      paramEventBus.register(this);
      return;
    }
  }

  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onLocationAddressSet(h.a parama)
  {
    long l1 = parama.a.getMessageToken();
    synchronized (this.a)
    {
      if (!this.a.contains(l1))
        return;
      if (da.a(parama.a.getBucket()))
        return;
    }
    this.a.remove(l1);
    if (this.c == null)
      return;
    long l2 = parama.a.getConversationId();
    if (this.c.a().contains(l2))
      this.c.a(LongSparseSet.from(new long[] { l2 }));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.i.d
 * JD-Core Version:    0.6.2
 */