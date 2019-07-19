package android.support.design.transformation;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.design.R.animator;
import android.support.design.a.h;
import android.support.design.a.j;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import java.util.HashMap;
import java.util.Map;

public class FabTransformationSheetBehavior extends FabTransformationBehavior
{
  private Map<View, Integer> importantForAccessibilityMap;

  public FabTransformationSheetBehavior()
  {
  }

  public FabTransformationSheetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void updateImportantForAccessibility(View paramView, boolean paramBoolean)
  {
    ViewParent localViewParent = paramView.getParent();
    if (!(localViewParent instanceof CoordinatorLayout));
    label101: label124: 
    do
    {
      return;
      CoordinatorLayout localCoordinatorLayout = (CoordinatorLayout)localViewParent;
      int i = localCoordinatorLayout.getChildCount();
      if ((Build.VERSION.SDK_INT >= 16) && (paramBoolean))
        this.importantForAccessibilityMap = new HashMap(i);
      int j = 0;
      if (j < i)
      {
        View localView = localCoordinatorLayout.getChildAt(j);
        int k;
        if (((localView.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) && ((((CoordinatorLayout.LayoutParams)localView.getLayoutParams()).getBehavior() instanceof FabTransformationScrimBehavior)))
        {
          k = 1;
          if ((localView != paramView) && (k == 0))
            break label124;
        }
        while (true)
        {
          j++;
          break;
          k = 0;
          break label101;
          if (!paramBoolean)
          {
            if ((this.importantForAccessibilityMap != null) && (this.importantForAccessibilityMap.containsKey(localView)))
              ViewCompat.setImportantForAccessibility(localView, ((Integer)this.importantForAccessibilityMap.get(localView)).intValue());
          }
          else
          {
            if (Build.VERSION.SDK_INT >= 16)
              this.importantForAccessibilityMap.put(localView, Integer.valueOf(localView.getImportantForAccessibility()));
            ViewCompat.setImportantForAccessibility(localView, 4);
          }
        }
      }
    }
    while (paramBoolean);
    this.importantForAccessibilityMap = null;
  }

  protected FabTransformationBehavior.a onCreateMotionSpec(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = R.animator.mtrl_fab_transformation_sheet_expand_spec; ; i = R.animator.mtrl_fab_transformation_sheet_collapse_spec)
    {
      FabTransformationBehavior.a locala = new FabTransformationBehavior.a();
      locala.a = h.a(paramContext, i);
      locala.b = new j(17, 0.0F, 0.0F);
      return locala;
    }
  }

  protected boolean onExpandedStateChange(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2)
  {
    updateImportantForAccessibility(paramView2, paramBoolean1);
    return super.onExpandedStateChange(paramView1, paramView2, paramBoolean1, paramBoolean2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.transformation.FabTransformationSheetBehavior
 * JD-Core Version:    0.6.2
 */