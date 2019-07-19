package com.viber.voip.messages.extensions.ui.details;

import android.arch.lifecycle.h;
import android.text.TextUtils;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.a;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.b;
import com.viber.voip.messages.MessageEditText.a;
import com.viber.voip.messages.controller.bv.a;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.controller.publicaccount.BotReplyRequest;
import com.viber.voip.messages.controller.publicaccount.b;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.extensions.a.a;
import com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.util.ae;
import com.viber.voip.util.cj;

public class ChatExtensionDetailsPresenter extends BaseMvpPresenter<a, ChatExtensionDetailsState>
{
  private final ChatExtensionDetailsData a;
  private final b b;
  private final com.viber.voip.messages.extensions.a c;
  private final com.viber.voip.messages.controller.publicaccount.d d;
  private final com.viber.voip.app.c e;
  private final o f;
  private final com.viber.voip.analytics.story.c.c g;
  private final com.viber.common.b.d h;
  private String i;
  private String j;
  private final bv.a k = new bv.a()
  {
    public void a(String paramAnonymousString)
    {
    }

    public void a(String paramAnonymousString, BotReplyConfig paramAnonymousBotReplyConfig)
    {
      ChatExtensionDetailsPresenter.a(ChatExtensionDetailsPresenter.this, paramAnonymousString, paramAnonymousBotReplyConfig);
    }

    public void a(String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean)
    {
    }
  };

  public ChatExtensionDetailsPresenter(ChatExtensionDetailsData paramChatExtensionDetailsData, b paramb, com.viber.voip.messages.extensions.a parama, com.viber.voip.messages.controller.publicaccount.d paramd, com.viber.voip.app.c paramc, o paramo, com.viber.voip.analytics.story.c.c paramc1, com.viber.common.b.d paramd1)
  {
    this.a = paramChatExtensionDetailsData;
    this.b = paramb;
    this.c = parama;
    this.d = paramd;
    this.e = paramc;
    this.f = paramo;
    this.g = paramc1;
    this.h = paramd1;
  }

  private void a(String paramString, BotReplyConfig paramBotReplyConfig)
  {
    ChatExtensionLoaderEntity localChatExtensionLoaderEntity = this.a.chatExtension;
    com.viber.voip.messages.extensions.a locala;
    long l;
    String str1;
    String str2;
    if (localChatExtensionLoaderEntity.getPublicAccountId().equals(paramString))
    {
      ConversationItemLoaderEntity localConversationItemLoaderEntity = this.a.conversation;
      locala = this.c;
      l = localConversationItemLoaderEntity.getId();
      str1 = localChatExtensionLoaderEntity.getUri();
      str2 = this.j;
      if ((!TextUtils.isEmpty(this.i)) || (TextUtils.isEmpty(this.j)))
        break label91;
    }
    label91: for (boolean bool = true; ; bool = false)
    {
      locala.a(l, str1, str2, bool, paramBotReplyConfig);
      return;
    }
  }

  private BotReplyRequest b(String paramString, BotReplyConfig paramBotReplyConfig, ReplyButton paramReplyButton)
  {
    ChatExtensionLoaderEntity localChatExtensionLoaderEntity = this.a.chatExtension;
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.a.conversation;
    boolean bool1 = localChatExtensionLoaderEntity.canAddToRecentsOnTap();
    long l1 = localConversationItemLoaderEntity.getGroupId();
    long l2 = localConversationItemLoaderEntity.getId();
    int m = localConversationItemLoaderEntity.getConversationType();
    boolean bool2 = localConversationItemLoaderEntity.isOneToOneWithPublicAccount();
    boolean bool3 = localConversationItemLoaderEntity.isSystemConversation();
    if (!localConversationItemLoaderEntity.canSendMessages(0));
    for (boolean bool4 = true; ; bool4 = false)
      return new BotReplyRequest(paramString, paramBotReplyConfig, paramReplyButton, bool1, l1, l2, m, bool2, bool3, bool4, localConversationItemLoaderEntity.getParticipantMemberId(), localConversationItemLoaderEntity.isHiddenConversation(), 1);
  }

  private void b(ChatExtensionDetailsState paramChatExtensionDetailsState)
  {
    String str = c(paramChatExtensionDetailsState);
    ChatExtensionLoaderEntity localChatExtensionLoaderEntity = this.a.chatExtension;
    ((a)this.mView).b(localChatExtensionLoaderEntity.isInputSupported());
    if (localChatExtensionLoaderEntity.isInputSupported())
      if (!localChatExtensionLoaderEntity.isSearchSupported())
        break label87;
    label87: for (MessageEditText.a locala = MessageEditText.a.d; ; locala = MessageEditText.a.e)
    {
      ((a)this.mView).a(new i(str, localChatExtensionLoaderEntity.getSearchHint(), locala, localChatExtensionLoaderEntity.isSearchSupported()), this.e.a());
      return;
    }
  }

  private String c(ChatExtensionDetailsState paramChatExtensionDetailsState)
  {
    boolean bool = this.a.silentQuery;
    String str4;
    String str1;
    label38: String str2;
    if (paramChatExtensionDetailsState != null)
      if ((TextUtils.isEmpty(paramChatExtensionDetailsState.getVisibleSearchQuery())) && (bool))
      {
        str4 = this.a.searchQuery;
        str1 = str4;
        if ((paramChatExtensionDetailsState == null) || (TextUtils.isEmpty(paramChatExtensionDetailsState.getSearchQuery())))
          break label170;
        str2 = paramChatExtensionDetailsState.getSearchQuery();
      }
    while (true)
    {
      label58: String str3;
      if ("Url Scheme".equals(this.a.entryPoint))
        str3 = "Url Scheme";
      while (true)
        if (!this.a.resetCache)
        {
          a.a locala = e();
          if (locala != null)
          {
            this.j = locala.b;
            if (!locala.c)
              str1 = this.j;
            this.f.a(this.a.chatExtension.getPublicAccountId(), locala.d);
            return str1;
            str4 = paramChatExtensionDetailsState.getVisibleSearchQuery();
            break;
            str1 = null;
            if (bool)
              break label38;
            str1 = this.a.searchQuery;
            break label38;
            label170: if ((!TextUtils.isEmpty(str1)) || (!bool))
              break label220;
            str2 = this.a.searchQuery;
            break label58;
            str3 = "Keyboard";
            continue;
          }
          a(str2, str3);
          return str1;
        }
      a(str2, str3);
      return str1;
      label220: str2 = str1;
    }
  }

  private void c()
  {
    ChatExtensionLoaderEntity localChatExtensionLoaderEntity = this.a.chatExtension;
    ((a)this.mView).a(localChatExtensionLoaderEntity.getName(), localChatExtensionLoaderEntity.getIcon());
  }

  private void d()
  {
    this.b.a(this.a.conversation);
    ((a)this.mView).a(this.a.chatExtension.getPublicAccountId());
  }

  private a.a e()
  {
    a.a locala = this.c.a(this.a.conversation.getId());
    String str = this.a.chatExtension.getUri();
    if ((locala != null) && (locala.a.equals(str)))
      return locala;
    return null;
  }

  protected ChatExtensionDetailsState a()
  {
    return new ChatExtensionDetailsState.a().a(this.j).b(this.i).a();
  }

  public void a(BotReplyRequest paramBotReplyRequest, double paramDouble1, double paramDouble2, String paramString)
  {
    this.d.a(paramBotReplyRequest, paramDouble1, paramDouble2, paramString);
  }

  protected void a(ChatExtensionDetailsState paramChatExtensionDetailsState)
  {
    super.onViewAttached(paramChatExtensionDetailsState);
    c();
    d();
    b(paramChatExtensionDetailsState);
  }

  public void a(String paramString)
  {
    if (((this.i == null) && (paramString == null)) || ((this.i != null) && (this.i.equals(paramString))))
      return;
    this.i = paramString;
    a locala = (a)this.mView;
    if ((paramString != null) && (paramString.length() > 0));
    for (boolean bool = true; ; bool = false)
    {
      locala.a(bool);
      return;
    }
  }

  public void a(String paramString, BotReplyConfig paramBotReplyConfig, ReplyButton paramReplyButton)
  {
    if (!cj.a(true));
    BotReplyRequest localBotReplyRequest;
    do
    {
      return;
      localBotReplyRequest = b(paramString, paramBotReplyConfig, paramReplyButton);
      switch (2.a[paramReplyButton.getActionType().ordinal()])
      {
      default:
        MsgInfo localMsgInfo = new MsgInfo();
        localMsgInfo.setTitle(this.a.conversation.getGroupName());
        this.d.a(localBotReplyRequest, localMsgInfo);
      case 1:
      case 2:
      case 3:
      case 4:
      }
    }
    while ((paramReplyButton.getActionType() != ReplyButton.a.REPLY) || (paramReplyButton.getReplyType() != ReplyButton.b.MESSAGE));
    this.d.d(paramString);
    ((a)this.mView).a();
    return;
    ((a)this.mView).a(localBotReplyRequest);
    return;
    ((a)this.mView).a(this.a.chatExtension.getName(), localBotReplyRequest);
    return;
    ((a)this.mView).a(paramReplyButton.getMap());
    return;
    this.d.a(localBotReplyRequest);
  }

  public void a(String paramString1, String paramString2)
  {
    if (!cj.a(true));
    ChatExtensionLoaderEntity localChatExtensionLoaderEntity;
    do
    {
      return;
      this.j = paramString1;
      localChatExtensionLoaderEntity = this.a.chatExtension;
      String str = localChatExtensionLoaderEntity.getPublicAccountId();
      this.d.d(str);
      this.b.a(str, paramString1);
    }
    while (TextUtils.isEmpty(paramString1));
    this.g.b(paramString2, localChatExtensionLoaderEntity.getUri(), ae.b());
  }

  public void b()
  {
    int m = this.h.d();
    if (m < 3)
    {
      this.h.a(m + 1);
      ((a)this.mView).b();
    }
  }

  public void onDestroy(h paramh)
  {
    this.b.a(null);
    this.d.d(this.a.chatExtension.getPublicAccountId());
    super.onDestroy(paramh);
  }

  public void onStart(h paramh)
  {
    super.onStart(paramh);
    this.f.a(this.k);
    this.b.a();
  }

  public void onStop(h paramh)
  {
    this.f.b(this.k);
    this.b.b();
    super.onStop(paramh);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.ui.details.ChatExtensionDetailsPresenter
 * JD-Core Version:    0.6.2
 */