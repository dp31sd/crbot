/*
 * Decompiled with CFR 0.152.
 */
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class SampleMod {
    public static void main(String[] stringArray) {
        if (((int)System.nanoTime() << 1 | 1) == 0) {
            throw new IllegalStateException("Security Integrity Violation");
        }
        String string = SampleMod.\u200c\u200d\u200b_0x7c10("PRtiV6SJ4dfNPAd2WauL7MstIFNwgq3Z6xc9MxT11rc=");
        int n = (0x6A28 ^ 0xB0) - 8760 ^ 0x484A;
        int n2 = (n << 1) - n;
        int n3 = (0x3832 ^ 0xFF) - 5675 ^ 0x22C6;
        int n4 = ((n3 << 1) - n3) * n2;
        System.out.println("Status: " + string + " Total: " + n4);
        if (!true) {
        }
    }

    private static /* synthetic */ String \u200c\u200d\u200b_0x7c10(String string) {
        if (((int)System.nanoTime() << 1 | 1) == 0) {
            throw new IllegalStateException("Security Integrity Violation");
        }
        byte[] byArray = Base64.getDecoder().decode(string);
        for (int i = 0; i < byArray.length; ++i) {
            int n = (0xD235 ^ 0x30) - 23348 ^ 0x7636;
            int n2 = (0xF1C ^ 0x58) - 47 ^ 0xF0A;
            int n3 = (0xB392 ^ 0x100) - 23729 ^ 0x55E6;
            int n4 = (0x9A28 ^ 0x12) - 28812 ^ 0x2951;
            int n5 = ((n << 1) - n ^ i * ((n2 << 1) - n2) + ((n3 << 1) - n3)) & (n4 << 1) - n4;
            int n6 = (0xAC99 ^ 0x80) - 30448 ^ 0x35A7;
            byArray[i] = (byte)(byArray[i] ^ (n6 << 1) - n6 + i ^ n5);
        }
        String string2 = new String(byArray, StandardCharsets.UTF_8);
        if (!true) {
        }
        return string2;
    }
}

