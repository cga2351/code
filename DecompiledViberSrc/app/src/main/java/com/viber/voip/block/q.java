package com.viber.voip.block;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.provider.d;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.util.dj;
import com.viber.voip.util.dx;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;

public class q extends BaseAdapter
{
  private LayoutInflater a;
  private d b;
  private e c;
  private f d;
  private b e;

  public q(Context paramContext, d paramd, b paramb, LayoutInflater paramLayoutInflater)
  {
    this.a = paramLayoutInflater;
    this.b = paramd;
    this.c = e.a(paramContext);
    this.d = f.d();
    this.e = paramb;
  }

  public View a(int paramInt, ViewGroup paramViewGroup, r paramr)
  {
    View localView = this.a.inflate(R.layout.fragment_blocked_data_item, paramViewGroup, false);
    localView.setTag(new a(localView));
    return localView;
  }

  public r a(int paramInt)
  {
    if ((this.b instanceof p))
      return ((p)this.b).e(paramInt);
    if ((this.b instanceof s))
      return ((s)this.b).e(paramInt);
    return null;
  }

  public void a(int paramInt, View paramView, final r paramr)
  {
    a locala = (a)paramView.getTag();
    View localView = locala.d;
    int i;
    if (paramInt == 0)
    {
      i = 0;
      dj.c(localView, i);
      if (paramInt == 0)
      {
        if (paramr.a() != 0)
          break label148;
        locala.e.setText(R.string.block_public_chats_header);
      }
      label52: if (paramr.a() != 0)
        break label170;
      final r.c localc = (r.c)paramr.b();
      this.c.a(dx.g(localc.c), locala.a, this.d);
      locala.b.setText(localc.b);
      locala.c.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          b.a().a(localc.a);
        }
      });
    }
    while (true)
    {
      locala.c.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (q.a(q.this) != null)
            q.a(q.this).a(paramr);
        }
      });
      return;
      i = 8;
      break;
      label148: if (1 != paramr.a())
        break label52;
      locala.e.setText(R.string.block_games_and_apps_header);
      break label52;
      label170: if (1 == paramr.a())
      {
        final r.a locala1 = (r.a)paramr.b();
        this.c.a(dx.a(locala1.a, dj.k(paramView.getContext())), locala.a, this.d);
        locala.b.setText(locala1.b);
        locala.c.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            b.a().b(locala1.a);
          }
        });
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
    r localr = a(paramInt);
    if (paramView == null)
      paramView = a(paramInt, paramViewGroup, localr);
    a(paramInt, paramView, localr);
    return paramView;
  }

  public static class a
  {
    public ImageView a;
    public TextView b;
    public View c;
    public View d;
    public TextView e;

    public a(View paramView)
    {
      this.a = ((ImageView)paramView.findViewById(R.id.icon));
      this.b = ((TextView)paramView.findViewById(R.id.name));
      this.c = paramView.findViewById(R.id.unblock);
      this.d = paramView.findViewById(R.id.header);
      this.e = ((TextView)paramView.findViewById(R.id.header_text));
    }
  }

  public static abstract interface b
  {
    public abstract void a(r paramr);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.block.q
 * JD-Core Version:    0.6.2
 */