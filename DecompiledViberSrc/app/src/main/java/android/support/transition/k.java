package android.support.transition;

import android.view.View;
import android.view.ViewGroup;

public class k
{
  private ViewGroup a;
  private Runnable b;

  static k a(View paramView)
  {
    return (k)paramView.getTag(R.id.transition_current_scene);
  }

  static void a(View paramView, k paramk)
  {
    paramView.setTag(R.id.transition_current_scene, paramk);
  }

  public void a()
  {
    if ((a(this.a) == this) && (this.b != null))
      this.b.run();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.transition.k
 * JD-Core Version:    0.6.2
 */