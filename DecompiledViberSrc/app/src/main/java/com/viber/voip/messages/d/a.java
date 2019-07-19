package com.viber.voip.messages.d;

import android.os.Build;
import com.viber.voip.ViberApplication;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.g.a.b;
import com.viber.voip.i.c.h;
import com.viber.voip.i.c.q;
import com.viber.voip.i.f;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.extensions.c;
import com.viber.voip.registration.af;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.bi;
import com.viber.voip.util.q;

public class a
{
  public static boolean a()
  {
    return !Build.BRAND.equals("Amazon");
  }

  public static boolean a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    com.viber.voip.wallet.a locala = ViberApplication.getInstance().getWalletController();
    return (paramConversationItemLoaderEntity != null) && (paramConversationItemLoaderEntity.isConversation1on1()) && (paramConversationItemLoaderEntity.getContactId() != 0L) && (locala.a(paramConversationItemLoaderEntity.getNumber()));
  }

  public static boolean a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, c paramc)
  {
    boolean bool1 = false;
    if (paramConversationItemLoaderEntity != null)
    {
      boolean bool2 = paramConversationItemLoaderEntity.canSendMessages(0);
      bool1 = false;
      if (bool2)
      {
        boolean bool3 = paramConversationItemLoaderEntity.isSecret();
        bool1 = false;
        if (!bool3)
        {
          boolean bool4 = paramConversationItemLoaderEntity.isOneToOneWithPublicAccount();
          bool1 = false;
          if (!bool4)
          {
            boolean bool5 = paramConversationItemLoaderEntity.isSystemConversation();
            bool1 = false;
            if (!bool5)
            {
              boolean bool6 = paramConversationItemLoaderEntity.isDisabledConversation();
              bool1 = false;
              if (!bool6)
              {
                boolean bool7 = paramConversationItemLoaderEntity.isBroadcastListType();
                bool1 = false;
                if (!bool7)
                {
                  boolean bool8 = paramc.b();
                  bool1 = false;
                  if (bool8)
                    bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }

  public static boolean a(boolean paramBoolean)
  {
    return (!paramBoolean) && (q.a());
  }

  public static boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return (!paramBoolean1) && (!paramBoolean2) && (!paramBoolean3);
  }

  public static boolean b()
  {
    return c.h.a.e();
  }

  public static boolean b(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    return (paramConversationItemLoaderEntity != null) && (!paramConversationItemLoaderEntity.isOneToOneWithPublicAccount()) && (!paramConversationItemLoaderEntity.isSystemReplyableChat()) && (!paramConversationItemLoaderEntity.isBroadcastListType()) && (ViberApplication.hasMicrophone());
  }

  public static boolean c()
  {
    return (com.viber.common.d.a.g()) && (c.h.b.e()) && (c.q.a.e());
  }

  public static boolean c(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    boolean bool1 = false;
    if (paramConversationItemLoaderEntity != null)
    {
      boolean bool2 = paramConversationItemLoaderEntity.canSendMessages(0);
      bool1 = false;
      if (bool2)
      {
        boolean bool3 = paramConversationItemLoaderEntity.isSystemConversation();
        bool1 = false;
        if (!bool3)
          bool1 = true;
      }
    }
    return bool1;
  }

  private static boolean d()
  {
    String str1 = UserManager.from(ViberApplication.getApplication()).getRegistrationValues().e();
    boolean bool1 = g.a().a(a.b.c);
    boolean bool3;
    Object localObject1;
    int j;
    label107: Object localObject2;
    if ((g.a().a(a.b.b)) && (com.viber.common.d.a.g()))
    {
      if (bool1)
        bool3 = true;
      boolean bool4;
      do
      {
        return bool3;
        bool4 = str1.toUpperCase().equals("US");
        bool3 = false;
      }
      while (bool4);
      localObject1 = null;
      String str2 = "SHOPCHAT_SHOW_BAG_PROGRESSIVE_ROLLOUT_" + str1.toUpperCase();
      a.b[] arrayOfb = a.b.values();
      int i = arrayOfb.length;
      j = 0;
      if (j < i)
      {
        localObject2 = arrayOfb[j];
        if (!((a.b)localObject2).name().equals(str2))
          break label186;
      }
    }
    while (true)
    {
      j++;
      localObject1 = localObject2;
      break label107;
      if (localObject1 != null);
      for (boolean bool5 = g.a().a(localObject1); ; bool5 = false)
      {
        return bool5;
        boolean bool2 = str1.toUpperCase().equals("US");
        bool3 = false;
        if (!bool2)
          break;
        return bool1;
      }
      label186: localObject2 = localObject1;
    }
  }

  public static boolean d(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    int i;
    if ((paramConversationItemLoaderEntity != null) && (paramConversationItemLoaderEntity.canSendMessages(0)) && (!paramConversationItemLoaderEntity.isPublicGroupBehavior()) && (!paramConversationItemLoaderEntity.isOneToOneWithPublicAccount()) && (!paramConversationItemLoaderEntity.isSystemConversation()) && (!paramConversationItemLoaderEntity.isBroadcastListType()) && (!paramConversationItemLoaderEntity.isSecret()) && (!paramConversationItemLoaderEntity.isDisabledConversation()))
      i = 1;
    while (d())
      if ((i != 0) && (c()))
      {
        return true;
        i = 0;
      }
      else
      {
        return false;
      }
    return false;
  }

  public static boolean e(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    return (paramConversationItemLoaderEntity != null) && (!paramConversationItemLoaderEntity.isCommunityType()) && (bi.a(paramConversationItemLoaderEntity));
  }

  public static boolean f(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    return (paramConversationItemLoaderEntity != null) && (paramConversationItemLoaderEntity.canCreatePoll());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.d.a
 * JD-Core Version:    0.6.2
 */