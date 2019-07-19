package com.viber.voip.storage.repository;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.orm.entity.impl.MessageEntityHelper;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.storage.model.ConversationMediaSize;
import com.viber.voip.storage.model.ConversationMediaSize.a;
import java.util.Iterator;

public class r
{
  private static final Logger a = ViberEnv.getLogger();
  private final int[] b;
  private final t c;
  private final o d;

  public r(t paramt, o paramo)
  {
    this.c = paramt;
    this.d = paramo;
    this.b = MediaFileType.getAssociatedMessagesMimeTypes(MediaFileType.values());
  }

  public ConversationMediaSize a(long paramLong)
  {
    n localn1 = new n();
    MessageEntity localMessageEntity = new MessageEntity();
    n localn2 = new n();
    this.c.a(paramLong, this.b, MessageEntityHelper.PROJECTIONS, new s(this, localn2, localMessageEntity, localn1));
    ConversationMediaSize.a locala = new ConversationMediaSize.a();
    Iterator localIterator = localn1.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      locala.a(localm.a(), localm.b());
    }
    return locala.a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.repository.r
 * JD-Core Version:    0.6.2
 */