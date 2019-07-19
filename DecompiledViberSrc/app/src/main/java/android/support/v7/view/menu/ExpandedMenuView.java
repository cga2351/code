package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;

public final class ExpandedMenuView extends ListView
  implements h.b, p, AdapterView.OnItemClickListener
{
  private static final int[] a = { 16842964, 16843049 };
  private h b;
  private int c;

  public ExpandedMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }

  public ExpandedMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    setOnItemClickListener(this);
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, a, paramInt, 0);
    if (localTintTypedArray.hasValue(0))
      setBackgroundDrawable(localTintTypedArray.getDrawable(0));
    if (localTintTypedArray.hasValue(1))
      setDivider(localTintTypedArray.getDrawable(1));
    localTintTypedArray.recycle();
  }

  public int getWindowAnimations()
  {
    return this.c;
  }

  public void initialize(h paramh)
  {
    this.b = paramh;
  }

  public boolean invokeItem(j paramj)
  {
    return this.b.a(paramj, 0);
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    setChildrenDrawingCacheEnabled(false);
  }

  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    invokeItem((j)getAdapter().getItem(paramInt));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.view.menu.ExpandedMenuView
 * JD-Core Version:    0.6.2
 */