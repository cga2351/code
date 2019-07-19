package com.viber.voip.contacts.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView.SelectionBoundsAdjuster;
import android.widget.RelativeLayout;
import com.viber.voip.R.id;

public class ContactListItemView extends RelativeLayout
  implements AbsListView.SelectionBoundsAdjuster
{
  private View a;

  public ContactListItemView(Context paramContext)
  {
    super(paramContext);
  }

  public ContactListItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ContactListItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  @TargetApi(21)
  public ContactListItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }

  public void adjustListItemSelectionBounds(Rect paramRect)
  {
    paramRect.left = this.a.getLeft();
    paramRect.top += this.a.getTop();
    paramRect.bottom = (paramRect.top + this.a.getHeight());
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = findViewById(R.id.root);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.ContactListItemView
 * JD-Core Version:    0.6.2
 */