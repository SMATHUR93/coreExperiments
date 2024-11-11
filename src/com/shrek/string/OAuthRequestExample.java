package com.shrek.string;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.time.Instant;
import java.util.Base64;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class OAuthRequestExample {

    private static final String CONSUMER_KEY = "EiD-Tfdkq7jIpGoqvkxOvvuUXjtiVD8FgljT1QBr7ae05dc2!8be2e95ff4704a04a45c6267cf9f365a0000000000000000";
    private static final String CONSUMER_SECRET = "-----BEGIN PRIVATE KEY-----\n" +
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
    private static final String OAUTH_SIGNATURE_METHOD = "RSA-SHA256";
    private static final String OAUTH_VERSION = "1.0";

    public static void main(String[] args) throws Exception {
        // Define request details
        String url = "https://mtf.apiedge.mastercard.com/commercial/virtual-card-accounts";
        String body = "{\n    \"expiry\": \"2024-12\",\n    \"fundingSourceGuid\": \"0ENT14b4de616523a73622ebb0649363dde142549c6c1de3e1f441ce0d3c04e2b1101728027776\",\n    \"unmaskedAccountNumber\": true\n}";

        // Generate OAuth 1.0a headers
        String authorizationHeader = generateAuthorizationHeader(url, "POST", body);

        // Build and send HTTP request
        HttpClient client = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.NORMAL).build();
        // Generate OAuth 1.0a headers
        HttpRequest request1 = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(BodyPublishers.ofString(body))
                .setHeader("Content-Type", "application/json")
                .setHeader("Accept", "application/json")
                .setHeader("Authorization", authorizationHeader)
                .build();

        HttpResponse<String> response1 = client.send(request1, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response 1: " + response1.body());

    }

    private static String generateAuthorizationHeader(String url, String method, String body) throws Exception {
        // OAuth parameters
        String nonce = generateNonce();
        String timestamp = String.valueOf(Instant.now().getEpochSecond());

        String bodyHash = generateBodyHash(body);
        Map<String, String> oauthParams = Map.of(
                "oauth_body_hash", bodyHash,
                "oauth_consumer_key", CONSUMER_KEY,
                "oauth_nonce", nonce,
                "oauth_timestamp", timestamp,
                "oauth_signature_method", OAUTH_SIGNATURE_METHOD,
                "oauth_version", OAUTH_VERSION
        );

        // Generate signature
        String baseString = generateSignatureBaseString(url, method, oauthParams);
        /*String signingKey = URLEncoder.encode(CONSUMER_SECRET, StandardCharsets.UTF_8) + "&";
        String signature = calculateSignature(baseString, signingKey);*/
        String signature = calculateSignature(baseString);

        // Add signature to OAuth parameters
        oauthParams = new java.util.HashMap<>(oauthParams);
        oauthParams.put("oauth_signature", signature);

        // Build Authorization header
        return "OAuth " + oauthParams.entrySet().stream()
                .map(entry -> entry.getKey() + "=\"" + URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8) + "\"")
                .collect(Collectors.joining(", "));
    }

    private static String generateNonce() {
        int nonce = new Random().nextInt(1_000_000);
        return Integer.toString(nonce);
    }

    private static String generateBodyHash(String body) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(body.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hashBytes);
    }

    private static String generateSignatureBaseString(String url, String method, Map<String, String> oauthParams) {
        String encodedParams = oauthParams.entrySet().stream()
                .map(entry -> URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8) + "=" +
                        URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8))
                .sorted()
                .collect(Collectors.joining("&"));

        return method.toUpperCase() + "&" +
                URLEncoder.encode(url, StandardCharsets.UTF_8) + "&" +
                URLEncoder.encode(encodedParams, StandardCharsets.UTF_8);
    }

    /*private static String calculateSignature(String baseString, String key) throws Exception {
        Mac mac = Mac.getInstance("RSA-SHA256");
        Key secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "RSA-SHA256");
        mac.init(secretKey);
        byte[] rawHmac = mac.doFinal(baseString.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(rawHmac);
    }*/

    public static String calculateSignature(String baseString) throws Exception {
        // Load the private key from the PEM-formatted string
        PrivateKey privateKey = loadPrivateKey(CONSUMER_SECRET);

        // Sign the base string with SHA256withRSA
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(baseString.getBytes());

        // Perform signing and encode result in Base64
        byte[] signedBytes = signature.sign();
        return Base64.getEncoder().encodeToString(signedBytes);
    }

    private static PrivateKey loadPrivateKey(String key) throws Exception {
        // Remove the PEM header, footer, and line breaks
        String privateKeyPEM = key
                .replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s+", "");

        // Decode the Base64-encoded string to get the key bytes
        byte[] keyBytes = Base64.getDecoder().decode(privateKeyPEM);

        // Generate private key from the key bytes
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }

}
