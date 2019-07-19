package com.viber.voip.messages.adapters;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.bot.item.b;
import com.viber.voip.messages.ui.d.d.a;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.i;
import com.viber.voip.stickers.ui.e;
import com.viber.voip.stickers.ui.f.a;
import com.viber.voip.stickers.w;
import com.viber.voip.util.dj;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class z extends a<Sticker>
{
  private static final Logger e = ViberEnv.getLogger();
  private static long f = 100L;
  private Context g;
  private i h;
  private d.a i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private int o = 0;
  private int p;
  private SparseArray<c> q = new SparseArray();
  private com.viber.voip.stickers.f r;
  private Handler s;
  private Handler t;

  static
  {
    ValueAnimator.setFrameDelay(50L);
  }

  public z(Context paramContext, int paramInt, com.viber.voip.stickers.f paramf, d.a parama, c paramc, LayoutInflater paramLayoutInflater)
  {
    super(paramContext, paramc, paramLayoutInflater);
    this.g = paramContext;
    this.i = parama;
    this.r = paramf;
    this.h = i.a();
    this.a = new ArrayList();
    if (!dj.c(this.g));
    for (boolean bool = true; ; bool = false)
    {
      this.j = bool;
      this.b = paramLayoutInflater;
      this.t = av.a(av.e.a);
      this.s = av.a(av.e.f);
      a(paramInt, 0, false, null);
      return;
    }
  }

  private void a(List<b<Sticker>> paramList, String paramString)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next());
  }

  protected int a()
  {
    return 12;
  }

  protected com.viber.voip.stickers.ui.a a(Context paramContext)
  {
    return new e(paramContext, this.o);
  }

  public void a(final int paramInt1, final int paramInt2, final boolean paramBoolean, final a parama)
  {
    System.currentTimeMillis();
    if (paramInt1 == 0)
      return;
    this.o = paramInt1;
    Runnable local1 = new Runnable()
    {
      public void run()
      {
        int i = 0;
        b[] arrayOfb = z.b(z.this).a(paramInt1, paramInt2, z.a(z.this));
        z.a(z.this, false);
        ArrayList localArrayList = new ArrayList(Arrays.asList(arrayOfb));
        int j = arrayOfb.length;
        for (int k = 0; k < j; k++)
        {
          b localb = arrayOfb[k];
          if (localb.a().size() > i)
            i = localb.a().size();
        }
        z.a(z.this, z.this.a, "old items");
        z.a(z.this, localArrayList, "new items");
        z.e locale = new z.e(z.this, localArrayList, i, parama);
        if (paramBoolean)
        {
          z.c(z.this).post(locale);
          return;
        }
        locale.run();
      }
    };
    if (paramBoolean)
    {
      this.s.removeCallbacks(local1);
      this.s.postDelayed(local1, f);
      return;
    }
    local1.run();
  }

  public void a(Sticker paramSticker)
  {
    c localc = (c)this.q.get(paramSticker.id);
    if (localc != null)
    {
      localc.a();
      c.a(localc, false);
    }
    b();
  }

  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
    this.m = paramBoolean;
    if (paramBoolean)
      b();
  }

  protected b b(ViewGroup paramViewGroup)
  {
    return new b(this.b, this.c, paramViewGroup, this.d);
  }

  public void b()
  {
    this.p = (1 + this.p);
    notifyDataSetChanged();
  }

  public boolean c()
  {
    if ((!this.k) || (this.n))
    {
      this.p = (1 + this.p);
      this.k = true;
      return true;
    }
    return false;
  }

  public boolean c(int paramInt)
  {
    boolean bool = this.c.b(paramInt);
    if (bool)
      b();
    return bool;
  }

  public boolean d()
  {
    boolean bool1 = this.l;
    boolean bool2 = false;
    if (bool1)
    {
      this.l = false;
      this.p = (1 + this.p);
      bool2 = true;
    }
    return bool2;
  }

  public boolean e()
  {
    if (!this.l)
    {
      this.l = true;
      return true;
    }
    return false;
  }

  public boolean f()
  {
    return this.m;
  }

  public static abstract interface a
  {
    public abstract void a();
  }

  private class b extends a.a<Sticker, z.d>
  {
    private int h;

    public b(LayoutInflater parama, com.viber.voip.stickers.ui.a paramViewGroup, ViewGroup paramInt, int arg5)
    {
      super(paramViewGroup, paramInt, i);
    }

    public void a(b<Sticker> paramb, int paramInt1, int paramInt2, long paramLong, int paramInt3, c paramc)
    {
      int i = 0;
      if ((paramb == this.c) && (this.h == z.e(z.this)));
      while (true)
      {
        return;
        this.h = z.e(z.this);
        b();
        super.a(paramb, paramInt1, paramInt2, paramLong, paramInt3, paramc);
        if (this.c != null)
          for (z.d locald : (z.d[])this.d)
            if (locald.i != null)
              locald.i.b();
        List localList = this.c.a();
        while (i < localList.size())
        {
          if (((z.d[])this.d)[i].i == null)
            ((z.d[])this.d)[i].i = new z.c(z.this, null);
          z.c.a(((z.d[])this.d)[i].i, ((z.d[])this.d)[i]);
          i++;
        }
        for (int j = localList.size(); j < ((z.d[])this.d).length; j++)
          ((z.d[])this.d)[j].i = null;
      }
    }

    protected z.d b(ViewGroup paramViewGroup)
    {
      View localView = this.a.inflate(R.layout.sticker_view, paramViewGroup, false);
      return new z.d(z.this, localView);
    }

    public void b()
    {
      z.d[] arrayOfd = (z.d[])this.d;
      int i = arrayOfd.length;
      for (int j = 0; j < i; j++)
        arrayOfd[j].b();
    }

    protected z.d[] b(int paramInt)
    {
      return new z.d[paramInt];
    }
  }

  private class c extends AnimatorListenerAdapter
    implements Animator.AnimatorListener
  {
    private boolean b;
    private boolean c;
    private z.d d;
    private ObjectAnimator e;
    private int f = 0;

    private c()
    {
    }

    private void a(z.d paramd)
    {
      this.d = paramd;
      this.f = (1 + this.f);
      paramd.a.a((Sticker)paramd.d);
      if (((Sticker)paramd.d).isReady())
      {
        paramd.h.setVisibility(8);
        paramd.b.setVisibility(0);
        boolean bool3;
        if (!z.g(z.this))
        {
          bool3 = true;
          a(false, bool3);
          if (this.e == null)
            break label127;
          if (z.g(z.this))
            break label121;
        }
        label121: for (boolean bool4 = true; ; bool4 = false)
        {
          a(true, bool4);
          paramd.g.setVisibility(0);
          return;
          bool3 = false;
          break;
        }
        label127: dj.a(paramd.b, 255);
        paramd.g.setVisibility(8);
        paramd.a.b(true);
        return;
      }
      paramd.b.setVisibility(8);
      paramd.g.setVisibility(0);
      paramd.h.setVisibility(0);
      paramd.a.b(false);
      boolean bool1 = z.g(z.this);
      boolean bool2 = false;
      if (!bool1)
        bool2 = true;
      a(true, bool2);
    }

    private void a(boolean paramBoolean)
    {
      if (this.d == null)
        return;
      this.c = false;
      if (this.e != null)
      {
        this.e.removeAllListeners();
        this.e.cancel();
      }
      this.d.b.setAlpha(0.0F);
      this.e = ObjectAnimator.ofFloat(this.d.b, "alpha", new float[] { 0.0F, 1.0F });
      this.e.setInterpolator(new AccelerateInterpolator());
      this.e.setDuration(2000L);
      this.e.addListener(this);
      if (paramBoolean)
        this.e.setStartDelay(1000L);
      this.e.start();
      z.b(z.this, true);
    }

    @SuppressLint({"InlinedApi"})
    private void a(boolean paramBoolean1, boolean paramBoolean2)
    {
      final int i = this.f;
      this.d.a.a(true, paramBoolean1, paramBoolean2, z.a(z.this), w.a, new f.a()
      {
        public boolean a(boolean paramAnonymousBoolean)
        {
          return z.c.b(z.c.this) == i;
        }
      });
    }

    public void a()
    {
      ((Sticker)this.d.d).checkStatus();
    }

    public void a(MotionEvent paramMotionEvent)
    {
      if ((!((Sticker)this.d.d).isReady()) || (this.e != null));
      do
      {
        do
        {
          do
          {
            return;
            if (paramMotionEvent.getAction() == 0)
            {
              this.d.j = true;
              final int i = this.f;
              if (this.d.a.a(false, true, z.a(z.this), w.a, new f.a()
              {
                public boolean a(boolean paramAnonymousBoolean)
                {
                  if ((z.c.a(z.c.this) != null) && (z.c.b(z.c.this) == i) && ((z.c.a(z.c.this).j) || (z.c.c(z.c.this))))
                    z.c.a(z.c.this).g.setVisibility(0);
                  for (boolean bool = true; ; bool = false)
                  {
                    z.c.b(z.c.this, false);
                    if (z.c.c(z.c.this))
                    {
                      z.c.c(z.c.this, false);
                      z.c.a(z.c.this, true);
                    }
                    return bool;
                  }
                }
              }))
              {
                this.d.g.setVisibility(0);
                return;
              }
              this.b = true;
              return;
            }
            if (paramMotionEvent.getAction() != 1)
              break;
          }
          while (this.d == null);
          this.d.j = false;
          if (this.b)
            this.c = true;
          while (true)
          {
            z.h(z.this).a((Sticker)this.d.d, null);
            return;
            a(true);
          }
        }
        while (paramMotionEvent.getAction() != 3);
        if (this.d != null)
          this.d.j = false;
        this.c = false;
      }
      while ((this.e != null) || (this.d == null));
      this.d.g.setVisibility(8);
      this.d.a.b(true);
    }

    public void b()
    {
      if (this.e != null)
        this.e.cancel();
      this.b = false;
      this.c = false;
      this.e = null;
      if (this.d == null)
        return;
      this.d.b.setAlpha(1.0F);
      this.d.a.a(null);
      this.d = null;
    }

    public void onAnimationEnd(Animator paramAnimator)
    {
      if (this.d != null)
      {
        this.d.g.setVisibility(8);
        this.d.g.setImageBitmap(null);
      }
      this.e = null;
      z.b(z.this, false);
    }
  }

  private class d extends com.viber.voip.bot.a.c<Sticker>
    implements View.OnTouchListener
  {
    public com.viber.voip.stickers.ui.f a = new com.viber.voip.stickers.ui.f(z.f(z.this), this.b, this.g);
    public ImageView b = (ImageView)this.c.findViewById(R.id.sticker_image);
    public ImageView g = (ImageView)this.c.findViewById(R.id.sticker_frame);
    public View h = this.c.findViewById(R.id.sticker_progress);
    public z.c i;
    public boolean j;

    public d(View arg2)
    {
      super();
      this.c.setOnTouchListener(this);
    }

    public void b()
    {
      this.a.b();
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if (this.i != null)
      {
        if (z.c.a(this.i) == null)
          z.c.a(this.i, this);
        this.i.a(paramMotionEvent);
      }
      return false;
    }
  }

  private class e
    implements Runnable
  {
    List<b<Sticker>> a;
    int b;
    z.a c;

    public e(int parama, z.a arg3)
    {
      this.a = parama;
      int i;
      this.b = i;
      Object localObject;
      this.c = localObject;
    }

    public void run()
    {
      ((e)z.this.c).a(z.d(z.this));
      z.this.b(this.b);
      z.this.a = this.a;
      z.this.notifyDataSetChanged();
      if (this.c != null)
        this.c.a();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.z
 * JD-Core Version:    0.6.2
 */