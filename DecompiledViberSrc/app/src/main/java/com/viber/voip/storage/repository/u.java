package com.viber.voip.storage.repository;

import com.google.d.f;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.controller.manager.z;
import com.viber.voip.storage.model.ConversationWithMediaSizesEntity;
import dagger.a;
import java.util.Collections;

public class u
{
  private final z a;
  private final a<o> b;
  private final f c;

  public u(z paramz, a<o> parama, f paramf)
  {
    this.a = paramz;
    this.b = parama;
    this.c = paramf;
  }

  public void a(ConversationWithMediaSizesEntity paramConversationWithMediaSizesEntity)
  {
    a(paramConversationWithMediaSizesEntity, false);
  }

  public void a(ConversationWithMediaSizesEntity paramConversationWithMediaSizesEntity, boolean paramBoolean)
  {
    this.a.b(paramConversationWithMediaSizesEntity.getId(), this.c.b(paramConversationWithMediaSizesEntity.getMediaSize()));
    if (paramBoolean)
      ((o)this.b.get()).a(Collections.singleton(Long.valueOf(paramConversationWithMediaSizesEntity.getId())), paramConversationWithMediaSizesEntity.getConversationType(), false, true);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.repository.u
 * JD-Core Version:    0.6.2
 */