package com.viber.voip.camera.fragment;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog.Builder;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceFragment;
import android.preference.PreferenceGroup;
import android.preference.PreferenceManager;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import com.viber.voip.camera.R.string;
import com.viber.voip.camera.R.xml;
import com.viber.voip.camera.activity.ViberCcamActivity;

public class ViberCcamInternalPreferences extends PreferenceFragment
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  private static final String a = com.viber.voip.camera.e.a.a(ViberCcamInternalPreferences.class);

  public final Activity a()
  {
    return getActivity();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    PreferenceManager localPreferenceManager = getPreferenceManager();
    localPreferenceManager.setSharedPreferencesName("com_viber_voip_camera_pref_file");
    localPreferenceManager.setSharedPreferencesMode(0);
    addPreferencesFromResource(R.xml.preferences);
    final Bundle localBundle = a().getIntent().getExtras();
    final int i = localBundle.getInt("cameraId");
    final String str1 = localBundle.getString("camera_api");
    final SharedPreferences localSharedPreferences = com.viber.voip.camera.d.a.a(getActivity());
    final boolean bool1 = localBundle.getBoolean("supports_auto_stabilise");
    final boolean bool2 = localBundle.getBoolean("supports_face_detection");
    if (!bool2)
    {
      Preference localPreference13 = findPreference("preference_face_detection");
      ((PreferenceGroup)findPreference("preference_category_camera_effects")).removePreference(localPreference13);
    }
    final int j = localBundle.getInt("preview_width");
    final int k = localBundle.getInt("preview_height");
    final int[] arrayOfInt1 = localBundle.getIntArray("preview_widths");
    final int[] arrayOfInt2 = localBundle.getIntArray("preview_heights");
    final int[] arrayOfInt3 = localBundle.getIntArray("video_widths");
    final int[] arrayOfInt4 = localBundle.getIntArray("video_heights");
    final int m = localBundle.getInt("resolution_width");
    final int n = localBundle.getInt("resolution_height");
    final int[] arrayOfInt5 = localBundle.getIntArray("resolution_widths");
    final int[] arrayOfInt6 = localBundle.getIntArray("resolution_heights");
    if ((arrayOfInt5 != null) && (arrayOfInt6 != null))
    {
      CharSequence[] arrayOfCharSequence5 = new CharSequence[arrayOfInt5.length];
      CharSequence[] arrayOfCharSequence6 = new CharSequence[arrayOfInt5.length];
      for (int i7 = 0; i7 < arrayOfInt5.length; i7++)
      {
        arrayOfCharSequence5[i7] = (arrayOfInt5[i7] + " x " + arrayOfInt6[i7] + " " + com.viber.voip.camera.c.b.b(arrayOfInt5[i7], arrayOfInt6[i7]));
        arrayOfCharSequence6[i7] = (arrayOfInt5[i7] + " " + arrayOfInt6[i7]);
      }
      ListPreference localListPreference3 = (ListPreference)findPreference("preference_resolution");
      localListPreference3.setEntries(arrayOfCharSequence5);
      localListPreference3.setEntryValues(arrayOfCharSequence6);
      String str4 = com.viber.voip.camera.d.a.b(i);
      localListPreference3.setValue(localSharedPreferences.getString(str4, ""));
      localListPreference3.setKey(str4);
    }
    CharSequence[] arrayOfCharSequence1;
    CharSequence[] arrayOfCharSequence2;
    while (true)
    {
      arrayOfCharSequence1 = new CharSequence[100];
      arrayOfCharSequence2 = new CharSequence[100];
      for (int i1 = 0; i1 < 100; i1++)
      {
        arrayOfCharSequence1[i1] = ("" + (i1 + 1) + "%");
        arrayOfCharSequence2[i1] = ("" + (i1 + 1));
      }
      Preference localPreference1 = findPreference("preference_resolution");
      ((PreferenceGroup)findPreference("preference_screen_photo_settings")).removePreference(localPreference1);
    }
    ListPreference localListPreference1 = (ListPreference)findPreference("preference_quality");
    localListPreference1.setEntries(arrayOfCharSequence1);
    localListPreference1.setEntryValues(arrayOfCharSequence2);
    final String[] arrayOfString1 = localBundle.getStringArray("video_quality");
    String[] arrayOfString2 = localBundle.getStringArray("video_quality_string");
    final String str2;
    final int i2;
    final int i3;
    final int i4;
    final int i5;
    final boolean bool3;
    if ((arrayOfString1 != null) && (arrayOfString2 != null))
    {
      CharSequence[] arrayOfCharSequence3 = new CharSequence[arrayOfString1.length];
      CharSequence[] arrayOfCharSequence4 = new CharSequence[arrayOfString1.length];
      for (int i6 = 0; i6 < arrayOfString1.length; i6++)
      {
        arrayOfCharSequence3[i6] = arrayOfString2[i6];
        arrayOfCharSequence4[i6] = arrayOfString1[i6];
      }
      ListPreference localListPreference2 = (ListPreference)findPreference("preference_video_quality");
      localListPreference2.setEntries(arrayOfCharSequence3);
      localListPreference2.setEntryValues(arrayOfCharSequence4);
      String str3 = com.viber.voip.camera.d.a.c(i);
      localListPreference2.setValue(localSharedPreferences.getString(str3, ""));
      localListPreference2.setKey(str3);
      str2 = localBundle.getString("current_video_quality");
      i2 = localBundle.getInt("video_frame_width");
      i3 = localBundle.getInt("video_frame_height");
      i4 = localBundle.getInt("video_bit_rate");
      i5 = localBundle.getInt("video_frame_rate");
      if ((!localBundle.getBoolean("supports_force_video_4k")) || (arrayOfString1 == null) || (arrayOfString2 == null))
      {
        Preference localPreference3 = findPreference("preference_force_video_4k");
        ((PreferenceGroup)findPreference("preference_screen_video_settings")).removePreference(localPreference3);
      }
      bool3 = localBundle.getBoolean("supports_video_stabilization");
      if (!bool3)
      {
        Preference localPreference12 = findPreference("preference_video_stabilization");
        ((PreferenceGroup)findPreference("preference_screen_video_settings")).removePreference(localPreference12);
      }
      boolean bool4 = localBundle.getBoolean("can_disable_shutter_sound");
      if ((Build.VERSION.SDK_INT < 17) || (!bool4))
      {
        Preference localPreference4 = findPreference("preference_shutter_sound");
        ((PreferenceGroup)findPreference("preference_screen_camera_controls_more")).removePreference(localPreference4);
      }
      Preference localPreference5 = findPreference("preference_show_iso");
      ((PreferenceGroup)findPreference("preference_screen_gui")).removePreference(localPreference5);
      if (!localBundle.getBoolean("supports_camera2"))
        break label1042;
      final Preference localPreference11 = findPreference("preference_use_camera2");
      localPreference11.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
      {
        public boolean onPreferenceClick(Preference paramAnonymousPreference)
        {
          if (localPreference11.getKey().equals("preference_use_camera2"))
          {
            Intent localIntent = ViberCcamInternalPreferences.this.getActivity().getBaseContext().getPackageManager().getLaunchIntentForPackage(ViberCcamInternalPreferences.this.getActivity().getBaseContext().getPackageName());
            localIntent.addFlags(67108864);
            ViberCcamInternalPreferences.this.startActivity(localIntent);
          }
          return false;
        }
      });
      label870: findPreference("preference_save_location").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
      {
        public boolean onPreferenceClick(Preference paramAnonymousPreference)
        {
          if (com.viber.voip.camera.b.b.a(ViberCcamInternalPreferences.this.a()))
          {
            ViberCcamActivity.a(ViberCcamInternalPreferences.this.a());
            return true;
          }
          new com.viber.voip.camera.f.a().show(ViberCcamInternalPreferences.this.getFragmentManager(), "FOLDER_FRAGMENT");
          return true;
        }
      });
      if (Build.VERSION.SDK_INT >= 21)
        break label1069;
      Preference localPreference10 = findPreference("preference_using_saf");
      ((PreferenceGroup)findPreference("preference_screen_camera_controls_more")).removePreference(localPreference10);
    }
    while (true)
    {
      final Preference localPreference8 = findPreference("preference_about");
      localPreference8.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
      {
        public boolean onPreferenceClick(Preference paramAnonymousPreference)
        {
          AlertDialog.Builder localBuilder;
          final StringBuilder localStringBuilder;
          String str1;
          int i1;
          if (localPreference8.getKey().equals("preference_about"))
          {
            localBuilder = new AlertDialog.Builder(ViberCcamInternalPreferences.this.getActivity());
            localBuilder.setTitle("About");
            localStringBuilder = new StringBuilder();
            str1 = "UNKNOWN_VERSION";
            i1 = -1;
          }
          try
          {
            PackageInfo localPackageInfo = ViberCcamInternalPreferences.this.getActivity().getPackageManager().getPackageInfo(ViberCcamInternalPreferences.this.getActivity().getPackageName(), 0);
            str1 = localPackageInfo.versionName;
            i1 = localPackageInfo.versionCode;
            label93: localStringBuilder.append("Camera v");
            localStringBuilder.append(str1);
            localStringBuilder.append("\nVersion Code: ");
            localStringBuilder.append(i1);
            localStringBuilder.append("\nPackage: ");
            localStringBuilder.append(ViberCcamInternalPreferences.this.getActivity().getPackageName());
            localStringBuilder.append("\nAndroid API version: ");
            localStringBuilder.append(Build.VERSION.SDK_INT);
            localStringBuilder.append("\nDevice manufacturer: ");
            localStringBuilder.append(Build.MANUFACTURER);
            localStringBuilder.append("\nDevice model: ");
            localStringBuilder.append(Build.MODEL);
            localStringBuilder.append("\nDevice code-name: ");
            localStringBuilder.append(Build.HARDWARE);
            localStringBuilder.append("\nDevice variant: ");
            localStringBuilder.append(Build.DEVICE);
            ActivityManager localActivityManager = (ActivityManager)ViberCcamInternalPreferences.this.getActivity().getSystemService("activity");
            localStringBuilder.append("\nStandard max heap? (MB): ");
            localStringBuilder.append(localActivityManager.getMemoryClass());
            localStringBuilder.append("\nLarge max heap? (MB): ");
            localStringBuilder.append(localActivityManager.getLargeMemoryClass());
            Point localPoint = new Point();
            ViberCcamInternalPreferences.this.getActivity().getWindowManager().getDefaultDisplay().getSize(localPoint);
            localStringBuilder.append("\nDisplay size: ");
            localStringBuilder.append(localPoint.x);
            localStringBuilder.append("x");
            localStringBuilder.append(localPoint.y);
            localStringBuilder.append("\nCurrent camera ID: ");
            localStringBuilder.append(i);
            localStringBuilder.append("\nCamera API: ");
            localStringBuilder.append(str1);
            if ((arrayOfInt1 != null) && (arrayOfInt2 != null))
            {
              localStringBuilder.append("\nPreview resolutions: ");
              for (int i14 = 0; i14 < arrayOfInt1.length; i14++)
              {
                if (i14 > 0)
                  localStringBuilder.append(", ");
                localStringBuilder.append(arrayOfInt1[i14]);
                localStringBuilder.append("x");
                localStringBuilder.append(arrayOfInt2[i14]);
              }
            }
            localStringBuilder.append("\nPreview resolution: " + j + "x" + k);
            if ((arrayOfInt5 != null) && (arrayOfInt6 != null))
            {
              localStringBuilder.append("\nPhoto resolutions: ");
              for (int i13 = 0; i13 < arrayOfInt5.length; i13++)
              {
                if (i13 > 0)
                  localStringBuilder.append(", ");
                localStringBuilder.append(arrayOfInt5[i13]);
                localStringBuilder.append("x");
                localStringBuilder.append(arrayOfInt6[i13]);
              }
            }
            localStringBuilder.append("\nPhoto resolution: " + m + "x" + n);
            if (arrayOfString1 != null)
            {
              localStringBuilder.append("\nVideo qualities: ");
              for (int i12 = 0; i12 < arrayOfString1.length; i12++)
              {
                if (i12 > 0)
                  localStringBuilder.append(", ");
                localStringBuilder.append(arrayOfString1[i12]);
              }
            }
            if ((arrayOfInt3 != null) && (arrayOfInt4 != null))
            {
              localStringBuilder.append("\nVideo resolutions: ");
              for (int i11 = 0; i11 < arrayOfInt3.length; i11++)
              {
                if (i11 > 0)
                  localStringBuilder.append(", ");
                localStringBuilder.append(arrayOfInt3[i11]);
                localStringBuilder.append("x");
                localStringBuilder.append(arrayOfInt4[i11]);
              }
            }
            localStringBuilder.append("\nVideo quality: " + str2);
            localStringBuilder.append("\nVideo frame width: " + i2);
            localStringBuilder.append("\nVideo frame height: " + i3);
            localStringBuilder.append("\nVideo bit rate: " + i4);
            localStringBuilder.append("\nVideo frame rate: " + i5);
            localStringBuilder.append("\nAuto-stabilise?: ");
            ViberCcamInternalPreferences localViberCcamInternalPreferences1 = ViberCcamInternalPreferences.this;
            int i2;
            int i3;
            label1055: ViberCcamInternalPreferences localViberCcamInternalPreferences3;
            if (bool1)
            {
              i2 = R.string.about_available;
              localStringBuilder.append(localViberCcamInternalPreferences1.getString(i2));
              localStringBuilder.append("\nAuto-stabilise enabled?: " + localSharedPreferences.getBoolean(com.viber.voip.camera.d.a.m(), false));
              localStringBuilder.append("\nFace detection?: ");
              ViberCcamInternalPreferences localViberCcamInternalPreferences2 = ViberCcamInternalPreferences.this;
              if (!bool2)
                break label1190;
              i3 = R.string.about_available;
              localStringBuilder.append(localViberCcamInternalPreferences2.getString(i3));
              localStringBuilder.append("\nVideo stabilization?: ");
              localViberCcamInternalPreferences3 = ViberCcamInternalPreferences.this;
              if (!bool3)
                break label1198;
            }
            label1190: label1198: for (int i4 = R.string.about_available; ; i4 = R.string.about_not_available)
            {
              localStringBuilder.append(localViberCcamInternalPreferences3.getString(i4));
              localStringBuilder.append("\nFlash modes: ");
              String[] arrayOfString1 = localBundle.getStringArray("flash_values");
              if ((arrayOfString1 == null) || (arrayOfString1.length <= 0))
                break label1206;
              for (int i10 = 0; i10 < arrayOfString1.length; i10++)
              {
                if (i10 > 0)
                  localStringBuilder.append(", ");
                localStringBuilder.append(arrayOfString1[i10]);
              }
              i2 = R.string.about_not_available;
              break;
              i3 = R.string.about_not_available;
              break label1055;
            }
            label1206: localStringBuilder.append("None");
            localStringBuilder.append("\nFocus modes: ");
            String[] arrayOfString2 = localBundle.getStringArray("focus_values");
            int i9;
            if ((arrayOfString2 != null) && (arrayOfString2.length > 0))
              i9 = 0;
            while (i9 < arrayOfString2.length)
            {
              if (i9 > 0)
                localStringBuilder.append(", ");
              localStringBuilder.append(arrayOfString2[i9]);
              i9++;
              continue;
              localStringBuilder.append("None");
            }
            localStringBuilder.append("\nColor effects: ");
            String[] arrayOfString3 = localBundle.getStringArray("color_effects");
            int i8;
            if ((arrayOfString3 != null) && (arrayOfString3.length > 0))
              i8 = 0;
            while (i8 < arrayOfString3.length)
            {
              if (i8 > 0)
                localStringBuilder.append(", ");
              localStringBuilder.append(arrayOfString3[i8]);
              i8++;
              continue;
              localStringBuilder.append("None");
            }
            localStringBuilder.append("\nScene modes: ");
            String[] arrayOfString4 = localBundle.getStringArray("scene_modes");
            int i7;
            if ((arrayOfString4 != null) && (arrayOfString4.length > 0))
              i7 = 0;
            while (i7 < arrayOfString4.length)
            {
              if (i7 > 0)
                localStringBuilder.append(", ");
              localStringBuilder.append(arrayOfString4[i7]);
              i7++;
              continue;
              localStringBuilder.append("None");
            }
            localStringBuilder.append("\nWhite balances: ");
            String[] arrayOfString5 = localBundle.getStringArray("white_balances");
            int i6;
            if ((arrayOfString5 != null) && (arrayOfString5.length > 0))
              i6 = 0;
            while (i6 < arrayOfString5.length)
            {
              if (i6 > 0)
                localStringBuilder.append(", ");
              localStringBuilder.append(arrayOfString5[i6]);
              i6++;
              continue;
              localStringBuilder.append("None");
            }
            localStringBuilder.append("\nISOs: ");
            String[] arrayOfString6 = localBundle.getStringArray("isos");
            int i5;
            if ((arrayOfString6 != null) && (arrayOfString6.length > 0))
              i5 = 0;
            while (i5 < arrayOfString6.length)
            {
              if (i5 > 0)
                localStringBuilder.append(", ");
              localStringBuilder.append(arrayOfString6[i5]);
              i5++;
              continue;
              localStringBuilder.append("None");
            }
            String str2 = localBundle.getString("iso_key");
            if (str2 != null)
              localStringBuilder.append("\nISO key: " + str2);
            localStringBuilder.append("\nUsing SAF?: " + localSharedPreferences.getBoolean(com.viber.voip.camera.d.a.t(), false));
            String str3 = localSharedPreferences.getString(com.viber.voip.camera.d.a.u(), "ViberCamera");
            localStringBuilder.append("\nSave Location: " + str3);
            String str4 = localSharedPreferences.getString(com.viber.voip.camera.d.a.v(), "");
            localStringBuilder.append("\nSave Location SAF: " + str4);
            localStringBuilder.append("\nParameters: ");
            String str5 = localBundle.getString("parameters_string");
            if (str5 != null)
              localStringBuilder.append(str5);
            while (true)
            {
              localBuilder.setMessage(localStringBuilder);
              localBuilder.setPositiveButton(R.string.about_ok, null);
              localBuilder.setNegativeButton(R.string.about_copy_to_clipboard, new DialogInterface.OnClickListener()
              {
                public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  ((ClipboardManager)ViberCcamInternalPreferences.this.getActivity().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Camera About", localStringBuilder));
                }
              });
              localBuilder.show();
              return false;
              localStringBuilder.append("None");
            }
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException)
          {
            break label93;
          }
        }
      });
      final Preference localPreference9 = findPreference("preference_reset");
      localPreference9.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
      {
        public boolean onPreferenceClick(Preference paramAnonymousPreference)
        {
          if (localPreference9.getKey().equals("preference_reset"))
            new AlertDialog.Builder(ViberCcamInternalPreferences.this.getActivity()).setIcon(17301543).setTitle(R.string.preference_reset).setMessage(R.string.preference_reset_question).setPositiveButton(R.string.answer_yes, new DialogInterface.OnClickListener()
            {
              public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                SharedPreferences.Editor localEditor = ViberCcamInternalPreferences.5.this.b.edit();
                localEditor.clear();
                localEditor.putBoolean(com.viber.voip.camera.d.a.a(), true);
                localEditor.apply();
                Intent localIntent = ViberCcamInternalPreferences.this.getActivity().getBaseContext().getPackageManager().getLaunchIntentForPackage(ViberCcamInternalPreferences.this.getActivity().getBaseContext().getPackageName());
                localIntent.addFlags(67108864);
                ViberCcamInternalPreferences.this.startActivity(localIntent);
              }
            }).setNegativeButton(R.string.answer_no, null).show();
          return false;
        }
      });
      return;
      Preference localPreference2 = findPreference("preference_video_quality");
      ((PreferenceGroup)findPreference("preference_screen_video_settings")).removePreference(localPreference2);
      break;
      label1042: Preference localPreference6 = findPreference("preference_use_camera2");
      ((PreferenceGroup)findPreference("preference_category_online")).removePreference(localPreference6);
      break label870;
      label1069: final Preference localPreference7 = findPreference("preference_using_saf");
      localPreference7.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
      {
        public boolean onPreferenceClick(Preference paramAnonymousPreference)
        {
          if ((localPreference7.getKey().equals("preference_using_saf")) && (localSharedPreferences.getBoolean(com.viber.voip.camera.d.a.t(), false)))
          {
            Toast.makeText(ViberCcamInternalPreferences.this.a(), R.string.saf_select_save_location, 0).show();
            ViberCcamActivity.a(ViberCcamInternalPreferences.this.a());
          }
          return false;
        }
      });
    }
  }

  public void onPause()
  {
    super.onPause();
  }

  public void onResume()
  {
    super.onResume();
    TypedArray localTypedArray = getActivity().getTheme().obtainStyledAttributes(new int[] { 16842801 });
    int i = localTypedArray.getColor(0, -16777216);
    if (getView() != null)
      getView().setBackgroundColor(i);
    localTypedArray.recycle();
    com.viber.voip.camera.d.a.a(getActivity()).registerOnSharedPreferenceChangeListener(this);
  }

  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    Preference localPreference = findPreference(paramString);
    if ((localPreference instanceof CheckBoxPreference))
      ((CheckBoxPreference)localPreference).setChecked(paramSharedPreferences.getBoolean(paramString, true));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camera.fragment.ViberCcamInternalPreferences
 * JD-Core Version:    0.6.2
 */