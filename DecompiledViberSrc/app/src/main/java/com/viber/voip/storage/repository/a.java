package com.viber.voip.storage.repository;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.storage.model.ConversationWithMediaSizesEntity;
import java.util.ArrayList;
import java.util.Iterator;

class a extends com.viber.voip.util.r
{
  private static final Logger a = ViberEnv.getLogger();
  private final r b;
  private final ArrayList<ConversationWithMediaSizesEntity> c;
  private final a d;

  a(r paramr, ArrayList<ConversationWithMediaSizesEntity> paramArrayList, a parama)
  {
    this.b = paramr;
    this.c = paramArrayList;
    this.d = parama;
  }

  public void a()
  {
    super.a();
  }

  public void run()
  {
    Iterator localIterator = this.c.iterator();
    while (true)
    {
      ConversationWithMediaSizesEntity localConversationWithMediaSizesEntity2;
      if (localIterator.hasNext())
      {
        ConversationWithMediaSizesEntity localConversationWithMediaSizesEntity1 = (ConversationWithMediaSizesEntity)localIterator.next();
        localConversationWithMediaSizesEntity2 = new ConversationWithMediaSizesEntity(localConversationWithMediaSizesEntity1, this.b.a(localConversationWithMediaSizesEntity1.getId()));
        if (!c());
      }
      else
      {
        if (!c())
          this.d.a();
        return;
      }
      this.d.a(localConversationWithMediaSizesEntity2);
    }
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(ConversationWithMediaSizesEntity paramConversationWithMediaSizesEntity);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.repository.a
 * JD-Core Version:    0.6.2
 */