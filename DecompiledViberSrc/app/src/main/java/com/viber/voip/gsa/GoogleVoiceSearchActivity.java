package com.viber.voip.gsa;

import com.google.android.search.verification.client.SearchActionVerificationClientActivity;
import com.google.android.search.verification.client.SearchActionVerificationClientService;

public class GoogleVoiceSearchActivity extends SearchActionVerificationClientActivity
{
  public Class<? extends SearchActionVerificationClientService> a()
  {
    return GoogleVoiceSearchService.class;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gsa.GoogleVoiceSearchActivity
 * JD-Core Version:    0.6.2
 */