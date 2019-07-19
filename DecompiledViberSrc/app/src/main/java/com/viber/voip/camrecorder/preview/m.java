package com.viber.voip.camrecorder.preview;

import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import com.viber.voip.R.id;
import com.viber.voip.ui.doodle.a.a.a;
import com.viber.voip.ui.doodle.a.a.a.b;
import com.viber.voip.ui.doodle.extras.ui.TrashArea;
import com.viber.voip.widget.TrashView;

class m
  implements a.b
{
  private final TrashArea a;
  private final TrashView b;
  private RectF c;
  private boolean d;
  private boolean e;
  private Runnable f;

  m(View paramView)
  {
    this.a = ((TrashArea)paramView.findViewById(R.id.trash_area));
    this.b = ((TrashView)paramView.findViewById(R.id.trash_icon));
    this.b.setAnimationEndCallback(new Runnable()
    {
      public void run()
      {
        m.a(m.this, false);
        if (m.a(m.this) != null)
          m.b(m.this);
      }
    });
  }

  private void c()
  {
    this.d = false;
    this.b.setVisibility(4);
    if (this.f != null)
    {
      this.f.run();
      this.f = null;
    }
  }

  void a()
  {
    this.c = null;
  }

  public void a(a parama, boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.e))
    {
      this.e = true;
      this.b.a();
    }
  }

  void a(Runnable paramRunnable)
  {
    this.f = paramRunnable;
    if (!this.e)
      c();
  }

  public boolean a(float paramFloat1, float paramFloat2)
  {
    boolean bool = true;
    if (!this.d)
      return false;
    if (this.c == null)
    {
      int[] arrayOfInt = new int[2];
      this.a.getLocationOnScreen(arrayOfInt);
      this.c = new RectF();
      this.c.set(arrayOfInt[0], arrayOfInt[bool], arrayOfInt[0] + this.a.getWidth(), arrayOfInt[bool] + this.a.getHeight());
    }
    if ((this.c.contains(paramFloat1, paramFloat2)) && (this.a.a(paramFloat1 - this.c.left, paramFloat2 - this.c.top)));
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  void b()
  {
    this.d = true;
    this.b.setVisibility(0);
    this.b.setAlpha(0.0F);
    ViewCompat.animate(this.b).alpha(1.0F).setStartDelay(80L).setDuration(220L).start();
  }

  public void b(a parama, boolean paramBoolean)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camrecorder.preview.m
 * JD-Core Version:    0.6.2
 */