package com.viber.jni.im2;

public class JokerButton
{
  public final String action;
  public final String buttonTxt;
  public final String iconUrl;

  public JokerButton(String paramString1, String paramString2, String paramString3)
  {
    this.iconUrl = Im2Utils.checkStringValue(paramString1);
    this.action = Im2Utils.checkStringValue(paramString2);
    this.buttonTxt = Im2Utils.checkStringValue(paramString3);
    init();
  }

  private void init()
  {
  }

  public com.viber.jni.JokerButton toLegacyJokerButton()
  {
    com.viber.jni.JokerButton localJokerButton = new com.viber.jni.JokerButton();
    localJokerButton.iconUrl = this.iconUrl;
    localJokerButton.action = this.action;
    localJokerButton.buttonTxt = this.buttonTxt;
    return localJokerButton;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.JokerButton
 * JD-Core Version:    0.6.2
 */