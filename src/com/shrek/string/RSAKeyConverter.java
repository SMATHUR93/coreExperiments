package com.shrek.string;

import java.nio.charset.Charset;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

public class RSAKeyConverter {

    /*
    private static final String HASH_ALGORITHM = "SHA-256";
    private static final int NONCE_LENGTH = 16;
    private static final String ALPHA_NUMERIC_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    static String getNonce() {
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(NONCE_LENGTH);
        for (int i = 0; i < NONCE_LENGTH; i++) {
            sb.append(ALPHA_NUMERIC_CHARS.charAt(rnd.nextInt(ALPHA_NUMERIC_CHARS.length())));
        }
        return sb.toString();
    }

    static String getBodyHash(String payload, Charset charset, String hashAlg) {
        MessageDigest digest;

        try {
            digest = MessageDigest.getInstance(hashAlg);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("Unable to obtain " + hashAlg + " message digest", e);
        }

        digest.reset();
        // "If the request does not have an entity body, the hash should be taken over the empty string"
        byte[] byteArray = null == payload ? "".getBytes() : payload.getBytes(charset);
        byte[] hash = digest.digest(byteArray);

        return Util.b64Encode(hash);
    }*/


    public static PrivateKey getPrivateKeyFromString(String key) throws Exception {
        // Remove the "BEGIN" and "END" markers, and any line breaks or whitespace
        String privateKeyPEM = key
                .replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s", "");

        // Decode the Base64 encoded key
        byte[] encoded = Base64.getDecoder().decode(privateKeyPEM);

        // Create a PKCS8EncodedKeySpec with the encoded key
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);

        // Generate the private key from KeyFactory
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }

    public static void main(String[] args) throws IOException, InterruptedException {

/*

        "OAuth " +
                "oauth_consumer_key=\"EiD-Tfdkq7jIpGoqvkxOvvuUXjtiVD8FgljT1QBr7ae05dc2%218be2e95ff4704a04a45c6267cf9f365a0000000000000000\"," +
                "oauth_signature_method=\"RSA-SHA256\"," +
                "oauth_timestamp=\"1730955107\"," +
                "oauth_nonce=\"p37iuDon3uR\"," +
                "oauth_version=\"1.0\"," +
                "oauth_body_hash=\"vq6tMZj32h5w0Dq5aXZeCCGyT8kTaX6SnnJq6uvw66M%3D\"," +
                "oauth_signature=\"H33qdiiOyD0XiN6OPNsowbd1lq1rDMXgkLGUvrkrygwxxN8DhQUWwVn6o0vCmP3VgjswYDd7xwN6VbWpfmyOiVlwrfT0rKilWjpI%2BDAlaqRRDkIQrHfccxZeGPGNG1fT%2BecIaU2FeSzC9VgaK381Uq2QI6kzWITo2ZKewUNzp5Lf6aNwUOrZe3xg48Cf4eB1vlSZQZc0VVc9%2BLk8YN4B8PsekSy5xdjqCfKP1vj6dy79xs55sbBIp0df7eHI64tJ98ZnbY%2BaZtSKiErpA93D%2BH0E6ESa%2FFPbpoa%2BohBJZqXfu1Vy%2Be%2BhI1yHKILqd7p55bkXbfD8Z%2FmSqy1Is2H3GQ%3D%3D\"")



        OAuth
        oauth_body_hash="47DEQpj8HBSa%2B%2FTImW%2B5JCeuQeRkm5NMpJWZG3hSuFU%3D",
        oauth_nonce="132649",
        oauth_signature="A0m%2F8X95qedqsSq8KCZr%2BjX5E%2FriEgJgzhzi4rDHmfABj3VKYVKLC9nX1cjxPzpqN0vRc8KjEu2bW1DCGQIWfQK9NB3sAJ9MX0JS0fvvQo4RQMmMo04Kjpml3uesEuuoxLRlV2YywlTnyo6MS4zb1dENw4AZA6F6lJN9ZAfuPbOr89yZ7EuHjXmpeLgJ2ZPgvEmsDwRdPqUV96Uva4%2BNbLgFJxYxfn7LTD0Pj3Bsu9P6NOhvotJxU2vs2kxHj%2FOAR43w4pdFDG1ZRfZRBNQcP3KlwCXrHIJJJ%2FjA0Vc7RksiruOgJ2tW0Wb0WZh65iy%2FgHDHc58aM2HR9YZW6pCEfw%3D%3D",
        oauth_consumer_key="EiD-Tfdkq7jIpGoqvkxOvvuUXjtiVD8FgljT1QBr7ae05dc2%218be2e95ff4704a04a45c6267cf9f365a0000000000000000",
        oauth_timestamp="1731043529",
        oauth_version="1.0",
        oauth_signature_method="RSA-SHA256"


*/

        String str = "OAuth oauth_consumer_key=\"EiD-Tfdkq7jIpGoqvkxOvvuUXjtiVD8FgljT1QBr7ae05dc2%218be2e95ff4704a04a45c6267cf9f365a0000000000000000\",oauth_signature_method=\"RSA-SHA256\",oauth_timestamp=\"1730978263\",oauth_nonce=\"n43Sf06wvAc\",oauth_version=\"1.0\",oauth_body_hash=\"47DEQpj8HBSa%2B%2FTImW%2B5JCeuQeRkm5NMpJWZG3hSuFU%3D\",oauth_signature=\"lt7%2F0OxQfhLe%2Fjd6pawSpKHOaIsrG17qq7X36MCcEA%2BygTFbWaBWkHzQ2Mme1o4xRdcbrhtz0VDw2bFA1%2F%2F9iOV8ZX9PBr2hFr9RWOf8d0%2FUoYUFgMA8Pc8nYTF9Gtyd8WLctKfnMglSFafYZEnwQ%2F66KWkhs42Dw6HCiMQBos979y66eJzMyHBpKiFNJrZVMPcq8aKWlVCh7Wa7z3K%2FRiTYBhwXNVs5KMBT61GgKmJv0eRFWn6iJ3ROEZAugvou7wl4SiytTdTBaQkf9p2YFTlVEYkLDkloIsc5VLzKtUav2jpv4JV1HoFSo7x4oeFsL2Ex5UEzUoZoE6hcFwoSrw%3D%3D\"";

        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://mtf.apiedge.mastercard.com/commercial/virtual-card-accounts/0ENT71a09853b8819c4ad90473cafe301f6bfa4deebc18d22f572373a40ec18d6a121730959151?unmasked_account_number=true"))
                .GET()
                .setHeader("Accept", "application/json")
                .setHeader("Authorization", str)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());



        String key = "-----BEGIN PRIVATE KEY-----\n" +
                "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCmWJ58QQKvRw7Q\n" +
                "dbVl4NCiliO7VUBATZSXX+Ly1O/Ua5XxsK8JsIJjn1VuBB5WFEn7+IBrrSs+/7uw\n" +
                "y8+vq66qiXJ7wQcPerKhCL6ka2hPIDtf+QQMzbw+7WFxr2LvfWhBDkzpxtiqRTBX\n" +
                "hN5qkLqSHSbK9jSMvpkxD62j/ps+Qymd3DdvOu5cJDZOw3flBBHqz3VCak8hD6AB\n" +
                "ABSGFLcoqI6CkP6t8X1uGnqKtGns7PiF4O7a6ZtFMVuQjU1kIJTZRCiOBZ6s055o\n" +
                "/VZXrjNnWnGQU/5V+YWPjnBhP40BYJvkDaorw6F6Uh4QLdquNyxM+ctB1D5WNRMz\n" +
                "XRxs9z2lAgMBAAECggEAPmtijR2X9E2lsXN57hC+OUQ9hD4pLffumh7Q+m4M0JjO\n" +
                "WzMBe5FQXDGdzPqep45VdMd66OzCHZG4zE6uUC0MDdIls2prS9Ou096EKw5ixc5C\n" +
                "eXDnpCZPTQ2mUxKM/XEBfefv1IlZJAtyaGTjUPmeCNYHiIF6lpWuxkorzi3r8yCE\n" +
                "L5Ob8jp2f/A2jat5a1fJKctgpJzQpuc7vwMlfgQN02xtC/l7VYzxEKHKfGRvQaRR\n" +
                "z/LP35l2OlgU9hjTEf5Rc/BUAduDcypVAyerpw7Gd5A5L+f5aIi245ei9OmH15ds\n" +
                "iMis29W5sjhuMDZ4o4IhY4CtbOB4GhZdnQ/3Ou76wQKBgQDuccuvaOuCeVQgfNBz\n" +
                "jx2/2L/3z3+9dV//d0i9bQ5gpje3BmxsdSDUnDPDA5geoj5CX1Z371+fKx7R0EmT\n" +
                "qJbpmBpofkcRo7EEGvjJYYXLL6Pt0Stj+lF2q7ozTmHiPUwULF8WcJbdZvLqAs68\n" +
                "RZDSt/WiaYvbb8ajiQOyR9uvBwKBgQCyl+nFFzuCmJ/h4ECPLJSo/1vU5F5wUf7h\n" +
                "mOJukgNiFzy0QPJcbwbjeUM1IbATmRgbX59JQg1Wq37O5EOhTW2mu+Xg2cjSgRSG\n" +
                "1/Zn1RIdM1AS0aJtNyh7BlJr6ZiURNZcaQMhQjoIcsmhOXYC/UYx4fHUF5jIOWSy\n" +
                "FiM9D46W8wKBgQCz3hmVN2M4qAeC/kRMd7AsUPf2mos0wr7oufWgFw0acShkIy9U\n" +
                "3UInv7D4MdTlfuPSM5LJpEOQkPmNsj5eaXV1vqxlGKTJtJ5Kh4IWfz9rF4PkWL4P\n" +
                "i/s5tq8eFsmV3UFvkk0kY0gauZcSWY3TzfJCUkyz+ERtArNoF2o3aSdZrwKBgEAq\n" +
                "KEkxcaYYI8lJgqhuAfM928Z/ThbYvtRa02+acjC53It+khT3pufvV2AtfE9uP6UG\n" +
                "E/qECrrK3sKCbHH1maG//HVuiaJn0fIogVUIzntDRk+cldjbamXY/Z/by3/pw4Js\n" +
                "ED3Qx3zlkN+l/2pPiPq/DN2ApNm7FRyOq5Zykm5VAoGAA0lfLWWrBjITD6mCCM24\n" +
                "lF4Q28QxxHU2ajchI1i76T+h5WeBSWaBv0aJzfmWPR5cQP6UcoZDkLFrREqycPCS\n" +
                "jM8pkcMp8oEMRGNslTJkpPloooXmdRLIEBOKSPF80SuY6burv1W2dAC13Q+8X9+G\n" +
                "mSXTYGpbJHBb/07BKRvhMP8=\n" +
                "-----END PRIVATE KEY-----\n";

        try {
            PrivateKey privateKey = getPrivateKeyFromString(key);
            System.out.println("Private Key: " + privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
