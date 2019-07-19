package com.viber.voip.ui.doodle.b;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.ui.doodle.a.a.a.b;
import com.viber.voip.ui.doodle.a.d.a;
import com.viber.voip.ui.doodle.extras.TextInfo;
import com.viber.voip.ui.doodle.extras.g;
import com.viber.voip.ui.doodle.objects.BaseObject;
import com.viber.voip.ui.doodle.objects.BaseObject.a;
import com.viber.voip.ui.doodle.objects.MovableObject;
import java.util.Collection;
import java.util.Iterator;

public class a extends d<MovableObject>
  implements d.a
{
  private static final Logger f = ViberEnv.getLogger();
  private final ArrayMap<BaseObject.a, d<? extends MovableObject>> g;
  private final com.viber.voip.ui.doodle.a.d h;
  private d<? extends MovableObject> i;
  private final a j;

  public a(Context paramContext, com.viber.voip.ui.doodle.scene.a parama, a.b paramb, com.viber.voip.ui.doodle.undo.a parama1, com.viber.voip.ui.doodle.objects.c.a parama2, a parama3, g paramg, c.a parama4, Bundle paramBundle)
  {
    super(paramContext, parama, paramb, parama1, parama2, paramg, parama4, paramBundle);
    this.j = parama3;
    this.g = new ArrayMap(2);
    this.g.put(BaseObject.a.b, new e(paramContext, parama, paramb, parama1, parama2, paramg, parama4, null));
    this.g.put(BaseObject.a.c, new f(paramContext, parama, paramb, parama1, parama2, paramg, parama4, null));
    this.h = new com.viber.voip.ui.doodle.a.d(paramContext, parama, this, paramb);
    this.b.a(this.h);
    if (paramBundle != null)
      b(paramBundle);
  }

  private void a(d<?> paramd)
  {
    if (paramd.a != null)
    {
      b(paramd);
      return;
    }
    g();
  }

  private void a(d<? extends MovableObject> paramd, MovableObject paramMovableObject)
  {
    if (paramd != null)
    {
      if (this.i != paramd)
      {
        this.i = paramd;
        if (this.j != null)
          this.j.a(paramMovableObject.getType());
      }
      if (this.i.a != paramMovableObject)
        this.i.b(paramMovableObject);
    }
    if (this.i == null)
      throw new IllegalStateException("Unable to find suitable handler for " + paramMovableObject);
  }

  private void b(Bundle paramBundle)
  {
    MovableObject localMovableObject = (MovableObject)this.d.a(paramBundle.getLong(e()));
    if (localMovableObject == null)
      return;
    d(localMovableObject);
  }

  private void b(d<?> paramd)
  {
    this.i = paramd;
    this.b.a(this.h);
  }

  private d<? extends MovableObject> c(BaseObject paramBaseObject)
  {
    if ((this.i != null) && (this.i.a(paramBaseObject)))
      return this.i;
    Iterator localIterator = this.g.values().iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (locald.a(paramBaseObject))
        return locald;
    }
    return null;
  }

  private void d(MovableObject paramMovableObject)
  {
    a(c(paramMovableObject), paramMovableObject);
  }

  private BaseObject g()
  {
    return this.b.a(new com.viber.voip.ui.doodle.scene.a.a()
    {
      public boolean a(BaseObject paramAnonymousBaseObject)
      {
        d locald = a.a(a.this, paramAnonymousBaseObject);
        if (locald != null);
        for (boolean bool = true; ; bool = false)
        {
          if (bool)
            a.a(a.this, locald, (MovableObject)paramAnonymousBaseObject);
          return bool;
        }
      }
    });
  }

  public void a()
  {
    b((d)this.g.get(BaseObject.a.b));
  }

  public void a(Bundle paramBundle)
  {
    if ((this.i != null) && (this.i.a != null))
      paramBundle.putLong(e(), ((MovableObject)this.i.a).getId());
  }

  public void a(Sticker paramSticker)
  {
    e locale = (e)this.g.get(BaseObject.a.b);
    locale.a(paramSticker);
    a(locale);
    this.b.a(this.h);
  }

  public void a(com.viber.voip.ui.doodle.commands.a<MovableObject> parama)
  {
    this.i.a(parama);
  }

  public void a(TextInfo paramTextInfo)
  {
    f localf = (f)this.g.get(BaseObject.a.c);
    if (localf.a(paramTextInfo))
      return;
    localf.b(paramTextInfo);
    a(localf);
    this.b.a(this.h);
  }

  public boolean a(long paramLong)
  {
    if (this.i == null);
    for (boolean bool = false; ; bool = this.i.a(paramLong))
    {
      if (bool)
        g();
      return bool;
    }
  }

  public boolean a(com.viber.voip.ui.doodle.commands.d<MovableObject> paramd)
  {
    MovableObject localMovableObject = (MovableObject)paramd.a(this.b);
    if (localMovableObject != null)
    {
      d(localMovableObject);
      return true;
    }
    if ((this.i != null) && (this.i.a != null));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  protected boolean a(BaseObject paramBaseObject)
  {
    return false;
  }

  public boolean a(MovableObject paramMovableObject)
  {
    d(paramMovableObject);
    return true;
  }

  public void b()
  {
    b((d)this.g.get(BaseObject.a.c));
  }

  public c.b c()
  {
    return c.b.d;
  }

  public c.b d()
  {
    if (this.i != null)
      return this.i.c();
    return null;
  }

  public static abstract interface a
  {
    public abstract void a(BaseObject.a parama);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.b.a
 * JD-Core Version:    0.6.2
 */