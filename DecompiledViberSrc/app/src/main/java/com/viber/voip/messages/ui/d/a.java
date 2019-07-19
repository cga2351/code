package com.viber.voip.messages.ui.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.Editable;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.messages.ui.aj.a;
import com.viber.voip.messages.ui.cv.c;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.j;
import java.util.ArrayList;
import java.util.List;

public class a
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final a c;
  private final Handler d;
  private Runnable e;
  private EditText f;
  private View g;
  private ListView h;
  private b i;
  private ImageButton j;
  private cv.c k;

  public a(Context paramContext, a parama, cv.c paramc)
  {
    this.b = paramContext;
    this.c = parama;
    this.k = paramc;
    this.d = av.e.a.a();
  }

  private void a(int paramInt)
  {
    int m = 5;
    int n = (int)(paramInt / (this.b.getResources().getDisplayMetrics().densityDpi / 160.0F));
    if ((n > 320) && (n <= 360))
      m = 6;
    while (true)
    {
      int i1 = paramInt - this.h.getPaddingLeft() - this.h.getPaddingRight();
      if (this.i != null)
        this.i.notifyDataSetInvalidated();
      this.i = new b(this.b, i1, m);
      this.i.a(new c()
      {
        public void a(aj.a paramAnonymousa)
        {
          if (a.a(a.this) != null)
            a.a(a.this).a(paramAnonymousa);
        }
      });
      this.h.setAdapter(this.i);
      this.i.notifyDataSetChanged();
      this.h.requestLayout();
      return;
      if ((n > 360) && (n <= 400))
        m = 7;
      else if ((n > 400) && (n < 600))
        m = 8;
      else if ((n >= 600) && (n < 720))
        m = 9;
      else if (n >= 720)
        m = 10;
    }
  }

  private void b(EditText paramEditText)
  {
    paramEditText.dispatchKeyEvent(new KeyEvent(0L, 0L, 0, 67, 0));
    paramEditText.dispatchKeyEvent(new KeyEvent(0L, 0L, 1, 67, 0));
  }

  public View a()
  {
    return this.g;
  }

  public void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, int paramInt)
  {
    this.g = paramLayoutInflater.inflate(R.layout.menu_emoticons, paramViewGroup, false);
    this.h = ((ListView)this.g.findViewById(R.id.emoticons_list_view));
    View localView = new View(this.b);
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, j.a(7.0F)));
    this.h.addHeaderView(localView);
    this.j = ((ImageButton)this.g.findViewById(R.id.erase_button));
    this.j.setImageDrawable(this.k.f());
    if (this.f != null)
      a(this.f);
    a(paramInt);
  }

  public void a(final EditText paramEditText)
  {
    this.f = paramEditText;
    if (this.j == null)
      return;
    this.e = new Runnable()
    {
      public void run()
      {
        if (paramEditText.getText().length() > 0)
        {
          a.a(a.this, paramEditText);
          a.c(a.this).postDelayed(a.b(a.this), 50L);
        }
      }
    };
    this.j.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 0)
          a.c(a.this).postDelayed(a.b(a.this), 400L);
        while (true)
        {
          return false;
          if ((paramAnonymousMotionEvent.getAction() == 1) || (paramAnonymousMotionEvent.getAction() == 3))
          {
            a.c(a.this).removeCallbacks(a.b(a.this));
            a.a(a.this, paramEditText);
          }
        }
      }
    });
  }

  public void a(cv.c paramc)
  {
    this.k = paramc;
    if (this.j != null)
      this.j.setImageDrawable(paramc.f());
  }

  public void b()
  {
  }

  public static abstract interface a
  {
    public abstract void a(aj.a parama);
  }

  private static class b extends BaseAdapter
  {
    private final Context a;
    private final int b;
    private int c;
    private int d;
    private final int e;
    private final int f;
    private aj g;
    private final View.OnClickListener h;
    private a.c i;

    b(Context paramContext, float paramFloat, int paramInt)
    {
      this.a = paramContext;
      this.b = paramInt;
      this.c = ((int)(paramFloat / this.b));
      this.e = this.a.getResources().getDimensionPixelSize(R.dimen.emoticon_top_bottom_padding);
      this.f = this.a.getResources().getDimensionPixelSize(R.dimen.emoticon_size_menu);
      this.d = ((this.c - this.f) / 2);
      int j = 2 * this.d / this.b;
      this.c = (j + this.c);
      this.d = (j + this.d);
      this.g = aj.b();
      this.h = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          a.b.a(a.b.this, paramAnonymousView);
        }
      };
    }

    @SuppressLint({"RtlHardcoded"})
    private a a(int paramInt1, int paramInt2)
    {
      ImageView localImageView = new ImageView(this.a);
      localImageView.setLayoutParams(new LinearLayout.LayoutParams(this.f, this.f));
      LinearLayout localLinearLayout = new LinearLayout(this.a);
      if (paramInt1 == 0)
      {
        localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(this.d + this.f, -2));
        localLinearLayout.setGravity(19);
      }
      while (true)
      {
        localLinearLayout.setPadding(0, this.e, 0, this.e);
        localLinearLayout.addView(localImageView);
        a locala = new a(null);
        a.a(locala, localLinearLayout);
        a.a(locala, localImageView);
        return locala;
        if (paramInt1 == paramInt2 - 1)
        {
          localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(this.d + this.f, -2));
          localLinearLayout.setGravity(21);
        }
        else
        {
          localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(this.c, -2));
          localLinearLayout.setGravity(17);
        }
      }
    }

    private void a(View paramView)
    {
      aj.a locala = a.a((a)paramView.getTag());
      if (this.i != null)
        this.i.a(locala);
    }

    private void a(View paramView, int paramInt)
    {
      a locala = (a)paramView.getTag();
      ImageView localImageView = a.c(locala);
      if (this.g.e() > paramInt);
      for (aj.a locala1 = this.g.f()[paramInt]; ; locala1 = null)
      {
        a.a(locala, locala1);
        if (a.a(locala) == null)
          break;
        localImageView.setImageBitmap(this.g.a(a.a(locala)));
        localImageView.setBackgroundResource(dc.a(paramView.getContext(), R.attr.conversationComposeEmoticonBackground));
        paramView.setOnClickListener(this.h);
        return;
      }
      dj.a(localImageView, null);
      localImageView.setImageBitmap(null);
      paramView.setOnClickListener(null);
    }

    public List<aj.a> a(int paramInt)
    {
      ArrayList localArrayList = new ArrayList();
      int j = paramInt * this.b;
      int k = paramInt * this.b + this.b;
      while ((j < k) && (j < this.g.e()))
      {
        localArrayList.add(this.g.f()[j]);
        j++;
      }
      return localArrayList;
    }

    void a(a.c paramc)
    {
      this.i = paramc;
    }

    public int getCount()
    {
      int j = 1;
      int k = this.g.e() / this.b;
      int m;
      if (this.g.e() % this.b > 0)
      {
        m = j;
        if (m == 0)
          break label45;
      }
      while (true)
      {
        return j + k;
        m = 0;
        break;
        label45: j = 0;
      }
    }

    public long getItemId(int paramInt)
    {
      return 0L;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int j = 0;
      if (paramView == null)
      {
        localLinearLayout = new LinearLayout(this.a);
        for (int k = 0; ; k++)
        {
          int m = this.b;
          j = 0;
          if (k >= m)
            break;
          a locala = a(k, this.b);
          a.b(locala).setTag(locala);
          localLinearLayout.addView(a.b(locala));
        }
      }
      LinearLayout localLinearLayout = (LinearLayout)paramView;
      while (j < localLinearLayout.getChildCount())
      {
        a(localLinearLayout.getChildAt(j), j + paramInt * this.b);
        j++;
      }
      return localLinearLayout;
    }

    private static final class a
    {
      private View a;
      private aj.a b;
      private ImageView c;
    }
  }

  static abstract interface c
  {
    public abstract void a(aj.a parama);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.d.a
 * JD-Core Version:    0.6.2
 */