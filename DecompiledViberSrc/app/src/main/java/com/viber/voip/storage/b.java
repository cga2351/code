package com.viber.voip.storage;

import com.viber.voip.messages.adapters.a.c.a;
import com.viber.voip.messages.conversation.RegularConversationLoaderEntity;
import com.viber.voip.util.da;

public class b<T extends RegularConversationLoaderEntity>
{
  private final a a;

  public b(a parama)
  {
    this.a = parama;
  }

  public String a(T paramT)
  {
    if (paramT.isGroupBehavior())
    {
      if (da.a(paramT.getGroupName()))
      {
        if (paramT.isBroadcastListType())
          return this.a.u();
        return this.a.t();
      }
      return paramT.getGroupName();
    }
    return paramT.getParticipantName();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.b
 * JD-Core Version:    0.6.2
 */