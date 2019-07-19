package android.support.v4.app;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.support.v4.graphics.drawable.IconCompat;

public class Person
{
  private static final String ICON_KEY = "icon";
  private static final String IS_BOT_KEY = "isBot";
  private static final String IS_IMPORTANT_KEY = "isImportant";
  private static final String KEY_KEY = "key";
  private static final String NAME_KEY = "name";
  private static final String URI_KEY = "uri";
  IconCompat mIcon;
  boolean mIsBot;
  boolean mIsImportant;
  String mKey;
  CharSequence mName;
  String mUri;

  Person(Builder paramBuilder)
  {
    this.mName = paramBuilder.mName;
    this.mIcon = paramBuilder.mIcon;
    this.mUri = paramBuilder.mUri;
    this.mKey = paramBuilder.mKey;
    this.mIsBot = paramBuilder.mIsBot;
    this.mIsImportant = paramBuilder.mIsImportant;
  }

  public static Person fromAndroidPerson(android.app.Person paramPerson)
  {
    Builder localBuilder = new Builder().setName(paramPerson.getName());
    if (paramPerson.getIcon() != null);
    for (IconCompat localIconCompat = IconCompat.createFromIcon(paramPerson.getIcon()); ; localIconCompat = null)
      return localBuilder.setIcon(localIconCompat).setUri(paramPerson.getUri()).setKey(paramPerson.getKey()).setBot(paramPerson.isBot()).setImportant(paramPerson.isImportant()).build();
  }

  public static Person fromBundle(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle.getBundle("icon");
    Builder localBuilder = new Builder().setName(paramBundle.getCharSequence("name"));
    if (localBundle != null);
    for (IconCompat localIconCompat = IconCompat.createFromBundle(localBundle); ; localIconCompat = null)
      return localBuilder.setIcon(localIconCompat).setUri(paramBundle.getString("uri")).setKey(paramBundle.getString("key")).setBot(paramBundle.getBoolean("isBot")).setImportant(paramBundle.getBoolean("isImportant")).build();
  }

  public IconCompat getIcon()
  {
    return this.mIcon;
  }

  public String getKey()
  {
    return this.mKey;
  }

  public CharSequence getName()
  {
    return this.mName;
  }

  public String getUri()
  {
    return this.mUri;
  }

  public boolean isBot()
  {
    return this.mIsBot;
  }

  public boolean isImportant()
  {
    return this.mIsImportant;
  }

  public android.app.Person toAndroidPerson()
  {
    android.app.Person.Builder localBuilder = new android.app.Person.Builder().setName(getName());
    if (getIcon() != null);
    for (Icon localIcon = getIcon().toIcon(); ; localIcon = null)
      return localBuilder.setIcon(localIcon).setUri(getUri()).setKey(getKey()).setBot(isBot()).setImportant(isImportant()).build();
  }

  public Builder toBuilder()
  {
    return new Builder(this);
  }

  public Bundle toBundle()
  {
    Bundle localBundle1 = new Bundle();
    localBundle1.putCharSequence("name", this.mName);
    if (this.mIcon != null);
    for (Bundle localBundle2 = this.mIcon.toBundle(); ; localBundle2 = null)
    {
      localBundle1.putBundle("icon", localBundle2);
      localBundle1.putString("uri", this.mUri);
      localBundle1.putString("key", this.mKey);
      localBundle1.putBoolean("isBot", this.mIsBot);
      localBundle1.putBoolean("isImportant", this.mIsImportant);
      return localBundle1;
    }
  }

  public static class Builder
  {
    IconCompat mIcon;
    boolean mIsBot;
    boolean mIsImportant;
    String mKey;
    CharSequence mName;
    String mUri;

    public Builder()
    {
    }

    Builder(Person paramPerson)
    {
      this.mName = paramPerson.mName;
      this.mIcon = paramPerson.mIcon;
      this.mUri = paramPerson.mUri;
      this.mKey = paramPerson.mKey;
      this.mIsBot = paramPerson.mIsBot;
      this.mIsImportant = paramPerson.mIsImportant;
    }

    public Person build()
    {
      return new Person(this);
    }

    public Builder setBot(boolean paramBoolean)
    {
      this.mIsBot = paramBoolean;
      return this;
    }

    public Builder setIcon(IconCompat paramIconCompat)
    {
      this.mIcon = paramIconCompat;
      return this;
    }

    public Builder setImportant(boolean paramBoolean)
    {
      this.mIsImportant = paramBoolean;
      return this;
    }

    public Builder setKey(String paramString)
    {
      this.mKey = paramString;
      return this;
    }

    public Builder setName(CharSequence paramCharSequence)
    {
      this.mName = paramCharSequence;
      return this;
    }

    public Builder setUri(String paramString)
    {
      this.mUri = paramString;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.app.Person
 * JD-Core Version:    0.6.2
 */