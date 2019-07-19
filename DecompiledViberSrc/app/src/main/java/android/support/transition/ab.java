package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

class ab
  implements ac
{
  private final ViewOverlay a;

  ab(View paramView)
  {
    this.a = paramView.getOverlay();
  }

  public void a(Drawable paramDrawable)
  {
    this.a.add(paramDrawable);
  }

  public void b(Drawable paramDrawable)
  {
    this.a.remove(paramDrawable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.transition.ab
 * JD-Core Version:    0.6.2
 */