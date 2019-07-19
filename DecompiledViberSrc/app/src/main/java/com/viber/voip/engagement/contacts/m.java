package com.viber.voip.engagement.contacts;

import android.support.v4.util.ArrayMap;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.Map;

class m
{
  private static final Logger a = ViberEnv.getLogger();
  private final Map<SendButtonReceiverId, Integer> b = new ArrayMap();
  private boolean c = true;

  public m(SendButtonReceiverId[] paramArrayOfSendButtonReceiverId)
  {
    int i = paramArrayOfSendButtonReceiverId.length;
    for (int j = 0; j < i; j++)
    {
      SendButtonReceiverId localSendButtonReceiverId = paramArrayOfSendButtonReceiverId[j];
      this.b.put(localSendButtonReceiverId, Integer.valueOf(2));
    }
  }

  public void a(SendButtonReceiverId paramSendButtonReceiverId)
  {
    this.b.put(paramSendButtonReceiverId, Integer.valueOf(1));
  }

  public void a(l paraml, SendButtonReceiverId paramSendButtonReceiverId)
  {
    boolean bool = this.b.containsKey(paramSendButtonReceiverId);
    int i = 0;
    if (bool)
      i = ((Integer)this.b.get(paramSendButtonReceiverId)).intValue();
    switch (i)
    {
    default:
      return;
    case 0:
      paraml.a(this.c);
      return;
    case 1:
      paraml.b();
      this.b.put(paramSendButtonReceiverId, Integer.valueOf(2));
      return;
    case 2:
    }
    paraml.c();
  }

  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.contacts.m
 * JD-Core Version:    0.6.2
 */