package com.viber.voip.analytics.story.e;

import android.net.Uri;
import android.support.v4.util.ArrayMap;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.StoryConstants.f.a;
import com.viber.voip.analytics.story.StoryConstants.g.a;
import com.viber.voip.analytics.story.StoryConstants.m.a;
import com.viber.voip.analytics.story.StoryConstants.n.a;
import com.viber.voip.analytics.story.StoryConstants.p.a;
import com.viber.voip.analytics.story.StoryConstants.q.a;
import com.viber.voip.analytics.story.StoryConstants.r.a;
import com.viber.voip.analytics.story.StoryConstants.w.a;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.Poll;
import com.viber.voip.flatbuffers.model.msginfo.PollUiOptions;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.PublicAccountMsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.a;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.c;
import com.viber.voip.messages.controller.manager.BotFavoriteLinksCommunicator.SaveLinkActionMessage;
import com.viber.voip.messages.controller.publicaccount.BotReplyRequest;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.model.a.d;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.settings.d.r;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.ui.style.InternalURLSpan;
import com.viber.voip.util.ae;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;
import com.viber.voip.util.upload.ObjectId;
import java.util.Locale;

public class e
  implements c
{
  private static final Logger a = ViberEnv.getLogger();
  private final com.viber.voip.analytics.g b;

  public e(com.viber.voip.analytics.g paramg)
  {
    this.b = paramg;
  }

  private int a(MessageEntity paramMessageEntity, i parami)
  {
    if (paramMessageEntity.isConversation1on1())
      return 2;
    if (parami != null)
      return parami.f;
    return 0;
  }

  private f a(MessageEntity paramMessageEntity, SpannableString paramSpannableString, boolean paramBoolean)
  {
    boolean bool1 = true;
    if (paramBoolean);
    for (StringBuilder localStringBuilder = new StringBuilder(); ; localStringBuilder = null)
    {
      if (paramMessageEntity.isUrlMessage());
      for (boolean bool2 = bool1; ; bool2 = false)
      {
        boolean bool3 = false;
        int j;
        Object localObject;
        if (paramSpannableString != null)
          if (bool2)
          {
            bool3 = false;
            if (!paramBoolean);
          }
          else
          {
            Object[] arrayOfObject = paramSpannableString.getSpans(0, -1 + paramSpannableString.length(), Object.class);
            int i = arrayOfObject.length;
            j = 0;
            if (j < i)
            {
              localObject = arrayOfObject[j];
              if ((localObject instanceof InternalURLSpan))
                if (paramBoolean)
                  break label203;
            }
          }
        while (true)
        {
          String str;
          label104: boolean bool4;
          boolean bool5;
          if (localStringBuilder == null)
          {
            str = "";
            return new f(bool3, str, bool1);
            if ((!paramBoolean) || (!(localObject instanceof ImageSpan)))
              break label192;
            if (localStringBuilder.length() != 0)
              localStringBuilder.append(',');
            localStringBuilder.append(((ImageSpan)localObject).getSource());
            bool4 = bool1;
            bool5 = bool2;
          }
          while (true)
          {
            j++;
            bool2 = bool5;
            bool3 = bool4;
            break;
            str = localStringBuilder.toString();
            break label104;
            label192: bool4 = bool3;
            bool5 = bool2;
            continue;
            label203: bool4 = bool3;
            bool5 = bool1;
          }
          bool1 = bool2;
        }
      }
    }
  }

  private String a(MessageEntity paramMessageEntity)
  {
    if ((paramMessageEntity.isConversation1on1()) || (paramMessageEntity.isBroadcastList()))
      return "";
    return String.valueOf(paramMessageEntity.getGroupId());
  }

  private String a(MessageEntity paramMessageEntity, com.viber.voip.model.entity.h paramh)
  {
    String str = "";
    if ((paramMessageEntity.isGroupBehavior()) && (paramh != null))
      if (paramh.h())
        str = dg.c(paramh.o());
    while (!paramMessageEntity.isConversation1on1())
    {
      return str;
      return dg.b(paramh.o());
    }
    return "1on1 chat";
  }

  private String a(com.viber.voip.model.entity.h paramh)
  {
    if ((paramh.a()) || (paramh.h()))
      return "";
    return String.valueOf(paramh.k());
  }

  private void a(int paramInt, com.viber.voip.util.d.b<i, i> paramb)
  {
    String str = "message_key_" + paramInt;
    this.b.a(str, new v(paramInt, paramb));
  }

  private void a(long paramLong, com.viber.voip.util.d.b<a, a> paramb)
  {
    this.b.a("add_participant_key", new u(paramLong, paramb));
  }

  private void a(ArrayMap<com.viber.voip.analytics.story.f, com.viber.voip.analytics.e.g> paramArrayMap, com.viber.voip.model.entity.h paramh, boolean paramBoolean)
  {
    if (paramh.g())
      a.a(paramArrayMap);
    while (true)
    {
      if (paramh.R())
      {
        a.d(paramArrayMap);
        if (paramh.a())
          a.e(paramArrayMap);
      }
      if (paramBoolean)
        a.f(paramArrayMap);
      return;
      if (paramh.d())
        a.b(paramArrayMap);
      else if (paramh.c())
        a.c(paramArrayMap);
      else if (paramh.a())
        a.g(paramArrayMap);
    }
  }

  private void a(com.viber.voip.util.d.b<g, g> paramb)
  {
    this.b.a("share_community_link_key", new l(paramb));
  }

  private void a(String paramString, com.viber.voip.util.d.b<c, c> paramb)
  {
    this.b.a("create_chat_key", new j(paramString, paramb));
  }

  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.b.a(b.d(paramString2, paramString3, da.h(paramString4)));
    this.b.a(a.e(paramString1));
  }

  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.b.a(b.a(paramString2, paramString3, paramString4, paramString5));
    this.b.a(a.h(paramString1));
  }

  private boolean a(MessageEntity paramMessageEntity, e parame)
  {
    return (paramMessageEntity.isLocationMessage()) || (paramMessageEntity.getLat() > 0) || (paramMessageEntity.getLng() > 0) || ((parame != null) && (parame.a));
  }

  private boolean a(MessageEntity paramMessageEntity, boolean paramBoolean)
  {
    return (paramMessageEntity.isImage()) || (paramMessageEntity.isVideo()) || (paramBoolean) || (paramMessageEntity.isVoiceMessage()) || (paramMessageEntity.isVideoPttBehavior()) || (paramMessageEntity.isFile());
  }

  private e b(MessageEntity paramMessageEntity)
  {
    boolean bool1 = false;
    if (!paramMessageEntity.isRichMessage())
      return null;
    ReplyButton[] arrayOfReplyButton = paramMessageEntity.getMessageInfo().getPublicAccountMsgInfo().getRichMedia().getButtons();
    int i = arrayOfReplyButton.length;
    int j = 0;
    boolean bool2 = false;
    while (true)
    {
      if (j < i)
      {
        ReplyButton localReplyButton = arrayOfReplyButton[j];
        if ((!bool2) && (ReplyButton.a.OPEN_MAP == localReplyButton.getActionType()))
          bool2 = true;
        if ((!bool1) && (ReplyButton.c.GIF.equals(localReplyButton.getBgMediaType())))
          bool1 = true;
        if ((!bool2) || (!bool1));
      }
      else
      {
        return new e(bool2, bool1);
      }
      j++;
    }
  }

  private String b(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if ((paramConversationItemLoaderEntity.isConversation1on1()) || (paramConversationItemLoaderEntity.isBroadcastListType()))
      return "";
    return String.valueOf(paramConversationItemLoaderEntity.getGroupId());
  }

  private String b(ConversationLoaderEntity paramConversationLoaderEntity)
  {
    if ((paramConversationLoaderEntity.isConversation1on1()) || (paramConversationLoaderEntity.isBroadcastListType()))
      return "";
    return String.valueOf(paramConversationLoaderEntity.getGroupId());
  }

  private String b(com.viber.voip.model.entity.h paramh)
  {
    if (paramh.h())
      return dg.c(paramh.o());
    if (paramh.a())
      return "1on1 chat";
    return dg.b(paramh.o());
  }

  private void b(long paramLong, com.viber.voip.util.d.b<d, d> paramb)
  {
    String str = "join_community_key_" + paramLong;
    this.b.a(str, new n(paramLong, paramb));
  }

  private void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.b.a(b.e(paramString2, paramString3, paramString4));
    this.b.a(a.f(paramString1));
  }

  private void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.b.a(b.b(paramString2, paramString3, paramString4, paramString5));
    this.b.a(a.i(paramString1));
  }

  private boolean b(MessageEntity paramMessageEntity, e parame)
  {
    return (paramMessageEntity.isGifFile()) || (paramMessageEntity.isGifUrlMessage()) || ((parame != null) && (parame.b));
  }

  private int c(MessageEntity paramMessageEntity)
  {
    boolean bool = paramMessageEntity.isPoll();
    int i = 0;
    if (bool)
    {
      Poll localPoll = paramMessageEntity.getMessageInfo().getPoll();
      i = 0;
      if (localPoll != null)
      {
        PollUiOptions[] arrayOfPollUiOptions = localPoll.getOptions();
        i = 0;
        if (arrayOfPollUiOptions != null)
          i = arrayOfPollUiOptions.length;
      }
    }
    return i;
  }

  private String c(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if (paramConversationItemLoaderEntity.isBroadcastListType())
      return dg.c(paramConversationItemLoaderEntity.getGroupName());
    if (paramConversationItemLoaderEntity.isConversation1on1())
      return "1on1 chat";
    return dg.b(paramConversationItemLoaderEntity.getGroupName());
  }

  private String c(ConversationLoaderEntity paramConversationLoaderEntity)
  {
    if (paramConversationLoaderEntity.isBroadcastListType())
      return dg.c(paramConversationLoaderEntity.getGroupName());
    if (paramConversationLoaderEntity.isConversation1on1())
      return "1on1 chat";
    return dg.b(paramConversationLoaderEntity.getGroupName());
  }

  private void c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.b.a(b.f(paramString2, paramString3, paramString4));
    this.b.a(a.g(paramString1));
  }

  private a e()
  {
    return (a)this.b.a("add_participant_key");
  }

  private c f()
  {
    return (c)this.b.a("create_chat_key");
  }

  public void a()
  {
    this.b.a(b.a());
  }

  public void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, new r(paramInt2));
  }

  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, boolean paramBoolean)
  {
    a(paramInt1, new o(paramInt2, paramInt3, paramString1, paramString2, paramBoolean));
  }

  public void a(int paramInt, Uri paramUri)
  {
    a(paramInt, new s(com.viber.voip.analytics.story.n.a(paramUri)));
  }

  public void a(int paramInt, ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    g localg = (g)this.b.b("share_community_link_key");
    if (localg != null)
      if (paramConversationItemLoaderEntity == null)
        break label60;
    label60: for (String str = StoryConstants.g.a.a(paramConversationItemLoaderEntity); ; str = "")
    {
      this.b.b("add_participant_key");
      this.b.a(b.a(paramInt, localg.a, str, paramBoolean));
      return;
    }
  }

  public void a(int paramInt, com.viber.voip.model.entity.h paramh)
  {
    a(paramInt, new t(paramh));
  }

  public void a(int paramInt, String paramString)
  {
    a(paramInt, new g(paramString));
  }

  public void a(int paramInt, String paramString1, String paramString2)
  {
    a(paramInt, new p(paramString1, paramString2));
  }

  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    a(paramInt, new q(paramString, paramBoolean));
  }

  public void a(long paramLong, int paramInt)
  {
    a locala = e();
    if ((locala != null) && (paramLong == locala.e))
    {
      this.b.b("add_participant_key");
      this.b.a(b.a(locala.b, locala.c, locala.a, locala.d, paramInt));
    }
  }

  public void a(long paramLong, String paramString)
  {
    b(paramLong, new m(paramString, paramLong));
  }

  public void a(BotFavoriteLinksCommunicator.SaveLinkActionMessage paramSaveLinkActionMessage)
  {
    d locald = com.viber.voip.model.a.b.c();
    if (locald.h("is_first_time_save_to_favorites_key") == null);
    for (boolean bool = true; ; bool = false)
    {
      locald.b("is_first_time_save_to_favorites_key", false);
      this.b.a(b.a(da.h(paramSaveLinkActionMessage.getDomainUrl()), paramSaveLinkActionMessage.getAnalyticsOrigin(), da.h(paramSaveLinkActionMessage.getAnalyticsChatType()), bool, paramSaveLinkActionMessage.isFromTooltip()));
      this.b.a(a.k(ae.b()));
      return;
    }
  }

  public void a(BotReplyRequest paramBotReplyRequest, boolean paramBoolean)
  {
    String str1;
    if (paramBotReplyRequest.replyButton.getActionType().equals(ReplyButton.a.OPEN_URL))
    {
      str1 = StoryConstants.g.a.a(paramBotReplyRequest, paramBoolean);
      if (paramBotReplyRequest.botReplyActionSource != 1)
        break label46;
    }
    label46: for (String str2 = "Chat Extension"; ; str2 = "Rich Message")
    {
      a(str1, str2, ae.b());
      return;
    }
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    String str1 = b(paramConversationItemLoaderEntity);
    String str2 = c(paramConversationItemLoaderEntity);
    String str3 = StoryConstants.g.a.a(paramConversationItemLoaderEntity);
    this.b.a(b.a("URL", str1, str2, "Open Browser", str3));
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, int paramInt1, int paramInt2, String paramString)
  {
    String str1 = b(paramConversationItemLoaderEntity);
    String str2 = c(paramConversationItemLoaderEntity);
    String str3 = StoryConstants.g.a.a(paramConversationItemLoaderEntity);
    boolean bool = paramConversationItemLoaderEntity.isGroupBehavior();
    String str4 = StoryConstants.f.a.a(paramConversationItemLoaderEntity);
    if (paramConversationItemLoaderEntity.isConversation1on1());
    for (int i = 2; ; i = paramInt1)
    {
      this.b.a(b.a(str1, str2, i, bool, str4, paramInt2, str3));
      this.b.a(a.a(str3, paramString));
      return;
    }
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, aa paramaa)
  {
    String str1 = b(paramConversationItemLoaderEntity);
    String str2 = c(paramConversationItemLoaderEntity);
    String str3 = StoryConstants.q.a.a(paramaa);
    String str4 = StoryConstants.m.a.a(paramaa);
    String str5 = StoryConstants.g.a.a(paramaa);
    this.b.a(b.a(str3, str1, str2, str4, str5));
    if (paramaa.an())
      this.b.a(a.n(ae.b()));
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString)
  {
    String str1 = c(paramConversationItemLoaderEntity);
    String str2 = b(paramConversationItemLoaderEntity);
    String str3 = StoryConstants.g.a.a(paramConversationItemLoaderEntity);
    this.b.a(b.a(str1, str2, str3));
    this.b.a(a.d(paramString));
  }

  public void a(ConversationLoaderEntity paramConversationLoaderEntity)
  {
    String str = StoryConstants.g.a.a(paramConversationLoaderEntity);
    if (("Business Message One Way".equals(str)) || ("Business Message Two Way".equals(str)))
      this.b.a(b.b(str));
  }

  public void a(Sticker paramSticker)
  {
    this.b.a(b.a(paramSticker.id, paramSticker.packageId, StoryConstants.w.a.a(paramSticker)));
  }

  public void a(String paramString)
  {
    this.b.a(b.b());
    this.b.a(a.b(paramString));
  }

  public void a(String paramString, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    String str1 = b(paramConversationItemLoaderEntity);
    String str2 = c(paramConversationItemLoaderEntity);
    this.b.a(b.b(paramString, str1, str2));
  }

  public void a(String paramString1, ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString2)
  {
    a(paramString1, b(paramConversationItemLoaderEntity), c(paramConversationItemLoaderEntity), paramString2);
  }

  public void a(String paramString1, ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramString1, b(paramConversationItemLoaderEntity), c(paramConversationItemLoaderEntity), StoryConstants.g.a.a(paramConversationItemLoaderEntity), paramString2);
      return;
    }
    b(paramString1, b(paramConversationItemLoaderEntity), c(paramConversationItemLoaderEntity), StoryConstants.g.a.a(paramConversationItemLoaderEntity), paramString2);
  }

  public void a(String paramString, ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b(paramString, b(paramConversationItemLoaderEntity), c(paramConversationItemLoaderEntity), StoryConstants.g.a.a(paramConversationItemLoaderEntity));
      return;
    }
    c(paramString, b(paramConversationItemLoaderEntity), c(paramConversationItemLoaderEntity), StoryConstants.g.a.a(paramConversationItemLoaderEntity));
  }

  public void a(String paramString1, ConversationLoaderEntity paramConversationLoaderEntity, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramString1, b(paramConversationLoaderEntity), c(paramConversationLoaderEntity), StoryConstants.g.a.a(paramConversationLoaderEntity), paramString2);
      return;
    }
    b(paramString1, b(paramConversationLoaderEntity), c(paramConversationLoaderEntity), StoryConstants.g.a.a(paramConversationLoaderEntity), paramString2);
  }

  public void a(String paramString, ConversationLoaderEntity paramConversationLoaderEntity, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b(paramString, b(paramConversationLoaderEntity), c(paramConversationLoaderEntity), StoryConstants.g.a.a(paramConversationLoaderEntity));
      return;
    }
    c(paramString, b(paramConversationLoaderEntity), c(paramConversationLoaderEntity), StoryConstants.g.a.a(paramConversationLoaderEntity));
  }

  public void a(String paramString, MessageEntity paramMessageEntity, com.viber.voip.model.entity.h paramh, Locale paramLocale, SpannableString paramSpannableString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramMessageEntity.isPollOption())
      return;
    i locali = (i)this.b.b("message_key_" + paramMessageEntity.getMessageSeq());
    int i = a(paramMessageEntity, locali);
    String str1 = a(paramMessageEntity);
    String str2 = a(paramMessageEntity, paramh);
    String str3;
    String str4;
    String str5;
    boolean bool1;
    boolean bool2;
    boolean bool4;
    e locale;
    boolean bool5;
    boolean bool6;
    boolean bool7;
    boolean bool8;
    b localb;
    label201: String str6;
    String str9;
    if (paramLocale != null)
    {
      str3 = paramLocale.getLanguage();
      str4 = StoryConstants.g.a.a(paramMessageEntity, paramBoolean2);
      str5 = StoryConstants.q.a.a(paramMessageEntity);
      bool1 = paramMessageEntity.isFormattedMessage();
      bool2 = paramMessageEntity.isSticker();
      if (!paramMessageEntity.isImage())
      {
        boolean bool10 = paramMessageEntity.isVideo();
        bool4 = false;
        if (!bool10);
      }
      else
      {
        boolean bool3 = da.a(paramMessageEntity.getDescription());
        bool4 = false;
        if (!bool3)
          bool4 = true;
      }
      locale = b(paramMessageEntity);
      bool5 = b(paramMessageEntity, locale);
      bool6 = a(paramMessageEntity, paramSpannableString, false).c;
      bool7 = a(paramMessageEntity, bool5);
      bool8 = paramMessageEntity.isShareContactMessage();
      if (locali == null)
        break label370;
      localb = locali.d;
      str6 = "";
      if (localb == null)
        break label376;
      str9 = localb.a;
      str6 = localb.b;
    }
    label370: label376: for (String str7 = str9; ; str7 = "")
    {
      boolean bool9 = a(paramMessageEntity, locale);
      String str8 = StoryConstants.f.a.a(paramh);
      int j = c(paramMessageEntity);
      this.b.a(b.a(i, bool1, str1, str2, bool2, bool4, bool7, bool5, bool6, bool8, str7, str6, bool9, str5, str4, str3, paramBoolean1, j, str8));
      ArrayMap localArrayMap = new ArrayMap(10);
      a.e(localArrayMap, paramString);
      a.f(localArrayMap, str4);
      a.h(localArrayMap, str3);
      a.g(localArrayMap, str5);
      if (paramMessageEntity.isSystemMessage())
        a.p(localArrayMap);
      this.b.a(localArrayMap);
      return;
      str3 = "";
      break;
      localb = null;
      break label201;
    }
  }

  public void a(String paramString, MessageEntity paramMessageEntity, Locale paramLocale, SpannableString paramSpannableString, boolean paramBoolean)
  {
    i locali = (i)this.b.b("message_key_" + paramMessageEntity.getMessageSeq());
    if (locali == null)
      return;
    com.viber.voip.model.entity.h localh = locali.h;
    String str1 = a(paramMessageEntity);
    String str2 = a(paramMessageEntity, localh);
    String str3;
    int i;
    boolean bool1;
    label98: String str4;
    String str5;
    String str6;
    h localh1;
    String str7;
    String str8;
    int i2;
    Object localObject1;
    boolean bool2;
    Object localObject2;
    Object localObject3;
    if (paramLocale != null)
    {
      str3 = paramLocale.getLanguage();
      i = a(paramMessageEntity, locali);
      if ((localh == null) || (!localh.ak()))
        break label740;
      bool1 = true;
      str4 = StoryConstants.g.a.a(paramMessageEntity, paramBoolean, bool1);
      str5 = StoryConstants.q.a.a(paramMessageEntity);
      str6 = locali.e;
      localh1 = locali.c;
      str7 = "";
      str8 = "";
      if (!paramMessageEntity.isSticker())
        break label916;
      i2 = paramMessageEntity.getObjectId().toStickerId();
      if (localh1 == null)
        break label916;
      if (localh1.a == i2)
        break label746;
      String str20 = str7;
      localObject1 = "";
      bool2 = false;
      localObject2 = "";
      localObject3 = str20;
    }
    while (true)
    {
      label186: b localb = locali.d;
      String str10 = "";
      String str11 = "";
      if (localb != null)
      {
        str10 = localb.a;
        str11 = localb.b;
      }
      e locale = b(paramMessageEntity);
      boolean bool3 = false;
      boolean bool4 = b(paramMessageEntity, locale);
      boolean bool5 = a(paramMessageEntity, bool4);
      f localf = a(paramMessageEntity, paramSpannableString, true);
      boolean bool6 = localf.c;
      boolean bool7 = localf.a;
      String str12 = localf.b;
      boolean bool8 = a(paramMessageEntity, locale);
      boolean bool9 = locali.i;
      boolean bool10;
      label308: String str13;
      int j;
      label343: boolean bool12;
      String str14;
      int k;
      label371: int m;
      label381: String str15;
      label393: boolean bool13;
      String str16;
      int n;
      float f;
      int i1;
      ArrayMap localArrayMap;
      if (paramMessageEntity.getMessageInfo().getGroupReferralInfo() != null)
      {
        bool10 = true;
        str13 = locali.b;
        if ((da.a(str13)) && (!"Text".equals(str5)))
          break label832;
        j = paramMessageEntity.getBody().length();
        bool12 = paramMessageEntity.isWink();
        str14 = StoryConstants.p.a.a(paramMessageEntity.getMsgInfoFileInfo().getLifeSpan());
        if (!paramMessageEntity.isVideo())
          break label891;
        k = 1;
        if (!paramMessageEntity.isImage())
          break label897;
        m = 1;
        if (localh == null)
          break label903;
        str15 = StoryConstants.f.a.a(localh);
        bool13 = paramMessageEntity.isShareContactMessage();
        str16 = StoryConstants.n.a.a(paramMessageEntity);
        if (str16 == null)
          str16 = "";
        n = Math.round((float)paramMessageEntity.getDuration() / 1000.0F);
        f = locali.g;
        i1 = c(paramMessageEntity);
        localArrayMap = new ArrayMap(20);
        if (localh != null)
          if (localb == null)
            break label910;
      }
      label897: label903: label910: for (boolean bool14 = true; ; bool14 = false)
      {
        a(localArrayMap, localh, bool14);
        a.c(localArrayMap, str4);
        a.d(localArrayMap, str5);
        if (bool3)
          a.h(localArrayMap);
        if (paramMessageEntity.isForwardedMessage())
          a.i(localArrayMap);
        if (paramMessageEntity.hasQuote())
          a.j(localArrayMap);
        if (bool5)
          a.k(localArrayMap);
        if (paramMessageEntity.isSticker())
          a.l(localArrayMap);
        if ("Chat Extension Service".equals(str5))
          a.m(localArrayMap);
        if (paramMessageEntity.isImage())
          a.n(localArrayMap);
        if (paramMessageEntity.isVideo())
          a.o(localArrayMap);
        a.h(localArrayMap, str3);
        a.a(localArrayMap, paramString);
        if (paramMessageEntity.isWink())
          a.b(localArrayMap, paramString);
        if (paramMessageEntity.isPoll())
          a.i(localArrayMap, paramString);
        this.b.a(b.a(i, str1, str2, (String)localObject2, (String)localObject1, str8, bool2, (String)localObject3, str6, bool3, bool5, bool4, bool6, bool7, str12, bool9, bool13, str10, str11, "", "", bool8, str13, str4, str5, n, f, false, str16, j, bool12, str14, k, str3, m, i1, bool10, str15));
        this.b.a(localArrayMap);
        return;
        str3 = "";
        break;
        label740: bool1 = false;
        break label98;
        label746: String str17 = String.valueOf(localh1.b);
        String str18 = String.valueOf(i2);
        boolean bool16 = localh1.e;
        boolean bool17 = false;
        if (bool16)
          bool17 = true;
        if (localh1.c != null)
          str7 = localh1.c;
        str8 = localh1.d;
        String str19 = str7;
        localObject1 = str18;
        bool2 = bool17;
        localObject2 = str17;
        localObject3 = str19;
        break label186;
        bool10 = false;
        break label308;
        label832: if (!paramMessageEntity.isImage())
        {
          boolean bool15 = paramMessageEntity.isVideo();
          bool3 = false;
          j = 0;
          if (!bool15)
            break label343;
        }
        boolean bool11 = da.a(paramMessageEntity.getDescription());
        bool3 = false;
        j = 0;
        if (bool11)
          break label343;
        j = paramMessageEntity.getDescription().length();
        bool3 = true;
        break label343;
        label891: k = 0;
        break label371;
        m = 0;
        break label381;
        str15 = "";
        break label393;
      }
      label916: String str9 = str7;
      localObject1 = "";
      localObject2 = "";
      localObject3 = str9;
      bool2 = false;
    }
  }

  public void a(String paramString1, com.viber.voip.model.entity.h paramh, String paramString2)
  {
    a(paramString1, a(paramh), b(paramh), paramString2);
  }

  public void a(String paramString1, String paramString2)
  {
    this.b.a(b.b("N/A", paramString1));
    this.b.a(a.c(paramString2));
  }

  public void a(String paramString1, String paramString2, int paramInt)
  {
    a(paramString1, new h(paramString2, paramInt));
  }

  public void a(String paramString1, String paramString2, String paramString3)
  {
    Boolean localBoolean = com.viber.voip.model.a.b.c().h("key_first_time_url_clicked");
    if (localBoolean == null)
    {
      localBoolean = Boolean.valueOf(true);
      com.viber.voip.model.a.b.c().b("key_first_time_url_clicked", false);
    }
    String str = StoryConstants.r.a.a(d.r.D.d());
    this.b.a(b.a(str, paramString2, paramString1, localBoolean.booleanValue()));
    this.b.a(a.a(paramString3));
  }

  public void a(String paramString1, String paramString2, String paramString3, Integer paramInteger)
  {
    this.b.a(b.a(paramString1, paramString2, paramString3, paramInteger));
  }

  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    a(paramString1, new i(paramBoolean, paramString2));
  }

  public void a(boolean paramBoolean)
  {
    this.b.a(b.a(paramBoolean));
  }

  public void b()
  {
    this.b.a(b.c());
    this.b.a(a.l(ae.b()));
  }

  public void b(long paramLong, int paramInt)
  {
    d locald = (d)this.b.b("join_community_key_" + paramLong);
    if (locald != null)
      this.b.a(b.a(locald.a, paramInt));
  }

  public void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString)
  {
    this.b.a(b.c(b(paramConversationItemLoaderEntity), c(paramConversationItemLoaderEntity), da.h(paramString)));
  }

  public void b(String paramString)
  {
    this.b.a(b.a(paramString));
  }

  public void b(String paramString, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    a(paramConversationItemLoaderEntity.getId(), new f(this, paramString, paramConversationItemLoaderEntity));
  }

  public void b(String paramString1, com.viber.voip.model.entity.h paramh, String paramString2)
  {
    c localc = f();
    if ((localc != null) && (paramString1.equals(localc.b)))
    {
      this.b.b("create_chat_key");
      String str1 = a(paramh);
      String str2 = b(paramh);
      String str3 = StoryConstants.g.a.a(paramh, localc.d);
      this.b.a(b.a(str1, str2, str3, localc.c, localc.a, localc.e));
      this.b.a(a.j(paramString2));
    }
  }

  public void b(String paramString1, String paramString2)
  {
    this.b.a(b.a(paramString1, paramString2));
  }

  public void b(String paramString1, String paramString2, String paramString3)
  {
    this.b.a(b.g(paramString1, paramString2, paramString3));
  }

  public void c()
  {
    this.b.a(b.d());
    this.b.a(a.m(ae.b()));
  }

  public void c(String paramString)
  {
    a(new k(paramString));
  }

  public void d()
  {
    this.b.a(b.e());
  }

  private static class a
  {
    String a;
    String b;
    String c;
    String d;
    long e;

    a(long paramLong)
    {
      this.e = paramLong;
    }

    public void a(String paramString)
    {
      this.a = paramString;
    }

    public void b(String paramString)
    {
      this.b = paramString;
    }

    public void c(String paramString)
    {
      this.c = paramString;
    }

    public void d(String paramString)
    {
      this.d = paramString;
    }
  }

  private static class b
  {
    final String a;
    final String b;

    b(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }

    public String toString()
    {
      return "ChatExtensionInfo{chatExtensionUri='" + this.a + '\'' + ", chatExtensionService='" + this.b + '\'' + '}';
    }
  }

  private static class c
  {
    String a;
    String b;
    int c;
    boolean d;
    String e;

    c(String paramString)
    {
      this.b = paramString;
    }

    void a(int paramInt)
    {
      this.c = paramInt;
    }

    void a(String paramString)
    {
      this.a = paramString;
    }

    void a(boolean paramBoolean)
    {
      this.d = paramBoolean;
    }

    void b(String paramString)
    {
      this.e = paramString;
    }
  }

  private static class d
  {
    String a;
    long b;

    public d(long paramLong)
    {
      this.b = paramLong;
    }
  }

  private static class e
  {
    final boolean a;
    final boolean b;

    e(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.a = paramBoolean1;
      this.b = paramBoolean2;
    }

    public String toString()
    {
      return "MessageRichMediaInfo{locationIncluded=" + this.a + ", gifIncluded=" + this.b + '}';
    }
  }

  private static class f
  {
    final boolean a;
    final String b;
    final boolean c;

    f(boolean paramBoolean1, String paramString, boolean paramBoolean2)
    {
      this.a = paramBoolean1;
      this.b = paramString;
      this.c = paramBoolean2;
    }

    public String toString()
    {
      return "MessageSpansInfo{emoticonsIncluded='" + this.a + '\'' + ", emoticonsIds='" + this.b + '\'' + ", linksIncluded='" + this.c + '\'' + '}';
    }
  }

  private static class g
  {
    String a;

    void a(String paramString)
    {
      this.a = paramString;
    }
  }

  private static class h
  {
    final int a;
    final int b;
    final String c;
    final String d;
    final boolean e;

    h(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramString1;
      this.d = paramString2;
      this.e = paramBoolean;
    }

    public String toString()
    {
      return "StickerInfo{stickerId=" + this.a + ", packageId=" + this.b + ", stickerType='" + this.c + '\'' + ", stickerOrigin='" + this.d + '\'' + ", hasClicker=" + this.e + '}';
    }
  }

  private static class i
  {
    final int a;
    String b = "";
    e.h c;
    e.b d;
    String e = "";
    int f;
    float g;
    com.viber.voip.model.entity.h h;
    boolean i;

    i(int paramInt)
    {
      this.a = paramInt;
    }

    void a(float paramFloat)
    {
      this.g = paramFloat;
    }

    void a(int paramInt)
    {
      this.f = paramInt;
    }

    void a(e.b paramb)
    {
      this.d = paramb;
    }

    void a(e.h paramh)
    {
      this.c = paramh;
    }

    void a(com.viber.voip.model.entity.h paramh)
    {
      this.h = paramh;
    }

    void a(String paramString)
    {
      this.b = paramString;
    }

    void a(boolean paramBoolean)
    {
      this.i = paramBoolean;
    }

    void b(String paramString)
    {
      this.e = paramString;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.e.e
 * JD-Core Version:    0.6.2
 */