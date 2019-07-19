package com.viber.voip.messages.conversation.adapter.d;

import android.graphics.Rect;
import android.text.Spannable;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.viber.common.d.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.util.e.j;
import com.viber.voip.util.links.e;

@Deprecated
public class v extends GestureDetector.SimpleOnGestureListener
  implements View.OnTouchListener
{
  private static final Logger a = ViberEnv.getLogger();
  private GestureDetector b;
  private n c;
  private a d;
  private b e;
  private c f;
  private View g;
  private aa h;
  private View i;

  private v(View paramView, n paramn)
  {
    this.g = paramView;
    this.c = paramn;
    this.b = new GestureDetector(this.g.getContext(), this);
  }

  private static int a(View paramView1, View paramView2)
  {
    View localView = (View)paramView1.getParent();
    if (localView == paramView2)
      return paramView1.getLeft();
    return paramView1.getLeft() + a(localView, paramView2);
  }

  public static v a(View paramView, n paramn)
  {
    v localv = new v(paramView, paramn);
    paramView.setOnTouchListener(localv);
    return localv;
  }

  private boolean a(int paramInt1, int paramInt2)
  {
    int j = j.a(24.0F);
    int k = a(this.i, this.g);
    int m = b(this.i, this.g);
    Rect localRect = new Rect(k, m, k + this.i.getWidth(), m + this.i.getHeight());
    localRect.left -= j;
    localRect.top -= j;
    localRect.right = (j + localRect.right);
    localRect.bottom = (j + localRect.bottom);
    return localRect.contains(paramInt1, paramInt2);
  }

  private boolean a(MotionEvent paramMotionEvent)
  {
    if ((this.g instanceof TextView))
    {
      TextView localTextView = (TextView)this.g;
      if (((localTextView.getText() instanceof Spannable)) && (e.a(localTextView, (Spannable)localTextView.getText(), paramMotionEvent).length != 0))
        return false;
    }
    return true;
  }

  private static int b(View paramView1, View paramView2)
  {
    View localView = (View)paramView1.getParent();
    if (localView == paramView2)
      return paramView1.getTop();
    return paramView1.getTop() + b(localView, paramView2);
  }

  public v a(a parama)
  {
    this.d = parama;
    return this;
  }

  public v a(b paramb)
  {
    this.e = paramb;
    return this;
  }

  public v a(c paramc)
  {
    this.f = paramc;
    return this;
  }

  public void a(aa paramaa)
  {
    this.h = paramaa;
  }

  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if ((this.h != null) && (this.c != null))
      this.c.h(this.h);
    return true;
  }

  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if (this.e != null)
      this.e.a(this.g);
    this.g.setPressed(true);
    return true;
  }

  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (a.k())
      this.g.performLongClick(paramMotionEvent.getX(), paramMotionEvent.getY());
    while (true)
    {
      super.onLongPress(paramMotionEvent);
      return;
      this.g.performLongClick();
    }
  }

  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((this.h != null) && (this.f != null))
    {
      this.f.a(this.g, paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      return true;
    }
    return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }

  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (!a(paramMotionEvent));
    while ((this.d == null) || ((this.i != null) && (!a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))))
      return false;
    this.d.a(this.g, paramMotionEvent);
    return true;
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getAction();
    if ((3 == j) || (1 == j) || (4 == j))
    {
      this.g.setPressed(false);
      if (this.e != null)
        this.e.b(this.g);
    }
    return this.b.onTouchEvent(paramMotionEvent);
  }

  public static abstract interface a
  {
    public abstract void a(View paramView, MotionEvent paramMotionEvent);
  }

  public static abstract interface b
  {
    public abstract void a(View paramView);

    public abstract void b(View paramView);
  }

  public static abstract interface c
  {
    public abstract void a(View paramView, MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.d.v
 * JD-Core Version:    0.6.2
 */