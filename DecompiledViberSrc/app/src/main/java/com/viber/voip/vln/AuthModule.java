package com.viber.voip.vln;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.viber.voip.billing.ac;
import com.viber.voip.billing.ad;
import com.viber.voip.billing.ae;
import com.viber.voip.billing.af;
import com.viber.voip.billing.i;

public class AuthModule extends ReactContextBaseJavaModule
{
  private static final String MODULE_NAME = "Auth";
  private final String mMemberId;
  private final String mRegNumberCanonized;

  public AuthModule(ReactApplicationContext paramReactApplicationContext, String paramString1, String paramString2)
  {
    super(paramReactApplicationContext);
    this.mMemberId = paramString1;
    this.mRegNumberCanonized = paramString2;
  }

  public String getName()
  {
    return "Auth";
  }

  @ReactMethod
  void getParams(final Promise paramPromise)
  {
    i.a().a(new ad()
    {
      public void a(ac paramAnonymousac)
      {
        WritableNativeMap localWritableNativeMap = new WritableNativeMap();
        localWritableNativeMap.putString("member_id", AuthModule.this.mMemberId);
        localWritableNativeMap.putString("phone_number", AuthModule.this.mRegNumberCanonized);
        localWritableNativeMap.putDouble("timestamp", paramAnonymousac.a);
        localWritableNativeMap.putString("token", paramAnonymousac.b);
        paramPromise.resolve(localWritableNativeMap);
      }

      public void a(ae paramAnonymousae)
      {
        paramPromise.reject("NETWORK_ERROR", "Unable to obtain web token");
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.vln.AuthModule
 * JD-Core Version:    0.6.2
 */