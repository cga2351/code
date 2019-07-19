package com.viber.voip.messages.conversation.ui.view;

import android.view.View.OnClickListener;
import com.viber.voip.mvp.core.j;

public abstract interface p extends j
{
  public abstract void a();

  public abstract void a(int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener);

  public abstract void a(int paramInt, String paramString1, ScreenshotConversationData paramScreenshotConversationData, String paramString2);

  public abstract void a(String paramString);

  public abstract void a(String paramString, float paramFloat);

  public abstract void a(String paramString, ScreenshotConversationData paramScreenshotConversationData);

  public abstract void a(String paramString1, String paramString2);

  public abstract void b();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.p
 * JD-Core Version:    0.6.2
 */