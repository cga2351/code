package com.viber.voip.stickers.ui;

import android.content.Context;
import com.viber.voip.bot.item.KeyboardItem;
import com.viber.voip.bot.item.b;
import com.viber.voip.stickers.p;
import java.util.Iterator;
import java.util.List;

public abstract class a<I extends KeyboardItem>
{
  private a a;
  protected boolean b;
  protected boolean c;
  private int d;

  public a(Context paramContext)
  {
  }

  public a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.c = paramBoolean1;
    this.b = paramBoolean2;
    if (b());
    for (int i = (int)p.e; ; i = (int)p.f)
    {
      this.d = i;
      return;
    }
  }

  public float a(KeyboardItem paramKeyboardItem)
  {
    if (b());
    for (int i = paramKeyboardItem.getPortRowPos(); ; i = paramKeyboardItem.getLandRowPos())
      return i * d().e();
  }

  public float a(b<I> paramb, boolean paramBoolean)
  {
    Iterator localIterator = paramb.a().iterator();
    float f1 = 0.0F;
    float f3;
    if (localIterator.hasNext())
    {
      KeyboardItem localKeyboardItem = (KeyboardItem)localIterator.next();
      f3 = a(localKeyboardItem) + d(localKeyboardItem);
      if (f3 <= f1)
        break label88;
    }
    while (true)
    {
      f1 = f3;
      break;
      float f2 = f1 + g();
      if (paramBoolean)
        f2 += g();
      return f2;
      label88: f3 = f1;
    }
  }

  protected abstract a a();

  public float b(KeyboardItem paramKeyboardItem)
  {
    if (b());
    for (int i = paramKeyboardItem.getPortColPos(); ; i = paramKeyboardItem.getLandColPos())
      return i * d().f();
  }

  public boolean b()
  {
    return this.b;
  }

  public boolean b(int paramInt)
  {
    if (paramInt != this.d)
    {
      this.d = paramInt;
      e();
      return true;
    }
    return false;
  }

  public float c(int paramInt)
  {
    return (paramInt - 1) * d().f() + d().d();
  }

  public float c(KeyboardItem paramKeyboardItem)
  {
    return c(paramKeyboardItem.getColSpan());
  }

  public int c()
  {
    return this.d;
  }

  public float d(int paramInt)
  {
    return (paramInt - 1) * d().e() + d().c();
  }

  public float d(KeyboardItem paramKeyboardItem)
  {
    return d(paramKeyboardItem.getRowSpan());
  }

  public a d()
  {
    if (this.a == null)
      this.a = a();
    return this.a;
  }

  protected void e()
  {
    this.a = null;
  }

  public boolean f()
  {
    return (b()) && (!this.c);
  }

  protected float g()
  {
    return d().a();
  }

  protected float h()
  {
    return d().b();
  }

  public static final class a
  {
    private float a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;

    public float a()
    {
      return this.b;
    }

    public void a(float paramFloat)
    {
      b(paramFloat);
      c(paramFloat);
    }

    public float b()
    {
      return this.e;
    }

    public void b(float paramFloat)
    {
      this.b = paramFloat;
      this.a = ((int)(this.c + this.b));
    }

    public float c()
    {
      return this.c;
    }

    public void c(float paramFloat)
    {
      this.e = paramFloat;
      this.d = (this.f + this.e);
    }

    public float d()
    {
      return this.f;
    }

    public void d(float paramFloat)
    {
      e(paramFloat);
      f(paramFloat);
    }

    public float e()
    {
      return this.a;
    }

    public void e(float paramFloat)
    {
      this.c = paramFloat;
      this.a = (this.c + this.b);
    }

    public float f()
    {
      return this.d;
    }

    public void f(float paramFloat)
    {
      this.f = paramFloat;
      this.d = (this.f + this.e);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.ui.a
 * JD-Core Version:    0.6.2
 */