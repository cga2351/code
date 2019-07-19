package com.facebook.react.views.progressbar;

import android.util.SparseIntArray;
import android.view.View.MeasureSpec;
import android.widget.ProgressBar;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

public class ProgressBarShadowNode extends LayoutShadowNode
  implements YogaMeasureFunction
{
  private final SparseIntArray mHeight = new SparseIntArray();
  private final Set<Integer> mMeasured = new HashSet();
  private String mStyle = "Normal";
  private final SparseIntArray mWidth = new SparseIntArray();

  public ProgressBarShadowNode()
  {
    initMeasureFunction();
  }

  private void initMeasureFunction()
  {
    setMeasureFunction(this);
  }

  @Nullable
  public String getStyle()
  {
    return this.mStyle;
  }

  public long measure(YogaNode paramYogaNode, float paramFloat1, YogaMeasureMode paramYogaMeasureMode1, float paramFloat2, YogaMeasureMode paramYogaMeasureMode2)
  {
    int i = ReactProgressBarViewManager.getStyleFromString(getStyle());
    if (!this.mMeasured.contains(Integer.valueOf(i)))
    {
      ProgressBar localProgressBar = ReactProgressBarViewManager.createProgressBar(getThemedContext(), i);
      int j = View.MeasureSpec.makeMeasureSpec(-2, 0);
      localProgressBar.measure(j, j);
      this.mHeight.put(i, localProgressBar.getMeasuredHeight());
      this.mWidth.put(i, localProgressBar.getMeasuredWidth());
      this.mMeasured.add(Integer.valueOf(i));
    }
    return YogaMeasureOutput.make(this.mWidth.get(i), this.mHeight.get(i));
  }

  @ReactProp(name="styleAttr")
  public void setStyle(@Nullable String paramString)
  {
    if (paramString == null)
      paramString = "Normal";
    this.mStyle = paramString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.progressbar.ProgressBarShadowNode
 * JD-Core Version:    0.6.2
 */