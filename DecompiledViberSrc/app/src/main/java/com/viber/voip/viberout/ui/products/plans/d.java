package com.viber.voip.viberout.ui.products.plans;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;

public class d extends RecyclerView.ItemDecoration
{
  private float a;
  private int b;
  private int c = -2147483648;
  private int d;
  private final TextView e;
  private final boolean f;

  public d(TextView paramTextView, Resources paramResources, boolean paramBoolean)
  {
    this.e = paramTextView;
    this.f = paramBoolean;
    this.b = paramResources.getDimensionPixelOffset(R.dimen.vo_ribbon_bottom);
    this.a = paramResources.getDimensionPixelOffset(R.dimen.vo_ribbon_top);
  }

  private int a(CharSequence paramCharSequence, Resources paramResources)
  {
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setTextSize(16.0F * paramResources.getDisplayMetrics().density);
    return new StaticLayout(paramCharSequence, localTextPaint, (int)localTextPaint.measureText(paramCharSequence.toString()), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getWidth();
  }

  private void a(int paramInt, Resources paramResources)
  {
    int i = a(this.e.getText(), paramResources);
    this.c = (paramInt / 2 - i / 2);
    this.d = (2 * this.c);
  }

  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = paramRecyclerView.getChildCount();
    int j = 0;
    if (j < i)
    {
      View localView1 = paramRecyclerView.getChildAt(j);
      RecyclerView.ViewHolder localViewHolder = paramRecyclerView.getChildViewHolder(localView1);
      View localView2;
      label109: int k;
      if (((localViewHolder instanceof c)) && (((c)localViewHolder).a()))
      {
        if (this.c == -2147483648)
        {
          a(localView1.getWidth() - localView1.getPaddingLeft() - localView1.getPaddingRight(), paramRecyclerView.getResources());
          localView2 = localView1.findViewById(R.id.card);
          if (!this.f)
            break label201;
          this.a = 0.0F;
        }
        k = localView1.getLeft();
        if (!this.f)
          break label219;
      }
      label201: label219: for (float f1 = this.a; ; f1 = localView1.getTop() - this.a)
      {
        this.e.layout(k, (int)this.a, localView1.getRight() - this.d, (int)(this.b + this.a));
        paramCanvas.save();
        paramCanvas.translate(k + this.c, f1);
        this.e.draw(paramCanvas);
        paramCanvas.restore();
        j++;
        break;
        this.a = ((float)(localView2.getPaddingTop() / 1.2D));
        break label109;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.plans.d
 * JD-Core Version:    0.6.2
 */