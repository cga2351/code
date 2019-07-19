package com.viber.voip.analytics.story.e;

import android.net.Uri;
import android.text.SpannableString;
import com.viber.voip.messages.controller.manager.BotFavoriteLinksCommunicator.SaveLinkActionMessage;
import com.viber.voip.messages.controller.publicaccount.BotReplyRequest;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.stickers.entity.Sticker;
import java.util.Locale;

public abstract interface c
{
  public abstract void a();

  public abstract void a(int paramInt1, int paramInt2);

  public abstract void a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, boolean paramBoolean);

  public abstract void a(int paramInt, Uri paramUri);

  public abstract void a(int paramInt, ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean);

  public abstract void a(int paramInt, h paramh);

  public abstract void a(int paramInt, String paramString);

  public abstract void a(int paramInt, String paramString1, String paramString2);

  public abstract void a(int paramInt, String paramString, boolean paramBoolean);

  public abstract void a(long paramLong, int paramInt);

  public abstract void a(long paramLong, String paramString);

  public abstract void a(BotFavoriteLinksCommunicator.SaveLinkActionMessage paramSaveLinkActionMessage);

  public abstract void a(BotReplyRequest paramBotReplyRequest, boolean paramBoolean);

  public abstract void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity);

  public abstract void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, int paramInt1, int paramInt2, String paramString);

  public abstract void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, aa paramaa);

  public abstract void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString);

  public abstract void a(ConversationLoaderEntity paramConversationLoaderEntity);

  public abstract void a(Sticker paramSticker);

  public abstract void a(String paramString);

  public abstract void a(String paramString, ConversationItemLoaderEntity paramConversationItemLoaderEntity);

  public abstract void a(String paramString1, ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString2);

  public abstract void a(String paramString1, ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString2, boolean paramBoolean);

  public abstract void a(String paramString, ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean);

  public abstract void a(String paramString1, ConversationLoaderEntity paramConversationLoaderEntity, String paramString2, boolean paramBoolean);

  public abstract void a(String paramString, ConversationLoaderEntity paramConversationLoaderEntity, boolean paramBoolean);

  public abstract void a(String paramString, MessageEntity paramMessageEntity, h paramh, Locale paramLocale, SpannableString paramSpannableString, boolean paramBoolean1, boolean paramBoolean2);

  public abstract void a(String paramString, MessageEntity paramMessageEntity, Locale paramLocale, SpannableString paramSpannableString, boolean paramBoolean);

  public abstract void a(String paramString1, h paramh, String paramString2);

  public abstract void a(String paramString1, String paramString2);

  public abstract void a(String paramString1, String paramString2, int paramInt);

  public abstract void a(String paramString1, String paramString2, String paramString3);

  public abstract void a(String paramString1, String paramString2, String paramString3, Integer paramInteger);

  public abstract void a(String paramString1, boolean paramBoolean, String paramString2);

  public abstract void a(boolean paramBoolean);

  public abstract void b();

  public abstract void b(long paramLong, int paramInt);

  public abstract void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString);

  public abstract void b(String paramString);

  public abstract void b(String paramString, ConversationItemLoaderEntity paramConversationItemLoaderEntity);

  public abstract void b(String paramString1, h paramh, String paramString2);

  public abstract void b(String paramString1, String paramString2);

  public abstract void b(String paramString1, String paramString2, String paramString3);

  public abstract void c();

  public abstract void c(String paramString);

  public abstract void d();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.e.c
 * JD-Core Version:    0.6.2
 */