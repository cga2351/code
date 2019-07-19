package com.facebook.react.devsupport;

import android.os.Handler;
import android.view.View;
import android.widget.EditText;

public class DoubleTapReloadRecognizer
{
  private static final long DOUBLE_TAP_DELAY = 200L;
  private boolean mDoRefresh = false;

  public boolean didDoubleTapR(int paramInt, View paramView)
  {
    if ((paramInt == 46) && (!(paramView instanceof EditText)))
    {
      if (this.mDoRefresh)
      {
        this.mDoRefresh = false;
        return true;
      }
      this.mDoRefresh = true;
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          DoubleTapReloadRecognizer.access$002(DoubleTapReloadRecognizer.this, false);
        }
      }
      , 200L);
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.DoubleTapReloadRecognizer
 * JD-Core Version:    0.6.2
 */