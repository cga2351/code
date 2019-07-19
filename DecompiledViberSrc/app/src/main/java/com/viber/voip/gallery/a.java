package com.viber.voip.gallery;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.BaseAdapter;

public abstract class a extends BaseAdapter
{
  protected View.OnTouchListener a = new View.OnTouchListener()
  {
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      if (paramAnonymousMotionEvent.getAction() == 0)
        a.a(a.this, paramAnonymousView.getTag());
      while (true)
      {
        return false;
        a.a(a.this, Integer.valueOf(-1));
      }
    }
  };
  private Object b = Integer.valueOf(-1);

  protected void a(View paramView)
  {
    paramView.setOnTouchListener(this.a);
  }

  protected boolean a(Object paramObject)
  {
    return paramObject.equals(this.b);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.a
 * JD-Core Version:    0.6.2
 */