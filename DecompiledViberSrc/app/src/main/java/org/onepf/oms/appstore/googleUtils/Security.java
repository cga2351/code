package org.onepf.oms.appstore.googleUtils;

import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class Security
{
  private static final String KEY_FACTORY_ALGORITHM = "RSA";
  private static final Logger L = ViberEnv.getLogger();
  private static final String SIGNATURE_ALGORITHM = "SHA1withRSA";

  public static PublicKey generatePublicKey(String paramString)
  {
    try
    {
      byte[] arrayOfByte = Base64.decode(paramString);
      PublicKey localPublicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(arrayOfByte));
      return localPublicKey;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new RuntimeException(localNoSuchAlgorithmException);
    }
    catch (InvalidKeySpecException localInvalidKeySpecException)
    {
      throw new IllegalArgumentException(localInvalidKeySpecException);
    }
    catch (Base64DecoderException localBase64DecoderException)
    {
      throw new IllegalArgumentException(localBase64DecoderException);
    }
  }

  public static boolean verify(PublicKey paramPublicKey, String paramString1, String paramString2)
  {
    try
    {
      Signature localSignature = Signature.getInstance("SHA1withRSA");
      localSignature.initVerify(paramPublicKey);
      localSignature.update(paramString1.getBytes());
      boolean bool = localSignature.verify(Base64.decode(paramString2));
      return bool;
    }
    catch (Base64DecoderException localBase64DecoderException)
    {
      return false;
    }
    catch (SignatureException localSignatureException)
    {
      return false;
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      return false;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
    }
    return false;
  }

  public static boolean verifyPurchase(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
      return false;
    return verify(generatePublicKey(paramString1), paramString2, paramString3);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.appstore.googleUtils.Security
 * JD-Core Version:    0.6.2
 */