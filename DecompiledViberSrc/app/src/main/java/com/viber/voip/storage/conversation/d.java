package com.viber.voip.storage.conversation;

import com.viber.voip.mvp.core.j;
import com.viber.voip.storage.model.ConversationWithMediaSizesEntity;
import com.viber.voip.storage.repository.MediaFileType;
import java.util.Set;

abstract interface d extends j
{
  public abstract void a();

  public abstract void a(int paramInt);

  public abstract void a(long paramLong, Set<MediaFileType> paramSet);

  public abstract void a(ManageConversationStorageDeletionErrorData paramManageConversationStorageDeletionErrorData);

  public abstract void a(ConversationWithMediaSizesEntity paramConversationWithMediaSizesEntity);

  public abstract void a(Set<MediaFileType> paramSet);

  public abstract void b();

  public abstract void c();

  public abstract void d();

  public abstract void e();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.conversation.d
 * JD-Core Version:    0.6.2
 */