package com.viber.voip.user.editinfo;

import com.viber.common.permission.c;
import com.viber.voip.util.e.e;
import javax.inject.Provider;

public final class EditInfoFragment_MembersInjector
  implements dagger.b<EditInfoFragment>
{
  private final Provider<com.viber.voip.app.b> mDeviceConfigurationProvider;
  private final Provider<e> mImageFetcherProvider;
  private final Provider<c> mPermissionManagerProvider;

  public EditInfoFragment_MembersInjector(Provider<e> paramProvider, Provider<c> paramProvider1, Provider<com.viber.voip.app.b> paramProvider2)
  {
    this.mImageFetcherProvider = paramProvider;
    this.mPermissionManagerProvider = paramProvider1;
    this.mDeviceConfigurationProvider = paramProvider2;
  }

  public static dagger.b<EditInfoFragment> create(Provider<e> paramProvider, Provider<c> paramProvider1, Provider<com.viber.voip.app.b> paramProvider2)
  {
    return new EditInfoFragment_MembersInjector(paramProvider, paramProvider1, paramProvider2);
  }

  public static void injectMDeviceConfiguration(EditInfoFragment paramEditInfoFragment, com.viber.voip.app.b paramb)
  {
    paramEditInfoFragment.mDeviceConfiguration = paramb;
  }

  public static void injectMImageFetcher(EditInfoFragment paramEditInfoFragment, e parame)
  {
    paramEditInfoFragment.mImageFetcher = parame;
  }

  public static void injectMPermissionManager(EditInfoFragment paramEditInfoFragment, c paramc)
  {
    paramEditInfoFragment.mPermissionManager = paramc;
  }

  public void injectMembers(EditInfoFragment paramEditInfoFragment)
  {
    injectMImageFetcher(paramEditInfoFragment, (e)this.mImageFetcherProvider.get());
    injectMPermissionManager(paramEditInfoFragment, (c)this.mPermissionManagerProvider.get());
    injectMDeviceConfiguration(paramEditInfoFragment, (com.viber.voip.app.b)this.mDeviceConfigurationProvider.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.editinfo.EditInfoFragment_MembersInjector
 * JD-Core Version:    0.6.2
 */