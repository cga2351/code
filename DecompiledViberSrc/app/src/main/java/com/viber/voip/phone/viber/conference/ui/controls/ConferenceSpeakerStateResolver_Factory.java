package com.viber.voip.phone.viber.conference.ui.controls;

import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.registration.HardwareParameters;
import com.viber.voip.sound.ISoundService;
import dagger.a.d;
import javax.inject.Provider;

public final class ConferenceSpeakerStateResolver_Factory
  implements d<ConferenceSpeakerStateResolver>
{
  private final Provider<CallHandler> callHandlerProvider;
  private final Provider<HardwareParameters> hardwareParametersProvider;
  private final Provider<ISoundService> soundServiceProvider;

  public ConferenceSpeakerStateResolver_Factory(Provider<CallHandler> paramProvider, Provider<ISoundService> paramProvider1, Provider<HardwareParameters> paramProvider2)
  {
    this.callHandlerProvider = paramProvider;
    this.soundServiceProvider = paramProvider1;
    this.hardwareParametersProvider = paramProvider2;
  }

  public static ConferenceSpeakerStateResolver_Factory create(Provider<CallHandler> paramProvider, Provider<ISoundService> paramProvider1, Provider<HardwareParameters> paramProvider2)
  {
    return new ConferenceSpeakerStateResolver_Factory(paramProvider, paramProvider1, paramProvider2);
  }

  public ConferenceSpeakerStateResolver get()
  {
    return new ConferenceSpeakerStateResolver((CallHandler)this.callHandlerProvider.get(), (ISoundService)this.soundServiceProvider.get(), (HardwareParameters)this.hardwareParametersProvider.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.ui.controls.ConferenceSpeakerStateResolver_Factory
 * JD-Core Version:    0.6.2
 */