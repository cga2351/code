package com.viber.voip.messages.conversation.ui.spam;

import android.os.Parcelable;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.adapter.x;
import com.viber.voip.model.entity.m;

public abstract interface a extends x
{
  public abstract void a();

  public abstract void a(Parcelable paramParcelable);

  public abstract void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, m paramm);

  public abstract void b();

  public abstract Parcelable c();

  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.spam.a
 * JD-Core Version:    0.6.2
 */