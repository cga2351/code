package com.facebook.react.uimanager;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.RadioButton;

class AccessibilityHelper
{
  private static final String BUTTON = "button";
  private static final View.AccessibilityDelegate BUTTON_DELEGATE = new View.AccessibilityDelegate()
  {
    public void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
      paramAnonymousAccessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
      paramAnonymousAccessibilityNodeInfo.setClassName(Button.class.getName());
    }
  };
  private static final String RADIOBUTTON_CHECKED = "radiobutton_checked";
  private static final View.AccessibilityDelegate RADIOBUTTON_CHECKED_DELEGATE = new View.AccessibilityDelegate()
  {
    public void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
      paramAnonymousAccessibilityEvent.setClassName(RadioButton.class.getName());
      paramAnonymousAccessibilityEvent.setChecked(true);
    }

    public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
      paramAnonymousAccessibilityNodeInfo.setClassName(RadioButton.class.getName());
      paramAnonymousAccessibilityNodeInfo.setCheckable(true);
      paramAnonymousAccessibilityNodeInfo.setChecked(true);
    }
  };
  private static final String RADIOBUTTON_UNCHECKED = "radiobutton_unchecked";
  private static final View.AccessibilityDelegate RADIOBUTTON_UNCHECKED_DELEGATE = new View.AccessibilityDelegate()
  {
    public void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
      paramAnonymousAccessibilityEvent.setClassName(RadioButton.class.getName());
      paramAnonymousAccessibilityEvent.setChecked(false);
    }

    public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
      paramAnonymousAccessibilityNodeInfo.setClassName(RadioButton.class.getName());
      paramAnonymousAccessibilityNodeInfo.setCheckable(true);
      paramAnonymousAccessibilityNodeInfo.setChecked(false);
    }
  };

  public static void sendAccessibilityEvent(View paramView, int paramInt)
  {
    paramView.sendAccessibilityEvent(paramInt);
  }

  public static void updateAccessibilityComponentType(View paramView, String paramString)
  {
    if (paramString == null)
    {
      paramView.setAccessibilityDelegate(null);
      return;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case -1377687758:
    case -714126251:
    case -1320494052:
    }
    while (true)
      switch (i)
      {
      default:
        paramView.setAccessibilityDelegate(null);
        return;
        if (paramString.equals("button"))
        {
          i = 0;
          continue;
          if (paramString.equals("radiobutton_checked"))
          {
            i = 1;
            continue;
            if (paramString.equals("radiobutton_unchecked"))
              i = 2;
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      }
    paramView.setAccessibilityDelegate(BUTTON_DELEGATE);
    return;
    paramView.setAccessibilityDelegate(RADIOBUTTON_CHECKED_DELEGATE);
    return;
    paramView.setAccessibilityDelegate(RADIOBUTTON_UNCHECKED_DELEGATE);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.AccessibilityHelper
 * JD-Core Version:    0.6.2
 */