package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

class v
  implements w
{
  private final ViewGroupOverlay a;

  v(ViewGroup paramViewGroup)
  {
    this.a = paramViewGroup.getOverlay();
  }

  public void a(Drawable paramDrawable)
  {
    this.a.add(paramDrawable);
  }

  public void a(View paramView)
  {
    this.a.add(paramView);
  }

  public void b(Drawable paramDrawable)
  {
    this.a.remove(paramDrawable);
  }

  public void b(View paramView)
  {
    this.a.remove(paramView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.transition.v
 * JD-Core Version:    0.6.2
 */