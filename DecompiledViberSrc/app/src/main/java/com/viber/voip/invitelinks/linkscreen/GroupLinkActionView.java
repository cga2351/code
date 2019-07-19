package com.viber.voip.invitelinks.linkscreen;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import com.viber.common.d.c;
import com.viber.voip.R.attr;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.R.styleable;
import com.viber.voip.ui.ViberTextView;
import com.viber.voip.util.co;
import com.viber.voip.util.dc;
import com.viber.voip.util.df;

public class GroupLinkActionView extends ViberTextView
{
  private boolean a = true;
  private a b;

  public GroupLinkActionView(Context paramContext)
  {
    super(paramContext);
  }

  public GroupLinkActionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public GroupLinkActionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.a(paramContext, paramAttributeSet);
    Drawable localDrawable = null;
    TypedArray localTypedArray;
    if (paramAttributeSet != null)
      localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.GroupLinkActionView);
    while (true)
    {
      try
      {
        localDrawable = df.a(localTypedArray.getDrawable(R.styleable.GroupLinkActionView_icon), dc.f(paramContext, R.attr.shareLinkScreenIconDefaultTint), false);
        this.a = localTypedArray.getBoolean(R.styleable.GroupLinkActionView_showBottomLine, true);
        localTypedArray.recycle();
        boolean bool = c.a();
        co.a(this, localDrawable);
        if (bool)
          co.a(this);
        if (this.a)
        {
          if (bool)
          {
            i = 0;
            if (!bool)
              break label157;
            j = getCompoundPaddingRight();
            this.b = new a(i, j, paramContext.getResources().getDimensionPixelSize(R.dimen.share_group_link_screen_action_divider_height), ContextCompat.getColor(paramContext, R.color.dividers));
          }
        }
        else
          return;
      }
      finally
      {
        localTypedArray.recycle();
      }
      int i = getCompoundPaddingLeft();
      continue;
      label157: int j = 0;
    }
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.a) && (this.b != null))
      this.b.a(paramCanvas);
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.a) && (this.b != null))
      this.b.a(paramInt1, paramInt2);
  }

  private static final class a
  {
    private final int a;
    private final int b;
    private final Rect c;
    private final Paint d;

    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = new Rect();
      this.d = new Paint();
      this.d.setColor(paramInt4);
      this.d.setStrokeWidth(paramInt3);
    }

    public void a(int paramInt1, int paramInt2)
    {
      this.c.top = ((int)(paramInt2 - this.d.getStrokeWidth()));
      this.c.bottom = paramInt2;
      this.c.left = this.a;
      this.c.right = (paramInt1 - this.b);
    }

    public void a(Canvas paramCanvas)
    {
      paramCanvas.drawLine(this.c.left, this.c.top, this.c.right, this.c.top, this.d);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.linkscreen.GroupLinkActionView
 * JD-Core Version:    0.6.2
 */