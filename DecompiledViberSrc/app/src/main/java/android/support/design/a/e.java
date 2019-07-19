package android.support.design.a;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Property;
import java.util.WeakHashMap;

public class e extends Property<Drawable, Integer>
{
  public static final Property<Drawable, Integer> a = new e();
  private final WeakHashMap<Drawable, Integer> b = new WeakHashMap();

  private e()
  {
    super(Integer.class, "drawableAlphaCompat");
  }

  public Integer a(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 19)
      return Integer.valueOf(paramDrawable.getAlpha());
    if (this.b.containsKey(paramDrawable))
      return (Integer)this.b.get(paramDrawable);
    return Integer.valueOf(255);
  }

  public void a(Drawable paramDrawable, Integer paramInteger)
  {
    if (Build.VERSION.SDK_INT < 19)
      this.b.put(paramDrawable, paramInteger);
    paramDrawable.setAlpha(paramInteger.intValue());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.a.e
 * JD-Core Version:    0.6.2
 */