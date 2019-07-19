package com.vk.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKRequest.VKRequestListener;
import com.vk.sdk.dialogs.VKCaptchaDialog;
import com.vk.sdk.dialogs.VKOpenAuthDialog;
import com.vk.sdk.util.VKStringJoiner;
import com.vk.sdk.util.VKUtil;
import java.util.ArrayList;

public class VKServiceActivity extends Activity
  implements DialogInterface.OnDismissListener
{
  private static final String KEY_REQUEST = "arg3";
  private static final String KEY_SCOPE_LIST = "arg2";
  private static final String KEY_SDK_CUSTOM_INITIALIZE = "arg4";
  private static final String KEY_TYPE = "arg1";
  private static final String VK_APP_AUTH_ACTION = "com.vkontakte.android.action.SDK_AUTH";
  private static final String VK_APP_FINGERPRINT = "48761EEF50EE53AFC4CC9C5F10E6BDE7F8F5B82F";
  private static final String VK_APP_PACKAGE_ID = "com.vkontakte.android";

  private static Intent createIntent(Context paramContext, VKServiceType paramVKServiceType)
  {
    Intent localIntent = new Intent(paramContext, VKServiceActivity.class);
    localIntent.putExtra("arg1", paramVKServiceType.name());
    localIntent.putExtra("arg4", VKSdk.isCustomInitialize());
    return localIntent;
  }

  private long getRequestId()
  {
    return getIntent().getLongExtra("arg3", 0L);
  }

  private ArrayList<String> getScopeList()
  {
    return getIntent().getStringArrayListExtra("arg2");
  }

  private VKServiceType getType()
  {
    return VKServiceType.valueOf(getIntent().getStringExtra("arg1"));
  }

  public static void interruptWithError(Context paramContext, VKError paramVKError, VKServiceType paramVKServiceType)
  {
    Intent localIntent = createIntent(paramContext, paramVKServiceType);
    localIntent.setFlags(268435456);
    localIntent.putExtra("arg3", paramVKError.registerObject());
    if (paramContext != null)
      paramContext.startActivity(localIntent);
  }

  static void startLoginActivity(Activity paramActivity, ArrayList<String> paramArrayList)
  {
    Intent localIntent = createIntent(paramActivity.getApplicationContext(), VKServiceType.Authorization);
    localIntent.putStringArrayListExtra("arg2", paramArrayList);
    paramActivity.startActivityForResult(localIntent, VKServiceType.Authorization.getOuterCode());
  }

  @TargetApi(11)
  static void startLoginActivity(Fragment paramFragment, ArrayList<String> paramArrayList)
  {
    Intent localIntent = createIntent(paramFragment.getActivity().getApplication(), VKServiceType.Authorization);
    localIntent.putStringArrayListExtra("arg2", paramArrayList);
    paramFragment.startActivityForResult(localIntent, VKServiceType.Authorization.getOuterCode());
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == VKServiceType.Authorization.getOuterCode()) || (paramInt1 == VKServiceType.Validation.getOuterCode()))
      VKSdk.processActivityResult(this, paramInt2, paramIntent, new VKCallback()
      {
        public void onError(VKError paramAnonymousVKError)
        {
          VKObject localVKObject = VKObject.getRegisteredObject(VKServiceActivity.this.getRequestId());
          if ((localVKObject instanceof VKError))
          {
            VKError localVKError = (VKError)localVKObject;
            if (localVKError.request != null)
            {
              localVKError.request.cancel();
              if (localVKError.request.requestListener != null)
                localVKError.request.requestListener.onError(paramAnonymousVKError);
            }
          }
          if (paramAnonymousVKError != null)
            VKServiceActivity.this.setResult(0, VKServiceActivity.this.getIntent().putExtra("vk_extra_error_id", paramAnonymousVKError.registerObject()));
          while (true)
          {
            VKServiceActivity.this.finish();
            return;
            VKServiceActivity.this.setResult(0);
          }
        }

        public void onResult(VKAccessToken paramAnonymousVKAccessToken)
        {
          VKServiceActivity.this.setResult(-1);
          VKServiceActivity.this.finish();
        }
      });
  }

  public void onActivityResultPublic(int paramInt1, int paramInt2, Intent paramIntent)
  {
    onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent().getBooleanExtra("arg4", false))
      VKSdk.customInitialize(this, 0, null);
    VKSdk.wakeUpSession(getApplicationContext());
    switch (2.$SwitchMap$com$vk$sdk$VKServiceActivity$VKServiceType[getType().ordinal()])
    {
    default:
    case 1:
      Bundle localBundle;
      do
      {
        return;
        Context localContext = getApplicationContext();
        localBundle = new Bundle();
        localBundle.putString("version", VKSdk.getApiVersion());
        localBundle.putInt("client_id", VKSdk.getsCurrentAppId());
        localBundle.putBoolean("revoke", true);
        localBundle.putString("scope", VKStringJoiner.join(getScopeList(), ","));
        if ((!VKUtil.isAppInstalled(localContext, "com.vkontakte.android")) || (!VKUtil.isIntentAvailable(localContext, "com.vkontakte.android.action.SDK_AUTH")))
          break;
      }
      while (paramBundle != null);
      Intent localIntent = new Intent("com.vkontakte.android.action.SDK_AUTH", null);
      localIntent.putExtras(localBundle);
      startActivityForResult(localIntent, VKServiceType.Authorization.getOuterCode());
      return;
      new VKOpenAuthDialog().show(this, localBundle, VKServiceType.Authorization.getOuterCode(), null);
      return;
    case 2:
      VKError localVKError2 = (VKError)VKObject.getRegisteredObject(getRequestId());
      if (localVKError2 != null)
      {
        new VKCaptchaDialog(localVKError2).show(this, this);
        return;
      }
      finish();
      return;
    case 3:
    }
    VKError localVKError1 = (VKError)VKObject.getRegisteredObject(getRequestId());
    if (localVKError1 != null)
    {
      if ((!TextUtils.isEmpty(localVKError1.redirectUri)) && (!localVKError1.redirectUri.contains("&ui=vk_sdk")) && (!localVKError1.redirectUri.contains("?ui=vk_sdk")))
        if (localVKError1.redirectUri.indexOf('?') <= 0)
          break label363;
      label363: for (localVKError1.redirectUri += "&ui=vk_sdk"; ; localVKError1.redirectUri += "?ui=vk_sdk")
      {
        new VKOpenAuthDialog().show(this, new Bundle(), VKServiceType.Validation.getOuterCode(), localVKError1);
        return;
      }
    }
    finish();
  }

  public void onDismiss(DialogInterface paramDialogInterface)
  {
    finish();
  }

  public static enum VKServiceType
  {
    private int outerCode;

    static
    {
      VKServiceType[] arrayOfVKServiceType = new VKServiceType[3];
      arrayOfVKServiceType[0] = Authorization;
      arrayOfVKServiceType[1] = Captcha;
      arrayOfVKServiceType[2] = Validation;
    }

    private VKServiceType(int paramInt)
    {
      this.outerCode = paramInt;
    }

    public int getOuterCode()
    {
      return this.outerCode;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.VKServiceActivity
 * JD-Core Version:    0.6.2
 */