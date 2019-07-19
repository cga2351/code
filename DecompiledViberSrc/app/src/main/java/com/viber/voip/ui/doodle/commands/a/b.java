package com.viber.voip.ui.doodle.commands.a;

import com.viber.voip.ui.doodle.objects.DoodleObject;
import com.viber.voip.ui.doodle.undo.Undo;

public class b
  implements com.viber.voip.ui.doodle.commands.a<DoodleObject>
{
  private final a a;

  private b(a parama)
  {
    this.a = parama;
  }

  public static b a(float paramFloat1, float paramFloat2)
  {
    return new b(new a(paramFloat1, paramFloat2, false));
  }

  public static b b(float paramFloat1, float paramFloat2)
  {
    return new b(new a(paramFloat1, paramFloat2, true));
  }

  public Undo a(DoodleObject paramDoodleObject, com.viber.voip.ui.doodle.scene.a parama)
  {
    return paramDoodleObject.applyDrawingValues(this.a);
  }

  public static class a
  {
    private final float a;
    private final float b;
    private final boolean c;

    public a(float paramFloat1, float paramFloat2, boolean paramBoolean)
    {
      this.a = paramFloat1;
      this.b = paramFloat2;
      this.c = paramBoolean;
    }

    public float a()
    {
      return this.a;
    }

    public float b()
    {
      return this.b;
    }

    public boolean c()
    {
      return this.c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.commands.a.b
 * JD-Core Version:    0.6.2
 */