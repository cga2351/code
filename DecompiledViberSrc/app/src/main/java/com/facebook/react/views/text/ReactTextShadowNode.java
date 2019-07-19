package com.facebook.react.views.text;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextPaint;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.yoga.YogaConstants;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import javax.annotation.Nullable;

@TargetApi(23)
public class ReactTextShadowNode extends ReactBaseTextShadowNode
{
  private static final TextPaint sTextPaintInstance = new TextPaint(1);

  @Nullable
  private Spannable mPreparedSpannableText;
  private boolean mShouldNotifyOnTextLayout;
  private final YogaMeasureFunction mTextMeasureFunction = new YogaMeasureFunction()
  {
    public long measure(YogaNode paramAnonymousYogaNode, float paramAnonymousFloat1, YogaMeasureMode paramAnonymousYogaMeasureMode1, float paramAnonymousFloat2, YogaMeasureMode paramAnonymousYogaMeasureMode2)
    {
      TextPaint localTextPaint = ReactTextShadowNode.sTextPaintInstance;
      localTextPaint.setTextSize(ReactTextShadowNode.this.mTextAttributes.getEffectiveFontSize());
      Spanned localSpanned = (Spanned)Assertions.assertNotNull(ReactTextShadowNode.this.mPreparedSpannableText, "Spannable element has not been prepared in onBeforeLayout");
      BoringLayout.Metrics localMetrics = BoringLayout.isBoring(localSpanned, localTextPaint);
      float f;
      int i;
      label77: Layout.Alignment localAlignment;
      label124: int j;
      StaticLayout localStaticLayout;
      label192: Object localObject;
      if (localMetrics == null)
      {
        f = Layout.getDesiredWidth(localSpanned, localTextPaint);
        if ((paramAnonymousYogaMeasureMode1 != YogaMeasureMode.UNDEFINED) && (paramAnonymousFloat1 >= 0.0F))
          break label328;
        i = 1;
        localAlignment = Layout.Alignment.ALIGN_NORMAL;
        switch (ReactTextShadowNode.this.getTextAlign())
        {
        default:
          if ((localMetrics == null) && ((i != 0) || ((!YogaConstants.isUndefined(f)) && (f <= paramAnonymousFloat1))))
          {
            j = (int)Math.ceil(f);
            if (Build.VERSION.SDK_INT < 23)
            {
              localStaticLayout = new StaticLayout(localSpanned, localTextPaint, j, localAlignment, 1.0F, 0.0F, ReactTextShadowNode.this.mIncludeFontPadding);
              localObject = localStaticLayout;
            }
          }
          break;
        case 8388611:
        case 8388613:
        case 1:
        }
      }
      while (true)
      {
        if (ReactTextShadowNode.this.mShouldNotifyOnTextLayout)
        {
          WritableArray localWritableArray = FontMetricsUtil.getFontMetrics(localSpanned, (Layout)localObject, ReactTextShadowNode.sTextPaintInstance, ReactTextShadowNode.this.getThemedContext());
          WritableMap localWritableMap = Arguments.createMap();
          localWritableMap.putArray("lines", localWritableArray);
          ((RCTEventEmitter)ReactTextShadowNode.this.getThemedContext().getJSModule(RCTEventEmitter.class)).receiveEvent(ReactTextShadowNode.this.getReactTag(), "topTextLayout", localWritableMap);
        }
        if ((ReactTextShadowNode.this.mNumberOfLines == -1) || (ReactTextShadowNode.this.mNumberOfLines >= ((Layout)localObject).getLineCount()))
          break label589;
        return YogaMeasureOutput.make(((Layout)localObject).getWidth(), ((Layout)localObject).getLineBottom(-1 + ReactTextShadowNode.this.mNumberOfLines));
        f = (0.0F / 0.0F);
        break;
        label328: i = 0;
        break label77;
        localAlignment = Layout.Alignment.ALIGN_NORMAL;
        break label124;
        localAlignment = Layout.Alignment.ALIGN_OPPOSITE;
        break label124;
        localAlignment = Layout.Alignment.ALIGN_CENTER;
        break label124;
        StaticLayout.Builder localBuilder = StaticLayout.Builder.obtain(localSpanned, 0, localSpanned.length(), localTextPaint, j).setAlignment(localAlignment).setLineSpacing(0.0F, 1.0F).setIncludePad(ReactTextShadowNode.this.mIncludeFontPadding).setBreakStrategy(ReactTextShadowNode.this.mTextBreakStrategy).setHyphenationFrequency(1);
        if (Build.VERSION.SDK_INT >= 26)
          localBuilder.setJustificationMode(ReactTextShadowNode.this.mJustificationMode);
        localStaticLayout = localBuilder.build();
        break label192;
        if ((localMetrics != null) && ((i != 0) || (localMetrics.width <= paramAnonymousFloat1)))
          localObject = BoringLayout.make(localSpanned, localTextPaint, localMetrics.width, localAlignment, 1.0F, 0.0F, localMetrics, ReactTextShadowNode.this.mIncludeFontPadding);
        else if (Build.VERSION.SDK_INT < 23)
          localObject = new StaticLayout(localSpanned, localTextPaint, (int)paramAnonymousFloat1, localAlignment, 1.0F, 0.0F, ReactTextShadowNode.this.mIncludeFontPadding);
        else
          localObject = StaticLayout.Builder.obtain(localSpanned, 0, localSpanned.length(), localTextPaint, (int)paramAnonymousFloat1).setAlignment(localAlignment).setLineSpacing(0.0F, 1.0F).setIncludePad(ReactTextShadowNode.this.mIncludeFontPadding).setBreakStrategy(ReactTextShadowNode.this.mTextBreakStrategy).setHyphenationFrequency(1).build();
      }
      label589: return YogaMeasureOutput.make(((Layout)localObject).getWidth(), ((Layout)localObject).getHeight());
    }
  };

  public ReactTextShadowNode()
  {
    initMeasureFunction();
  }

  private int getTextAlign()
  {
    int i = this.mTextAlign;
    if (getLayoutDirection() == YogaDirection.RTL)
    {
      if (i == 8388613)
        return 8388611;
      if (i == 8388611)
        return 8388613;
    }
    return i;
  }

  private void initMeasureFunction()
  {
    if (!isVirtual())
      setMeasureFunction(this.mTextMeasureFunction);
  }

  public boolean isVirtualAnchor()
  {
    return true;
  }

  public void markUpdated()
  {
    super.markUpdated();
    super.dirty();
  }

  public void onBeforeLayout()
  {
    this.mPreparedSpannableText = spannedFromShadowNode(this, null);
    markUpdated();
  }

  public void onCollectExtraUpdates(UIViewOperationQueue paramUIViewOperationQueue)
  {
    super.onCollectExtraUpdates(paramUIViewOperationQueue);
    if (this.mPreparedSpannableText != null)
    {
      ReactTextUpdate localReactTextUpdate = new ReactTextUpdate(this.mPreparedSpannableText, -1, this.mContainsImages, getPadding(4), getPadding(1), getPadding(5), getPadding(3), getTextAlign(), this.mTextBreakStrategy, this.mJustificationMode);
      paramUIViewOperationQueue.enqueueUpdateExtraData(getReactTag(), localReactTextUpdate);
    }
  }

  @ReactProp(name="onTextLayout")
  public void setShouldNotifyOnTextLayout(boolean paramBoolean)
  {
    this.mShouldNotifyOnTextLayout = paramBoolean;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.ReactTextShadowNode
 * JD-Core Version:    0.6.2
 */