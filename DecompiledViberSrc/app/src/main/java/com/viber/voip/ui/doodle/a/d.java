package com.viber.voip.ui.doodle.a;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import com.a.a.a.b.a;
import com.a.a.a.c.a;
import com.viber.voip.ui.doodle.a.a.a.a;
import com.viber.voip.ui.doodle.a.a.a.b;
import com.viber.voip.ui.doodle.commands.movable.TransformationCommand;
import com.viber.voip.ui.doodle.objects.MovableObject;

public class d extends e
  implements ScaleGestureDetector.OnScaleGestureListener, b.a, c.a, a.a
{
  GestureDetector.SimpleOnGestureListener a = new GestureDetector.SimpleOnGestureListener()
  {
    public boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
    {
      d.a(d.this).a(new com.viber.voip.ui.doodle.commands.movable.b());
      return true;
    }

    public boolean onSingleTapConfirmed(MotionEvent paramAnonymousMotionEvent)
    {
      d.a(d.this).a(new com.viber.voip.ui.doodle.commands.movable.a());
      return true;
    }
  };
  private final a b;
  private boolean c;

  public d(Context paramContext, com.viber.voip.ui.doodle.scene.b paramb, a parama, a.b paramb1)
  {
    super(paramb, parama);
    this.b = parama;
    com.viber.voip.ui.doodle.a.a.b[] arrayOfb = new com.viber.voip.ui.doodle.a.a.b[5];
    arrayOfb[0] = new com.viber.voip.ui.doodle.a.a.a(paramb1, this);
    arrayOfb[1] = new com.viber.voip.ui.doodle.a.a.e(paramContext, this);
    arrayOfb[2] = new com.viber.voip.ui.doodle.a.a.c(paramContext, paramb, this);
    arrayOfb[3] = new com.viber.voip.ui.doodle.a.a.d(paramContext, this);
    arrayOfb[4] = new com.viber.voip.ui.doodle.a.a.f(paramContext, this.a);
    a(arrayOfb);
  }

  private void a(TransformationCommand paramTransformationCommand, boolean paramBoolean)
  {
    if ((this.c) && (paramBoolean))
    {
      this.b.a(new com.viber.voip.ui.doodle.commands.movable.c(paramTransformationCommand));
      return;
    }
    this.b.a(paramTransformationCommand);
  }

  public void a(com.viber.voip.ui.doodle.a.a.a parama, boolean paramBoolean)
  {
  }

  boolean a(PointF paramPointF)
  {
    return this.b.a(new com.viber.voip.ui.doodle.commands.movable.d(paramPointF));
  }

  public boolean a(com.a.a.a.b paramb)
  {
    PointF localPointF = paramb.c();
    this.b.a(TransformationCommand.createForTranslation(localPointF.x, localPointF.y, false));
    return true;
  }

  public boolean a(com.a.a.a.c paramc)
  {
    this.b.a(TransformationCommand.createForRotation(-paramc.c(), false));
    return true;
  }

  public void b(com.viber.voip.ui.doodle.a.a.a parama, boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public boolean b(com.a.a.a.b paramb)
  {
    return true;
  }

  public boolean b(com.a.a.a.c paramc)
  {
    return true;
  }

  public void c(com.a.a.a.b paramb)
  {
    if (!a((com.viber.voip.ui.doodle.a.a.b)paramb));
    for (boolean bool = true; ; bool = false)
    {
      PointF localPointF = paramb.c();
      a(TransformationCommand.createForTranslation(localPointF.x, localPointF.y, bool), bool);
      return;
    }
  }

  public void c(com.a.a.a.c paramc)
  {
    if (!a((com.viber.voip.ui.doodle.a.a.b)paramc));
    for (boolean bool = true; ; bool = false)
    {
      a(TransformationCommand.createForRotation(-paramc.c(), bool), bool);
      return;
    }
  }

  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.b.a(TransformationCommand.createForScale(paramScaleGestureDetector.getScaleFactor(), false));
    return true;
  }

  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }

  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (!a((com.viber.voip.ui.doodle.a.a.b)paramScaleGestureDetector));
    for (boolean bool = true; ; bool = false)
    {
      a(TransformationCommand.createForScale(paramScaleGestureDetector.getScaleFactor(), bool), bool);
      return;
    }
  }

  public static abstract interface a extends a<MovableObject>, f, g<MovableObject>
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.a.d
 * JD-Core Version:    0.6.2
 */