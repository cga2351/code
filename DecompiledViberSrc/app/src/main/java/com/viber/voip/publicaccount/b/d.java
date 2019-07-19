package com.viber.voip.publicaccount.b;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.viber.voip.R.layout;
import com.viber.voip.publicaccount.entity.CrmItem;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import java.util.List;

public class d extends RecyclerView.Adapter<c>
  implements c.a
{
  private List<CrmItem> a;
  private b b;
  private e c;
  private f d;
  private LayoutInflater e;

  public d(Context paramContext, List<CrmItem> paramList, b paramb, LayoutInflater paramLayoutInflater)
  {
    this.a = paramList;
    this.b = paramb;
    this.c = e.a(paramContext);
    this.d = f.a();
    this.e = paramLayoutInflater;
  }

  public c a(ViewGroup paramViewGroup, int paramInt)
  {
    return new c(this.e.inflate(R.layout.layout_crm_item, paramViewGroup, false), this, this.c, this.d);
  }

  public void a(int paramInt)
  {
    this.b.a((CrmItem)this.a.get(paramInt));
  }

  public void a(c paramc, int paramInt)
  {
    paramc.a((CrmItem)this.a.get(paramInt));
  }

  public int getItemCount()
  {
    return this.a.size();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.b.d
 * JD-Core Version:    0.6.2
 */