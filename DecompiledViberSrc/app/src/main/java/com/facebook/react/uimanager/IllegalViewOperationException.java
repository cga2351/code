package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.JSApplicationCausedNativeException;

public class IllegalViewOperationException extends JSApplicationCausedNativeException
{
  private View mView;

  public IllegalViewOperationException(String paramString)
  {
    super(paramString);
  }

  public IllegalViewOperationException(String paramString, View paramView, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    this.mView = paramView;
  }

  public View getView()
  {
    return this.mView;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.IllegalViewOperationException
 * JD-Core Version:    0.6.2
 */