package android.support.v7.widget.helper;

import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v7.recyclerview.R.id;
import android.support.v7.widget.RecyclerView;
import android.view.View;

class ItemTouchUIUtilImpl
  implements ItemTouchUIUtil
{
  static final ItemTouchUIUtil INSTANCE = new ItemTouchUIUtilImpl();

  private static float findMaxElevation(RecyclerView paramRecyclerView, View paramView)
  {
    int i = paramRecyclerView.getChildCount();
    int j = 0;
    float f1 = 0.0F;
    if (j < i)
    {
      View localView = paramRecyclerView.getChildAt(j);
      if (localView == paramView);
      while (true)
      {
        j++;
        break;
        float f2 = ViewCompat.getElevation(localView);
        if (f2 > f1)
          f1 = f2;
      }
    }
    return f1;
  }

  public void clearView(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      Object localObject = paramView.getTag(R.id.item_touch_helper_previous_elevation);
      if ((localObject != null) && ((localObject instanceof Float)))
        ViewCompat.setElevation(paramView, ((Float)localObject).floatValue());
      paramView.setTag(R.id.item_touch_helper_previous_elevation, null);
    }
    paramView.setTranslationX(0.0F);
    paramView.setTranslationY(0.0F);
  }

  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (paramBoolean) && (paramView.getTag(R.id.item_touch_helper_previous_elevation) == null))
    {
      Float localFloat = Float.valueOf(ViewCompat.getElevation(paramView));
      ViewCompat.setElevation(paramView, 1.0F + findMaxElevation(paramRecyclerView, paramView));
      paramView.setTag(R.id.item_touch_helper_previous_elevation, localFloat);
    }
    paramView.setTranslationX(paramFloat1);
    paramView.setTranslationY(paramFloat2);
  }

  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
  }

  public void onSelected(View paramView)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.helper.ItemTouchUIUtilImpl
 * JD-Core Version:    0.6.2
 */