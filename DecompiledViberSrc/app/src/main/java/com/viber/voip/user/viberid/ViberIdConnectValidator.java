package com.viber.voip.user.viberid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViberIdConnectValidator
{
  private static final Pattern CREATE_PASSWORD_PATTERN = Pattern.compile("^(?=.{8,128}$)(?!.*(<[^>]*>))[\\p{ASCII}&&[^\\u0020]]+$");
  private static final int EMAIL_MAX_CHARACTERS = 128;
  private static final Pattern EMAIL_PATTERN = Pattern.compile("^(?=.{1,128}$)(?!.*(<[^>]*>))([\\u0021-\\u007e&&[^@]]{1,256}@[\\u0021-\\u007e&&[^@\\(\\)<>,;:\\\\\"\\[\\]\\*\\|]]{0,64}(\\.[a-zA-Z0-9][\\u0021-\\u007e&&[^@\\(\\)<>,;:\\\\\"\\[\\]\\*\\|]]{0,25})+)$");
  private static final Pattern ENTER_PASSWORD_PATTERN = Pattern.compile("^(?=.{6,128}$)(?!.*(<[^>]*>))[\\p{ASCII}&&[^\\u0020]]+$");

  public static boolean isValidEmail(String paramString)
  {
    return EMAIL_PATTERN.matcher(paramString).matches();
  }

  public static int isValidPassword(String paramString1, String paramString2, String paramString3, PasswordValidationStrategy paramPasswordValidationStrategy)
  {
    if (!paramPasswordValidationStrategy.getValidationPattern().matcher(paramString2).matches())
      return 1;
    if (paramString2.equals(paramString1))
      return 2;
    if (!paramString2.equals(paramString3))
      return 3;
    return 0;
  }

  public static enum PasswordValidationStrategy
  {
    private int mMinPasswordLength;
    private Pattern mValidationPattern;

    static
    {
      PasswordValidationStrategy[] arrayOfPasswordValidationStrategy = new PasswordValidationStrategy[2];
      arrayOfPasswordValidationStrategy[0] = CREATE;
      arrayOfPasswordValidationStrategy[1] = ENTER;
    }

    private PasswordValidationStrategy(int paramInt, Pattern paramPattern)
    {
      this.mMinPasswordLength = paramInt;
      this.mValidationPattern = paramPattern;
    }

    public int getMinPasswordLength()
    {
      return this.mMinPasswordLength;
    }

    public Pattern getValidationPattern()
    {
      return this.mValidationPattern;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.ViberIdConnectValidator
 * JD-Core Version:    0.6.2
 */