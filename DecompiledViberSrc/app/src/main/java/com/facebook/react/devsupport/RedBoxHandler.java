package com.facebook.react.devsupport;

import android.content.Context;
import android.text.SpannedString;
import com.facebook.react.devsupport.interfaces.StackFrame;

public abstract interface RedBoxHandler
{
  public abstract void handleRedbox(String paramString, StackFrame[] paramArrayOfStackFrame, ErrorType paramErrorType);

  public abstract boolean isReportEnabled();

  public abstract void reportRedbox(Context paramContext, String paramString1, StackFrame[] paramArrayOfStackFrame, String paramString2, ReportCompletedListener paramReportCompletedListener);

  public static enum ErrorType
  {
    private final String name;

    static
    {
      ErrorType[] arrayOfErrorType = new ErrorType[2];
      arrayOfErrorType[0] = JS;
      arrayOfErrorType[1] = NATIVE;
    }

    private ErrorType(String paramString)
    {
      this.name = paramString;
    }

    public String getName()
    {
      return this.name;
    }
  }

  public static abstract interface ReportCompletedListener
  {
    public abstract void onReportError(SpannedString paramSpannedString);

    public abstract void onReportSuccess(SpannedString paramSpannedString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.RedBoxHandler
 * JD-Core Version:    0.6.2
 */