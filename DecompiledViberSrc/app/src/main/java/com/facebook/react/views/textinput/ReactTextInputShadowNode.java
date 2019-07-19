package com.facebook.react.views.textinput;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.text.ReactBaseTextShadowNode;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.text.TextAttributes;
import com.facebook.react.views.view.MeasureUtil;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import javax.annotation.Nullable;

@TargetApi(23)
@VisibleForTesting
public class ReactTextInputShadowNode extends ReactBaseTextShadowNode
  implements YogaMeasureFunction
{

  @VisibleForTesting
  public static final String PROP_PLACEHOLDER = "placeholder";

  @VisibleForTesting
  public static final String PROP_TEXT = "text";

  @Nullable
  private EditText mDummyEditText;

  @Nullable
  private ReactTextInputLocalData mLocalData;
  private int mMostRecentEventCount = -1;

  @Nullable
  private String mPlaceholder = null;

  @Nullable
  private String mText = null;

  public ReactTextInputShadowNode()
  {
    if (Build.VERSION.SDK_INT < 23);
    for (int i = 0; ; i = 1)
    {
      this.mTextBreakStrategy = i;
      initMeasureFunction();
      return;
    }
  }

  private void initMeasureFunction()
  {
    setMeasureFunction(this);
  }

  @Nullable
  public String getPlaceholder()
  {
    return this.mPlaceholder;
  }

  @Nullable
  public String getText()
  {
    return this.mText;
  }

  public boolean isVirtualAnchor()
  {
    return true;
  }

  public boolean isYogaLeafNode()
  {
    return true;
  }

  public long measure(YogaNode paramYogaNode, float paramFloat1, YogaMeasureMode paramYogaMeasureMode1, float paramFloat2, YogaMeasureMode paramYogaMeasureMode2)
  {
    EditText localEditText = (EditText)Assertions.assertNotNull(this.mDummyEditText);
    if (this.mLocalData != null)
      this.mLocalData.apply(localEditText);
    while (true)
    {
      localEditText.setHint(getPlaceholder());
      localEditText.measure(MeasureUtil.getMeasureSpec(paramFloat1, paramYogaMeasureMode1), MeasureUtil.getMeasureSpec(paramFloat2, paramYogaMeasureMode2));
      return YogaMeasureOutput.make(localEditText.getMeasuredWidth(), localEditText.getMeasuredHeight());
      localEditText.setTextSize(0, this.mTextAttributes.getEffectiveFontSize());
      if (this.mNumberOfLines != -1)
        localEditText.setLines(this.mNumberOfLines);
      if ((Build.VERSION.SDK_INT >= 23) && (localEditText.getBreakStrategy() != this.mTextBreakStrategy))
        localEditText.setBreakStrategy(this.mTextBreakStrategy);
    }
  }

  public void onCollectExtraUpdates(UIViewOperationQueue paramUIViewOperationQueue)
  {
    super.onCollectExtraUpdates(paramUIViewOperationQueue);
    if (this.mMostRecentEventCount != -1)
    {
      ReactTextUpdate localReactTextUpdate = new ReactTextUpdate(spannedFromShadowNode(this, getText()), this.mMostRecentEventCount, this.mContainsImages, getPadding(0), getPadding(1), getPadding(2), getPadding(3), this.mTextAlign, this.mTextBreakStrategy, this.mJustificationMode);
      paramUIViewOperationQueue.enqueueUpdateExtraData(getReactTag(), localReactTextUpdate);
    }
  }

  public void setLocalData(Object paramObject)
  {
    Assertions.assertCondition(paramObject instanceof ReactTextInputLocalData);
    this.mLocalData = ((ReactTextInputLocalData)paramObject);
    dirty();
  }

  @ReactProp(name="mostRecentEventCount")
  public void setMostRecentEventCount(int paramInt)
  {
    this.mMostRecentEventCount = paramInt;
  }

  public void setPadding(int paramInt, float paramFloat)
  {
    super.setPadding(paramInt, paramFloat);
    markUpdated();
  }

  @ReactProp(name="placeholder")
  public void setPlaceholder(@Nullable String paramString)
  {
    this.mPlaceholder = paramString;
    markUpdated();
  }

  @ReactProp(name="text")
  public void setText(@Nullable String paramString)
  {
    this.mText = paramString;
    markUpdated();
  }

  public void setTextBreakStrategy(@Nullable String paramString)
  {
    if (Build.VERSION.SDK_INT < 23)
      return;
    if ((paramString == null) || ("simple".equals(paramString)))
    {
      this.mTextBreakStrategy = 0;
      return;
    }
    if ("highQuality".equals(paramString))
    {
      this.mTextBreakStrategy = 1;
      return;
    }
    if ("balanced".equals(paramString))
    {
      this.mTextBreakStrategy = 2;
      return;
    }
    throw new JSApplicationIllegalArgumentException("Invalid textBreakStrategy: " + paramString);
  }

  public void setThemedContext(ThemedReactContext paramThemedReactContext)
  {
    super.setThemedContext(paramThemedReactContext);
    EditText localEditText = new EditText(getThemedContext());
    setDefaultPadding(4, ViewCompat.getPaddingStart(localEditText));
    setDefaultPadding(1, localEditText.getPaddingTop());
    setDefaultPadding(5, ViewCompat.getPaddingEnd(localEditText));
    setDefaultPadding(3, localEditText.getPaddingBottom());
    this.mDummyEditText = localEditText;
    this.mDummyEditText.setPadding(0, 0, 0, 0);
    this.mDummyEditText.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.textinput.ReactTextInputShadowNode
 * JD-Core Version:    0.6.2
 */