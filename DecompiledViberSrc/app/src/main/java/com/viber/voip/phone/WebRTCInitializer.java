package com.viber.voip.phone;

import com.viber.common.a.e.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import org.webrtc.Logging.Severity;
import org.webrtc.PeerConnectionFactory;
import org.webrtc.PeerConnectionFactory.InitializationOptions;
import org.webrtc.PeerConnectionFactory.InitializationOptions.Builder;

public final class WebRTCInitializer
{
  private static final Logger L = ViberEnv.getLogger();
  private static String[] fieldTrialsList = { "WebRTC-NetEqOpusDtxDelayFix", "Enabled", "" };
  private static boolean isInitialized = false;

  public static void ensureInitialized()
  {
    try
    {
      boolean bool = isInitialized;
      if (bool);
      while (true)
      {
        return;
        PeerConnectionFactory.initialize(PeerConnectionFactory.InitializationOptions.builder(ViberApplication.getApplication()).createInitializationOptions());
        isInitialized = true;
      }
    }
    finally
    {
    }
  }

  private static e.a getLogLevelBySeverity(Logging.Severity paramSeverity)
  {
    switch (1.$SwitchMap$org$webrtc$Logging$Severity[paramSeverity.ordinal()])
    {
    default:
      return e.a.f;
    case 1:
      return e.a.c;
    case 2:
      return e.a.a;
    case 3:
      return e.a.b;
    case 4:
      return e.a.d;
    case 5:
      return e.a.e;
    case 6:
    }
    return e.a.f;
  }

  private static Logging.Severity getSeverityByLogLevel(e.a parama)
  {
    switch (1.$SwitchMap$com$viber$common$logger$Logger$LogLevel[parama.ordinal()])
    {
    default:
      return Logging.Severity.LS_NONE;
    case 1:
      return Logging.Severity.LS_INFO;
    case 2:
      return Logging.Severity.LS_VERBOSE;
    case 3:
      return Logging.Severity.LS_SENSITIVE;
    case 4:
      return Logging.Severity.LS_WARNING;
    case 5:
      return Logging.Severity.LS_ERROR;
    case 6:
    }
    return Logging.Severity.LS_NONE;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.WebRTCInitializer
 * JD-Core Version:    0.6.2
 */