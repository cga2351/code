package com.viber.voip.contacts.b.a;

import android.database.Cursor;
import android.net.Uri;
import com.viber.provider.contacts.a.b;
import com.viber.voip.calls.a.a.a.a;
import com.viber.voip.messages.orm.creator.Creator;
import com.viber.voip.messages.orm.creator.JoinCreator;
import com.viber.voip.model.entity.AggregatedCallEntity;
import com.viber.voip.model.entity.CallEntity;
import com.viber.voip.model.entity.e;
import com.viber.voip.model.entity.k;
import com.viber.voip.model.entity.t;
import com.viber.voip.model.entity.x;
import java.util.TreeSet;

public class a extends JoinCreator
{
  public static final a.a a = new a.a()
  {
    public AggregatedCallEntity a()
    {
      return new AggregatedCallEntity();
    }

    public com.viber.voip.model.d createInstance(Cursor paramAnonymousCursor)
    {
      return createInstance(paramAnonymousCursor, 0);
    }

    public com.viber.voip.model.d createInstance(Cursor paramAnonymousCursor, int paramAnonymousInt)
    {
      return a(a(), paramAnonymousCursor, paramAnonymousInt);
    }
  };
  private static final b b = new b()
  {
    public e a()
    {
      return new com.viber.voip.model.entity.d();
    }
  };
  private String[] c;
  private int d = getProjectionColumn(CallEntity.ENTITY_CREATOR, "aggregate_hash");

  public a()
  {
    super(localUri, a.b.class, arrayOfCreator);
  }

  public com.viber.voip.model.d createInstance(Cursor paramCursor)
  {
    try
    {
      AggregatedCallEntity localAggregatedCallEntity = (AggregatedCallEntity)createInstancesInternal(paramCursor, a);
      k localk = (k)createInstancesInternal(paramCursor, t.j);
      com.viber.voip.model.entity.d locald = (com.viber.voip.model.entity.d)createInstancesInternal(paramCursor, b);
      x localx = (x)createInstancesInternal(paramCursor, x.a);
      if (localk.getId() != 0L)
        localAggregatedCallEntity.setNumberData(localk);
      if (locald.getId() != 0L)
      {
        if (localx.getId() != 0L)
        {
          TreeSet localTreeSet = new TreeSet(com.viber.voip.model.entity.d.m);
          localTreeSet.add(localx);
          locald.a(localTreeSet);
        }
        localAggregatedCallEntity.setContact(locald);
      }
      localAggregatedCallEntity.setCount(paramCursor.getInt(-1 + this.c.length));
      return localAggregatedCallEntity;
    }
    finally
    {
    }
  }

  public int getAggregateField()
  {
    return this.d;
  }

  public String[] getProjections()
  {
    if (this.c == null)
    {
      String[] arrayOfString = super.getProjections();
      if (arrayOfString == null)
        break label58;
      this.c = new String[1 + arrayOfString.length];
      System.arraycopy(arrayOfString, 0, this.c, 0, arrayOfString.length);
    }
    while (true)
    {
      this.c[(-1 + this.c.length)] = "COUNT(*)";
      return this.c;
      label58: this.c = new String[1];
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.b.a.a
 * JD-Core Version:    0.6.2
 */