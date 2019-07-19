package com.viber.voip.storage.manage;

import android.content.Context;
import com.viber.voip.storage.model.ConversationWithMediaSizesEntity;
import com.viber.voip.util.ViberActionRunner.ay;

class h
{
  private final Context a;
  private final int b;

  h(Context paramContext, int paramInt)
  {
    this.a = paramContext;
    this.b = paramInt;
  }

  void a(ConversationWithMediaSizesEntity paramConversationWithMediaSizesEntity)
  {
    ViberActionRunner.ay.a(this.a, paramConversationWithMediaSizesEntity.getId(), this.b);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.manage.h
 * JD-Core Version:    0.6.2
 */