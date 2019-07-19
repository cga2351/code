package com.viber.voip.contacts.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.viber.voip.R.dimen;
import com.viber.voip.calls.ui.a;
import com.viber.voip.calls.ui.a.a;
import com.viber.voip.model.Call;
import java.util.List;

public class o extends RecyclerView.Adapter<a.a>
{
  private List<Call> a;
  private a b;
  private LayoutInflater c;

  public o(Context paramContext, List<Call> paramList, LayoutInflater paramLayoutInflater)
  {
    this.a = paramList;
    this.b = new a(paramContext, paramContext.getResources().getDimensionPixelSize(R.dimen.contact_details_item_left), paramContext.getResources().getDimensionPixelSize(R.dimen.contact_details_item_right));
    this.c = paramLayoutInflater;
  }

  public a.a a(ViewGroup paramViewGroup, int paramInt)
  {
    return this.b.a(this.c, paramViewGroup);
  }

  public void a(a.a parama, int paramInt)
  {
    Call localCall = (Call)this.a.get(paramInt);
    this.b.a(parama, localCall, paramInt);
  }

  public int getItemCount()
  {
    return this.a.size();
  }

  public long getItemId(int paramInt)
  {
    return ((Call)this.a.get(paramInt)).getDate();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.adapters.o
 * JD-Core Version:    0.6.2
 */