package com.viber.voip.messages.controller;

import android.content.Context;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.notif.e.s;
import com.viber.voip.notif.g;
import com.viber.voip.util.upload.t;
import java.util.HashMap;
import java.util.Map;

public class bl
{
  private static final Logger a = ViberEnv.getLogger();
  private Map<Long, Runnable> b = new HashMap();
  private Handler c;
  private final Context d;

  public bl(Handler paramHandler, Context paramContext)
  {
    this.c = paramHandler;
    this.d = paramContext;
  }

  public void a(long paramLong)
  {
    Runnable localRunnable = (Runnable)this.b.remove(Long.valueOf(paramLong));
    this.c.removeCallbacks(localRunnable);
  }

  public boolean a(MessageEntity paramMessageEntity)
  {
    if (this.b.containsKey(Long.valueOf(paramMessageEntity.getId())))
      return false;
    bm localbm = new bm(this, paramMessageEntity);
    this.b.put(Long.valueOf(paramMessageEntity.getId()), localbm);
    long l = t.a;
    this.c.postDelayed(localbm, l);
    return false;
  }

  public void b(MessageEntity paramMessageEntity)
  {
    g.a(this.d).d().a(paramMessageEntity.getConversationId());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.bl
 * JD-Core Version:    0.6.2
 */