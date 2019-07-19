package com.viber.voip.user.editinfo;

import android.net.Uri;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract interface EditInfoView
{
  public abstract void hideBirthDate();

  public abstract void hideImportFromVkButton();

  public abstract void hideRakutenAccountInfo();

  public abstract void onImportFromSocialNetwork(@SocialNetworkType int paramInt);

  public abstract void renderAvatar(Uri paramUri);

  public abstract void renderChangePhotoState();

  public abstract void renderDefaultAvatar(boolean paramBoolean);

  public abstract void renderEmptyNameAvatar(boolean paramBoolean);

  public abstract void renderPhoneNumber(String paramString);

  public abstract void renderPhotoPickerDialog(boolean paramBoolean);

  public abstract void renderRakutenAccountInfo(String paramString);

  public abstract void renderRegistrationMode();

  public abstract void renderUserName(String paramString);

  public abstract void showAgeKindSelector();

  public abstract void showBirthDateSelector(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2);

  public abstract void showConnectToSocialNetworkDialog(@SocialNetworkType int paramInt);

  public abstract void showExactBirthDate(String paramString);

  public abstract void showFbImportError();

  public abstract void showImportFromVkButton();

  public abstract void showInexactBirthDate(int paramInt);

  public abstract void showInitials(String paramString, boolean paramBoolean);

  public abstract void showShadows(boolean paramBoolean);

  public abstract void showStatusBarShadow(boolean paramBoolean);

  public abstract void showVkImportError();

  public abstract void updatePhoneNumberVisibility(boolean paramBoolean);

  @Retention(RetentionPolicy.RUNTIME)
  public static @interface SocialNetworkType
  {
    public static final int FACEBOOK = 1;
    public static final int VK = 2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.editinfo.EditInfoView
 * JD-Core Version:    0.6.2
 */