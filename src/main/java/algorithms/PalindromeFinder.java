package algorithms;

public class PalindromeFinder {
    private final String originalText;

    public PalindromeFinder(String originalText) {
        if (originalText == null) {
            throw new IllegalArgumentException("PalindromeFinder does not accept null values.");
        }
        this.originalText = originalText;
    }

    public String findLongest() {
        String result = "";
        for (int i = 0; i < originalText.length(); i++) {
            for (int j = i + result.length(); j < originalText.length(); j++) {
                String substring = originalText.substring(i, j + 1);
                String reversed = new StringBuilder(substring).reverse().toString();
                if (substring.equals(reversed)) {
                    result = substring;
                }
            }
        }
        return result;

    }
}
