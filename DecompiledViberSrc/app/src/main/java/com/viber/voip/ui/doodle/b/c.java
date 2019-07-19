package com.viber.voip.ui.doodle.b;

import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.ui.doodle.a.f;
import com.viber.voip.ui.doodle.extras.g;
import com.viber.voip.ui.doodle.objects.BaseObject;
import com.viber.voip.ui.doodle.undo.Undo;

public abstract class c<T extends BaseObject>
  implements f
{
  private static final Logger f = ViberEnv.getLogger();
  T a;
  final com.viber.voip.ui.doodle.scene.a b;
  final com.viber.voip.ui.doodle.undo.a c;
  final com.viber.voip.ui.doodle.objects.c.a d;
  final g e;
  private final ArrayMap<com.viber.voip.ui.doodle.commands.c.b, Runnable> g;
  private final a h;

  c(com.viber.voip.ui.doodle.scene.a parama, com.viber.voip.ui.doodle.undo.a parama1, com.viber.voip.ui.doodle.objects.c.a parama2, g paramg, a parama3, Bundle paramBundle)
  {
    this.b = parama;
    this.c = parama1;
    this.d = parama2;
    this.e = paramg;
    this.h = parama3;
    this.g = a();
    if (paramBundle != null)
      b(paramBundle);
  }

  private ArrayMap<com.viber.voip.ui.doodle.commands.c.b, Runnable> a()
  {
    ArrayMap localArrayMap = new ArrayMap(2);
    localArrayMap.put(com.viber.voip.ui.doodle.commands.c.b.a, new Runnable()
    {
      public void run()
      {
        c.a(c.this).a(c.this.c());
      }
    });
    localArrayMap.put(com.viber.voip.ui.doodle.commands.c.b.b, new Runnable()
    {
      public void run()
      {
        c.this.b.d();
        c.a(c.this).b(c.this.c());
      }
    });
    return localArrayMap;
  }

  private void b(Bundle paramBundle)
  {
    this.a = this.d.a(paramBundle.getLong(e()));
  }

  public void a(Bundle paramBundle)
  {
    if (this.a != null)
      paramBundle.putLong(e(), this.a.getId());
  }

  public void a(com.viber.voip.ui.doodle.commands.c paramc)
  {
    Runnable localRunnable = (Runnable)this.g.get(paramc.a());
    if (localRunnable != null)
      localRunnable.run();
  }

  void a(Undo paramUndo)
  {
    this.c.a(paramUndo);
  }

  public boolean a(long paramLong)
  {
    if ((this.a != null) && (this.a.getId() == paramLong))
    {
      this.a = null;
      return true;
    }
    return false;
  }

  protected void b(T paramT)
  {
    this.a = paramT;
    this.d.a(paramT);
    this.b.d(paramT);
    f();
  }

  public abstract b c();

  final String e()
  {
    return "active_object_id_" + c().ordinal();
  }

  final void f()
  {
    this.b.b();
  }

  public static abstract interface a
  {
    public abstract void a(c.b paramb);

    public abstract void b(c.b paramb);
  }

  public static enum b
  {
    static
    {
      b[] arrayOfb = new b[4];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.b.c
 * JD-Core Version:    0.6.2
 */