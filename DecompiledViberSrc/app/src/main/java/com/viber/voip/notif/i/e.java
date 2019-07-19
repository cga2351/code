package com.viber.voip.notif.i;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.util.LongSparseSet;
import com.viber.voip.util.cj;

public class e
{
  private static final Logger b = ViberEnv.getLogger();
  final LongSparseSet a = new LongSparseSet();
  private h c;
  private final Context d;

  public e(Context paramContext)
  {
    this.d = paramContext;
  }

  public void a(bv parambv, h paramh)
  {
    synchronized (this.a)
    {
      this.c = paramh;
      parambv.a(new f(this));
      return;
    }
  }

  public void a(MessageEntity paramMessageEntity)
  {
    synchronized (this.a)
    {
      this.a.add(paramMessageEntity.getMessageToken());
      return;
    }
  }

  void a(MessageEntity paramMessageEntity, int paramInt)
  {
    long l1 = paramMessageEntity.getMessageToken();
    while (true)
    {
      synchronized (this.a)
      {
        if (this.a.contains(l1))
          break label131;
        return;
        if (this.c != null)
          break;
        return;
      }
      this.a.remove(l1);
      continue;
      if (cj.b(this.d))
        this.a.remove(l1);
    }
    if (paramInt == 0)
    {
      long l2 = paramMessageEntity.getConversationId();
      if (this.c.a().contains(l2))
        this.c.a(LongSparseSet.from(new long[] { l2 }));
    }
    return;
    label131: switch (paramInt)
    {
    case 1:
    default:
    case 0:
    case 3:
    case 4:
    case 2:
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.i.e
 * JD-Core Version:    0.6.2
 */