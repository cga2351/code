package com.viber.voip.contacts.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.util.da;

public class ContactDetailsButtonsLayout extends FrameLayout
{
  private TextView a;
  private TextView b;
  private float c;
  private float d;

  public ContactDetailsButtonsLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public ContactDetailsButtonsLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public ContactDetailsButtonsLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private void a(int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.a.getLayoutParams();
    if (localLayoutParams1 != null);
    for (int i = 0 + localLayoutParams1.leftMargin + localLayoutParams1.rightMargin; ; i = 0)
    {
      LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)this.b.getLayoutParams();
      if (localLayoutParams2 != null)
        i = i + localLayoutParams2.leftMargin + localLayoutParams2.rightMargin;
      int j = (paramInt - getPaddingLeft() - getPaddingRight() - i) / 2;
      float f = this.c;
      String str1 = this.a.getText().toString();
      String str2 = this.b.getText().toString();
      int k = j - this.a.getPaddingLeft() - this.a.getPaddingRight();
      int m = j - this.b.getPaddingLeft() - this.b.getPaddingRight();
      while (f >= this.d)
      {
        this.a.setTextSize(0, f);
        int n = da.a(this.a, str1);
        this.b.setTextSize(0, f);
        int i1 = da.a(this.b, str2);
        if ((n < k) && (i1 < m))
          break;
        f -= 1.0F;
      }
      return;
    }
  }

  private void a(Context paramContext)
  {
    this.c = getResources().getDimension(R.dimen.viber_buttons_text_size);
    this.d = (this.c / 2.0F);
    LayoutInflater.from(paramContext).inflate(R.layout.contact_details_viber_buttons, this);
    this.a = ((TextView)findViewById(R.id.left_button));
    this.b = ((TextView)findViewById(R.id.right_button));
  }

  public void a()
  {
    this.a.setVisibility(4);
    this.b.setVisibility(4);
  }

  public void a(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2)
  {
    this.a.setVisibility(0);
    this.b.setVisibility(0);
    this.a.setTag(paramObject1);
    this.b.setTag(paramObject2);
    if (paramInt1 > 0)
      this.a.setText(paramInt1);
    if (paramInt2 > 0)
      this.b.setText(paramInt2);
    if ((getWidth() > 0) && ((paramInt1 > 0) || (paramInt2 > 0)))
      a(getWidth());
  }

  public void a(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    this.a.setOnClickListener(paramOnClickListener1);
    this.b.setOnClickListener(paramOnClickListener2);
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) && (!isInEditMode()))
      a(paramInt1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.ContactDetailsButtonsLayout
 * JD-Core Version:    0.6.2
 */