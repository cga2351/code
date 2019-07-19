package com.viber.voip.bot.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.SparseArray;
import com.viber.common.ui.a.a;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.util.ca;
import com.viber.voip.util.dc;

public class e extends b
{
  private final int b = this.a.getDimensionPixelSize(R.dimen.rich_message_cell_size);
  private final int c = this.a.getDimensionPixelSize(R.dimen.rich_message_button_gap_size);
  private final int d = this.a.getDimensionPixelSize(R.dimen.rich_message_group_divider_size);
  private final int e = this.a.getDimensionPixelSize(R.dimen.rich_message_corner_radius);
  private final int f = this.a.getDimensionPixelSize(R.dimen.rich_message_text_padding);
  private final int g = this.a.getDimensionPixelSize(R.dimen.conversations_content_right_padding);
  private SparseArray<Drawable> h = new SparseArray(20);
  private int i;
  private int j;

  public e(Context paramContext)
  {
    super(paramContext);
    this.i = dc.d(paramContext, R.attr.conversationListItemMediaBorderColor);
    this.j = this.a.getDimensionPixelSize(R.dimen.media_message_border_width);
  }

  public Drawable a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = (Drawable)this.h.get(ca.a(new int[] { paramInt1, paramInt2, paramInt3 }));
    if (localObject == null)
    {
      localObject = new ShapeDrawable(new a(g(), paramInt1, this.j));
      ((ShapeDrawable)localObject).getPaint().setColor(this.i);
      if (this.h.size() == 20)
        this.h.removeAt(0);
      this.h.put(paramInt1, localObject);
    }
    return localObject;
  }

  public int c()
  {
    return this.f;
  }

  public int d()
  {
    return this.d;
  }

  public int e()
  {
    return this.b;
  }

  public int f()
  {
    return this.c;
  }

  public int g()
  {
    return this.e;
  }

  public int h()
  {
    return this.g;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.bot.a.e
 * JD-Core Version:    0.6.2
 */