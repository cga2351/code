package com.viber.voip.storage.manage;

import com.viber.voip.mvp.core.j;
import com.viber.voip.storage.model.ConversationWithMediaSizesEntity;
import java.util.ArrayList;

abstract interface i extends j
{
  public abstract void a();

  public abstract void a(ConversationWithMediaSizesEntity paramConversationWithMediaSizesEntity);

  public abstract void a(String paramString);

  public abstract void a(ArrayList<ConversationWithMediaSizesEntity> paramArrayList);

  public abstract void b();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.manage.i
 * JD-Core Version:    0.6.2
 */