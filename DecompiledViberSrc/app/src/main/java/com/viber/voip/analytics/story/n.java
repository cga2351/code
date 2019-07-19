package com.viber.voip.analytics.story;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Base64;
import com.viber.voip.ViberApplication;
import com.viber.voip.analytics.story.l.a;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.messages.controller.bs.f;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.d.c;
import com.viber.voip.messages.m;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.messages.orm.entity.json.TextMessage;
import com.viber.voip.messages.ui.ai;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.util.at;
import com.viber.voip.util.da;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;

public class n
{
  private static float a(long paramLong)
  {
    return Math.round(10.0F * ((float)paramLong / 1024.0F / 1024.0F)) / 10.0F;
  }

  public static float a(Uri paramUri)
  {
    if (paramUri != null);
    for (long l = at.c(ViberApplication.getApplication(), paramUri); ; l = 0L)
      return a(l);
  }

  public static Bundle a(Bundle paramBundle, int paramInt)
  {
    if (paramBundle == null)
      paramBundle = new Bundle(1);
    paramBundle.putInt("participants_count_extra", paramInt);
    return paramBundle;
  }

  public static Bundle a(Bundle paramBundle, Sticker paramSticker, String paramString, boolean paramBoolean)
  {
    if (paramBundle == null)
      paramBundle = new Bundle(4);
    if (paramSticker != null)
    {
      paramBundle.putInt("sticker_id_extra", paramSticker.id);
      paramBundle.putString("sticker_type_extra", StoryConstants.w.a.a(paramSticker));
    }
    if (paramString != null)
      paramBundle.putString("sticker_origin_extra", paramString);
    paramBundle.putBoolean("has_sticker_clicker_extra", paramBoolean);
    return paramBundle;
  }

  public static Bundle a(Bundle paramBundle, String paramString)
  {
    if (paramBundle == null)
      paramBundle = new Bundle(1);
    paramBundle.putString("message_origin_extra", paramString);
    return paramBundle;
  }

  public static Bundle a(Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBundle == null)
      paramBundle = new Bundle(1);
    paramBundle.putBoolean("doodle_included_extra", paramBoolean);
    return paramBundle;
  }

  public static ArrayMap<f, com.viber.voip.analytics.e.g> a(ArrayMap<f, com.viber.voip.analytics.e.g> paramArrayMap, String paramString, double paramDouble)
  {
    paramArrayMap.put(a(paramString, Double.valueOf(paramDouble)), com.viber.voip.analytics.e.g.a);
    return paramArrayMap;
  }

  public static ArrayMap<f, com.viber.voip.analytics.e.g> a(ArrayMap<f, com.viber.voip.analytics.e.g> paramArrayMap, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return a(paramArrayMap, paramString1, paramString2, paramString3, paramString4, 1.0D);
  }

  public static ArrayMap<f, com.viber.voip.analytics.e.g> a(ArrayMap<f, com.viber.voip.analytics.e.g> paramArrayMap, String paramString1, String paramString2, String paramString3, String paramString4, double paramDouble)
  {
    paramArrayMap.put(a(paramString1, paramString4), com.viber.voip.analytics.e.g.b);
    paramArrayMap.put(a(paramString2, paramString4), com.viber.voip.analytics.e.g.c);
    paramArrayMap.put(a(paramString3, Double.valueOf(paramDouble)), com.viber.voip.analytics.e.g.a);
    return paramArrayMap;
  }

  public static ArrayMap<f, com.viber.voip.analytics.e.g> a(ArrayMap<f, com.viber.voip.analytics.e.g> paramArrayMap, String paramString, String[] paramArrayOfString)
  {
    paramArrayMap.put(a(paramString, paramArrayOfString), com.viber.voip.analytics.e.g.d);
    return paramArrayMap;
  }

  public static ArrayMap<f, com.viber.voip.analytics.e.g> a(String paramString, double paramDouble)
  {
    ArrayMap localArrayMap = new ArrayMap(1);
    localArrayMap.put(a(paramString, Double.valueOf(paramDouble)), com.viber.voip.analytics.e.g.a);
    return localArrayMap;
  }

  public static ArrayMap<f, com.viber.voip.analytics.e.g> a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return a(paramString1, paramString2, paramString3, paramString4, 1.0D);
  }

  public static ArrayMap<f, com.viber.voip.analytics.e.g> a(String paramString1, String paramString2, String paramString3, String paramString4, double paramDouble)
  {
    return a(new ArrayMap(3), paramString1, paramString2, paramString3, paramString4, paramDouble);
  }

  public static ArrayMap<f, com.viber.voip.analytics.e.g> a(HashMap<String, Object> paramHashMap)
  {
    ArrayMap localArrayMap = new ArrayMap(paramHashMap.size());
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayMap.put(a(str, paramHashMap.get(str)), com.viber.voip.analytics.e.g.c);
    }
    return localArrayMap;
  }

  public static SpannableString a(MessageEntity paramMessageEntity, ai paramai)
  {
    String str1 = paramMessageEntity.getSpans();
    String str2;
    if (paramMessageEntity.isTextMessage())
      str2 = paramMessageEntity.getBody();
    while (true)
    {
      if (str2 == null)
        str2 = "";
      if ((!TextUtils.isEmpty(str1)) && (!"no_sp".equals(str1)))
        break;
      return new SpannableString("");
      if (paramMessageEntity.isUrlMessage())
      {
        str2 = paramMessageEntity.getMessageInfo().getText();
        FormattedMessage localFormattedMessage = paramMessageEntity.getFormattedMessage();
        if (localFormattedMessage == null)
          return new SpannableString("");
        LongSparseArray localLongSparseArray = localFormattedMessage.getTextMessages();
        if (localLongSparseArray.size() == 0)
          return new SpannableString("");
        TextMessage localTextMessage = (TextMessage)localLongSparseArray.get(0L);
        if (localTextMessage == null)
          return new SpannableString("");
        str1 = localTextMessage.getSpans();
      }
      else
      {
        str2 = paramMessageEntity.getDescription();
      }
    }
    return da.a(paramai, str2, Base64.decode(str1, 19), true, true, aj.b);
  }

  public static f a(String paramString, Object paramObject)
  {
    return new f().b(paramString, paramObject).b(com.viber.voip.analytics.e.b.class, b.a(new String[] { paramString }).a());
  }

  public static f a(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    f.a locala = b.a(new String[] { paramString }).a();
    JSONArray localJSONArray = new JSONArray();
    int j = paramArrayOfString.length;
    while (i < j)
    {
      localJSONArray.put(paramArrayOfString[i]);
      i++;
    }
    return new f().b(paramString, localJSONArray).b(com.viber.voip.analytics.e.b.class, locala);
  }

  public static Integer a(int paramInt1, int paramInt2)
  {
    if (m.b(paramInt1))
      return Integer.valueOf(paramInt2);
    return null;
  }

  public static Integer a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if (((paramConversationItemLoaderEntity instanceof PublicGroupConversationItemLoaderEntity)) && (paramConversationItemLoaderEntity.isCommunityType()))
      return Integer.valueOf(((PublicGroupConversationItemLoaderEntity)paramConversationItemLoaderEntity).getWatchersCount());
    return null;
  }

  public static Integer a(ConversationLoaderEntity paramConversationLoaderEntity)
  {
    if ((paramConversationLoaderEntity != null) && (paramConversationLoaderEntity.isCommunityType()))
      return Integer.valueOf(paramConversationLoaderEntity.getWatchersCount());
    return null;
  }

  public static void a(bs.f paramf)
  {
    MessageEntity localMessageEntity = paramf.h;
    int i = localMessageEntity.getMimeType();
    ArrayList localArrayList = new ArrayList();
    if ((!localMessageEntity.isBroadcastList()) && (!localMessageEntity.isOneToOneChatWithPa()) && (!localMessageEntity.isPublicGroupType()))
      if (localMessageEntity.isCommunityType())
      {
        localArrayList.add(a.a(paramf.f.o(), String.valueOf(paramf.f.k())));
        localArrayList.add(a.b());
        label83: if (4 != i)
          break label234;
        if (!localMessageEntity.isCommunityType())
          localArrayList.add(a.d());
        if ((localMessageEntity.isGroupBehavior()) && (!localMessageEntity.isBroadcastList()) && (!localMessageEntity.isCommunityType()))
          localArrayList.add(a.e());
      }
    while (true)
    {
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        com.viber.voip.analytics.g.a().a(locale);
      }
      if (!localMessageEntity.isGroupBehavior())
        break;
      localArrayList.add(a.c());
      break;
      if (!localMessageEntity.isOneToOneChatWithPa())
        break label83;
      localArrayList.add(a.c(paramf.h.getMemberId()));
      localArrayList.add(a.b());
      break label83;
      label234: if ((2 == i) || (1009 == i))
        com.viber.voip.analytics.g.a().a(g.c(Boolean.TRUE));
      else if (localMessageEntity.isVideoPttBehavior())
        com.viber.voip.analytics.g.a().a(g.b(Boolean.TRUE));
    }
    if (localMessageEntity.isOneToOneType())
      k.a(c.c().b(paramf.h.getMemberId(), 1));
    if (localMessageEntity.isSecretMessage())
      com.viber.voip.analytics.g.a().a(g.e(Boolean.TRUE));
  }

  public static void a(bs.f[] paramArrayOff)
  {
    if ((paramArrayOff == null) || (paramArrayOff.length == 0));
    while (true)
    {
      return;
      int i = paramArrayOff.length;
      for (int j = 0; j < i; j++)
        a(paramArrayOff[j]);
    }
  }

  public static boolean a(Bundle paramBundle)
  {
    if (paramBundle == null)
      return false;
    return paramBundle.getBoolean("doodle_included_extra");
  }

  public static Bundle b(Bundle paramBundle, String paramString)
  {
    if (paramBundle == null)
      paramBundle = new Bundle(1);
    paramBundle.putString("image_gallery_origin_extra", paramString);
    return paramBundle;
  }

  public static String b(Bundle paramBundle)
  {
    if (paramBundle == null)
      return "";
    return paramBundle.getString("message_origin_extra", "");
  }

  public static int c(Bundle paramBundle)
  {
    if (paramBundle == null)
      return -1;
    return paramBundle.getInt("sticker_id_extra", -1);
  }

  public static String d(Bundle paramBundle)
  {
    if (paramBundle == null)
      return "";
    return paramBundle.getString("sticker_type_extra", "");
  }

  public static String e(Bundle paramBundle)
  {
    if (paramBundle == null)
      return "";
    return paramBundle.getString("sticker_origin_extra", "");
  }

  public static boolean f(Bundle paramBundle)
  {
    if (paramBundle == null)
      return false;
    return paramBundle.getBoolean("has_sticker_clicker_extra");
  }

  public static int g(Bundle paramBundle)
  {
    if (paramBundle == null)
      return -1;
    return paramBundle.getInt("participants_count_extra", -1);
  }

  public static String h(Bundle paramBundle)
  {
    if (paramBundle == null)
      return "";
    return paramBundle.getString("image_gallery_origin_extra", "");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.n
 * JD-Core Version:    0.6.2
 */