package com.viber.voip.camrecorder.preview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.util.dg;

public class l
  implements Runnable
{
  private PopupWindow a;
  private String[] b;
  private int[] c;
  private a d;
  private int e = -1;
  private b f;
  private ListView g;
  private Handler h = new Handler();
  private boolean i = false;
  private LayoutInflater j;

  public l(Context paramContext, a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, LayoutInflater paramLayoutInflater)
  {
    this.d = parama;
    this.e = paramInt4;
    a(paramContext, paramInt1, paramInt2, paramInt3);
    this.j = paramLayoutInflater;
  }

  private void a(Context paramContext, int paramInt)
  {
    int k = paramContext.getResources().getDimensionPixelSize(R.dimen.bomb_picker_height);
    View localView = this.j.inflate(R.layout.timebomb_duration_popup, null);
    this.g = ((ListView)localView.findViewById(R.id.bomb_picker_area));
    this.f = new b(this.b, this.c, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        l.a(l.this, ((Integer)paramAnonymousView.getTag()).intValue());
        l.a(l.this).notifyDataSetChanged();
        l.c(l.this).postDelayed(new Runnable()
        {
          public void run()
          {
            l.b(l.this).dismiss();
          }
        }
        , 300L);
        if (l.d(l.this) != null)
          l.d(l.this).c(l.e(l.this));
      }
    }
    , this.j);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        l.b(l.this).dismiss();
      }
    });
    Resources localResources = paramContext.getResources();
    int m = Math.min(paramInt - localResources.getDimensionPixelSize(R.dimen.bomb_picker_item_left_right_padding), localResources.getDimensionPixelSize(R.dimen.bomb_picker_popup_max_width));
    this.g.setAdapter(this.f);
    this.g.setLayoutParams(new FrameLayout.LayoutParams(m, k, 17));
    this.g.setSelection(this.f.a());
    this.a = new PopupWindow(localView, -1, -1);
    this.a.setTouchable(true);
    this.a.setOutsideTouchable(true);
    this.a.setFocusable(true);
    this.a.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(paramContext, 17170445)));
    this.a.setOnDismissListener(new PopupWindow.OnDismissListener()
    {
      public void onDismiss()
      {
        l.a(l.this, true);
        l.c(l.this).postDelayed(l.this, 100L);
      }
    });
  }

  private void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    Resources localResources = paramContext.getResources();
    this.b = localResources.getStringArray(paramInt1);
    this.c = localResources.getIntArray(paramInt2);
    String[] arrayOfString1 = localResources.getStringArray(paramInt3);
    for (int k = 0; k < this.b.length; k++)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String[] arrayOfString2 = this.b;
      arrayOfString2[k] = (arrayOfString2[k] + arrayOfString1[k]);
    }
  }

  private void b(View paramView)
  {
    if (!this.a.isShowing())
      this.a.showAtLocation(paramView, 17, 0, 0);
  }

  public void a()
  {
    if ((this.a != null) && (!this.i) && (b()))
      this.a.dismiss();
  }

  public void a(int paramInt)
  {
    this.e = paramInt;
    this.g.setSelection(this.f.a());
  }

  public void a(View paramView)
  {
    if (this.a == null)
    {
      int k = Math.min(paramView.getWidth(), paramView.getHeight());
      a(paramView.getContext(), k);
    }
    if (!this.i)
      b(paramView);
  }

  public boolean b()
  {
    return (this.a != null) && (this.a.isShowing());
  }

  public void run()
  {
    this.i = false;
  }

  public static abstract interface a
  {
    public abstract void c(int paramInt);
  }

  private class b extends BaseAdapter
  {
    private String[] b;
    private int[] c;
    private View.OnClickListener d;
    private LayoutInflater e;

    public b(String[] paramArrayOfInt, int[] paramOnClickListener, View.OnClickListener paramLayoutInflater, LayoutInflater arg5)
    {
      this.b = paramArrayOfInt;
      this.c = paramOnClickListener;
      this.d = paramLayoutInflater;
      Object localObject;
      this.e = localObject;
    }

    private String b(int paramInt)
    {
      int i = l.f(l.this)[paramInt];
      switch (i)
      {
      default:
        return i + "_sec";
      case 0:
      }
      return "no_limit";
    }

    public int a()
    {
      for (int i = 0; i < this.c.length; i++)
        if (this.c[i] == l.e(l.this))
          return i;
      return 0;
    }

    public String a(int paramInt)
    {
      return this.b[paramInt];
    }

    public int getCount()
    {
      return this.b.length;
    }

    public long getItemId(int paramInt)
    {
      return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      if (paramView == null)
      {
        localView = this.e.inflate(R.layout.bomb_time_picker_item, paramViewGroup, false);
        localView.setOnClickListener(this.d);
      }
      while (true)
      {
        int i = this.c[paramInt];
        localView.setTag(Integer.valueOf(i));
        int j = l.e(l.this);
        boolean bool = false;
        if (i == j)
          bool = true;
        localView.setActivated(bool);
        ((TextView)localView).setText(a(paramInt));
        dg.a(localView, b(paramInt));
        return localView;
        localView = paramView;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camrecorder.preview.l
 * JD-Core Version:    0.6.2
 */