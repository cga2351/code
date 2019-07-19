package com.viber.voip.messages.conversation.adapter;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class a
{
  private final LayoutInflater a;
  private final SparseArray<b> b = new SparseArray();

  public a(LayoutInflater paramLayoutInflater)
  {
    this.a = paramLayoutInflater;
  }

  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    return a(paramInt, paramViewGroup, false);
  }

  public View a(int paramInt, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return b(paramInt).a(paramViewGroup, paramBoolean);
  }

  public void a(int paramInt1, int paramInt2, a parama)
  {
    this.b.append(paramInt1, new b(paramInt1, paramInt2, parama, null));
  }

  public b b(int paramInt)
  {
    return (b)this.b.get(paramInt);
  }

  public static abstract interface a
  {
    public abstract Object a(View paramView, int paramInt, ViewGroup paramViewGroup);
  }

  public class b
  {
    private final int b;
    private final int c;
    private final a.a d;

    private b(int paramInt1, int parama, a.a arg4)
    {
      this.c = parama;
      this.b = paramInt1;
      Object localObject;
      this.d = localObject;
    }

    private View b(ViewGroup paramViewGroup, boolean paramBoolean)
    {
      View localView = a.a(a.this).inflate(this.c, paramViewGroup, paramBoolean);
      if (this.d != null)
        localView.setTag(this.d.a(localView, this.b, paramViewGroup));
      return localView;
    }

    public View a(ViewGroup paramViewGroup)
    {
      return b(paramViewGroup, false);
    }

    public View a(ViewGroup paramViewGroup, boolean paramBoolean)
    {
      return b(paramViewGroup, paramBoolean);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.a
 * JD-Core Version:    0.6.2
 */