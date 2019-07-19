package com.viber.voip.messages.controller.manager;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.util.ArrayMap;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.a.d.b;
import com.viber.voip.messages.m;
import com.viber.voip.settings.d.r;
import com.viber.voip.util.af;
import com.viber.voip.util.dd;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ao
{
  private static final Logger a = ViberEnv.getLogger();
  private final o b;
  private final a c;
  private final Handler d;
  private final Object e;
  private EventBus f;
  private boolean g;

  ao(o paramo, Handler paramHandler, EventBus paramEventBus, boolean paramBoolean)
  {
    this.b = paramo;
    this.d = paramHandler;
    this.e = new Object();
    this.f = paramEventBus;
    this.c = new a(this.f, paramBoolean);
  }

  private void a(long paramLong1, long paramLong2)
  {
    if (0L == paramLong1)
      return;
    long l = paramLong1 - paramLong2;
    this.d.removeCallbacksAndMessages(this.e);
    this.d.postAtTime(new ar(this), this.e, l + SystemClock.uptimeMillis());
  }

  private void e()
  {
    dd.a(this.d, new aq(this));
  }

  public void a()
  {
    dd.a(this.d, new ap(this));
  }

  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void reschedule(d.b paramb)
  {
    this.d.removeCallbacksAndMessages(this.e);
    e();
  }

  static class a extends aa
  {
    private final EventBus g;
    private final boolean h;

    public a(EventBus paramEventBus, boolean paramBoolean)
    {
      this.g = paramEventBus;
      this.h = paramBoolean;
    }

    private long a()
    {
      if (d.r.H.d())
        return 30000L;
      return 2592000000L;
    }

    private Set<Long> a(long paramLong)
    {
      com.viber.provider.b localb = f();
      String[] arrayOfString = new String[1];
      arrayOfString[0] = Long.toString(paramLong - a());
      Cursor localCursor = localb.a(" SELECT conversations.group_id, conversations.conversation_type FROM conversations WHERE conversations.favourite_conversation == -1 AND conversations.snoozed_conversation_time<=?", arrayOfString);
      Object localObject2;
      HashSet localHashSet;
      ContentValues localContentValues;
      StringBuilder localStringBuilder;
      try
      {
        ArrayMap localArrayMap;
        if (af.c(localCursor))
        {
          localArrayMap = new ArrayMap(localCursor.getCount());
          boolean bool;
          do
          {
            localArrayMap.put(Long.valueOf(localCursor.getLong(0)), Integer.valueOf(localCursor.getInt(1)));
            bool = localCursor.moveToNext();
          }
          while (bool);
        }
        Map localMap;
        for (localObject2 = localArrayMap; ; localObject2 = localMap)
        {
          af.a(localCursor);
          if (((Map)localObject2).isEmpty())
            break label429;
          localHashSet = new HashSet(((Map)localObject2).size());
          localContentValues = new ContentValues(2);
          localContentValues.put("favourite_conversation", Integer.valueOf(0));
          localContentValues.put("snoozed_conversation_time", Integer.valueOf(0));
          Iterator localIterator = ((Map)localObject2).keySet().iterator();
          Long localLong1 = (Long)localIterator.next();
          localStringBuilder = new StringBuilder("( " + localLong1);
          if (m.b(((Integer)((Map)localObject2).get(localLong1)).intValue()))
            localHashSet.add(new d.b(localLong1.longValue(), true, false));
          while (localIterator.hasNext())
          {
            Long localLong2 = (Long)localIterator.next();
            localStringBuilder.append(',').append(localLong2);
            if (m.b(((Integer)((Map)localObject2).get(localLong2)).intValue()))
              localHashSet.add(new d.b(localLong2.longValue(), true, false));
          }
          localMap = Collections.emptyMap();
        }
      }
      finally
      {
        af.a(localCursor);
      }
      localStringBuilder.append(')');
      f().a("conversations", localContentValues, "group_id IN " + localStringBuilder, null);
      if (this.h)
        this.g.post(localHashSet);
      label429: return ((Map)localObject2).keySet();
    }

    private long b(long paramLong)
    {
      Cursor localCursor = f().a(" SELECT snoozed_conversation_time FROM conversations WHERE conversations.favourite_conversation == -1 ORDER BY snoozed_conversation_time LIMIT 1", null);
      try
      {
        if (af.c(localCursor))
        {
          long l2 = localCursor.getLong(0);
          long l3 = a();
          l1 = l2 + l3;
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
 * Qualified Name:     com.viber.voip.messages.controller.manager.ao
 * JD-Core Version:    0.6.2
 */