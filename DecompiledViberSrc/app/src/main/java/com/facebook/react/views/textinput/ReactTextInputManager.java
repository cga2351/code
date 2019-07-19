package com.facebook.react.views.textinput;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.MapBuilder.Builder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.facebook.react.views.scroll.ScrollEvent;
import com.facebook.react.views.scroll.ScrollEventType;
import com.facebook.react.views.text.DefaultStyleValuesUtil;
import com.facebook.react.views.text.ReactFontManager;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.text.TextInlineImageSpan;
import com.facebook.yoga.YogaConstants;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Map;
import javax.annotation.Nullable;

@ReactModule(name="AndroidTextInput")
public class ReactTextInputManager extends BaseViewManager<ReactEditText, LayoutShadowNode>
{
  private static final int BLUR_TEXT_INPUT = 2;
  private static final InputFilter[] EMPTY_FILTERS = new InputFilter[0];
  private static final int FOCUS_TEXT_INPUT = 1;
  private static final int IME_ACTION_ID = 1648;
  private static final int INPUT_TYPE_KEYBOARD_DECIMAL_PAD = 8194;
  private static final int INPUT_TYPE_KEYBOARD_NUMBERED = 12290;
  private static final int INPUT_TYPE_KEYBOARD_NUMBER_PAD = 2;
  private static final String KEYBOARD_TYPE_DECIMAL_PAD = "decimal-pad";
  private static final String KEYBOARD_TYPE_EMAIL_ADDRESS = "email-address";
  private static final int KEYBOARD_TYPE_FLAGS = 12339;
  private static final String KEYBOARD_TYPE_NUMBER_PAD = "number-pad";
  private static final String KEYBOARD_TYPE_NUMERIC = "numeric";
  private static final String KEYBOARD_TYPE_PHONE_PAD = "phone-pad";
  private static final String KEYBOARD_TYPE_VISIBLE_PASSWORD = "visible-password";
  private static final int PASSWORD_VISIBILITY_FLAG = 16;
  protected static final String REACT_CLASS = "AndroidTextInput";
  private static final int[] SPACING_TYPES;
  public static final String TAG = ReactTextInputManager.class.getSimpleName();
  private static final int UNSET = -1;

  static
  {
    SPACING_TYPES = new int[] { 8, 0, 2, 1, 3 };
  }

  private static void checkPasswordType(ReactEditText paramReactEditText)
  {
    if (((0x3002 & paramReactEditText.getStagedInputType()) != 0) && ((0x80 & paramReactEditText.getStagedInputType()) != 0))
      updateStagedInputTypeFlag(paramReactEditText, 128, 16);
  }

  private static int parseNumericFontWeight(String paramString)
  {
    if ((paramString.length() == 3) && (paramString.endsWith("00")) && (paramString.charAt(0) <= '9') && (paramString.charAt(0) >= '1'))
      return 100 * ('￐' + paramString.charAt(0));
    return -1;
  }

  private void setCursorColor(ReactEditText paramReactEditText, @Nullable Integer paramInteger)
  {
    try
    {
      Field localField1 = TextView.class.getDeclaredField("mCursorDrawableRes");
      localField1.setAccessible(true);
      int i = localField1.getInt(paramReactEditText);
      if (i == 0)
        return;
      Drawable localDrawable = ContextCompat.getDrawable(paramReactEditText.getContext(), i);
      if (paramInteger != null)
        localDrawable.setColorFilter(paramInteger.intValue(), PorterDuff.Mode.SRC_IN);
      Drawable[] arrayOfDrawable = { localDrawable, localDrawable };
      Field localField2 = TextView.class.getDeclaredField("mEditor");
      localField2.setAccessible(true);
      Object localObject = localField2.get(paramReactEditText);
      Field localField3 = localObject.getClass().getDeclaredField("mCursorDrawable");
      localField3.setAccessible(true);
      localField3.set(localObject, arrayOfDrawable);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
    }
  }

  private static void updateStagedInputTypeFlag(ReactEditText paramReactEditText, int paramInt1, int paramInt2)
  {
    paramReactEditText.setStagedInputType(paramInt2 | paramReactEditText.getStagedInputType() & (paramInt1 ^ 0xFFFFFFFF));
  }

  protected void addEventEmitters(final ThemedReactContext paramThemedReactContext, final ReactEditText paramReactEditText)
  {
    paramReactEditText.addTextChangedListener(new ReactTextInputTextWatcher(paramThemedReactContext, paramReactEditText));
    paramReactEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        EventDispatcher localEventDispatcher = ((UIManagerModule)paramThemedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
        if (paramAnonymousBoolean)
        {
          localEventDispatcher.dispatchEvent(new ReactTextInputFocusEvent(paramReactEditText.getId()));
          return;
        }
        localEventDispatcher.dispatchEvent(new ReactTextInputBlurEvent(paramReactEditText.getId()));
        localEventDispatcher.dispatchEvent(new ReactTextInputEndEditingEvent(paramReactEditText.getId(), paramReactEditText.getText().toString()));
      }
    });
    paramReactEditText.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        boolean bool1 = true;
        if (((paramAnonymousInt & 0xFF) > 0) || (paramAnonymousInt == 0))
        {
          bool2 = paramReactEditText.getBlurOnSubmit();
          if ((0x20000 & paramReactEditText.getInputType()) != 0)
          {
            bool3 = bool1;
            ((UIManagerModule)paramThemedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactTextInputSubmitEditingEvent(paramReactEditText.getId(), paramReactEditText.getText().toString()));
            if (bool2)
              paramReactEditText.clearFocus();
            if (!bool2)
            {
              bool4 = false;
              if (bool3);
            }
            else
            {
              bool4 = bool1;
            }
            bool1 = bool4;
          }
        }
        while ((paramAnonymousInt != 5) || ((paramAnonymousTextView.focusSearch(2) != null) && (!paramAnonymousTextView.requestFocus(2))))
          while (true)
          {
            boolean bool2;
            boolean bool4;
            return bool1;
            boolean bool3 = false;
          }
        return false;
      }
    });
  }

  public LayoutShadowNode createShadowNodeInstance()
  {
    return new ReactTextInputShadowNode();
  }

  public ReactEditText createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    ReactEditText localReactEditText = new ReactEditText(paramThemedReactContext);
    localReactEditText.setInputType(0xFFFDFFFF & localReactEditText.getInputType());
    localReactEditText.setReturnKeyType("done");
    return localReactEditText;
  }

  @Nullable
  public Map<String, Integer> getCommandsMap()
  {
    return MapBuilder.of("focusTextInput", Integer.valueOf(1), "blurTextInput", Integer.valueOf(2));
  }

  @Nullable
  public Map<String, Object> getExportedCustomBubblingEventTypeConstants()
  {
    return MapBuilder.builder().put("topSubmitEditing", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onSubmitEditing", "captured", "onSubmitEditingCapture"))).put("topEndEditing", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onEndEditing", "captured", "onEndEditingCapture"))).put("topTextInput", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onTextInput", "captured", "onTextInputCapture"))).put("topFocus", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onFocus", "captured", "onFocusCapture"))).put("topBlur", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onBlur", "captured", "onBlurCapture"))).put("topKeyPress", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onKeyPress", "captured", "onKeyPressCapture"))).build();
  }

  @Nullable
  public Map<String, Object> getExportedCustomDirectEventTypeConstants()
  {
    return MapBuilder.builder().put(ScrollEventType.getJSEventName(ScrollEventType.SCROLL), MapBuilder.of("registrationName", "onScroll")).build();
  }

  @Nullable
  public Map getExportedViewConstants()
  {
    return MapBuilder.of("AutoCapitalizationType", MapBuilder.of("none", Integer.valueOf(0), "characters", Integer.valueOf(4096), "words", Integer.valueOf(8192), "sentences", Integer.valueOf(16384)));
  }

  public String getName()
  {
    return "AndroidTextInput";
  }

  public Class<? extends LayoutShadowNode> getShadowNodeClass()
  {
    return ReactTextInputShadowNode.class;
  }

  protected void onAfterUpdateTransaction(ReactEditText paramReactEditText)
  {
    super.onAfterUpdateTransaction(paramReactEditText);
    paramReactEditText.commitStagedInputType();
  }

  public void receiveCommand(ReactEditText paramReactEditText, int paramInt, @Nullable ReadableArray paramReadableArray)
  {
    switch (paramInt)
    {
    default:
      return;
    case 1:
      paramReactEditText.requestFocusFromJS();
      return;
    case 2:
    }
    paramReactEditText.clearFocusFromJS();
  }

  @ReactProp(defaultBoolean=true, name="allowFontScaling")
  public void setAllowFontScaling(ReactEditText paramReactEditText, boolean paramBoolean)
  {
    paramReactEditText.setAllowFontScaling(paramBoolean);
  }

  @ReactProp(name="autoCapitalize")
  public void setAutoCapitalize(ReactEditText paramReactEditText, int paramInt)
  {
    updateStagedInputTypeFlag(paramReactEditText, 28672, paramInt);
  }

  @ReactProp(name="autoCorrect")
  public void setAutoCorrect(ReactEditText paramReactEditText, @Nullable Boolean paramBoolean)
  {
    int i;
    if (paramBoolean != null)
      if (paramBoolean.booleanValue())
        i = 32768;
    while (true)
    {
      updateStagedInputTypeFlag(paramReactEditText, 557056, i);
      return;
      i = 524288;
      continue;
      i = 0;
    }
  }

  @ReactProp(name="blurOnSubmit")
  public void setBlurOnSubmit(ReactEditText paramReactEditText, @Nullable Boolean paramBoolean)
  {
    paramReactEditText.setBlurOnSubmit(paramBoolean);
  }

  @ReactPropGroup(customType="Color", names={"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
  public void setBorderColor(ReactEditText paramReactEditText, int paramInt, Integer paramInteger)
  {
    float f1 = (0.0F / 0.0F);
    float f2;
    if (paramInteger == null)
    {
      f2 = f1;
      if (paramInteger != null)
        break label45;
    }
    while (true)
    {
      paramReactEditText.setBorderColor(SPACING_TYPES[paramInt], f2, f1);
      return;
      f2 = 0xFFFFFF & paramInteger.intValue();
      break;
      label45: f1 = paramInteger.intValue() >>> 24;
    }
  }

  @ReactPropGroup(defaultFloat=(0.0F / 0.0F), names={"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
  public void setBorderRadius(ReactEditText paramReactEditText, int paramInt, float paramFloat)
  {
    if (!YogaConstants.isUndefined(paramFloat))
      paramFloat = PixelUtil.toPixelFromDIP(paramFloat);
    if (paramInt == 0)
    {
      paramReactEditText.setBorderRadius(paramFloat);
      return;
    }
    paramReactEditText.setBorderRadius(paramFloat, paramInt - 1);
  }

  @ReactProp(name="borderStyle")
  public void setBorderStyle(ReactEditText paramReactEditText, @Nullable String paramString)
  {
    paramReactEditText.setBorderStyle(paramString);
  }

  @ReactPropGroup(defaultFloat=(0.0F / 0.0F), names={"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
  public void setBorderWidth(ReactEditText paramReactEditText, int paramInt, float paramFloat)
  {
    if (!YogaConstants.isUndefined(paramFloat))
      paramFloat = PixelUtil.toPixelFromDIP(paramFloat);
    paramReactEditText.setBorderWidth(SPACING_TYPES[paramInt], paramFloat);
  }

  @ReactProp(defaultBoolean=false, name="caretHidden")
  public void setCaretHidden(ReactEditText paramReactEditText, boolean paramBoolean)
  {
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      paramReactEditText.setCursorVisible(bool);
      return;
    }
  }

  @ReactProp(customType="Color", name="color")
  public void setColor(ReactEditText paramReactEditText, @Nullable Integer paramInteger)
  {
    if (paramInteger == null)
    {
      paramReactEditText.setTextColor(DefaultStyleValuesUtil.getDefaultTextColor(paramReactEditText.getContext()));
      return;
    }
    paramReactEditText.setTextColor(paramInteger.intValue());
  }

  @ReactProp(defaultBoolean=false, name="contextMenuHidden")
  public void setContextMenuHidden(ReactEditText paramReactEditText, final boolean paramBoolean)
  {
    paramReactEditText.setOnLongClickListener(new View.OnLongClickListener()
    {
      public boolean onLongClick(View paramAnonymousView)
      {
        return paramBoolean;
      }
    });
  }

  @ReactProp(defaultBoolean=false, name="disableFullscreenUI")
  public void setDisableFullscreenUI(ReactEditText paramReactEditText, boolean paramBoolean)
  {
    paramReactEditText.setDisableFullscreenUI(paramBoolean);
  }

  @ReactProp(defaultBoolean=true, name="editable")
  public void setEditable(ReactEditText paramReactEditText, boolean paramBoolean)
  {
    paramReactEditText.setEnabled(paramBoolean);
  }

  @ReactProp(name="fontFamily")
  public void setFontFamily(ReactEditText paramReactEditText, String paramString)
  {
    Typeface localTypeface = paramReactEditText.getTypeface();
    int i = 0;
    if (localTypeface != null)
      i = paramReactEditText.getTypeface().getStyle();
    paramReactEditText.setTypeface(ReactFontManager.getInstance().getTypeface(paramString, i, paramReactEditText.getContext().getAssets()));
  }

  @ReactProp(defaultFloat=14.0F, name="fontSize")
  public void setFontSize(ReactEditText paramReactEditText, float paramFloat)
  {
    paramReactEditText.setFontSize(paramFloat);
  }

  @ReactProp(name="fontStyle")
  public void setFontStyle(ReactEditText paramReactEditText, @Nullable String paramString)
  {
    int i = -1;
    if ("italic".equals(paramString))
      i = 2;
    while (true)
    {
      Typeface localTypeface = paramReactEditText.getTypeface();
      if (localTypeface == null)
        localTypeface = Typeface.DEFAULT;
      if (i != localTypeface.getStyle())
        paramReactEditText.setTypeface(localTypeface, i);
      return;
      if ("normal".equals(paramString))
        i = 0;
    }
  }

  @ReactProp(name="fontWeight")
  public void setFontWeight(ReactEditText paramReactEditText, @Nullable String paramString)
  {
    int i = -1;
    int j;
    if (paramString != null)
    {
      j = parseNumericFontWeight(paramString);
      if ((j < 500) && (!"bold".equals(paramString)))
        break label71;
    }
    for (i = 1; ; i = 0)
      label71: 
      do
      {
        Typeface localTypeface = paramReactEditText.getTypeface();
        if (localTypeface == null)
          localTypeface = Typeface.DEFAULT;
        if (i != localTypeface.getStyle())
          paramReactEditText.setTypeface(localTypeface, i);
        return;
        j = i;
        break;
      }
      while ((!"normal".equals(paramString)) && ((j == i) || (j >= 500)));
  }

  @ReactProp(name="importantForAutofill")
  public void setImportantForAutofill(ReactEditText paramReactEditText, @Nullable String paramString)
  {
    if (Build.VERSION.SDK_INT < 26)
      return;
    int i;
    if ("no".equals(paramString))
      i = 2;
    while (true)
    {
      paramReactEditText.setImportantForAutofill(i);
      return;
      if ("noExcludeDescendants".equals(paramString))
      {
        i = 8;
      }
      else if ("yes".equals(paramString))
      {
        i = 1;
      }
      else
      {
        boolean bool = "yesExcludeDescendants".equals(paramString);
        i = 0;
        if (bool)
          i = 4;
      }
    }
  }

  @ReactProp(name="inlineImageLeft")
  public void setInlineImageLeft(ReactEditText paramReactEditText, @Nullable String paramString)
  {
    paramReactEditText.setCompoundDrawablesWithIntrinsicBounds(ResourceDrawableIdHelper.getInstance().getResourceDrawableId(paramReactEditText.getContext(), paramString), 0, 0, 0);
  }

  @ReactProp(name="inlineImagePadding")
  public void setInlineImagePadding(ReactEditText paramReactEditText, int paramInt)
  {
    paramReactEditText.setCompoundDrawablePadding(paramInt);
  }

  @ReactProp(name="keyboardType")
  public void setKeyboardType(ReactEditText paramReactEditText, @Nullable String paramString)
  {
    int i = 1;
    if ("numeric".equalsIgnoreCase(paramString))
      i = 12290;
    while (true)
    {
      updateStagedInputTypeFlag(paramReactEditText, 12339, i);
      checkPasswordType(paramReactEditText);
      return;
      if ("number-pad".equalsIgnoreCase(paramString))
        i = 2;
      else if ("decimal-pad".equalsIgnoreCase(paramString))
        i = 8194;
      else if ("email-address".equalsIgnoreCase(paramString))
        i = 33;
      else if ("phone-pad".equalsIgnoreCase(paramString))
        i = 3;
      else if ("visible-password".equalsIgnoreCase(paramString))
        i = 144;
    }
  }

  @ReactProp(defaultFloat=0.0F, name="letterSpacing")
  public void setLetterSpacing(ReactEditText paramReactEditText, float paramFloat)
  {
    paramReactEditText.setLetterSpacingPt(paramFloat);
  }

  @ReactProp(defaultFloat=(0.0F / 0.0F), name="maxFontSizeMultiplier")
  public void setMaxFontSizeMultiplier(ReactEditText paramReactEditText, float paramFloat)
  {
    paramReactEditText.setMaxFontSizeMultiplier(paramFloat);
  }

  @ReactProp(name="maxLength")
  public void setMaxLength(ReactEditText paramReactEditText, @Nullable Integer paramInteger)
  {
    int i = 0;
    InputFilter[] arrayOfInputFilter1 = paramReactEditText.getFilters();
    InputFilter[] arrayOfInputFilter2 = EMPTY_FILTERS;
    InputFilter[] arrayOfInputFilter3;
    if (paramInteger == null)
    {
      if (arrayOfInputFilter1.length <= 0)
        break label201;
      LinkedList localLinkedList = new LinkedList();
      while (i < arrayOfInputFilter1.length)
      {
        if (!(arrayOfInputFilter1[i] instanceof InputFilter.LengthFilter))
          localLinkedList.add(arrayOfInputFilter1[i]);
        i++;
      }
      if (localLinkedList.isEmpty())
        break label201;
      arrayOfInputFilter3 = (InputFilter[])localLinkedList.toArray(new InputFilter[localLinkedList.size()]);
    }
    while (true)
    {
      paramReactEditText.setFilters(arrayOfInputFilter3);
      return;
      if (arrayOfInputFilter1.length > 0)
      {
        int j = 0;
        int k = 0;
        while (j < arrayOfInputFilter1.length)
        {
          if ((arrayOfInputFilter1[j] instanceof InputFilter.LengthFilter))
          {
            arrayOfInputFilter1[j] = new InputFilter.LengthFilter(paramInteger.intValue());
            k = 1;
          }
          j++;
        }
        if (k == 0)
        {
          arrayOfInputFilter2 = new InputFilter[1 + arrayOfInputFilter1.length];
          System.arraycopy(arrayOfInputFilter1, 0, arrayOfInputFilter2, 0, arrayOfInputFilter1.length);
          arrayOfInputFilter1[arrayOfInputFilter1.length] = new InputFilter.LengthFilter(paramInteger.intValue());
        }
      }
      else
      {
        while (true)
        {
          label201: arrayOfInputFilter3 = arrayOfInputFilter2;
          break;
          arrayOfInputFilter2 = new InputFilter[1];
          arrayOfInputFilter2[0] = new InputFilter.LengthFilter(paramInteger.intValue());
        }
      }
      arrayOfInputFilter3 = arrayOfInputFilter1;
    }
  }

  @ReactProp(defaultBoolean=false, name="multiline")
  public void setMultiline(ReactEditText paramReactEditText, boolean paramBoolean)
  {
    int i = 131072;
    int j;
    if (paramBoolean)
    {
      j = 0;
      if (!paramBoolean)
        break label29;
    }
    while (true)
    {
      updateStagedInputTypeFlag(paramReactEditText, j, i);
      return;
      j = i;
      break;
      label29: i = 0;
    }
  }

  @ReactProp(defaultInt=1, name="numberOfLines")
  public void setNumLines(ReactEditText paramReactEditText, int paramInt)
  {
    paramReactEditText.setLines(paramInt);
  }

  @ReactProp(defaultBoolean=false, name="onContentSizeChange")
  public void setOnContentSizeChange(ReactEditText paramReactEditText, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramReactEditText.setContentSizeWatcher(new ReactContentSizeWatcher(paramReactEditText));
      return;
    }
    paramReactEditText.setContentSizeWatcher(null);
  }

  @ReactProp(defaultBoolean=false, name="onKeyPress")
  public void setOnKeyPress(ReactEditText paramReactEditText, boolean paramBoolean)
  {
    paramReactEditText.setOnKeyPress(paramBoolean);
  }

  @ReactProp(defaultBoolean=false, name="onScroll")
  public void setOnScroll(ReactEditText paramReactEditText, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramReactEditText.setScrollWatcher(new ReactScrollWatcher(paramReactEditText));
      return;
    }
    paramReactEditText.setScrollWatcher(null);
  }

  @ReactProp(defaultBoolean=false, name="onSelectionChange")
  public void setOnSelectionChange(ReactEditText paramReactEditText, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramReactEditText.setSelectionWatcher(new ReactSelectionWatcher(paramReactEditText));
      return;
    }
    paramReactEditText.setSelectionWatcher(null);
  }

  @ReactProp(name="placeholder")
  public void setPlaceholder(ReactEditText paramReactEditText, @Nullable String paramString)
  {
    paramReactEditText.setHint(paramString);
  }

  @ReactProp(customType="Color", name="placeholderTextColor")
  public void setPlaceholderTextColor(ReactEditText paramReactEditText, @Nullable Integer paramInteger)
  {
    if (paramInteger == null)
    {
      paramReactEditText.setHintTextColor(DefaultStyleValuesUtil.getDefaultTextColorHint(paramReactEditText.getContext()));
      return;
    }
    paramReactEditText.setHintTextColor(paramInteger.intValue());
  }

  @ReactProp(name="returnKeyLabel")
  public void setReturnKeyLabel(ReactEditText paramReactEditText, String paramString)
  {
    paramReactEditText.setImeActionLabel(paramString, 1648);
  }

  @ReactProp(name="returnKeyType")
  public void setReturnKeyType(ReactEditText paramReactEditText, String paramString)
  {
    paramReactEditText.setReturnKeyType(paramString);
  }

  @ReactProp(defaultBoolean=false, name="secureTextEntry")
  public void setSecureTextEntry(ReactEditText paramReactEditText, boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 0; ; i = 144)
    {
      int j = 0;
      if (paramBoolean)
        j = 128;
      updateStagedInputTypeFlag(paramReactEditText, i, j);
      checkPasswordType(paramReactEditText);
      return;
    }
  }

  @ReactProp(defaultBoolean=false, name="selectTextOnFocus")
  public void setSelectTextOnFocus(ReactEditText paramReactEditText, boolean paramBoolean)
  {
    paramReactEditText.setSelectAllOnFocus(paramBoolean);
  }

  @ReactProp(name="selection")
  public void setSelection(ReactEditText paramReactEditText, @Nullable ReadableMap paramReadableMap)
  {
    if (paramReadableMap == null);
    while ((!paramReadableMap.hasKey("start")) || (!paramReadableMap.hasKey("end")))
      return;
    paramReactEditText.setSelection(paramReadableMap.getInt("start"), paramReadableMap.getInt("end"));
  }

  @ReactProp(customType="Color", name="selectionColor")
  public void setSelectionColor(ReactEditText paramReactEditText, @Nullable Integer paramInteger)
  {
    if (paramInteger == null)
      paramReactEditText.setHighlightColor(DefaultStyleValuesUtil.getDefaultTextColorHighlight(paramReactEditText.getContext()));
    while (true)
    {
      setCursorColor(paramReactEditText, paramInteger);
      return;
      paramReactEditText.setHighlightColor(paramInteger.intValue());
    }
  }

  @ReactProp(name="textAlign")
  public void setTextAlign(ReactEditText paramReactEditText, @Nullable String paramString)
  {
    if ("justify".equals(paramString))
    {
      if (Build.VERSION.SDK_INT >= 26)
        paramReactEditText.setJustificationMode(1);
      paramReactEditText.setGravityHorizontal(8388611);
      return;
    }
    if (Build.VERSION.SDK_INT >= 26)
      paramReactEditText.setJustificationMode(0);
    if ((paramString == null) || ("auto".equals(paramString)))
    {
      paramReactEditText.setGravityHorizontal(0);
      return;
    }
    if ("left".equals(paramString))
    {
      paramReactEditText.setGravityHorizontal(8388611);
      return;
    }
    if ("right".equals(paramString))
    {
      paramReactEditText.setGravityHorizontal(8388613);
      return;
    }
    if ("center".equals(paramString))
    {
      paramReactEditText.setGravityHorizontal(1);
      return;
    }
    throw new JSApplicationIllegalArgumentException("Invalid textAlign: " + paramString);
  }

  @ReactProp(name="textAlignVertical")
  public void setTextAlignVertical(ReactEditText paramReactEditText, @Nullable String paramString)
  {
    if ((paramString == null) || ("auto".equals(paramString)))
    {
      paramReactEditText.setGravityVertical(0);
      return;
    }
    if ("top".equals(paramString))
    {
      paramReactEditText.setGravityVertical(48);
      return;
    }
    if ("bottom".equals(paramString))
    {
      paramReactEditText.setGravityVertical(80);
      return;
    }
    if ("center".equals(paramString))
    {
      paramReactEditText.setGravityVertical(16);
      return;
    }
    throw new JSApplicationIllegalArgumentException("Invalid textAlignVertical: " + paramString);
  }

  @ReactProp(name="autoComplete")
  public void setTextContentType(ReactEditText paramReactEditText, @Nullable String paramString)
  {
    if (Build.VERSION.SDK_INT < 26)
      return;
    if (paramString == null)
    {
      paramReactEditText.setImportantForAutofill(2);
      return;
    }
    if ("username".equals(paramString))
    {
      paramReactEditText.setAutofillHints(new String[] { "username" });
      return;
    }
    if ("password".equals(paramString))
    {
      paramReactEditText.setAutofillHints(new String[] { "password" });
      return;
    }
    if ("email".equals(paramString))
    {
      paramReactEditText.setAutofillHints(new String[] { "emailAddress" });
      return;
    }
    if ("name".equals(paramString))
    {
      paramReactEditText.setAutofillHints(new String[] { "name" });
      return;
    }
    if ("tel".equals(paramString))
    {
      paramReactEditText.setAutofillHints(new String[] { "phone" });
      return;
    }
    if ("street-address".equals(paramString))
    {
      paramReactEditText.setAutofillHints(new String[] { "postalAddress" });
      return;
    }
    if ("postal-code".equals(paramString))
    {
      paramReactEditText.setAutofillHints(new String[] { "postalCode" });
      return;
    }
    if ("cc-number".equals(paramString))
    {
      paramReactEditText.setAutofillHints(new String[] { "creditCardNumber" });
      return;
    }
    if ("cc-csc".equals(paramString))
    {
      paramReactEditText.setAutofillHints(new String[] { "creditCardSecurityCode" });
      return;
    }
    if ("cc-exp".equals(paramString))
    {
      paramReactEditText.setAutofillHints(new String[] { "creditCardExpirationDate" });
      return;
    }
    if ("cc-exp-month".equals(paramString))
    {
      paramReactEditText.setAutofillHints(new String[] { "creditCardExpirationMonth" });
      return;
    }
    if ("cc-exp-year".equals(paramString))
    {
      paramReactEditText.setAutofillHints(new String[] { "creditCardExpirationYear" });
      return;
    }
    if ("off".equals(paramString))
    {
      paramReactEditText.setImportantForAutofill(2);
      return;
    }
    throw new JSApplicationIllegalArgumentException("Invalid autocomplete option: " + paramString);
  }

  @ReactProp(customType="Color", name="underlineColorAndroid")
  public void setUnderlineColor(ReactEditText paramReactEditText, @Nullable Integer paramInteger)
  {
    Object localObject = paramReactEditText.getBackground();
    if (((Drawable)localObject).getConstantState() != null);
    try
    {
      Drawable localDrawable = ((Drawable)localObject).mutate();
      localObject = localDrawable;
      if (paramInteger == null)
      {
        ((Drawable)localObject).clearColorFilter();
        return;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      while (true)
        FLog.e(TAG, "NullPointerException when setting underlineColorAndroid for TextInput", localNullPointerException);
      ((Drawable)localObject).setColorFilter(paramInteger.intValue(), PorterDuff.Mode.SRC_IN);
    }
  }

  public void updateExtraData(ReactEditText paramReactEditText, Object paramObject)
  {
    if ((paramObject instanceof ReactTextUpdate))
    {
      ReactTextUpdate localReactTextUpdate = (ReactTextUpdate)paramObject;
      paramReactEditText.setPadding((int)localReactTextUpdate.getPaddingLeft(), (int)localReactTextUpdate.getPaddingTop(), (int)localReactTextUpdate.getPaddingRight(), (int)localReactTextUpdate.getPaddingBottom());
      if (localReactTextUpdate.containsImages())
        TextInlineImageSpan.possiblyUpdateInlineImageSpans(localReactTextUpdate.getText(), paramReactEditText);
      paramReactEditText.maybeSetText(localReactTextUpdate);
    }
  }

  private class ReactContentSizeWatcher
    implements ContentSizeWatcher
  {
    private ReactEditText mEditText;
    private EventDispatcher mEventDispatcher;
    private int mPreviousContentHeight = 0;
    private int mPreviousContentWidth = 0;

    public ReactContentSizeWatcher(ReactEditText arg2)
    {
      Object localObject;
      this.mEditText = localObject;
      this.mEventDispatcher = ((UIManagerModule)((ReactContext)localObject.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher();
    }

    public void onLayout()
    {
      int i = this.mEditText.getWidth();
      int j = this.mEditText.getHeight();
      if (this.mEditText.getLayout() != null)
      {
        i = this.mEditText.getCompoundPaddingLeft() + this.mEditText.getLayout().getWidth() + this.mEditText.getCompoundPaddingRight();
        j = this.mEditText.getCompoundPaddingTop() + this.mEditText.getLayout().getHeight() + this.mEditText.getCompoundPaddingBottom();
      }
      if ((i != this.mPreviousContentWidth) || (j != this.mPreviousContentHeight))
      {
        this.mPreviousContentHeight = j;
        this.mPreviousContentWidth = i;
        this.mEventDispatcher.dispatchEvent(new ReactContentSizeChangedEvent(this.mEditText.getId(), PixelUtil.toDIPFromPixel(i), PixelUtil.toDIPFromPixel(j)));
      }
    }
  }

  private class ReactScrollWatcher
    implements ScrollWatcher
  {
    private EventDispatcher mEventDispatcher;
    private int mPreviousHoriz;
    private int mPreviousVert;
    private ReactEditText mReactEditText;

    public ReactScrollWatcher(ReactEditText arg2)
    {
      Object localObject;
      this.mReactEditText = localObject;
      this.mEventDispatcher = ((UIManagerModule)((ReactContext)localObject.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher();
    }

    public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if ((this.mPreviousHoriz != paramInt1) || (this.mPreviousVert != paramInt2))
      {
        ScrollEvent localScrollEvent = ScrollEvent.obtain(this.mReactEditText.getId(), ScrollEventType.SCROLL, paramInt1, paramInt2, 0.0F, 0.0F, 0, 0, this.mReactEditText.getWidth(), this.mReactEditText.getHeight());
        this.mEventDispatcher.dispatchEvent(localScrollEvent);
        this.mPreviousHoriz = paramInt1;
        this.mPreviousVert = paramInt2;
      }
    }
  }

  private class ReactSelectionWatcher
    implements SelectionWatcher
  {
    private EventDispatcher mEventDispatcher;
    private int mPreviousSelectionEnd;
    private int mPreviousSelectionStart;
    private ReactEditText mReactEditText;

    public ReactSelectionWatcher(ReactEditText arg2)
    {
      Object localObject;
      this.mReactEditText = localObject;
      this.mEventDispatcher = ((UIManagerModule)((ReactContext)localObject.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher();
    }

    public void onSelectionChanged(int paramInt1, int paramInt2)
    {
      if ((this.mPreviousSelectionStart != paramInt1) || (this.mPreviousSelectionEnd != paramInt2))
      {
        this.mEventDispatcher.dispatchEvent(new ReactTextInputSelectionEvent(this.mReactEditText.getId(), paramInt1, paramInt2));
        this.mPreviousSelectionStart = paramInt1;
        this.mPreviousSelectionEnd = paramInt2;
      }
    }
  }

  private class ReactTextInputTextWatcher
    implements TextWatcher
  {
    private ReactEditText mEditText;
    private EventDispatcher mEventDispatcher;
    private String mPreviousText;

    public ReactTextInputTextWatcher(ReactContext paramReactEditText, ReactEditText arg3)
    {
      this.mEventDispatcher = ((UIManagerModule)paramReactEditText.getNativeModule(UIManagerModule.class)).getEventDispatcher();
      Object localObject;
      this.mEditText = localObject;
      this.mPreviousText = null;
    }

    public void afterTextChanged(Editable paramEditable)
    {
    }

    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      this.mPreviousText = paramCharSequence.toString();
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      if ((paramInt3 == 0) && (paramInt2 == 0));
      String str1;
      String str2;
      do
      {
        return;
        Assertions.assertNotNull(this.mPreviousText);
        str1 = paramCharSequence.toString().substring(paramInt1, paramInt1 + paramInt3);
        str2 = this.mPreviousText.substring(paramInt1, paramInt1 + paramInt2);
      }
      while ((paramInt3 == paramInt2) && (str1.equals(str2)));
      this.mEventDispatcher.dispatchEvent(new ReactTextChangedEvent(this.mEditText.getId(), paramCharSequence.toString(), this.mEditText.incrementAndGetEventCounter()));
      this.mEventDispatcher.dispatchEvent(new ReactTextInputEvent(this.mEditText.getId(), str1, str2, paramInt1, paramInt1 + paramInt2));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.textinput.ReactTextInputManager
 * JD-Core Version:    0.6.2
 */