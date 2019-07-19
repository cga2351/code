package com.viber.voip.messages.controller.b;

import android.content.Context;
import android.net.Uri;
import android.support.v4.util.Pair;
import com.viber.dexshared.Logger;
import com.viber.jni.PinInfo;
import com.viber.jni.PublicAccountInfo;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.CRecoverPublicAccountsReplyMsg.Receiver;
import com.viber.jni.im2.PublicAccountUserInfoShort;
import com.viber.jni.im2.RecoveredPublicAccountDeleteAllUsersMessages;
import com.viber.jni.publicaccount.PublicAccountControllerDelegate.PublicAccountDelegate;
import com.viber.jni.publicaccount.PublicAccountControllerDelegate.PublicAccountInfoReceiver;
import com.viber.provider.b;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.Pin;
import com.viber.voip.flatbuffers.model.msginfo.Pin.a;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.a.d.d;
import com.viber.voip.messages.controller.bn;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.bs.e;
import com.viber.voip.messages.controller.bs.e.a;
import com.viber.voip.messages.controller.bs.f;
import com.viber.voip.messages.controller.c.c;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.d.j;
import com.viber.voip.messages.orm.entity.impl.PublicAccountEntityHelper;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.model.entity.r;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.util.at;
import com.viber.voip.util.av;
import com.viber.voip.util.da;
import com.viber.voip.util.dk;
import com.viber.voip.util.dx;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;

public class p
  implements CRecoverPublicAccountsReplyMsg.Receiver, PublicAccountControllerDelegate.PublicAccountDelegate, PublicAccountControllerDelegate.PublicAccountInfoReceiver
{
  private static final Logger i = ViberEnv.getLogger();
  protected j a;
  protected o b;
  protected dagger.a<bs> c;
  protected ab d;
  protected com.viber.voip.messages.controller.af e;
  protected ak f;
  protected Set<Long> g = new HashSet();
  protected EventBus h;
  private final Context j;
  private final bn k;
  private Map<String, com.viber.jni.im2.ChatUserInfo> l = new HashMap();
  private PhoneController m;
  private final com.viber.voip.messages.controller.a n;
  private com.viber.voip.registration.af o;

  public p(Context paramContext, com.viber.voip.messages.controller.af paramaf, com.viber.voip.registration.af paramaf1, PhoneController paramPhoneController, com.viber.voip.messages.controller.a parama, dagger.a<bs> parama1, bn parambn)
  {
    this.j = paramContext;
    this.k = parambn;
    this.d = ab.b();
    this.b = o.a();
    this.f = ak.a();
    this.c = parama1;
    this.e = paramaf;
    this.a = new j(this.b, parama1, this.d, paramaf1);
    this.h = com.viber.voip.h.a.b();
    this.m = paramPhoneController;
    this.n = parama;
    this.o = paramaf1;
  }

  private r a(PublicAccountInfo paramPublicAccountInfo)
  {
    r localr = this.d.d(paramPublicAccountInfo.getPublicChatId());
    if (localr == null)
      localr = this.d.a(paramPublicAccountInfo.getPublicAccountID());
    if (localr == null);
    return localr;
  }

  private void a(long paramLong, int paramInt)
  {
    Integer localInteger = com.viber.voip.model.e.a(String.valueOf(paramLong), "key_not_changed_public_group_info");
    if (localInteger != null)
    {
      Pair localPair = this.e.g(localInteger.intValue());
      if (localPair != null)
      {
        ((PublicAccount)localPair.second).setRevision(paramInt);
        this.e.a(localInteger.intValue(), ((Integer)localPair.first).intValue(), (PublicAccount)localPair.second);
      }
      com.viber.voip.model.e.a(String.valueOf(paramLong), new String[] { "key_not_changed_public_group_info" });
    }
  }

  private void a(PublicAccountInfo paramPublicAccountInfo, long paramLong)
  {
    if ((paramPublicAccountInfo.getDeleteAllUserMessagesInfos() != null) && (paramPublicAccountInfo.getDeleteAllUserMessagesInfos().length > 0))
    {
      HashSet localHashSet = new HashSet(paramPublicAccountInfo.getDeleteAllUserMessagesInfos().length);
      com.viber.jni.DeleteAllUserMessagesInfo[] arrayOfDeleteAllUserMessagesInfo = paramPublicAccountInfo.getDeleteAllUserMessagesInfos();
      int i1 = arrayOfDeleteAllUserMessagesInfo.length;
      int i2 = 0;
      if (i2 < i1)
      {
        com.viber.jni.DeleteAllUserMessagesInfo localDeleteAllUserMessagesInfo = arrayOfDeleteAllUserMessagesInfo[i2];
        if (localDeleteAllUserMessagesInfo == null);
        while (true)
        {
          i2++;
          break;
          if (com.viber.voip.messages.m.a(this.o, localDeleteAllUserMessagesInfo.getUser()))
            localHashSet.add(new com.viber.voip.publicaccount.entity.a(localDeleteAllUserMessagesInfo.getToken(), localDeleteAllUserMessagesInfo.getUser(), true));
          else if (this.f.c(new Member(localDeleteAllUserMessagesInfo.getUser(), null, null, null, localDeleteAllUserMessagesInfo.getUser()), 2) != null)
            localHashSet.add(new com.viber.voip.publicaccount.entity.a(localDeleteAllUserMessagesInfo.getToken(), localDeleteAllUserMessagesInfo.getUser(), false));
          else
            localHashSet.add(new com.viber.voip.publicaccount.entity.a(localDeleteAllUserMessagesInfo.getToken(), localDeleteAllUserMessagesInfo.getUser(), false));
        }
      }
      ((bs)this.c.get()).a(paramPublicAccountInfo.getPublicChatId(), paramLong, localHashSet);
    }
  }

  private void a(PublicAccountInfo paramPublicAccountInfo, r paramr)
  {
    PublicAccountEntityHelper.createEntity(paramr, new PublicAccount(paramPublicAccountInfo, paramr.r(), paramr.W(), paramr.R()));
    paramr.l(av.b(paramr.A(), 2));
    this.d.b(paramr);
  }

  private void a(RecoveredPublicAccountDeleteAllUsersMessages paramRecoveredPublicAccountDeleteAllUsersMessages, long paramLong)
  {
    if ((paramRecoveredPublicAccountDeleteAllUsersMessages.deleteAllUsersMessagesInfo != null) && (paramRecoveredPublicAccountDeleteAllUsersMessages.deleteAllUsersMessagesInfo.length > 0))
    {
      HashSet localHashSet = new HashSet(paramRecoveredPublicAccountDeleteAllUsersMessages.deleteAllUsersMessagesInfo.length);
      com.viber.jni.im2.DeleteAllUserMessagesInfo[] arrayOfDeleteAllUserMessagesInfo = paramRecoveredPublicAccountDeleteAllUsersMessages.deleteAllUsersMessagesInfo;
      int i1 = arrayOfDeleteAllUserMessagesInfo.length;
      int i2 = 0;
      if (i2 < i1)
      {
        com.viber.jni.im2.DeleteAllUserMessagesInfo localDeleteAllUserMessagesInfo = arrayOfDeleteAllUserMessagesInfo[i2];
        if (localDeleteAllUserMessagesInfo == null);
        while (true)
        {
          i2++;
          break;
          com.viber.jni.DeleteAllUserMessagesInfo localDeleteAllUserMessagesInfo1 = localDeleteAllUserMessagesInfo.toLegacyDeleteAllUserMessagesInfo();
          if (com.viber.voip.messages.m.a(this.o, localDeleteAllUserMessagesInfo1.getUser()))
            localHashSet.add(new com.viber.voip.publicaccount.entity.a(localDeleteAllUserMessagesInfo1.getToken(), localDeleteAllUserMessagesInfo1.getUser(), true));
          else if (this.f.c(new Member(localDeleteAllUserMessagesInfo1.getUser(), null, null, null, localDeleteAllUserMessagesInfo1.getUser()), 2) != null)
            localHashSet.add(new com.viber.voip.publicaccount.entity.a(localDeleteAllUserMessagesInfo1.getToken(), localDeleteAllUserMessagesInfo1.getUser(), false));
          else
            localHashSet.add(new com.viber.voip.publicaccount.entity.a(localDeleteAllUserMessagesInfo1.getToken(), localDeleteAllUserMessagesInfo1.getUser(), false));
        }
      }
      ((bs)this.c.get()).a(paramRecoveredPublicAccountDeleteAllUsersMessages.publicChatId, paramLong, localHashSet);
    }
  }

  private void a(h paramh, PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramh == null);
    MessageEntity localMessageEntity;
    com.viber.voip.model.entity.m localm;
    do
    {
      do
      {
        boolean bool1;
        do
        {
          return;
          int i1 = paramh.j();
          int i2 = 0;
          if (i1 != 0)
          {
            boolean bool2 = paramPublicAccountInfo.getGroupName().equals(paramh.o());
            i2 = 0;
            if (!bool2)
            {
              paramh.b(paramPublicAccountInfo.getGroupName());
              i2 = 1;
            }
            Uri localUri = dx.g(paramPublicAccountInfo.getIconDownloadID());
            if (!dk.a(localUri, paramh.q()))
            {
              paramh.a(localUri);
              i2 = 1;
            }
            if (paramh.p() != paramPublicAccountInfo.getUserRole())
            {
              paramh.c(paramPublicAccountInfo.getUserRole());
              i2 = 1;
            }
            if ((paramh.p() != 3) && (paramh.f()))
            {
              paramh.a(2);
              i2 = 1;
            }
          }
          bool1 = paramh.J();
          if (bool1)
          {
            paramh.h(18);
            i2 = 1;
          }
          if (i2 != 0)
          {
            this.d.b(paramh);
            this.h.post(new d.d(paramh.j()));
            this.b.a(Collections.singleton(Long.valueOf(paramh.getId())), paramh.j(), true, true);
          }
        }
        while (!bool1);
        localMessageEntity = this.d.R(paramh.getId());
      }
      while (localMessageEntity == null);
      localm = ak.a().a(localMessageEntity.getParticipantId());
    }
    while (localm == null);
    this.k.a(paramh, localm, localMessageEntity);
  }

  private void a(PinInfo[] paramArrayOfPinInfo, h paramh, int paramInt)
  {
    int i1 = paramArrayOfPinInfo.length;
    int i2 = 0;
    while (i2 < i1)
    {
      PinInfo localPinInfo = paramArrayOfPinInfo[i2];
      if (localPinInfo == null)
      {
        i2++;
      }
      else
      {
        if ((paramInt > localPinInfo.getSeqInPG()) || (paramh.f()));
        for (int i3 = 64; ; i3 = 0)
        {
          MsgInfo localMsgInfo = (MsgInfo)com.viber.voip.flatbuffers.b.e.a().a().a(localPinInfo.getMsgInfo());
          if ((localMsgInfo.getPin() == null) || (localMsgInfo.getPin().getAction() == Pin.a.DELETE))
            break;
          String str = localMsgInfo.getPin().getNumber();
          if (da.a(str))
            break;
          MessageEntity localMessageEntity = new com.viber.voip.messages.controller.c.a(paramh.k(), str, localPinInfo.getToken(), localPinInfo.getPinTime(), i3, 0, null, paramh.j(), paramh.l(), paramh.ah()).a(0, "", localPinInfo.getSeqInPG(), localPinInfo.getMsgInfo(), 0);
          ((bs)this.c.get()).a(localMessageEntity);
          break;
        }
      }
    }
  }

  private com.viber.jni.ChatUserInfo[] a(PublicAccountUserInfoShort[] paramArrayOfPublicAccountUserInfoShort, Map<String, com.viber.jni.im2.ChatUserInfo> paramMap)
  {
    com.viber.jni.ChatUserInfo[] arrayOfChatUserInfo = new com.viber.jni.ChatUserInfo[paramArrayOfPublicAccountUserInfoShort.length];
    int i1 = paramArrayOfPublicAccountUserInfoShort.length;
    int i2 = 0;
    int i3 = 0;
    int i5;
    if (i2 < i1)
    {
      PublicAccountUserInfoShort localPublicAccountUserInfoShort = paramArrayOfPublicAccountUserInfoShort[i2];
      String str = localPublicAccountUserInfoShort.mid;
      if (!paramMap.containsKey(str))
        break label96;
      com.viber.jni.im2.ChatUserInfo localChatUserInfo = (com.viber.jni.im2.ChatUserInfo)paramMap.get(str);
      i5 = i3 + 1;
      arrayOfChatUserInfo[i3] = localChatUserInfo.toLegacyChatUserInfoWithRole(localPublicAccountUserInfoShort.groupRole);
    }
    label96: for (int i4 = i5; ; i4 = i3)
    {
      i2++;
      i3 = i4;
      break;
      return arrayOfChatUserInfo;
    }
  }

  protected void a(int paramInt1, long paramLong, r paramr, h paramh, int paramInt2, int paramInt3)
  {
    if (av.c(paramr.A(), 2))
      return;
    if (paramh != null);
    for (int i1 = paramh.j(); ; i1 = 2)
    {
      if (paramh != null)
        this.d.a("conversations", paramh.getId(), "group_role", Integer.valueOf(paramInt3));
      this.d.a(paramr.getId(), 2, true);
      this.e.a(paramInt1, paramLong, paramr.b(), paramInt2, i1, paramInt3);
      return;
    }
  }

  // ERROR //
  public void onCRecoverPublicAccountsReplyMsg(com.viber.jni.im2.CRecoverPublicAccountsReplyMsg paramCRecoverPublicAccountsReplyMsg)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 509	com/viber/jni/im2/CRecoverPublicAccountsReplyMsg:status	I
    //   4: ifne +926 -> 930
    //   7: aload_1
    //   8: getfield 512	com/viber/jni/im2/CRecoverPublicAccountsReplyMsg:chunkSeq	B
    //   11: ifne +12 -> 23
    //   14: aload_0
    //   15: getfield 67	com/viber/voip/messages/controller/b/p:l	Ljava/util/Map;
    //   18: invokeinterface 515 1 0
    //   23: aload_0
    //   24: getfield 67	com/viber/voip/messages/controller/b/p:l	Ljava/util/Map;
    //   27: aload_1
    //   28: getfield 518	com/viber/jni/im2/CRecoverPublicAccountsReplyMsg:users	Ljava/util/Map;
    //   31: invokeinterface 522 2 0
    //   36: new 524	android/support/v4/util/LongSparseArray
    //   39: dup
    //   40: aload_1
    //   41: getfield 528	com/viber/jni/im2/CRecoverPublicAccountsReplyMsg:publicAccounts	[Lcom/viber/jni/im2/RecoveredPublicAccountInfo;
    //   44: arraylength
    //   45: invokespecial 529	android/support/v4/util/LongSparseArray:<init>	(I)V
    //   48: astore_2
    //   49: new 524	android/support/v4/util/LongSparseArray
    //   52: dup
    //   53: aload_1
    //   54: getfield 528	com/viber/jni/im2/CRecoverPublicAccountsReplyMsg:publicAccounts	[Lcom/viber/jni/im2/RecoveredPublicAccountInfo;
    //   57: arraylength
    //   58: invokespecial 529	android/support/v4/util/LongSparseArray:<init>	(I)V
    //   61: astore_3
    //   62: new 531	java/util/ArrayList
    //   65: dup
    //   66: invokespecial 532	java/util/ArrayList:<init>	()V
    //   69: astore 4
    //   71: new 531	java/util/ArrayList
    //   74: dup
    //   75: invokespecial 532	java/util/ArrayList:<init>	()V
    //   78: astore 5
    //   80: aload_1
    //   81: getfield 528	com/viber/jni/im2/CRecoverPublicAccountsReplyMsg:publicAccounts	[Lcom/viber/jni/im2/RecoveredPublicAccountInfo;
    //   84: astore 6
    //   86: aload 6
    //   88: arraylength
    //   89: istore 7
    //   91: iconst_0
    //   92: istore 8
    //   94: iload 8
    //   96: iload 7
    //   98: if_icmpge +196 -> 294
    //   101: aload 6
    //   103: iload 8
    //   105: aaload
    //   106: astore 31
    //   108: iconst_0
    //   109: istore 32
    //   111: aload_1
    //   112: getfield 536	com/viber/jni/im2/CRecoverPublicAccountsReplyMsg:publicAccountsMoreInfo	[Lcom/viber/jni/im2/RecoveredPublicAccountMoreInfo;
    //   115: arraylength
    //   116: istore 33
    //   118: iload 32
    //   120: iload 33
    //   122: if_icmpge +38 -> 160
    //   125: aload 31
    //   127: getfield 539	com/viber/jni/im2/RecoveredPublicAccountInfo:publicChatId	J
    //   130: aload_1
    //   131: getfield 536	com/viber/jni/im2/CRecoverPublicAccountsReplyMsg:publicAccountsMoreInfo	[Lcom/viber/jni/im2/RecoveredPublicAccountMoreInfo;
    //   134: iload 32
    //   136: aaload
    //   137: getfield 542	com/viber/jni/im2/RecoveredPublicAccountMoreInfo:publicChatId	J
    //   140: lcmp
    //   141: ifne +93 -> 234
    //   144: aload_2
    //   145: aload 31
    //   147: getfield 539	com/viber/jni/im2/RecoveredPublicAccountInfo:publicChatId	J
    //   150: aload_1
    //   151: getfield 536	com/viber/jni/im2/CRecoverPublicAccountsReplyMsg:publicAccountsMoreInfo	[Lcom/viber/jni/im2/RecoveredPublicAccountMoreInfo;
    //   154: iload 32
    //   156: aaload
    //   157: invokevirtual 546	android/support/v4/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   160: iconst_0
    //   161: istore 34
    //   163: aload_1
    //   164: getfield 550	com/viber/jni/im2/CRecoverPublicAccountsReplyMsg:publicAccountsDeleteAllUsersMessages	[Lcom/viber/jni/im2/RecoveredPublicAccountDeleteAllUsersMessages;
    //   167: arraylength
    //   168: istore 35
    //   170: iload 34
    //   172: iload 35
    //   174: if_icmpge +38 -> 212
    //   177: aload 31
    //   179: getfield 539	com/viber/jni/im2/RecoveredPublicAccountInfo:publicChatId	J
    //   182: aload_1
    //   183: getfield 550	com/viber/jni/im2/CRecoverPublicAccountsReplyMsg:publicAccountsDeleteAllUsersMessages	[Lcom/viber/jni/im2/RecoveredPublicAccountDeleteAllUsersMessages;
    //   186: iload 34
    //   188: aaload
    //   189: getfield 281	com/viber/jni/im2/RecoveredPublicAccountDeleteAllUsersMessages:publicChatId	J
    //   192: lcmp
    //   193: ifne +47 -> 240
    //   196: aload_3
    //   197: aload 31
    //   199: getfield 539	com/viber/jni/im2/RecoveredPublicAccountInfo:publicChatId	J
    //   202: aload_1
    //   203: getfield 550	com/viber/jni/im2/CRecoverPublicAccountsReplyMsg:publicAccountsDeleteAllUsersMessages	[Lcom/viber/jni/im2/RecoveredPublicAccountDeleteAllUsersMessages;
    //   206: iload 34
    //   208: aaload
    //   209: invokevirtual 546	android/support/v4/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   212: aload 31
    //   214: getfield 553	com/viber/jni/im2/RecoveredPublicAccountInfo:userSubscribeState	B
    //   217: ifne +29 -> 246
    //   220: aload 4
    //   222: aload 31
    //   224: invokevirtual 554	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   227: pop
    //   228: iinc 8 1
    //   231: goto -137 -> 94
    //   234: iinc 32 1
    //   237: goto -119 -> 118
    //   240: iinc 34 1
    //   243: goto -73 -> 170
    //   246: aload 31
    //   248: getfield 553	com/viber/jni/im2/RecoveredPublicAccountInfo:userSubscribeState	B
    //   251: iconst_1
    //   252: if_icmpne +14 -> 266
    //   255: aload 5
    //   257: aload 31
    //   259: invokevirtual 554	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   262: pop
    //   263: goto -35 -> 228
    //   266: aload 31
    //   268: getfield 553	com/viber/jni/im2/RecoveredPublicAccountInfo:userSubscribeState	B
    //   271: iconst_2
    //   272: if_icmpne -44 -> 228
    //   275: aload 5
    //   277: aload 31
    //   279: invokevirtual 554	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   282: pop
    //   283: aload 4
    //   285: aload 31
    //   287: invokevirtual 554	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   290: pop
    //   291: goto -63 -> 228
    //   294: aload_1
    //   295: getfield 528	com/viber/jni/im2/CRecoverPublicAccountsReplyMsg:publicAccounts	[Lcom/viber/jni/im2/RecoveredPublicAccountInfo;
    //   298: arraylength
    //   299: ifle +554 -> 853
    //   302: invokestatic 559	com/viber/voip/publicaccount/d/a:a	()Lcom/viber/voip/publicaccount/d/a;
    //   305: invokevirtual 561	com/viber/voip/publicaccount/d/a:b	()V
    //   308: new 59	java/util/HashSet
    //   311: dup
    //   312: aload 5
    //   314: invokevirtual 564	java/util/ArrayList:size	()I
    //   317: invokespecial 186	java/util/HashSet:<init>	(I)V
    //   320: astore 9
    //   322: aload 5
    //   324: invokevirtual 568	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   327: astore 10
    //   329: aload 10
    //   331: invokeinterface 573 1 0
    //   336: ifeq +30 -> 366
    //   339: aload 9
    //   341: aload 10
    //   343: invokeinterface 576 1 0
    //   348: checkcast 538	com/viber/jni/im2/RecoveredPublicAccountInfo
    //   351: getfield 539	com/viber/jni/im2/RecoveredPublicAccountInfo:publicChatId	J
    //   354: invokestatic 350	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   357: invokeinterface 210 2 0
    //   362: pop
    //   363: goto -34 -> 329
    //   366: invokestatic 579	com/viber/voip/messages/controller/manager/ab:f	()Lcom/viber/provider/b;
    //   369: astore 11
    //   371: aload 11
    //   373: invokeinterface 583 1 0
    //   378: aload 4
    //   380: invokevirtual 568	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   383: astore 13
    //   385: aload 13
    //   387: invokeinterface 573 1 0
    //   392: ifeq +336 -> 728
    //   395: aload 13
    //   397: invokeinterface 576 1 0
    //   402: checkcast 538	com/viber/jni/im2/RecoveredPublicAccountInfo
    //   405: astore 18
    //   407: aload_3
    //   408: aload 18
    //   410: getfield 539	com/viber/jni/im2/RecoveredPublicAccountInfo:publicChatId	J
    //   413: invokevirtual 586	android/support/v4/util/LongSparseArray:get	(J)Ljava/lang/Object;
    //   416: checkcast 267	com/viber/jni/im2/RecoveredPublicAccountDeleteAllUsersMessages
    //   419: astore 19
    //   421: aload_2
    //   422: aload 18
    //   424: getfield 539	com/viber/jni/im2/RecoveredPublicAccountInfo:publicChatId	J
    //   427: invokevirtual 586	android/support/v4/util/LongSparseArray:get	(J)Ljava/lang/Object;
    //   430: checkcast 541	com/viber/jni/im2/RecoveredPublicAccountMoreInfo
    //   433: astore 20
    //   435: new 166	com/viber/voip/publicaccount/entity/PublicAccount
    //   438: dup
    //   439: aload 18
    //   441: aload 20
    //   443: invokespecial 589	com/viber/voip/publicaccount/entity/PublicAccount:<init>	(Lcom/viber/jni/im2/RecoveredPublicAccountInfo;Lcom/viber/jni/im2/RecoveredPublicAccountMoreInfo;)V
    //   446: astore 21
    //   448: aload 21
    //   450: aload 9
    //   452: aload 18
    //   454: getfield 539	com/viber/jni/im2/RecoveredPublicAccountInfo:publicChatId	J
    //   457: invokestatic 350	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   460: invokeinterface 592 2 0
    //   465: invokevirtual 596	com/viber/voip/publicaccount/entity/PublicAccount:setSubscriptionExists	(Z)V
    //   468: aload 18
    //   470: getfield 539	com/viber/jni/im2/RecoveredPublicAccountInfo:publicChatId	J
    //   473: aload 18
    //   475: getfield 599	com/viber/jni/im2/RecoveredPublicAccountInfo:groupType	B
    //   478: invokestatic 602	com/viber/voip/model/entity/h:a	(JI)I
    //   481: istore 22
    //   483: iload 22
    //   485: invokestatic 605	com/viber/voip/messages/m:b	(I)Z
    //   488: istore 23
    //   490: invokestatic 610	com/viber/voip/messages/controller/bs$e:a	()Lcom/viber/voip/messages/controller/bs$e$a;
    //   493: iload 23
    //   495: invokevirtual 615	com/viber/voip/messages/controller/bs$e$a:a	(Z)Lcom/viber/voip/messages/controller/bs$e$a;
    //   498: getstatic 621	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   501: invokevirtual 624	com/viber/voip/messages/controller/bs$e$a:a	(Ljava/lang/Boolean;)Lcom/viber/voip/messages/controller/bs$e$a;
    //   504: invokevirtual 627	com/viber/voip/messages/controller/bs$e$a:a	()Lcom/viber/voip/messages/controller/bs$e;
    //   507: astore 24
    //   509: aload_0
    //   510: getfield 94	com/viber/voip/messages/controller/b/p:c	Ldagger/a;
    //   513: invokeinterface 224 1 0
    //   518: checkcast 226	com/viber/voip/messages/controller/bs
    //   521: aload_0
    //   522: getfield 112	com/viber/voip/messages/controller/b/p:m	Lcom/viber/jni/controller/PhoneController;
    //   525: invokeinterface 632 1 0
    //   530: aload 18
    //   532: getfield 539	com/viber/jni/im2/RecoveredPublicAccountInfo:publicChatId	J
    //   535: iload 22
    //   537: aconst_null
    //   538: aload 21
    //   540: invokestatic 636	com/viber/voip/util/ae:a	()J
    //   543: aload 24
    //   545: invokevirtual 639	com/viber/voip/messages/controller/bs:a	(IJILandroid/support/v4/util/Pair;Lcom/viber/voip/publicaccount/entity/PublicAccount;JLcom/viber/voip/messages/controller/bs$e;)Lcom/viber/voip/messages/controller/bs$f;
    //   548: astore 25
    //   550: aload_0
    //   551: aload 18
    //   553: getfield 643	com/viber/jni/im2/RecoveredPublicAccountInfo:members	[Lcom/viber/jni/im2/PublicAccountUserInfoShort;
    //   556: aload_0
    //   557: getfield 67	com/viber/voip/messages/controller/b/p:l	Ljava/util/Map;
    //   560: invokespecial 645	com/viber/voip/messages/controller/b/p:a	([Lcom/viber/jni/im2/PublicAccountUserInfoShort;Ljava/util/Map;)[Lcom/viber/jni/ChatUserInfo;
    //   563: astore 29
    //   565: aload_0
    //   566: getfield 103	com/viber/voip/messages/controller/b/p:a	Lcom/viber/voip/messages/d/j;
    //   569: aload 25
    //   571: getfield 650	com/viber/voip/messages/controller/bs$f:f	Lcom/viber/voip/model/entity/h;
    //   574: invokevirtual 345	com/viber/voip/model/entity/h:getId	()J
    //   577: aload 25
    //   579: getfield 650	com/viber/voip/messages/controller/bs$f:f	Lcom/viber/voip/model/entity/h;
    //   582: invokevirtual 286	com/viber/voip/model/entity/h:j	()I
    //   585: aload 18
    //   587: getfield 653	com/viber/jni/im2/RecoveredPublicAccountInfo:userRole	B
    //   590: aload 29
    //   592: invokevirtual 656	com/viber/voip/messages/d/j:a	(JII[Lcom/viber/jni/ChatUserInfo;)V
    //   595: aload 20
    //   597: ifnull +63 -> 660
    //   600: aload 20
    //   602: getfield 660	com/viber/jni/im2/RecoveredPublicAccountMoreInfo:pinsInfo	[Lcom/viber/jni/im2/PinInfo;
    //   605: arraylength
    //   606: anewarray 378	com/viber/jni/PinInfo
    //   609: astore 27
    //   611: iconst_0
    //   612: istore 28
    //   614: iload 28
    //   616: aload 27
    //   618: arraylength
    //   619: if_icmpge +25 -> 644
    //   622: aload 27
    //   624: iload 28
    //   626: aload 20
    //   628: getfield 660	com/viber/jni/im2/RecoveredPublicAccountMoreInfo:pinsInfo	[Lcom/viber/jni/im2/PinInfo;
    //   631: iload 28
    //   633: aaload
    //   634: invokevirtual 666	com/viber/jni/im2/PinInfo:toLegacyPinInfo	()Lcom/viber/jni/PinInfo;
    //   637: aastore
    //   638: iinc 28 1
    //   641: goto -27 -> 614
    //   644: aload_0
    //   645: aload 27
    //   647: aload 25
    //   649: getfield 650	com/viber/voip/messages/controller/bs$f:f	Lcom/viber/voip/model/entity/h;
    //   652: aload 18
    //   654: getfield 669	com/viber/jni/im2/RecoveredPublicAccountInfo:lastMsgSeqID	I
    //   657: invokespecial 671	com/viber/voip/messages/controller/b/p:a	([Lcom/viber/jni/PinInfo;Lcom/viber/voip/model/entity/h;I)V
    //   660: aload 19
    //   662: ifnull +17 -> 679
    //   665: aload_0
    //   666: aload 19
    //   668: aload 25
    //   670: getfield 650	com/viber/voip/messages/controller/bs$f:f	Lcom/viber/voip/model/entity/h;
    //   673: invokevirtual 345	com/viber/voip/model/entity/h:getId	()J
    //   676: invokespecial 673	com/viber/voip/messages/controller/b/p:a	(Lcom/viber/jni/im2/RecoveredPublicAccountDeleteAllUsersMessages;J)V
    //   679: iload 23
    //   681: ifeq -296 -> 385
    //   684: aload 25
    //   686: getfield 650	com/viber/voip/messages/controller/bs$f:f	Lcom/viber/voip/model/entity/h;
    //   689: invokevirtual 320	com/viber/voip/model/entity/h:p	()I
    //   692: invokestatic 676	com/viber/voip/util/cd:b	(I)Z
    //   695: ifeq -310 -> 385
    //   698: aload_0
    //   699: getfield 114	com/viber/voip/messages/controller/b/p:n	Lcom/viber/voip/messages/controller/a;
    //   702: aload 25
    //   704: getfield 650	com/viber/voip/messages/controller/bs$f:f	Lcom/viber/voip/model/entity/h;
    //   707: invokevirtual 429	com/viber/voip/model/entity/h:k	()J
    //   710: invokevirtual 681	com/viber/voip/messages/controller/a:a	(J)V
    //   713: goto -328 -> 385
    //   716: astore 12
    //   718: aload 11
    //   720: invokeinterface 682 1 0
    //   725: aload 12
    //   727: athrow
    //   728: aload 5
    //   730: invokevirtual 568	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   733: astore 14
    //   735: aload 14
    //   737: invokeinterface 573 1 0
    //   742: ifeq +97 -> 839
    //   745: aload 14
    //   747: invokeinterface 576 1 0
    //   752: checkcast 538	com/viber/jni/im2/RecoveredPublicAccountInfo
    //   755: astore 15
    //   757: new 166	com/viber/voip/publicaccount/entity/PublicAccount
    //   760: dup
    //   761: aload 15
    //   763: aload_2
    //   764: aload 15
    //   766: getfield 539	com/viber/jni/im2/RecoveredPublicAccountInfo:publicChatId	J
    //   769: invokevirtual 586	android/support/v4/util/LongSparseArray:get	(J)Ljava/lang/Object;
    //   772: checkcast 541	com/viber/jni/im2/RecoveredPublicAccountMoreInfo
    //   775: invokespecial 589	com/viber/voip/publicaccount/entity/PublicAccount:<init>	(Lcom/viber/jni/im2/RecoveredPublicAccountInfo;Lcom/viber/jni/im2/RecoveredPublicAccountMoreInfo;)V
    //   778: astore 16
    //   780: aload 16
    //   782: iconst_1
    //   783: invokevirtual 596	com/viber/voip/publicaccount/entity/PublicAccount:setSubscriptionExists	(Z)V
    //   786: aload_0
    //   787: getfield 94	com/viber/voip/messages/controller/b/p:c	Ldagger/a;
    //   790: invokeinterface 224 1 0
    //   795: checkcast 226	com/viber/voip/messages/controller/bs
    //   798: aconst_null
    //   799: aconst_null
    //   800: invokestatic 636	com/viber/voip/util/ae:a	()J
    //   803: new 212	com/viber/voip/memberid/Member
    //   806: dup
    //   807: aload 15
    //   809: getfield 685	com/viber/jni/im2/RecoveredPublicAccountInfo:publicAccountID	Ljava/lang/String;
    //   812: aload 15
    //   814: getfield 685	com/viber/jni/im2/RecoveredPublicAccountInfo:publicAccountID	Ljava/lang/String;
    //   817: invokespecial 688	com/viber/voip/memberid/Member:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   820: lconst_0
    //   821: ldc_w 443
    //   824: iconst_0
    //   825: iconst_0
    //   826: iconst_1
    //   827: iconst_0
    //   828: iconst_0
    //   829: aload 16
    //   831: aconst_null
    //   832: invokevirtual 691	com/viber/voip/messages/controller/bs:a	(Lcom/viber/voip/model/entity/MessageEntity;Lcom/viber/voip/model/entity/MessageCallEntity;JLcom/viber/voip/memberid/Member;JLjava/lang/String;IIIZILcom/viber/voip/publicaccount/entity/PublicAccount;Ljava/lang/String;)Lcom/viber/voip/messages/controller/bs$f;
    //   835: pop
    //   836: goto -101 -> 735
    //   839: aload 11
    //   841: invokeinterface 693 1 0
    //   846: aload 11
    //   848: invokeinterface 682 1 0
    //   853: aload_1
    //   854: getfield 697	com/viber/jni/im2/CRecoverPublicAccountsReplyMsg:last	Z
    //   857: ifeq +72 -> 929
    //   860: aload_0
    //   861: getfield 67	com/viber/voip/messages/controller/b/p:l	Ljava/util/Map;
    //   864: invokeinterface 515 1 0
    //   869: aload_0
    //   870: getfield 78	com/viber/voip/messages/controller/b/p:d	Lcom/viber/voip/messages/controller/manager/ab;
    //   873: invokevirtual 700	com/viber/voip/messages/controller/manager/ab:E	()J
    //   876: lconst_0
    //   877: lcmp
    //   878: ifle +10 -> 888
    //   881: aload_0
    //   882: getfield 114	com/viber/voip/messages/controller/b/p:n	Lcom/viber/voip/messages/controller/a;
    //   885: invokevirtual 701	com/viber/voip/messages/controller/a:b	()V
    //   888: getstatic 706	com/viber/voip/settings/d$r:i	Lcom/viber/common/b/b;
    //   891: iconst_0
    //   892: invokevirtual 710	com/viber/common/b/b:a	(Z)V
    //   895: aload_0
    //   896: getfield 110	com/viber/voip/messages/controller/b/p:h	Lorg/greenrobot/eventbus/EventBus;
    //   899: new 712	com/viber/voip/messages/a/d$a
    //   902: dup
    //   903: invokespecial 713	com/viber/voip/messages/a/d$a:<init>	()V
    //   906: invokevirtual 342	org/greenrobot/eventbus/EventBus:post	(Ljava/lang/Object;)V
    //   909: aload 4
    //   911: invokevirtual 564	java/util/ArrayList:size	()I
    //   914: ifne +15 -> 929
    //   917: aload 5
    //   919: invokevirtual 564	java/util/ArrayList:size	()I
    //   922: ifne +7 -> 929
    //   925: iconst_4
    //   926: invokestatic 716	com/viber/voip/analytics/story/k:a	(I)V
    //   929: return
    //   930: aload_1
    //   931: getfield 509	com/viber/jni/im2/CRecoverPublicAccountsReplyMsg:status	I
    //   934: iconst_1
    //   935: if_icmpeq -6 -> 929
    //   938: aload_1
    //   939: getfield 509	com/viber/jni/im2/CRecoverPublicAccountsReplyMsg:status	I
    //   942: iconst_2
    //   943: if_icmpne -14 -> 929
    //   946: getstatic 706	com/viber/voip/settings/d$r:i	Lcom/viber/common/b/b;
    //   949: iconst_0
    //   950: invokevirtual 710	com/viber/common/b/b:a	(Z)V
    //   953: iconst_4
    //   954: invokestatic 716	com/viber/voip/analytics/story/k:a	(I)V
    //   957: return
    //   958: astore 26
    //   960: goto -365 -> 595
    //
    // Exception table:
    //   from	to	target	type
    //   378	385	716	finally
    //   385	550	716	finally
    //   550	595	716	finally
    //   600	611	716	finally
    //   614	638	716	finally
    //   644	660	716	finally
    //   665	679	716	finally
    //   684	713	716	finally
    //   728	735	716	finally
    //   735	836	716	finally
    //   839	846	716	finally
    //   550	595	958	com/viber/voip/publicaccount/c/a
  }

  public void onChangePublicAccountReply(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    h localh = this.d.b(paramLong1);
    if (localh == null)
      return;
    Pair localPair = this.e.g(paramInt1);
    if (localPair == null);
    for (int i1 = 0; ; i1 = ((Integer)localPair.first).intValue())
      switch (paramInt4)
      {
      default:
        this.b.a(paramInt1, paramLong1, paramInt4, i1);
        this.e.h(paramInt1);
        return;
      case 1:
      case 6:
      }
    if (localPair == null)
    {
      this.e.a(paramInt1, paramLong1, null, paramInt3, 2, localh.p());
      return;
    }
    r localr = this.d.d(paramLong1);
    String str = localh.o();
    ((PublicAccount)localPair.second).setRevision(paramInt3);
    if (((PublicAccount)localPair.second).getIconObjectId() != null)
      ((PublicAccount)localPair.second).setIcon(at.a(((PublicAccount)localPair.second).getIcon(), ((PublicAccount)localPair.second).getIconObjectId(), this.j, true));
    h.a(localh, ((PublicAccount)localPair.second).getIcon(), ((PublicAccount)localPair.second).getName(), i1);
    r.a(localr, (PublicAccount)localPair.second, i1);
    this.d.b(localr);
    this.d.b(localh);
    this.b.a(Collections.singleton(Long.valueOf(localh.getId())), localh.j(), false, false);
    this.b.a(paramInt1, paramLong1, paramInt4, i1);
    this.e.h(paramInt1);
    MessageEntity localMessageEntity = c.a(this.j, i1, localh, this.o.l(), 16, System.currentTimeMillis(), paramLong2, localh.o(), str, paramInt2);
    if (localMessageEntity != null)
    {
      if ((!localMessageEntity.isEmpty()) || (!localh.g()))
        break label438;
      ((bs)this.c.get()).a(localMessageEntity, "", true);
    }
    while (true)
    {
      com.viber.voip.publicaccount.d.e.a(localr.b(), localh.q(), localh.o(), i1);
      com.viber.voip.publicaccount.d.e.a(localh, localr.f(), i1);
      return;
      label438: ((bs)this.c.get()).a(localMessageEntity);
    }
    com.viber.voip.model.e.a(String.valueOf(paramLong1), "key_not_changed_public_group_info", paramInt1);
    this.e.a(paramInt1, paramLong1, null, 0, localh.j(), localh.p());
  }

  public void onCreatePublicAccountReply(int paramInt1, int paramInt2, long paramLong, String paramString1, Map<String, Integer> paramMap, String paramString2)
  {
    if (paramInt1 == 0)
    {
      PublicAccount localPublicAccount = this.e.i(paramInt2);
      if (localPublicAccount != null)
      {
        localPublicAccount.setPublicAccountId(paramString1);
        localPublicAccount.setGroupID(paramLong);
        localPublicAccount.setAuthToken(paramString2);
        localPublicAccount.setGroupRole(2);
        bs.e locale = bs.e.a().a(true).a(Boolean.FALSE).a();
        bs.f localf = ((bs)this.c.get()).a(paramInt2, paramLong, 2, localPublicAccount, locale);
        this.e.j(paramInt2);
        this.b.a(paramInt2, localf.f.getId(), paramLong, paramString1, paramMap, paramString2, "");
        this.b.a(Collections.singleton(Long.valueOf(localf.f.getId())), localf.f.j(), false, false);
        return;
      }
      this.e.j(paramInt2);
      this.b.b(paramInt2, 1);
      return;
    }
    this.e.j(paramInt2);
    this.b.b(paramInt2, paramInt1);
  }

  public void onJoinPublicGroup(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.e.k(paramInt1))
      return;
    if ((paramInt2 == 2) || (paramInt2 == 0))
    {
      h localh1 = this.d.b(paramLong);
      if (localh1 != null)
      {
        localh1.a(2);
        localh1.h(6);
        this.d.b(localh1);
        this.d.e(localh1.getId(), 2);
        com.viber.voip.messages.k localk = ViberApplication.getInstance().getMessagesManager();
        localk.a().a(localh1.getId());
        r localr = this.d.d(paramLong);
        if ((da.a(localr.b())) || (!localr.c()))
          break label197;
        localk.h().a(localr.b(), true);
      }
    }
    while (true)
    {
      h localh2 = this.d.c(paramLong);
      if (localh2 != null)
        this.b.a(Collections.singleton(Long.valueOf(localh2.getId())), localh2.j(), false, false);
      this.b.b(paramInt1, paramLong, 2, paramInt2);
      return;
      label197: this.g.add(Long.valueOf(paramLong));
    }
  }

  public void onPublicAccountInfo(int paramInt1, int paramInt2, PublicAccountInfo paramPublicAccountInfo)
  {
    long l1 = paramPublicAccountInfo.getPublicChatId();
    r localr = a(paramPublicAccountInfo);
    h localh1 = this.d.b(l1);
    if (localr == null)
      com.viber.voip.model.e.a(String.valueOf(l1), new String[] { "key_not_synced_public_group" });
    while (true)
    {
      return;
      b localb;
      int i1;
      switch (paramInt1)
      {
      default:
        localb = ab.f();
        if (!localb.d())
        {
          i1 = 1;
          if (i1 != 0)
            localb.a();
        }
        break;
      case 4:
      case 3:
      case 1:
      case 2:
      }
      try
      {
        h localh2 = this.d.a(paramPublicAccountInfo.getPublicAccountID(), false);
        int i2;
        if (av.d(paramPublicAccountInfo.getGroupFlags(), 134217728) != av.d(localr.x(), 134217728))
        {
          i2 = 1;
          label151: if (da.a(paramPublicAccountInfo.getChatBackground(), localr.U()))
            break label394;
        }
        label394: for (int i3 = 1; ; i3 = 0)
        {
          a(paramPublicAccountInfo, localr);
          a(localh1, paramPublicAccountInfo);
          a(localh2, paramPublicAccountInfo);
          if (localh2 != null)
          {
            this.a.a(paramPublicAccountInfo);
            if (i3 != 0)
              this.b.b(localh2.getId());
          }
          if (localh1 == null)
            break label481;
          if (!av.d(paramPublicAccountInfo.getGroupFlags(), 8))
            break label400;
          ((bs)this.c.get()).a(Collections.singleton(Long.valueOf(localh1.getId())), localh1.j());
          return;
          a(paramInt2, l1, localr, localh1, 1, 1);
          return;
          a(paramInt2, l1, localr, localh1, 1, 3);
          return;
          if (com.viber.voip.model.e.a(String.valueOf(paramPublicAccountInfo.getPublicChatId()), "key_not_changed_public_group_info") != null)
          {
            com.viber.voip.model.e.a(String.valueOf(paramPublicAccountInfo.getPublicChatId()), new String[] { "key_not_changed_public_group_info" });
            this.b.a(paramInt2, l1, 7, 0);
            this.e.h(paramInt2);
          }
          this.b.a(paramInt2, paramInt1);
          return;
          i1 = 0;
          break;
          i2 = 0;
          break label151;
        }
        label400: if (i2 != 0)
          this.b.a(Collections.singleton(Long.valueOf(localh1.getId())), localh1.j(), true, false);
        try
        {
          this.a.a(localh1.getId(), localh1.j(), localh1.p(), paramPublicAccountInfo.getMembers());
          a(paramPublicAccountInfo.getPinInfos(), localh1, localr.K());
          a(paramPublicAccountInfo, localh1.getId());
          label481: if (i1 != 0)
          {
            localb.c();
            localb.b();
          }
          a(l1, paramPublicAccountInfo.getRevision());
          com.viber.voip.model.e.a(String.valueOf(l1), new String[] { "key_not_synced_public_group" });
          if ((!this.g.remove(Long.valueOf(l1))) || (!paramPublicAccountInfo.isWebhookExists()))
            continue;
          ViberApplication.getInstance().getMessagesManager().h().a(paramPublicAccountInfo.getPublicAccountID(), true);
          return;
        }
        catch (com.viber.voip.publicaccount.c.a locala)
        {
          a(this.m.generateSequence(), l1, localr, localh1, paramPublicAccountInfo.getRevision(), paramPublicAccountInfo.getUserRole());
        }
        return;
      }
      finally
      {
        if (i1 != 0)
        {
          localb.c();
          localb.b();
        }
      }
    }
  }

  public void onPublicAccountRefreshToken(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (paramInt1 == 0)
    {
      r localr = this.d.a(paramString1);
      if (localr != null)
      {
        localr.f(paramString2);
        localr.a(false);
        this.d.b(localr);
      }
    }
    o.a().g();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.b.p
 * JD-Core Version:    0.6.2
 */