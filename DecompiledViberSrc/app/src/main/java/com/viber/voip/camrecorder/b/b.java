package com.viber.voip.camrecorder.b;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.viber.voip.camera.e.e;
import com.viber.voip.util.dj;

public abstract class b<T extends View>
{
  protected T a;
  protected View b;

  public b(View paramView1, View paramView2)
  {
    this.a = paramView1;
    this.b = paramView2;
    if (this.b != null)
      this.b.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          b.this.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
        }
      });
  }

  public void a()
  {
    dj.c(this.a, 8);
  }

  public void a(int paramInt)
  {
    e.b(this.a, paramInt);
  }

  protected abstract void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4);

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b();
      return;
    }
    a();
  }

  public void b()
  {
    dj.c(this.a, 0);
  }

  public boolean c()
  {
    return this.a.getVisibility() == 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camrecorder.b.b
 * JD-Core Version:    0.6.2
 */