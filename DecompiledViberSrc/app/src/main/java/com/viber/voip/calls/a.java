package com.viber.voip.calls;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.c.e.b;
import com.viber.voip.messages.orm.manager.AsyncEntityManager;
import com.viber.voip.messages.orm.manager.AsyncEntityManager.FillCursorCompleteCallback;
import com.viber.voip.messages.orm.manager.EntityManager;
import com.viber.voip.messages.orm.service.ServiceSaveCallback;
import com.viber.voip.model.d;
import com.viber.voip.model.entity.CallEntity;
import com.viber.voip.util.bq.c;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class a
{
  private static final Logger a = ViberEnv.getLogger();
  private AsyncEntityManager b = new AsyncEntityManager(CallEntity.ENTITY_CREATOR, false);
  private Context c;
  private b d;

  public a(Context paramContext)
  {
    this.c = paramContext;
    this.d = b.a(this.c);
  }

  public void a(final long paramLong, final d.b paramb)
  {
    this.b.fillCursor(this.d, new AsyncEntityManager.FillCursorCompleteCallback()
    {
      public void onDataReady(EntityManager paramAnonymousEntityManager, int paramAnonymousInt)
      {
        int i = 0;
        if (paramAnonymousEntityManager != null);
        LinkedHashSet localLinkedHashSet;
        for (int j = paramAnonymousEntityManager.getCount(); ; j = 0)
        {
          localLinkedHashSet = new LinkedHashSet(j);
          while (i < j)
          {
            localLinkedHashSet.add((CallEntity)paramAnonymousEntityManager.getEntity(i));
            i++;
          }
        }
        if (paramAnonymousEntityManager != null)
          paramAnonymousEntityManager.closeCursor();
        if (paramb != null)
          paramb.a(paramLong, localLinkedHashSet);
      }
    }
    , "date DESC", 0, "aggregate_hash=" + paramLong, new String[0]);
  }

  public void a(final a parama)
  {
    this.d.a(1595, null, com.viber.provider.contacts.a.b.a, null, null, new bq.c()
    {
      public void onDeleteComplete(int paramAnonymousInt1, Object paramAnonymousObject, int paramAnonymousInt2)
      {
        if (parama != null)
          parama.a();
      }
    }
    , false, true);
  }

  public void a(final a parama, Long[] paramArrayOfLong)
  {
    this.d.a(1595, null, com.viber.provider.contacts.a.b.a, "aggregate_hash IN (" + com.viber.voip.s.a.a(paramArrayOfLong) + ")", null, new bq.c()
    {
      public void onDeleteComplete(int paramAnonymousInt1, Object paramAnonymousObject, int paramAnonymousInt2)
      {
        if (parama != null)
          parama.a();
      }
    }
    , false, true);
  }

  public void a(d.b paramb)
  {
    a(paramb, "viber_call_type=2");
  }

  public void a(final d.b paramb, String paramString)
  {
    this.b.fillCursor(this.d, new AsyncEntityManager.FillCursorCompleteCallback()
    {
      public void onDataReady(EntityManager paramAnonymousEntityManager, int paramAnonymousInt)
      {
        int i = 0;
        if (paramAnonymousEntityManager != null);
        HashSet localHashSet;
        for (int j = paramAnonymousEntityManager.getCount(); ; j = 0)
        {
          localHashSet = new HashSet(j);
          while (i < j)
          {
            localHashSet.add((CallEntity)paramAnonymousEntityManager.getEntity(i));
            i++;
          }
        }
        if (paramAnonymousEntityManager != null)
          paramAnonymousEntityManager.closeCursor();
        if (paramb != null)
          paramb.a(0L, localHashSet);
      }
    }
    , null, 0, paramString, new String[0]);
  }

  public void a(CallEntity paramCallEntity, final b paramb)
  {
    AsyncEntityManager.save(paramCallEntity, paramCallEntity.getCreator(), new ServiceSaveCallback()
    {
      public void onDataSave(d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        if (paramb != null)
          paramb.a(true);
      }
    });
  }

  public void b(final a parama, Long[] paramArrayOfLong)
  {
    this.d.a(1595, null, com.viber.provider.contacts.a.b.a, "_id IN (" + com.viber.voip.s.a.a(paramArrayOfLong) + ")", null, new bq.c()
    {
      public void onDeleteComplete(int paramAnonymousInt1, Object paramAnonymousObject, int paramAnonymousInt2)
      {
        if (parama != null)
          parama.a();
      }
    }
    , false, true);
  }

  public static abstract interface a
  {
    public abstract void a();
  }

  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.a
 * JD-Core Version:    0.6.2
 */