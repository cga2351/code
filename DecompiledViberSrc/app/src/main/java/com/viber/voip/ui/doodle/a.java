package com.viber.voip.ui.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.ui.doodle.b.b;
import com.viber.voip.ui.doodle.b.c.a;
import com.viber.voip.ui.doodle.b.c.b;
import com.viber.voip.ui.doodle.extras.TextInfo;
import com.viber.voip.ui.doodle.extras.d;
import com.viber.voip.ui.doodle.extras.e;
import com.viber.voip.ui.doodle.extras.e.a;
import com.viber.voip.ui.doodle.extras.f;
import com.viber.voip.ui.doodle.extras.h;
import com.viber.voip.ui.doodle.objects.BaseObject.a;
import com.viber.voip.ui.doodle.objects.MovableObject;
import com.viber.voip.ui.doodle.scene.SceneConfig;
import com.viber.voip.ui.doodle.scene.SceneView;
import com.viber.voip.ui.doodle.scene.a.c;
import com.viber.voip.ui.doodle.undo.Undo;

public class a
  implements c.a
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final com.viber.voip.ui.doodle.a.a.a.b c;
  private final com.viber.voip.ui.doodle.scene.a d;
  private final com.viber.voip.ui.doodle.undo.a e;
  private final com.viber.voip.ui.doodle.objects.c.a f;
  private ArrayMap<c.b, a> g;
  private com.viber.voip.ui.doodle.b.c<?> h;
  private final b i;
  private final d j;
  private final f k;

  public a(SceneView paramSceneView, com.viber.voip.ui.doodle.a.a.a.b paramb, b paramb1, d paramd, Bundle paramBundle)
  {
    this.b = paramSceneView.getContext();
    this.c = paramb;
    this.i = paramb1;
    this.j = paramd;
    this.k = new f(paramBundle);
    this.e = new com.viber.voip.ui.doodle.undo.a(new com.viber.voip.ui.doodle.undo.a.a()
    {
      public void a(int paramAnonymousInt)
      {
        a.b localb = a.a(a.this);
        if (paramAnonymousInt == 0);
        for (boolean bool = true; ; bool = false)
        {
          localb.a(bool);
          return;
        }
      }
    }
    , paramBundle);
    this.f = new com.viber.voip.ui.doodle.objects.c.a(new h()
    {
      public void a(long paramAnonymousLong)
      {
        a.b(a.this).a(paramAnonymousLong);
      }
    }
    , paramBundle);
    this.d = new com.viber.voip.ui.doodle.scene.a(paramSceneView, this.f, new com.viber.voip.ui.doodle.scene.a.b()
    {
      public void a(int paramAnonymousInt)
      {
        a.a(a.this).a(paramAnonymousInt);
      }

      public void a(long paramAnonymousLong)
      {
        if (a.f(a.this) != null)
          a.f(a.this).a(paramAnonymousLong);
        a.b(a.this).b();
      }

      public void a(MovableObject paramAnonymousMovableObject)
      {
        a.a(a.this, ((a.a)a.e(a.this).get(c.b.d)).a(null));
        ((com.viber.voip.ui.doodle.b.a)a.f(a.this)).a(paramAnonymousMovableObject);
      }

      public void b(long paramAnonymousLong)
      {
        a.d(a.this).a(paramAnonymousLong).execute(a.c(a.this), a.b(a.this));
        a.a(a.this).d();
      }
    }
    , new e()
    {
      public void a(e.a paramAnonymousa)
      {
        if (BaseObject.a.c == paramAnonymousa.getType())
          a.a(a.this).a((TextInfo)paramAnonymousa);
      }
    }
    , paramBundle);
    j();
    if ((paramBundle != null) && (paramBundle.containsKey("active_mode_name")))
    {
      c.b localb = c.b.values()[paramBundle.getInt("active_mode_name")];
      this.h = ((a)this.g.get(localb)).a(paramBundle);
    }
  }

  private void j()
  {
    this.g = new ArrayMap(2);
    this.g.put(c.b.c, new a()
    {
      public com.viber.voip.ui.doodle.b.c<?> a(Bundle paramAnonymousBundle)
      {
        return new b(a.g(a.this), a.b(a.this), a.d(a.this), a.c(a.this), a.h(a.this), a.this, a.i(a.this), paramAnonymousBundle);
      }
    });
    this.g.put(c.b.d, new a()
    {
      private com.viber.voip.ui.doodle.b.a b;

      public com.viber.voip.ui.doodle.b.c<?> a(Bundle paramAnonymousBundle)
      {
        if (this.b == null)
          this.b = new com.viber.voip.ui.doodle.b.a(a.g(a.this), a.b(a.this), a.j(a.this), a.d(a.this), a.c(a.this), new com.viber.voip.ui.doodle.b.a.a()
          {
            public void a(BaseObject.a paramAnonymous2a)
            {
              if (BaseObject.a.b == paramAnonymous2a)
              {
                a.a(a.this).a();
                return;
              }
              a.a(a.this).b();
            }
          }
          , a.h(a.this), a.this, paramAnonymousBundle);
        return this.b;
      }
    });
  }

  public long a()
  {
    return this.f.a() + this.d.a() + this.e.a() + this.k.b();
  }

  public void a(Bitmap paramBitmap)
  {
    Canvas localCanvas = new Canvas(paramBitmap);
    localCanvas.getWidth();
    localCanvas.getHeight();
    float f1 = Math.min(this.d.f().getScaleFactor() * localCanvas.getWidth() / this.d.f().getDrawingWidth(), this.d.f().getScaleFactor() * localCanvas.getHeight() / this.d.f().getDrawingHeight());
    localCanvas.scale(f1, f1);
    this.d.a(localCanvas);
  }

  public void a(Bundle paramBundle)
  {
    if (a() <= 256000L)
    {
      this.f.a(paramBundle);
      this.d.a(paramBundle);
      this.e.a(paramBundle);
      this.k.a(paramBundle);
    }
    if (this.h != null)
    {
      this.h.a(paramBundle);
      paramBundle.putInt("active_mode_name", this.h.c().ordinal());
    }
  }

  public void a(Sticker paramSticker)
  {
    this.h = ((a)this.g.get(c.b.d)).a(null);
    ((com.viber.voip.ui.doodle.b.a)this.h).a(paramSticker);
    this.i.a();
  }

  public void a(c.b paramb)
  {
    if (c.b.d == paramb)
    {
      this.i.a(((com.viber.voip.ui.doodle.b.a)this.h).d());
      return;
    }
    this.i.a(paramb);
  }

  public void a(TextInfo paramTextInfo)
  {
    this.h = ((a)this.g.get(c.b.d)).a(null);
    ((com.viber.voip.ui.doodle.b.a)this.h).a(paramTextInfo);
    this.i.b();
  }

  public void a(boolean paramBoolean)
  {
    this.d.a(paramBoolean);
  }

  public void b()
  {
    this.d.e();
    this.e.c();
    this.f.b();
  }

  public void b(c.b paramb)
  {
    if (c.b.d == paramb)
    {
      this.i.b(((com.viber.voip.ui.doodle.b.a)this.h).d());
      return;
    }
    this.i.b(paramb);
  }

  public void c()
  {
    this.h = ((a)this.g.get(c.b.d)).a(null);
    ((com.viber.voip.ui.doodle.b.a)this.h).a();
    this.i.a();
  }

  public void d()
  {
    this.h = null;
    this.d.a(null);
  }

  public void e()
  {
    this.h = ((a)this.g.get(c.b.d)).a(null);
    ((com.viber.voip.ui.doodle.b.a)this.h).b();
    this.i.b();
  }

  public void f()
  {
    this.h = ((a)this.g.get(c.b.c)).a(null);
    this.i.c();
  }

  public void g()
  {
    this.e.b().execute(this.f, this.d);
    this.d.c();
  }

  public int h()
  {
    return this.d.hashCode();
  }

  public com.viber.voip.ui.doodle.scene.c i()
  {
    return this.d.g();
  }

  private static abstract interface a
  {
    public abstract com.viber.voip.ui.doodle.b.c<?> a(Bundle paramBundle);
  }

  public static abstract interface b extends c.a, a.c
  {
    public abstract void a();

    public abstract void a(TextInfo paramTextInfo);

    public abstract void a(boolean paramBoolean);

    public abstract void b();

    public abstract void c();

    public abstract void d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.a
 * JD-Core Version:    0.6.2
 */