package com.viber.voip.calls.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ui.h.b;
import com.viber.voip.ui.h.f;

public class l extends b<k, a>
{
  public a a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return new a(paramLayoutInflater.inflate(R.layout.group_call_details_header_list_item, paramViewGroup, false));
  }

  public void a(a parama, k paramk, int paramInt)
  {
    parama.a.setText(paramk.a);
  }

  public boolean a(Object paramObject)
  {
    return paramObject instanceof k;
  }

  public static class a extends f<k>
  {
    public TextView a;

    public a(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(R.id.title));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.ui.l
 * JD-Core Version:    0.6.2
 */