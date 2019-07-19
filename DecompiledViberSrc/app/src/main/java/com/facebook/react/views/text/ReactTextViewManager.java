package com.facebook.react.views.text;

import android.text.Spannable;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.yoga.YogaMeasureMode;
import java.util.Map;
import javax.annotation.Nullable;

@ReactModule(name="RCTText")
public class ReactTextViewManager extends ReactTextAnchorViewManager<ReactTextView, ReactTextShadowNode>
{

  @VisibleForTesting
  public static final String REACT_CLASS = "RCTText";

  public ReactTextShadowNode createShadowNodeInstance()
  {
    return new ReactTextShadowNode();
  }

  public ReactTextView createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactTextView(paramThemedReactContext);
  }

  @Nullable
  public Map getExportedCustomDirectEventTypeConstants()
  {
    return MapBuilder.of("topTextLayout", MapBuilder.of("registrationName", "onTextLayout"));
  }

  public String getName()
  {
    return "RCTText";
  }

  public Class<ReactTextShadowNode> getShadowNodeClass()
  {
    return ReactTextShadowNode.class;
  }

  public long measure(ReactContext paramReactContext, ReadableNativeMap paramReadableNativeMap1, ReadableNativeMap paramReadableNativeMap2, float paramFloat1, YogaMeasureMode paramYogaMeasureMode1, float paramFloat2, YogaMeasureMode paramYogaMeasureMode2)
  {
    return TextLayoutManager.measureText(paramReactContext, paramReadableNativeMap1, paramReadableNativeMap2, paramFloat1, paramYogaMeasureMode1, paramFloat2, paramYogaMeasureMode2);
  }

  protected void onAfterUpdateTransaction(ReactTextView paramReactTextView)
  {
    super.onAfterUpdateTransaction(paramReactTextView);
    paramReactTextView.updateView();
  }

  public void updateExtraData(ReactTextView paramReactTextView, Object paramObject)
  {
    ReactTextUpdate localReactTextUpdate = (ReactTextUpdate)paramObject;
    if (localReactTextUpdate.containsImages())
      TextInlineImageSpan.possiblyUpdateInlineImageSpans(localReactTextUpdate.getText(), paramReactTextView);
    paramReactTextView.setText(localReactTextUpdate);
  }

  public Object updateLocalData(ReactTextView paramReactTextView, ReactStylesDiffMap paramReactStylesDiffMap1, ReactStylesDiffMap paramReactStylesDiffMap2)
  {
    ReadableMap localReadableMap = paramReactStylesDiffMap2.getMap("attributedString");
    Spannable localSpannable = TextLayoutManager.getOrCreateSpannableForText(paramReactTextView.getContext(), localReadableMap);
    paramReactTextView.setSpanned(localSpannable);
    TextAttributeProps localTextAttributeProps = new TextAttributeProps(paramReactStylesDiffMap1);
    return new ReactTextUpdate(localSpannable, -1, false, localTextAttributeProps.getStartPadding(), localTextAttributeProps.getTopPadding(), localTextAttributeProps.getEndPadding(), localTextAttributeProps.getBottomPadding(), localTextAttributeProps.getTextAlign(), 1, 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.ReactTextViewManager
 * JD-Core Version:    0.6.2
 */