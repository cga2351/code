package com.viber.voip.messages.controller.publicaccount;

import android.app.Application;
import android.content.Context;
import android.graphics.BitmapFactory.Options;
import android.location.Location;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.util.LongSparseArray;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.LocationInfo;
import com.viber.jni.PublicAccountInfo;
import com.viber.jni.PublicGroupInfo;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.connection.ConnectionController;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.jni.connection.ConnectionListener;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.publicaccount.PublicAccountControllerDelegate.PublicAccountConversationStatusReceiver;
import com.viber.jni.publicaccount.PublicAccountControllerDelegate.PublicAccountRefreshTokenReceiver;
import com.viber.jni.publicaccount.PublicAccountControllerDelegate.PublicAccountSearchReceiver;
import com.viber.jni.publicaccount.PublicAccountControllerDelegate.PublicAccountSubscribersCountReceiver;
import com.viber.jni.publicaccount.PublicAccountControllerDelegate.PublicAccountSubscriptionStatusReceiver;
import com.viber.jni.publicaccount.PublicAccountConversationStatusController;
import com.viber.jni.publicaccount.PublicAccountConversationStatusListener;
import com.viber.jni.publicaccount.PublicAccountRefreshTokenListener;
import com.viber.jni.publicaccount.PublicAccountSearchListener;
import com.viber.jni.publicaccount.PublicAccountSubscribersCountController;
import com.viber.jni.publicaccount.PublicAccountSubscribersCountListener;
import com.viber.jni.publicaccount.PublicAccountSubscriptionController;
import com.viber.jni.publicaccount.PublicAccountSubscriptionStatusListener;
import com.viber.jni.publicgroup.PublicGroupController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.n;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.backgrounds.q;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.keyboard.BotKeyboardSendData;
import com.viber.voip.flatbuffers.model.msginfo.keyboard.BrowserData;
import com.viber.voip.flatbuffers.model.msginfo.keyboard.PickerLocation;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.a;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.b;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.ai.n;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.bv.d;
import com.viber.voip.messages.controller.bv.e;
import com.viber.voip.messages.controller.bv.q;
import com.viber.voip.messages.controller.bv.r;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.messages.controller.manager.al;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.extensions.f;
import com.viber.voip.messages.k;
import com.viber.voip.messages.orm.entity.json.action.Action;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.model.entity.l;
import com.viber.voip.model.entity.m;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.entity.PublicAccount.CategoryItem;
import com.viber.voip.sound.tones.IRingtonePlayer;
import com.viber.voip.sound.tones.SampleTone;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ViberActionRunner.PublicAccountInviteData;
import com.viber.voip.util.ap;
import com.viber.voip.util.at;
import com.viber.voip.util.da;
import com.viber.voip.util.dv;
import com.viber.voip.util.e.j;
import com.viber.voip.util.e.j.b;
import com.viber.voip.util.u.a;
import java.io.File;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class w
  implements ConnectionDelegate, PublicAccountControllerDelegate.PublicAccountConversationStatusReceiver, PublicAccountControllerDelegate.PublicAccountRefreshTokenReceiver, PublicAccountControllerDelegate.PublicAccountSearchReceiver, PublicAccountControllerDelegate.PublicAccountSubscribersCountReceiver, PublicAccountControllerDelegate.PublicAccountSubscriptionStatusReceiver, d
{
  private static final Logger a = ViberEnv.getLogger();
  private static final long b = TimeUnit.SECONDS.toMillis(5L);
  private final Engine c;
  private final com.viber.voip.messages.extensions.c d;
  private final bs e;
  private final ab f;
  private final o g;
  private final com.viber.voip.backgrounds.b h;
  private final LongSparseArray<a> i = new LongSparseArray();
  private final HashMap<String, Integer> j = new HashMap();
  private final SparseArray<c> k = new SparseArray();
  private final SparseArray<Runnable> l = new SparseArray();
  private final SparseArray<BotReplyRequest> m = new SparseArray();
  private final Map<String, b> n = new ConcurrentHashMap();
  private final Map<String, Integer> o = new ConcurrentHashMap();
  private af p;
  private final ICdrController q;
  private final Handler r;
  private final Handler s;
  private com.viber.common.permission.c t;
  private final ak u;
  private final al v;
  private final dagger.a<f> w;
  private final Set<String> x;
  private final bv.e y = new bv.d()
  {
    public void onConversationClosed(boolean paramAnonymousBoolean, long paramAnonymousLong)
    {
      w.a(w.this).a();
      w.b(w.this).clear();
      w.c(w.this).post(new ac(this, paramAnonymousLong));
    }

    public void onOpenConversation(ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity)
    {
      w.a(w.this).a(paramAnonymousConversationItemLoaderEntity.getId());
      if (paramAnonymousConversationItemLoaderEntity.isOneToOneWithPublicAccount())
        w.c(w.this).post(new ad(this, paramAnonymousConversationItemLoaderEntity));
    }
  };
  private final bv.r z = new bv.q()
  {
    public void a(long paramAnonymousLong)
    {
      w.this.a(paramAnonymousLong);
    }
  };

  public w(Context paramContext, Engine paramEngine, Handler paramHandler1, Handler paramHandler2, Handler paramHandler3, ab paramab, al paramal, ak paramak, dagger.a<f> parama, com.viber.voip.messages.extensions.c paramc)
  {
    this.e = new bs(paramContext);
    this.f = paramab;
    this.c = paramEngine;
    this.d = paramc;
    this.w = parama;
    this.c.getDelegatesManager().getPublicAccountConversationStatusListener().registerDelegate(this, paramHandler1);
    this.c.getDelegatesManager().getPublicAccountSubscriptionStatusListener().registerDelegate(this, paramHandler1);
    this.c.getDelegatesManager().getPublicAccountSubscribersCountListener().registerDelegate(this, paramHandler1);
    this.c.getDelegatesManager().getConnectionListener().registerDelegate(this, paramHandler1);
    this.c.getDelegatesManager().getPublicAccountSearchListener().registerDelegate(this, paramHandler1);
    this.c.getDelegatesManager().getPublicAccountRefreshTokenListener().registerDelegate(this, paramHandler1);
    this.q = this.c.getCdrController();
    this.r = paramHandler1;
    this.s = paramHandler3;
    this.g = o.a();
    this.g.a(this.y);
    this.g.a(this.z, paramHandler2);
    this.p = new af(this.g, paramc);
    this.t = com.viber.common.permission.c.a(paramContext);
    this.u = paramak;
    this.v = paramal;
    this.h = com.viber.voip.backgrounds.b.a();
    this.x = Collections.newSetFromMap(new ConcurrentHashMap());
  }

  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case 2:
    default:
      return 0;
    case 3:
      return 1;
    case 1:
    }
    return 2;
  }

  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    String str = (String)u.a.a(this.j, Integer.valueOf(paramInt2));
    if (str == null)
      return;
    if (paramInt1 == 0)
    {
      com.viber.voip.model.e.e(str);
      this.e.a(str, paramBoolean);
      BotReplyRequest localBotReplyRequest = (BotReplyRequest)this.m.get(paramInt2);
      if (localBotReplyRequest != null)
      {
        this.m.remove(paramInt2);
        a(localBotReplyRequest, null);
      }
    }
    this.g.a(str, paramInt1);
    this.j.remove(str);
  }

  private void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (this.j.containsKey(paramString))
      return;
    com.viber.voip.model.e.a(paramString, "key_pending_public_account_subscription", paramBoolean);
    this.j.put(paramString, Integer.valueOf(paramInt));
    if (paramBoolean)
    {
      this.c.getPublicAccountSubscriptionController().handleSubscribeToPublicAccount(paramInt, paramString);
      return;
    }
    this.c.getPublicAccountSubscriptionController().handleUnSubscribeFromPublicAccount(paramInt, paramString);
  }

  private void a(int paramInt1, ArrayList<PublicAccount> paramArrayList, int paramInt2, c paramc)
  {
    synchronized (this.k)
    {
      this.k.remove(paramInt1);
    }
    synchronized (this.l)
    {
      Runnable localRunnable = (Runnable)this.l.get(paramInt1);
      av.a(av.e.g).removeCallbacks(localRunnable);
      this.l.remove(paramInt1);
      if (paramInt2 == 0)
      {
        paramc.b.a(paramc.a, paramArrayList);
        return;
        localObject1 = finally;
        throw localObject1;
      }
    }
    paramc.b.a(paramc.a, Collections.emptyList());
  }

  private void a(com.viber.voip.bot.a parama, boolean paramBoolean, MsgInfo paramMsgInfo)
  {
    a(parama, paramBoolean, paramMsgInfo, null);
  }

  private void a(com.viber.voip.bot.a parama, boolean paramBoolean, MsgInfo paramMsgInfo, Pair<ReplyButton.a, ReplyButton.b> paramPair)
  {
    BotReplyConfig localBotReplyConfig = this.p.b(parama.c());
    if ((paramBoolean) && (localBotReplyConfig != null))
      o.a().a(parama.c(), localBotReplyConfig);
    int i1;
    do
    {
      return;
      i1 = this.c.getPhoneController().generateSequence();
      String str1 = parama.c();
      this.n.put(str1, new b(i1, parama, paramBoolean, paramMsgInfo));
    }
    while (!this.c.getConnectionController().isConnected());
    String str2 = com.viber.voip.model.e.c("-4", com.viber.voip.publicaccount.d.e.a(parama));
    String str3 = com.viber.voip.flatbuffers.b.e.a().b().a(paramMsgInfo);
    if ((parama.g() == ReplyButton.b.QUERY) && (parama.j() != ReplyButton.a.OPEN_URL))
      o.a().a(parama.d(), parama.c(), paramBoolean);
    String str4;
    if ((paramPair != null) && (parama.j() == paramPair.first))
      str4 = ((ReplyButton.b)paramPair.second).getTypeName();
    while (true)
    {
      this.c.getPublicAccountConversationStatusController().handleSendConversationStatus(parama.c(), parama.i(), parama.d(), i1, da.h(str2), parama.e(), parama.f(), str4, parama.h(), str3);
      return;
      if (parama.j() == ReplyButton.a.OPEN_URL)
        str4 = parama.j().getTypeName();
      else
        str4 = parama.g().getTypeName();
    }
  }

  private void a(BotReplyRequest paramBotReplyRequest, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    MsgInfo localMsgInfo = new MsgInfo();
    BotKeyboardSendData localBotKeyboardSendData = new BotKeyboardSendData();
    BrowserData localBrowserData = new BrowserData();
    localBrowserData.setUrl(paramString1);
    localBrowserData.setTitle(paramString2);
    localBrowserData.setActionReplyData(paramString3);
    localBrowserData.setOriginalUrl(paramBoolean);
    localBotKeyboardSendData.setBrowserData(localBrowserData);
    localMsgInfo.setBotKeyboardSendData(localBotKeyboardSendData);
    a(paramBotReplyRequest, localMsgInfo);
  }

  private void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    String str1 = paramConversationItemLoaderEntity.getPublicAccountId();
    if (TextUtils.isEmpty(str1));
    com.viber.voip.model.entity.r localr;
    do
    {
      return;
      localr = this.f.a(str1);
    }
    while (localr == null);
    String str2 = localr.P();
    String str3 = localr.Q();
    PublicAccount.CategoryItem[] arrayOfCategoryItem1;
    PublicAccount.CategoryItem[] arrayOfCategoryItem3;
    if (!da.a(str2))
    {
      arrayOfCategoryItem1 = com.viber.voip.publicaccount.d.e.a(str2, str3);
      if (arrayOfCategoryItem1 != null)
        break label171;
      arrayOfCategoryItem3 = new PublicAccount.CategoryItem[2];
      arrayOfCategoryItem3[0] = new PublicAccount.CategoryItem(str2, "");
      arrayOfCategoryItem3[1] = new PublicAccount.CategoryItem(str3, "");
    }
    label171: for (PublicAccount.CategoryItem[] arrayOfCategoryItem2 = arrayOfCategoryItem3; ; arrayOfCategoryItem2 = arrayOfCategoryItem1)
    {
      a(paramConversationItemLoaderEntity.getId());
      this.q.handleReportPAEntering1On1Chat(str1, arrayOfCategoryItem2[0].getName(), arrayOfCategoryItem2[1].getName(), localr.g(), new LocationInfo(localr.h(), localr.i()), new SecureRandom().nextLong());
      return;
      arrayOfCategoryItem1 = null;
      break;
    }
  }

  private boolean a(String paramString, int paramInt)
  {
    int i1 = this.i.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      long l1 = this.i.keyAt(i2);
      a locala = (a)this.i.get(l1);
      if ((paramString.equals(locala.c)) && (paramInt == locala.a))
        return true;
    }
    return false;
  }

  private void b(long paramLong)
  {
    this.i.remove(paramLong);
  }

  private void b(com.viber.voip.bot.a parama, Location paramLocation, String paramString)
  {
    MsgInfo localMsgInfo = new MsgInfo();
    BotKeyboardSendData localBotKeyboardSendData = new BotKeyboardSendData();
    PickerLocation localPickerLocation = new PickerLocation();
    localPickerLocation.setAddress(paramString);
    localPickerLocation.setLat(paramLocation.getLatitude());
    localPickerLocation.setLon(paramLocation.getLongitude());
    localBotKeyboardSendData.setLocation(localPickerLocation);
    localMsgInfo.setBotKeyboardSendData(localBotKeyboardSendData);
    a(parama, true, localMsgInfo);
  }

  private boolean b(String paramString, int paramInt)
  {
    Iterator localIterator = this.n.values().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb.a == paramInt) && (paramString.equals(localb.b.c())))
        return true;
    }
    return false;
  }

  private void c(BotReplyRequest paramBotReplyRequest)
  {
    String str = UserManager.from(ViberApplication.getApplication()).getRegistrationValues().g();
    MsgInfo localMsgInfo = new MsgInfo();
    BotKeyboardSendData localBotKeyboardSendData = new BotKeyboardSendData();
    localBotKeyboardSendData.setPhone(str);
    localMsgInfo.setBotKeyboardSendData(localBotKeyboardSendData);
    a(paramBotReplyRequest, localMsgInfo);
  }

  private void c(BotReplyRequest paramBotReplyRequest, double paramDouble1, double paramDouble2, String paramString)
  {
    MsgInfo localMsgInfo = new MsgInfo();
    BotKeyboardSendData localBotKeyboardSendData = new BotKeyboardSendData();
    PickerLocation localPickerLocation = new PickerLocation();
    localPickerLocation.setAddress(paramString);
    localPickerLocation.setLat(paramDouble1);
    localPickerLocation.setLon(paramDouble2);
    localBotKeyboardSendData.setLocation(localPickerLocation);
    localMsgInfo.setBotKeyboardSendData(localBotKeyboardSendData);
    a(paramBotReplyRequest, localMsgInfo);
  }

  public void a()
  {
    this.p.b();
  }

  public void a(int paramInt1, int paramInt2, long paramLong1, String[] paramArrayOfString, long paramLong2, ViberActionRunner.PublicAccountInviteData paramPublicAccountInviteData)
  {
    PublicGroupController localPublicGroupController = this.c.getPublicGroupController();
    int i1 = a(paramPublicAccountInviteData.getInvitedTo());
    int i3;
    int i4;
    int i5;
    switch (paramInt2)
    {
    case 2:
    case 3:
    default:
      i3 = paramArrayOfString.length;
      i4 = 0;
      i5 = paramInt1;
    case 1:
      while (i4 < i3)
      {
        localPublicGroupController.handleSendPublicGroupInvite(i5, new String[] { paramArrayOfString[i4] }, paramPublicAccountInviteData.getGroupId(), i1);
        int i6 = this.c.getPhoneController().generateSequence();
        i4++;
        i5 = i6;
        continue;
        localPublicGroupController.handleSendPublicGroupInviteToGroup(paramInt1, paramLong1, paramPublicAccountInviteData.getGroupId(), i1);
      }
    case 4:
    }
    while (true)
    {
      return;
      List localList1 = this.v.c(paramLong2);
      ArrayList localArrayList = new ArrayList(localList1.size());
      Iterator localIterator1 = localList1.iterator();
      while (localIterator1.hasNext())
        localArrayList.add(String.valueOf(((l)localIterator1.next()).a()));
      if (!localArrayList.isEmpty())
      {
        List localList2 = this.u.b(localArrayList);
        if (!localList2.isEmpty())
        {
          Iterator localIterator2 = localList2.iterator();
          int i2 = paramInt1;
          while (localIterator2.hasNext())
          {
            m localm = (m)localIterator2.next();
            if (!localm.isOwner())
            {
              String[] arrayOfString = new String[1];
              arrayOfString[0] = localm.a();
              localPublicGroupController.handleSendPublicGroupInvite(i2, arrayOfString, paramPublicAccountInviteData.getGroupId(), i1);
              i2 = this.c.getPhoneController().generateSequence();
            }
          }
        }
      }
    }
  }

  public void a(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    int i1 = this.c.getPhoneController().generateSequence();
    String str = da.h(paramString1);
    a locala = new a(i1, paramInt, str, paramString2);
    this.i.put(paramLong, locala);
    if (!this.c.getConnectionController().isConnected())
      return;
    this.c.getPublicAccountConversationStatusController().handleSendConversationStatus(paramString2, paramInt, str, i1, "", "", 0L, "", false, "");
  }

  public void a(long paramLong)
  {
    com.viber.voip.model.entity.r localr = this.f.e(paramLong);
    String str1;
    String str2;
    if (localr != null)
    {
      str1 = localr.U();
      if (localr == null)
        break label56;
      str2 = localr.V();
      label29: if (da.a(str2))
        str2 = str1;
      if (!TextUtils.isEmpty(str2))
        break label62;
    }
    label56: label62: label222: Uri[] arrayOfUri;
    label266: 
    do
    {
      ViberApplication localViberApplication;
      j.b localb;
      BitmapFactory.Options localOptions;
      do
      {
        return;
        str1 = null;
        break;
        str2 = null;
        break label29;
        Application localApplication = ViberApplication.getApplication();
        localViberApplication = ViberApplication.getInstance();
        File localFile = dv.n.b(localApplication, str2, false);
        if (localFile != null);
        for (Uri localUri1 = Uri.fromFile(localFile); ; localUri1 = null)
        {
          Uri localUri2 = new com.viber.voip.backgrounds.r(localUri1).a(false);
          String str3 = null;
          if (localUri2 != null)
            str3 = localUri2.toString();
          if (!da.a(str3))
          {
            String str5 = this.f.f(paramLong).t();
            if ((str5 != null) && (str3.contains(str5)) && (at.d(localApplication, str5)))
              break;
          }
          localb = j.b(str2);
          long l1 = localb.b;
          if ((0L < l1) && (l1 <= 3145728L))
            break label222;
          localViberApplication.getDownloadValve().a(str2);
          return;
        }
        localOptions = localb.a;
        if ((localOptions != null) && (localOptions.outWidth > 0) && (localOptions.outHeight > 0))
          break label266;
        localViberApplication.getDownloadValve().a(str2);
      }
      while (localOptions == null);
      return;
      String str4 = localb.c;
      if ((!"png".equalsIgnoreCase(str4)) && (!"jpeg".equalsIgnoreCase(str4)))
      {
        localViberApplication.getDownloadValve().a(str2);
        return;
      }
      arrayOfUri = this.h.b(str2);
    }
    while (arrayOfUri[0] == null);
    this.e.a(paramLong, 2, arrayOfUri[0].toString(), arrayOfUri[1].toString());
  }

  public void a(long paramLong, boolean paramBoolean)
  {
    com.viber.voip.model.entity.r localr = this.f.e(paramLong);
    if (localr != null)
      a(this.c.getPhoneController().generateSequence(), localr.b(), paramBoolean);
  }

  public void a(com.viber.voip.bot.a parama)
  {
    String str = parama.c();
    if (da.a(str));
    while (this.n.containsKey(str))
      return;
    a(parama, true, null);
  }

  public void a(com.viber.voip.bot.a parama, Location paramLocation)
  {
    String str = parama.c();
    if (da.a(str));
    while (this.n.containsKey(str))
      return;
    this.x.add(str);
    if (a.a(paramLocation))
    {
      b(parama, paramLocation, "");
      return;
    }
    ViberApplication.getInstance().getLocationManager().a(2, paramLocation.getLatitude(), paramLocation.getLongitude(), false, false, new y(this, parama, paramLocation));
  }

  public void a(ai.n paramn)
  {
    // Byte code:
    //   0: new 928	com/viber/voip/messages/controller/publicaccount/w$3
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 929	com/viber/voip/messages/controller/publicaccount/w$3:<init>	(Lcom/viber/voip/messages/controller/publicaccount/w;)V
    //   8: ldc_w 570
    //   11: lconst_0
    //   12: aload_1
    //   13: invokevirtual 932	com/viber/voip/messages/controller/publicaccount/w$3:a	(Ljava/lang/String;JLcom/viber/voip/messages/controller/ai$n;)V
    //   16: return
  }

  public void a(BotReplyRequest paramBotReplyRequest)
  {
    if (this.e.a(0, new Member(paramBotReplyRequest.publicAccountId), 0L, true) != null)
    {
      int i1 = this.c.getPhoneController().generateSequence();
      this.m.put(i1, paramBotReplyRequest);
      a(i1, paramBotReplyRequest.publicAccountId, true);
    }
  }

  public void a(BotReplyRequest paramBotReplyRequest, double paramDouble1, double paramDouble2, String paramString)
  {
    if (!da.a(paramString))
    {
      c(paramBotReplyRequest, paramDouble1, paramDouble2, paramString);
      return;
    }
    ViberApplication.getInstance().getLocationManager().a(1, paramDouble1, paramDouble2, false, false, new x(this, paramBotReplyRequest, paramDouble1, paramDouble2));
  }

  public void a(BotReplyRequest paramBotReplyRequest, MsgInfo paramMsgInfo)
  {
    if ((!paramBotReplyRequest.isSystemConversation) && (da.a(paramBotReplyRequest.publicAccountId)));
    com.viber.voip.bot.a locala;
    MessageEntity localMessageEntity;
    do
    {
      Action localAction;
      do
      {
        return;
        locala = new com.viber.voip.bot.c(paramBotReplyRequest.conversationId, paramBotReplyRequest.conversationType, paramBotReplyRequest.memberId, this.d, paramBotReplyRequest.replyRelatedConfig, paramBotReplyRequest.replyButton, paramBotReplyRequest.memberId, paramBotReplyRequest.groupId, paramBotReplyRequest.publicAccountId, paramBotReplyRequest.isPublicAccount, paramBotReplyRequest.isSystemConversation, paramMsgInfo, paramBotReplyRequest.botReplyActionSource, paramBotReplyRequest.isHiddenChat).a();
        localAction = locala.b();
        localMessageEntity = locala.a();
      }
      while (locala.j().equals(ReplyButton.a.NONE));
      if ((localAction != null) && (!paramBotReplyRequest.skipActionHandling))
        this.s.post(new z(localAction));
    }
    while ((paramBotReplyRequest.unableSendMessages) || (da.a(paramBotReplyRequest.publicAccountId)));
    int i1;
    if ((paramBotReplyRequest.replyButton.getReplyType() == ReplyButton.b.MESSAGE) && (com.viber.voip.publicaccount.d.e.a(paramBotReplyRequest.replyButton.getActionType())))
    {
      i1 = 1;
      label182: if (localMessageEntity == null)
        break label316;
      ViberApplication.getInstance().getMessagesManager().c().a(localMessageEntity, n.a(null, "Keyboard"));
    }
    label316: 
    while (i1 == 0)
    {
      com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.g.d(Boolean.TRUE));
      if ((paramBotReplyRequest.isPublicAccount) || (paramBotReplyRequest.isSystemConversation))
        break;
      a(locala, false, paramMsgInfo, paramBotReplyRequest.overriddenReplyType);
      if (i1 != 0)
        ViberApplication.getInstance().getRingtonePlayer().playSample(SampleTone.OUTGOING_FG);
      if (((i1 == 0) && (!paramBotReplyRequest.canAddToRecentsOnTap)) || (!((f)this.w.get()).a(paramBotReplyRequest.publicAccountId)))
        break;
      this.g.f();
      return;
      i1 = 0;
      break label182;
    }
    if (paramBotReplyRequest.conversationType == 5)
      if (paramMsgInfo != null)
        break label368;
    label368: for (String str = ""; ; str = paramMsgInfo.getTitle())
    {
      com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.l.a.a(str, String.valueOf(paramBotReplyRequest.groupId)));
      com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.l.a.b());
      break;
    }
  }

  public void a(SendRichMessageRequest paramSendRichMessageRequest)
  {
    a(paramSendRichMessageRequest.getBotReplyRequest(), paramSendRichMessageRequest.getUrl(), paramSendRichMessageRequest.getTitle(), paramSendRichMessageRequest.getActionReplyData(), paramSendRichMessageRequest.isOriginalUrl());
  }

  public void a(String paramString)
  {
    int i1 = this.c.getPhoneController().generateSequence();
    this.c.getPublicAccountSubscribersCountController().handleGetPublicAccountSubscribersCount(i1, paramString);
  }

  public void a(String paramString, boolean paramBoolean)
  {
    a(this.c.getPhoneController().generateSequence(), paramString, paramBoolean);
  }

  public void b(com.viber.voip.bot.a parama)
  {
    a(parama, false, null);
  }

  public void b(BotReplyRequest paramBotReplyRequest)
  {
    c(paramBotReplyRequest);
  }

  public void b(SendRichMessageRequest paramSendRichMessageRequest)
  {
    a(paramSendRichMessageRequest.getBotReplyRequest(), paramSendRichMessageRequest.getUrl(), paramSendRichMessageRequest.getTitle(), paramSendRichMessageRequest.getActionReplyData(), paramSendRichMessageRequest.isOriginalUrl());
  }

  public boolean b(String paramString)
  {
    return this.x.contains(paramString);
  }

  public boolean c(String paramString)
  {
    b localb = (b)this.n.get(paramString);
    if (localb != null)
      return localb.b.g() == ReplyButton.b.QUERY;
    return false;
  }

  public void d(String paramString)
  {
    if (paramString != null)
      this.p.c(paramString);
  }

  public boolean e(String paramString)
  {
    int i1 = this.c.getPhoneController().generateSequence();
    this.o.put(paramString, Integer.valueOf(i1));
    return this.c.getPublicGroupController().handleRefreshPublicAccountToken(i1, paramString);
  }

  public boolean f(String paramString)
  {
    return this.o.containsKey(paramString);
  }

  public void onConnect()
  {
    int i1 = this.i.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      long l1 = this.i.keyAt(i2);
      a locala = (a)this.i.get(l1);
      a(locala.d, l1, locala.b, locala.c);
    }
    Iterator localIterator1 = this.n.values().iterator();
    while (localIterator1.hasNext())
    {
      b localb = (b)localIterator1.next();
      a(localb.b, b.a(localb), localb.c);
    }
    Iterator localIterator2 = com.viber.voip.model.e.a("key_pending_public_account_subscription", true).iterator();
    while (localIterator2.hasNext())
      a((String)localIterator2.next(), true);
    Iterator localIterator3 = com.viber.voip.model.e.a("key_pending_public_account_subscription", false).iterator();
    while (localIterator3.hasNext())
      a((String)localIterator3.next(), false);
  }

  public void onConnectionStateChange(int paramInt)
  {
  }

  public void onPublicAccountRefreshToken(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (((Integer)this.o.get(paramString1)).intValue() == paramInt2)
      this.o.remove(paramString1);
  }

  public void onPublicAccountSubscribersCount(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    PublicGroupConversationItemLoaderEntity localPublicGroupConversationItemLoaderEntity;
    if (paramInt1 == 0)
    {
      localPublicGroupConversationItemLoaderEntity = this.f.b(paramString);
      if (localPublicGroupConversationItemLoaderEntity != null)
        break label20;
    }
    label20: 
    do
    {
      do
        return;
      while (localPublicGroupConversationItemLoaderEntity.getSubscribersCount() == paramInt3);
      this.f.i(localPublicGroupConversationItemLoaderEntity.getGroupId(), paramInt3);
    }
    while ((localPublicGroupConversationItemLoaderEntity.isPendingRole()) || (2 != localPublicGroupConversationItemLoaderEntity.getGroupRole()));
    this.g.a(Collections.singleton(Long.valueOf(localPublicGroupConversationItemLoaderEntity.getId())), 2, true, false);
  }

  public void onSearchPublicAccounts(int paramInt1, PublicAccountInfo[] paramArrayOfPublicAccountInfo, int paramInt2)
  {
    c localc;
    ArrayList localArrayList;
    synchronized (this.k)
    {
      localc = (c)this.k.get(paramInt1);
      if (localc == null)
        return;
      localArrayList = new ArrayList(paramArrayOfPublicAccountInfo.length);
      int i1 = 0;
      if (i1 < paramArrayOfPublicAccountInfo.length)
      {
        PublicAccount localPublicAccount = new PublicAccount(paramArrayOfPublicAccountInfo[i1]);
        localPublicAccount.setGroupRole(3);
        localArrayList.add(localPublicAccount);
        i1++;
      }
    }
    a(paramInt1, localArrayList, paramInt2, localc);
  }

  public void onSearchPublicGroups(int paramInt1, PublicGroupInfo[] paramArrayOfPublicGroupInfo, int paramInt2)
  {
    c localc;
    ArrayList localArrayList;
    synchronized (this.k)
    {
      localc = (c)this.k.get(paramInt1);
      if (localc == null)
        return;
      localArrayList = new ArrayList(paramArrayOfPublicGroupInfo.length);
      int i1 = 0;
      if (i1 < paramArrayOfPublicGroupInfo.length)
      {
        localArrayList.add(new PublicAccount(paramArrayOfPublicGroupInfo[i1]));
        i1++;
      }
    }
    a(paramInt1, localArrayList, paramInt2, localc);
  }

  public void onSendConversationStatusReply(String paramString, int paramInt1, int paramInt2)
  {
    h localh;
    if ((1 != paramInt2) && (3 != paramInt2) && (a(paramString, paramInt1)))
    {
      localh = this.f.a(paramString, false);
      if (localh != null)
        break label73;
    }
    while (true)
    {
      if ((1 != paramInt2) && (b(paramString, paramInt1)))
      {
        if (3 == paramInt2)
          o.a().c(paramString);
        this.n.remove(paramString);
      }
      return;
      label73: this.i.remove(localh.getId());
    }
  }

  public void onSubscribeToPublicAccountReply(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, true);
  }

  public void onUnSubscribeFromPublicAccountReply(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, false);
  }

  private static final class a
  {
    public final int a;
    public final String b;
    public final String c;
    public int d;

    a(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      this.a = paramInt1;
      this.b = paramString1;
      this.c = paramString2;
      this.d = paramInt2;
    }

    public String toString()
    {
      return "PendingContext{seq=" + this.a + ", context='" + this.b + '\'' + ", publicAccountId='" + this.c + '\'' + ", status=" + this.d + '}';
    }
  }

  private static final class b
  {
    public final int a;
    public final com.viber.voip.bot.a b;
    public final MsgInfo c;
    private final boolean d;

    public b(int paramInt, com.viber.voip.bot.a parama, boolean paramBoolean, MsgInfo paramMsgInfo)
    {
      this.a = paramInt;
      this.b = parama;
      this.d = paramBoolean;
      this.c = paramMsgInfo;
    }
  }

  private static final class c
  {
    public final String a;
    public final ai.n b;

    public c(String paramString, ai.n paramn)
    {
      this.a = paramString;
      this.b = paramn;
    }
  }

  private abstract class d
  {
    private int a;

    private d()
    {
    }

    private void a(int paramInt, long paramLong)
    {
      Runnable local1 = new Runnable()
      {
        public void run()
        {
          w.this.onSearchPublicAccounts(w.d.a(w.d.this), new PublicAccountInfo[0], 2);
        }
      };
      synchronized (w.f(w.this))
      {
        w.f(w.this).put(paramInt, local1);
        av.a(av.e.g).postDelayed(local1, paramLong);
        return;
      }
    }

    public void a(String paramString, long paramLong, ai.n paramn)
    {
      if (paramn == null)
        return;
      this.a = w.d(w.this).getPhoneController().generateSequence();
      if (w.d(w.this).getPhoneController().isConnected())
        synchronized (w.e(w.this))
        {
          w.e(w.this).put(this.a, new w.c(paramString, paramn));
          if (paramLong > 0L)
            a(this.a, paramLong);
          a(this.a, w.d(w.this).getPublicGroupController());
          return;
        }
      paramn.a(paramString, Collections.emptyList());
    }

    public abstract boolean a(int paramInt, PublicGroupController paramPublicGroupController);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.publicaccount.w
 * JD-Core Version:    0.6.2
 */