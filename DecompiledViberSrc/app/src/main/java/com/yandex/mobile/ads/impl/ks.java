package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public final class ks extends LinearLayout
{
  private final cy a = new cy();
  private kn b;
  private TextView c;
  private final View.OnClickListener d = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      boolean bool;
      TextView localTextView;
      int i;
      if (!ks.a(ks.this).isSelected())
      {
        bool = true;
        ks.a(ks.this).setSelected(bool);
        localTextView = ks.b(ks.this);
        i = 0;
        if (!bool)
          break label53;
      }
      while (true)
      {
        localTextView.setVisibility(i);
        return;
        bool = false;
        break;
        label53: i = 8;
      }
    }
  };

  public ks(Context paramContext)
  {
    super(paramContext);
    setOrientation(0);
    int i = cy.a(paramContext, 4.0F);
    setPadding(i, i, i, i);
    this.b = new kn(paramContext, this.a);
    this.b.setOnClickListener(this.d);
    addView(this.b);
    this.c = new TextView(paramContext);
    int j = cy.a(paramContext, 3.0F);
    this.c.setPadding(j, j, j, j);
    int k = cy.a(paramContext, 2.0F);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(-1);
    localGradientDrawable.setStroke(k, -65536);
    this.c.setBackgroundDrawable(localGradientDrawable);
    addView(this.c);
    int m = cy.a(paramContext, 2.0F);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.c.getLayoutParams();
    localLayoutParams.setMargins(m, 0, m, m);
    this.c.setLayoutParams(localLayoutParams);
    this.c.setVisibility(8);
  }

  public final void setDescription(String paramString)
  {
    this.c.setText(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ks
 * JD-Core Version:    0.6.2
 */