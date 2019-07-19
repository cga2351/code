package com.viber.voip.messages.b.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.viber.voip.R.attr;
import com.viber.voip.R.layout;
import com.viber.voip.messages.conversation.ac;
import com.viber.voip.messages.conversation.ae;
import com.viber.voip.util.dc;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.a;
import com.viber.voip.util.e.f.b;

public class b extends RecyclerView.Adapter<a>
{
  private final LayoutInflater a;
  private final e b;
  private final f c;
  private final a d;
  private ac e;
  private int f;
  private int g;

  public b(Context paramContext, a parama, LayoutInflater paramLayoutInflater)
  {
    this.a = paramLayoutInflater;
    this.b = e.a(paramContext);
    int i = dc.a(paramContext, R.attr.contactDefaultPhotoSmall);
    this.c = new f.a().a(f.b.a).a(Integer.valueOf(i)).b(Integer.valueOf(i)).c();
    this.d = parama;
  }

  public a a(ViewGroup paramViewGroup, int paramInt)
  {
    return new a(this.a.inflate(R.layout.mentions_filter_item_layout, paramViewGroup, false), this.b, this.c, this.d);
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.g = paramInt2;
  }

  public void a(a parama, int paramInt)
  {
    ae localae = this.e.e(paramInt);
    int i = this.f;
    int j = this.g;
    if (paramInt == -1 + getItemCount());
    for (boolean bool = true; ; bool = false)
    {
      parama.a(localae, i, j, bool);
      return;
    }
  }

  public void a(ac paramac)
  {
    this.e = paramac;
  }

  public int getItemCount()
  {
    return this.e.getCount();
  }

  public static abstract interface a
  {
    public abstract void a(ae paramae);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.b.a.b
 * JD-Core Version:    0.6.2
 */