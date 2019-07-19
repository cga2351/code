package com.viber.voip.publicaccount.d;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.app.Fragment;
import com.google.d.f;
import com.viber.common.dialogs.a.a;
import com.viber.dexshared.Logger;
import com.viber.jni.CategoryMap;
import com.viber.jni.Engine;
import com.viber.jni.PublicChatCategory;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.PublicAccountReplyData;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.a;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.b;
import com.viber.voip.flatbuffers.model.publicaccount.MyCommunitySettings;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.k;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.publicaccount.entity.CrmItem;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.entity.PublicAccount.CategoryItem;
import com.viber.voip.publicaccount.entity.d;
import com.viber.voip.registration.af;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.r;
import com.viber.voip.ui.dialogs.r;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.SparseSet;
import com.viber.voip.util.cd;
import com.viber.voip.util.da;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class e
{
  public static final long a;
  private static final Logger b = ViberEnv.getLogger();
  private static final long c;
  private static SparseSet d;

  static
  {
    a = TimeUnit.HOURS.toMillis(24L);
    c = TimeUnit.HOURS.toMillis(2L);
    d = new SparseSet(9);
    d.add(0);
    d.add(5);
    d.add(10);
    d.add(1);
    d.add(3);
    d.add(1005);
    d.add(4);
    d.add(9);
    d.add(8);
  }

  public static com.viber.voip.bot.a a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString1, String paramString2)
  {
    com.viber.voip.bot.a locala = new com.viber.voip.bot.a();
    locala.a(paramString1);
    locala.a(4);
    locala.b(da.h(paramString2));
    locala.c(paramConversationItemLoaderEntity.getParticipantMemberId());
    locala.a(paramConversationItemLoaderEntity.getGroupId());
    locala.a(ReplyButton.b.QUERY);
    locala.a(true);
    return locala;
  }

  public static com.viber.voip.bot.a a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    String str = "embedded|ANDROID|" + paramString2;
    com.viber.voip.bot.a locala = new com.viber.voip.bot.a();
    locala.a(ReplyButton.a.REPLY);
    locala.a(ReplyButton.b.MESSAGE);
    locala.a(false);
    locala.a(4);
    locala.a(paramString1);
    locala.b(str);
    locala.c(paramString3);
    locala.a(paramLong);
    return locala;
  }

  public static BotReplyConfig a(String paramString)
  {
    if ((!da.a(paramString)) && (!"{}".equals(paramString)))
      return (BotReplyConfig)new f().a(paramString, BotReplyConfig.class);
    return null;
  }

  public static String a(com.viber.voip.bot.a parama)
  {
    String str;
    if (b(parama.c()))
      str = "ss";
    while (true)
    {
      return b(str, parama.c());
      if (parama.f() > 0L)
        str = String.valueOf(parama.f());
      else
        str = parama.e();
    }
  }

  public static String a(MessageEntity paramMessageEntity, String paramString)
  {
    String str;
    if (b(paramString))
      str = "ss";
    while (true)
    {
      return b(str, paramString);
      if (paramMessageEntity.isOneToOneType())
        str = paramMessageEntity.getMemberId();
      else
        str = String.valueOf(paramMessageEntity.getGroupId());
    }
  }

  public static ArrayList<com.viber.voip.publicaccount.entity.b> a()
  {
    CategoryMap localCategoryMap = new CategoryMap();
    a(localCategoryMap, null);
    return a(localCategoryMap);
  }

  public static ArrayList<com.viber.voip.publicaccount.entity.b> a(CategoryMap paramCategoryMap)
  {
    String[] arrayOfString1 = paramCategoryMap.getKeys();
    ArrayList localArrayList1 = new ArrayList(arrayOfString1.length);
    int i = arrayOfString1.length;
    for (int j = 0; j < i; j++)
    {
      String str1 = arrayOfString1[j];
      PublicChatCategory localPublicChatCategory = paramCategoryMap.getValue(str1);
      String[] arrayOfString2 = localPublicChatCategory.getKeys();
      ArrayList localArrayList2 = new ArrayList(arrayOfString2.length);
      int k = arrayOfString2.length;
      for (int m = 0; m < k; m++)
      {
        String str2 = arrayOfString2[m];
        localArrayList2.add(new d(str2, localPublicChatCategory.getValue(str2)));
      }
      Collections.sort(localArrayList2);
      localArrayList1.add(new com.viber.voip.publicaccount.entity.b(str1, localPublicChatCategory.getName(), localArrayList2));
    }
    return localArrayList1;
  }

  private static ArrayList<CrmItem> a(ArrayList<Map> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      Map localMap = (Map)localIterator.next();
      String str = (String)localMap.get("name");
      localArrayList.add(new CrmItem((String)localMap.get("action"), str, (String)localMap.get("icon")));
    }
    return localArrayList;
  }

  public static void a(Fragment paramFragment)
  {
    String str = UserManager.from(ViberApplication.getApplication()).getRegistrationValues().e().toUpperCase();
    int i = paramFragment.getResources().getIdentifier(str, "string", ViberApplication.getApplication().getPackageName());
    if (i != 0)
      str = paramFragment.getString(i);
    r.u().b(R.string.dialog_2011_message, new Object[] { str }).b(paramFragment);
  }

  private static void a(CategoryMap paramCategoryMap, ArrayList<Map> paramArrayList)
  {
    if (paramCategoryMap == null)
      paramCategoryMap = new CategoryMap();
    if (paramArrayList == null)
      paramArrayList = new ArrayList();
    ViberApplication.getInstance().getEngine(true).getGroupController().handleGetPublicAccountsMetaData(paramCategoryMap, paramArrayList);
  }

  public static void a(MessageEntity paramMessageEntity, String paramString, PublicAccountReplyData paramPublicAccountReplyData, com.viber.voip.messages.extensions.c paramc)
  {
    ReplyButton localReplyButton = paramPublicAccountReplyData.getButton();
    com.viber.voip.bot.a locala = new com.viber.voip.bot.c(paramMessageEntity.getConversationId(), paramMessageEntity.getConversationType(), paramMessageEntity.getMemberId(), paramc, null, localReplyButton, paramMessageEntity.getMemberId(), paramMessageEntity.getGroupId(), paramString, true, false, null, 0, paramMessageEntity.isHiddenChat()).a();
    MessageEntity localMessageEntity = locala.a();
    if (localMessageEntity == null);
    while (true)
    {
      return;
      paramMessageEntity.setBody(localMessageEntity.getBody());
      paramMessageEntity.setMimeType(localMessageEntity.getMimeType());
      paramMessageEntity.setSpans(null);
      if (localMessageEntity.getMimeType() != 1)
        paramMessageEntity.addExtraFlag(18);
      while (locala.h())
      {
        paramMessageEntity.addExtraFlag(22);
        return;
        paramMessageEntity.setMimeType(1);
        paramMessageEntity.setMediaUri(localMessageEntity.getMediaUri());
        paramMessageEntity.setBody(localMessageEntity.getMediaUri());
        paramMessageEntity.setExtraStatus(3);
      }
    }
  }

  public static void a(com.viber.voip.model.entity.h paramh, String paramString, int paramInt)
  {
    if ((paramInt & 0x4) == 0)
      return;
    ViberApplication.getInstance().getMessagesManager().d().b(paramh.getId(), paramh.j(), paramh.t(), paramString);
  }

  public static void a(String paramString1, Uri paramUri, String paramString2, int paramInt)
  {
    if (((paramInt & 0x1) == 0) && ((paramInt & 0x2) == 0))
      return;
    if ((paramInt & 0x2) != 0);
    for (Uri localUri = paramUri; ; localUri = null)
    {
      if ((paramInt & 0x1) != 0);
      for (String str = paramString2; ; str = null)
      {
        Member localMember = new Member(paramString1, paramString1, localUri, str, null);
        com.viber.voip.messages.d.c.c().a(localMember);
        return;
      }
    }
  }

  public static boolean a(long paramLong1, long paramLong2)
  {
    return paramLong2 - paramLong1 > c;
  }

  public static boolean a(long paramLong1, long paramLong2, long paramLong3)
  {
    return (paramLong2 > paramLong1) || (a(paramLong1, paramLong3));
  }

  public static boolean a(Context paramContext, a parama)
  {
    UserData localUserData = UserManager.from(paramContext).getUserData();
    int i;
    if ((da.a(localUserData.getViberName())) && ((parama == a.a) || (parama == a.b)))
    {
      i = 1;
      if ((!da.a(localUserData.getViberImage())) || ((parama != a.a) && (parama != a.c)))
        break label84;
    }
    label84: for (int j = 1; ; j = 0)
    {
      boolean bool;
      if (j == 0)
      {
        bool = false;
        if (i == 0);
      }
      else
      {
        bool = true;
      }
      return bool;
      i = 0;
      break;
    }
  }

  public static boolean a(Fragment paramFragment, a.a parama, a parama1, boolean paramBoolean)
  {
    if (a(paramFragment.getContext(), parama1))
    {
      if (paramBoolean)
        parama.a(paramFragment).b(paramFragment);
      return false;
    }
    return true;
  }

  public static boolean a(Fragment paramFragment, boolean paramBoolean)
  {
    return a(paramFragment, r.g(), a.a, paramBoolean);
  }

  public static boolean a(ReplyButton.a parama)
  {
    return (ReplyButton.a.REPLY == parama) || (ReplyButton.a.LOCATION_PICKER == parama) || (ReplyButton.a.SHARE_PHONE == parama);
  }

  public static boolean a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if (paramConversationItemLoaderEntity.isAgeRestrictedPublicAccount())
    {
      int i = paramConversationItemLoaderEntity.getConversationType();
      if ((i == 3) || ((i == 2) && (paramConversationItemLoaderEntity.isDisabledConversation())));
      while ((paramConversationItemLoaderEntity.isOneToOneWithPublicAccount()) && (!paramConversationItemLoaderEntity.isPublicAccountGroupExists()))
        return true;
    }
    return false;
  }

  public static boolean a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
    MyCommunitySettings localMyCommunitySettings = paramPublicGroupConversationItemLoaderEntity.getMySettings();
    if (localMyCommunitySettings != null)
      return localMyCommunitySettings.isAllowM2M();
    return true;
  }

  public static boolean a(com.viber.voip.model.entity.h paramh, PublicAccount paramPublicAccount)
  {
    if (paramPublicAccount.isAgeRestricted())
    {
      int i = paramh.j();
      if ((i == 3) || ((i == 2) && (paramh.K())))
        return true;
    }
    return false;
  }

  public static boolean a(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++)
    {
      int k = paramArrayOfInt[j];
      if (!d.contains(k))
        return false;
    }
    return true;
  }

  public static PublicAccount.CategoryItem[] a(String paramString1, String paramString2)
  {
    String[] arrayOfString = c(paramString1, paramString2);
    if ((arrayOfString != null) && (arrayOfString.length != 0))
      return new PublicAccount.CategoryItem[] { new PublicAccount.CategoryItem(paramString1, arrayOfString[0]), new PublicAccount.CategoryItem(paramString2, arrayOfString[1]) };
    return null;
  }

  public static String b(String paramString1, String paramString2)
  {
    return paramString2 + "_" + paramString1;
  }

  public static ArrayList<CrmItem> b()
  {
    ArrayList localArrayList = new ArrayList();
    a(null, localArrayList);
    return a(localArrayList);
  }

  public static boolean b(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    int i = paramConversationItemLoaderEntity.getGroupRole();
    if (cd.b(i));
    int j;
    do
    {
      return true;
      if (!cd.f(i))
        break;
      j = paramConversationItemLoaderEntity.getConversationType();
    }
    while ((!paramConversationItemLoaderEntity.isDisabledConversation()) && (j == 2));
    return false;
    return false;
  }

  public static boolean b(String paramString)
  {
    return (paramString != null) && (paramString.equals(d.r.p.d()));
  }

  public static boolean c()
  {
    return (!ViberApplication.isTablet(ViberApplication.getApplication())) && (!a.a().e()) && (!ao.f());
  }

  private static String[] c(String paramString1, String paramString2)
  {
    return ViberApplication.getInstance().getEngine(true).getGroupController().handleGetPublicAccountCategoryItem(paramString1, paramString2);
  }

  public static boolean d()
  {
    return !a.a().e();
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.d.e
 * JD-Core Version:    0.6.2
 */