package com.viber.voip.stickers.ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.viber.voip.bot.item.KeyboardItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class d extends FrameLayout
{
  private a a;
  private int b = 0;
  private int c = 0;
  private Map<View, KeyboardItem> d = new HashMap();

  public d(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    this.a = new e(paramContext, 0);
    a(false, false);
  }

  private int b(View paramView, KeyboardItem paramKeyboardItem)
  {
    int i = (int)this.a.b(paramKeyboardItem);
    int j = (int)this.a.a(paramKeyboardItem);
    int k = (int)this.a.c(paramKeyboardItem);
    int m = (int)this.a.d(paramKeyboardItem);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.width = k;
    localLayoutParams.height = m;
    localLayoutParams.leftMargin = i;
    localLayoutParams.topMargin = j;
    localLayoutParams.gravity = 51;
    return i + k;
  }

  public void a()
  {
    this.d.clear();
  }

  public void a(View paramView, KeyboardItem paramKeyboardItem)
  {
    this.d.put(paramView, paramKeyboardItem);
    b(paramView, paramKeyboardItem);
    paramView.requestLayout();
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    int j;
    if (paramBoolean1)
    {
      i = (int)this.a.h();
      j = (int)this.a.g();
      if (!paramBoolean2)
        break label53;
    }
    label53: for (int k = (int)this.a.g(); ; k = 0)
    {
      setPadding(i, j, 0, k);
      return;
      i = 0;
      break;
    }
  }

  public void addView(View paramView)
  {
    addView(paramView, new FrameLayout.LayoutParams(1, 1));
  }

  public void b()
  {
    this.b = 0;
    Iterator localIterator = this.d.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      this.b = Math.max(this.b, b((View)localEntry.getKey(), (KeyboardItem)localEntry.getValue()));
    }
    this.c = ((getMeasuredWidth() - this.b) / 2);
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = getChildAt(j);
      if (localView.isShown())
      {
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
        localLayoutParams.leftMargin += this.c;
      }
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.a instanceof e))
      b();
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void setMeasure(a parama)
  {
    this.a = parama;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.ui.d
 * JD-Core Version:    0.6.2
 */