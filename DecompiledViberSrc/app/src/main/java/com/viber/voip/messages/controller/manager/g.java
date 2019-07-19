package com.viber.voip.messages.controller.manager;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.viber.dexshared.Logger;
import com.viber.provider.b;
import com.viber.voip.ViberEnv;
import com.viber.voip.memberid.Member;
import com.viber.voip.model.entity.l;
import com.viber.voip.model.entity.m;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.util.LongSparseSet;
import com.viber.voip.util.af;
import com.viber.voip.util.av;
import com.viber.voip.util.u;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class g
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final ak c;
  private final al d;
  private final ab e;
  private final k f;
  private final dagger.a<ConferenceCallsRepository> g;
  private final o h;

  public g(Context paramContext, ak paramak, al paramal, ab paramab, k paramk, dagger.a<ConferenceCallsRepository> parama, o paramo)
  {
    this.b = paramContext;
    this.c = paramak;
    this.d = paramal;
    this.e = paramab;
    this.f = paramk;
    this.g = parama;
    this.h = paramo;
  }

  private int a(b paramb, ContentValues paramContentValues, long paramLong1, long paramLong2, boolean paramBoolean, String paramString)
  {
    paramContentValues.put("conversation_id", Long.valueOf(paramLong1));
    paramContentValues.put("participant_id", Long.valueOf(paramLong2));
    if (paramBoolean);
    for (int i = 0; ; i = 1)
      return paramb.a("messages", paramContentValues, "conversation_id=? AND send_type=" + i, new String[] { paramString });
  }

  private long a(long paramLong1, long paramLong2, int paramInt)
  {
    if (!av.c(paramLong2, paramInt))
      paramLong1 = av.b(paramLong1, paramInt);
    return paramLong1;
  }

  private b a(long paramLong1, m paramm, com.viber.voip.model.entity.h paramh1, long paramLong2, long paramLong3, com.viber.voip.model.entity.h paramh2, long paramLong4, long paramLong5)
  {
    b localb = new b();
    long l1 = paramm.getId();
    localb.b.add(l1);
    String str1 = String.valueOf(l1);
    List localList1 = this.e.e("participant_id_1=? OR participant_id_2=? OR participant_id_3=? OR participant_id_4=? OR creator_participant_id=?", new String[] { str1, str1, str1, str1, str1 });
    ContentValues localContentValues1 = new ContentValues(2);
    Iterator localIterator1 = localList1.iterator();
    while (localIterator1.hasNext())
    {
      com.viber.voip.model.entity.h localh2 = (com.viber.voip.model.entity.h)localIterator1.next();
      if ((localh2.a()) && (!localh2.ao()) && (((localh2.R()) && (paramh2 != null)) || ((!localh2.R()) && (paramh1 != null))))
      {
        if (localh2.R());
        for (com.viber.voip.model.entity.h localh3 = paramh2; ; localh3 = paramh1)
        {
          if (localh3 == null)
            break label211;
          localb.a.put(Long.valueOf(localh2.getId()), localh3);
          a(localh3, localh2);
          break;
        }
      }
      label211: if (localh2.V() == l1)
      {
        localh2.f(paramLong1);
        localContentValues1.put("participant_id_1", Long.valueOf(paramLong1));
      }
      if (localh2.W() == l1)
      {
        localh2.g(paramLong1);
        localContentValues1.put("participant_id_2", Long.valueOf(paramLong1));
      }
      if (localh2.X() == l1)
      {
        localh2.h(paramLong1);
        localContentValues1.put("participant_id_3", Long.valueOf(paramLong1));
      }
      if (localh2.Y() == l1)
      {
        localh2.i(paramLong1);
        localContentValues1.put("participant_id_4", Long.valueOf(paramLong1));
      }
      if (localh2.Z() == l1)
      {
        localh2.j(paramLong1);
        localContentValues1.put("creator_participant_id", Long.valueOf(paramLong1));
      }
      if (localContentValues1.size() > 0)
      {
        this.e.a(localh2.getId(), localh2.getTable(), localContentValues1);
        localContentValues1.clear();
      }
    }
    List localList2 = this.d.i("participant_info_id=?", new String[] { str1 });
    ContentValues localContentValues2 = new ContentValues(1);
    Iterator localIterator2 = localList2.iterator();
    while (localIterator2.hasNext())
    {
      l locall = (l)localIterator2.next();
      if (!localb.a.containsKey(Long.valueOf(locall.b())))
      {
        locall.a(paramLong1);
        localContentValues2.put("participant_info_id", Long.valueOf(paramLong1));
        this.d.a(locall.getId(), locall.getTable(), localContentValues2);
        localContentValues2.clear();
      }
    }
    ContentValues localContentValues3 = new ContentValues(2);
    ContentValues localContentValues4 = new ContentValues(1);
    b localb1 = aa.f();
    Iterator localIterator3 = localb.a.entrySet().iterator();
    if (localIterator3.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator3.next();
      String str2 = String.valueOf(localEntry.getKey());
      com.viber.voip.model.entity.h localh1 = (com.viber.voip.model.entity.h)localEntry.getValue();
      long l2 = localh1.getId();
      long l3;
      if (localh1.R())
        l3 = paramLong5;
      for (long l4 = paramLong4; ; l4 = paramLong2)
      {
        if ((l4 > 0L) && (l3 > 0L))
        {
          (a(localb1, localContentValues3, l2, l4, true, str2) + a(localb1, localContentValues3, l2, l3, false, str2));
          localContentValues4.put("conversation_id", Long.valueOf(l2));
          localb1.a("messages_calls", localContentValues4, "conversation_id=?", new String[] { str2 });
        }
        localContentValues3.clear();
        localContentValues4.clear();
        break;
        l3 = paramLong3;
      }
    }
    paramm.b(av.a(paramm.m(), 1));
    this.c.a(paramm.getTable(), paramm.getId(), "participant_info_flags", Integer.valueOf(paramm.m()));
    return localb;
  }

  private c a(long paramLong)
  {
    ab localab = this.e;
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramLong);
    List localList = localab.e("conversation_type = 0 AND participant_id_1 = ? AND (flags & (1 << 34)) = 0", arrayOfString);
    Object localObject1 = null;
    Object localObject2 = null;
    Iterator localIterator1 = localList.iterator();
    if (localIterator1.hasNext())
    {
      Object localObject3 = (com.viber.voip.model.entity.h)localIterator1.next();
      if (((com.viber.voip.model.entity.h)localObject3).R());
      while (true)
      {
        localObject2 = localObject3;
        break;
        localObject1 = localObject3;
        localObject3 = localObject2;
      }
    }
    long l1 = this.c.b().getId();
    long l2 = -1L;
    long l3 = -1L;
    if (localObject1 != null)
    {
      Iterator localIterator3 = this.d.b(localObject1.getId()).iterator();
      while (localIterator3.hasNext())
      {
        l locall2 = (l)localIterator3.next();
        if (locall2.a() == l1)
          l3 = locall2.getId();
        else
          l2 = locall2.getId();
      }
    }
    long l4 = l3;
    long l5 = l2;
    long l6 = -1L;
    long l7 = -1L;
    if (localObject2 != null)
    {
      Iterator localIterator2 = this.d.b(localObject2.getId()).iterator();
      while (localIterator2.hasNext())
      {
        l locall1 = (l)localIterator2.next();
        if (locall1.a() == l1)
          l7 = locall1.getId();
        else
          l6 = locall1.getId();
      }
    }
    long l8 = l7;
    return new c(localObject1, l5, l4, localObject2, l6, l8);
  }

  private LongSparseSet a(b paramb, Set<Long> paramSet)
  {
    String str = String.format("conversation_id IN (%s)", new Object[] { com.viber.voip.s.a.e(paramSet) });
    Cursor localCursor = paramb.a("participants", new String[] { "_id" }, str, null, null, null, null);
    try
    {
      boolean bool1 = af.c(localCursor);
      LongSparseSet localLongSparseSet = null;
      if (bool1)
      {
        localLongSparseSet = new LongSparseSet();
        boolean bool2;
        do
        {
          localLongSparseSet.add(localCursor.getLong(localCursor.getColumnIndex("_id")));
          bool2 = localCursor.moveToNext();
        }
        while (bool2);
      }
      return localLongSparseSet;
    }
    finally
    {
      af.a(localCursor);
    }
  }

  private void a(b paramb, Map<Long, com.viber.voip.model.entity.h> paramMap)
  {
    ContentValues localContentValues = new ContentValues(1);
    Iterator localIterator = paramMap.entrySet().iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localContentValues.put("conversation_id", Long.valueOf(((com.viber.voip.model.entity.h)localEntry.getValue()).getId()));
      String[] arrayOfString = new String[1];
      arrayOfString[0] = String.valueOf(localEntry.getKey());
      j = i + paramb.a("conference_calls", localContentValues, "conversation_id = ?", arrayOfString);
      localContentValues.clear();
    }
    if (i > 0)
      ((ConferenceCallsRepository)this.g.get()).invalidate();
  }

  private void a(com.viber.voip.model.entity.h paramh1, com.viber.voip.model.entity.h paramh2)
  {
    long l1 = paramh1.z();
    long l2 = paramh2.z();
    long l3 = a(a(l1 | l2 & av.a(0, new int[] { 7, 5, 9, 8, 15 }), l2, 32), l2, 10);
    ContentValues localContentValues = new ContentValues(2);
    if (l1 != l3)
    {
      paramh1.d(l3);
      localContentValues.put("flags", Long.valueOf(paramh1.z()));
    }
    long l4 = paramh2.aa();
    if (paramh1.aa() < l4)
    {
      paramh1.k(l4);
      localContentValues.put("read_notification_token", Long.valueOf(l4));
    }
    if (localContentValues.size() > 0)
      this.e.a(paramh1.getId(), paramh1.getTable(), localContentValues);
  }

  public m a(List<m> paramList, Member paramMember, int paramInt, a parama)
  {
    int i = paramList.size();
    a(paramList, paramMember);
    m localm = (m)paramList.get(0);
    b localb = new b();
    this.c.a(new h(this, i, paramList, localm, paramInt, paramMember, localb));
    Set localSet = localb.a.keySet();
    if (!u.a(localSet))
    {
      HashSet localHashSet = new HashSet(2 * localSet.size());
      localHashSet.addAll(localSet);
      Iterator localIterator = localb.a.values().iterator();
      while (localIterator.hasNext())
        localHashSet.add(Long.valueOf(((com.viber.voip.model.entity.h)localIterator.next()).getId()));
      this.f.a(localSet);
      com.viber.voip.notif.g.a(this.b).a(localHashSet);
      this.e.a(localSet, 33, false);
      this.e.o();
      this.h.a(localHashSet, 0, false, false);
    }
    if (parama != null)
      parama.a(localb);
    return localm;
  }

  public void a(List<m> paramList, Member paramMember)
  {
    Collections.sort(paramList, new i(paramMember));
  }

  public static abstract interface a
  {
    public abstract void a(g.b paramb);
  }

  public static class b
  {

    @SuppressLint({"UseSparseArrays"})
    public final Map<Long, com.viber.voip.model.entity.h> a = new HashMap(2);
    public final LongSparseSet b = new LongSparseSet(2);
    public final LongSparseSet c = new LongSparseSet(2);

    void a(b paramb)
    {
      this.a.putAll(paramb.a);
      this.b.addAll(paramb.b);
      this.c.addAll(paramb.c);
    }
  }

  private static class c
  {
    final com.viber.voip.model.entity.h a;
    final long b;
    final long c;
    final com.viber.voip.model.entity.h d;
    final long e;
    final long f;

    c(com.viber.voip.model.entity.h paramh1, long paramLong1, long paramLong2, com.viber.voip.model.entity.h paramh2, long paramLong3, long paramLong4)
    {
      this.a = paramh1;
      this.b = paramLong1;
      this.c = paramLong2;
      this.d = paramh2;
      this.e = paramLong3;
      this.f = paramLong4;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.manager.g
 * JD-Core Version:    0.6.2
 */