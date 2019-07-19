package com.viber.voip.user.editinfo;

import android.net.Uri;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.ci;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.da;
import com.viber.voip.util.dk;
import dagger.a;
import java.io.File;
import javax.inject.Inject;

public class UserInfoRepository
  implements ProfileImageRepository, ProfileNameRepository, ProfileNumberRepository
{
  private final a<ci> mUserDataController;
  private final UserManager mUserManager;

  @Inject
  public UserInfoRepository(UserManager paramUserManager, a<ci> parama)
  {
    this.mUserManager = paramUserManager;
    this.mUserDataController = parama;
  }

  public void changeName(String paramString)
  {
    ((ci)this.mUserDataController.get()).a(paramString);
  }

  public Uri getImageUri()
  {
    return this.mUserManager.getUserData().getImage();
  }

  public String getMemberId()
  {
    return this.mUserManager.getUser().getId();
  }

  public String getName()
  {
    return this.mUserManager.getUserData().getViberName();
  }

  public CharSequence getNameOrDefault(ProfileNameRepository.DefaultNameProvider paramDefaultNameProvider)
  {
    Object localObject = getName();
    if (da.a((CharSequence)localObject))
      localObject = paramDefaultNameProvider.get();
    return localObject;
  }

  public String getNameOrNumber()
  {
    String str = this.mUserManager.getUserData().getViberName();
    if (da.a(str))
      str = getPhoneNumberWithPlus();
    return str;
  }

  public String getPhoneNumber()
  {
    return this.mUserManager.getUser().getPhoneNumber();
  }

  public String getPhoneNumberWithPlus()
  {
    String str = getPhoneNumber();
    if (str == null)
      return null;
    return "+" + str;
  }

  public String getViberImage()
  {
    return this.mUserManager.getUserData().getViberImage();
  }

  public boolean isViberImageRemoved()
  {
    String str = getViberImage();
    if (da.a(str));
    for (Uri localUri = null; (localUri != null) && (localUri.getPath() != null) && (!dk.f(localUri)) && (!new File(localUri.getPath()).exists()); localUri = Uri.parse(str))
      return true;
    return false;
  }

  public void updateAvatar(Uri paramUri)
  {
    ((ci)this.mUserDataController.get()).a(paramUri);
    this.mUserManager.getUserData().setImage(paramUri);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.editinfo.UserInfoRepository
 * JD-Core Version:    0.6.2
 */