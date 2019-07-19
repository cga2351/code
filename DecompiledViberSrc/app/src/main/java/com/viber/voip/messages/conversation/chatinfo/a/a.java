package com.viber.voip.messages.conversation.chatinfo.a;

import android.content.res.Resources;
import android.support.v4.util.Pair;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ac;
import com.viber.voip.messages.conversation.ae;
import com.viber.voip.messages.conversation.chatinfo.d.g;
import com.viber.voip.messages.conversation.chatinfo.d.k;
import com.viber.voip.messages.conversation.chatinfo.presentation.n;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.publicaccount.ui.holders.recentmedia.b;
import java.util.ArrayList;
import java.util.List;

public abstract class a
  implements com.viber.voip.messages.conversation.chatinfo.c.a<com.viber.voip.messages.conversation.chatinfo.d.d>
{
  final Resources a;
  final b b;
  private final ac c;
  private final ConferenceCallsRepository d;
  private List<com.viber.voip.messages.conversation.chatinfo.d.d> e = new ArrayList();
  private int f;
  private int g;
  private int h;
  private int i;

  a(Resources paramResources, b paramb, ac paramac, ConferenceCallsRepository paramConferenceCallsRepository)
  {
    this.a = paramResources;
    this.b = paramb;
    this.c = paramac;
    this.d = paramConferenceCallsRepository;
  }

  private void d()
  {
    this.e = new ArrayList();
  }

  private com.viber.voip.messages.conversation.chatinfo.d.d e(int paramInt)
  {
    ae localae = this.c.e(paramInt);
    if (localae != null)
      return new k(localae);
    return new g();
  }

  public int a()
  {
    return this.e.size() + this.g + this.i;
  }

  public Pair<Integer, com.viber.voip.messages.conversation.chatinfo.d.d> a(com.viber.voip.messages.conversation.chatinfo.presentation.a.d paramd, int paramInt)
  {
    for (int j = 0; j < a(); j++)
    {
      com.viber.voip.messages.conversation.chatinfo.d.d locald = a(j);
      if ((locald.d() == paramd) && (locald.e() == paramInt))
        return Pair.create(Integer.valueOf(j), locald);
    }
    return null;
  }

  a a(n paramn, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (paramBoolean5);
    int k;
    int n;
    int i1;
    for (int j = paramn.c(); ; j = 2147483647)
    {
      k = this.c.getCount();
      int m = 0;
      n = 0;
      i1 = 0;
      while (true)
      {
        if (m >= k)
          break label234;
        if (!this.c.g(m))
          break;
        i1++;
        m++;
      }
    }
    if ((!paramBoolean3) && (n >= j));
    label94: label234: for (int i2 = k - i1; ; i2 = n)
    {
      int i8;
      if (paramBoolean2)
        if (paramBoolean1)
          i8 = 0;
      for (int i3 = i1 + i8; ; i3 = 0)
      {
        int i4;
        if (paramBoolean1)
        {
          i4 = 0;
          if (!paramBoolean2);
        }
        label112: for (int i5 = i2 + i4; ; i5 = 0)
        {
          int i6;
          if (!paramBoolean4)
          {
            i6 = Math.min(i3, j);
            if (paramBoolean3)
              break label215;
          }
          for (int i7 = Math.min(i5, j); ; i7 = i5)
          {
            return new a.a.a().a(i5).b(i7).c(i2).d(i3).e(i6).f(i1).a();
            n++;
            break;
            i8 = i2;
            break label94;
            i4 = i1;
            break label112;
            i6 = i3;
            break label133;
          }
        }
      }
    }
  }

  public com.viber.voip.messages.conversation.chatinfo.d.d a(int paramInt)
  {
    int j = this.g;
    int k = 0;
    if (j > 0)
    {
      if ((paramInt >= this.f) && (paramInt < this.f + this.g))
        return e(paramInt - this.f);
      int m = this.f + this.g;
      k = 0;
      if (paramInt >= m)
        k = 0 + this.g;
    }
    if (this.i > 0)
    {
      if ((paramInt >= this.h) && (paramInt < this.h + this.i))
        return e(paramInt - this.h + this.g);
      if (paramInt >= this.h + this.i)
        k += this.i;
    }
    return (com.viber.voip.messages.conversation.chatinfo.d.d)this.e.get(paramInt - k);
  }

  void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if ((!paramConversationItemLoaderEntity.isMuteConversation()) && (!paramConversationItemLoaderEntity.isSnoozedConversation()))
      a(c.c(this.a, paramConversationItemLoaderEntity));
  }

  public final void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, n paramn)
  {
    d();
    b(paramConversationItemLoaderEntity, paramn);
  }

  void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    if (!this.d.isConversationConferenceTalkingTo(paramConversationItemLoaderEntity.getId()))
    {
      if (paramBoolean)
        a(c.a());
      a(c.j(this.a, paramConversationItemLoaderEntity));
    }
  }

  void a(com.viber.voip.messages.conversation.chatinfo.d.d paramd)
  {
    this.e.add(paramd);
  }

  void b()
  {
    this.f = 0;
    this.g = 0;
    this.h = 0;
    this.i = 0;
  }

  void b(int paramInt)
  {
    if (paramInt > 0)
    {
      this.f = this.e.size();
      this.g = paramInt;
    }
  }

  void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    a(paramConversationItemLoaderEntity, true);
  }

  abstract void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity, n paramn);

  void c()
  {
  }

  void c(int paramInt)
  {
    if (paramInt > 0)
    {
      this.h = (this.e.size() + this.g);
      this.i = paramInt;
    }
  }

  static final class a
  {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;

    private a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramInt4;
      this.e = paramInt5;
      this.f = paramInt6;
    }

    int a()
    {
      return this.a;
    }

    int b()
    {
      return this.b;
    }

    int c()
    {
      return this.c;
    }

    int d()
    {
      return this.d;
    }

    int e()
    {
      return this.e;
    }

    int f()
    {
      return this.f;
    }

    static final class a
    {
      private int a;
      private int b;
      private int c;
      private int d;
      private int e;
      private int f;

      a a(int paramInt)
      {
        this.a = paramInt;
        return this;
      }

      public a.a a()
      {
        return new a.a(this.a, this.b, this.c, this.d, this.e, this.f, null);
      }

      a b(int paramInt)
      {
        this.b = paramInt;
        return this;
      }

      a c(int paramInt)
      {
        this.c = paramInt;
        return this;
      }

      a d(int paramInt)
      {
        this.d = paramInt;
        return this;
      }

      a e(int paramInt)
      {
        this.e = paramInt;
        return this;
      }

      a f(int paramInt)
      {
        this.f = paramInt;
        return this;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.a.a
 * JD-Core Version:    0.6.2
 */