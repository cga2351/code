package com.viber.voip.messages.conversation.ui.view;

import android.net.Uri;
import com.viber.common.permission.c;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.flatbuffers.model.msginfo.GroupReferralInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.publicaccount.BotReplyRequest;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity;
import com.viber.voip.messages.orm.entity.json.action.MessageOpenUrlAction;
import com.viber.voip.messages.shopchat.OpenShopChatPanelData;
import com.viber.voip.model.entity.MessageCallEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.ui.dialogs.e.b;
import com.viber.voip.util.ag;
import java.util.List;

public abstract interface j extends com.viber.voip.mvp.core.j
{
  public abstract void a();

  public abstract void a(int paramInt);

  public abstract void a(int paramInt1, int paramInt2, String paramString1, String paramString2);

  public abstract void a(Uri paramUri);

  public abstract void a(c paramc, int paramInt, String[] paramArrayOfString);

  public abstract void a(c paramc, int paramInt, String[] paramArrayOfString, long paramLong, String paramString, boolean paramBoolean);

  public abstract void a(c paramc, int paramInt, String[] paramArrayOfString, Object paramObject);

  public abstract void a(ConferenceInfo paramConferenceInfo, long paramLong, boolean paramBoolean);

  public abstract void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, long paramLong, int paramInt);

  public abstract void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean, long paramLong);

  public abstract void a(aa paramaa, String paramString);

  public abstract void a(aa paramaa, List<MessageCallEntity> paramList, boolean paramBoolean);

  public abstract void a(MessageOpenUrlAction paramMessageOpenUrlAction);

  public abstract void a(OpenShopChatPanelData paramOpenShopChatPanelData);

  public abstract void a(h paramh);

  public abstract void a(h paramh, long paramLong1, long paramLong2);

  public abstract void a(e.b paramb);

  public abstract void a(String paramString);

  public abstract void a(String paramString, Uri paramUri);

  public abstract void a(String paramString, GroupReferralInfo paramGroupReferralInfo);

  public abstract void a(String paramString, BotReplyConfig paramBotReplyConfig, ReplyButton paramReplyButton, boolean paramBoolean, int paramInt);

  public abstract void a(String paramString1, BotReplyConfig paramBotReplyConfig, BotReplyRequest paramBotReplyRequest, ChatExtensionLoaderEntity paramChatExtensionLoaderEntity, ReplyButton paramReplyButton, String paramString2, String paramString3, boolean paramBoolean, int paramInt);

  public abstract void a(String paramString1, String paramString2, boolean paramBoolean);

  public abstract void a(boolean paramBoolean);

  public abstract void a(boolean paramBoolean1, Member paramMember, MessageOpenUrlAction paramMessageOpenUrlAction, boolean paramBoolean2);

  public abstract void a(boolean paramBoolean, MessageOpenUrlAction paramMessageOpenUrlAction);

  public abstract void b();

  public abstract void b(int paramInt);

  public abstract void b(long paramLong);

  public abstract void b(aa paramaa, boolean paramBoolean);

  public abstract void b(e.b paramb);

  public abstract void b(String paramString);

  public abstract void c();

  public abstract void c(int paramInt);

  public abstract void c(long paramLong);

  public abstract void d();

  public abstract void e();

  public abstract void f();

  public abstract void g();

  public abstract void h();

  @ag
  public abstract boolean i();

  public abstract void j();

  public abstract void n(aa paramaa);

  public abstract void o(aa paramaa);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.j
 * JD-Core Version:    0.6.2
 */