package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityWindowInfo;

public class AccessibilityWindowInfoCompat
{
  public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
  public static final int TYPE_APPLICATION = 1;
  public static final int TYPE_INPUT_METHOD = 2;
  public static final int TYPE_SPLIT_SCREEN_DIVIDER = 5;
  public static final int TYPE_SYSTEM = 3;
  private static final int UNDEFINED = -1;
  private Object mInfo;

  private AccessibilityWindowInfoCompat(Object paramObject)
  {
    this.mInfo = paramObject;
  }

  public static AccessibilityWindowInfoCompat obtain()
  {
    if (Build.VERSION.SDK_INT >= 21)
      return wrapNonNullInstance(AccessibilityWindowInfo.obtain());
    return null;
  }

  public static AccessibilityWindowInfoCompat obtain(AccessibilityWindowInfoCompat paramAccessibilityWindowInfoCompat)
  {
    if ((Build.VERSION.SDK_INT < 21) || (paramAccessibilityWindowInfoCompat == null))
      return null;
    return wrapNonNullInstance(AccessibilityWindowInfo.obtain((AccessibilityWindowInfo)paramAccessibilityWindowInfoCompat.mInfo));
  }

  private static String typeToString(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "<UNKNOWN>";
    case 1:
      return "TYPE_APPLICATION";
    case 2:
      return "TYPE_INPUT_METHOD";
    case 3:
      return "TYPE_SYSTEM";
    case 4:
    }
    return "TYPE_ACCESSIBILITY_OVERLAY";
  }

  static AccessibilityWindowInfoCompat wrapNonNullInstance(Object paramObject)
  {
    if (paramObject != null)
      return new AccessibilityWindowInfoCompat(paramObject);
    return null;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    AccessibilityWindowInfoCompat localAccessibilityWindowInfoCompat;
    do
    {
      do
      {
        return true;
        if (paramObject == null)
          return false;
        if (getClass() != paramObject.getClass())
          return false;
        localAccessibilityWindowInfoCompat = (AccessibilityWindowInfoCompat)paramObject;
        if (this.mInfo != null)
          break;
      }
      while (localAccessibilityWindowInfoCompat.mInfo == null);
      return false;
    }
    while (this.mInfo.equals(localAccessibilityWindowInfoCompat.mInfo));
    return false;
  }

  public AccessibilityNodeInfoCompat getAnchor()
  {
    if (Build.VERSION.SDK_INT >= 24)
      return AccessibilityNodeInfoCompat.wrapNonNullInstance(((AccessibilityWindowInfo)this.mInfo).getAnchor());
    return null;
  }

  public void getBoundsInScreen(Rect paramRect)
  {
    if (Build.VERSION.SDK_INT >= 21)
      ((AccessibilityWindowInfo)this.mInfo).getBoundsInScreen(paramRect);
  }

  public AccessibilityWindowInfoCompat getChild(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return wrapNonNullInstance(((AccessibilityWindowInfo)this.mInfo).getChild(paramInt));
    return null;
  }

  public int getChildCount()
  {
    if (Build.VERSION.SDK_INT >= 21)
      return ((AccessibilityWindowInfo)this.mInfo).getChildCount();
    return 0;
  }

  public int getId()
  {
    if (Build.VERSION.SDK_INT >= 21)
      return ((AccessibilityWindowInfo)this.mInfo).getId();
    return -1;
  }

  public int getLayer()
  {
    if (Build.VERSION.SDK_INT >= 21)
      return ((AccessibilityWindowInfo)this.mInfo).getLayer();
    return -1;
  }

  public AccessibilityWindowInfoCompat getParent()
  {
    if (Build.VERSION.SDK_INT >= 21)
      return wrapNonNullInstance(((AccessibilityWindowInfo)this.mInfo).getParent());
    return null;
  }

  public AccessibilityNodeInfoCompat getRoot()
  {
    if (Build.VERSION.SDK_INT >= 21)
      return AccessibilityNodeInfoCompat.wrapNonNullInstance(((AccessibilityWindowInfo)this.mInfo).getRoot());
    return null;
  }

  public CharSequence getTitle()
  {
    if (Build.VERSION.SDK_INT >= 24)
      return ((AccessibilityWindowInfo)this.mInfo).getTitle();
    return null;
  }

  public int getType()
  {
    if (Build.VERSION.SDK_INT >= 21)
      return ((AccessibilityWindowInfo)this.mInfo).getType();
    return -1;
  }

  public int hashCode()
  {
    if (this.mInfo == null)
      return 0;
    return this.mInfo.hashCode();
  }

  public boolean isAccessibilityFocused()
  {
    if (Build.VERSION.SDK_INT >= 21)
      return ((AccessibilityWindowInfo)this.mInfo).isAccessibilityFocused();
    return true;
  }

  public boolean isActive()
  {
    if (Build.VERSION.SDK_INT >= 21)
      return ((AccessibilityWindowInfo)this.mInfo).isActive();
    return true;
  }

  public boolean isFocused()
  {
    if (Build.VERSION.SDK_INT >= 21)
      return ((AccessibilityWindowInfo)this.mInfo).isFocused();
    return true;
  }

  public void recycle()
  {
    if (Build.VERSION.SDK_INT >= 21)
      ((AccessibilityWindowInfo)this.mInfo).recycle();
  }

  public String toString()
  {
    boolean bool1 = true;
    StringBuilder localStringBuilder1 = new StringBuilder();
    Rect localRect = new Rect();
    getBoundsInScreen(localRect);
    localStringBuilder1.append("AccessibilityWindowInfo[");
    localStringBuilder1.append("id=").append(getId());
    localStringBuilder1.append(", type=").append(typeToString(getType()));
    localStringBuilder1.append(", layer=").append(getLayer());
    localStringBuilder1.append(", bounds=").append(localRect);
    localStringBuilder1.append(", focused=").append(isFocused());
    localStringBuilder1.append(", active=").append(isActive());
    StringBuilder localStringBuilder2 = localStringBuilder1.append(", hasParent=");
    boolean bool2;
    StringBuilder localStringBuilder3;
    if (getParent() != null)
    {
      bool2 = bool1;
      localStringBuilder2.append(bool2);
      localStringBuilder3 = localStringBuilder1.append(", hasChildren=");
      if (getChildCount() <= 0)
        break label180;
    }
    while (true)
    {
      localStringBuilder3.append(bool1);
      localStringBuilder1.append(']');
      return localStringBuilder1.toString();
      bool2 = false;
      break;
      label180: bool1 = false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityWindowInfoCompat
 * JD-Core Version:    0.6.2
 */