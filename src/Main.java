import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        byte[] s = new byte[]{73, 76, 79, 86, 69, 68, 79, 71, 83};
        AsciiCharSequence sequence = new AsciiCharSequence(s);
        AsciiCharSequence result = sequence.subSequence(5);
        System.out.println(result.toString());
        AsciiCharSequence result1 = sequence.delete(2, 5);
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
            String subSequence = subSequence(0,from - 1) + subSequence(to).toString();
            return new AsciiCharSequence(subSequence.toString().getBytes());
        }
            /* byte[] result = new byte[bytes.length - (to - from + 1)] ;
            int currentIndex = 0;

            for (int i = 0; i < bytes.length; i++) {
                if (i < from - 1 || i > to - 1) {
                    result[currentIndex] = bytes[i];
                    currentIndex++;
                }
            }
            return new AsciiCharSequence(result);
        }*/
    }
}

