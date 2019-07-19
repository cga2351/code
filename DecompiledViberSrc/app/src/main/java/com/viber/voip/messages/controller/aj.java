package com.viber.voip.messages.controller;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.LongSparseArray;
import com.viber.voip.apps.b;
import com.viber.voip.av.e;
import com.viber.voip.flatbuffers.model.msginfo.Pin;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.manager.af;
import com.viber.voip.messages.controller.manager.az.a;
import com.viber.voip.messages.controller.manager.y;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.model.entity.CallEntity;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.util.dx;
import com.viber.voip.util.upload.s;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class aj
  implements ai
{
  private final ai a;
  private final Handler b;

  public aj(Handler paramHandler, ai paramai)
  {
    this.a = paramai;
    this.b = paramHandler;
  }

  private void a(final a parama)
  {
    this.b.postAtFrontOfQueue(new Runnable()
    {
      public void run()
      {
        parama.a(aj.a(aj.this));
      }
    });
  }

  public void a()
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.a();
      }
    });
  }

  public void a(final int paramInt, final long paramLong, PublicAccount paramPublicAccount, final ai.e parame)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.a(paramInt, paramLong, parame, this.d);
      }
    });
  }

  public void a(final int paramInt, final Member paramMember, final long paramLong, boolean paramBoolean1, final boolean paramBoolean2, final ai.e parame)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.a(paramInt, paramMember, paramLong, paramBoolean2, parame, this.f);
      }
    });
  }

  public void a(long paramLong)
  {
    a(new ak(paramLong));
  }

  public void a(long paramLong, int paramInt)
  {
    a(new au(paramLong, paramInt));
  }

  public void a(long paramLong, int paramInt, ai.m paramm)
  {
    a(new ax(paramLong, paramInt, paramm));
  }

  public void a(final long paramLong, int paramInt, final CharSequence paramCharSequence, final String paramString, final LongSparseArray<Integer> paramLongSparseArray)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.a(paramLong, paramCharSequence, paramString, paramLongSparseArray, this.e);
      }
    });
  }

  public void a(long paramLong, int paramInt, String paramString)
  {
    a(paramLong, paramInt, paramString, null, null);
  }

  public void a(long paramLong, int paramInt, String paramString, ai.j paramj)
  {
    a(new ar(paramLong, paramInt, paramString, paramj));
  }

  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    a(new az(paramLong, paramInt, paramBoolean));
  }

  public void a(long paramLong1, long paramLong2)
  {
    a(new at(paramLong1, paramLong2));
  }

  public void a(long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2, String[] paramArrayOfString, boolean paramBoolean, Bundle paramBundle)
  {
    a(new bb(paramLong1, paramLong2, paramString1, paramInt1, paramInt2, paramString2, paramArrayOfString, paramBoolean, paramBundle));
  }

  public void a(final long paramLong, Uri paramUri)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.a(paramLong, this.b);
      }
    });
  }

  public void a(final long paramLong, ai.b paramb)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.a(paramLong, this.b);
      }
    });
  }

  public void a(final long paramLong, ai.d paramd)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.a(paramLong, this.b);
      }
    });
  }

  public void a(final long paramLong, ai.e parame)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.a(paramLong, this.b);
      }
    });
  }

  public void a(final long paramLong, ai.f paramf)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.a(paramLong, this.b);
      }
    });
  }

  public void a(final long paramLong, ai.h paramh)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.a(paramLong, this.b);
      }
    });
  }

  public void a(final long paramLong, String paramString)
  {
    if (paramLong > -1L)
      s.b(dx.a(paramLong));
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.a(paramLong, this.b);
      }
    });
  }

  public void a(long paramLong, boolean paramBoolean)
  {
    a(new aw(paramLong, paramBoolean));
  }

  public void a(final long paramLong, boolean paramBoolean, final int paramInt)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.a(paramLong, paramInt, this.c);
      }
    });
  }

  public void a(long paramLong1, boolean paramBoolean, int paramInt, long paramLong2)
  {
    a(new ap(paramLong1, paramBoolean, paramInt, paramLong2));
  }

  public void a(final long paramLong, boolean paramBoolean, final ai.m paramm)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.a(paramLong, paramm, this.c);
      }
    });
  }

  public void a(final long paramLong, boolean paramBoolean1, final boolean paramBoolean2)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.a(paramLong, paramBoolean2, this.c);
      }
    });
  }

  public void a(final Pin paramPin, final long paramLong1, long paramLong2, final String paramString, int paramInt1, final int paramInt2)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.a(paramPin, paramLong1, paramString, paramInt2, this.e, this.f);
      }
    });
  }

  public void a(final ai.a parama)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.a(parama);
      }
    });
  }

  public void a(ai.k paramk)
  {
    a(new al(paramk));
  }

  public void a(final y paramy, final af paramaf, final ai.l paraml)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.a(paramy, paramaf, paraml);
      }
    });
  }

  public void a(final ConversationLoaderEntity paramConversationLoaderEntity)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.a(paramConversationLoaderEntity);
      }
    });
  }

  public void a(final aa paramaa)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.a(paramaa);
      }
    });
  }

  public void a(aa paramaa, int paramInt1, int paramInt2)
  {
    a(new an(paramaa, paramInt1, paramInt2));
  }

  public void a(final CallEntity paramCallEntity, final int paramInt, final long paramLong, String paramString)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.a(paramCallEntity, paramInt, paramLong, this.d);
      }
    });
  }

  public void a(final MessageEntity paramMessageEntity, final Bundle paramBundle)
  {
    this.b.post(new Runnable()
    {
      public void run()
      {
        aj.a(aj.this).a(paramMessageEntity, paramBundle);
      }
    });
  }

  public void a(h paramh, ai.i parami)
  {
    a(new ay(paramh, parami));
  }

  public void a(Runnable paramRunnable)
  {
    a(new ba(paramRunnable));
  }

  public void a(String paramString)
  {
    a(new ao(paramString));
  }

  public void a(final String paramString, final ai.e parame)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.a(paramString, parame);
      }
    });
  }

  public void a(final String paramString, final ai.i parami)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.a(paramString, parami);
      }
    });
  }

  public void a(final List<b> paramList)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.a(paramList);
      }
    });
  }

  public void a(Map<String, az.a> paramMap, long paramLong)
  {
    a(new aq(paramMap, paramLong));
  }

  public void a(final Set<Long> paramSet)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.a(paramSet);
      }
    });
  }

  public void a(final Set<Long> paramSet, final int paramInt)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.a(paramSet, paramInt);
      }
    });
  }

  public void a(final Set<Long> paramSet, final ai.c paramc)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.a(paramSet, paramc);
      }
    });
  }

  public void a(final Set<Long> paramSet, final boolean paramBoolean, final int paramInt)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.a(paramSet, paramBoolean, paramInt);
      }
    });
  }

  public void a(final Set<Long> paramSet, final boolean paramBoolean, final ai.b paramb)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.a(paramSet, paramBoolean, paramb);
      }
    });
  }

  public void a(final long[] paramArrayOfLong, final Bundle paramBundle, final ConversationItemLoaderEntity paramConversationItemLoaderEntity, final ai.g paramg)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.a(paramArrayOfLong, paramBundle, paramConversationItemLoaderEntity, paramg);
      }
    });
  }

  public void a(final MessageEntity[] paramArrayOfMessageEntity, final Bundle paramBundle)
  {
    this.b.post(new Runnable()
    {
      public void run()
      {
        aj.a(aj.this).a(paramArrayOfMessageEntity, paramBundle);
      }
    });
  }

  public boolean a(int paramInt, boolean paramBoolean)
  {
    return this.a.a(paramInt, paramBoolean);
  }

  public void b()
  {
    com.viber.voip.av.a(av.e.g).postDelayed(new Runnable()
    {
      public void run()
      {
        aj.a(aj.this).b();
      }
    }
    , 5000L);
  }

  public void b(final long paramLong)
  {
    this.b.postAtFrontOfQueue(new Runnable()
    {
      public void run()
      {
        aj.a(aj.this).b(paramLong);
      }
    });
  }

  public void b(long paramLong, int paramInt)
  {
    a(new av(paramLong, paramInt));
  }

  public void b(final long paramLong, Uri paramUri)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.b(paramLong, this.b);
      }
    });
  }

  public void b(final long paramLong, ai.b paramb)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.b(paramLong, this.b);
      }
    });
  }

  public void b(final long paramLong, String paramString)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.b(paramLong, this.b);
      }
    });
  }

  public void b(final long paramLong, boolean paramBoolean)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.b(paramLong, this.b);
      }
    });
  }

  public void b(final long paramLong, boolean paramBoolean, final ai.m paramm)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.b(paramLong, paramm, this.c);
      }
    });
  }

  public void b(final aa paramaa)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.b(paramaa);
      }
    });
  }

  public void b(final List<MessageEntity> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
      return;
    com.viber.voip.av.a(av.e.g).post(new Runnable()
    {
      public void run()
      {
        aj.a(aj.this).b(paramList);
      }
    });
  }

  public void c()
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.c();
      }
    });
  }

  public void c(final long paramLong)
  {
    this.b.postAtFrontOfQueue(new Runnable()
    {
      public void run()
      {
        aj.a(aj.this).c(paramLong);
      }
    });
  }

  public void c(final long paramLong, int paramInt)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.c(paramLong, this.b);
      }
    });
  }

  public void c(final long paramLong, ai.b paramb)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.c(paramLong, this.b);
      }
    });
  }

  public void c(final long paramLong, boolean paramBoolean)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.c(paramLong, this.b);
      }
    });
  }

  public void c(final long paramLong, boolean paramBoolean, final ai.m paramm)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.c(paramLong, paramm, this.c);
      }
    });
  }

  public u d()
  {
    return this.a.d();
  }

  public void d(final long paramLong)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.d(paramLong);
      }
    });
  }

  public void d(final long paramLong, boolean paramBoolean)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.d(paramLong, this.b);
      }
    });
  }

  public void d(final long paramLong, boolean paramBoolean, final ai.m paramm)
  {
    a(new a()
    {
      public void a(ai paramAnonymousai)
      {
        paramAnonymousai.d(paramLong, paramm, this.c);
      }
    });
  }

  public void e()
  {
    a(as.a);
  }

  public void e(long paramLong)
  {
    a(new am(paramLong));
  }

  private static abstract interface a
  {
    public abstract void a(ai paramai);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.aj
 * JD-Core Version:    0.6.2
 */