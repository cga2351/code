package com.viber.voip.analytics.a;

import android.net.Uri;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.s;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.util.upload.ObjectId;

public class j
{
  public static void a()
  {
    if (g.a() != null)
      ((a)g.a().a(a.class)).a();
  }

  public static void a(Uri paramUri)
  {
    String str = paramUri.getQueryParameter("adjust");
    if (Boolean.TRUE.toString().equalsIgnoreCase(str))
    {
      g.a().a(i.b);
      ((a)g.a().a(a.class)).a(paramUri);
    }
  }

  public static void a(MessageEntity paramMessageEntity)
  {
    if ((!b(paramMessageEntity)) || (paramMessageEntity.isBroadcastList()))
      return;
    f.a locala = f.a.a(paramMessageEntity);
    s locals1;
    label68: s locals2;
    label77: s locals3;
    switch (1.a[locala.ordinal()])
    {
    default:
      if (paramMessageEntity.isGroupBehavior())
      {
        locals1 = i.c(locala);
        if (!paramMessageEntity.isGroupBehavior())
          break label323;
        locals2 = null;
        if (locals1 != null)
          g.a().a(locals1);
        if (locals2 != null)
          g.a().a(locals2);
        int i = 1.a[locala.ordinal()];
        locals3 = null;
        switch (i)
        {
        default:
        case 4:
        case 5:
        case 6:
        }
      }
      break;
    case 1:
    case 2:
    case 3:
    }
    while (locals3 != null)
    {
      g.a().a(locals3);
      return;
      if (paramMessageEntity.hasExtraFlagNeedFetchUrlByBody())
      {
        if (paramMessageEntity.isGroupBehavior());
        for (locals1 = i.c(f.a.g); ; locals1 = i.a(f.a.g))
        {
          if (!paramMessageEntity.isGroupBehavior())
            break label197;
          locals2 = null;
          break;
        }
        label197: locals2 = i.b(f.a.g);
        break label77;
      }
      if (paramMessageEntity.isGroupBehavior());
      for (locals1 = i.c(f.a.a); ; locals1 = i.a(f.a.a))
      {
        if (!paramMessageEntity.isGroupBehavior())
          break label243;
        locals2 = null;
        break;
      }
      label243: locals2 = i.b(f.a.a);
      break label77;
      String str = Integer.toString(paramMessageEntity.getObjectId().toStickerId());
      if (paramMessageEntity.isGroupBehavior());
      for (locals1 = i.e(str); ; locals1 = i.c(str))
      {
        if (!paramMessageEntity.isGroupBehavior())
          break label299;
        locals2 = null;
        break;
      }
      label299: locals2 = i.d(str);
      break label77;
      locals1 = null;
      locals2 = null;
      break label77;
      locals1 = i.a(locala);
      break label68;
      label323: locals2 = i.b(locala);
      break label77;
      locals3 = i.a(paramMessageEntity.isGroupBehavior());
      continue;
      locals3 = i.b(paramMessageEntity.isGroupBehavior());
      continue;
      locals3 = i.c(paramMessageEntity.isGroupBehavior());
    }
  }

  public static void a(MessageEntity[] paramArrayOfMessageEntity)
  {
    if (paramArrayOfMessageEntity.length == 0);
    MessageEntity localMessageEntity;
    do
    {
      return;
      localMessageEntity = paramArrayOfMessageEntity[0];
    }
    while (!b(localMessageEntity));
    a(localMessageEntity);
  }

  public static boolean a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    return (paramConversationItemLoaderEntity != null) && (a(paramConversationItemLoaderEntity.isSecret()));
  }

  public static boolean a(aa paramaa)
  {
    return (paramaa != null) && (a(paramaa.ag()));
  }

  public static boolean a(CallInfo paramCallInfo)
  {
    return a(paramCallInfo.isFromSecretConversation());
  }

  public static boolean a(boolean paramBoolean)
  {
    return !paramBoolean;
  }

  public static void b()
  {
    if (g.a() != null)
      ((a)g.a().a(a.class)).b();
  }

  public static boolean b(MessageEntity paramMessageEntity)
  {
    return (paramMessageEntity != null) && (a(paramMessageEntity.isSecretMessage()));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.a.j
 * JD-Core Version:    0.6.2
 */