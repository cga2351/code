package com.viber.voip.ui.doodle.scene;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v4.util.LongSparseArray;
import android.view.View.OnTouchListener;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.ui.doodle.extras.e;
import com.viber.voip.ui.doodle.extras.e.a;
import com.viber.voip.ui.doodle.extras.h;
import com.viber.voip.ui.doodle.extras.i;
import com.viber.voip.ui.doodle.objects.BaseObject;
import com.viber.voip.ui.doodle.objects.BaseObject.b;
import com.viber.voip.ui.doodle.objects.MovableObject;
import com.viber.voip.ui.doodle.undo.RestorePositionUndo;
import com.viber.voip.ui.doodle.undo.Undo;
import java.util.ArrayList;
import java.util.List;

public class a
  implements BaseObject.b, SceneView.a, b
{
  private static final long a = 72L + i.a;
  private static final Logger b = ViberEnv.getLogger();
  private final SceneView c;
  private final com.viber.voip.ui.doodle.objects.c.a d;
  private final List<Long> e;
  private final LongSparseArray<Integer> f;
  private final List<Long> g;
  private final b h;
  private final e i;
  private SceneConfig j = SceneConfig.createDefault();
  private boolean k;
  private int l;

  public a(SceneView paramSceneView, com.viber.voip.ui.doodle.objects.c.a parama, b paramb, e parame, Bundle paramBundle)
  {
    this.c = paramSceneView;
    this.d = parama;
    this.h = paramb;
    this.i = parame;
    this.e = new ArrayList();
    this.f = new LongSparseArray();
    this.g = new ArrayList();
    this.c.setDrawDelegate(this);
    if (paramBundle != null)
      b(paramBundle);
  }

  private void b(Bundle paramBundle)
  {
    int m = 0;
    this.l = paramBundle.getInt("scene_hashcode_extra");
    long[] arrayOfLong1 = paramBundle.getLongArray("scene_ids_extra");
    if (arrayOfLong1 == null)
      return;
    int n = arrayOfLong1.length;
    for (int i1 = 0; i1 < n; i1++)
    {
      BaseObject localBaseObject2 = this.d.a(arrayOfLong1[i1]);
      if (localBaseObject2 != null)
        a(localBaseObject2, i1);
    }
    if (paramBundle.containsKey("scene_editing_ids_extra"))
    {
      long[] arrayOfLong3 = paramBundle.getLongArray("scene_editing_ids_extra");
      int i3 = arrayOfLong3.length;
      for (int i4 = 0; i4 < i3; i4++)
        this.g.add(Long.valueOf(arrayOfLong3[i4]));
    }
    if (paramBundle.containsKey("scene_preparation_keys_extra"))
    {
      long[] arrayOfLong2 = paramBundle.getLongArray("scene_preparation_keys_extra");
      int[] arrayOfInt = paramBundle.getIntArray("scene_preparation_values_extra");
      if ((arrayOfLong2 != null) && (arrayOfInt != null))
      {
        int i2 = arrayOfLong2.length;
        if (m < i2)
        {
          BaseObject localBaseObject1 = this.d.a(arrayOfLong2[m]);
          if ((localBaseObject1 != null) && (!this.g.contains(Long.valueOf(localBaseObject1.getId()))))
            a(localBaseObject1, arrayOfInt[m]);
          while (true)
          {
            m++;
            break;
            this.f.append(arrayOfLong2[m], Integer.valueOf(arrayOfInt[m]));
          }
        }
      }
    }
    b();
  }

  private void c(long paramLong)
  {
  }

  private void h()
  {
    int m = this.e.size();
    int n = 0;
    int i1;
    BaseObject localBaseObject;
    if (m != 0)
    {
      i1 = 0;
      n = 1;
      if (i1 < m)
      {
        long l1 = ((Long)this.e.get(i1)).longValue();
        localBaseObject = this.d.a(l1);
        if (localBaseObject == null)
          break label111;
      }
    }
    label111: for (int i2 = n * 31 + localBaseObject.hashCode(); ; i2 = n)
    {
      i1++;
      n = i2;
      break;
      if (this.l != n)
      {
        if (this.h != null)
          this.h.a(n);
        this.l = n;
      }
      return;
    }
  }

  public int a(long paramLong)
  {
    Integer localInteger = (Integer)this.f.get(paramLong);
    this.f.remove(paramLong);
    int m = this.e.indexOf(Long.valueOf(paramLong));
    if ((m >= 0) || (localInteger != null));
    for (int n = 1; ; n = 0)
    {
      if (n != 0)
      {
        this.e.remove(Long.valueOf(paramLong));
        if (this.h != null)
          this.h.a(paramLong);
        h();
      }
      return m;
    }
  }

  public long a()
  {
    return a + this.e.size() * i.b + this.f.size() * i.b + this.f.size() * i.a + this.g.size() * i.b;
  }

  public BaseObject a(a parama)
  {
    int m = -1 + this.e.size();
    if (m >= 0)
    {
      long l1 = ((Long)this.e.get(m)).longValue();
      BaseObject localBaseObject = this.d.a(l1);
      if (localBaseObject == null);
      while (!parama.a(localBaseObject))
      {
        m--;
        break;
      }
      return localBaseObject;
    }
    return null;
  }

  public void a(long paramLong, int paramInt)
  {
    this.e.remove(Long.valueOf(paramLong));
    this.e.add(paramInt, Long.valueOf(paramLong));
    h();
  }

  public void a(Canvas paramCanvas)
  {
    int m = this.e.size();
    int n = 0;
    if (n < m)
    {
      long l1 = ((Long)this.e.get(n)).longValue();
      BaseObject localBaseObject = this.d.a(l1);
      if (localBaseObject == null)
        c(l1);
      while (true)
      {
        n++;
        break;
        localBaseObject.draw(paramCanvas);
      }
    }
  }

  public void a(Bundle paramBundle)
  {
    int m = 0;
    paramBundle.putInt("scene_hashcode_extra", this.l);
    int n = this.e.size();
    long[] arrayOfLong1 = new long[n];
    for (int i1 = 0; i1 < n; i1++)
      arrayOfLong1[i1] = ((Long)this.e.get(i1)).longValue();
    paramBundle.putLongArray("scene_ids_extra", arrayOfLong1);
    int i2 = this.g.size();
    if (i2 > 0)
    {
      long[] arrayOfLong3 = new long[i2];
      for (int i5 = 0; i5 < i2; i5++)
        arrayOfLong3[i5] = ((Long)this.g.get(i5)).longValue();
      paramBundle.putLongArray("scene_editing_ids_extra", arrayOfLong3);
    }
    int i3 = this.f.size();
    if (i3 > 0)
    {
      long[] arrayOfLong2 = new long[i3];
      int[] arrayOfInt = new int[i3];
      while (m < i3)
      {
        long l1 = this.f.keyAt(m);
        int i4 = ((Integer)this.f.get(l1)).intValue();
        arrayOfLong2[m] = l1;
        arrayOfInt[m] = i4;
        m++;
      }
      paramBundle.putLongArray("scene_preparation_keys_extra", arrayOfLong2);
      paramBundle.putIntArray("scene_preparation_values_extra", arrayOfInt);
    }
  }

  public void a(View.OnTouchListener paramOnTouchListener)
  {
    this.c.setOnTouchListener(paramOnTouchListener);
  }

  public void a(BaseObject paramBaseObject)
  {
    Integer localInteger = (Integer)this.f.get(paramBaseObject.getId());
    if (localInteger == null)
      return;
    this.f.remove(paramBaseObject.getId());
    if ((localInteger.intValue() <= -1) || (localInteger.intValue() >= this.e.size()))
      this.e.add(Long.valueOf(paramBaseObject.getId()));
    while (true)
    {
      h();
      b();
      return;
      this.e.add(localInteger.intValue(), Long.valueOf(paramBaseObject.getId()));
    }
  }

  public void a(BaseObject paramBaseObject, int paramInt)
  {
    this.f.put(paramBaseObject.getId(), Integer.valueOf(paramInt));
    paramBaseObject.setPreparationCallback(this);
  }

  public void a(MovableObject paramMovableObject, int paramInt)
  {
    a(paramMovableObject, paramInt);
    if (this.h != null)
      this.h.a(paramMovableObject);
  }

  public void a(SceneConfig paramSceneConfig)
  {
    this.j = paramSceneConfig;
  }

  public void a(boolean paramBoolean)
  {
    this.c.setInteractionsEnabled(paramBoolean);
  }

  public Undo b(long paramLong)
  {
    int m = this.e.indexOf(Long.valueOf(paramLong));
    if (m == -1 + this.e.size())
      return Undo.None;
    a(paramLong, -1 + this.e.size());
    return new RestorePositionUndo(paramLong, m);
  }

  public void b()
  {
    if (this.k)
      return;
    this.c.invalidate();
  }

  public void b(BaseObject paramBaseObject)
  {
    int m = this.e.indexOf(Long.valueOf(paramBaseObject.getId()));
    if (m < 0);
    e.a locala;
    do
    {
      do
      {
        return;
        this.e.remove(m);
        this.g.add(Long.valueOf(paramBaseObject.getId()));
        this.f.put(paramBaseObject.getId(), Integer.valueOf(m));
      }
      while (this.i == null);
      locala = paramBaseObject.getEditableInfo();
    }
    while (locala == null);
    this.i.a(locala);
  }

  public void c()
  {
    h();
    b();
  }

  public void c(BaseObject paramBaseObject)
  {
    a(paramBaseObject.getId());
    if (this.h != null)
      this.h.b(paramBaseObject.getId());
  }

  public void d()
  {
    h();
  }

  public void d(BaseObject paramBaseObject)
  {
    a(paramBaseObject, -1);
  }

  public void e()
  {
    this.f.clear();
    this.e.clear();
    this.k = true;
  }

  public void e(BaseObject paramBaseObject)
  {
    this.g.remove(Long.valueOf(paramBaseObject.getId()));
    paramBaseObject.setPreparationCallback(this);
  }

  public SceneConfig f()
  {
    return this.j;
  }

  public c g()
  {
    return new c(this.d, this.e);
  }

  public int hashCode()
  {
    return this.l;
  }

  public static abstract interface a
  {
    public abstract boolean a(BaseObject paramBaseObject);
  }

  public static abstract interface b extends h, a.c
  {
    public abstract void a(MovableObject paramMovableObject);

    public abstract void b(long paramLong);
  }

  public static abstract interface c
  {
    public abstract void a(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.scene.a
 * JD-Core Version:    0.6.2
 */