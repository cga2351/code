package com.appboy.ui.inappmessage;

import com.appboy.e.b;

public class InAppMessageCloser
{
  private InAppMessageViewWrapper mInAppMessageViewWrapper;

  public InAppMessageCloser(InAppMessageViewWrapper paramInAppMessageViewWrapper)
  {
    this.mInAppMessageViewWrapper = paramInAppMessageViewWrapper;
  }

  public void close(boolean paramBoolean)
  {
    if (paramBoolean)
      this.mInAppMessageViewWrapper.getInAppMessage().b(true);
    while (true)
    {
      this.mInAppMessageViewWrapper.close();
      return;
      this.mInAppMessageViewWrapper.getInAppMessage().b(false);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.InAppMessageCloser
 * JD-Core Version:    0.6.2
 */