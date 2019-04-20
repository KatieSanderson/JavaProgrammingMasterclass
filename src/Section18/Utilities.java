package Section18;

public class Utilities {

    public char[] everyNthChar(char[] arr, int n) {
        if (arr == null || arr.length < n) {
            return arr;
        }
        int returnedLength = arr.length / n;
        char[] result = new char[returnedLength];
        int index = 0;
        for (int i = n - 1; i < arr.length; i += n) {
            result[index] = arr[i];
            index++;
        }
        return result;
    }

    public String removePairs(String str) {
        StringBuilder sb = new StringBuilder();
        if (str == null || str.length() < 2) {
            return str;
        }
        char[] arr = str.toCharArray();
        for (int i = 0; i < str.length() - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                sb.append(arr[i]);
            }
        }
        sb.append(arr[str.length() - 1]);
        return sb.toString();
    }

    public int converter(int a, int b) {
        return (a / b) + (a * 30) - 2;
    }

    public String nullIfOddLength(String src) {
        if (src.length() % 2 == 0) {
            return src;
        }
        return null;
    }
}
