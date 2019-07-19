package com.viber.voip.ui.doodle.a;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.ui.doodle.commands.c.a;
import com.viber.voip.ui.doodle.commands.c.c;
import com.viber.voip.ui.doodle.scene.SceneConfig;
import com.viber.voip.ui.doodle.scene.SceneConfig.CoordinateNormalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class e
  implements View.OnTouchListener
{
  private static final Logger a = ViberEnv.getLogger();
  private final com.viber.voip.ui.doodle.scene.b b;
  private final List<com.viber.voip.ui.doodle.a.a.b> c;
  private final f d;

  e(com.viber.voip.ui.doodle.scene.b paramb, f paramf)
  {
    this.b = paramb;
    this.d = paramf;
    this.c = new ArrayList();
  }

  void a(com.viber.voip.ui.doodle.a.a.b[] paramArrayOfb)
  {
    this.c.clear();
    this.c.addAll(Arrays.asList(paramArrayOfb));
  }

  boolean a(PointF paramPointF)
  {
    return true;
  }

  boolean a(com.viber.voip.ui.doodle.a.a.b paramb)
  {
    int i = this.c.size();
    for (int j = 0; j < i; j++)
    {
      com.viber.voip.ui.doodle.a.a.b localb = (com.viber.voip.ui.doodle.a.a.b)this.c.get(j);
      if ((localb != paramb) && (localb.a()))
        return true;
    }
    return false;
  }

  void b(PointF paramPointF)
  {
  }

  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      SceneConfig.CoordinateNormalizer localCoordinateNormalizer2 = this.b.f().getCoordinateNormalizer();
      if (!a(new PointF(localCoordinateNormalizer2.normalizeXCoordinate(paramMotionEvent.getX()), localCoordinateNormalizer2.normalizeYCoordinate(paramMotionEvent.getY()))))
        return false;
      this.d.a(new c.c());
    }
    int i = this.c.size();
    for (int j = 0; j < i; j++)
      ((com.viber.voip.ui.doodle.a.a.b)this.c.get(j)).a(paramMotionEvent);
    if ((1 == paramMotionEvent.getAction()) || (3 == paramMotionEvent.getAction()))
    {
      SceneConfig.CoordinateNormalizer localCoordinateNormalizer1 = this.b.f().getCoordinateNormalizer();
      b(new PointF(localCoordinateNormalizer1.normalizeXCoordinate(paramMotionEvent.getX()), localCoordinateNormalizer1.normalizeYCoordinate(paramMotionEvent.getY())));
      this.d.a(new c.a());
    }
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.a.e
 * JD-Core Version:    0.6.2
 */