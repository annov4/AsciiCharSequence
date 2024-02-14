import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        byte[] s = new byte[]{73, 76, 79, 86, 69, 68, 79, 71, 83};
        AsciiCharSequence sequence = new AsciiCharSequence(s);
        AsciiCharSequence result = sequence.subSequence(5);
        System.out.println(result.toString());
        AsciiCharSequence result1 = sequence.delete(1, 4);
        System.out.println(result1);
    }

    public static class AsciiCharSequence implements CharSequence {

        private byte[] bytes;

        public AsciiCharSequence(byte[] bytes) {
            this.bytes = bytes.clone();
        }

        @Override
        public int length() {
            return bytes.length;
        }

        @Override
        public char charAt(int index) {
            return (char) this.bytes[index];
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            byte[] subArray = new byte[end - start];
            for (int i = 0; i < subArray.length; i++) {
                subArray[i] = bytes[start + i];
            }
            return new AsciiCharSequence(subArray);
        }

        @Override
        public String toString() {
            return new String(bytes);
        }

        public AsciiCharSequence subSequence(int start) {
            return (AsciiCharSequence) subSequence(start, bytes.length);
        }

        public AsciiCharSequence delete(int from, int to) {
            CharSequence subSequence1 = subSequence(0, from);
            CharSequence subSequence2 = subSequence(to + 1, bytes.length);
            return concat((AsciiCharSequence) subSequence1, (AsciiCharSequence) subSequence2);
        }

        private AsciiCharSequence concat(AsciiCharSequence sequence1, AsciiCharSequence sequence2) {
            byte[] resultBytes = new byte[sequence1.length() + sequence2.length()];
            int i = 0;
            for (byte b : sequence1.bytes) {
                resultBytes[i] = b;
                i++;
            }
            for (byte b : sequence2.bytes) {
                resultBytes[i] = b;
                i++;
            }
            return new AsciiCharSequence(resultBytes);
        }
    }
}

