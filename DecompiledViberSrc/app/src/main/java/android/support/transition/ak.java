package android.support.transition;

import android.view.View;
import android.view.WindowId;

class ak
  implements al
{
  private final WindowId a;

  ak(View paramView)
  {
    this.a = paramView.getWindowId();
  }

  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof ak)) && (((ak)paramObject).a.equals(this.a));
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.transition.ak
 * JD-Core Version:    0.6.2
 */