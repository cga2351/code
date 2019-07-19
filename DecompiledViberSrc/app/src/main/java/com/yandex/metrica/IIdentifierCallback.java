package com.yandex.metrica;

import java.util.Map;

public abstract interface IIdentifierCallback
{
  public static final String APP_METRICA_DEVICE_ID_HASH = "appmetrica_device_id_hash";
  public static final String YANDEX_MOBILE_METRICA_DEVICE_ID = "yandex_mobile_metrica_device_id";
  public static final String YANDEX_MOBILE_METRICA_GET_AD_URL = "yandex_mobile_metrica_get_ad_url";
  public static final String YANDEX_MOBILE_METRICA_REPORT_AD_URL = "yandex_mobile_metrica_report_ad_url";
  public static final String YANDEX_MOBILE_METRICA_UUID = "yandex_mobile_metrica_uuid";

  public abstract void onReceive(Map<String, String> paramMap);

  public abstract void onRequestError(Reason paramReason);

  public static enum Reason
  {
    static
    {
      NETWORK = new Reason("NETWORK", 1);
      INVALID_RESPONSE = new Reason("INVALID_RESPONSE", 2);
      Reason[] arrayOfReason = new Reason[3];
      arrayOfReason[0] = UNKNOWN;
      arrayOfReason[1] = NETWORK;
      arrayOfReason[2] = INVALID_RESPONSE;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.IIdentifierCallback
 * JD-Core Version:    0.6.2
 */