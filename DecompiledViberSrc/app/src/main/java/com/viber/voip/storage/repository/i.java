package com.viber.voip.storage.repository;

import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.storage.model.ConversationWithMediaSizesEntity;
import java.util.ArrayList;

public abstract interface i
{
  public abstract void a(MessageEntity paramMessageEntity);

  public abstract void a(ArrayList<ConversationWithMediaSizesEntity> paramArrayList);

  public abstract void b(MessageEntity paramMessageEntity);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.repository.i
 * JD-Core Version:    0.6.2
 */