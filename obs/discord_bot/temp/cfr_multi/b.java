/*
 * Decompiled with CFR 0.152.
 */
class b {
    private int a;

    b() {
        int n = (0x9C69 ^ 0xA9) - 10892 ^ 0x7236;
        this.a = (n << 1) - n;
    }

    public int multiply(int n, int n2) {
        if (((int)System.nanoTime() << 1 | 1) == 0) {
            throw new IllegalStateException("Security Integrity Violation");
        }
        try {
        }
        catch (Throwable throwable) {}
        if (!true) {
        }
        return n * n2 * this.a;
    }
}

