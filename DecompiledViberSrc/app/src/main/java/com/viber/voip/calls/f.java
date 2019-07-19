package com.viber.voip.calls;

import android.content.Context;
import android.database.ContentObserver;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.model.entity.CallEntity;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class f extends ContentObserver
{
  private static final Logger a = ViberEnv.getLogger();
  private a b;
  private a c;
  private boolean d;
  private Queue<CallEntity> e = new LinkedList();
  private Map<CallEntity, d.a> f = new HashMap();

  public f(Context paramContext, a parama)
  {
    super(av.a(av.e.c));
    this.c = parama;
    this.b = new a(paramContext);
  }

  private void a()
  {
    try
    {
      if (this.e.size() > 0)
      {
        CallEntity localCallEntity = (CallEntity)this.e.poll();
        b(localCallEntity, (d.a)this.f.remove(localCallEntity));
      }
      while (true)
      {
        return;
        this.d = false;
      }
    }
    finally
    {
    }
  }

  private void b(final CallEntity paramCallEntity, final d.a parama)
  {
    a.b local1 = new a.b()
    {
      public void a(boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          if (f.a(f.this) != null)
            f.a(f.this).a(0);
          if (parama != null)
            parama.onInsert(paramCallEntity);
        }
        f.b(f.this);
      }
    };
    this.b.a(paramCallEntity, local1);
  }

  public void a(CallEntity paramCallEntity, d.a parama)
  {
    try
    {
      if (this.d)
      {
        this.e.add(paramCallEntity);
        this.f.put(paramCallEntity, parama);
      }
      while (true)
      {
        return;
        this.d = true;
        b(paramCallEntity, parama);
      }
    }
    finally
    {
    }
  }

  public boolean deliverSelfNotifications()
  {
    return false;
  }

  public void onChange(boolean paramBoolean)
  {
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.f
 * JD-Core Version:    0.6.2
 */