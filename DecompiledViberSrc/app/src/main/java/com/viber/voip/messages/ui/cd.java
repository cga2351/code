package com.viber.voip.messages.ui;

import android.view.View;

public abstract interface cd
{
  public abstract void setPositioningListener(b paramb);

  public static class a
    implements cd.b
  {
    public void a(View paramView)
    {
    }

    public void a(View paramView, int paramInt1, int paramInt2)
    {
    }

    public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
    }

    public void a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
    }

    public void b(View paramView, int paramInt1, int paramInt2)
    {
    }

    public void b(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
    }
  }

  public static abstract interface b
  {
    public abstract void a(View paramView);

    public abstract void a(View paramView, int paramInt1, int paramInt2);

    public abstract void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);

    public abstract void a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4);

    public abstract void b(View paramView, int paramInt1, int paramInt2);

    public abstract void b(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.cd
 * JD-Core Version:    0.6.2
 */