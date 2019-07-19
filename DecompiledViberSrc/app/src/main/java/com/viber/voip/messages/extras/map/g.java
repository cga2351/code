package com.viber.voip.messages.extras.map;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class g extends FrameLayout
{
  private a a;

  public g(Context paramContext)
  {
    super(paramContext);
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a == null)
      return super.dispatchTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    default:
    case 0:
    case 1:
    }
    while (true)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.a.a();
      continue;
      this.a.b();
    }
  }

  public a getMapTouchCallback()
  {
    return this.a;
  }

  public void setMapTouchCallback(a parama)
  {
    this.a = parama;
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extras.map.g
 * JD-Core Version:    0.6.2
 */