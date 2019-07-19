package com.viber.voip.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.ParcelableSpan;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.viber.common.d.c;
import com.viber.jni.OnlineContactInfo;
import com.viber.jni.PublicAccountAttributes;
import com.viber.jni.PublicAccountInfo;
import com.viber.jni.im2.RecoveredPublicAccountInfo;
import com.viber.voip.R.attr;
import com.viber.voip.R.drawable;
import com.viber.voip.R.plurals;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.flatbuffers.model.msginfo.ExtendedInfo;
import com.viber.voip.flatbuffers.model.msginfo.Pin;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.ae;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.l;
import com.viber.voip.messages.ui.ai;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.model.entity.MessageCallEntity;
import com.viber.voip.model.entity.r;
import com.viber.voip.model.g;
import com.viber.voip.registration.af;
import com.viber.voip.ui.style.UserMentionSpan;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dg
{
  public static Resources a()
  {
    return ViberApplication.getLocalizedResources();
  }

  public static Spannable a(Context paramContext)
  {
    SpannableString localSpannableString = new SpannableString(paramContext.getString(R.string.new_feature));
    localSpannableString.setSpan(new ForegroundColorSpan(dc.d(paramContext, R.attr.newTextColor)), 0, localSpannableString.length(), 33);
    localSpannableString.setSpan(new StyleSpan(1), 0, localSpannableString.length(), 33);
    return localSpannableString;
  }

  public static Spanned a(Spanned paramSpanned)
  {
    int i = 0;
    if ((paramSpanned == null) || (paramSpanned.length() == 0))
      return paramSpanned;
    SpannableString localSpannableString = new SpannableString(paramSpanned);
    URLSpan[] arrayOfURLSpan = (URLSpan[])localSpannableString.getSpans(0, -1 + localSpannableString.length(), URLSpan.class);
    int j = arrayOfURLSpan.length;
    while (i < j)
    {
      URLSpan localURLSpan = arrayOfURLSpan[i];
      int k = localSpannableString.getSpanStart(localURLSpan);
      int m = localSpannableString.getSpanEnd(localURLSpan);
      localSpannableString.setSpan(new StyleSpan(1), k, m, 18);
      i++;
    }
    return localSpannableString;
  }

  private static CharSequence a(int paramInt1, String paramString1, String paramString2, ai paramai, com.viber.voip.messages.d.b paramb, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Object localObject;
    switch (paramInt1)
    {
    default:
      localObject = com.viber.voip.messages.c.b.a(l.a(paramInt1), paramString1);
    case 0:
    }
    do
    {
      return localObject;
      localObject = da.a(paramString1, paramai, paramb, paramString2, false, false, false, paramBoolean, aj.c, paramInt2, paramInt3);
    }
    while (!paramBoolean);
    a((SpannableString)localObject, UserMentionSpan.class);
    return localObject;
  }

  public static CharSequence a(Pin paramPin, String paramString, ai paramai, com.viber.voip.messages.d.b paramb, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ExtendedInfo localExtendedInfo = paramPin.getExtendedInfo();
    Object localObject;
    if (localExtendedInfo == null)
    {
      localObject = a(0, paramPin.getText(), paramString, paramai, paramb, paramInt1, paramInt2, paramBoolean);
      return localObject;
    }
    switch (paramPin.getMediaType())
    {
    default:
    case 1:
    case 3:
    case 8:
    case 10:
    }
    do
    {
      return a(paramPin.getMediaType(), paramPin.getText(), paramString, paramai, paramb, paramInt1, paramInt2, paramBoolean);
      localObject = localExtendedInfo.getDescription();
      if (!da.a((CharSequence)localObject))
        break;
      return com.viber.voip.messages.c.b.a(l.a(paramPin.getMediaType()), paramPin.getText());
    }
    while (!"gif".equals(localExtendedInfo.getFileExt()));
    return a().getString(R.string.message_type_gif);
  }

  public static CharSequence a(CharSequence paramCharSequence, int paramInt)
  {
    if (paramCharSequence == null)
      return paramCharSequence;
    return a(paramCharSequence, 0, paramCharSequence.length(), paramInt);
  }

  public static CharSequence a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 > paramInt2) || (paramCharSequence == null))
      return paramCharSequence;
    SpannableString localSpannableString = new SpannableString(paramCharSequence);
    localSpannableString.setSpan(new ForegroundColorSpan(paramInt3), paramInt1, paramInt2, 33);
    return localSpannableString;
  }

  public static String a(OnlineContactInfo paramOnlineContactInfo)
  {
    String str = null;
    if (paramOnlineContactInfo != null)
      str = x.a(ViberApplication.getLocalizedContext(), paramOnlineContactInfo.isOnLine, paramOnlineContactInfo.time);
    return str;
  }

  public static String a(PublicAccountAttributes paramPublicAccountAttributes)
  {
    String str = paramPublicAccountAttributes.getCrmName();
    if (paramPublicAccountAttributes.getWebHookExists() > 0);
    for (boolean bool = true; ; bool = false)
      return a(str, bool);
  }

  public static String a(PublicAccountInfo paramPublicAccountInfo)
  {
    return a(paramPublicAccountInfo.getCrmName(), paramPublicAccountInfo.isWebhookExists());
  }

  public static String a(RecoveredPublicAccountInfo paramRecoveredPublicAccountInfo)
  {
    return a(paramRecoveredPublicAccountInfo.crmName, paramRecoveredPublicAccountInfo.webhookExists);
  }

  public static String a(Pin paramPin)
  {
    ExtendedInfo localExtendedInfo = paramPin.getExtendedInfo();
    String str;
    if (localExtendedInfo == null)
    {
      str = paramPin.getText();
      return str;
    }
    switch (paramPin.getMediaType())
    {
    default:
    case 1:
    case 3:
    case 8:
    case 10:
    }
    do
    {
      return com.viber.voip.messages.c.b.a(l.a(paramPin.getMediaType()), paramPin.getText());
      str = localExtendedInfo.getDescription();
      if (!da.a(str))
        break;
      return com.viber.voip.messages.c.b.a(l.a(paramPin.getMediaType()), paramPin.getText());
    }
    while (!"gif".equals(localExtendedInfo.getFileExt()));
    return a().getString(R.string.message_type_gif);
  }

  public static String a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    return b(paramConversationItemLoaderEntity, paramConversationItemLoaderEntity.getConversationType(), paramConversationItemLoaderEntity.getGroupRole());
  }

  public static String a(ConversationLoaderEntity paramConversationLoaderEntity)
  {
    return b(paramConversationLoaderEntity, paramConversationLoaderEntity.getConversationType(), paramConversationLoaderEntity.getGroupRole());
  }

  public static String a(aa paramaa, int paramInt)
  {
    return b(paramaa, paramaa.A(), paramInt);
  }

  public static String a(ae paramae)
  {
    return b(paramae, 1, 0);
  }

  public static String a(ae paramae, int paramInt1, int paramInt2)
  {
    return b(paramae, paramInt1, paramInt2);
  }

  public static String a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
    return a(paramPublicGroupConversationItemLoaderEntity.getCrm(), paramPublicGroupConversationItemLoaderEntity.isWebhookExist());
  }

  public static String a(ConversationData paramConversationData)
  {
    return a(paramConversationData.isGroupBehavior(), paramConversationData.isBroadcastListType(), paramConversationData.groupName, paramConversationData.viberName, paramConversationData.contactName, paramConversationData.number);
  }

  public static String a(MessageCallEntity paramMessageCallEntity)
  {
    String str;
    if (paramMessageCallEntity.isTypeViberOut())
      str = "vo";
    while (true)
    {
      return a(str, 1);
      if (paramMessageCallEntity.isMissed())
      {
        if (paramMessageCallEntity.isTypeViberGeneralVideo())
          str = "missed_call_video";
        else if (paramMessageCallEntity.isTypeViberGroup())
          str = "missed_call_group";
        else
          str = "missed_call";
      }
      else if (paramMessageCallEntity.isAnswerredOnAnotherDevice())
      {
        if (paramMessageCallEntity.isTypeViberGroup())
          str = "answ_another_dev_group";
        else
          str = "answ_another_dev";
      }
      else if (paramMessageCallEntity.isTransferredIn())
        str = "transferred";
      else if (paramMessageCallEntity.isOutgoing())
      {
        if (paramMessageCallEntity.isTypeViberGeneralVideo())
          str = "outgoing_call_video";
        else
          str = "outgoing_call";
      }
      else if (paramMessageCallEntity.isTypeViberGeneralVideo())
        str = "incoming_call_video";
      else if (paramMessageCallEntity.isTypeViberGroup())
        str = "incoming_call_group";
      else
        str = "incoming_call";
    }
  }

  public static String a(com.viber.voip.model.entity.m paramm, int paramInt1, int paramInt2)
  {
    return a(paramm, paramInt1, paramInt2, false);
  }

  public static String a(com.viber.voip.model.entity.m paramm, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramm == null)
      return "";
    return a(paramm, paramInt1, paramInt2, paramBoolean);
  }

  public static String a(com.viber.voip.model.entity.m paramm, int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    String str1 = a().getString(R.string.unknown);
    if (paramm != null);
    for (String str2 = a(paramm, paramInt1, paramInt2, paramBoolean); ; str2 = str1)
    {
      if ((!paramBoolean) && (!da.a(paramString)) && (str1.equals(str2)))
        return paramString;
      return str2;
    }
  }

  public static String a(r paramr)
  {
    String str = paramr.p();
    if (paramr.L() > 0);
    for (boolean bool = true; ; bool = false)
      return a(str, bool);
  }

  public static String a(g paramg, int paramInt1, int paramInt2)
  {
    if (paramg == null)
      return a().getString(R.string.unknown);
    return a(paramg, paramInt1, paramInt2, false);
  }

  public static String a(g paramg, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return a(paramg.isOwner(), paramg.getViberName(), paramg.getContactName(), paramg.getNumber(), paramInt1, paramInt2, paramBoolean);
  }

  public static String a(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return paramCharSequence1 + " (" + c.a(paramCharSequence2) + ")";
  }

  public static String a(String paramString)
  {
    if ((da.a(paramString)) || ("private_number".equals(paramString)))
      paramString = a().getString(R.string.unknown);
    return paramString;
  }

  public static String a(String paramString, int paramInt)
  {
    int i;
    if ("vo".equals(paramString))
      i = R.plurals.plural_msg_call_viber_out;
    while (i > 0)
    {
      return a().getQuantityString(i, paramInt);
      if ("missed_call".equals(paramString))
        i = R.plurals.plural_msg_call_missed;
      else if ("missed_call_group".equals(paramString))
        i = R.plurals.plural_msg_call_missed;
      else if ("missed_call_video".equals(paramString))
        i = R.plurals.plural_msg_video_call_missed;
      else if ("answ_another_dev".equals(paramString))
        i = R.plurals.plural_msg_call_answered_on_another_device;
      else if ("transferred".equals(paramString))
        i = R.plurals.plural_msg_call_transferred;
      else if ("outgoing_call".equals(paramString))
        i = R.plurals.plural_msg_call_outgoing;
      else if ("outgoing_call_video".equals(paramString))
        i = R.plurals.plural_msg_video_call_outgoing;
      else if ("incoming_call".equals(paramString))
        i = R.plurals.plural_msg_call_incoming;
      else if ("incoming_call_group".equals(paramString))
        i = R.plurals.plural_msg_call_incoming;
      else if ("incoming_call_video".equals(paramString))
        i = R.plurals.plural_msg_video_call_incoming;
      else if ("answ_another_dev_group".equals(paramString))
        i = R.plurals.plural_msg_call_answered_on_another_device;
      else
        i = 0;
    }
    return "";
  }

  private static String a(String paramString, boolean paramBoolean)
  {
    if (paramString == null)
      paramString = null;
    while ((paramString.length() != 0) || (!paramBoolean))
      return paramString;
    return a().getString(R.string.crm_name_chat_api);
  }

  static String a(boolean paramBoolean1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    boolean bool = com.viber.voip.messages.m.e(paramInt1);
    int i;
    int j;
    label49: String str3;
    String str1;
    int k;
    String str2;
    if ((bool) && ((paramBoolean2) || (!cd.c(paramInt2))))
    {
      i = 1;
      if ((!paramBoolean2) && ((!bool) || (!cd.f(paramInt2))))
        break label111;
      j = 1;
      if (!paramBoolean1)
        break label193;
      UserManager localUserManager = UserManager.from(ViberApplication.getApplication());
      str3 = localUserManager.getUserData().getViberName();
      str1 = localUserManager.getRegistrationValues().h();
      k = 0;
      str2 = "";
    }
    while (true)
    {
      if ((j == 0) && (!da.a(str2)))
      {
        return str2;
        i = 0;
        break;
        label111: j = 0;
        break label49;
      }
      if (!da.a(str3))
        return str3;
      if ((!da.a(str1)) && (ce.l.matcher(str1).matches()) && (k == 0))
        return str1;
      if ((!da.a(str1)) && (str1.toLowerCase().startsWith("viber")))
        return str1;
      return a().getString(R.string.unknown);
      label193: k = i;
      str1 = paramString3;
      str2 = paramString2;
      str3 = paramString1;
    }
  }

  private static String a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramBoolean2)
      return c(paramString1);
    if (paramBoolean1)
      return b(paramString1);
    return a(false, paramString2, paramString3, paramString4, 0, 0, false);
  }

  private static void a(SpannableString paramSpannableString, Class<? extends ParcelableSpan> paramClass)
  {
    int i = 0;
    if (paramSpannableString != null)
    {
      Object[] arrayOfObject = paramSpannableString.getSpans(0, paramSpannableString.length(), paramClass);
      if (!n.a(arrayOfObject))
      {
        int j = arrayOfObject.length;
        while (i < j)
        {
          Object localObject = arrayOfObject[i];
          int k = paramSpannableString.getSpanStart(localObject);
          int m = paramSpannableString.getSpanEnd(localObject);
          int n = paramSpannableString.getSpanFlags(localObject);
          paramSpannableString.removeSpan(localObject);
          if ((k >= 0) && (m >= 0))
            paramSpannableString.setSpan(new StyleSpan(2), k, m, n);
          i++;
        }
      }
    }
  }

  public static void a(View paramView, CharSequence paramCharSequence)
  {
  }

  public static void a(TextView paramTextView, int paramInt)
  {
    CharSequence localCharSequence = paramTextView.getContext().getResources().getText(paramInt);
    if (!localCharSequence.equals(paramTextView.getHint()))
      paramTextView.setHint(localCharSequence);
  }

  public static boolean a(TextView paramTextView, String paramString, int paramInt)
  {
    return a(paramTextView, paramString, paramInt, new dh(dc.d(paramTextView.getContext(), R.attr.highlightTextColor)));
  }

  private static boolean a(TextView paramTextView, String paramString, int paramInt, a parama)
  {
    if ((paramTextView.getText() == null) || (paramTextView.getText().length() == 0))
      return false;
    String str1 = paramTextView.getText().toString();
    int i = str1.toLowerCase().indexOf(paramString.toLowerCase());
    if (i == -1)
      return false;
    int j = i + paramString.length();
    int k;
    if (j > paramInt)
    {
      k = i - paramInt / 3;
      if (j - k <= paramInt)
        break label241;
      k += j - k - paramInt;
      if (k <= i)
        break label241;
    }
    while (true)
    {
      if (i != 0)
        str1 = "..." + str1.substring(i);
      paramTextView.setText(str1);
      String str2 = str1;
      if (!(paramTextView.getText() instanceof Spannable))
        paramTextView.setText(paramTextView.getText(), TextView.BufferType.SPANNABLE);
      Spannable localSpannable = (Spannable)paramTextView.getText();
      Matcher localMatcher = Pattern.compile(Pattern.quote(paramString.toLowerCase())).matcher(str2.toLowerCase());
      while (localMatcher.find())
        localSpannable.setSpan(parama.a(), localMatcher.start(), localMatcher.end(), 0);
      paramTextView.setText(localSpannable);
      return true;
      label241: i = k;
    }
  }

  public static String b(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if (paramConversationItemLoaderEntity == null)
      return "";
    return a(paramConversationItemLoaderEntity.isGroupBehavior(), paramConversationItemLoaderEntity.isBroadcastListType(), paramConversationItemLoaderEntity.getGroupName(), paramConversationItemLoaderEntity.getViberName(), paramConversationItemLoaderEntity.getContactName(), paramConversationItemLoaderEntity.getNumber());
  }

  public static String b(ConversationLoaderEntity paramConversationLoaderEntity)
  {
    if (paramConversationLoaderEntity == null)
      return "";
    return a(paramConversationLoaderEntity.isGroupBehavior(), paramConversationLoaderEntity.isBroadcastListType(), paramConversationLoaderEntity.getGroupName(), paramConversationLoaderEntity.getParticipantName(), paramConversationLoaderEntity.getContactName(), paramConversationLoaderEntity.getNumber());
  }

  public static String b(g paramg, int paramInt1, int paramInt2)
  {
    return a(paramg, paramInt1, paramInt2, false);
  }

  public static String b(String paramString)
  {
    if (da.a(paramString))
      paramString = a().getString(R.string.default_group_name);
    return paramString;
  }

  public static boolean b(TextView paramTextView, String paramString, int paramInt)
  {
    return a(paramTextView, paramString, paramInt, new di(paramTextView));
  }

  public static String c(String paramString)
  {
    if (da.a(paramString))
      paramString = a().getString(R.string.broadcast_list);
    return paramString;
  }

  public static int d(String paramString)
  {
    int i;
    if ("vo".equals(paramString))
      i = R.drawable.ic_conversation_viber_out_call;
    boolean bool;
    do
    {
      return i;
      if (("missed_call".equals(paramString)) || ("missed_call_group".equals(paramString)) || ("missed_call_video".equals(paramString)))
        return R.drawable.ic_conversation_incoming_call;
      if (("outgoing_call".equals(paramString)) || ("outgoing_call_video".equals(paramString)))
        return R.drawable.ic_conversation_outgoing_call;
      if (("incoming_call".equals(paramString)) || ("incoming_call_group".equals(paramString)))
        break;
      bool = "incoming_call_video".equals(paramString);
      i = 0;
    }
    while (!bool);
    return R.drawable.ic_conversation_incoming_call;
  }

  public static int e(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case 3769:
    case 1799862658:
    case 2143316354:
    case -2138077314:
    case 89080657:
    case 892746253:
    case -822844713:
    case -262377:
    case 13311251:
    case 859975915:
    case -1674318293:
    case -2008779578:
    }
    while (true)
      switch (i)
      {
      default:
        return 0;
        if (paramString.equals("vo"))
        {
          i = 0;
          continue;
          if (paramString.equals("missed_call"))
          {
            i = 1;
            continue;
            if (paramString.equals("missed_call_group"))
            {
              i = 2;
              continue;
              if (paramString.equals("missed_call_video"))
              {
                i = 3;
                continue;
                if (paramString.equals("outgoing_call"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("outgoing_call_video"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("incoming_call"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("incoming_call_group"))
                      {
                        i = 7;
                        continue;
                        if (paramString.equals("incoming_call_video"))
                        {
                          i = 8;
                          continue;
                          if (paramString.equals("answ_another_dev"))
                          {
                            i = 9;
                            continue;
                            if (paramString.equals("answ_another_dev_group"))
                            {
                              i = 10;
                              continue;
                              if (paramString.equals("transferred"))
                                i = 11;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 11:
      }
    return R.drawable.ic_chat_list_viber_out_call_inset;
    return R.drawable.ic_chat_list_incoming_call_inset;
    return R.drawable.ic_chat_list_outgoing_call_inset;
    return R.drawable.ic_chat_list_incoming_call_inset;
  }

  private static abstract interface a
  {
    public abstract CharacterStyle a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.dg
 * JD-Core Version:    0.6.2
 */