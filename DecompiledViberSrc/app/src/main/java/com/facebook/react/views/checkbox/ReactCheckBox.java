package com.facebook.react.views.checkbox;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;

class ReactCheckBox extends AppCompatCheckBox
{
  private boolean mAllowChange = true;

  public ReactCheckBox(Context paramContext)
  {
    super(paramContext);
  }

  public void setChecked(boolean paramBoolean)
  {
    if (this.mAllowChange)
    {
      this.mAllowChange = false;
      super.setChecked(paramBoolean);
    }
  }

  void setOn(boolean paramBoolean)
  {
    if (isChecked() != paramBoolean)
      super.setChecked(paramBoolean);
    this.mAllowChange = true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.checkbox.ReactCheckBox
 * JD-Core Version:    0.6.2
 */