package com.my.target;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import com.my.target.common.a.b;
import java.lang.ref.WeakReference;

public final class cd
{
  private final e a;
  private b b;
  private a c;
  private WeakReference<ar> d;
  private int e;

  private cd(e parame)
  {
    this.a = parame;
    if (parame != null)
    {
      this.c = new a(parame.b());
      this.b = new b((byte)0);
    }
  }

  public static cd a(e parame)
  {
    return new cd(parame);
  }

  public final void a(View paramView)
  {
    if (this.b != null)
      paramView.removeOnLayoutChangeListener(this.b);
    if (this.d != null);
    for (ar localar = (ar)this.d.get(); ; localar = null)
    {
      if (localar != null)
      {
        if (this.a != null)
          be.b(this.a.a(), localar);
        localar.setOnClickListener(null);
        localar.setImageBitmap(null);
        localar.setVisibility(8);
        this.d.clear();
      }
      this.d = null;
      return;
    }
  }

  public final void a(ViewGroup paramViewGroup, ar paramar, int paramInt)
  {
    this.e = paramInt;
    if (this.a != null)
    {
      if (paramar == null)
      {
        localContext = paramViewGroup.getContext();
        paramar = new ar(localContext);
        paramar.setId(bj.a());
        bj.a(paramar, "ad_choices");
        paramar.setFixedHeight(bj.a(20, localContext));
        i = bj.a(2, localContext);
        paramar.setPadding(i, i, i, i);
      }
      this.d = new WeakReference(paramar);
      locale = this.a;
      paramar.setVisibility(0);
      paramar.setOnClickListener(this.c);
      paramViewGroup.addOnLayoutChangeListener(this.b);
      if (paramar.getParent() != null);
    }
    while (paramar == null)
      try
      {
        Context localContext;
        int i;
        e locale;
        paramViewGroup.addView(paramar);
        localb = locale.a();
        Bitmap localBitmap = localb.e();
        if (localb.e() != null)
        {
          paramar.setImageBitmap(localBitmap);
          return;
        }
      }
      catch (Exception localException)
      {
        b localb;
        while (true)
          dp.a("Unable to add AdChoices View: " + localException.getMessage());
        be.a(localb, paramar);
        return;
      }
    paramar.setImageBitmap(null);
    paramar.setVisibility(8);
  }

  private static final class a
    implements View.OnClickListener
  {
    private final String a;

    a(String paramString)
    {
      this.a = paramString;
    }

    public final void onClick(View paramView)
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(this.a));
      Context localContext = paramView.getContext();
      if (!(localContext instanceof Activity))
        localIntent.addFlags(268435456);
      try
      {
        localContext.startActivity(localIntent);
        return;
      }
      catch (Exception localException)
      {
        dp.a("Unable to open AdChoices link: " + localException.getMessage());
      }
    }
  }

  private final class b
    implements View.OnLayoutChangeListener
  {
    private b()
    {
    }

    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      if (cd.a(cd.this) != null);
      for (ar localar = (ar)cd.a(cd.this).get(); localar == null; localar = null)
        return;
      int i = paramView.getMeasuredWidth();
      int j = paramView.getMeasuredHeight();
      int k = localar.getMeasuredWidth();
      int m = localar.getMeasuredHeight();
      int n;
      int i1;
      int i2;
      int i3;
      switch (cd.b(cd.this))
      {
      default:
        n = i - k - paramView.getPaddingLeft();
        i1 = paramView.getPaddingTop();
        i2 = i - paramView.getPaddingRight();
        i3 = m + paramView.getPaddingTop();
      case 1:
      case 3:
      case 2:
      }
      while (true)
      {
        localar.layout(n, i1, i2, i3);
        return;
        n = paramView.getPaddingLeft();
        i1 = paramView.getPaddingTop();
        i2 = k + paramView.getPaddingLeft();
        i3 = m + paramView.getPaddingTop();
        continue;
        n = paramView.getPaddingLeft();
        i1 = j - paramView.getPaddingBottom() - m;
        i2 = k + paramView.getPaddingLeft();
        i3 = j - paramView.getPaddingBottom();
        continue;
        n = i - k - paramView.getPaddingLeft();
        i1 = j - paramView.getPaddingBottom() - m;
        i2 = i - paramView.getPaddingRight();
        i3 = j - paramView.getPaddingBottom();
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.cd
 * JD-Core Version:    0.6.2
 */