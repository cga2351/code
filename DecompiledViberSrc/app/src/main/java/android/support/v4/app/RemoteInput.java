package android.support.v4.app;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class RemoteInput
{
  private static final String EXTRA_DATA_TYPE_RESULTS_DATA = "android.remoteinput.dataTypeResultsData";
  public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
  public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
  private static final String TAG = "RemoteInput";
  private final boolean mAllowFreeFormTextInput;
  private final Set<String> mAllowedDataTypes;
  private final CharSequence[] mChoices;
  private final Bundle mExtras;
  private final CharSequence mLabel;
  private final String mResultKey;

  RemoteInput(String paramString, CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence, boolean paramBoolean, Bundle paramBundle, Set<String> paramSet)
  {
    this.mResultKey = paramString;
    this.mLabel = paramCharSequence;
    this.mChoices = paramArrayOfCharSequence;
    this.mAllowFreeFormTextInput = paramBoolean;
    this.mExtras = paramBundle;
    this.mAllowedDataTypes = paramSet;
  }

  public static void addDataResultToIntent(RemoteInput paramRemoteInput, Intent paramIntent, Map<String, Uri> paramMap)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      android.app.RemoteInput.addDataResultToIntent(fromCompat(paramRemoteInput), paramIntent, paramMap);
      return;
    }
    Intent localIntent1;
    if (Build.VERSION.SDK_INT >= 16)
    {
      localIntent1 = getClipDataIntentFromIntent(paramIntent);
      if (localIntent1 != null)
        break label187;
    }
    label187: for (Intent localIntent2 = new Intent(); ; localIntent2 = localIntent1)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str = (String)localEntry.getKey();
        Uri localUri = (Uri)localEntry.getValue();
        if (str != null)
        {
          Bundle localBundle = localIntent2.getBundleExtra(getExtraResultsKeyForData(str));
          if (localBundle == null)
            localBundle = new Bundle();
          localBundle.putString(paramRemoteInput.getResultKey(), localUri.toString());
          localIntent2.putExtra(getExtraResultsKeyForData(str), localBundle);
        }
      }
      paramIntent.setClipData(ClipData.newIntent("android.remoteinput.results", localIntent2));
      return;
      Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
      return;
    }
  }

  public static void addResultsToIntent(RemoteInput[] paramArrayOfRemoteInput, Intent paramIntent, Bundle paramBundle)
  {
    int i = 0;
    if (Build.VERSION.SDK_INT >= 26)
    {
      android.app.RemoteInput.addResultsToIntent(fromCompat(paramArrayOfRemoteInput), paramIntent, paramBundle);
      return;
    }
    if (Build.VERSION.SDK_INT >= 20)
    {
      Bundle localBundle3 = getResultsFromIntent(paramIntent);
      if (localBundle3 == null);
      while (true)
      {
        int k = paramArrayOfRemoteInput.length;
        for (int m = 0; m < k; m++)
        {
          RemoteInput localRemoteInput2 = paramArrayOfRemoteInput[m];
          Map localMap = getDataResultsFromIntent(paramIntent, localRemoteInput2.getResultKey());
          android.app.RemoteInput.addResultsToIntent(fromCompat(new RemoteInput[] { localRemoteInput2 }), paramIntent, paramBundle);
          if (localMap != null)
            addDataResultToIntent(localRemoteInput2, paramIntent, localMap);
        }
        break;
        localBundle3.putAll(paramBundle);
        paramBundle = localBundle3;
      }
    }
    Intent localIntent1;
    if (Build.VERSION.SDK_INT >= 16)
    {
      localIntent1 = getClipDataIntentFromIntent(paramIntent);
      if (localIntent1 != null)
        break label262;
    }
    label262: for (Intent localIntent2 = new Intent(); ; localIntent2 = localIntent1)
    {
      Bundle localBundle1 = localIntent2.getBundleExtra("android.remoteinput.resultsData");
      if (localBundle1 == null);
      for (Bundle localBundle2 = new Bundle(); ; localBundle2 = localBundle1)
      {
        int j = paramArrayOfRemoteInput.length;
        while (i < j)
        {
          RemoteInput localRemoteInput1 = paramArrayOfRemoteInput[i];
          Object localObject = paramBundle.get(localRemoteInput1.getResultKey());
          if ((localObject instanceof CharSequence))
            localBundle2.putCharSequence(localRemoteInput1.getResultKey(), (CharSequence)localObject);
          i++;
        }
        localIntent2.putExtra("android.remoteinput.resultsData", localBundle2);
        paramIntent.setClipData(ClipData.newIntent("android.remoteinput.results", localIntent2));
        return;
        Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
        return;
      }
    }
  }

  static android.app.RemoteInput fromCompat(RemoteInput paramRemoteInput)
  {
    return new android.app.RemoteInput.Builder(paramRemoteInput.getResultKey()).setLabel(paramRemoteInput.getLabel()).setChoices(paramRemoteInput.getChoices()).setAllowFreeFormInput(paramRemoteInput.getAllowFreeFormInput()).addExtras(paramRemoteInput.getExtras()).build();
  }

  static android.app.RemoteInput[] fromCompat(RemoteInput[] paramArrayOfRemoteInput)
  {
    if (paramArrayOfRemoteInput == null)
      return null;
    android.app.RemoteInput[] arrayOfRemoteInput = new android.app.RemoteInput[paramArrayOfRemoteInput.length];
    for (int i = 0; i < paramArrayOfRemoteInput.length; i++)
      arrayOfRemoteInput[i] = fromCompat(paramArrayOfRemoteInput[i]);
    return arrayOfRemoteInput;
  }

  private static Intent getClipDataIntentFromIntent(Intent paramIntent)
  {
    ClipData localClipData = paramIntent.getClipData();
    if (localClipData == null);
    ClipDescription localClipDescription;
    do
    {
      return null;
      localClipDescription = localClipData.getDescription();
    }
    while ((!localClipDescription.hasMimeType("text/vnd.android.intent")) || (!localClipDescription.getLabel().equals("android.remoteinput.results")));
    return localClipData.getItemAt(0).getIntent();
  }

  public static Map<String, Uri> getDataResultsFromIntent(Intent paramIntent, String paramString)
  {
    Map localMap;
    if (Build.VERSION.SDK_INT >= 26)
      localMap = android.app.RemoteInput.getDataResultsFromIntent(paramIntent, paramString);
    Intent localIntent;
    do
    {
      return localMap;
      if (Build.VERSION.SDK_INT < 16)
        break;
      localIntent = getClipDataIntentFromIntent(paramIntent);
      localMap = null;
    }
    while (localIntent == null);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = localIntent.getExtras().keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (str1.startsWith("android.remoteinput.dataTypeResultsData"))
      {
        String str2 = str1.substring("android.remoteinput.dataTypeResultsData".length());
        if (!str2.isEmpty())
        {
          String str3 = localIntent.getBundleExtra(str1).getString(paramString);
          if ((str3 != null) && (!str3.isEmpty()))
            localHashMap.put(str2, Uri.parse(str3));
        }
      }
    }
    if (localHashMap.isEmpty());
    for (Object localObject = null; ; localObject = localHashMap)
      return localObject;
    Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
    return null;
  }

  private static String getExtraResultsKeyForData(String paramString)
  {
    return "android.remoteinput.dataTypeResultsData" + paramString;
  }

  public static Bundle getResultsFromIntent(Intent paramIntent)
  {
    Bundle localBundle;
    if (Build.VERSION.SDK_INT >= 20)
      localBundle = android.app.RemoteInput.getResultsFromIntent(paramIntent);
    Intent localIntent;
    do
    {
      return localBundle;
      if (Build.VERSION.SDK_INT < 16)
        break;
      localIntent = getClipDataIntentFromIntent(paramIntent);
      localBundle = null;
    }
    while (localIntent == null);
    return (Bundle)localIntent.getExtras().getParcelable("android.remoteinput.resultsData");
    Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
    return null;
  }

  public boolean getAllowFreeFormInput()
  {
    return this.mAllowFreeFormTextInput;
  }

  public Set<String> getAllowedDataTypes()
  {
    return this.mAllowedDataTypes;
  }

  public CharSequence[] getChoices()
  {
    return this.mChoices;
  }

  public Bundle getExtras()
  {
    return this.mExtras;
  }

  public CharSequence getLabel()
  {
    return this.mLabel;
  }

  public String getResultKey()
  {
    return this.mResultKey;
  }

  public boolean isDataOnly()
  {
    return (!getAllowFreeFormInput()) && ((getChoices() == null) || (getChoices().length == 0)) && (getAllowedDataTypes() != null) && (!getAllowedDataTypes().isEmpty());
  }

  public static final class Builder
  {
    private boolean mAllowFreeFormTextInput = true;
    private final Set<String> mAllowedDataTypes = new HashSet();
    private CharSequence[] mChoices;
    private final Bundle mExtras = new Bundle();
    private CharSequence mLabel;
    private final String mResultKey;

    public Builder(String paramString)
    {
      if (paramString == null)
        throw new IllegalArgumentException("Result key can't be null");
      this.mResultKey = paramString;
    }

    public Builder addExtras(Bundle paramBundle)
    {
      if (paramBundle != null)
        this.mExtras.putAll(paramBundle);
      return this;
    }

    public RemoteInput build()
    {
      return new RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormTextInput, this.mExtras, this.mAllowedDataTypes);
    }

    public Bundle getExtras()
    {
      return this.mExtras;
    }

    public Builder setAllowDataType(String paramString, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.mAllowedDataTypes.add(paramString);
        return this;
      }
      this.mAllowedDataTypes.remove(paramString);
      return this;
    }

    public Builder setAllowFreeFormInput(boolean paramBoolean)
    {
      this.mAllowFreeFormTextInput = paramBoolean;
      return this;
    }

    public Builder setChoices(CharSequence[] paramArrayOfCharSequence)
    {
      this.mChoices = paramArrayOfCharSequence;
      return this;
    }

    public Builder setLabel(CharSequence paramCharSequence)
    {
      this.mLabel = paramCharSequence;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.app.RemoteInput
 * JD-Core Version:    0.6.2
 */