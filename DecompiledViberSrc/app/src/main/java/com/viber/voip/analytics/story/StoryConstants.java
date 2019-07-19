package com.viber.voip.analytics.story;

import android.annotation.SuppressLint;
import com.viber.jni.messenger.MessengerDelegate;
import com.viber.voip.R.id;
import com.viber.voip.analytics.story.b.f;
import com.viber.voip.backup.a;
import com.viber.voip.contacts.b.b;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.Quote;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.PublicAccountMsgInfo;
import com.viber.voip.messages.controller.publicaccount.BotReplyRequest;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.m;
import com.viber.voip.messages.ui.MessagesFragmentModeManager.b;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.registration.ActivationController.b;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.storage.repository.MediaFileType;
import com.viber.voip.ui.j.ax;
import com.viber.voip.util.LongSparseSet;
import com.viber.voip.util.av;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class StoryConstants
{
  public static final String NO = "no";
  public static final String NOT_AVAILABLE = "N/A";
  public static final int NUMBER_OF_PARTICIPANTS_IN_1ON1_CHAT = 2;
  public static final String ONE_ON_ONE_CHAT_NAME = "1on1 chat";
  public static final String VALUE_CHANGED_UNAVAILABLE = "Value Changed Unavailable";
  public static final String YES = "yes";

  @Retention(RetentionPolicy.SOURCE)
  public static @interface a
  {
    public static class a
    {
      public static String a(ActivationController.b paramb)
      {
        switch (StoryConstants.1.c[paramb.ordinal()])
        {
        default:
          return "SMS Automatically";
        case 1:
          return "QR";
        case 2:
          return "Manual Code";
        case 3:
          return "Tzintuk";
        case 4:
        }
        return "URL Scheme";
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface aa
  {
    public static class a
    {
      public static String a(int paramInt)
      {
        switch (paramInt)
        {
        default:
          return "World Credits";
        case 0:
        }
        return "Plans";
      }

      public static String a(String paramString)
      {
        if ("world credits".equals(paramString))
          return "World Credits";
        return "Plans";
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface ab
  {
    public static class a
    {
      public static String a(ax paramax)
      {
        switch (StoryConstants.1.e[paramax.ordinal()])
        {
        default:
          return "OFF";
        case 1:
        }
        return "ON";
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface b
  {
    public static class a
    {
      public static String a(ax paramax)
      {
        switch (StoryConstants.1.e[paramax.ordinal()])
        {
        default:
          return "Default";
        case 1:
        }
        return "Viber Dark";
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface c
  {
    public static class a
    {
      public static String a(a parama)
      {
        switch (StoryConstants.1.b[parama.ordinal()])
        {
        default:
          return "off";
        case 1:
          return "Daily";
        case 2:
          return "Weekly";
        case 3:
        }
        return "Monthly";
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface d
  {
    public static class a
    {
      public static String a(int paramInt)
      {
        if (paramInt == 1)
          return "Manual";
        return "Auto Backup";
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface e
  {
    public static class a
    {
      public static String a(f paramf)
      {
        if (paramf.g())
          return "Free Video";
        if (paramf.a())
          return "Group Audio Call";
        if (paramf.d())
          return "VLN";
        if (paramf.b())
          return "Viber In";
        if (paramf.c())
          return "Viber Out";
        return "Free Audio 1-On-1 Call";
      }

      public static String a(CallInfo paramCallInfo)
      {
        if (paramCallInfo.isIncomingVideoCall())
          return "Free Video";
        if (paramCallInfo.isConference())
          return "Group Audio Call";
        if (paramCallInfo.isVln())
          return "VLN";
        if (paramCallInfo.isViberIn())
          return "Viber In";
        if (paramCallInfo.isViberOut())
          return "Viber Out";
        return "Free Audio 1-On-1 Call";
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface f
  {
    public static class a
    {
      public static String a(int paramInt)
      {
        if (paramInt == 3)
          return "Member";
        if (paramInt == 2)
          return "Super Admin";
        return "Admin";
      }

      public static String a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
      {
        int i = paramConversationItemLoaderEntity.getGroupRole();
        if (paramConversationItemLoaderEntity.isDisabledConversation())
          return "Removed from Chat";
        if (paramConversationItemLoaderEntity.isCommunityType())
        {
          if (i == 3)
            return "Member";
          if (i == 2)
            return "Super Admin";
          return "Admin";
        }
        if (paramConversationItemLoaderEntity.isPublicGroupType())
        {
          if (i == 3)
          {
            if (paramConversationItemLoaderEntity.getConversationType() == 3)
              return "Viewer";
            return "Follower";
          }
          if (i == 2)
            return "Admin";
          return "Participant";
        }
        if ((paramConversationItemLoaderEntity.isGroupBehavior()) && (i == 2))
          return "Admin";
        return "Participant";
      }

      public static String a(h paramh)
      {
        int i = paramh.p();
        if (paramh.K())
          return "Removed from Chat";
        if (paramh.g())
          return a(i);
        if (paramh.d())
        {
          if (i == 3)
          {
            if (paramh.j() == 3)
              return "Viewer";
            return "Follower";
          }
          if (i == 2)
            return "Admin";
          return "Participant";
        }
        if ((paramh.b()) && (i == 2))
          return "Admin";
        return "Participant";
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface g
  {
    public static class a
    {
      private static String a(int paramInt, boolean paramBoolean)
      {
        if (MessengerDelegate.VIBER_SYSTEM_IDS.contains(paramInt))
          return "System Message";
        if (paramBoolean)
          return "Business Message Two Way";
        return "Business Message One Way";
      }

      static String a(BotReplyRequest paramBotReplyRequest)
      {
        if (paramBotReplyRequest.isPublicAccount)
          return "Bot";
        if (paramBotReplyRequest.isSystemConversation)
          return "System Message";
        if (m.b(paramBotReplyRequest.conversationType))
          return "Community";
        if (m.d(paramBotReplyRequest.conversationType))
          return "Group Chat";
        return "1-on-1";
      }

      public static String a(BotReplyRequest paramBotReplyRequest, boolean paramBoolean)
      {
        if (paramBoolean)
          return "M2M Chat";
        return a(paramBotReplyRequest);
      }

      public static String a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
      {
        if (paramConversationItemLoaderEntity.isBroadcastListType())
          return "Broadcast";
        if (paramConversationItemLoaderEntity.isOneToOneWithPublicAccount())
          return "Bot";
        if (paramConversationItemLoaderEntity.isSystemConversation())
          return a(paramConversationItemLoaderEntity.getAppId(), paramConversationItemLoaderEntity.isSystemReplyableChat());
        if ((paramConversationItemLoaderEntity.isSecret()) && (paramConversationItemLoaderEntity.isHiddenConversation()) && (paramConversationItemLoaderEntity.isGroupBehavior()))
          return "Hidden Secret Group Chat";
        if ((paramConversationItemLoaderEntity.isSecret()) && (paramConversationItemLoaderEntity.isHiddenConversation()) && (paramConversationItemLoaderEntity.isConversation1on1()))
          return "Hidden Secret 1-on-1 Chat";
        if ((paramConversationItemLoaderEntity.isHiddenConversation()) && (paramConversationItemLoaderEntity.isGroupBehavior()))
          return "Hidden Group Chat";
        if ((paramConversationItemLoaderEntity.isHiddenConversation()) && (paramConversationItemLoaderEntity.isConversation1on1()))
          return "Hidden 1-on-1 Chat";
        if ((paramConversationItemLoaderEntity.isSecret()) && (paramConversationItemLoaderEntity.isGroupBehavior()))
          return "Secret Group Chat";
        if (paramConversationItemLoaderEntity.isSecret())
          return "Secret Chat 1-on-1";
        if (paramConversationItemLoaderEntity.isPublicGroupType())
          return "Public Account";
        if (paramConversationItemLoaderEntity.isCommunityType())
          return "Community";
        if (paramConversationItemLoaderEntity.isGroupBehavior())
          return "Group Chat";
        if (paramConversationItemLoaderEntity.isAnonymous())
          return "M2M Chat";
        return "1-on-1";
      }

      public static String a(ConversationLoaderEntity paramConversationLoaderEntity)
      {
        if (paramConversationLoaderEntity.isBroadcastListType())
          return "Broadcast";
        if (paramConversationLoaderEntity.isOneToOneWithPublicAccount())
          return "Bot";
        if (paramConversationLoaderEntity.isSystemConversation())
          return a(paramConversationLoaderEntity.getAppId(), paramConversationLoaderEntity.isSystemReplyableChat());
        if ((paramConversationLoaderEntity.isSecret()) && (paramConversationLoaderEntity.isHiddenConversation()) && (paramConversationLoaderEntity.isGroupBehavior()))
          return "Hidden Secret Group Chat";
        if ((paramConversationLoaderEntity.isSecret()) && (paramConversationLoaderEntity.isHiddenConversation()) && (paramConversationLoaderEntity.isConversation1on1()))
          return "Hidden Secret 1-on-1 Chat";
        if ((paramConversationLoaderEntity.isHiddenConversation()) && (paramConversationLoaderEntity.isGroupBehavior()))
          return "Hidden Group Chat";
        if ((paramConversationLoaderEntity.isHiddenConversation()) && (paramConversationLoaderEntity.isConversation1on1()))
          return "Hidden 1-on-1 Chat";
        if ((paramConversationLoaderEntity.isSecret()) && (paramConversationLoaderEntity.isGroupBehavior()))
          return "Secret Group Chat";
        if (paramConversationLoaderEntity.isSecret())
          return "Secret Chat 1-on-1";
        if (paramConversationLoaderEntity.isPublicGroupType())
          return "Public Account";
        if (paramConversationLoaderEntity.isCommunityType())
          return "Community";
        if (paramConversationLoaderEntity.isGroupBehavior())
          return "Group Chat";
        if (paramConversationLoaderEntity.isAnonymous())
          return "M2M Chat";
        return "1-on-1";
      }

      public static String a(aa paramaa)
      {
        if (paramaa.aU())
          return "Broadcast";
        if (paramaa.V())
          return "Bot";
        if (paramaa.O())
          return "System Message";
        if (paramaa.aa())
        {
          if (paramaa.T())
            return "Business Message Two Way";
          return "Business Message One Way";
        }
        if ((paramaa.ag()) && (paramaa.X()) && (paramaa.aR()))
          return "Hidden Secret Group Chat";
        if ((paramaa.ag()) && (paramaa.X()) && (paramaa.Q()))
          return "Hidden Secret 1-on-1 Chat";
        if ((paramaa.X()) && (paramaa.aR()))
          return "Hidden Group Chat";
        if ((paramaa.X()) && (paramaa.Q()))
          return "Hidden 1-on-1 Chat";
        if ((paramaa.ag()) && (paramaa.aR()))
          return "Secret Group Chat";
        if (paramaa.ag())
          return "Secret Chat 1-on-1";
        if (paramaa.aT())
          return "Public Account";
        if (paramaa.aV())
          return "Community";
        if (paramaa.aR())
          return "Group Chat";
        return "1-on-1";
      }

      public static String a(aa paramaa, boolean paramBoolean)
      {
        if (paramBoolean)
          return "M2M Chat";
        return a(paramaa);
      }

      public static String a(MessagesFragmentModeManager.b paramb)
      {
        boolean bool1 = av.c(paramb.h, 24);
        boolean bool2 = av.c(paramb.h, 15);
        if (m.c(paramb.f))
          return "Broadcast";
        if (av.c(paramb.h, 19))
          return "Bot";
        if (av.c(paramb.h, 0))
        {
          boolean bool3 = av.c(paramb.h, 13);
          return a(paramb.i, bool3);
        }
        if ((bool1) && (bool2) && (m.d(paramb.f)))
          return "Hidden Secret Group Chat";
        if ((bool1) && (bool2) && (m.g(paramb.f)))
          return "Hidden Secret 1-on-1 Chat";
        if ((bool2) && (m.d(paramb.f)))
          return "Hidden Group Chat";
        if ((bool2) && (m.g(paramb.f)))
          return "Hidden 1-on-1 Chat";
        if ((bool1) && (m.d(paramb.f)))
          return "Secret Group Chat";
        if (bool1)
          return "Secret Chat 1-on-1";
        if (m.a(paramb.f))
          return "Public Account";
        if (m.b(paramb.f))
          return "Community";
        if (m.d(paramb.f))
          return "Group Chat";
        return "1-on-1";
      }

      static String a(MessageEntity paramMessageEntity)
      {
        if (paramMessageEntity.isBroadcastList())
          return "Broadcast";
        if (paramMessageEntity.isOneToOneChatWithPa())
          return "Bot";
        if (paramMessageEntity.isSystemMessage())
          return "System Message";
        if (paramMessageEntity.isExternalAppMessage())
        {
          if (paramMessageEntity.isSystemReplyableMessage())
            return "Business Message Two Way";
          return "Business Message One Way";
        }
        if ((paramMessageEntity.isSecretMessage()) && (paramMessageEntity.isHiddenChat()) && (paramMessageEntity.isGroupBehavior()))
          return "Hidden Secret Group Chat";
        if ((paramMessageEntity.isSecretMessage()) && (paramMessageEntity.isHiddenChat()) && (paramMessageEntity.isOneToOneType()))
          return "Hidden Secret 1-on-1 Chat";
        if ((paramMessageEntity.isHiddenChat()) && (paramMessageEntity.isGroupBehavior()))
          return "Hidden Group Chat";
        if ((paramMessageEntity.isHiddenChat()) && (paramMessageEntity.isOneToOneType()))
          return "Hidden 1-on-1 Chat";
        if ((paramMessageEntity.isSecretMessage()) && (paramMessageEntity.isGroupBehavior()))
          return "Secret Group Chat";
        if (paramMessageEntity.isSecretMessage())
          return "Secret Chat 1-on-1";
        if (paramMessageEntity.isPublicGroupType())
          return "Public Account";
        if (paramMessageEntity.isCommunityType())
          return "Community";
        if (paramMessageEntity.isGroupBehavior())
          return "Group Chat";
        return "1-on-1";
      }

      public static String a(MessageEntity paramMessageEntity, boolean paramBoolean)
      {
        if (paramBoolean)
          return "M2M Chat";
        return a(paramMessageEntity);
      }

      public static String a(MessageEntity paramMessageEntity, boolean paramBoolean1, boolean paramBoolean2)
      {
        if (paramBoolean2)
          return "Business Message Two Way";
        return a(paramMessageEntity, paramBoolean1);
      }

      static String a(h paramh)
      {
        if (paramh.h())
          return "Broadcast";
        if (paramh.G())
          return "Bot";
        if (paramh.D())
          return a(paramh.l(), paramh.F());
        if ((paramh.R()) && (paramh.I()) && (paramh.b()))
          return "Hidden Secret Group Chat";
        if ((paramh.R()) && (paramh.I()) && (paramh.a()))
          return "Hidden Secret 1-on-1 Chat";
        if ((paramh.I()) && (paramh.b()))
          return "Hidden Group Chat";
        if ((paramh.I()) && (paramh.a()))
          return "Hidden 1-on-1 Chat";
        if ((paramh.R()) && (paramh.b()))
          return "Secret Group Chat";
        if (paramh.R())
          return "Secret Chat 1-on-1";
        if (paramh.d())
          return "Public Account";
        if (paramh.g())
          return "Community";
        if (paramh.b())
          return "Group Chat";
        return "1-on-1";
      }

      public static String a(h paramh, boolean paramBoolean)
      {
        if (paramBoolean)
          return "M2M Chat";
        return a(paramh);
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface h
  {
    public static class a
    {
      public static String a(b.b paramb)
      {
        switch (StoryConstants.1.a[paramb.ordinal()])
        {
        default:
          return "All";
        case 1:
        case 2:
        }
        return "Viber";
      }
    }
  }

  public static @interface i
  {
    public static class a
    {
      @StoryConstants.i
      public static String a(aa paramaa)
      {
        if ((paramaa.az()) || (paramaa.aA()))
          return "Caption";
        if (paramaa.aL())
          return "URL";
        return "Text";
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface j
  {
    public static class a
    {
      public static String a(int paramInt)
      {
        switch (paramInt)
        {
        default:
          return "Other";
        case 0:
          return "Profile Notification - Name";
        case 1:
          return "Profile Notification - Photo";
        case 2:
        }
        return "Profile Notification - Complete Profile";
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface k
  {
    public static class a
    {
      public static String a(int paramInt)
      {
        switch (paramInt)
        {
        case 5:
        case 7:
        case 8:
        case 10:
        case 11:
        default:
          return "Ended";
        case 1:
          return "Busy";
        case 3:
          return "Ended";
        case 2:
          return "Failed";
        case 4:
          return "Disconnected";
        case 9:
          return "Transferred";
        case 6:
          return "Timeout";
        case 12:
          return "No Credit";
        case 13:
        }
        return "Unsupported User Alert";
      }
    }
  }

  public static @interface l
  {
    public static class a
    {
      @SuppressLint({"SwitchIntDef"})
      public static String a(int paramInt)
      {
        switch (paramInt)
        {
        default:
          return "Settings";
        case 0:
        case 6:
        }
        return "URL Scheme";
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface m
  {
    public static class a
    {
      public static String a(aa paramaa)
      {
        switch (paramaa.q())
        {
        default:
        case 3:
        case 14:
        case 1009:
        case 7:
        case 8:
        case 1005:
        case 1:
        case 10:
        case 5:
        case 9:
        case 4:
        case 0:
        }
        do
        {
          return "";
          return "Play Video";
          return "Play Video";
          return "Play Audio";
          return "Open Browser";
          return "Play Gif";
          return "Open Image";
          return "Open File";
          return "Open Location";
          return "View Contact";
          if ((paramaa.bn() != null) && (paramaa.bn().isAnimated()))
            return "Play Animation";
        }
        while (!paramaa.an());
        return "Vote";
      }
    }
  }

  public static @interface n
  {
    public static class a
    {
      @StoryConstants.n
      public static String a(MessageEntity paramMessageEntity)
      {
        if (paramMessageEntity.isForwardedMessage())
          return "Forward";
        Quote localQuote = paramMessageEntity.getQuote();
        if (localQuote == null)
          return null;
        if (localQuote.getReplySource() == 1)
          return "Quick Reply";
        return "Reply";
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface o
  {
    public static class a
    {
      public static String a(MessageEntity paramMessageEntity)
      {
        if (paramMessageEntity.isForwardedMessage())
          return "In-app Share";
        return "Keyboard";
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface p
  {
    public static class a
    {
      public static String a(int paramInt)
      {
        if (paramInt == 1)
          return "1";
        if (paramInt == 3)
          return "3";
        if (paramInt == 7)
          return "7";
        if (paramInt == 10)
          return "10";
        return "No time limit";
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface q
  {
    public static class a
    {
      public static String a(aa paramaa)
      {
        if (paramaa.V())
          return "Bot Message";
        if (paramaa.bx().getPublicAccountMsgInfo().getPublicAccountInfo() != null)
          return "Chat Extension Service";
        if (paramaa.P())
          return "VLN Message";
        if (paramaa.an())
          return "Poll";
        if ((paramaa.aM()) || (paramaa.aH()))
          return "Gif";
        if (paramaa.aL())
          return "URL";
        if (paramaa.aY())
          return "Text";
        if ((paramaa.az()) && (!paramaa.aD()))
          return "Photo";
        if ((paramaa.aA()) && (!paramaa.aD()))
          return "Video";
        if (paramaa.ax())
          return "Sticker";
        if (paramaa.ay())
          return "Location";
        if (paramaa.aE())
          return "Formatted Message";
        if (paramaa.aD())
          return "Wink";
        if (paramaa.aI())
          return "PTT Message";
        if (paramaa.aK())
          return "Instant Video";
        if (paramaa.aG())
          return "File";
        return "Text";
      }

      public static String a(MessageEntity paramMessageEntity)
      {
        if (paramMessageEntity.getMessageInfo().getPublicAccountMsgInfo().getPublicAccountInfo() != null)
          return "Chat Extension Service";
        if (paramMessageEntity.isVlnMessage())
          return "VLN Message";
        if (paramMessageEntity.isPoll())
          return "Poll";
        if ((paramMessageEntity.isGifUrlMessage()) || (paramMessageEntity.isGifFile()))
          return "Gif";
        if (paramMessageEntity.isUrlMessage())
          return "URL";
        if (paramMessageEntity.isTextMessage())
          return "Text";
        if ((paramMessageEntity.isImage()) && (!paramMessageEntity.isWink()))
          return "Photo";
        if ((paramMessageEntity.isVideo()) && (!paramMessageEntity.isWink()))
          return "Video";
        if (paramMessageEntity.isSticker())
          return "Sticker";
        if (paramMessageEntity.isLocationMessage())
          return "Location";
        if (paramMessageEntity.isFormattedMessage())
          return "Formatted Message";
        if (paramMessageEntity.isWink())
          return "Wink";
        if (paramMessageEntity.isVoiceMessage())
          return "PTT Message";
        if (paramMessageEntity.isVideoPttBehavior())
          return "Instant Video";
        if (paramMessageEntity.isFile())
          return "File";
        return "Text";
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface r
  {
    public static class a
    {
      public static String a(boolean paramBoolean)
      {
        if (paramBoolean)
          return "Internal Browser";
        return "External Browser";
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface s
  {
    public static class a
    {
      public static String a(int paramInt)
      {
        if (paramInt == R.id.market)
          return "Sticker Packs";
        if (paramInt == R.id.settings)
          return "Settings";
        return null;
      }

      public static String b(int paramInt)
      {
        switch (paramInt)
        {
        default:
          return null;
        case 0:
          return "Profile Notification - Name";
        case 1:
          return "Profile Notification - Photo";
        case 2:
        }
        return "Profile Notification - Complete Profile";
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface t
  {
    public static class a
    {
      public static String a(int paramInt)
      {
        switch (paramInt)
        {
        default:
          return null;
        case 0:
          return "Name Notification";
        case 1:
          return "Photo Notification";
        case 2:
        }
        return "Complete Profile Notification";
      }

      public static String b(int paramInt)
      {
        if (paramInt == R.id.discover)
          return "Discover";
        if (paramInt == R.id.news)
          return "Viber News";
        if (paramInt == R.id.share)
          return "Invite Friends";
        if (paramInt == R.id.viber_out)
          return "Viber Out";
        if (paramInt == R.id.viber_local_number)
          return "VLN";
        if (paramInt == R.id.rakuten_account)
          return "Get Rakuten Superpoints";
        if (paramInt == R.id.market)
          return "Sticker Market";
        if (paramInt == R.id.add_friend)
          return "Add Contact";
        if (paramInt == R.id.settings)
          return "Settings";
        if (paramInt == R.id.desktop_and_tablets)
          return "Viber for Desktop & Tablets";
        if (paramInt == R.id.open_wallet)
          return "Send Money";
        if (paramInt == R.id.about)
          return "About Viber";
        return null;
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface u
  {
    public static class a
    {
      public static String a(String paramString)
      {
        int i = -1;
        switch (paramString.hashCode())
        {
        default:
        case 108960:
        case 3151468:
        case 1853891989:
        }
        while (true)
          switch (i)
          {
          default:
            return "Top";
            if (paramString.equals("new"))
            {
              i = 0;
              continue;
              if (paramString.equals("free"))
              {
                i = 1;
                continue;
                if (paramString.equals("collections"))
                  i = 2;
              }
            }
            break;
          case 0:
          case 1:
          case 2:
          }
        return "New";
        return "Free";
        return "Collections";
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface v
  {
    public static class a
    {
      public static String a(aa paramaa)
      {
        if (paramaa.aZ())
          return "Rich Message";
        if (paramaa.aL())
          return "URL Message";
        return "";
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface w
  {
    public static class a
    {
      public static String a(Sticker paramSticker)
      {
        if (!paramSticker.isAnimated());
        boolean bool;
        for (int i = 1; ; i = 0)
        {
          bool = paramSticker.hasSound();
          if ((i == 0) || (!bool))
            break;
          return "Static with sound";
        }
        if ((i == 0) && (bool))
          return "Animated with sound";
        if (i == 0)
          return "Animated";
        return "Static";
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface x
  {
    public static class a
    {
      public static String a(boolean paramBoolean)
      {
        if (paramBoolean)
          return "Primary";
        return "Secondary";
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface y
  {
    public static class a
    {
      public static String a(String paramString1, String paramString2)
      {
        if (paramString2 == null)
          return null;
        int i = -1;
        switch (paramString2.hashCode())
        {
        default:
        case 100343516:
        case 3541555:
        }
        while (true)
          switch (i)
          {
          default:
            return null;
          case 0:
            if (!"calling_plan".equals(paramString1))
              break label106;
            return "30 day";
            if (paramString2.equals("inapp"))
            {
              i = 0;
              continue;
              if (paramString2.equals("subs"))
                i = 1;
            }
            break;
          case 1:
          }
        label106: return "world credits";
        return "subscription";
      }

      public static String a(String paramString, boolean paramBoolean)
      {
        if ((paramString != null) && (paramString.contains("/")))
          return "subscription";
        if (paramBoolean)
          return "30 day";
        return "world credits";
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface z
  {
    public static class a
    {
      public static String a(int paramInt)
      {
        if (paramInt == 1)
          return "world credits";
        return "plans";
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.StoryConstants
 * JD-Core Version:    0.6.2
 */