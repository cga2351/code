package com.facebook.react.uimanager;

import android.content.Context;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.text.SpannableString;
import android.text.style.URLSpan;
import android.view.View;
import com.facebook.react.R.id;
import com.facebook.react.R.string;
import java.util.Locale;
import javax.annotation.Nullable;

public class AccessibilityDelegateUtil
{
  public static void setDelegate(final View paramView)
  {
    String str = (String)paramView.getTag(R.id.accessibility_hint);
    final AccessibilityRole localAccessibilityRole = (AccessibilityRole)paramView.getTag(R.id.accessibility_role);
    if ((!ViewCompat.hasAccessibilityDelegate(paramView)) && ((str != null) || (localAccessibilityRole != null)))
      ViewCompat.setAccessibilityDelegate(paramView, new AccessibilityDelegateCompat()
      {
        public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfoCompat paramAnonymousAccessibilityNodeInfoCompat)
        {
          super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfoCompat);
          if (this.val$accessibilityHint != null)
          {
            String str = (String)paramAnonymousAccessibilityNodeInfoCompat.getContentDescription();
            if (str == null)
              break label71;
            paramAnonymousAccessibilityNodeInfoCompat.setContentDescription(str + ", " + this.val$accessibilityHint);
          }
          while (true)
          {
            AccessibilityDelegateUtil.setRole(paramAnonymousAccessibilityNodeInfoCompat, localAccessibilityRole, paramView.getContext());
            return;
            label71: paramAnonymousAccessibilityNodeInfoCompat.setContentDescription(this.val$accessibilityHint);
          }
        }
      });
  }

  public static void setRole(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, AccessibilityRole paramAccessibilityRole, Context paramContext)
  {
    if (paramAccessibilityRole == null)
      paramAccessibilityRole = AccessibilityRole.NONE;
    paramAccessibilityNodeInfoCompat.setClassName(AccessibilityRole.getValue(paramAccessibilityRole));
    if (Locale.getDefault().getLanguage().equals(new Locale("en").getLanguage()))
    {
      if (paramAccessibilityRole.equals(AccessibilityRole.LINK))
      {
        paramAccessibilityNodeInfoCompat.setRoleDescription(paramContext.getString(R.string.link_description));
        if (paramAccessibilityNodeInfoCompat.getContentDescription() != null)
        {
          SpannableString localSpannableString1 = new SpannableString(paramAccessibilityNodeInfoCompat.getContentDescription());
          localSpannableString1.setSpan(new URLSpan(""), 0, localSpannableString1.length(), 0);
          paramAccessibilityNodeInfoCompat.setContentDescription(localSpannableString1);
        }
        if (paramAccessibilityNodeInfoCompat.getText() != null)
        {
          SpannableString localSpannableString2 = new SpannableString(paramAccessibilityNodeInfoCompat.getText());
          localSpannableString2.setSpan(new URLSpan(""), 0, localSpannableString2.length(), 0);
          paramAccessibilityNodeInfoCompat.setText(localSpannableString2);
        }
      }
      if (paramAccessibilityRole.equals(AccessibilityRole.SEARCH))
        paramAccessibilityNodeInfoCompat.setRoleDescription(paramContext.getString(R.string.search_description));
      if (paramAccessibilityRole.equals(AccessibilityRole.IMAGE))
        paramAccessibilityNodeInfoCompat.setRoleDescription(paramContext.getString(R.string.image_description));
      if (paramAccessibilityRole.equals(AccessibilityRole.IMAGEBUTTON))
        paramAccessibilityNodeInfoCompat.setRoleDescription(paramContext.getString(R.string.image_button_description));
      if (paramAccessibilityRole.equals(AccessibilityRole.ADJUSTABLE))
        paramAccessibilityNodeInfoCompat.setRoleDescription(paramContext.getString(R.string.adjustable_description));
      if (paramAccessibilityRole.equals(AccessibilityRole.HEADER))
      {
        paramAccessibilityNodeInfoCompat.setRoleDescription(paramContext.getString(R.string.header_description));
        paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, 0, 1, true));
      }
    }
    if (paramAccessibilityRole.equals(AccessibilityRole.IMAGEBUTTON))
      paramAccessibilityNodeInfoCompat.setClickable(true);
  }

  public static enum AccessibilityRole
  {
    static
    {
      BUTTON = new AccessibilityRole("BUTTON", 1);
      LINK = new AccessibilityRole("LINK", 2);
      SEARCH = new AccessibilityRole("SEARCH", 3);
      IMAGE = new AccessibilityRole("IMAGE", 4);
      IMAGEBUTTON = new AccessibilityRole("IMAGEBUTTON", 5);
      KEYBOARDKEY = new AccessibilityRole("KEYBOARDKEY", 6);
      TEXT = new AccessibilityRole("TEXT", 7);
      ADJUSTABLE = new AccessibilityRole("ADJUSTABLE", 8);
      SUMMARY = new AccessibilityRole("SUMMARY", 9);
      HEADER = new AccessibilityRole("HEADER", 10);
      AccessibilityRole[] arrayOfAccessibilityRole = new AccessibilityRole[11];
      arrayOfAccessibilityRole[0] = NONE;
      arrayOfAccessibilityRole[1] = BUTTON;
      arrayOfAccessibilityRole[2] = LINK;
      arrayOfAccessibilityRole[3] = SEARCH;
      arrayOfAccessibilityRole[4] = IMAGE;
      arrayOfAccessibilityRole[5] = IMAGEBUTTON;
      arrayOfAccessibilityRole[6] = KEYBOARDKEY;
      arrayOfAccessibilityRole[7] = TEXT;
      arrayOfAccessibilityRole[8] = ADJUSTABLE;
      arrayOfAccessibilityRole[9] = SUMMARY;
      arrayOfAccessibilityRole[10] = HEADER;
    }

    public static AccessibilityRole fromValue(@Nullable String paramString)
    {
      for (AccessibilityRole localAccessibilityRole : values())
        if (localAccessibilityRole.name().equalsIgnoreCase(paramString))
          return localAccessibilityRole;
      throw new IllegalArgumentException("Invalid accessibility role value: " + paramString);
    }

    public static String getValue(AccessibilityRole paramAccessibilityRole)
    {
      switch (AccessibilityDelegateUtil.2.$SwitchMap$com$facebook$react$uimanager$AccessibilityDelegateUtil$AccessibilityRole[paramAccessibilityRole.ordinal()])
      {
      default:
        throw new IllegalArgumentException("Invalid accessibility role value: " + paramAccessibilityRole);
      case 1:
        return null;
      case 2:
        return "android.widget.Button";
      case 3:
        return "android.widget.ViewGroup";
      case 4:
        return "android.widget.EditText";
      case 5:
        return "android.widget.ImageView";
      case 6:
        return "android.widget.ImageView";
      case 7:
        return "android.inputmethodservice.Keyboard$Key";
      case 8:
        return "android.widget.ViewGroup";
      case 9:
        return "android.widget.SeekBar";
      case 10:
        return "android.widget.ViewGroup";
      case 11:
      }
      return "android.widget.ViewGroup";
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.AccessibilityDelegateUtil
 * JD-Core Version:    0.6.2
 */