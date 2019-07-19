package com.viber.voip.messages.conversation.ui.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.viber.voip.block.g.a;
import com.viber.voip.gallery.GalleryItem;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity;
import com.viber.voip.messages.ui.media.SendMediaDataContainer;
import com.viber.voip.mvp.core.j;
import java.util.ArrayList;
import java.util.List;

public abstract interface o extends j
{
  public abstract void a();

  public abstract void a(long paramLong1, long paramLong2, String paramString, int paramInt1, int paramInt2);

  public abstract void a(Intent paramIntent, Uri paramUri, ConversationData paramConversationData, boolean paramBoolean, Bundle paramBundle);

  public abstract void a(Uri paramUri);

  public abstract void a(Uri paramUri, Bundle paramBundle, boolean paramBoolean, int paramInt);

  public abstract void a(Member paramMember, g.a parama);

  public abstract void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity);

  public abstract void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString1, ChatExtensionLoaderEntity paramChatExtensionLoaderEntity, String paramString2);

  public abstract void a(ConversationData paramConversationData);

  public abstract void a(ConversationData paramConversationData, ArrayList<GalleryItem> paramArrayList, Bundle paramBundle);

  public abstract void a(List<SendMediaDataContainer> paramList, Bundle paramBundle);

  public abstract void a(boolean paramBoolean);

  public abstract void a(boolean paramBoolean, long paramLong);

  public abstract void a(boolean paramBoolean, ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString1, ChatExtensionLoaderEntity paramChatExtensionLoaderEntity, String paramString2);

  public abstract void b();

  public abstract void b(boolean paramBoolean);

  public abstract void c();

  public abstract void c(boolean paramBoolean);

  public abstract void d();

  public abstract void d(boolean paramBoolean);

  public abstract void e();

  public abstract void f();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.o
 * JD-Core Version:    0.6.2
 */