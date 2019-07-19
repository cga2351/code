package com.viber.voip.block;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.messages.d.b;
import com.viber.voip.model.entity.m;
import com.viber.voip.util.cd;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;
import com.viber.voip.util.dj;

public class c extends BaseAdapter
{
  private LayoutInflater a;
  private i b;
  private b c;

  c(i parami, b paramb, LayoutInflater paramLayoutInflater)
  {
    this.a = paramLayoutInflater;
    this.b = parami;
    this.c = paramb;
  }

  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    View localView = this.a.inflate(R.layout.fragment_blocked_member_item, paramViewGroup, false);
    localView.setTag(new a(localView));
    return localView;
  }

  public j a(int paramInt)
  {
    return this.b.e(paramInt);
  }

  public void a(int paramInt, View paramView, final j paramj)
  {
    a locala = (a)paramView.getTag();
    View localView = locala.d;
    int i;
    String str;
    if (paramInt == 0)
    {
      i = 0;
      dj.c(localView, i);
      if (!cd.c(paramj.b()))
        break label156;
      if (!paramj.d())
        break label98;
      str = paramj.c();
      label53: locala.a.setText(str);
      locala.b.setVisibility(8);
    }
    while (true)
    {
      locala.c.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (c.a(c.this) != null)
            c.a(c.this).a(paramj);
        }
      });
      return;
      i = 8;
      break;
      label98: m localm = com.viber.voip.messages.d.c.c().c(paramj.a(), 1);
      str = null;
      if (localm != null)
        str = dg.a(localm, 0, 3);
      if (!da.a(str))
        break label53;
      str = paramView.getContext().getResources().getString(R.string.unknown);
      break label53;
      label156: locala.a.setText(paramj.b());
      if (paramj.d())
      {
        locala.b.setVisibility(0);
        locala.b.setText(paramj.c());
      }
      else
      {
        locala.b.setVisibility(8);
      }
    }
  }

  public int getCount()
  {
    return this.b.getCount();
  }

  public long getItemId(int paramInt)
  {
    return this.b.a(paramInt);
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
      paramView = a(paramInt, paramViewGroup);
    a(paramInt, paramView, a(paramInt));
    return paramView;
  }

  public static class a
  {
    public TextView a;
    public TextView b;
    public View c;
    public View d;

    a(View paramView)
    {
      this.a = ((TextView)paramView.findViewById(R.id.number));
      this.b = ((TextView)paramView.findViewById(R.id.name));
      this.c = paramView.findViewById(R.id.unblock);
      this.d = paramView.findViewById(R.id.header);
    }
  }

  public static abstract interface b
  {
    public abstract void a(j paramj);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.block.c
 * JD-Core Version:    0.6.2
 */