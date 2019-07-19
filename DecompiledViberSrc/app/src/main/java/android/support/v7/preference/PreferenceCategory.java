package android.support.v7.preference;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.util.AttributeSet;
import android.view.View;

public class PreferenceCategory extends PreferenceGroup
{
  public PreferenceCategory(Context paramContext)
  {
    this(paramContext, null);
  }

  public PreferenceCategory(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, TypedArrayUtils.getAttr(paramContext, R.attr.preferenceCategoryStyle, 16842892));
  }

  public PreferenceCategory(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }

  public PreferenceCategory(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }

  public void a(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.a(paramAccessibilityNodeInfoCompat);
    AccessibilityNodeInfoCompat.CollectionItemInfoCompat localCollectionItemInfoCompat;
    if (Build.VERSION.SDK_INT < 28)
    {
      localCollectionItemInfoCompat = paramAccessibilityNodeInfoCompat.getCollectionItemInfo();
      if (localCollectionItemInfoCompat != null);
    }
    else
    {
      return;
    }
    paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(localCollectionItemInfoCompat.getRowIndex(), localCollectionItemInfoCompat.getRowSpan(), localCollectionItemInfoCompat.getColumnIndex(), localCollectionItemInfoCompat.getColumnSpan(), true, localCollectionItemInfoCompat.isSelected()));
  }

  public void a(l paraml)
  {
    super.a(paraml);
    if (Build.VERSION.SDK_INT >= 28)
      paraml.itemView.setAccessibilityHeading(true);
  }

  public boolean l()
  {
    return !super.z();
  }

  public boolean z()
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.preference.PreferenceCategory
 * JD-Core Version:    0.6.2
 */