package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public abstract class a
{
  public b a(b.a parama)
  {
    return null;
  }

  public abstract View a();

  public void a(float paramFloat)
  {
    if (paramFloat != 0.0F)
      throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
  }

  public abstract void a(int paramInt);

  public void a(Configuration paramConfiguration)
  {
  }

  public abstract void a(Drawable paramDrawable);

  public abstract void a(View paramView);

  public abstract void a(CharSequence paramCharSequence);

  public abstract void a(boolean paramBoolean);

  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }

  public boolean a(KeyEvent paramKeyEvent)
  {
    return false;
  }

  public abstract CharSequence b();

  public abstract void b(int paramInt);

  public abstract void b(CharSequence paramCharSequence);

  public abstract void b(boolean paramBoolean);

  public abstract CharSequence c();

  public abstract void c(int paramInt);

  public void c(CharSequence paramCharSequence)
  {
  }

  public abstract void c(boolean paramBoolean);

  public abstract int d();

  public void d(int paramInt)
  {
  }

  public abstract void d(boolean paramBoolean);

  public abstract int e();

  public void e(int paramInt)
  {
  }

  public void e(boolean paramBoolean)
  {
  }

  public abstract void f();

  public void f(boolean paramBoolean)
  {
    if (paramBoolean)
      throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
  }

  public abstract void g();

  public void g(boolean paramBoolean)
  {
  }

  public void h(boolean paramBoolean)
  {
  }

  public abstract boolean h();

  public Context i()
  {
    return null;
  }

  public void i(boolean paramBoolean)
  {
  }

  public int j()
  {
    return 0;
  }

  public boolean k()
  {
    return false;
  }

  public boolean l()
  {
    return false;
  }

  public boolean m()
  {
    return false;
  }

  public boolean n()
  {
    return false;
  }

  void o()
  {
  }

  public static class a extends ViewGroup.MarginLayoutParams
  {
    public int gravity = 0;

    public a(int paramInt)
    {
      this(-2, -1, paramInt);
    }

    public a(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      this.gravity = 8388627;
    }

    public a(int paramInt1, int paramInt2, int paramInt3)
    {
      super(paramInt2);
      this.gravity = paramInt3;
    }

    public a(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionBarLayout);
      this.gravity = localTypedArray.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
      localTypedArray.recycle();
    }

    public a(a parama)
    {
      super();
      this.gravity = parama.gravity;
    }

    public a(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }

  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean);
  }

  @Deprecated
  public static abstract class c
  {
    public abstract Drawable a();

    public abstract CharSequence b();

    public abstract View c();

    public abstract void d();

    public abstract CharSequence e();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.app.a
 * JD-Core Version:    0.6.2
 */