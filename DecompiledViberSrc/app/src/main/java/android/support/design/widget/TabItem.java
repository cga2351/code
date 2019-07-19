package android.support.design.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.R.styleable;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.View;

public class TabItem extends View
{
  public final int customLayout;
  public final Drawable icon;
  public final CharSequence text;

  public TabItem(Context paramContext)
  {
    this(paramContext, null);
  }

  public TabItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.TabItem);
    this.text = localTintTypedArray.getText(R.styleable.TabItem_android_text);
    this.icon = localTintTypedArray.getDrawable(R.styleable.TabItem_android_icon);
    this.customLayout = localTintTypedArray.getResourceId(R.styleable.TabItem_android_layout, 0);
    localTintTypedArray.recycle();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.widget.TabItem
 * JD-Core Version:    0.6.2
 */