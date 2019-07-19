package com.viber.voip.messages.controller.manager;

import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.viber.dexshared.Logger;
import com.viber.provider.b;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.bv.d;
import com.viber.voip.messages.controller.bv.l;
import com.viber.voip.messages.controller.by;
import com.viber.voip.messages.m;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.s.a;
import com.viber.voip.util.af;
import com.viber.voip.util.av;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class ai
  implements ah
{
  private static final Logger a = ViberEnv.getLogger();
  private final o b;
  private final b c;
  private final Handler d;
  private final Object e;
  private final HashSet<Long> f;
  private boolean g;

  ai(o paramo, Handler paramHandler)
  {
    this.b = paramo;
    this.d = paramHandler;
    a locala = new a();
    this.b.a(locala);
    this.b.a(locala);
    this.e = new Object();
    this.c = new b();
    this.f = new HashSet();
  }

  private void a(long paramLong1, long paramLong2)
  {
    if (0L == paramLong1)
      return;
    long l = paramLong1 - paramLong2;
    this.d.removeCallbacksAndMessages(this.e);
    this.d.postAtTime(new Runnable()
    {
      public void run()
      {
        ai.b(ai.this);
      }
    }
    , this.e, l + SystemClock.uptimeMillis());
  }

  private void a(Runnable paramRunnable)
  {
    if (Thread.currentThread() == this.d.getLooper().getThread())
    {
      paramRunnable.run();
      return;
    }
    this.d.post(paramRunnable);
  }

  private void b()
  {
    this.d.removeCallbacksAndMessages(this.e);
    c();
  }

  private void c()
  {
    a(new Runnable()
    {
      public void run()
      {
        long l1 = SystemClock.elapsedRealtime();
        long l2 = ai.b.a(ai.e(ai.this), l1, ai.c(ai.this));
        Set localSet1 = ai.b.b(ai.e(ai.this), l1, ai.c(ai.this));
        Set localSet2 = ai.b.c(ai.e(ai.this), l1, ai.c(ai.this));
        if (localSet2.size() > 0)
          ai.f(ai.this).a(localSet2, false);
        if (localSet1.size() > 0)
          ai.f(ai.this).a(localSet1);
        ai.a(ai.this, l2, l1);
      }
    });
  }

  public void a()
  {
    a(new Runnable()
    {
      public void run()
      {
        if (ai.a(ai.this))
          return;
        ai.a(ai.this, true);
        ai.b(ai.this);
      }
    });
  }

  public void a(final long paramLong)
  {
    a(new Runnable()
    {
      public void run()
      {
        ai.c(ai.this).add(Long.valueOf(paramLong));
        ai.d(ai.this);
      }
    });
  }

  public void b(final long paramLong)
  {
    a(new Runnable()
    {
      public void run()
      {
        ai.c(ai.this).remove(Long.valueOf(paramLong));
        ai.d(ai.this);
      }
    });
  }

  class a extends bv.d
    implements bv.l
  {
    a()
    {
    }

    public void a(long paramLong1, long paramLong2, boolean paramBoolean)
    {
    }

    public void a(long paramLong, Set<Long> paramSet)
    {
    }

    public void a(MessageEntity paramMessageEntity, boolean paramBoolean)
    {
    }

    public void a(Set<Long> paramSet, boolean paramBoolean)
    {
    }

    public void a(Set<Long> paramSet, boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((!paramBoolean1) && (paramBoolean2))
        ai.b(ai.this);
    }

    public void b(long paramLong1, long paramLong2, boolean paramBoolean)
    {
      by.b(this, paramLong1, paramLong2, paramBoolean);
    }

    public void onRead(Set<Long> paramSet, int paramInt, boolean paramBoolean)
    {
      if ((!m.a(paramInt)) && (paramBoolean))
        ai.b(ai.this);
    }

    public void onReadOutgoing(long paramLong, int paramInt, boolean paramBoolean)
    {
      if (!m.a(paramInt))
        ai.b(ai.this);
    }
  }

  static class b extends aa
  {
    private static final String g = "messages.extra_flags & " + av.a(0, 27) + ">0";
    private static final String h = "messages.timebomb>0 AND messages.read_message_time>0 AND messages.read_message_time+(messages.timebomb * 1000)<=CAST(IFNULL(?, 0) as LONG) AND messages.conversation_id NOT IN(%s) AND " + g;
    private static final String i = "SELECT messages.extra_uri FROM messages WHERE " + h + " AND " + "messages.extra_mime = 2";
    private static final String j = " SELECT messages._id, messages.conversation_id FROM messages WHERE " + h;
    private static final String k = " SELECT messages.read_message_time+(messages.timebomb * 1000) as expiration_time FROM messages WHERE messages.timebomb>0 AND messages.read_message_time>0 AND expiration_time>CAST(IFNULL(?, 0) as LONG) AND messages.conversation_id NOT IN(%s) AND " + g + " ORDER BY " + "expiration_time" + " LIMIT 1";

    private Set<String> a(long paramLong, HashSet<Long> paramHashSet)
    {
      b localb = f();
      String str1 = i;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = a.e(paramHashSet);
      String str2 = String.format(str1, arrayOfObject);
      String[] arrayOfString = new String[1];
      arrayOfString[0] = Long.toString(paramLong);
      Cursor localCursor = localb.a(str2, arrayOfString);
      try
      {
        Object localObject2;
        if (af.c(localCursor))
        {
          localObject2 = new HashSet(localCursor.getCount());
          boolean bool;
          do
          {
            ((Set)localObject2).add(localCursor.getString(0));
            bool = localCursor.moveToNext();
          }
          while (bool);
        }
        while (true)
        {
          return localObject2;
          Set localSet = Collections.emptySet();
          localObject2 = localSet;
        }
      }
      finally
      {
        af.a(localCursor);
      }
    }

    private Set<Long> b(long paramLong, HashSet<Long> paramHashSet)
    {
      b localb1 = f();
      String str1 = j;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = a.e(paramHashSet);
      String str2 = String.format(str1, arrayOfObject1);
      String[] arrayOfString = new String[1];
      arrayOfString[0] = Long.toString(paramLong);
      Cursor localCursor = localb1.a(str2, arrayOfString);
      try
      {
        Object localObject2;
        Object localObject3;
        if (af.c(localCursor))
        {
          localObject2 = new HashSet(localCursor.getCount());
          localObject3 = new HashSet(localCursor.getCount());
          boolean bool;
          do
          {
            ((Set)localObject2).add(Long.valueOf(localCursor.getLong(0)));
            ((Set)localObject3).add(Long.valueOf(localCursor.getLong(1)));
            bool = localCursor.moveToNext();
          }
          while (bool);
        }
        while (true)
        {
          af.a(localCursor);
          b localb2 = f();
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = a.e((Collection)localObject2);
          localb2.a("messages", String.format("messages._id IN(%s)", arrayOfObject2), null);
          return localObject3;
          Set localSet = Collections.emptySet();
          localObject3 = localSet;
          localObject2 = localObject3;
        }
      }
      finally
      {
        af.a(localCursor);
      }
    }

    private long c(long paramLong, HashSet<Long> paramHashSet)
    {
      b localb = f();
      String str1 = k;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = a.e(paramHashSet);
      String str2 = String.format(str1, arrayOfObject);
      String[] arrayOfString = new String[1];
      arrayOfString[0] = Long.toString(paramLong);
      Cursor localCursor = localb.a(str2, arrayOfString);
      try
      {
        if (af.c(localCursor))
        {
          long l2 = localCursor.getLong(0);
          l1 = l2;
          return l1;
        }
        long l1 = 0L;
      }
      finally
      {
        af.a(localCursor);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.manager.ai
 * JD-Core Version:    0.6.2
 */