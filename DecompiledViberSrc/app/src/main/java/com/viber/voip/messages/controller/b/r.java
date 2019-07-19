package com.viber.voip.messages.controller.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.viber.common.d.i;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.like.LikeController;
import com.viber.jni.like.LikeControllerDelegate.PublicGroupLikes;
import com.viber.jni.publicgroup.PgAction;
import com.viber.provider.b;
import com.viber.provider.messages.b.d;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.util.UnsignedInt;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.model.entity.j;
import com.viber.voip.s.a;
import com.viber.voip.util.af;
import com.viber.voip.util.av;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class r
  implements LikeControllerDelegate.PublicGroupLikes
{
  private static final Logger a = ViberEnv.getLogger();
  private final ab b = ab.b();
  private final a c = new a(null);
  private final o d = o.a();

  public static int a(int paramInt)
  {
    return 1 + 50 * ((paramInt - 1) / 50);
  }

  private void a(long paramLong, SparseIntArray paramSparseIntArray)
  {
    if ((paramSparseIntArray == null) || (paramSparseIntArray.size() == 0))
      return;
    int i = a(paramSparseIntArray.keyAt(0));
    int j = -1 + (50 + a(paramSparseIntArray.keyAt(-1 + paramSparseIntArray.size())));
    b localb = d.a(ViberApplication.getApplication());
    String[] arrayOfString1 = { "message_global_id", "token", "conversation_id" };
    String[] arrayOfString2 = new String[3];
    arrayOfString2[0] = String.valueOf(paramLong);
    arrayOfString2[1] = String.valueOf(i);
    arrayOfString2[2] = String.valueOf(j);
    Cursor localCursor = localb.a("messages", arrayOfString1, "group_id=? AND message_global_id BETWEEN ? AND ?", arrayOfString2, null, null, "message_global_id");
    int k = 0;
    int n;
    ContentValues localContentValues;
    String[] arrayOfString3;
    if (localCursor.moveToFirst())
    {
      n = localCursor.getInt(2);
      localContentValues = new ContentValues(1);
      arrayOfString3 = new String[2];
      localb.a();
    }
    while (true)
    {
      try
      {
        long l = localCursor.getLong(1);
        int i1 = paramSparseIntArray.get(localCursor.getInt(0));
        int i2 = this.b.j(l);
        arrayOfString3[0] = Long.toString(l);
        arrayOfString3[1] = Integer.toString(Math.max(i1, i2));
        localContentValues.put("likes_count", arrayOfString3[1]);
        k += localb.a("messages", localContentValues, "token=? AND likes_count<> ?", arrayOfString3);
        if (localCursor.moveToNext())
          continue;
        localb.c();
        localb.b();
        m = k;
        af.a(localCursor);
        if (m > 0)
        {
          List localList = this.b.a(n, i, j);
          if (localList.size() > 0)
          {
            t localt = new t(this, localList, paramSparseIntArray);
            this.b.a(localt);
          }
        }
        if ((n <= 0) || (m <= 0))
          break;
        this.d.a(n, 0L, false);
        return;
      }
      finally
      {
        localb.b();
      }
      int m = 0;
      n = 0;
    }
  }

  private void a(long paramLong, Collection<Integer> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.size() == 0));
    h localh;
    do
    {
      b localb;
      ContentValues localContentValues;
      Object[] arrayOfObject;
      do
      {
        return;
        localb = d.a(ViberApplication.getApplication());
        localContentValues = new ContentValues(3);
        localContentValues.put("extra_mime", Integer.valueOf(1007));
        localContentValues.put("extra_flags", Integer.valueOf(0));
        localContentValues.put("msg_info", "");
        arrayOfObject = new Object[2];
        arrayOfObject[0] = a.d(paramCollection);
        arrayOfObject[1] = Long.valueOf(paramLong);
      }
      while (localb.a("messages", localContentValues, String.format("message_global_id IN (%s)  AND group_id = %s  AND extra_mime <> 1007 AND token > 0", arrayOfObject), null) <= 0);
      localh = this.b.b(paramLong);
    }
    while (localh == null);
    this.b.a(new s(this, localh));
    this.d.a(localh.getId(), 0L, false);
    this.d.a(Collections.singleton(Long.valueOf(localh.getId())), localh.j(), false, false);
  }

  public void onGetPublicGroupLikes(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong, Map<Integer, PgAction> paramMap, int paramInt3)
  {
    if (paramInt3 == 0)
      this.c.a(paramInt1, paramMap);
    if ((paramBoolean) || (paramInt3 != 0))
    {
      i.a();
      a(paramLong, this.c.a(paramInt1));
      a(paramLong, this.c.b(paramInt1));
      this.c.c(paramInt1);
    }
  }

  public void onLikePublicGroupMessage(long paramLong1, long paramLong2, int paramInt1, boolean paramBoolean, int paramInt2, long paramLong3, int paramInt3)
  {
    MessageEntity localMessageEntity;
    if (paramInt3 != 1)
    {
      localMessageEntity = this.b.k(paramLong2);
      if (localMessageEntity != null);
    }
    label51: j localj1;
    label140: label150: 
    do
    {
      return;
      UnsignedInt localUnsignedInt = new UnsignedInt(localMessageEntity.getLikesCount());
      long l = localMessageEntity.getExtraFlags();
      boolean bool;
      if (!paramBoolean)
      {
        bool = true;
        localMessageEntity.setExtraFlags(av.a(l, 12, bool));
        if (!paramBoolean)
          break label140;
      }
      j localj2;
      for (int i = localUnsignedInt.decrement(); ; i = localUnsignedInt.increment())
      {
        localMessageEntity.setLikesCount(i);
        this.b.b(localMessageEntity);
        localj2 = this.b.b(paramInt2);
        if (localj2 == null)
          break;
        if (!paramBoolean)
          break label150;
        this.b.d(localj2.a(), localj2.d());
        return;
        bool = false;
        break label51;
      }
      localj2.b(0);
      this.b.b(localj2);
      return;
      localj1 = this.b.b(paramInt2);
    }
    while (localj1 == null);
    if (paramBoolean)
    {
      localj1.b(paramLong3);
      localj1.b(0);
      this.b.b(localj1);
      return;
    }
    this.b.d(localj1.a(), localj1.d());
  }

  public boolean onSyncMessageLike(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean, long paramLong3)
  {
    MessageEntity localMessageEntity = this.b.k(paramLong2);
    UnsignedInt localUnsignedInt;
    if ((localMessageEntity != null) && (paramBoolean != localMessageEntity.hasMyLike()))
    {
      long l = av.a(localMessageEntity.getExtraFlags(), 12, paramBoolean);
      localUnsignedInt = new UnsignedInt(localMessageEntity.getLikesCount());
      localMessageEntity.setExtraFlags(l);
      if (!paramBoolean)
        break label126;
    }
    label126: for (int i = localUnsignedInt.increment(); ; i = localUnsignedInt.decrement())
    {
      localMessageEntity.setLikesCount(i);
      this.b.b(localMessageEntity);
      this.d.a(localMessageEntity.getConversationId(), localMessageEntity.getMessageToken(), false);
      ViberApplication.getInstance().getEngine(true).getLikeController().handleSendSyncMessageLikeAck(paramLong3);
      return false;
    }
  }

  private class a
  {
    private SparseArray<SparseIntArray> b = new SparseArray();
    private SparseArray<Collection<Integer>> c = new SparseArray();

    private a()
    {
    }

    public SparseIntArray a(int paramInt)
    {
      return (SparseIntArray)this.b.get(paramInt);
    }

    public void a(int paramInt, Map<Integer, PgAction> paramMap)
    {
      SparseIntArray localSparseIntArray1 = a(paramInt);
      SparseIntArray localSparseIntArray2;
      if (localSparseIntArray1 == null)
      {
        localSparseIntArray2 = new SparseIntArray();
        this.b.put(paramInt, localSparseIntArray2);
      }
      for (SparseIntArray localSparseIntArray3 = localSparseIntArray2; ; localSparseIntArray3 = localSparseIntArray1)
      {
        Iterator localIterator = paramMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          PgAction localPgAction = (PgAction)localEntry.getValue();
          if (localPgAction.getActionFlags() == 0L)
          {
            localSparseIntArray3.put(((Integer)localEntry.getKey()).intValue(), localPgAction.getLikeCount());
          }
          else if (localPgAction.getActionFlags() == 1L)
          {
            Object localObject = b(paramInt);
            if (localObject == null)
            {
              localObject = new ArrayList();
              this.c.put(paramInt, localObject);
            }
            ((Collection)localObject).add(localEntry.getKey());
          }
        }
        return;
      }
    }

    public Collection<Integer> b(int paramInt)
    {
      return (Collection)this.c.get(paramInt);
    }

    public void c(int paramInt)
    {
      this.b.put(paramInt, null);
      this.c.put(paramInt, null);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.b.r
 * JD-Core Version:    0.6.2
 */