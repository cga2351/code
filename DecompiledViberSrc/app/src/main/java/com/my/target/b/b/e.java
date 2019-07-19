package com.my.target.b.b;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.my.target.a.a;
import com.my.target.a.a.a;
import com.my.target.aq;
import com.my.target.b.c.a.h;
import com.my.target.b.d.g;
import com.my.target.b.d.j.a;
import com.my.target.bb;
import com.my.target.bi;
import com.my.target.common.MyTargetActivity;
import com.my.target.i;
import com.my.target.q;

public final class e extends c
{
  private final h b;

  private e(a parama, h paramh)
  {
    super(parama);
    this.b = paramh;
  }

  static e a(a parama, h paramh)
  {
    return new e(parama, paramh);
  }

  private void a(ViewGroup paramViewGroup)
  {
    g localg = g.a(paramViewGroup.getContext());
    localg.a(new a(this));
    localg.a(this.b);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    paramViewGroup.addView(localg.f(), localLayoutParams);
  }

  static void a(i parami, Context paramContext)
  {
    bi.a(parami.y().a("playbackStarted"), paramContext);
  }

  public final void a(aq paramaq, FrameLayout paramFrameLayout)
  {
    super.a(paramaq, paramFrameLayout);
    a(paramFrameLayout);
  }

  public final void a(MyTargetActivity paramMyTargetActivity, Intent paramIntent, FrameLayout paramFrameLayout)
  {
    super.a(paramMyTargetActivity, paramIntent, paramFrameLayout);
    a(paramFrameLayout);
  }

  final void b(Context paramContext)
  {
    bb.a().a(this.b, paramContext);
    a.a locala = this.a.c();
    if (locala != null)
      locala.onClick(this.a);
    g();
  }

  private static final class a
    implements j.a
  {
    private final e a;

    a(e parame)
    {
      this.a = parame;
    }

    public final void a(i parami, Context paramContext)
    {
      e.a(parami, paramContext);
    }

    public final void a(i parami, String paramString, Context paramContext)
    {
      this.a.b(paramContext);
    }

    public final void b()
    {
      this.a.g();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.b.b.e
 * JD-Core Version:    0.6.2
 */