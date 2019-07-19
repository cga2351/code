package com.viber.voip.settings.ui;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.Preference.b;
import android.widget.Toast;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.jni.DeviceFlagsManager;
import com.viber.jni.Engine;
import com.viber.jni.Engine.InitializedListener;
import com.viber.voip.R.string;
import com.viber.voip.R.xml;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.av;
import com.viber.voip.sound.ISoundService;
import com.viber.voip.sound.NativeMediaDelegate;
import com.viber.voip.sound.config.IAudioSettings;
import com.viber.voip.sound.config.IAudioSettings.AudioModeCtl;
import com.viber.voip.sound.config.IAudioSettings.IAudioSettingsListener;
import com.viber.voip.sound.config.IVocoderSettings;
import com.viber.voip.sound.config.IVocoderSettings.IVocoderDescriptor;
import com.viber.voip.sound.config.IVocoderSettings.VocoderCtl;
import com.viber.voip.sound.config.SoundConfig;
import com.viber.voip.sound.hacks.HtcHwConfig.HtcHwCtl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.webrtc.videoengine.ViEVideoSupport;
import org.webrtc.voiceengine.NativeADMCtl;

public class ai extends SettingsHeadersActivity.a
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  private static final Logger b = ViberEnv.getLogger();
  private IAudioSettings c;
  private IAudioSettings d;
  private IAudioSettings.IAudioSettingsListener e = new IAudioSettings.IAudioSettingsListener()
  {
    public void onAECChange(int paramAnonymousInt1, final int paramAnonymousInt2)
    {
      ViberApplication.getInstance().getEngine(false).addInitializedListener(new Engine.InitializedListener()
      {
        public void initialized(Engine paramAnonymous2Engine)
        {
          DeviceFlagsManager._AECmode = paramAnonymousInt2;
          NativeMediaDelegate.setSpeechEnhancementsModes(DeviceFlagsManager._AECmode, DeviceFlagsManager._AGCmode, DeviceFlagsManager._NSmode, DeviceFlagsManager._RxAGCmode, DeviceFlagsManager._RxNSmode);
        }
      });
    }

    public void onAGCChange(int paramAnonymousInt1, final int paramAnonymousInt2)
    {
      ViberApplication.getInstance().getEngine(false).addInitializedListener(new Engine.InitializedListener()
      {
        public void initialized(Engine paramAnonymous2Engine)
        {
          DeviceFlagsManager._AGCmode = paramAnonymousInt2;
          NativeMediaDelegate.setSpeechEnhancementsModes(DeviceFlagsManager._AECmode, DeviceFlagsManager._AGCmode, DeviceFlagsManager._NSmode, DeviceFlagsManager._RxAGCmode, DeviceFlagsManager._RxNSmode);
        }
      });
    }

    public void onNSChange(int paramAnonymousInt1, final int paramAnonymousInt2)
    {
      ViberApplication.getInstance().getEngine(false).addInitializedListener(new Engine.InitializedListener()
      {
        public void initialized(Engine paramAnonymous2Engine)
        {
          DeviceFlagsManager._NSmode = paramAnonymousInt2;
          NativeMediaDelegate.setSpeechEnhancementsModes(DeviceFlagsManager._AECmode, DeviceFlagsManager._AGCmode, DeviceFlagsManager._NSmode, DeviceFlagsManager._RxAGCmode, DeviceFlagsManager._RxNSmode);
        }
      });
    }

    public void onRxAGCChange(int paramAnonymousInt1, final int paramAnonymousInt2)
    {
      ViberApplication.getInstance().getEngine(false).addInitializedListener(new Engine.InitializedListener()
      {
        public void initialized(Engine paramAnonymous2Engine)
        {
          DeviceFlagsManager._RxAGCmode = paramAnonymousInt2;
          NativeMediaDelegate.setSpeechEnhancementsModes(DeviceFlagsManager._AECmode, DeviceFlagsManager._AGCmode, DeviceFlagsManager._NSmode, DeviceFlagsManager._RxAGCmode, DeviceFlagsManager._RxNSmode);
        }
      });
    }

    public void onRxNSChange(int paramAnonymousInt1, final int paramAnonymousInt2)
    {
      ViberApplication.getInstance().getEngine(false).addInitializedListener(new Engine.InitializedListener()
      {
        public void initialized(Engine paramAnonymous2Engine)
        {
          DeviceFlagsManager._RxNSmode = paramAnonymousInt2;
          NativeMediaDelegate.setSpeechEnhancementsModes(DeviceFlagsManager._AECmode, DeviceFlagsManager._AGCmode, DeviceFlagsManager._NSmode, DeviceFlagsManager._RxAGCmode, DeviceFlagsManager._RxNSmode);
        }
      });
    }

    public void onVADChange(int paramAnonymousInt1, int paramAnonymousInt2)
    {
    }
  };

  protected void a(NativeADMCtl paramNativeADMCtl, int paramInt)
  {
    int i = 1;
    int j = paramNativeADMCtl.getAvailableFeaturesMask(paramInt);
    int k = paramNativeADMCtl.getFeaturesMask(paramInt);
    ListPreference localListPreference1 = (ListPreference)a(d.av.b.c());
    int i1;
    label60: label93: int i4;
    label111: int i7;
    label144: label162: label197: int i10;
    label217: label252: int i13;
    label272: ListPreference localListPreference6;
    if (i == (j & 0x1))
    {
      int m = i;
      localListPreference1.a(m);
      if (i != (k & 0x1))
        break label337;
      i1 = i;
      localListPreference1.b(i1);
      ListPreference localListPreference2 = (ListPreference)a(d.av.c.c());
      if (2 != (j & 0x2))
        break label343;
      int i2 = i;
      localListPreference2.a(i2);
      if (2 != (k & 0x2))
        break label349;
      i4 = i;
      localListPreference2.b(i4);
      ListPreference localListPreference3 = (ListPreference)a(d.av.d.c());
      if (4 != (j & 0x4))
        break label355;
      int i5 = i;
      localListPreference3.a(i5);
      if (4 != (k & 0x4))
        break label361;
      i7 = i;
      localListPreference3.b(i7);
      ListPreference localListPreference4 = (ListPreference)a(d.av.e.c());
      if (8 != (j & 0x8))
        break label367;
      int i8 = i;
      localListPreference4.a(i8);
      if (8 != (k & 0x8))
        break label373;
      i10 = i;
      localListPreference4.b(i10);
      ListPreference localListPreference5 = (ListPreference)a(d.av.f.c());
      if (16 != (j & 0x10))
        break label379;
      int i11 = i;
      localListPreference5.a(i11);
      if (16 != (k & 0x10))
        break label385;
      i13 = i;
      localListPreference5.b(i13);
      localListPreference6 = (ListPreference)a(d.av.g.c());
      if (32 != (j & 0x20))
        break label391;
      int i14 = i;
      label307: localListPreference6.a(i14);
      if (32 != (k & 0x20))
        break label397;
    }
    while (true)
    {
      localListPreference6.b(i);
      return;
      int n = 0;
      break;
      label337: i1 = 0;
      break label60;
      label343: int i3 = 0;
      break label93;
      label349: i4 = 0;
      break label111;
      label355: int i6 = 0;
      break label144;
      label361: i7 = 0;
      break label162;
      label367: int i9 = 0;
      break label197;
      label373: i10 = 0;
      break label217;
      label379: int i12 = 0;
      break label252;
      label385: i13 = 0;
      break label272;
      label391: int i15 = 0;
      break label307;
      label397: i = 0;
    }
  }

  public void b(Bundle paramBundle, String paramString)
  {
    a(R.xml.sound_settings, paramString);
  }

  public void i()
  {
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    ((AppCompatActivity)getActivity()).getSupportActionBar().a("Sound settings");
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    final NativeADMCtl localNativeADMCtl = NativeADMCtl.getInstance();
    SoundConfig localSoundConfig = ViberApplication.getInstance().getSoundService().getSoundConfig();
    this.c = localSoundConfig.getAudioSettings(IAudioSettings.AudioModeCtl.MODE_EARPIECE.ordinal());
    this.c.addListener(this.e);
    int i = this.c.getAECMode();
    int j = this.c.getAGCMode();
    int k = this.c.getRxAGCMode();
    int m = this.c.getNSMode();
    int n = this.c.getRxNSMode();
    int i1 = this.c.getVADMode();
    d.av.m.a(String.valueOf(i));
    d.av.l.a(String.valueOf(j));
    d.av.k.a(String.valueOf(k));
    d.av.j.a(String.valueOf(m));
    d.av.i.a(String.valueOf(n));
    d.av.h.a(String.valueOf(i1));
    this.d = localSoundConfig.getAudioSettings(IAudioSettings.AudioModeCtl.MODE_LOUDSPEAKER.ordinal());
    int i2 = this.d.getAECMode();
    int i3 = this.d.getAGCMode();
    int i4 = this.d.getRxAGCMode();
    int i5 = this.d.getNSMode();
    int i6 = this.d.getRxNSMode();
    int i7 = this.d.getVADMode();
    d.av.s.a(String.valueOf(i2));
    d.av.r.a(String.valueOf(i3));
    d.av.q.a(String.valueOf(i4));
    d.av.p.a(String.valueOf(i5));
    d.av.o.a(String.valueOf(i6));
    d.av.n.a(String.valueOf(i7));
    if (localNativeADMCtl.isNativeDriverAvailable())
      d.av.a.a("2");
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    while (true)
    {
      a(localNativeADMCtl, Integer.parseInt(d.av.a.d()));
      ListPreference localListPreference1 = (ListPreference)a(d.av.a.c());
      localListPreference1.a(localNativeADMCtl.isInitialized());
      localListPreference1.a(new Preference.b()
      {
        public boolean a(Preference paramAnonymousPreference, Object paramAnonymousObject)
        {
          int i = Integer.parseInt((String)paramAnonymousObject);
          if (i != (i & localNativeADMCtl.getDeviceMask()))
          {
            Toast.makeText(ai.this.getActivity().getApplicationContext(), R.string.audio_driver_unsupported, 1).show();
            return false;
          }
          localNativeADMCtl.setDeviceMask(i);
          ai.this.a(localNativeADMCtl, i);
          return true;
        }
      });
      localArrayList1 = new ArrayList();
      localArrayList1.add("Default (selected by server)");
      localArrayList2 = new ArrayList();
      localArrayList2.add("-1");
      Iterator localIterator = localSoundConfig.getVocoderSettings().getSupportedCodecs().iterator();
      while (localIterator.hasNext())
      {
        IVocoderSettings.IVocoderDescriptor localIVocoderDescriptor = (IVocoderSettings.IVocoderDescriptor)localIterator.next();
        localArrayList1.add(localIVocoderDescriptor.getVocoderName());
        localArrayList2.add(String.valueOf(localIVocoderDescriptor.getVocoderId()));
      }
      if (localNativeADMCtl.isOpenSLESDriverAvailable())
        d.av.a.a("1");
      else
        d.av.a.a("4");
    }
    ListPreference localListPreference2 = (ListPreference)a(d.av.t.c());
    localListPreference2.a((CharSequence[])localArrayList1.toArray(new CharSequence[localArrayList1.size()]));
    localListPreference2.b((CharSequence[])localArrayList2.toArray(new CharSequence[localArrayList2.size()]));
    ((ListPreference)a(d.av.y.c())).a(HtcHwConfig.HtcHwCtl.ctlHwAecSupported());
    ListPreference localListPreference3 = (ListPreference)a(d.av.z.c());
    boolean bool1;
    ListPreference localListPreference4;
    if ((ViEVideoSupport.isVideoCallSupported()) && (ViEVideoSupport.isH264Available()))
    {
      bool1 = true;
      localListPreference3.a(bool1);
      localListPreference4 = (ListPreference)a(d.av.A.c());
      if ((!ViEVideoSupport.isVideoCallSupported()) || (!ViEVideoSupport.isVP9Available()))
        break label802;
    }
    label802: for (boolean bool2 = true; ; bool2 = false)
    {
      localListPreference4.a(bool2);
      final CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)a(d.av.x.c());
      localCheckBoxPreference.f(false);
      localCheckBoxPreference.a(true);
      localCheckBoxPreference.a(new Preference.b()
      {
        public boolean a(Preference paramAnonymousPreference, Object paramAnonymousObject)
        {
          localCheckBoxPreference.a(false);
          localCheckBoxPreference.f(true);
          return true;
        }
      });
      ((ListPreference)a(d.av.w.c())).b("0");
      ((ListPreference)a(d.av.v.c())).b("0");
      ((ListPreference)a(d.av.u.c())).b("0");
      return;
      bool1 = false;
      break;
    }
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    this.c.removeListener(this.e);
  }

  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    NativeADMCtl localNativeADMCtl = NativeADMCtl.getInstance();
    int i = Integer.valueOf(d.av.a.d()).intValue();
    if (paramString.equals(d.av.a.c()));
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramString.equals(d.av.b.c()))
            {
              if (Integer.valueOf(d.av.b.d()).intValue() == 0);
              for (int i15 = 0xFFFFFFFE & localNativeADMCtl.getFeaturesMask(i); ; i15 = 0x1 | localNativeADMCtl.getFeaturesMask(i))
              {
                localNativeADMCtl.setFeaturesMask(i, i15);
                return;
              }
            }
            if (paramString.equals(d.av.c.c()))
            {
              if (Integer.valueOf(d.av.c.d()).intValue() == 0);
              for (int i14 = 0xFFFFFFFD & localNativeADMCtl.getFeaturesMask(i); ; i14 = 0x2 | localNativeADMCtl.getFeaturesMask(i))
              {
                localNativeADMCtl.setFeaturesMask(i, i14);
                return;
              }
            }
            if (paramString.equals(d.av.d.c()))
            {
              if (Integer.valueOf(d.av.d.d()).intValue() == 0);
              for (int i13 = 0xFFFFFFFB & localNativeADMCtl.getFeaturesMask(i); ; i13 = 0x4 | localNativeADMCtl.getFeaturesMask(i))
              {
                localNativeADMCtl.setFeaturesMask(i, i13);
                return;
              }
            }
            if (paramString.equals(d.av.e.c()))
            {
              if (Integer.valueOf(d.av.e.d()).intValue() == 0);
              for (int i12 = 0xFFFFFFF7 & localNativeADMCtl.getFeaturesMask(i); ; i12 = 0x8 | localNativeADMCtl.getFeaturesMask(i))
              {
                localNativeADMCtl.setFeaturesMask(i, i12);
                return;
              }
            }
            if (paramString.equals(d.av.f.c()))
            {
              if (Integer.valueOf(d.av.f.d()).intValue() == 0);
              for (int i11 = 0xFFFFFFEF & localNativeADMCtl.getFeaturesMask(i); ; i11 = 0x10 | localNativeADMCtl.getFeaturesMask(i))
              {
                localNativeADMCtl.setFeaturesMask(i, i11);
                return;
              }
            }
            if (paramString.equals(d.av.g.c()))
            {
              if (Integer.valueOf(d.av.g.d()).intValue() == 0);
              for (int i10 = 0xFFFFFFDF & localNativeADMCtl.getFeaturesMask(i); ; i10 = 0x20 | localNativeADMCtl.getFeaturesMask(i))
              {
                localNativeADMCtl.setFeaturesMask(i, i10);
                return;
              }
            }
            if (paramString.equals(d.av.m))
            {
              int i9 = Integer.valueOf(d.av.m.d()).intValue();
              this.c.setAECMode(i9);
              return;
            }
            if (paramString.equals(d.av.l.c()))
            {
              int i8 = Integer.valueOf(d.av.l.d()).intValue();
              this.c.setAGCMode(i8);
              return;
            }
            if (paramString.equals(d.av.k.c()))
            {
              int i7 = Integer.valueOf(d.av.k.d()).intValue();
              this.c.setRxAGCMode(i7);
              return;
            }
            if (paramString.equals(d.av.j.c()))
            {
              int i6 = Integer.valueOf(d.av.j.d()).intValue();
              this.c.setNSMode(i6);
              return;
            }
            if (paramString.equals(d.av.i.c()))
            {
              int i5 = Integer.valueOf(d.av.i.d()).intValue();
              this.c.setRxNSMode(i5);
              return;
            }
            if (paramString.equals(d.av.h.c()))
            {
              int i4 = Integer.valueOf(d.av.h.d()).intValue();
              this.c.setVADMode(i4);
              return;
            }
            if (paramString.equals(d.av.s.c()))
            {
              int i3 = Integer.valueOf(d.av.s.d()).intValue();
              this.d.setAECMode(i3);
              return;
            }
            if (paramString.equals(d.av.r.c()))
            {
              int i2 = Integer.valueOf(d.av.r.d()).intValue();
              this.d.setAGCMode(i2);
              return;
            }
            if (paramString.equals(d.av.q.c()))
            {
              int i1 = Integer.valueOf(d.av.q.d()).intValue();
              this.d.setRxAGCMode(i1);
              return;
            }
            if (paramString.equals(d.av.p.c()))
            {
              int n = Integer.valueOf(d.av.p.d()).intValue();
              this.d.setNSMode(n);
              return;
            }
            if (paramString.equals(d.av.o.c()))
            {
              int m = Integer.valueOf(d.av.o.d()).intValue();
              this.d.setRxNSMode(m);
              return;
            }
            if (paramString.equals(d.av.n.c()))
            {
              int k = Integer.valueOf(d.av.n.d()).intValue();
              this.d.setVADMode(k);
              return;
            }
            if (paramString.equals(d.av.t.c()))
            {
              int j = Integer.valueOf(d.av.t.d()).intValue();
              ViberApplication.getInstance().getSoundService().getSoundConfig().setVocoderCtl(IVocoderSettings.VocoderCtl.VOECTL_FORCE_CODEC, j, j);
              return;
            }
          }
          while (paramString.equals(d.av.y.c()));
          if (!d.av.u.c().equals(paramString))
            break;
        }
        while (Integer.valueOf(d.av.u.d()).intValue() == 0);
        return;
        if (!d.av.v.c().equals(paramString))
          break;
      }
      while (Integer.valueOf(d.av.v.d()).intValue() == 0);
      return;
    }
    while ((!d.av.w.c().equals(paramString)) || (Integer.valueOf(d.av.w.d()).intValue() == 0));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.ai
 * JD-Core Version:    0.6.2
 */