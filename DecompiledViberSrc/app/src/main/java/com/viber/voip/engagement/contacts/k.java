package com.viber.voip.engagement.contacts;

import android.view.ContextMenu;
import com.viber.voip.contacts.b.a;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.messages.conversation.RegularConversationLoaderEntity;
import com.viber.voip.model.a;
import java.util.List;

abstract interface k
{
  public abstract void a();

  public abstract void a(ContextMenu paramContextMenu, String paramString, int paramInt, boolean paramBoolean);

  public abstract void a(b.a parama1, SendButtonReceiverId[] paramArrayOfSendButtonReceiverId, b.a parama2);

  public abstract void a(SendButtonReceiverId paramSendButtonReceiverId);

  public abstract void a(SendButtonReceiverId paramSendButtonReceiverId, List<ParticipantSelector.Participant> paramList, boolean paramBoolean);

  public abstract void a(String paramString);

  public abstract void a(List<a> paramList);

  public abstract void a(boolean paramBoolean);

  public abstract void b();

  public abstract void b(List<RegularConversationLoaderEntity> paramList);

  public abstract void b(boolean paramBoolean);

  public abstract void c();

  public abstract void d();

  public abstract void f();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.contacts.k
 * JD-Core Version:    0.6.2
 */