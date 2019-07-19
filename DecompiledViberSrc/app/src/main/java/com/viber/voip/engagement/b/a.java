package com.viber.voip.engagement.b;

import android.os.Handler;
import android.support.v4.util.ArrayMap;
import com.viber.dexshared.Logger;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberEnv;
import com.viber.voip.engagement.c.a;
import com.viber.voip.messages.controller.manager.z;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.RegularConversationLoaderEntity;
import com.viber.voip.user.OnlineUserActivityHelper;
import com.viber.voip.util.cd;
import com.viber.voip.util.cl;
import com.viber.voip.util.i.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class a
  implements com.viber.voip.engagement.c
{
  private static final Logger a = ViberEnv.getLogger();
  private final Handler b;
  private final ExecutorService c;
  private final PhoneController d;
  private final OnlineUserActivityHelper e;
  private final z f;
  private final e g;
  private final int h;
  private c.a i = (c.a)cl.b(c.a.class);
  private Map<String, RegularConversationLoaderEntity> j = new HashMap();
  private final long k;
  private Future l;
  private final Runnable m = new Runnable()
  {
    public void run()
    {
      List localList = a.a(a.this);
      a.b(a.this).post(new d(this, localList));
    }
  };

  public a(Handler paramHandler, ExecutorService paramExecutorService, PhoneController paramPhoneController, OnlineUserActivityHelper paramOnlineUserActivityHelper, z paramz, e parame, int paramInt)
  {
    this.b = paramHandler;
    this.c = paramExecutorService;
    this.d = paramPhoneController;
    this.e = paramOnlineUserActivityHelper;
    this.f = paramz;
    this.g = parame;
    this.h = paramInt;
    this.k = TimeUnit.SECONDS.toMillis(10L);
  }

  private List<RegularConversationLoaderEntity> a(List<RegularConversationLoaderEntity> paramList)
  {
    Collections.sort(paramList, d());
    return paramList.subList(0, Math.min(paramList.size(), 30));
  }

  // ERROR //
  private List<String> a(String[] paramArrayOfString, com.viber.voip.engagement.d.a parama)
  {
    // Byte code:
    //   0: new 144	java/util/ArrayList
    //   3: dup
    //   4: bipush 50
    //   6: invokespecial 147	java/util/ArrayList:<init>	(I)V
    //   9: astore_3
    //   10: aload_0
    //   11: getfield 74	com/viber/voip/engagement/b/a:d	Lcom/viber/jni/controller/PhoneController;
    //   14: invokeinterface 152 1 0
    //   19: istore 4
    //   21: new 154	java/util/concurrent/CountDownLatch
    //   24: dup
    //   25: iconst_1
    //   26: invokespecial 155	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   29: astore 5
    //   31: new 157	com/viber/voip/engagement/d
    //   34: dup
    //   35: iload 4
    //   37: aload_3
    //   38: aload 5
    //   40: aload_2
    //   41: invokespecial 160	com/viber/voip/engagement/d:<init>	(ILjava/util/List;Ljava/util/concurrent/CountDownLatch;Lcom/viber/voip/engagement/d$a;)V
    //   44: astore 6
    //   46: aload_0
    //   47: getfield 76	com/viber/voip/engagement/b/a:e	Lcom/viber/voip/user/OnlineUserActivityHelper;
    //   50: aload_1
    //   51: iload 4
    //   53: aload 6
    //   55: invokevirtual 166	com/viber/voip/user/OnlineUserActivityHelper:obtainInfoSync	([Ljava/lang/String;ILcom/viber/voip/user/OnlineUserActivityHelper$UiOnlineUserInfoDelegate;)V
    //   58: aload 5
    //   60: aload_0
    //   61: getfield 96	com/viber/voip/engagement/b/a:k	J
    //   64: getstatic 169	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   67: invokevirtual 173	java/util/concurrent/CountDownLatch:await	(JLjava/util/concurrent/TimeUnit;)Z
    //   70: istore 9
    //   72: aconst_null
    //   73: astore 10
    //   75: iload 9
    //   77: ifne +42 -> 119
    //   80: aload_0
    //   81: getfield 76	com/viber/voip/engagement/b/a:e	Lcom/viber/voip/user/OnlineUserActivityHelper;
    //   84: aload 6
    //   86: invokevirtual 177	com/viber/voip/user/OnlineUserActivityHelper:removeListener	(Lcom/viber/voip/user/OnlineUserActivityHelper$UiOnlineUserInfoDelegate;)V
    //   89: aload 10
    //   91: areturn
    //   92: astore 8
    //   94: aload_0
    //   95: getfield 76	com/viber/voip/engagement/b/a:e	Lcom/viber/voip/user/OnlineUserActivityHelper;
    //   98: aload 6
    //   100: invokevirtual 177	com/viber/voip/user/OnlineUserActivityHelper:removeListener	(Lcom/viber/voip/user/OnlineUserActivityHelper$UiOnlineUserInfoDelegate;)V
    //   103: aconst_null
    //   104: areturn
    //   105: astore 7
    //   107: aload_0
    //   108: getfield 76	com/viber/voip/engagement/b/a:e	Lcom/viber/voip/user/OnlineUserActivityHelper;
    //   111: aload 6
    //   113: invokevirtual 177	com/viber/voip/user/OnlineUserActivityHelper:removeListener	(Lcom/viber/voip/user/OnlineUserActivityHelper$UiOnlineUserInfoDelegate;)V
    //   116: aload 7
    //   118: athrow
    //   119: aload_3
    //   120: astore 10
    //   122: goto -42 -> 80
    //
    // Exception table:
    //   from	to	target	type
    //   58	72	92	java/lang/InterruptedException
    //   58	72	105	finally
  }

  private boolean a(long paramLong1, long paramLong2)
  {
    return paramLong2 <= paramLong1 - TimeUnit.DAYS.toMillis(this.h);
  }

  private List<RegularConversationLoaderEntity> c()
  {
    List localList1 = this.f.e();
    long l1 = this.g.a();
    b localb = new b(this, l1);
    ArrayList localArrayList = new ArrayList();
    ArrayMap localArrayMap = new ArrayMap(50);
    Iterator localIterator1 = localList1.iterator();
    while (localIterator1.hasNext())
    {
      while ((localIterator1.hasNext()) && (localArrayMap.size() < 50))
      {
        RegularConversationLoaderEntity localRegularConversationLoaderEntity2 = (RegularConversationLoaderEntity)localIterator1.next();
        if (localRegularConversationLoaderEntity2.isConversation1on1())
        {
          String str = localRegularConversationLoaderEntity2.getParticipantMemberId();
          if ((cd.a(str)) && ((!localRegularConversationLoaderEntity2.isIncoming()) || (a(l1, localRegularConversationLoaderEntity2.getDate()))))
            localArrayMap.put(str, localRegularConversationLoaderEntity2);
        }
        else
        {
          localArrayList.add(localRegularConversationLoaderEntity2);
        }
      }
      if (!localArrayMap.isEmpty())
        break;
    }
    label175: for (List localList3 = null; ; localList3 = a(localArrayList))
    {
      if (localList3 == null)
        localList3 = a(localArrayList);
      return localList3;
      List localList2 = a((String[])localArrayMap.keySet().toArray(new String[0]), localb);
      if (localList2 == null)
        break label175;
      Iterator localIterator2 = localList2.iterator();
      while (localIterator2.hasNext())
      {
        RegularConversationLoaderEntity localRegularConversationLoaderEntity1 = (RegularConversationLoaderEntity)localArrayMap.get((String)localIterator2.next());
        localArrayList.add(localRegularConversationLoaderEntity1);
        if (localRegularConversationLoaderEntity1.isConversation1on1())
          this.j.put(localRegularConversationLoaderEntity1.getParticipantMemberId(), localRegularConversationLoaderEntity1);
      }
      localArrayMap.clear();
      if (localArrayList.size() < 30)
        break;
    }
  }

  private Comparator<RegularConversationLoaderEntity> d()
  {
    return c.a;
  }

  public ConversationLoaderEntity a(String paramString)
  {
    return (ConversationLoaderEntity)this.j.get(paramString);
  }

  public void a()
  {
    b();
    this.l = this.c.submit(this.m);
  }

  public void a(c.a parama)
  {
    this.i = parama;
  }

  public void b()
  {
    if (this.l != null)
      this.l.cancel(false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.b.a
 * JD-Core Version:    0.6.2
 */