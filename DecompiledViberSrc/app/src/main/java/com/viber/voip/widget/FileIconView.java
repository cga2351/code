package com.viber.voip.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.viber.dexshared.Logger;
import com.viber.svg.jni.TimeAware.Clock;
import com.viber.voip.R.attr;
import com.viber.voip.R.styleable;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.d;
import com.viber.voip.util.dc;

public class FileIconView extends ag
{
  private static final Logger c = ViberEnv.getLogger();
  private final ag.g[] d = new ag.g[d.values().length];
  private final ag.g[] e = new ag.g[d.values().length];
  private final ag.g[] f = new ag.g[d.values().length];
  private boolean g;
  private a h;
  private e i;
  private long j;
  private d k;
  private double l;

  public FileIconView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public FileIconView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public FileIconView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FileIconView);
    int m = localTypedArray.getColor(R.styleable.FileIconView_fileIconColor, dc.d(paramContext, R.attr.conversationFileIconColor));
    localTypedArray.recycle();
    d[] arrayOfd = d.values();
    int n = 0;
    int i1 = arrayOfd.length;
    while (n < i1)
    {
      d locald = arrayOfd[n];
      this.d[n] = new ag.g(locald.k);
      this.e[n] = new ag.g(locald.l);
      this.f[n] = new ag.g(locald.m);
      this.d[n].a(m);
      this.e[n].a(m);
      this.f[n].a(m);
      n++;
    }
    this.h = new a();
    this.i = new e();
  }

  private TimeAware.Clock getClock()
  {
    return this.a[0].b();
  }

  public void a(double paramDouble)
  {
    if (this.g)
    {
      this.h.a(paramDouble);
      return;
    }
    this.i.a(paramDouble);
  }

  public void a(boolean paramBoolean, long paramLong, d paramd)
  {
    if ((paramLong != this.j) || (paramBoolean != this.g));
    for (boolean bool = true; ; bool = false)
    {
      this.j = paramLong;
      this.g = paramBoolean;
      this.k = paramd;
      if (bool)
        this.l = 0.0D;
      if (!this.g)
        break;
      this.h.a(bool);
      return;
    }
    this.i.a(bool);
  }

  public a getDownloadIcon()
  {
    return this.h;
  }

  public e getUploadIcon()
  {
    return this.i;
  }

  public class a extends FileIconView.d<FileIconView.c>
  {
    public a()
    {
      super(null);
    }

    protected ag.g a(FileIconView.c paramc)
    {
      switch (FileIconView.1.b[FileIconView.c.a(paramc).ordinal()])
      {
      default:
        return null;
      case 1:
        return FileIconView.c(FileIconView.this)[FileIconView.d(FileIconView.this).ordinal()];
      case 2:
      }
      return FileIconView.e(FileIconView.this)[FileIconView.d(FileIconView.this).ordinal()];
    }

    public void a()
    {
      switch (FileIconView.1.a[((FileIconView.c)this.b).ordinal()])
      {
      default:
        d(FileIconView.c.b);
        return;
      case 1:
      case 2:
      case 3:
      case 4:
      }
      d(FileIconView.c.g);
    }

    public void a(double paramDouble)
    {
      FileIconView.a(FileIconView.this, paramDouble);
      switch (FileIconView.1.a[((FileIconView.c)this.b).ordinal()])
      {
      case 2:
      case 3:
      default:
        d(FileIconView.c.c);
        ((ag.d)FileIconView.b(FileIconView.this)).b(FileIconView.a(FileIconView.this));
        FileIconView.this.invalidate();
        return;
      case 1:
      case 4:
      case 5:
        d(FileIconView.c.f);
        return;
      case 6:
      case 7:
      case 8:
      }
      d(FileIconView.c.j);
    }

    protected TimeAware.Clock b(FileIconView.c paramc)
    {
      switch (FileIconView.1.a[paramc.ordinal()])
      {
      case 9:
      default:
        return null;
      case 5:
        return new ag.f(0.0D);
      case 2:
        return new ag.d(0.98D, 0.79D);
      case 10:
        return new ag.f(2.67D);
      case 6:
        return new ag.f(1.25D);
      case 1:
        return new ag.c(0.0D, 0.95D);
      case 4:
        return new ag.e(0.0D, 0.95D);
      case 3:
        return new ag.c(1.77D, 0.8999999999999999D);
      case 7:
        return new ag.c(0.5D, 0.75D);
      case 8:
      }
      return new ag.e(0.5D, 0.75D);
    }

    public void b()
    {
      switch (FileIconView.1.a[((FileIconView.c)this.b).ordinal()])
      {
      default:
        d(FileIconView.c.h);
      case 10:
        return;
      case 9:
      }
      d(FileIconView.c.d);
    }

    protected FileIconView.c c(FileIconView.c paramc)
    {
      switch (FileIconView.1.a[paramc.ordinal()])
      {
      case 2:
      case 5:
      case 6:
      default:
        return null;
      case 1:
        return FileIconView.c.c;
      case 4:
        return FileIconView.c.b;
      case 3:
        return FileIconView.c.d;
      case 7:
        return FileIconView.c.e;
      case 8:
      }
      return FileIconView.c.c;
    }

    public void c()
    {
      switch (FileIconView.1.a[((FileIconView.c)this.b).ordinal()])
      {
      case 7:
      case 8:
      default:
        d(FileIconView.c.i);
      case 6:
        return;
      case 9:
      }
      d(FileIconView.c.e);
    }

    protected FileIconView.c d()
    {
      return FileIconView.c.a;
    }
  }

  private static enum b
  {
    static
    {
      b[] arrayOfb = new b[2];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
    }
  }

  private static enum c
  {
    private final FileIconView.b k;

    static
    {
      c[] arrayOfc = new c[10];
      arrayOfc[0] = a;
      arrayOfc[1] = b;
      arrayOfc[2] = c;
      arrayOfc[3] = d;
      arrayOfc[4] = e;
      arrayOfc[5] = f;
      arrayOfc[6] = g;
      arrayOfc[7] = h;
      arrayOfc[8] = i;
      arrayOfc[9] = j;
    }

    private c(FileIconView.b paramb)
    {
      this.k = paramb;
    }
  }

  private abstract class d<STATE>
    implements ag.c.a
  {
    protected STATE b;

    private d()
    {
    }

    protected abstract STATE a(STATE paramSTATE);

    protected void a(boolean paramBoolean)
    {
      if (paramBoolean)
        this.b = e();
    }

    protected abstract ag.g b(STATE paramSTATE);

    protected abstract TimeAware.Clock c(STATE paramSTATE);

    protected void d(STATE paramSTATE)
    {
      if (this.b != paramSTATE)
      {
        FileIconView.this.a[0] = b(paramSTATE);
        TimeAware.Clock localClock = c(paramSTATE);
        if ((localClock instanceof ag.c))
        {
          ag.c localc = (ag.c)localClock;
          localc.b();
          localc.a(this);
        }
        FileIconView.this.a[0].setClock(localClock);
        this.b = paramSTATE;
        FileIconView.this.invalidate();
      }
    }

    protected abstract STATE e();

    public void onAnimationEnd()
    {
      Object localObject = a(this.b);
      if (localObject != null)
      {
        this.b = e();
        d(localObject);
      }
    }
  }

  public class e extends FileIconView.d<FileIconView.g>
  {
    public e()
    {
      super(null);
    }

    protected ag.g a(FileIconView.g paramg)
    {
      switch (FileIconView.1.d[FileIconView.g.a(paramg).ordinal()])
      {
      default:
        return null;
      case 1:
        return FileIconView.f(FileIconView.this)[FileIconView.d(FileIconView.this).ordinal()];
      case 2:
      }
      return FileIconView.e(FileIconView.this)[FileIconView.d(FileIconView.this).ordinal()];
    }

    public void a()
    {
      switch (FileIconView.1.c[((FileIconView.g)this.b).ordinal()])
      {
      default:
        d(FileIconView.g.c);
        return;
      case 4:
      case 5:
      }
      d(FileIconView.g.e);
    }

    public void a(double paramDouble)
    {
      FileIconView.a(FileIconView.this, paramDouble);
      switch (FileIconView.1.c[((FileIconView.g)this.b).ordinal()])
      {
      default:
        d(FileIconView.g.b);
        ((ag.d)FileIconView.b(FileIconView.this)).b(FileIconView.a(FileIconView.this));
        FileIconView.this.invalidate();
        return;
      case 1:
      case 2:
      case 3:
      }
      d(FileIconView.g.g);
    }

    protected TimeAware.Clock b(FileIconView.g paramg)
    {
      switch (FileIconView.1.c[paramg.ordinal()])
      {
      case 6:
      default:
        return null;
      case 4:
        return new ag.d(0.0D, 0.76D);
      case 7:
        return new ag.f(1.68D);
      case 1:
        return new ag.f(1.25D);
      case 5:
        return new ag.c(1.15D, 0.53D);
      case 2:
        return new ag.c(0.5D, 0.75D);
      case 3:
      }
      return new ag.e(0.5D, 0.75D);
    }

    public void b()
    {
      switch (FileIconView.1.c[((FileIconView.g)this.b).ordinal()])
      {
      default:
        d(FileIconView.g.d);
        return;
      case 2:
      case 3:
      case 4:
      }
      d(FileIconView.g.f);
    }

    protected FileIconView.g c()
    {
      return FileIconView.g.a;
    }

    protected FileIconView.g c(FileIconView.g paramg)
    {
      switch (FileIconView.1.c[paramg.ordinal()])
      {
      case 4:
      default:
        return null;
      case 5:
        return FileIconView.g.c;
      case 2:
        return FileIconView.g.d;
      case 3:
      }
      return FileIconView.g.b;
    }
  }

  private static enum f
  {
    static
    {
      f[] arrayOff = new f[2];
      arrayOff[0] = a;
      arrayOff[1] = b;
    }
  }

  private static enum g
  {
    private final FileIconView.f h;

    static
    {
      g[] arrayOfg = new g[7];
      arrayOfg[0] = a;
      arrayOfg[1] = b;
      arrayOfg[2] = c;
      arrayOfg[3] = d;
      arrayOfg[4] = e;
      arrayOfg[5] = f;
      arrayOfg[6] = g;
    }

    private g(FileIconView.f paramf)
    {
      this.h = paramf;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.FileIconView
 * JD-Core Version:    0.6.2
 */