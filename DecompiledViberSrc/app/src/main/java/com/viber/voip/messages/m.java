package com.viber.voip.messages;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.Editable;
import android.text.Spanned;
import com.viber.common.d.a;
import com.viber.common.d.i;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.secure.QueryDestOperationSupportDelegate;
import com.viber.jni.secure.QueryDestOperationSupportListener;
import com.viber.liblinkparser.LinkParser.LinkSpec;
import com.viber.voip.R.attr;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.TextMetaInfo;
import com.viber.voip.flatbuffers.model.TextMetaInfo.a;
import com.viber.voip.flatbuffers.model.msginfo.AudioPttInfo;
import com.viber.voip.flatbuffers.model.msginfo.ExtendedInfo;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.Pin;
import com.viber.voip.flatbuffers.model.msginfo.Pin.a;
import com.viber.voip.flatbuffers.model.msginfo.Poll;
import com.viber.voip.flatbuffers.model.msginfo.PollUiOptions;
import com.viber.voip.flatbuffers.model.msginfo.Quote;
import com.viber.voip.flatbuffers.model.msginfo.ServiceMetadata;
import com.viber.voip.flatbuffers.model.msginfo.TechInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.PublicAccountInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.PublicAccountMsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.flatbuffers.model.quote.QuotedMessageData;
import com.viber.voip.flatbuffers.model.util.UnsignedLong;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.ai.e;
import com.viber.voip.messages.controller.bs.f;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationData;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.conversation.ui.SpamController;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.messages.orm.entity.json.FormattedUrlMessage;
import com.viber.voip.messages.orm.entity.json.MessageInfo;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.publicaccount.entity.PublicAccount.GlobalPermissions;
import com.viber.voip.registration.af;
import com.viber.voip.settings.d.p;
import com.viber.voip.util.as;
import com.viber.voip.util.at;
import com.viber.voip.util.av;
import com.viber.voip.util.cd;
import com.viber.voip.util.ci;
import com.viber.voip.util.da;
import com.viber.voip.util.dc;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public final class m
{
  public static final ci<String> a = n.a;
  private static final Logger b = ViberEnv.getLogger();

  public static int a(BotReplyConfig paramBotReplyConfig)
  {
    if ((paramBotReplyConfig != null) && (!b(paramBotReplyConfig)))
      return 1;
    return 0;
  }

  public static int a(aa paramaa)
  {
    if (paramaa.q() == 1007);
    for (int i = l(paramaa.m()); ; i = 1)
      return 1 + (paramaa.F() - i);
  }

  public static Intent a(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    return a(paramLong, paramInt, false, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
  }

  public static Intent a(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    return a(paramLong, 0L, 0L, 0L, "", "", paramInt, "", "", "", -1, paramBoolean5, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
  }

  public static Intent a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    ConversationData localConversationData = new ConversationData(paramLong1, paramLong5, paramString1, paramString2, paramInt1, paramString3, paramString4, paramString5, paramInt2, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
    localConversationData.foundMessageToken = paramLong2;
    localConversationData.foundMessageOrderKey = paramLong3;
    localConversationData.foundMessageHightlitingTime = paramLong4;
    return a(localConversationData, paramBoolean1);
  }

  private static Intent a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    return a(paramLong1, paramLong2, paramLong2, paramLong4, paramString1, paramString2, paramInt1, paramString3, paramString4, "", paramInt2, paramBoolean4, false, paramBoolean1, paramBoolean2, paramBoolean3);
  }

  public static Intent a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    return a(paramLong1, paramLong2, paramLong3, -1L, paramLong4, paramString1, paramString2, paramInt1, paramString3, paramString4, paramString5, paramInt2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }

  public static Intent a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString1, String paramString2, int paramInt1, String paramString3, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    Intent localIntent = a(paramLong1, paramLong2, paramLong3, paramLong4, paramString1, paramString2, paramInt1, "", paramString3, paramInt2, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
    localIntent.putExtra("go_up", paramBoolean1);
    if (paramLong2 > 0L)
      localIntent.putExtra("extra_search_message", true);
    return localIntent;
  }

  public static Intent a(long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt1, String paramString3, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    return a(paramLong1, 0L, 0L, paramLong2, paramString1, paramString2, paramInt1, paramString3, paramBoolean1, paramInt2, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }

  public static Intent a(long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    return a(paramLong1, paramLong2, paramString1, paramString2, paramInt, paramString3, paramBoolean1, -1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }

  public static Intent a(long paramLong, boolean paramBoolean)
  {
    return a(paramLong, false, paramBoolean);
  }

  public static Intent a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intent localIntent = a(0L, 0L, 0L, paramLong, "", "", 1, "", "", -1, false, false, false, paramBoolean2);
    if (paramBoolean1)
      localIntent.putExtra("go_up", true);
    return localIntent;
  }

  public static Intent a(PublicGroupConversationData paramPublicGroupConversationData, boolean paramBoolean)
  {
    Intent localIntent = new Intent("com.viber.voip.action.PUBLIC_CONVERSATION");
    localIntent.putExtra("extra_conversation_data", paramPublicGroupConversationData);
    localIntent.putExtra("go_up", paramBoolean);
    return localIntent;
  }

  public static Intent a(ConversationData paramConversationData, boolean paramBoolean)
  {
    String str = "com.viber.voip.action.CONVERSATION";
    switch (paramConversationData.conversationType)
    {
    case 4:
    default:
    case 2:
    case 3:
    case 5:
    }
    while (true)
    {
      if (paramConversationData.isInBusinessInbox)
        str = "com.viber.voip.action.BUSINESS_INBOX_CONVERSATION";
      if ((paramConversationData.isInSmsInbox) && (!paramBoolean))
        str = "com.viber.voip.action.SMS_INBOX_CONVERSATION";
      Intent localIntent = new Intent(str);
      localIntent.putExtra("extra_conversation_data", paramConversationData);
      localIntent.putExtra("go_up", true);
      return localIntent;
      str = "com.viber.voip.action.PUBLIC_CONVERSATION";
      continue;
      str = "com.viber.voip.action.COMMUNITY_CONVERSATION";
    }
  }

  public static Intent a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    return a(0L, 0L, 0L, 0L, paramString1, paramString2, 0, paramString3, paramString4, 0, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
  }

  public static Intent a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    return a(paramString1, paramString2, "", paramString3, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
  }

  public static Uri a(int paramInt, Uri paramUri)
  {
    if ((paramUri == null) && (b(paramInt)))
      paramUri = Uri.parse("android.resource://com.viber.voip/drawable/ic_community_default");
    return paramUri;
  }

  public static Uri a(Context paramContext, Uri paramUri)
  {
    if (paramUri == null)
      paramUri = null;
    do
    {
      do
      {
        return paramUri;
        if (!"android.resource://com.viber.voip/drawable/broadcast_list_pic".equals(paramUri.toString()))
          break;
      }
      while (dc.a(paramContext, R.attr.conversationsListItemDefaultBroadcastImage) != R.drawable.ic_chat_list_broadcast);
      return Uri.parse("android.resource://com.viber.voip/drawable/ic_chat_list_broadcast");
    }
    while ((!"android.resource://com.viber.voip/drawable/ic_community_default".equals(paramUri.toString())) || (dc.a(paramContext, R.attr.conversationsListItemDefaultCommunityImage) != R.drawable.darcula_img_community_default));
    return Uri.parse("android.resource://com.viber.voip/drawable/darcula_img_community_default");
  }

  public static QuotedMessageData a(Quote paramQuote, aa paramaa, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    int i = paramaa.q();
    String str1 = a(paramaa, i);
    String str2 = b(paramaa, i);
    boolean bool1 = paramaa.W();
    String str3 = paramaa.c(paramInt1);
    String str4;
    String str5;
    label67: int j;
    label77: long l;
    label87: String str6;
    if (paramaa.aE())
    {
      str4 = paramaa.L().getPushText();
      if (!paramaa.aE())
        break label168;
      str5 = paramaa.L().getPreviewText();
      if (paramQuote != null)
        break label175;
      j = paramaa.F();
      if (paramQuote != null)
        break label184;
      l = paramaa.y();
      if (paramQuote != null)
        break label193;
      str6 = paramString1;
      label94: if ((!paramaa.aM()) && (!paramaa.aH()))
        break label202;
    }
    label168: label175: label184: label193: label202: for (boolean bool2 = true; ; bool2 = false)
    {
      QuotedMessageData localQuotedMessageData = a(str1, l, i, str6, str2, bool1, str4, bool2, str5, j, true, 10, paramaa.bx().getTextMetaInfo(), paramString2, false, paramInt2);
      localQuotedMessageData.setSenderName(str3);
      return localQuotedMessageData;
      str4 = "";
      break;
      str5 = "";
      break label67;
      j = paramQuote.getMessageId();
      break label77;
      l = paramQuote.getToken();
      break label87;
      str6 = paramQuote.getMemberId();
      break label94;
    }
  }

  private static QuotedMessageData a(Quote paramQuote, MessageEntity paramMessageEntity)
  {
    int i;
    Object localObject1;
    String str1;
    Object localObject2;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    int j;
    Object localObject3;
    TextMetaInfo[] arrayOfTextMetaInfo;
    long l;
    int k;
    if (paramMessageEntity != null)
    {
      i = paramMessageEntity.getMimeType();
      if ((paramMessageEntity != null) && (paramMessageEntity.getMimeType() != 1007))
        break label140;
      localObject1 = com.viber.voip.messages.c.b.a(i, paramQuote.getText());
      str1 = "";
      localObject2 = "";
      bool1 = false;
      bool2 = false;
      bool3 = false;
      j = 0;
      localObject3 = paramQuote.getMemberId();
      arrayOfTextMetaInfo = paramQuote.getTextMetaInfo();
      l = paramQuote.getToken();
      k = paramQuote.getMessageId();
      if ((paramMessageEntity == null) || (paramMessageEntity.getMimeType() == 1007))
        break label296;
    }
    label140: label273: label283: label290: label296: for (boolean bool4 = true; ; bool4 = false)
    {
      return a((String)localObject1, l, i, (String)localObject3, str1, bool1, (String)localObject2, bool2, "", k, bool4, 11, arrayOfTextMetaInfo, paramQuote.getMemberId(), bool3, j);
      i = l.a(paramQuote.getMediaType());
      break;
      String str2 = a(paramQuote, paramMessageEntity, i);
      str1 = b(paramMessageEntity, i);
      bool1 = paramMessageEntity.isFromPublicAccount();
      String str3;
      label184: FormattedMessage localFormattedMessage;
      String str4;
      if ((da.a(paramMessageEntity.getMemberId())) || (paramMessageEntity.isOneToOneType()))
      {
        str3 = paramQuote.getMemberId();
        if (!paramMessageEntity.isFormattedMessage())
          break label283;
        localFormattedMessage = paramMessageEntity.loadFormattedMessage();
        if (localFormattedMessage != null)
          break label273;
        str4 = null;
        label205: if ((!paramMessageEntity.isGifUrlMessage()) && (!paramMessageEntity.isGifFile()))
          break label290;
      }
      for (boolean bool5 = true; ; bool5 = false)
      {
        bool3 = paramMessageEntity.isYouWasMentionedInThisMessage();
        j = paramMessageEntity.getQuotedMessageData().getReplySource();
        arrayOfTextMetaInfo = paramMessageEntity.getMessageInfo().getTextMetaInfo();
        bool2 = bool5;
        localObject3 = str3;
        localObject2 = str4;
        localObject1 = str2;
        break;
        str3 = paramMessageEntity.getMemberId();
        break label184;
        str4 = localFormattedMessage.getPushText();
        break label205;
        str4 = "";
        break label205;
      }
    }
  }

  private static QuotedMessageData a(String paramString1, long paramLong, int paramInt1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, String paramString5, int paramInt2, boolean paramBoolean3, int paramInt3, TextMetaInfo[] paramArrayOfTextMetaInfo, String paramString6, boolean paramBoolean4, int paramInt4)
  {
    QuotedMessageData localQuotedMessageData = new QuotedMessageData();
    localQuotedMessageData.setBody(paramString1);
    localQuotedMessageData.setToken(paramLong);
    localQuotedMessageData.setType(paramInt1);
    localQuotedMessageData.setMemberId(paramString2);
    localQuotedMessageData.setDownloadId(paramString3);
    localQuotedMessageData.setFromPublicAccount(paramBoolean1);
    localQuotedMessageData.setPreviewText(paramString4);
    localQuotedMessageData.setMessageUrl(paramString5);
    localQuotedMessageData.setMessageId(paramInt2);
    localQuotedMessageData.setEncryptedPhoneNumber(paramString6);
    localQuotedMessageData.setTextMetaInfo(paramArrayOfTextMetaInfo);
    localQuotedMessageData.setReplySource(paramInt4);
    if (paramBoolean2)
      localQuotedMessageData.addFlag(1L);
    if (paramBoolean3)
      localQuotedMessageData.addFlag(2L);
    if (paramBoolean4)
      localQuotedMessageData.addFlag(3L);
    a(localQuotedMessageData, paramInt3, paramArrayOfTextMetaInfo);
    return localQuotedMessageData;
  }

  public static String a(int paramInt1, int paramInt2)
  {
    com.google.d.o localo = new com.google.d.o();
    localo.a("message_score", Integer.valueOf(paramInt1));
    if (paramInt2 != 0)
      localo.a("message_source", Integer.valueOf(paramInt2));
    return localo.toString();
  }

  public static String a(Context paramContext, boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) || (da.a(paramString)))
      return paramContext.getString(R.string.message_type_rich_message);
    return paramContext.getString(R.string.conversation_preview_rich_text, new Object[] { paramString });
  }

  public static String a(Resources paramResources, boolean paramBoolean, MessageEntity paramMessageEntity, String paramString)
  {
    return a(paramResources, paramMessageEntity.isOneToOneChatWithPa(), paramMessageEntity.isIncoming(), paramBoolean, paramString, paramMessageEntity.getPublicAccountInfoName());
  }

  private static String a(Resources paramResources, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2)
  {
    if ((paramBoolean1) || (!paramBoolean2))
      return paramResources.getString(R.string.message_type_rich_message);
    if ((da.a(paramString1)) && (!paramBoolean3))
    {
      if (da.a(paramString2))
        return paramResources.getString(R.string.message_type_rich_message);
      return paramResources.getString(R.string.message_notification_rich_text_content, new Object[] { paramString2 });
    }
    if (da.a(paramString2))
    {
      if (paramBoolean3)
        return paramResources.getString(R.string.message_notification_rich_message_incoming_group, new Object[] { paramString1 });
      return paramResources.getString(R.string.message_notification_rich_message_incoming_1on1, new Object[] { paramString1 });
    }
    if (paramBoolean3)
      return paramResources.getString(R.string.message_notification_rich_group_text, new Object[] { paramString1, paramString2 });
    return paramResources.getString(R.string.message_notification_rich_text, new Object[] { paramString1, paramString2 });
  }

  public static String a(Editable paramEditable)
  {
    TextMetaInfo[] arrayOfTextMetaInfo = a(paramEditable);
    if (arrayOfTextMetaInfo != null)
    {
      MsgInfo localMsgInfo = new MsgInfo();
      localMsgInfo.setTextMetaInfo(arrayOfTextMetaInfo);
      return com.viber.voip.flatbuffers.b.e.a().b().a(localMsgInfo);
    }
    return null;
  }

  public static String a(MsgInfo paramMsgInfo)
  {
    if (paramMsgInfo == null);
    PublicAccountInfo localPublicAccountInfo;
    do
    {
      return null;
      localPublicAccountInfo = paramMsgInfo.getPublicAccountMsgInfo().getPublicAccountInfo();
    }
    while ((localPublicAccountInfo == null) || (localPublicAccountInfo.isIgnorePaInfo()));
    return localPublicAccountInfo.getPaName();
  }

  private static String a(Quote paramQuote, MessageEntity paramMessageEntity, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return paramMessageEntity.getBody();
    case 9:
      return paramMessageEntity.getMessageInfo().getName();
    case 1003:
    case 1004:
    }
    return paramQuote.getText();
  }

  private static String a(aa paramaa, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return paramaa.h();
    case 9:
    }
    return paramaa.bx().getName();
  }

  public static String a(MessageEntity paramMessageEntity)
  {
    switch (paramMessageEntity.getMimeType())
    {
    default:
      return da.h(paramMessageEntity.getDescription());
    case 0:
      return da.h(paramMessageEntity.getBody());
    case 8:
    }
    try
    {
      String str = new JSONObject(paramMessageEntity.getRawMessageInfo()).optString("Text", "");
      return str;
    }
    catch (JSONException localJSONException)
    {
    }
    return "";
  }

  public static void a(int paramInt, MessageEntity[] paramArrayOfMessageEntity)
  {
    i.a();
    int i = paramArrayOfMessageEntity.length;
    for (int j = 0; j < i; j++)
    {
      MessageEntity localMessageEntity = paramArrayOfMessageEntity[j];
      com.viber.voip.util.g.a.f.a(localMessageEntity.getMimeType(), paramInt).a(localMessageEntity);
    }
  }

  public static void a(QuotedMessageData paramQuotedMessageData, int paramInt, TextMetaInfo[] paramArrayOfTextMetaInfo)
  {
    int i = paramQuotedMessageData.getType();
    Object localObject = null;
    switch (i)
    {
    default:
    case 0:
    case 7:
    case 8:
    }
    while (da.a((CharSequence)localObject))
    {
      paramQuotedMessageData.setSpans("no_sp");
      return;
      boolean bool = paramQuotedMessageData.isGif();
      localObject = null;
      if (!bool)
        if (da.a(paramQuotedMessageData.getPreviewText()))
          localObject = paramQuotedMessageData.getBody();
        else
          localObject = paramQuotedMessageData.getPreviewText();
    }
    String str = com.viber.voip.util.g.a.f.b(paramInt).a((String)localObject, paramArrayOfTextMetaInfo);
    if (str == null)
      str = "no_sp";
    paramQuotedMessageData.setSpans(str);
  }

  public static void a(ab paramab, MessageEntity paramMessageEntity)
  {
    if (paramMessageEntity.isPublicGroupBehavior())
    {
      if (!paramMessageEntity.isToSend())
      {
        paramMessageEntity.setMimeType(1007);
        paramMessageEntity.setFlag(av.e(paramMessageEntity.getFlag(), 8));
        if (!paramMessageEntity.isSyncedMessage())
          paramab.C(paramMessageEntity.getGroupId());
      }
      return;
    }
    paramMessageEntity.addExtraFlag(22);
    paramMessageEntity.setUnread(0);
  }

  public static void a(MessageEntity paramMessageEntity, int paramInt)
  {
    if ((i(paramInt)) && (paramMessageEntity.isFormattedMessage()));
    try
    {
      a(new FormattedMessage(paramMessageEntity.getBody()).getInfo().getTrackingData(), j(paramInt));
      String str1;
      String str2;
      do
      {
        do
          return;
        while (!paramMessageEntity.isConvertedFromPublicAccountFormat());
        PublicAccountMsgInfo localPublicAccountMsgInfo = paramMessageEntity.getMessageInfo().getPublicAccountMsgInfo();
        str1 = localPublicAccountMsgInfo.getTrackingData();
        if (localPublicAccountMsgInfo.getPublicAccountInfo() == null);
        for (str2 = ""; paramMessageEntity.isOneToOneChatWithPa(); str2 = localPublicAccountMsgInfo.getPublicAccountInfo().getPaId())
        {
          a(str1, paramMessageEntity.getMemberId());
          return;
        }
      }
      while (da.a(str2));
      a("-4", str1, com.viber.voip.publicaccount.d.e.a(paramMessageEntity, str2));
      return;
    }
    catch (JSONException localJSONException)
    {
    }
  }

  public static void a(MessageEntity paramMessageEntity, Quote paramQuote)
  {
    MsgInfo localMsgInfo = paramMessageEntity.getMessageInfo();
    localMsgInfo.setQuote(paramQuote);
    paramMessageEntity.setRawMessageInfo(com.viber.voip.flatbuffers.b.e.a().b().a(localMsgInfo));
  }

  public static void a(MessageEntity paramMessageEntity, af paramaf)
  {
    if (a(paramMessageEntity.getMessageInfo(), paramaf))
      paramMessageEntity.addExtraFlag(34);
  }

  public static void a(MessageEntity paramMessageEntity, String paramString)
  {
    if ((!da.a(paramString)) && (paramMessageEntity.isOutgoing()))
    {
      String str = com.viber.voip.model.e.c("-3", paramString);
      if (!da.a(str))
      {
        MsgInfo localMsgInfo = paramMessageEntity.getMessageInfo();
        localMsgInfo.getServiceMetadata().setTrackingData(str);
        paramMessageEntity.setRawMessageInfo(com.viber.voip.flatbuffers.b.e.a().b().a(localMsgInfo));
      }
    }
  }

  public static void a(MessageEntity paramMessageEntity, String paramString, ai.e parame)
  {
    b(paramMessageEntity, paramString, parame);
  }

  public static void a(h paramh, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
      return;
    if (cd.c(paramInt2))
    {
      paramh.h(30);
      paramh.g(31);
      return;
    }
    if (cd.a(paramInt2))
    {
      paramh.h(31);
      paramh.g(30);
      return;
    }
    paramh.h(30);
    paramh.h(31);
  }

  public static void a(String paramString1, String paramString2)
  {
    a("-3", paramString1, paramString2);
  }

  public static void a(String paramString1, String paramString2, String paramString3)
  {
    com.viber.voip.model.e.a(paramString1, paramString3, paramString2);
  }

  public static void a(boolean paramBoolean, ab paramab, MessageEntity paramMessageEntity)
  {
    MessageEntity localMessageEntity;
    MsgInfo localMsgInfo;
    Poll localPoll;
    Object localObject1;
    int j;
    PollUiOptions localPollUiOptions;
    Object localObject2;
    if (paramMessageEntity.isPollOptionMessage())
    {
      localMessageEntity = paramab.k(paramMessageEntity.getMessageInfo().getPoll().getParentToken().get());
      if ((localMessageEntity != null) && (localMessageEntity.isPollQuestionMessage()))
      {
        localMsgInfo = localMessageEntity.getMessageInfo();
        localPoll = localMsgInfo.getPoll();
        localObject1 = null;
        PollUiOptions[] arrayOfPollUiOptions = localPoll.getOptions();
        int i = arrayOfPollUiOptions.length;
        j = 0;
        if (j < i)
        {
          localPollUiOptions = arrayOfPollUiOptions[j];
          if (localPollUiOptions.getToken() == paramMessageEntity.getMessageToken())
          {
            localPollUiOptions.setLikesCount(paramMessageEntity.getLikesCount());
            localPollUiOptions.setLiked(paramMessageEntity.hasMyLike());
            localObject2 = localObject1;
          }
        }
      }
    }
    while (true)
    {
      j++;
      localObject1 = localObject2;
      break;
      if ((localPollUiOptions.isLiked()) && (paramMessageEntity.hasMyLike()))
      {
        if (-1 + localPollUiOptions.getLikesCount() >= 0);
        for (int k = -1 + localPollUiOptions.getLikesCount(); ; k = 0)
        {
          localPollUiOptions.setLikesCount(k);
          localPollUiOptions.setLiked(false);
          localObject2 = localPollUiOptions;
          break;
        }
        String str = com.viber.voip.flatbuffers.b.e.a().b().a(localMsgInfo);
        paramab.a(localMessageEntity.getTable(), localMessageEntity.getId(), "msg_info", str);
        if ((paramBoolean) && (!localPoll.isMultiple()) && (localObject1 != null))
          ViberApplication.getInstance().getMessagesManager().c().e(localObject1.getToken());
        return;
      }
      localObject2 = localObject1;
    }
  }

  public static boolean a()
  {
    return a.c();
  }

  public static boolean a(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3);
  }

  public static boolean a(int paramInt, String paramString)
  {
    return (paramInt == 0) && (cd.c(paramString));
  }

  public static boolean a(int paramInt, String paramString, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if (paramConversationItemLoaderEntity != null)
      return paramConversationItemLoaderEntity.isAnonymous();
    com.viber.voip.model.entity.m localm = com.viber.voip.messages.d.c.c().c(paramString, 1);
    if (localm != null)
      return a(paramInt, localm.a());
    return false;
  }

  public static boolean a(MsgInfo paramMsgInfo, af paramaf)
  {
    TextMetaInfo[] arrayOfTextMetaInfo = paramMsgInfo.getTextMetaInfo();
    boolean bool = false;
    if (arrayOfTextMetaInfo != null)
    {
      int i = arrayOfTextMetaInfo.length;
      for (int j = 0; j < i; j++)
      {
        TextMetaInfo localTextMetaInfo = arrayOfTextMetaInfo[j];
        String str = localTextMetaInfo.getMemberId();
        if ((localTextMetaInfo.getType() == TextMetaInfo.a.MENTION) && (a(paramaf, str)))
          bool = true;
      }
    }
    return bool;
  }

  public static boolean a(bs.f paramf)
  {
    return (paramf.a) || (paramf.b);
  }

  public static boolean a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    return (paramConversationItemLoaderEntity.isConversation1on1()) && (!paramConversationItemLoaderEntity.isSecret()) && (!paramConversationItemLoaderEntity.isHiddenConversation()) && (!paramConversationItemLoaderEntity.isOneToOneWithPublicAccount()) && (!paramConversationItemLoaderEntity.isSystemConversation()) && (!paramConversationItemLoaderEntity.isAnonymous());
  }

  public static boolean a(aa paramaa, int paramInt, com.viber.voip.group.participants.settings.b paramb)
  {
    if (paramaa.ba())
      return false;
    return a(paramaa.aS(), paramInt, paramaa.e(), paramaa.g(), paramaa.A(), paramb);
  }

  public static boolean a(MessageEntity paramMessageEntity, MsgInfo paramMsgInfo)
  {
    String str1 = com.viber.voip.flatbuffers.b.e.a().b().a(paramMsgInfo);
    if (str1 == "{}")
      return false;
    String str2 = FormattedUrlMessage.createUrlMessage(paramMsgInfo, true);
    paramMessageEntity.removeExtraFlag(18);
    paramMessageEntity.setMimeType(8);
    paramMessageEntity.setBody(str2);
    paramMessageEntity.setRawMessageInfo(str1);
    paramMessageEntity.setSpans(null);
    paramMessageEntity.setFormattedMessage(null);
    a(11, new MessageEntity[] { paramMessageEntity });
    return true;
  }

  public static boolean a(MessageEntity paramMessageEntity, ab paramab)
  {
    Pin localPin = paramMessageEntity.getMessageInfo().getPin();
    MessageEntity localMessageEntity = paramab.k(localPin.getToken());
    if ((localMessageEntity != null) && (localPin.getMediaType() != 0) && (Pin.a.DELETE != localPin.getAction()) && ((localMessageEntity.isImage()) || (localMessageEntity.isVideo()) || (localMessageEntity.isGifFile())) && (localPin.getExtendedInfo() != null) && (da.a(localPin.getExtendedInfo().getDownloadId())))
    {
      paramMessageEntity.setMediaUri(localMessageEntity.getBody());
      return true;
    }
    return false;
  }

  private static boolean a(MessageEntity paramMessageEntity1, MessageEntity paramMessageEntity2)
  {
    Quote localQuote = paramMessageEntity1.getMessageInfo().getQuote();
    if (localQuote != null)
    {
      QuotedMessageData localQuotedMessageData = a(localQuote, paramMessageEntity2);
      if ((paramMessageEntity2 != null) && (paramMessageEntity2.isYouWasMentionedInThisMessage()))
        paramMessageEntity1.addExtraFlag(36);
      paramMessageEntity1.setRawQuotedMessageData(com.viber.voip.flatbuffers.b.e.b().b().a(localQuotedMessageData));
      return true;
    }
    return false;
  }

  public static boolean a(af paramaf, String paramString)
  {
    return (paramString != null) && ((paramString.equals(paramaf.l())) || (paramString.equals(paramaf.j())) || (paramString.equals(paramaf.k())));
  }

  public static boolean a(String paramString)
  {
    return (!da.a(paramString)) && (paramString.startsWith("External:"));
  }

  public static boolean a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2, int paramInt3, com.viber.voip.group.participants.settings.b paramb)
  {
    int i;
    if (paramBoolean)
    {
      if (System.currentTimeMillis() - paramLong <= 2592000000L)
        break label28;
      i = 1;
      if (!cd.c(paramInt1))
        break label34;
    }
    label28: label34: 
    while (((1 == paramInt2) && (i == 0) && ((paramb == null) || (paramb.canWrite()))) || ((b(paramInt3)) && (cd.a(paramInt1))))
    {
      return true;
      i = 0;
      break;
    }
    return false;
  }

  public static boolean a(boolean paramBoolean, MessageEntity paramMessageEntity, String paramString, int paramInt)
  {
    if ((paramBoolean) && (paramMessageEntity.isIncoming()))
    {
      File localFile = com.viber.voip.util.upload.o.a(paramString, paramInt, ViberApplication.getApplication());
      if ((at.a(localFile)) && (localFile.length() > 0L))
      {
        paramMessageEntity.setMediaUri(Uri.fromFile(localFile).toString());
        return true;
      }
    }
    return false;
  }

  public static TextMetaInfo[] a(Spanned paramSpanned)
  {
    int i = 0;
    com.viber.voip.ui.style.c[] arrayOfc = (com.viber.voip.ui.style.c[])paramSpanned.getSpans(0, paramSpanned.length(), com.viber.voip.ui.style.c.class);
    if ((arrayOfc != null) && (arrayOfc.length > 0))
    {
      TextMetaInfo[] arrayOfTextMetaInfo = new TextMetaInfo[arrayOfc.length];
      int j = arrayOfc.length;
      while (i < j)
      {
        com.viber.voip.ui.style.c localc = arrayOfc[i];
        TextMetaInfo localTextMetaInfo = localc.getMetaInfo();
        localTextMetaInfo.setStartPosition(paramSpanned.getSpanStart(localc));
        localTextMetaInfo.setEndPosition(paramSpanned.getSpanEnd(localc));
        arrayOfTextMetaInfo[i] = localTextMetaInfo;
        i++;
      }
      return arrayOfTextMetaInfo;
    }
    return null;
  }

  public static boolean[] a(MessageEntity paramMessageEntity, long paramLong)
  {
    if ((paramMessageEntity.isGroupBehavior()) || (paramMessageEntity.isPublicAccount()))
      return new boolean[] { 1, 0 };
    return a(paramMessageEntity.getMemberId(), paramLong);
  }

  public static boolean[] a(String paramString, long paramLong)
  {
    Engine localEngine = ViberApplication.getInstance().getEngine(false);
    int i = localEngine.getPhoneController().generateSequence();
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    final Boolean[] arrayOfBoolean = new Boolean[1];
    QueryDestOperationSupportDelegate local2 = new QueryDestOperationSupportDelegate()
    {
      public void onQueryDestOperationSupportReplyMsg(int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (this.a == paramAnonymousInt1);
        switch (paramAnonymousInt2)
        {
        default:
          localCountDownLatch.countDown();
          return;
        case 1:
        }
        Boolean[] arrayOfBoolean = arrayOfBoolean;
        if ((paramAnonymousInt3 & 0x1) != 0);
        for (boolean bool = true; ; bool = false)
        {
          arrayOfBoolean[0] = Boolean.valueOf(bool);
          break;
        }
      }
    };
    localEngine.getDelegatesManager().getQueryDestOperationSupportListener().registerDelegate(new QueryDestOperationSupportDelegate[] { local2 });
    localEngine.getPhoneController().handleSendQueryDestOperationSupport(i, paramString, paramLong);
    try
    {
      if (localCountDownLatch.await(30000L, TimeUnit.MILLISECONDS))
      {
        if (arrayOfBoolean[0] != null)
        {
          if (!arrayOfBoolean[0].booleanValue())
          {
            boolean[] arrayOfBoolean4 = new boolean[2];
            arrayOfBoolean4[0] = 0;
            arrayOfBoolean4[1] = 0;
            return arrayOfBoolean4;
          }
        }
        else
        {
          boolean[] arrayOfBoolean3 = new boolean[2];
          arrayOfBoolean3[0] = 0;
          arrayOfBoolean3[1] = 1;
          return arrayOfBoolean3;
        }
      }
      else
      {
        boolean[] arrayOfBoolean2 = new boolean[2];
        arrayOfBoolean2[0] = 0;
        arrayOfBoolean2[1] = 1;
        return arrayOfBoolean2;
      }
      localEngine.getDelegatesManager().getQueryDestOperationSupportListener().removeDelegate(local2);
      return new boolean[] { 1, 0 };
    }
    catch (InterruptedException localInterruptedException)
    {
      boolean[] arrayOfBoolean1 = new boolean[2];
      arrayOfBoolean1[0] = 0;
      arrayOfBoolean1[1] = 1;
      return arrayOfBoolean1;
    }
    finally
    {
      localEngine.getDelegatesManager().getQueryDestOperationSupportListener().removeDelegate(local2);
    }
  }

  private static String b(aa paramaa, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return paramaa.B();
    case 9:
    }
    return paramaa.bx().getDownloadId();
  }

  private static String b(MessageEntity paramMessageEntity, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return paramMessageEntity.getDownloadId();
    case 9:
    }
    return paramMessageEntity.getMessageInfo().getDownloadId();
  }

  public static void b(MessageEntity paramMessageEntity)
  {
    com.viber.voip.util.g.a.f.a(paramMessageEntity.getMimeType()).a(paramMessageEntity);
  }

  private static void b(MessageEntity paramMessageEntity, String paramString, final ai.e parame)
  {
    final k localk = ViberApplication.getInstance().getMessagesManager();
    String str = paramMessageEntity.getMemberId();
    int i = paramMessageEntity.getConversationType();
    if (((i == 1) && (paramMessageEntity.getGroupId() > 0L)) || ((!da.a(str)) && (localk != null)))
      localk.c().a(i, new Member(str, paramString), paramMessageEntity.getGroupId(), true, false, new ai.e()
      {
        public void a(ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity)
        {
          if ((paramAnonymousConversationItemLoaderEntity != null) && (paramAnonymousConversationItemLoaderEntity.isShareLocation()) && ((this.a.getLat() == 0) || (this.a.getLng() == 0)))
            this.a.setExtraStatus(0);
          localk.c().a(this.a, null);
          if (parame != null)
            parame.a(paramAnonymousConversationItemLoaderEntity);
        }
      });
  }

  public static boolean b()
  {
    return d.p.v.d() >= 10;
  }

  public static boolean b(int paramInt)
  {
    return paramInt == 5;
  }

  public static boolean b(MsgInfo paramMsgInfo)
  {
    if (paramMsgInfo == null);
    PublicAccountInfo localPublicAccountInfo;
    do
    {
      return false;
      localPublicAccountInfo = paramMsgInfo.getPublicAccountMsgInfo().getPublicAccountInfo();
    }
    while (localPublicAccountInfo == null);
    return localPublicAccountInfo.isIgnorePaInfo();
  }

  private static boolean b(BotReplyConfig paramBotReplyConfig)
  {
    ReplyButton[] arrayOfReplyButton = paramBotReplyConfig.getButtons();
    int i = arrayOfReplyButton.length;
    int j = 0;
    ReplyButton localReplyButton;
    if (j < i)
    {
      localReplyButton = arrayOfReplyButton[j];
      if (localReplyButton.getText() == null)
        break label174;
    }
    label174: for (int k = 1; ; k = 0)
    {
      if (localReplyButton.getBgMedia() != null);
      for (int m = 1; ; m = 0)
      {
        if (localReplyButton.getImageUri() != null);
        for (int n = 1; ; n = 0)
        {
          if (localReplyButton.getBgColor() != null);
          for (int i1 = 1; ; i1 = 0)
          {
            if ((k == 0) && (m == 0) && (n == 0) && (i1 == 0));
            int i3;
            do
            {
              int i2;
              do
              {
                return false;
                i2 = localReplyButton.getRows();
              }
              while ((i2 > paramBotReplyConfig.getButtonsGroupRows()) || (i2 < 1));
              i3 = localReplyButton.getColumns();
            }
            while ((i3 > paramBotReplyConfig.getButtonsGroupColumns()) || (i3 < 1));
            j++;
            break;
            return new com.viber.voip.bot.item.d(paramBotReplyConfig.getButtonsGroupRows(), paramBotReplyConfig.getButtonsGroupColumns()).a(paramBotReplyConfig);
          }
        }
      }
    }
  }

  public static boolean b(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if ((paramConversationItemLoaderEntity == null) || (paramConversationItemLoaderEntity.isSystemConversation()) || (paramConversationItemLoaderEntity.isDisabledConversation()) || (paramConversationItemLoaderEntity.isCommunityBlocked()) || (paramConversationItemLoaderEntity.isPendingInfo()) || ((paramConversationItemLoaderEntity.isOneToOneWithPublicAccount()) && (!paramConversationItemLoaderEntity.isWebhookExist())) || (3 == paramConversationItemLoaderEntity.getGroupRole()) || (paramConversationItemLoaderEntity.showInviteBanner()));
    label120: label123: 
    while (true)
    {
      return false;
      PublicGroupConversationItemLoaderEntity localPublicGroupConversationItemLoaderEntity;
      if ((paramConversationItemLoaderEntity instanceof PublicGroupConversationItemLoaderEntity))
      {
        localPublicGroupConversationItemLoaderEntity = (PublicGroupConversationItemLoaderEntity)paramConversationItemLoaderEntity;
        if ((2 != paramConversationItemLoaderEntity.getGroupRole()) || (localPublicGroupConversationItemLoaderEntity.getRevision() > 1) || (localPublicGroupConversationItemLoaderEntity.getGroupEnterCount() != 0))
          break label120;
      }
      for (int i = 1; ; i = 0)
      {
        if ((localPublicGroupConversationItemLoaderEntity.isPendingRole()) || (i != 0))
          break label123;
        if (SpamController.b(paramConversationItemLoaderEntity))
          break;
        return true;
      }
    }
  }

  public static boolean b(MessageEntity paramMessageEntity, ab paramab)
  {
    return a(paramMessageEntity, paramab.k(paramMessageEntity.getMessageInfo().getQuote().getToken()));
  }

  public static boolean b(String paramString)
  {
    return (!da.a(paramString)) && (paramString.startsWith("pa:"));
  }

  private static int c()
  {
    return 500;
  }

  public static boolean c(int paramInt)
  {
    return paramInt == 4;
  }

  public static boolean c(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    boolean bool1 = paramConversationItemLoaderEntity instanceof PublicGroupConversationItemLoaderEntity;
    boolean bool2 = false;
    if (bool1)
    {
      PublicGroupConversationItemLoaderEntity localPublicGroupConversationItemLoaderEntity = (PublicGroupConversationItemLoaderEntity)paramConversationItemLoaderEntity;
      boolean bool3 = localPublicGroupConversationItemLoaderEntity.isCommunityType();
      bool2 = false;
      if (bool3)
      {
        boolean bool4 = localPublicGroupConversationItemLoaderEntity.isDisplayInvitationLinkToAll();
        bool2 = false;
        if (bool4)
          if ((localPublicGroupConversationItemLoaderEntity.getWatchersCount() <= c()) && (!localPublicGroupConversationItemLoaderEntity.isOpenCommunity()) && (!localPublicGroupConversationItemLoaderEntity.isVerified()))
          {
            boolean bool5 = PublicAccount.GlobalPermissions.canWrite(localPublicGroupConversationItemLoaderEntity.getCommunityPrivileges());
            bool2 = false;
            if (bool5);
          }
          else
          {
            bool2 = true;
          }
      }
    }
    return bool2;
  }

  public static boolean c(MessageEntity paramMessageEntity)
  {
    if ((paramMessageEntity.getMimeType() != 0) || (a(paramMessageEntity.getMemberId())) || (paramMessageEntity.isPinMessage()));
    com.viber.voip.util.links.d locald;
    do
    {
      do
        return false;
      while (paramMessageEntity.isForwardedMessage());
      locald = com.viber.voip.util.links.f.d().a(paramMessageEntity.getBody(), a);
    }
    while ((locald == null) || (locald.a == null));
    return true;
  }

  public static boolean c(String paramString)
  {
    return (!da.a(paramString)) && ("viber".equals(paramString.toLowerCase()));
  }

  public static int d(String paramString)
  {
    if (a(paramString))
      try
      {
        int i = Integer.parseInt(paramString.substring("External:".length()));
        return i;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    return 0;
  }

  public static void d(MessageEntity paramMessageEntity)
  {
    if (c(paramMessageEntity))
    {
      if (!paramMessageEntity.hasExtraStatus())
        paramMessageEntity.setExtraStatus(10);
      paramMessageEntity.addExtraFlag(18);
    }
  }

  public static boolean d(int paramInt)
  {
    return paramInt != 0;
  }

  public static boolean d(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    return (!paramConversationItemLoaderEntity.isDisabledConversation()) && (!paramConversationItemLoaderEntity.isCommunityBlocked()) && ((cd.b(paramConversationItemLoaderEntity.getGroupRole())) || (paramConversationItemLoaderEntity.isDisplayInvitationLinkToAll()));
  }

  public static int e(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if ((paramConversationItemLoaderEntity != null) && (d(paramConversationItemLoaderEntity)))
    {
      if (b())
        return 1;
      return 2;
    }
    return 0;
  }

  public static void e(MessageEntity paramMessageEntity)
  {
    Pin localPin;
    if (paramMessageEntity.getMimeType() == 0)
    {
      localPin = paramMessageEntity.getMessageInfo().getPin();
      if (localPin != null)
      {
        if (!paramMessageEntity.isPgForwardedMessage())
          break label55;
        MsgInfo localMsgInfo = paramMessageEntity.getMessageInfo();
        localMsgInfo.setPin(null);
        paramMessageEntity.setRawMessageInfo(com.viber.voip.flatbuffers.b.e.a().b().a(localMsgInfo));
      }
    }
    label55: 
    do
    {
      return;
      paramMessageEntity.addExtraFlag(32);
      paramMessageEntity.setBucket(localPin.getAction().getTypeName());
    }
    while ((e(paramMessageEntity.getConversationType())) || (Pin.a.DELETE != localPin.getAction()));
    paramMessageEntity.setUnread(0);
  }

  public static boolean e(int paramInt)
  {
    return (a(paramInt)) || (b(paramInt));
  }

  public static boolean e(String paramString)
  {
    return "image/gif".equals(paramString);
  }

  public static void f(MessageEntity paramMessageEntity)
  {
    if (paramMessageEntity.getMessageInfo().getPttVersion() >= 3)
    {
      paramMessageEntity.setMimeType(1009);
      AudioPttInfo localAudioPttInfo = paramMessageEntity.getMessageInfo().getAudioPttInfo();
      if (localAudioPttInfo != null)
        paramMessageEntity.setDuration(localAudioPttInfo.getDuration());
    }
  }

  public static boolean f(int paramInt)
  {
    return paramInt == 1;
  }

  public static void g(MessageEntity paramMessageEntity)
  {
    if ((paramMessageEntity.getMessageInfo() == null) || (paramMessageEntity.getMessageInfo().getFileInfo() == null));
    while ((!a()) || (!as.f.a().equals(paramMessageEntity.getMessageInfo().getFileInfo().getFileExt())))
      return;
    paramMessageEntity.setMimeType(1010);
  }

  public static boolean g(int paramInt)
  {
    return paramInt == 0;
  }

  public static int h(MessageEntity paramMessageEntity)
  {
    if (paramMessageEntity.isForwardedMessage())
    {
      if (paramMessageEntity.isForwardedFromPG())
        return 2;
      return 1;
    }
    return 0;
  }

  public static String h(int paramInt)
  {
    if (paramInt >= 1000)
    {
      int i = paramInt / 1000;
      int j = 9;
      StringBuilder localStringBuilder = new StringBuilder();
      if (i > j);
      while (true)
      {
        return j + "k+";
        j = i;
      }
    }
    return String.valueOf(paramInt);
  }

  public static String i(MessageEntity paramMessageEntity)
  {
    Object localObject = paramMessageEntity.getRawMessageInfo();
    if ((paramMessageEntity.isCommunityType()) && (!paramMessageEntity.isRichMessage()))
    {
      MsgInfo localMsgInfo = paramMessageEntity.getMessageInfo();
      TechInfo localTechInfo = localMsgInfo.getTechInfo();
      if (localMsgInfo.getTechInfo() == null)
        localTechInfo = new TechInfo();
      localTechInfo.setSeq(paramMessageEntity.getMessageSeq());
      localMsgInfo.setTechInfo(localTechInfo);
      localObject = com.viber.voip.flatbuffers.b.e.a().b().a(localMsgInfo);
    }
    JSONObject localJSONObject1;
    if ((paramMessageEntity.isForwardedMessage()) && (!av.d(paramMessageEntity.getFlag(), 4096)) && (((String)localObject).contains("MediaMetadata")))
    {
      localJSONObject1 = com.viber.voip.flatbuffers.b.e.a().b().b((String)localObject);
      if (localJSONObject1 == null);
    }
    try
    {
      JSONObject localJSONObject2 = localJSONObject1.getJSONObject("MediaMetadata");
      localJSONObject2.remove("EncParams");
      if (localJSONObject2.length() == 0)
        localJSONObject1.remove("MediaMetadata");
      String str = localJSONObject1.toString();
      localObject = str;
      return localObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return localObject;
  }

  public static boolean i(int paramInt)
  {
    return paramInt > 2;
  }

  public static int j(MessageEntity paramMessageEntity)
  {
    int i = 1;
    boolean bool = paramMessageEntity.isResendMessage();
    long l = paramMessageEntity.getExtraFlags();
    int j = paramMessageEntity.getMimeType();
    if (av.c(l, i));
    while (true)
    {
      if (1003 == j)
      {
        i |= 32;
        label39: switch (h(paramMessageEntity))
        {
        default:
        case 1:
        case 2:
        }
      }
      while (true)
      {
        if (bool)
          i |= 16;
        if (paramMessageEntity.isActiveOneToOneBroadcast())
          i |= 128;
        return i;
        if (!av.c(l, 2))
          break label132;
        i = 2;
        break;
        if (1004 != j)
          break label39;
        i |= 64;
        break label39;
        i |= 4;
        continue;
        i |= 8;
      }
      label132: i = 0;
    }
  }

  public static String j(int paramInt)
  {
    return ViberApplication.getInstance().getEngine(true).getPhoneController().getExternalAppPhone(paramInt);
  }

  public static long k(MessageEntity paramMessageEntity)
  {
    long l;
    if (paramMessageEntity.isForwardedFromCommunity())
    {
      l = 16L;
      if ((paramMessageEntity.isTextMessage()) && (!paramMessageEntity.isReplyToBot()))
        break label32;
    }
    label134: label140: 
    while (true)
    {
      return l;
      l = 0L;
      break;
      label32: Pin localPin = paramMessageEntity.getMessageInfo().getPin();
      label58: TextMetaInfo[] arrayOfTextMetaInfo;
      int i;
      if (localPin != null)
      {
        if (Pin.a.CREATE == localPin.getAction())
          l |= 1L;
      }
      else
      {
        if (!b(paramMessageEntity.getConversationType()))
          break label134;
        arrayOfTextMetaInfo = paramMessageEntity.getMessageInfo().getTextMetaInfo();
        if (arrayOfTextMetaInfo == null)
          continue;
        i = arrayOfTextMetaInfo.length;
      }
      for (int j = 0; ; j++)
      {
        if (j >= i)
          break label140;
        if (arrayOfTextMetaInfo[j].getType() == TextMetaInfo.a.MENTION)
        {
          return l | 0x4;
          if (Pin.a.DELETE != localPin.getAction())
            break label58;
          l |= 2L;
          break label58;
          break;
        }
      }
    }
  }

  public static boolean k(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 8);
  }

  public static int l(int paramInt)
  {
    if (paramInt > 1)
      return paramInt;
    return 1;
  }

  public static boolean l(MessageEntity paramMessageEntity)
  {
    return (paramMessageEntity != null) && (!paramMessageEntity.isDeleted()) && (1008 != paramMessageEntity.getMimeType()) && (paramMessageEntity.isVisibleMessage()) && (!paramMessageEntity.isEmpty());
  }

  public static int m(MessageEntity paramMessageEntity)
  {
    int i = 0;
    String str;
    Iterator localIterator;
    switch (paramMessageEntity.getMimeType())
    {
    default:
      str = "";
      if (!da.a(str))
        localIterator = com.viber.voip.util.links.f.b().b(str).iterator();
      break;
    case 0:
    case 1:
    case 1003:
      while (true)
      {
        if (!localIterator.hasNext())
          break label175;
        LinkParser.LinkSpec localLinkSpec = (LinkParser.LinkSpec)localIterator.next();
        switch (3.a[localLinkSpec.type.ordinal()])
        {
        default:
          break;
        case 1:
          i = av.e(i, 2);
          continue;
          str = paramMessageEntity.getBody();
          i = 0;
          break;
          i = av.e(0, 1);
          str = paramMessageEntity.getDescription();
          break;
        case 2:
          i = av.e(i, 4);
          break;
        case 3:
          i = av.e(i, 8);
        }
      }
    }
    label175: return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.m
 * JD-Core Version:    0.6.2
 */