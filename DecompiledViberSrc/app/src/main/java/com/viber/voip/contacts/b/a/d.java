package com.viber.voip.contacts.b.a;

import android.database.Cursor;
import android.net.Uri;
import com.viber.voip.messages.orm.creator.Creator;
import com.viber.voip.messages.orm.creator.JoinCreator;
import com.viber.voip.model.entity.c;
import com.viber.voip.model.entity.e;
import com.viber.voip.model.entity.g;
import com.viber.voip.model.entity.k;
import com.viber.voip.model.entity.t;
import com.viber.voip.model.entity.x;
import java.util.Collection;

public class d extends JoinCreator
{
  private static final b a = new b()
  {
    public e a()
    {
      return new g();
    }
  };
  private int b = 0;

  public d()
  {
    super(localUri, e.class, arrayOfCreator);
  }

  public g a()
  {
    return new g();
  }

  public final g a(Cursor paramCursor)
  {
    g localg = (g)createInstancesInternal(paramCursor, a);
    do
    {
      t localt = (t)createInstancesInternal(paramCursor, t.j);
      x localx = (x)createInstancesInternal(paramCursor, x.a);
      c localc = (c)createInstancesInternal(paramCursor, c.a);
      if ((localt instanceof k))
        localg.a((k)localt, localx, localc);
    }
    while (moveToNext(paramCursor, localg.getId()));
    if (localg.s().size() != 0);
    for (boolean bool = true; ; bool = false)
    {
      localg.c(bool);
      return localg;
    }
  }

  public int getAggregateField()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.b.a.d
 * JD-Core Version:    0.6.2
 */