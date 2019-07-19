package android.support.constraint;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.constraint.a.a.d;
import android.util.AttributeSet;
import android.view.View;

public class Group extends a
{
  public Group(Context paramContext)
  {
    super(paramContext);
  }

  public Group(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public Group(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void a(ConstraintLayout paramConstraintLayout)
  {
    int i = getVisibility();
    if (Build.VERSION.SDK_INT >= 21);
    for (float f = getElevation(); ; f = 0.0F)
    {
      for (int j = 0; j < this.b; j++)
      {
        View localView = paramConstraintLayout.a(this.a[j]);
        if (localView != null)
        {
          localView.setVisibility(i);
          if ((f > 0.0F) && (Build.VERSION.SDK_INT >= 21))
            localView.setElevation(f);
        }
      }
      return;
    }
  }

  protected void a(AttributeSet paramAttributeSet)
  {
    super.a(paramAttributeSet);
    this.e = false;
  }

  public void b(ConstraintLayout paramConstraintLayout)
  {
    ConstraintLayout.a locala = (ConstraintLayout.a)getLayoutParams();
    locala.al.h(0);
    locala.al.i(0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.constraint.Group
 * JD-Core Version:    0.6.2
 */