package com.viber.voip.gallery.selection;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.voip.R.layout;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.k;

public class b extends RecyclerView.Adapter<e>
  implements e.a
{
  private LayoutInflater a;
  private com.viber.voip.gallery.b.a b;
  private k c;
  private f d;
  private a e;

  public b(com.viber.voip.gallery.b.a parama, k paramk, f paramf, a parama1, LayoutInflater paramLayoutInflater)
  {
    this.a = paramLayoutInflater;
    this.b = parama;
    this.c = paramk;
    this.d = paramf;
    this.e = parama1;
  }

  public e a(ViewGroup paramViewGroup, int paramInt)
  {
    return new e(this.a.inflate(R.layout.gallery_album_list_item, paramViewGroup, false), this);
  }

  public void a(int paramInt)
  {
    com.viber.voip.model.entity.a locala = this.b.e(paramInt);
    this.e.a(locala);
  }

  public void a(e parame, int paramInt)
  {
    com.viber.voip.model.entity.a locala = this.b.e(paramInt);
    parame.b.setText(locala.b());
    parame.c.setText(Integer.toString(locala.d()));
    this.c.a(locala.c(), parame.a, this.d);
  }

  public int getItemCount()
  {
    return this.b.getCount();
  }

  static abstract interface a
  {
    public abstract void a(com.viber.voip.model.entity.a parama);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.selection.b
 * JD-Core Version:    0.6.2
 */